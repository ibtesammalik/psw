package com.jwt.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.support.oracle.SqlArrayValue;
import org.springframework.data.jdbc.support.oracle.SqlStructArrayValue;
import org.springframework.data.jdbc.support.oracle.SqlStructValue;
import org.springframework.data.jdbc.support.oracle.StructMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnType;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.jwt.dto.request.Mapper;
import com.jwt.dto.request.ObjGd;
import com.jwt.dto.request.ObjW000005;
import com.jwt.dto.request.ObjW000007;
import com.jwt.dto.request.PswRequest;
import com.jwt.dto.request.wse00003.ContainerVehicleInformation;
import com.jwt.dto.request.wse00003.ItemInformation;
import com.jwt.dto.request.wse00003.PackagesInformation;
import com.jwt.dto.request.wse00003.Wse00003Dto;
import com.jwt.dto.request.wse00004.Wse00004Dto;
import com.jwt.dto.request.wseWSE00006Export.WseWSE00006Export;
import com.jwt.dto.request.wseWSE00006Import.WseWSE00006Import;
import com.jwt.dto.response.MsgMap;

import oracle.jdbc.OracleTypes;

@Repository("requestManagementDao")
public class RequestMangementDaoImpl implements RequestManagementDao, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6203148822583737105L;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private DataSource dataSource;

	/*
	 * @Override public StringBuilder addToken(TokenAcquisitionResponse dto, String
	 * code) throws SQLException {
	 * jdbcTemplate.update(Iconstants.latestToken.queryToAddToken, new Object[] {
	 * code, dto.getToken(), new Date(), Long.parseLong(dto.getExpireDate()),
	 * dto.getTokenType(), "AD", "AD" }); return new StringBuilder(dto.getToken());
	 * }
	 */


	
	@Override public Map<String, Object> msg1VerifyIban(PswRequest dto, String
			code, String requestType,ObjGd[] fiUno,String gdno, String gdStatus, ObjW000005 obj5, ObjW000007 obj7) 
	{ 
		
		
		StructMapper<ObjGd> map = new Mapper();
		LocalDateTime to = LocalDateTime.now();
		//	String[] fiUno = new String[]{"", "", "",""};
		SimpleJdbcCall jdbcCall = new
				SimpleJdbcCall(dataSource).withProcedureName("PSW_WSEPROC") ;
		
		jdbcCall.declareParameters(	
				new SqlParameter("P_REQTYPE", Types.VARCHAR),
				new SqlParameter("P_IBAN",	Types.VARCHAR), 
				new SqlParameter("P_EMAIL", Types.VARCHAR), 
				new	SqlParameter("P_MOBILE", Types.VARCHAR),
				new SqlParameter("P_NTN",	Types.VARCHAR), 
				new SqlParameter("P_GDNO", Types.VARCHAR), 
				new	SqlParameter("P_GDSTS", Types.VARCHAR),
				new SqlParameter("P_FI_UNO",	OracleTypes.ARRAY, "COL_FI_UNO"), 
				new SqlParameter("P_WSE00005" ,OracleTypes.STRUCT,"OBJ_WSE00005"), 
				new SqlParameter("P_WSE00007" ,OracleTypes.STRUCT,"OBJ_WSE00007"), 
				new SqlOutParameter("P_WSE00002",	OracleTypes.STRUCT, "OBJ_WSE00002",new SqlReturnType() {

					@Override
					public Object getTypeValue(CallableStatement cs, int paramIndex, int sqlType, String typeName) throws SQLException {
						java.sql.Struct  str=(java.sql.Struct)cs.getObject(paramIndex);
						Object []test = str.getAttributes();
						MsgMap map= new MsgMap();
						map.getData().put("iban", (String)test[0]);
						map.getData().put("accountTitle", (String)test[1]);
						map.getData().put("accountNumber", test[2]);
						map.getData().put("accountStatus", (String)test[3]);
						map.getData().put("ntn", (String)test[4]);

						if(test[5]!=null)
							map.getData().put("cnic", (String)test[5]);
						map.getData().put("authorizedPaymentModesForImport", convertArrayToArrayListString( (Array)test[6]));
						map.getData().put("authorizedPaymentModesForExport", convertArrayToArrayListString( (Array)test[7]));

						return map;
					}
				}),
				new SqlOutParameter("P_WSSTS",	Types.VARCHAR), 
				new SqlOutParameter("P_STS_DESC", Types.VARCHAR), 
				new	SqlOutParameter("P_STS", Types.VARCHAR), 
				new SqlOutParameter("P_STS_DESC",Types.VARCHAR));

		
		SqlParameterSource in = new MapSqlParameterSource().
				addValue("P_REQTYPE",requestType).
				addValue("P_IBAN", dto.getData().get("iban")).
				addValue("P_EMAIL", dto.getData().get("email") ).
				addValue("P_MOBILE",dto.getData().get("mobileNumber")).
				addValue("P_NTN", dto.getData().get("ntn")).
				addValue("P_WSE00005",new SqlStructValue<ObjW000005>(obj5)).
				addValue("P_WSE00007",new SqlStructValue<ObjW000007>(obj7)).
				addValue("P_GDNO",gdno).
				addValue("P_GDSTS", gdStatus).
				addValue("P_FI_UNO", new SqlStructArrayValue<ObjGd>(fiUno, map, "OBJ_GD_FI_MOP"));

		Map<String, Object> out = jdbcCall.execute(in); 

		//	out.put("P_WSSTS","200");
		return out; 
	}


	@Override
	public boolean insertWSE00003Records(Wse00003Dto wse00003Dto, String code, String requestType)
			throws SQLException, ClassNotFoundException { 
		StringBuilder packageInfoList=new StringBuilder();

		for (PackagesInformation iterable_element : wse00003Dto.getData().getGeneralInformation().getPackagesInformation()) {
			packageInfoList.append("OBJ_GDFIM_GI_PKGS(");
			packageInfoList.append(iterable_element.getNumberOfPackages());
			packageInfoList.append(",'");
			packageInfoList.append(iterable_element.getPackageType());
			packageInfoList.append("')");
			packageInfoList.append(",");
		}
		packageInfoList.replace(packageInfoList.length()-1, packageInfoList.length(), "");

		StringBuilder commoditiesList=new StringBuilder();
		if( wse00003Dto.getData().getNegativeList()!=null) {

			for (String iterable_element : wse00003Dto.getData().getNegativeList().getCommodities()) {
				commoditiesList.append("OBJ_GDFIM_NL_CMDTY('");
				commoditiesList.append(iterable_element);
				commoditiesList.append("')");
				commoditiesList.append(",");
			}
			if(commoditiesList.length()<=0) {
				commoditiesList.replace(commoditiesList.length()-1, commoditiesList.length(), "");
			}
			else {
				commoditiesList.append("OBJ_GDFIM_NL_CMDTY(null)");
			}
		}
		else {
			commoditiesList.append("OBJ_GDFIM_NL_CMDTY(null)");


		}
		StringBuilder containerVehicleInformationLst=new StringBuilder();
		if(wse00003Dto.getData().getGeneralInformation()!=null) {
			if(wse00003Dto.getData().getGeneralInformation().getContainerVehicleInformation()!=null) {
				for (ContainerVehicleInformation iterable_element : wse00003Dto.getData().getGeneralInformation().getContainerVehicleInformation()) {
					containerVehicleInformationLst.append("OBJ_GDFIM_GI_CTRVHCL('");
					containerVehicleInformationLst.append(iterable_element.getContainerOrTruckNumber());
					containerVehicleInformationLst.append("','");
					containerVehicleInformationLst.append(iterable_element.getSealNumber());
					containerVehicleInformationLst.append("','");
					containerVehicleInformationLst.append(iterable_element.getContainerType());
					containerVehicleInformationLst.append("')");
					containerVehicleInformationLst.append(",");
				}
				if(containerVehicleInformationLst.length()>0)
					containerVehicleInformationLst.replace(containerVehicleInformationLst.length()-1, containerVehicleInformationLst.length(), "");
				else {
					containerVehicleInformationLst.append("OBJ_GDFIM_GI_CTRVHCL(null,null,null)");
				}
			}else {
				containerVehicleInformationLst.append("OBJ_GDFIM_GI_CTRVHCL(null,null,null)");
			}
		}
		else {
			containerVehicleInformationLst.append("OBJ_GDFIM_GI_CTRVHCL(null,null,null)");


		}
		StringBuilder itemInformation=new StringBuilder();
		for (ItemInformation iterable_element : wse00003Dto.getData().getItemInformation()) {
			itemInformation.append("OBJ_GDFIM_ITEMS('");
			itemInformation.append(iterable_element.getHsCode());
			itemInformation.append("',");
			itemInformation.append(iterable_element.getQuantity());
			itemInformation.append(",'");
			itemInformation.append(iterable_element.getUom());
			itemInformation.append("',");
			itemInformation.append(iterable_element.getUnitPrice());
			itemInformation.append(",");
			itemInformation.append(iterable_element.getTotalValue());
			itemInformation.append(",");
			itemInformation.append(iterable_element.getImportValue());
			itemInformation.append(")");
			itemInformation.append(",");
		}

		itemInformation.replace(itemInformation.length()-1, itemInformation.length(), "");
		String negativeList="";String supplier="";
		if(wse00003Dto.getData().getNegativeList()!=null) {
			negativeList=	wse00003Dto.getData().getNegativeList().getCountry();
			supplier =wse00003Dto.getData().getNegativeList().getSupplier();
		}
		String finInsUniqueNumber="";
		if(!"302".equalsIgnoreCase(wse00003Dto.getData().getFinancialInfo().getModeOfPayment())){
			if(wse00003Dto.getData().getFinancialInfo()!=null)
				finInsUniqueNumber=wse00003Dto.getData().getFinancialInfo().getFinInsUniqueNumber();
			else {
				return false;
			}
		}else {
			if(wse00003Dto.getData().getFinancialInfo()!=null)
				finInsUniqueNumber=wse00003Dto.getData().getFinancialInfo().getFinInsUniqueNumber();
			else {
				finInsUniqueNumber="";
			}
		}


		String query="INSERT INTO PSW_GDFI_MASTER ( GDNO, GDSTS, CNMT_CAT, GDTYPE, COLLECTORATE, BL_AWB_NO, BL_AWB_DATE, VIR_AIR_NO "
				+ " ,CC_NTNFTN, CC_STRN, CC_CNEE_NAME, CC_CNEE_ADDR, CC_CNOR_NAME, CC_CNOR_ADDR"
				+ " ,FI_IMP_IBAN, FI_MOP, FI_UNO ,FI_CCY, FI_INV_NO, FI_INV_DATE,FI_TOT_DECL_VAL, FI_DLVR_TERMS, FI_FOB_VAL_USD, FI_FREIGHT_USD, FI_CFR_VAL_USD, FI_INSURANCE_USD "
				+ " ,FI_LNDG_CHGS_USD, FI_ASSD_VAL_USD, FI_OTHER_CHGS, FI_EXR"
				+ " ,GI_PKG_INFO, GI_CTRVHCL_INFO, GI_NW, GI_GW, GI_POS, GI_PODLVR, GI_PODISCH, GI_TERM_LOC"
				+ " ,ITEMS_INFO, NL_CTRY,NL_SPLR,NL_CMDTY) VALUES ("
				+ "'"+wse00003Dto.getData().getGdNumber()+"',"
				+ "'"+wse00003Dto.getData().getGdStatus()+"', "
				+ "'"+wse00003Dto.getData().getConsignmentCategory()+"',"
				+ "'"+wse00003Dto.getData().getGdType()+"', "
				+ "'"+wse00003Dto.getData().getCollectorate()+"',"
				+ "'"+wse00003Dto.getData().getBlAwbNumber()+"', "
				+ "'"+wse00003Dto.getData().getBlAwbDate()+"',"
				+ "'"+wse00003Dto.getData().getVirAirNumber()+"', "

+ "'"+wse00003Dto.getData().getConsignorConsigneeInfo().getNtnFtn()+"','"+wse00003Dto.getData().getConsignorConsigneeInfo().getStrn()+"','"+wse00003Dto.getData().getConsignorConsigneeInfo().getConsigneeName()+"','"+wse00003Dto.getData().getConsignorConsigneeInfo().getConsigneeAddress()+"','"+wse00003Dto.getData().getConsignorConsigneeInfo().getConsignorName()+"','"+wse00003Dto.getData().getConsignorConsigneeInfo().getConsignorAddress()+"'," 

+ "'"+wse00003Dto.getData().getFinancialInfo().getImporterIban()+"','"+wse00003Dto.getData().getFinancialInfo().getModeOfPayment()+"','"+finInsUniqueNumber+"','"+wse00003Dto.getData().getFinancialInfo().getCurrency()+"','"+wse00003Dto.getData().getFinancialInfo().getInvoiceNumber()+"','"+wse00003Dto.getData().getFinancialInfo().getInvoiceDate()+"'" 
+ ","+wse00003Dto.getData().getFinancialInfo().getTotalDeclaredValue() +",'"+wse00003Dto.getData().getFinancialInfo().getDeliveryTerm()+"',"+wse00003Dto.getData().getFinancialInfo().getFobValueUsd()+","+wse00003Dto.getData().getFinancialInfo().getFreightUsd()+","+wse00003Dto.getData().getFinancialInfo().getCfrValueUsd()+","+wse00003Dto.getData().getFinancialInfo().getInsuranceUsd()+","+wse00003Dto.getData().getFinancialInfo().getLandingChargesUsd()+","+wse00003Dto.getData().getFinancialInfo().getAssessedValueUsd()+","+wse00003Dto.getData().getFinancialInfo().getOtherCharges()+","+wse00003Dto.getData().getFinancialInfo().getExchangeRate()+"," 

+ "COL_GDFIM_GI_PKGS( "+packageInfoList+"),COL_GDFIM_GI_CTRVHCL("+containerVehicleInformationLst+")"

+ ",'"+wse00003Dto.getData().getGeneralInformation().getNetWeight()+"','"+wse00003Dto.getData().getGeneralInformation().getGrossWeight()+"','"+wse00003Dto.getData().getGeneralInformation().getPortOfShipment()+"','"+wse00003Dto.getData().getGeneralInformation().getPortOfDelivery()+"','"+wse00003Dto.getData().getGeneralInformation().getPortOfDischarge()+"','"+wse00003Dto.getData().getGeneralInformation().getTerminalLocation()+"'" 

+ ",COL_GDFIM_ITEMS("+itemInformation+"),"

+ "'"+negativeList+"','"+supplier+"',COL_GDFIM_NL_CMDTY("+commoditiesList+"))";	

		

		System.out.println("GD Share Query:  "+query);
		
		String removeNull=query.replaceAll("'null'", "null");
		System.out.println("Oracle :"+removeNull);
		
		return jdbcTemplate.getDataSource().getConnection().createStatement().
				execute(removeNull); 


	}


	@Override
	public boolean getWSE00004Records(Wse00004Dto wse00004Dto, String code, String requestType)
			throws SQLException, ClassNotFoundException { 
		StringBuilder packageInfoList=new StringBuilder();
		for (com.jwt.dto.request.wse00004.PackagesInformation iterable_element : wse00004Dto.getData().getGeneralInformation().getPackagesInformation()) {
			packageInfoList.append("OBJ_GDFEM_GI_PKGS(");
			packageInfoList.append(iterable_element.getNumberOfPackages());
			packageInfoList.append(",'");
			packageInfoList.append(iterable_element.getPackageType());
			packageInfoList.append("')");
			packageInfoList.append(",");
		}
		packageInfoList.replace(packageInfoList.length()-1, packageInfoList.length(), "");

		StringBuilder FinancialInstrument=new StringBuilder();
		for (com.jwt.dto.request.wse00004.FinancialInstrument iterable_element : wse00004Dto.getData().getFinancialInformation().getFinancialInstrument()) {
			FinancialInstrument.append("OBJ_GDFEM_FI_FIB('");
			FinancialInstrument.append(iterable_element.getExporterIban());
			FinancialInstrument.append("','");
			FinancialInstrument.append(iterable_element.getModeOfPayment());
			FinancialInstrument.append("','");


			if("305".equalsIgnoreCase(iterable_element.getModeOfPayment())) {
				if(iterable_element.getFinInsUniqueNumber()!=null)
					FinancialInstrument.append(iterable_element.getFinInsUniqueNumber());
				else {
					FinancialInstrument.append("");
				}
			}
			FinancialInstrument.append("',");
			FinancialInstrument.append(iterable_element.getFinInsConsumedValue());
			FinancialInstrument.append(")");
			FinancialInstrument.append(",");
		}
		FinancialInstrument.replace(FinancialInstrument.length()-1, FinancialInstrument.length(), "");



		StringBuilder commoditiesList=new StringBuilder();
		if(wse00004Dto.getData().getNegativeList()!=null) {
			for (String iterable_element : wse00004Dto.getData().getNegativeList().getCommodities()) {
				commoditiesList.append("OBJ_GDFEM_NL_CMDTY('");
				commoditiesList.append(iterable_element);
				commoditiesList.append("')");
				commoditiesList.append(",");
			}
			if(commoditiesList.length()<=0) {
				commoditiesList.replace(commoditiesList.length()-1, commoditiesList.length(), "");
			}
			else {
				commoditiesList.append("OBJ_GDFEM_NL_CMDTY(null)");
			}
		}
		else {
			commoditiesList.append("OBJ_GDFEM_NL_CMDTY(null)");
		}
		StringBuilder containerVehicleInformationLst=new StringBuilder();
		if(wse00004Dto.getData().getGeneralInformation()!=null) {
			if(wse00004Dto.getData().getGeneralInformation().getContainerVehicleInformation()!=null) {
				for (com.jwt.dto.request.wse00004.ContainerVehicleInformation iterable_element : wse00004Dto.getData().getGeneralInformation().getContainerVehicleInformation()) {
					containerVehicleInformationLst.append("OBJ_GDFEM_GI_CTRVHCL('");
					containerVehicleInformationLst.append(iterable_element.getContainerOrTruckNumber());
					containerVehicleInformationLst.append("','");
					containerVehicleInformationLst.append(iterable_element.getSealNumber());
					containerVehicleInformationLst.append("','");
					containerVehicleInformationLst.append(iterable_element.getContainerType());
					containerVehicleInformationLst.append("')");
					containerVehicleInformationLst.append(",");
				}
				if(containerVehicleInformationLst.length()>0) {
					containerVehicleInformationLst.replace(containerVehicleInformationLst.length()-1, containerVehicleInformationLst.length(), "");

				}
				else {
					containerVehicleInformationLst.append("OBJ_GDFEM_GI_CTRVHCL(null,null,null)");
				}
			}else {
				containerVehicleInformationLst.append("OBJ_GDFEM_GI_CTRVHCL(null,null,null)");
			}	
		}

		else {
			containerVehicleInformationLst.append("OBJ_GDFEM_GI_CTRVHCL(null,null,null)");
		}

		StringBuilder itemInformation=new StringBuilder();
		for (com.jwt.dto.request.wse00004.ItemInformation iterable_element : wse00004Dto.getData().getItemInformation()) {
			itemInformation.append("OBJ_GDFEM_ITEMS('");
			itemInformation.append(iterable_element.getHsCode());
			itemInformation.append("',");
			itemInformation.append(iterable_element.getQuantity());
			itemInformation.append(",'");
			itemInformation.append(iterable_element.getUom());
			itemInformation.append("',");
			itemInformation.append(iterable_element.getUnitPrice());
			itemInformation.append(",");
			itemInformation.append(iterable_element.getTotalValue());
			itemInformation.append(",");
			itemInformation.append(iterable_element.getExportValue());
			itemInformation.append(")");
			itemInformation.append(",");
		}

		itemInformation.replace(itemInformation.length()-1, itemInformation.length(), "");

		String negativeList="";String supplier="";
		if(wse00004Dto.getData().getNegativeList()!=null) {
			negativeList=	wse00004Dto.getData().getNegativeList().getCountry();
			supplier =wse00004Dto.getData().getNegativeList().getSupplier();
		}
		String str="INSERT INTO PSW_GDFE_MASTER ( GDNO, GDSTS, CNMT_CAT, GDTYPE, COLLECTORATE, BL_AWB_NO, BL_AWB_DATE, VIR_AIR_NO, "
				+ "CC_NTNFTN, CC_SRTN, CC_CNEE_NAME, CC_CNEE_ADDR, CC_CNOR_NAME, CC_CNOR_ADDR, "
				+ "FI_FIB,FI_CCY,FI_INV_NO,FI_INV_DATE,FI_TOT_DECL_VAL, FI_DLVR_TERMS, FI_FOB_VAL_USD, FI_FREIGHT_USD, FI_CFR_VAL_USD, FI_INSURANCE_USD, FI_LNDG_CHGS_USD, FI_ASSD_VAL_USD, FI_OTHER_CHGS, FI_EXR,"
				+ "GI_PKG_INFO, GI_CTRVHCL_INFO, GI_NW, GI_GW, GI_CNMT_TYPE, GI_POS, GI_PODLVR, GI_PODISCH, GI_TERM_LOC, GI_SHPG_LINE, GI_DEST_CNTRY,  "
				+ "ITEMS_INFO, "
				+ "NL_CTRY, NL_SPLR, NL_CMDTY"
				+ ") VALUES ("
				+ "'"+wse00004Dto.getData().getGdNumber()+"',"
				+ "'"+wse00004Dto.getData().getGdStatus()+"', "
				+ "'"+wse00004Dto.getData().getConsignmentCategory()+"',"
				+ "'"+wse00004Dto.getData().getGdType()+"', "
				+ "'"+wse00004Dto.getData().getCollectorate()+"',"
				+ "'"+wse00004Dto.getData().getBlAwbNumber()+"', "
				+ "'"+wse00004Dto.getData().getBlAwbDate()+"',"
				+ "'"+wse00004Dto.getData().getVirAirNumber()+"', "

+ "'"+wse00004Dto.getData().getConsignorConsigneeInfo().getNtnFtn()+"','"+wse00004Dto.getData().getConsignorConsigneeInfo().getStrn()+"','"+wse00004Dto.getData().getConsignorConsigneeInfo().getConsigneeName()+"','"+wse00004Dto.getData().getConsignorConsigneeInfo().getConsigneeAddress()+"','"+wse00004Dto.getData().getConsignorConsigneeInfo().getConsignorName()+"','"+wse00004Dto.getData().getConsignorConsigneeInfo().getConsignorAddress()+"'," 

+ "COL_GDFEM_FI_FIB("+FinancialInstrument+"),'"+wse00004Dto.getData().getFinancialInformation().getCurrency()+"',"+wse00004Dto.getData().getFinancialInformation().getTotalDeclaredValue()+",'"+wse00004Dto.getData().getFinancialInformation().getInvoiceNumber()+"','"+wse00004Dto.getData().getFinancialInformation().getInvoiceDate()+"','"+wse00004Dto.getData().getFinancialInformation().getDeliveryTerm()+"',"+wse00004Dto.getData().getFinancialInformation().getFobValueUsd()+","+wse00004Dto.getData().getFinancialInformation().getFreightUsd()+","+wse00004Dto.getData().getFinancialInformation().getCfrValueUsd()+","+wse00004Dto.getData().getFinancialInformation().getInsuranceUsd()+","+wse00004Dto.getData().getFinancialInformation().getLandingChargesUsd()+","+wse00004Dto.getData().getFinancialInformation().getAssessedValueUsd()+","+wse00004Dto.getData().getFinancialInformation().getOtherCharges()+","+wse00004Dto.getData().getFinancialInformation().getExchangeRate()+","

+ "COL_GDFEM_GI_PKGS( "+packageInfoList+"),COL_GDFEM_GI_CTRVHCL("+containerVehicleInformationLst+")"

+ ",'"+wse00004Dto.getData().getGeneralInformation().getNetWeight()+"','"+wse00004Dto.getData().getGeneralInformation().getGrossWeight()+"','"+wse00004Dto.getData().getGeneralInformation().getConsignmentType()+"','"+wse00004Dto.getData().getGeneralInformation().getPortOfShipment()+"','"+wse00004Dto.getData().getGeneralInformation().getPlaceOfDelivery()+"','"+wse00004Dto.getData().getGeneralInformation().getPortOfDischarge()+"','"+wse00004Dto.getData().getGeneralInformation().getTerminalLocation()+"','"+wse00004Dto.getData().getGeneralInformation().getShippingLine()+"','"+wse00004Dto.getData().getGeneralInformation().getDestinationCountry()+"'" 

+ ",COL_GDFEM_ITEMS("+itemInformation+"),"

+ "'"+negativeList+"','"+supplier+"',COL_GDFEM_NL_CMDTY("+commoditiesList+"))";

		String removeNull=str.replaceAll("'null'", "null");
		System.out.println("Oracle :"+removeNull);
		//	dto.getData().get("generalInformation")
		return jdbcTemplate.getDataSource().getConnection().createStatement().
				execute(removeNull); 






	}
	@Override
	@Transactional
	public Map<String, Object> getWSE00006ExportRecords(WseWSE00006Export wse00006ExportDto, String code, String requestType)
			throws SQLException, ClassNotFoundException {

		Map<String, Object> map= new HashMap<String, Object>();
		StringBuilder itemInformation=new StringBuilder();
		for (com.jwt.dto.request.wseWSE00006Export.ItemInformationFinancialInf iterable_element : wse00006ExportDto.getData().getFinancialInstrumentInfo().getItemInformation()) {
			itemInformation.append("OBJ_FTEM_ITEMS('");
			itemInformation.append(iterable_element.getHsCode());
			itemInformation.append("','");
			itemInformation.append(iterable_element.getGoodsDescription());
			itemInformation.append("',");
			itemInformation.append(iterable_element.getQuantity());
			itemInformation.append(",'");
			itemInformation.append(iterable_element.getUom());
			itemInformation.append("',");
			itemInformation.append(iterable_element.getItemInvoiceValue());
			itemInformation.append(",'");
			itemInformation.append(iterable_element.getCountryOfOrigin());
			itemInformation.append("')");
			itemInformation.append(",");
		}
		itemInformation.replace(itemInformation.length()-1, itemInformation.length(), "");


		Statement str= jdbcTemplate.getDataSource().getConnection().createStatement();

		boolean exportMaster=	str.execute(
				"INSERT INTO PSW_COBR_MASTER (COBR_UNO, COBR_TYPE, TRADE_TYPE, TRADER_IBAN, TRADER_NTN, TRADER_NAME, "
						+ "FI_UNO) VALUES(" + "'"
						+ wse00006ExportDto.getData().getCobUniqueIdNumber() + "','T','"
						+ wse00006ExportDto.getData().getTradeTranType() + "','"
						+ wse00006ExportDto.getData().getFinancialInstrumentInfo().getExporterIban() + "','"
						+ wse00006ExportDto.getData().getFinancialInstrumentInfo().getExporterNtn() + "','"
						+ wse00006ExportDto.getData().getFinancialInstrumentInfo().getExporterName() + "','"
						+ wse00006ExportDto.getData().getFinancialInstrumentInfo().getFinInsUniqueNumber() + "')"
				);

		Integer CoColAdvPayPer=null;Integer CoColDocAgainstPayPercentage=null ;Integer CoColAgainstAcceptancePercentage=null;Integer CoColDays=null;Integer CoColTotalPercentage=null;
		//304 contact 301 LCdate 310 //cash margin 302//openAccountData
		if("308".equalsIgnoreCase(wse00006ExportDto.getData().getFinancialInstrumentInfo().getModeOfPayment())) { // contract Collection
			CoColAdvPayPer=wse00006ExportDto.getData().getFinancialInstrumentInfo().getContractCollectionData().getAdvPayPercentage();
			CoColDocAgainstPayPercentage=wse00006ExportDto.getData().getFinancialInstrumentInfo().getContractCollectionData().getDocAgainstPayPercentage();
			CoColAgainstAcceptancePercentage=wse00006ExportDto.getData().getFinancialInstrumentInfo().getContractCollectionData().getDocAgainstAcceptancePercentage();
			CoColDays=wse00006ExportDto.getData().getFinancialInstrumentInfo().getContractCollectionData().getDays();
			CoColTotalPercentage=wse00006ExportDto.getData().getFinancialInstrumentInfo().getContractCollectionData().getTotalPercentage();


		}
		Integer lcAdvPayPercentage=null;Integer lcSightPercentage=null ;Integer lcUsancePercentage=null;Integer lcDays=null;Integer lcTotalPercentage=null;

		if("307".equalsIgnoreCase(wse00006ExportDto.getData().getFinancialInstrumentInfo().getModeOfPayment())) {//LC data
			lcAdvPayPercentage=wse00006ExportDto.getData().getFinancialInstrumentInfo().getLcData().getAdvPayPercentage()  ;
			lcSightPercentage=wse00006ExportDto.getData().getFinancialInstrumentInfo().getLcData().getSightPercentage();
			lcUsancePercentage=wse00006ExportDto.getData().getFinancialInstrumentInfo().getLcData().getUsancePercentage();
			lcDays=wse00006ExportDto.getData().getFinancialInstrumentInfo().getLcData().getDays();
			lcTotalPercentage= wse00006ExportDto.getData().getFinancialInstrumentInfo().getLcData().getTotalPercentage();

		}

		String openAccountDataGdNumber=null;

		if("305".equalsIgnoreCase(wse00006ExportDto.getData().getFinancialInstrumentInfo().getModeOfPayment())) {//LC data
			openAccountDataGdNumber=wse00006ExportDto.getData().getFinancialInstrumentInfo().getOpenAccountData().getGdNumber() ;


		}

		boolean exportMasterFi=	str.execute(
				"INSERT INTO PSW_COBR_FIE (COBR_UNO,FI_UNO, EXP_NTN, EXP_NAME, EXP_IBAN, MOP,"
						+ "CC_APP, CC_DAPP, CC_DAAP, CC_DAYS, CC_TOTAL,"
						+ "LC_APP, LC_SP, LC_UP, LC_DAYS, LC_TOTAL, OAGDNO,"
						+ "PI_CNEE_NAME, PI_CNEE_ADDRESS, PI_CNEE_COUNTRY, PI_CNEE_IBAN, PI_PODISCH, PI_DLVR_TERMS, PI_FI_CCY, PI_FI_VAL, PI_FI_EXPIRY_DATE,"
						+ "ITEMS_INFO"

					+ ") VALUES(" + "'"
					+ wse00006ExportDto.getData().getCobUniqueIdNumber() + "','" 
					+ wse00006ExportDto.getData().getFinancialInstrumentInfo().getFinInsUniqueNumber() + "','" 
					+ wse00006ExportDto.getData().getFinancialInstrumentInfo().getExporterNtn() + "','"
					+ wse00006ExportDto.getData().getFinancialInstrumentInfo().getExporterName() + "','"
					+ wse00006ExportDto.getData().getFinancialInstrumentInfo().getExporterIban() + "','"
					+ wse00006ExportDto.getData().getFinancialInstrumentInfo().getModeOfPayment() + "',"
					+ CoColAdvPayPer +  ","
					+ CoColDocAgainstPayPercentage+ ","
					+ CoColAgainstAcceptancePercentage + ","
					+ CoColDays + ","
					+ CoColTotalPercentage + ","
					+ lcAdvPayPercentage + ","

					+ lcSightPercentage + ","
					+ lcUsancePercentage + ","
					+ lcDays + ","
					+ lcTotalPercentage + ",'"

					+ openAccountDataGdNumber + ",'"

					+ wse00006ExportDto.getData().getFinancialInstrumentInfo().getPaymentInformation().getConsigneeName() + "','"
					+ wse00006ExportDto.getData().getFinancialInstrumentInfo().getPaymentInformation().getConsigneeAddress() + "','"
					+ wse00006ExportDto.getData().getFinancialInstrumentInfo().getPaymentInformation().getConsigneeCountry() + "','"
					+ wse00006ExportDto.getData().getFinancialInstrumentInfo().getPaymentInformation().getConsigneeIban() + "','"
					+ wse00006ExportDto.getData().getFinancialInstrumentInfo().getPaymentInformation().getPortOfDischarge() + "','"
					+ wse00006ExportDto.getData().getFinancialInstrumentInfo().getPaymentInformation().getDeliveryTerms() + "','"

					+ wse00006ExportDto.getData().getFinancialInstrumentInfo().getPaymentInformation().getFinancialInstrumentCurrency() + "','"
					+ wse00006ExportDto.getData().getFinancialInstrumentInfo().getPaymentInformation().getFinancialInstrumentValue() + "','"
					+ wse00006ExportDto.getData().getFinancialInstrumentInfo().getPaymentInformation().getExpiryDate() + "',"

					+ "COL_FTEM_ITEMS("+itemInformation+"))"

				);

		boolean exportMasterGd=false;
		for (com.jwt.dto.request.wseWSE00006Export.GdInfo gdE :  wse00006ExportDto.getData().getGdInfo()) {

			StringBuilder itemInformationGd=new StringBuilder();

			itemInformationGd.append("OBJ_GDFEM_FI_FIB('");
			itemInformationGd.append(gdE.getFinancialInformation().getExporterIban());
			itemInformationGd.append("','");
			itemInformationGd.append(gdE.getFinancialInformation().getModeOfPayment());
			itemInformationGd.append("','");
			itemInformationGd.append(gdE.getFinancialInformation().getFinInsUniqueNumber());
			itemInformationGd.append("')");


			StringBuilder packageInfoList=new StringBuilder();
			for (com.jwt.dto.request.wseWSE00006Export.PackagesInformation iterable_element : gdE.getGeneralInformation().getPackagesInformation()) {
				packageInfoList.append("OBJ_GDFEM_GI_PKGS(");
				packageInfoList.append(iterable_element.getNumberOfPackages());
				packageInfoList.append(",'");
				packageInfoList.append(iterable_element.getPackageType());
				packageInfoList.append("')");
				packageInfoList.append(",");
			}
			packageInfoList.replace(packageInfoList.length()-1, packageInfoList.length(), "");

			StringBuilder containerVehicleInformationLst=new StringBuilder();
			for (com.jwt.dto.request.wseWSE00006Export.ContainerVehicleInformation iterable_element : gdE.getGeneralInformation().getContainerVehicleInformation()) {
				containerVehicleInformationLst.append("OBJ_GDFEM_GI_CTRVHCL('");
				containerVehicleInformationLst.append(iterable_element.getContainerOrTruckNumber());
				containerVehicleInformationLst.append("','");
				containerVehicleInformationLst.append(iterable_element.getSealNumber());
				containerVehicleInformationLst.append("','");
				containerVehicleInformationLst.append(iterable_element.getContainerType());
				containerVehicleInformationLst.append("')");
				containerVehicleInformationLst.append(",");
			}
			containerVehicleInformationLst.replace(containerVehicleInformationLst.length()-1, containerVehicleInformationLst.length(), "");


			StringBuilder itemInformationgD=new StringBuilder();
			for (com.jwt.dto.request.wseWSE00006Export.ItemInformationGd iterable_element :  gdE.getItemInformation()) {
				itemInformationgD.append("OBJ_GDFEM_ITEMS('");
				itemInformationgD.append(iterable_element.getHsCode());
				itemInformationgD.append("',");
				itemInformationgD.append(iterable_element.getQuantity());
				itemInformationgD.append(",'");
				itemInformationgD.append(iterable_element.getUom());
				itemInformationgD.append("',");
				itemInformationgD.append(iterable_element.getUnitPrice());
				itemInformationgD.append(",");
				itemInformationgD.append(iterable_element.getTotalValue());
				itemInformationgD.append(",");
				itemInformationgD.append(iterable_element.getExportValue());
				itemInformationgD.append(")");
				itemInformationgD.append(",");
			}

			itemInformationgD.replace(itemInformationgD.length()-1, itemInformationgD.length(), "");



			exportMasterGd=  str.execute(
					"INSERT INTO PSW_COBR_GDE (COBR_UNO,"
							+ "GDNO, GDSTS, CNMT_CAT, GDTYPE, COLLECTORATE, BL_AWB_NO, BL_AWB_DATE, VIR_AIR_NO, CC_NTNFTN, CC_SRTN, CC_CNEE_NAME, CC_CNEE_ADDR, CC_CNOR_NAME, CC_CNOR_ADDR,"
							+ "FI_EXP_IBAN,FI_MOP,FI_UNO, FI_CVALUE,FI_CCY,FI_INV_NO, FI_INV_DATE, FI_TOT_DECL_VAL, FI_DLVR_TERMS, FI_FOB_VAL_USD, FI_FREIGHT_USD, FI_CFR_VAL_USD, FI_INSURANCE_USD,"
							+ "FI_LNDG_CHGS_USD, FI_ASSD_VAL_USD, FI_OTHER_CHGS, FI_EXR, "
							+ "GI_NW, GI_GW, GI_CNMT_TYPE, GI_POS, GI_PODLVR, GI_PODISCH, GI_TERM_LOC, GI_SHPG_LINE, GI_PKG_INFO, GI_CTRVHCL_INFO,"
							+ "ITEMS_INFO"

					+ ") VALUES('"
					+ wse00006ExportDto.getData().getCobUniqueIdNumber() + "','" 
					+gdE.getGdNumber() + "','" + gdE.getGdStatus() + "','"
					+gdE.getConsignmentCategory() + "','" + gdE.getGdType() + "','"
					+gdE.getCollectorate() + "','" + gdE.getBlAwbNumber() + "','"
					+gdE.getBlAwbDate() + "','" + gdE.getVirAirNumber() + "','"
					+gdE.getConsignorConsigneeInfo().getNtnFtn() + "','" +gdE.getConsignorConsigneeInfo().getStrn() + "','"
					+gdE.getConsignorConsigneeInfo().getConsigneeName() + "','" +gdE.getConsignorConsigneeInfo().getConsigneeAddress() + "','"
					+gdE.getConsignorConsigneeInfo().getConsignorName() + "','" +gdE.getConsignorConsigneeInfo().getConsignorAddress() + "','"

					+gdE.getFinancialInformation().getExporterIban()+ "','"

					+gdE.getFinancialInformation().getModeOfPayment()+ "','"

					+gdE.getFinancialInformation().getFinInsUniqueNumber()+"'," + gdE.getFinancialInformation().getFinInsConsumedValue() + ",'" + gdE.getFinancialInformation().getCurrency() + "','"
					+gdE.getFinancialInformation().getInvoiceNumber() + "','" + gdE.getFinancialInformation().getInvoiceDate() + "','"
					+gdE.getFinancialInformation().getTotalDeclaredValue() + "','" + gdE.getFinancialInformation().getDeliveryTerm() + "','"
					+gdE.getFinancialInformation().getFobValueUsd() + "','" + gdE.getFinancialInformation().getFreightUsd() + "','"
					+gdE.getFinancialInformation().getCfrValueUsd() + "','" + gdE.getFinancialInformation().getInsuranceUsd() + "','"
					+gdE.getFinancialInformation().getLandingChargesUsd() + "','" + gdE.getFinancialInformation().getAssessedValueUsd() + "','"
					+gdE.getFinancialInformation().getOtherCharges() + "','" + gdE.getFinancialInformation().getExchangeRate() + "','"

					+gdE.getGeneralInformation().getNetWeight() + "','" + gdE.getGeneralInformation().getGrossWeight() + "','"
					+gdE.getGeneralInformation().getConsignmentType() + "','" + gdE.getGeneralInformation().getPortOfShipment() + "','"
					+gdE.getGeneralInformation().getPlaceOfDelivery() + "','" + gdE.getGeneralInformation().getPortOfDischarge() + "','"
					+gdE.getGeneralInformation().getTerminalLocation() + "','" + gdE.getGeneralInformation().getShippingLine() + "',"

					+ "COL_GDFEM_GI_PKGS("+packageInfoList+"),COL_GDFEM_GI_CTRVHCL("+containerVehicleInformationLst+"),COL_GDFEM_ITEMS("+itemInformationgD+"))"


					);
		}


		boolean exportMasterBca=false;
		for (com.jwt.dto.request.wseWSE00006Export.BankAdviceInfo bcaE :  wse00006ExportDto.getData().getBankAdviceInfo()) {

			StringBuilder bacEGdNumber=new StringBuilder();
			bacEGdNumber.append("COL_FI_GDNO(");
			for (String iterable_element : bcaE.getGdNumber()) {
				bacEGdNumber.append("'");
				bacEGdNumber.append(iterable_element);
				bacEGdNumber.append("'");
				bacEGdNumber.append(",");
			}
			bacEGdNumber.replace(bacEGdNumber.length()-1, bacEGdNumber.length(), "");
			bacEGdNumber.append(")");
			exportMasterBca= str.execute(
					"INSERT INTO PSW_COBR_BCAE (COBR_UNO, BCA_UINO, GD_INFO,"
							+ "EXP_NTN,EXP_NAME,EXP_IBAN,MOEP, FI_UNO,"
							+ "BCAI_EVENT_NAME,BCAI_EVENT_DATE,BCAI_RUNNING_SRNO, BCAI_SWIFT_REFNO, BCAI_BILL_NO ,BCAI_BILL_DATE, BCAI_BILL_AMT, BCAI_INV_NO, BCAI_INV_DATE,BCAI_INV_AMT,"
							+ "DED_FBCHRGS_FCY, DED_ABC_FCY, DED_WHT_LCY, DED_EDS_LCY,"
							+ "NAR_COR_DIFF, NAR_COR_DIFF_CCY, NAR_BCA_AMT_FCY, NAR_EXR_FCY, NAR_BCA_PKR, NAR_DOR,"
							+ "NAR_ADJ_FCY, NAR_FANR_RASWD, NAR_ALLOWED_DISC, NAR_ALLOWED_DISCP, NAR_BCA_TAMT_FCY, NAR_AMT_REALIZED, NAR_BAMT, NAR_REMARKS"					
							+ ") VALUES('"
							+ wse00006ExportDto.getData().getCobUniqueIdNumber() + "','"+bcaE.getBcaUniqueIdNumber()+"',"+bacEGdNumber+",'" +bcaE.getExporterNtn() + "','"+bcaE.getExporterName()+"','"
							+ bcaE.getIban()+"','"+ bcaE.getModeOfPayment() + "','"+bcaE.getFinInsUniqueNumber()+"','"+bcaE.getBcaInformation().getBcaEventName() + "','"
							+ bcaE.getBcaInformation().getEventDate() + "','"+bcaE.getBcaInformation().getRunningSerialNumber()+"','"+bcaE.getBcaInformation().getSwiftReference() + "','"
							+ bcaE.getBcaInformation().getBillNumber() + "','"+bcaE.getBcaInformation().getBillDated()+"','"+bcaE.getBcaInformation().getBillAmount() + "','"
							+ bcaE.getBcaInformation().getInvoiceNumber() + "','"+bcaE.getBcaInformation().getInvoiceDate()+"','"+bcaE.getBcaInformation().getInvoiceAmount() + "','"
							+ bcaE.getDeductions().getForeignBankChargesFcy() + "','"+bcaE.getDeductions().getAgentCommissionFcy()+"','"+bcaE.getDeductions().getWithholdingTaxPkr() + "','"
							+ bcaE.getDeductions().getEdsPkr() + "','"+ bcaE.getNetAmountRealized().getIsFinInsCurrencyDiff() + "','"+ bcaE.getNetAmountRealized().getCurrency() + "','"+ bcaE.getNetAmountRealized().getBcaFc()+"','"
							+ bcaE.getNetAmountRealized().getFcyExchangeRate() + "',"+ bcaE.getNetAmountRealized().getBcaPkr() + ",'"+ bcaE.getNetAmountRealized().getDateOfRealized() + "','"+ bcaE.getNetAmountRealized().getAdjustFromSpecialFcyAcc()+"','"
							+ bcaE.getNetAmountRealized().getIsRemAmtSettledWithDiscount() + "','"+ bcaE.getNetAmountRealized().getAllowedDiscount() + "','"+ bcaE.getNetAmountRealized().getAllowedDiscountPercentage() + "','"+ bcaE.getNetAmountRealized().getTotalBcaAmount()+"','"
							+ bcaE.getNetAmountRealized().getAmountRealized() + "','"+ bcaE.getNetAmountRealized().getBalance() + "','"+ bcaE.getRemarks() + "')"
					);
		}
		map.put("P_STS","S");
		map.put("P_WSSTS","200");
		map.put("P_STS_DESC","Change of bank request with GD and financial information received.");
		map.put("P_WSSTS_DESC","Change of bank request with GD and financial information received.");
		return map;


	}


	@Override
	public Map<String, Object> getWSE00006ImportRecords(WseWSE00006Import wse00006ImportDto, String code, String requestType)
			throws SQLException, ClassNotFoundException {
		Map<String, Object> map= new HashMap<String, Object>();
		StringBuilder itemInformation=new StringBuilder();
		for (com.jwt.dto.request.wseWSE00006Import.ItemInformationFinancalInst iterable_element : wse00006ImportDto.getData().getFinancialInstrumentInfo().getItemInformation()) {
			itemInformation.append("OBJ_FTIM_ITEMS('");
			itemInformation.append(iterable_element.getHsCode());
			itemInformation.append("','");
			itemInformation.append(iterable_element.getGoodsDescription());
			itemInformation.append("',");
			itemInformation.append(iterable_element.getQuantity());
			itemInformation.append(",'");
			itemInformation.append(iterable_element.getUom());
			itemInformation.append("','");
			itemInformation.append(iterable_element.getCountryOfOrigin());
			itemInformation.append("','");
			itemInformation.append(iterable_element.getSample());
			itemInformation.append("',");
			itemInformation.append(iterable_element.getSampleValue());
			itemInformation.append(")");
			itemInformation.append(",");
		}
		itemInformation.replace(itemInformation.length()-1, itemInformation.length(), "");


		Statement str= jdbcTemplate.getDataSource().getConnection().createStatement();

		boolean importMaster=	str.execute(
				"INSERT INTO PSW_COBR_MASTER (COBR_UNO, COBR_TYPE, NEW_BANK_IBAN , TRADE_TYPE, TRADER_IBAN, TRADER_NTN, TRADER_NAME, "
						+ "FI_UNO) VALUES(" + "'"
						+ wse00006ImportDto.getData().getCobUniqueIdNumber() + "','T','"
						+ wse00006ImportDto.getData().getTradeTranType() + "','"
						+ wse00006ImportDto.getData().getIban() + "','"
						+ wse00006ImportDto.getData().getFinancialInstrumentInfo().getImporterIban() + "','"
						+ wse00006ImportDto.getData().getFinancialInstrumentInfo().getImporterNtn() + "','"
						+ wse00006ImportDto.getData().getFinancialInstrumentInfo().getImporterName() + "','"
						+ wse00006ImportDto.getData().getFinancialInstrumentInfo().getFinInsUniqueNumber() + "')"
				);
		Integer CoColAdvPayPer=null;Integer CoColDocAgainstPayPercentage=null ;Integer CoColAgainstAcceptancePercentage=null;Integer CoColDays=null;Integer CoColTotalPercentage=null;
		//304 contact 301 LCdate 310 //cash margin 302//openAccountData
		if("304".equalsIgnoreCase(wse00006ImportDto.getData().getFinancialInstrumentInfo().getModeOfPayment())) { // contract Collection
			CoColAdvPayPer=wse00006ImportDto.getData().getFinancialInstrumentInfo().getContractCollectionData().getAdvPayPercentage();
			CoColDocAgainstPayPercentage=wse00006ImportDto.getData().getFinancialInstrumentInfo().getContractCollectionData().getDocAgainstPayPercentage();
			CoColAgainstAcceptancePercentage=wse00006ImportDto.getData().getFinancialInstrumentInfo().getContractCollectionData().getDocAgainstAcceptancePercentage();
			CoColDays=wse00006ImportDto.getData().getFinancialInstrumentInfo().getContractCollectionData().getDays();
			CoColTotalPercentage=wse00006ImportDto.getData().getFinancialInstrumentInfo().getContractCollectionData().getTotalPercentage();


		}
		Integer lcAdvPayPercentage=null;Integer lcSightPercentage=null ;Integer lcUsancePercentage=null;Integer lcDays=null;Integer lcTotalPercentage=null;

		if("301".equalsIgnoreCase(wse00006ImportDto.getData().getFinancialInstrumentInfo().getModeOfPayment())) {//LC data
			lcAdvPayPercentage=wse00006ImportDto.getData().getFinancialInstrumentInfo().getLcData().getAdvPayPercentage()  ;
			lcSightPercentage=wse00006ImportDto.getData().getFinancialInstrumentInfo().getLcData().getSightPercentage();
			lcUsancePercentage=wse00006ImportDto.getData().getFinancialInstrumentInfo().getLcData().getUsancePercentage();
			lcDays=wse00006ImportDto.getData().getFinancialInstrumentInfo().getLcData().getDays();
			lcTotalPercentage= wse00006ImportDto.getData().getFinancialInstrumentInfo().getLcData().getTotalPercentage();

		}
		Integer cMarginPercentage=null;Double cashmarginValue=null ;

		if("310".equalsIgnoreCase(wse00006ImportDto.getData().getFinancialInstrumentInfo().getModeOfPayment())) {//LC data
			cMarginPercentage=wse00006ImportDto.getData().getFinancialInstrumentInfo().getCashMargin().getCashmarginPercentage() ;
			cashmarginValue=wse00006ImportDto.getData().getFinancialInstrumentInfo().getCashMargin().getCashmarginValue();

		}
		String openAccountDataGdNumber=null;

		if("302".equalsIgnoreCase(wse00006ImportDto.getData().getFinancialInstrumentInfo().getModeOfPayment())) {//LC data
			openAccountDataGdNumber=wse00006ImportDto.getData().getFinancialInstrumentInfo().getOpenAccountData().getGdNumber() ;


		}

		boolean importFi=	str.execute(
				"INSERT INTO PSW_COBR_FII (COBR_UNO,"
						+ "			FI_UNO,"
						+ "			IMP_NTN,"
						+ "			IMP_NAME,"
						+ "			IMP_IBAN,"
						+ "			MOP,"
						+ "			CC_APP,"
						+ "			CC_DAPP,"
						+ "			CC_DAAP,"
						+ "			CC_DAYS,"
						+ "			CC_TOTAL,"
						+ "			LC_APP,"
						+ "			LC_SP,"
						+ "			LC_UP,"
						+ "			LC_DAYS,"
						+ "			LC_TOTAL,"
						+ "			CASH_MARGIN_PERAGE,"
						+ "			CASH_MARGIN_VALUE,"
						+ "			OAGDNO,"
						+ "			PI_BEN_NAME,"
						+ "			PI_BEN_ADDRESS,"
						+ "			PI_BEN_COUNTRY,"
						+ "			PI_BEN_IBAN,"
						+ "			PI_EXP_NAME,"
						+ "			PI_EXP_ADDRESS,"
						+ "			PI_EXP_COUNTRY,"
						+ "			PI_POS,"
						+ "			PI_DELIVERY_TERMS,"
						+ "			PI_FIVAL,"
						+ "			PI_FICCY,"
						+ "			PI_EXCHANGE_RATE,"
						+ "			PI_LC_NO,"
						+ "			ITEMS_INFO,"
						+ "			FI_IPD,"
						+ "			FI_TDD,"
						+ "			FI_FDS,"
						+ "			FI_EXPIRY_DATE,"
						+ "			FI_REMARKS"

					+ ") VALUES(" + "'"
					+ wse00006ImportDto.getData().getCobUniqueIdNumber() + "','" 
					+ wse00006ImportDto.getData().getFinancialInstrumentInfo().getFinInsUniqueNumber() + "','" 
					+ wse00006ImportDto.getData().getFinancialInstrumentInfo().getImporterNtn() + "','"
					+ wse00006ImportDto.getData().getFinancialInstrumentInfo().getImporterName() + "','"
					+ wse00006ImportDto.getData().getFinancialInstrumentInfo().getImporterIban() + "','"
					+ wse00006ImportDto.getData().getFinancialInstrumentInfo().getModeOfPayment() + "',"
					+ CoColAdvPayPer +  ","
					+ CoColDocAgainstPayPercentage + ","
					+ CoColAgainstAcceptancePercentage + ","
					+ CoColDays + ","
					+ CoColTotalPercentage + ","

					+ lcAdvPayPercentage + ","
					+ lcSightPercentage + ","
					+ lcUsancePercentage + ","
					+ lcDays + ","
					+ lcTotalPercentage + ","

					+ cMarginPercentage + ","
					+ cashmarginValue + ",'"
					+ openAccountDataGdNumber + "','"
					+ wse00006ImportDto.getData().getFinancialInstrumentInfo().getPaymentInformation().getBeneficiaryName() + "','"
					+ wse00006ImportDto.getData().getFinancialInstrumentInfo().getPaymentInformation().getBeneficiaryAddress() + "','"
					+ wse00006ImportDto.getData().getFinancialInstrumentInfo().getPaymentInformation().getBeneficiaryCountry() + "','"
					+ wse00006ImportDto.getData().getFinancialInstrumentInfo().getPaymentInformation().getBeneficiaryIban() + "','"
					+ wse00006ImportDto.getData().getFinancialInstrumentInfo().getPaymentInformation().getExporterName() + "','"
					+ wse00006ImportDto.getData().getFinancialInstrumentInfo().getPaymentInformation().getExporterAddress() + "','"
					+ wse00006ImportDto.getData().getFinancialInstrumentInfo().getPaymentInformation().getExporterCountry() + "','"

					+ wse00006ImportDto.getData().getFinancialInstrumentInfo().getPaymentInformation().getPortOfShipment() + "','"
					+ wse00006ImportDto.getData().getFinancialInstrumentInfo().getPaymentInformation().getDeliveryTerms() + "',"
					+ wse00006ImportDto.getData().getFinancialInstrumentInfo().getPaymentInformation().getFinancialInstrumentValue() + ",'"
					+ wse00006ImportDto.getData().getFinancialInstrumentInfo().getPaymentInformation().getFinancialInstrumentCurrency() + "',"
					+ wse00006ImportDto.getData().getFinancialInstrumentInfo().getPaymentInformation().getExchangeRate() + ",'"
					+ wse00006ImportDto.getData().getFinancialInstrumentInfo().getPaymentInformation().getLcContractNo() + "',"

					+ "COL_FTIM_ITEMS("+itemInformation+"),'"
					+ wse00006ImportDto.getData().getFinancialInstrumentInfo().getFinancialTranInformation().getIntendedPayDate() + "','"
					+ wse00006ImportDto.getData().getFinancialInstrumentInfo().getFinancialTranInformation().getTransportDocDate() + "','"
					+ wse00006ImportDto.getData().getFinancialInstrumentInfo().getFinancialTranInformation().getFinalDateOfShipment() + "','"
					+ wse00006ImportDto.getData().getFinancialInstrumentInfo().getFinancialTranInformation().getExpiryDate() + "','"
					+ wse00006ImportDto.getData().getFinancialInstrumentInfo().getRemarks() + "')"

				);

		boolean importMasterGd=false;
		for (com.jwt.dto.request.wseWSE00006Import.GdInfo gdE :  wse00006ImportDto.getData().getGdInfo()) {


			StringBuilder packageInfoList=new StringBuilder();
			for (com.jwt.dto.request.wseWSE00006Import.PackagesInformation iterable_element : gdE.getGeneralInformation().getPackagesInformation()) {
				packageInfoList.append("OBJ_GDFIM_GI_PKGS(");
				packageInfoList.append(iterable_element.getNumberOfPackages());
				packageInfoList.append(",'");
				packageInfoList.append(iterable_element.getPackageType());
				packageInfoList.append("')");
				packageInfoList.append(",");
			}
			packageInfoList.replace(packageInfoList.length()-1, packageInfoList.length(), "");

			StringBuilder containerVehicleInformationLst=new StringBuilder();
			for (com.jwt.dto.request.wseWSE00006Import.ContainerVehicleInformation iterable_element : gdE.getGeneralInformation().getContainerVehicleInformation()) {
				containerVehicleInformationLst.append("OBJ_GDFIM_GI_CTRVHCL('");
				containerVehicleInformationLst.append(iterable_element.getContainerOrTruckNumber());
				containerVehicleInformationLst.append("','");
				containerVehicleInformationLst.append(iterable_element.getSealNumber());
				containerVehicleInformationLst.append("','");
				containerVehicleInformationLst.append(iterable_element.getContainerType());
				containerVehicleInformationLst.append("')");
				containerVehicleInformationLst.append(",");
			}
			containerVehicleInformationLst.replace(containerVehicleInformationLst.length()-1, containerVehicleInformationLst.length(), "");


			StringBuilder itemInformationgD=new StringBuilder();
			for (com.jwt.dto.request.wseWSE00006Import.ItemInformationGd iterable_element :  gdE.getItemInformation()) {
				itemInformationgD.append("OBJ_GDFIM_ITEMS('");
				itemInformationgD.append(iterable_element.getHsCode());
				itemInformationgD.append("',");
				itemInformationgD.append(iterable_element.getQuantity());
				itemInformationgD.append(",'");
				itemInformationgD.append(iterable_element.getUom());
				itemInformationgD.append("',");
				itemInformationgD.append(iterable_element.getUnitPrice());
				itemInformationgD.append(",");
				itemInformationgD.append(iterable_element.getTotalValue());
				itemInformationgD.append(",");
				itemInformationgD.append(iterable_element.getImportValue());
				itemInformationgD.append(")");
				itemInformationgD.append(",");
			}

			itemInformationgD.replace(itemInformationgD.length()-1, itemInformationgD.length(), "");
			String finInsUniqueNumber=null;;
			if(!"302".equalsIgnoreCase(gdE.getFinancialInfo().getModeOfPayment())) {
				finInsUniqueNumber= gdE.getFinancialInfo().getFinInsUniqueNumber() ;
			}
			else {
				if( gdE.getFinancialInfo().getFinInsUniqueNumber() !=null) {
					finInsUniqueNumber= gdE.getFinancialInfo().getFinInsUniqueNumber() ;
				}else {
					finInsUniqueNumber=null;
				}
			}
			importMasterGd=  str.execute(
					"INSERT INTO PSW_COBR_GDI (COBR_UNO, GDNO, GDSTS, CNMT_CAT, GDTYPE, COLLECTORATE, "
							+ "BL_AWB_NO, BL_AWB_DATE, VIR_AIR_NO, CC_NTNFTN, CC_STRN, CC_CNEE_NAME,"
							+ "CC_CNEE_ADDR,CC_CNOR_NAME,CC_CNOR_ADDR,FI_IMP_IBAN,FI_MOP,FI_UNO,FI_CCY,FI_INV_NO,FI_INV_DATE,FI_TOT_DECL_VAL,FI_DLVR_TERMS,FI_FOB_VAL_USD,"
							+ "FI_FREIGHT_USD,FI_CFR_VAL_USD,FI_INSURANCE_USD,FI_LNDG_CHGS_USD,FI_ASSD_VAL_USD,FI_OTHER_CHGS,FI_EXR,GI_NW,GI_GW,GI_POS,GI_PODLVR,GI_PODISCH,"
							+ "GI_TERM_LOC,GI_PKG_INFO,GI_CTRVHCL_INFO,ITEMS_INFO"
							+ ") VALUES(" + "'"
							+ wse00006ImportDto.getData().getCobUniqueIdNumber() + "','" 
							+gdE.getGdNumber() + "','" + gdE.getGdStatus() + "','"
							+gdE.getConsignmentCategory() + "','" + gdE.getGdType() + "','"
							+gdE.getCollectorate() + "','" + gdE.getBlAwbNumber() + "','"
							+gdE.getBlAwbDate() + "','" + gdE.getVirAirNumber() + "','"
							+gdE.getConsignorConsigneeInfo().getNtnFtn() + "','" +gdE.getConsignorConsigneeInfo().getStrn() + "','"
							+gdE.getConsignorConsigneeInfo().getConsigneeName() + "','" +gdE.getConsignorConsigneeInfo().getConsigneeAddress() + "','"
							+gdE.getConsignorConsigneeInfo().getConsignorName() + "','" +gdE.getConsignorConsigneeInfo().getConsignorAddress() + "','"

					+ gdE.getFinancialInfo().getImporterIban() + "' ,'" + gdE.getFinancialInfo().getModeOfPayment() + "' ,'" 
					+ finInsUniqueNumber + "' ,'" + gdE.getFinancialInfo().getCurrency() + "','"
					+ gdE.getFinancialInfo().getInvoiceNumber() + "','" +gdE.getFinancialInfo().getInvoiceDate() + "','" 
					+ gdE.getFinancialInfo().getTotalDeclaredValue() + "','" + gdE.getFinancialInfo().getDeliveryTerm() + "',"
					+gdE.getFinancialInfo().getFobValueUsd() + "," + gdE.getFinancialInfo().getFreightUsd() + ","
					+gdE.getFinancialInfo().getCfrValueUsd() + "," + gdE.getFinancialInfo().getInsuranceUsd() + ","
					+gdE.getFinancialInfo().getLandingChargesUsd() + "," + gdE.getFinancialInfo().getAssessedValueUsd() + ","
					+gdE.getFinancialInfo().getOtherCharges() + "," + gdE.getFinancialInfo().getExchangeRate() + ",'"

					+gdE.getGeneralInformation().getNetWeight() + "','" + gdE.getGeneralInformation().getGrossWeight() + "','"
					+gdE.getGeneralInformation().getPortOfShipment() + "','" + gdE.getGeneralInformation().getPortOfDelivery() + "','"
					+gdE.getGeneralInformation().getPortOfDischarge() + "','" + gdE.getGeneralInformation().getTerminalLocation() + "',"


					+ "COL_GDFIM_GI_PKGS("+packageInfoList+"),COL_GDFIM_GI_CTRVHCL("+containerVehicleInformationLst+"),COL_GDFIM_ITEMS("+itemInformationgD+"))"


					);
		}


		boolean importMasterBca=false;
		for (com.jwt.dto.request.wseWSE00006Import.BankAdviceInfo bcaE :  wse00006ImportDto.getData().getBankAdviceInfo()) {

			StringBuilder bacEGdNumber=new StringBuilder();
			bacEGdNumber.append("COL_FI_GDNO(");
			for (String iterable_element : bcaE.getGdNumber()) {
				bacEGdNumber.append("'");
				bacEGdNumber.append(iterable_element);
				bacEGdNumber.append("'");
				bacEGdNumber.append(",");
			}
			bacEGdNumber.replace(bacEGdNumber.length()-1, bacEGdNumber.length(), "");
			bacEGdNumber.append(")");
			importMasterBca= str.execute(
					"INSERT INTO PSW_COBR_BDAI (COBR_UNO,"
							+ "			BDA_UINO,"
							+ "			GD_INFO,"
							+ "			IMP_IBAN,"
							+ "			IMP_NTN,"
							+ "			IMP_NAME,"
							+ "			BDA_DATE,"
							+ "			MOIP,"
							+ "			FI_UNO,"
							+ "			BDAI_BDA_TAMT_FCY,"
							+ "			BDAI_TACCY,"
							+ "			BDAI_BDA_SAMT_FCY,"
							+ "			BDAI_SACCY,"
							+ "			BDAI_BDA_NAMT_FCY,"
							+ "			BDAI_NACCY,"
							+ "			BDAI_EXR_FCY,"
							+ "			BDAI_BDA_NAMT_LCY,"
							+ "			BDAI_BDA_NAMT_WRDS,"
							+ "			BDAID_CCY,"
							+ "			BDAID_EXR_FCY,"
							+ "			BDAID_BDA_AMT_FCY,"
							+ "			BDAID_BDA_AMT_LCY,"
							+ "			BDAID_DOC_REFNO,"
							+ "			BDAID_CAMT_FCY,"
							+ "			BDAID_CAMT_LCY,"
							+ "			BDAID_FED_FCY,"
							+ "			BDAID_FED_LCY,"
							+ "			BDAID_SCHRGS_LCY,"
							+ "			BDAID_OCHRGS_LCY,"
							+ "			BDAID_REMARKS,"
							+ "			BDAID_BDA_BAMT_FCY"
							+ ") VALUES(" + "'"
							+ wse00006ImportDto.getData().getCobUniqueIdNumber() + "','"+bcaE.getBdaUniqueIdNumber()+"',"+bacEGdNumber+",'" +bcaE.getIban()+"','"
							+bcaE.getImporterNtn() + "','"+bcaE.getImporterName()+"','"+bcaE.getBdaDate() + "','"
							+  bcaE.getModeOfPayment() + "','"+bcaE.getFinInsUniqueNumber()+"','"
							+bcaE.getBdaInformation().getTotalBdaAmountFcy() + "','"
							+ bcaE.getBdaInformation().getTotalBdaAmountCurrency() + "','"+bcaE.getBdaInformation().getSampleAmountExclude()+"','"+bcaE.getBdaInformation().getSampleAmountCurrency() + "','"
							+ bcaE.getBdaInformation().getNetBdaAmountFcy() + "','"+bcaE.getBdaInformation().getNetBdaAmountCurrency()+"','"+bcaE.getBdaInformation().getExchangeRateFiFcy() + "','"
							+ bcaE.getBdaInformation().getNetBdaAmountPkr() + "','"+bcaE.getBdaInformation().getAmountInWords()+"','"+bcaE.getBdaInformation().getCurrencyFcy() + "','"+bcaE.getBdaInformation().getExchangeRateFcy() + "','"
							+ bcaE.getBdaInformation().getBdaAmountFcy() + "','"+ bcaE.getBdaInformation().getBdaAmountPkr() + "','"+ bcaE.getBdaInformation().getBdaDocumentRefNumber() + "','"+ bcaE.getBdaInformation().getCommisionAmountFcy()+"','"
							+ bcaE.getBdaInformation().getCommisionAmountPkr() + "',"+ bcaE.getBdaInformation().getFedFcy() + ",'"+ bcaE.getBdaInformation().getFedAmountPkr() + "','"+ bcaE.getBdaInformation().getSwiftChargesPkr()+"','"
							+ bcaE.getBdaInformation().getOtherChargesPkr() + "','"+ bcaE.getBdaInformation().getRemarks() + "','"+ bcaE.getBdaInformation().getBalanceBdaAmountFcy() + "')"
					);
		}
		map.put("P_STS","S");
		map.put("P_WSSTS","200");
		map.put("P_STS_DESC","Change of bank request with GD and financial information received.");
		map.put("P_WSSTS_DESC","Change of bank request with GD and financial information received.");
		return map;

	}



	@Override
	public Map<String, Object> verifyRequest(PswRequest dto, String code, String requestType)
			throws SQLException { 
		//	Connection c = dataSource.getConnection();
		LocalDateTime to = LocalDateTime.now();
		String[] coffees = new String[]{"abc", "efg", "hij",
		"klm"};
		//	 java.sql.Array sqlArray=  c.createArrayOf("varchar", coffees);
		//	 Array a = new StubArray("varchar", coffees);
		SimpleJdbcCall jdbcCall = new
				SimpleJdbcCall(dataSource).withProcedureName("PSW_WSEPROC") ;
		jdbcCall.declareParameters(	
				new SqlParameter("P_REQTYPE", Types.VARCHAR),
				new SqlParameter("P_IBAN",	Types.VARCHAR), 
				new SqlParameter("P_EMAIL", Types.VARCHAR), 
				new	SqlParameter("P_MOBILE", Types.VARCHAR),
				new SqlParameter("P_NTN",	Types.VARCHAR), 
				new SqlParameter("P_GDNO", Types.VARCHAR), 
				new	SqlParameter("P_GDSTS", Types.VARCHAR),
				new SqlParameter("P_FI_UNO",	OracleTypes.ARRAY, "COL_FI_UNO"), 
				new SqlOutParameter("P_WSE00002",	OracleTypes.STRUCT, "OBJ_WSE00002",new SqlReturnType() {

					@Override
					public Object getTypeValue(CallableStatement cs, int paramIndex, int sqlType, String typeName) throws SQLException {
						java.sql.Struct  str=(java.sql.Struct)cs.getObject(paramIndex);
						Object []test = str.getAttributes();
						MsgMap map= new MsgMap();
						map.getData().put("Iban", (String)test[0]);
						map.getData().put("accountTitle", (String)test[1]);
						map.getData().put("accountStatus", (BigDecimal)test[3]);
						map.getData().put("accountType", convertArrayToArrayListString((Array)test[4]));
						map.getData().put("ntn", (String)test[5]);
						map.getData().put("cnic", (String)test[6]);
						map.getData().put("authorizedPaymentModesForImport", convertArrayToArrayListString( (Array)test[7]));
						map.getData().put("authorizedPaymentModesForExport", convertArrayToArrayListString( (Array)test[8]));

						return map;
					}
				}),

				new SqlOutParameter("P_WSSTS",	Types.VARCHAR), 
				new SqlOutParameter("P_WSSTS_DESC", Types.VARCHAR), 
				new	SqlOutParameter("P_STS", Types.VARCHAR), 
				new SqlOutParameter("P_STS_DESC",Types.VARCHAR));

		SqlParameterSource in = new MapSqlParameterSource(). addValue("P_REQTYPE",
				requestType). addValue("P_IBAN", dto.getData().get("iban").toString()).
				addValue("P_FI_UNO", new SqlArrayValue<String>(coffees)).
				addValue("P_GDNO", "234234" ).
				addValue("P_GDSTS", "s" ).
				addValue("P_EMAIL", null ).
				addValue("P_MOBILE",null).
				addValue("P_NTN", null);

		Map<String, Object> out = jdbcCall.execute(in); 

		return out; 
	}



	@Override
	public Map<String, Object> getForInActiveToken(StringBuilder token, String wsCat) throws SQLException {

		LocalDateTime to = LocalDateTime.now();

		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("PSW_WSTPROC");
		SqlParameterSource in = new MapSqlParameterSource().addValue("P_REQTYPE", "WSTV")
				.addValue("P_WSTVAL", token.toString()).addValue("P_WSTRESP_CODE", null).addValue("P_WST_EXPIRY", null)
				.addValue("P_WST_TYPE", null).addValue("P_REQCAT", "AD");
		Map<String, Object> out = jdbcCall.execute(in);

		return out;

	}
	List<BigDecimal> convertArrayToArrayListNumber(java.sql.Array array) throws SQLException{
		List<Object> d1=java.util.Arrays.asList(array.getArray());
		BigDecimal arr[] =(BigDecimal[]) d1.get(0) ;
		return Arrays.asList(arr);
	}

	List<String> convertArrayToArrayListString(java.sql.Array array) throws SQLException{
		List<Object> d1=java.util.Arrays.asList(array.getArray());
		String arr[] =(String[]) d1.get(0) ;
		return Arrays.asList(arr);
	}

















}
