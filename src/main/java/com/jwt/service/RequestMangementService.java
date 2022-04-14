package com.jwt.service;

import java.io.Serializable;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwt.dao.MessageDao;
import com.jwt.dao.RequestManagementDao;
import com.jwt.dto.request.ObjGd;
import com.jwt.dto.request.ObjW000005;
import com.jwt.dto.request.ObjW000007;
import com.jwt.dto.request.PswRequest;
import com.jwt.dto.request.wse00003.Wse00003Dto;
import com.jwt.dto.request.wse00004.Wse00004Dto;
import com.jwt.dto.request.wseWSE00006Export.WseWSE00006Export;
import com.jwt.dto.request.wseWSE00006Import.WseWSE00006Import;
import com.jwt.model.PswWsmsgs;

@Service
public class RequestMangementService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6203148822583737105L;


	@Autowired
	private RequestManagementDao requestDao;

	@Autowired
	MessageDao	 mesRepository;

	public
	Map<String, Object>  msg1VerifyIban(PswRequest dto, String code)	throws  SQLException{

		PswWsmsgs msg = getMsgId(dto.getProcessingCode());
		Map<String, Object> mapObj= requestDao.msg1VerifyIban(dto, code,msg.getMsgid(),null,null,null,new ObjW000005(), new ObjW000007());
		mapObj.put("Message_id", msg.getMsgid());
		return mapObj;
	}

	public
	Map<String, Object>  SharingofChangeofBankrequestwithADbyPSW(PswRequest dto, String code)	throws  SQLException{

		PswWsmsgs msg = getMsgId(dto.getProcessingCode());

		Map<String, Object> mapObj= requestDao.msg1VerifyIban(dto, code,msg.getMsgid(),null,null,null,new ObjW000005(dto.getData().get("cobUniqueIdNumber").toString(), dto.getData().get("tradeTranType").toString(), dto.getData().get("iban").toString(), dto.getData().get("traderNTN").toString(),dto.getData().get("traderName").toString(),
				dto.getData().get("finInsUniqueNumber").toString()), new ObjW000007());
		mapObj.put("Message_id", msg.getMsgid());
		return mapObj;
	}

	public
	Map<String, Object>  SharingofChangeofBankrequestapprovalOrRejectionMessageWithOldADbyPSW(PswRequest dto, String code)	throws  SQLException{

		PswWsmsgs msg = getMsgId(dto.getProcessingCode());

		Map<String, Object> mapObj= requestDao.msg1VerifyIban(dto, code,msg.getMsgid(),null,null,null,new ObjW000005(),new ObjW000007(dto.getData().get("cobUniqueIdNumber").toString(), dto.getData().get("tradeTranType").toString(), dto.getData().get("iban").toString(), dto.getData().get("traderNTN").toString(),dto.getData().get("traderName").toString(),
				dto.getData().get("finInsUniqueNumber").toString()/*,dto.getData().get("cobStatus").toString()*/));
		mapObj.put("Message_id", msg.getMsgid());
		return mapObj;
	}



	public	Map<String, Object>  getWSE00003Records(Wse00003Dto  dto, String code)	throws  SQLException, ClassNotFoundException{



		PswWsmsgs msg = getMsgId(dto.getProcessingCode());

		ObjGd str[] = new ObjGd[1];
		str[0]= new  ObjGd(dto.getData().getFinancialInfo().getModeOfPayment(),dto.getData().getFinancialInfo().getFinInsUniqueNumber());





		Map<String, Object> mapObjProc= requestDao.msg1VerifyIban(new PswRequest(), code,msg.getMsgid(),str,dto.getData().getGdNumber(),dto.getData().getGdStatus(), new ObjW000005(), new ObjW000007());
		if("200".equalsIgnoreCase((String) mapObjProc.get("P_WSSTS")) ){
			if("01".equalsIgnoreCase(dto.getData().getGdStatus())||"05".equalsIgnoreCase(dto.getData().getGdStatus())) {
				mapObjProc.put("Response_insert", requestDao.insertWSE00003Records(dto, code,msg.getMsgid()));
				mapObjProc.put("P_WSSTS_DESC", "Updated GD and financial information.");

			}

		}else {
			mapObjProc.put("Response_insert", false);

		}
		mapObjProc.put("Message_id", msg.getMsgid());
		return mapObjProc;
	}

	public	Map<String, Object>  getWSE00004Records(Wse00004Dto  dto, String code)	throws  SQLException, ClassNotFoundException{


		PswWsmsgs msg = getMsgId(dto.getProcessingCode());
		ObjGd str[] = new ObjGd[dto.getData().getFinancialInformation().getFinancialInstrument().size()];



		for (int i=0; i < dto.getData().getFinancialInformation().getFinancialInstrument().size(); i++) 
		{
			str[i]= new  ObjGd(dto.getData().getFinancialInformation().getFinancialInstrument().get(i).getModeOfPayment(),dto.getData().getFinancialInformation().getFinancialInstrument().get(i).getFinInsUniqueNumber());

		}


		Map<String, Object> mapObjProc= requestDao.msg1VerifyIban(new PswRequest(), code,msg.getMsgid(),str,dto.getData().getGdNumber(),dto.getData().getGdStatus(),new ObjW000005(), new ObjW000007());
		if("200".equalsIgnoreCase((String) mapObjProc.get("P_WSSTS")) ){
			if("01".equalsIgnoreCase(dto.getData().getGdStatus())||"05".equalsIgnoreCase(dto.getData().getGdStatus())) {
				mapObjProc.put("Response_insert", requestDao.getWSE00004Records(dto, code,msg.getMsgid()));
				mapObjProc.put("P_WSSTS_DESC", "Updated financial transaction data for import.");

			}

		}else {
			mapObjProc.put("Response_insert", false);

		}
		mapObjProc.put("Message_id", msg.getMsgid());
		return mapObjProc;

	}

	public	Map<String, Object>  getWSE00006ImportRecords(WseWSE00006Import  dto, String code)	throws  SQLException, ClassNotFoundException{


		PswWsmsgs msg = getMsgId(dto.getProcessingCode());

		Map<String, Object> mapObjProc= requestDao.getWSE00006ImportRecords(dto, code,msg.getMsgid());



		return mapObjProc;




	}

	public	Map<String, Object>  getWSE00006ExportRecords(WseWSE00006Export  dto, String code)	throws  SQLException, ClassNotFoundException{


		PswWsmsgs msg = getMsgId(dto.getProcessingCode());

		Map<String, Object> mapObjProc= requestDao.getWSE00006ExportRecords(dto, code,msg.getMsgid());


		return mapObjProc;




	}


	public	Map<String, Object>  verifyRequest(PswRequest  dto, String code)	throws  SQLException, ClassNotFoundException{

		Map<String, Object> mapObj= new HashMap<String, Object>();
		//	PswWsmsgs msg = getMsgId(dto.getProcessingCode());
		mapObj.put("Response From DB", requestDao.verifyRequest(dto, code,"WSE00001"));
		//	mapObj.put("Message_id", msg.getMsgid());
		return mapObj;
	}



	public
	Map<String, Object>  getForInActiveToken(StringBuilder token, String wsCat)	throws  SQLException{


		return requestDao.getForInActiveToken(token, wsCat);
	}

	public PswWsmsgs getMsgIdSubString(String processCode) 
	{
		List<PswWsmsgs> books = new ArrayList<PswWsmsgs>();
		mesRepository.findAll().forEach(books1 -> books.add(books1));
		Optional<PswWsmsgs> matchingObject = books.stream().
				filter(p -> p.getMethodCode().equals(processCode.substring(1, processCode.length()-1))).
				findFirst();	
		PswWsmsgs pswWsmsgsObj = matchingObject.get();
		return pswWsmsgsObj;
	}	
	public PswWsmsgs getMsgId(String processCode) 
	{
		List<PswWsmsgs> books = new ArrayList<PswWsmsgs>();
		mesRepository.findAll().forEach(books1 -> books.add(books1));
		Optional<PswWsmsgs> matchingObject = books.stream().
				filter(p -> p.getMethodCode().equals(processCode)).
				findFirst();	
		PswWsmsgs pswWsmsgsObj = matchingObject.get();
		return pswWsmsgsObj;
	}	

}
