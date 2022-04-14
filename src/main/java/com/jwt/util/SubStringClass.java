package com.jwt.util;

public class SubStringClass {
	public static void main(String[] args) {
		StringBuilder buf =new StringBuilder("{\"gdNumber\":\"KPPI-HC-86-08-07-2021\",\"consignmentCategory\":\"Commercial\",\"gdStatus\":\"03\",\"gdType\":\"Home Consumption\",\"collectorate\":\"Qasim International Container Terminal\",\"blAwbNumber\":\"BL-24923231\",\"blAwbDate\":\"20201012\",\"virAirNumber\":\"KEWB-0005-010112020\",\"consignorConsigneeInfo\":{\"ntnFtn\":\"0425425\",\"strn\":\"1700003019489\",\"consigneeName\":\"PSW\",\"consigneeAddress\":\"PECHS\",\"consignorName\":\"M/S. International Jute Traders\",\"consignorAddress\":\"95, MOTIJHEEL COMMERCIAL AREA (2ND FLOOR) BANGLADESH.\"},\"financialInfo\":{\"importerIban\":\"PK56MCIB1891002622870001\",\"modeOfPayment\":\"304\",\"finInsUniqueNumber\":\"MIB-IMP-000003-22062021\",\"currency\":\"USD\",\"invoiceNumber\":\"AS1234567\",\"invoiceDate\":\"20200223\",\"totalDeclaredValue\":5000.0002,\"deliveryTerm\":\"CFR\",\"fobValueUsd\":1,\"freightUsd\":1,\"cfrValueUsd\":1,\"insuranceUsd\":0,\"landingChargesUsd\":100,\"assessedValueUsd\":50,\"otherCharges\":0,\"exchangeRate\":158},\"generalInformation\":{\"packagesInformation\":[{\"numberOfPackages\":100,\"packageType\":\"Box\"},{\"numberOfPackages\":100,\"packageType\":\"BULK\"}],\"containerVehicleInformation\":[{\"containerOrTruckNumber\":\"ASF9999991\",\"sealNumber\":\"SL2674\",\"containerType\":\"20FT\"},{\"containerOrTruckNumber\":\"ASF9999992\",\"sealNumber\":\"SL2674\",\"containerType\":\"40FT\"}],\"netWeight\":\"1.89400 MT\",\"grossWeight\":\"1.11400 MT\",\"portOfShipment\":\"AUCHN\",\"portOfDelivery\":\"AUCHN\",\"portOfDischarge\":\"AUCHN\",\"terminalLocation\":\"Qasim International Container Terminal\"},\"itemInformation\":[{\"hsCode\":\"8446.1000\",\"quantity\":6,\"unitPrice\":20,\"totalValue\":120,\"importValue\":120,\"uom\":\"KG\"},{\"hsCode\":\"8446.1000\",\"quantity\":6,\"unitPrice\":20,\"totalValue\":120,\"importValue\":120,\"uom\":\"KG\"}]}");
		StringBuilder jsonvalue= new StringBuilder();
		StringBuilder value= new StringBuilder();
		StringBuilder changedValue= new StringBuilder();
		String fodValue="fobValueUsd";

		//S	String chr = buf.substring(buf.indexOf("fobValueUsd"),buf.lastIndexOf("fobValueUsd",buf.indexOf(",")));
		for (int i = buf.indexOf(fodValue)-1; true; i++) {
			if(buf.charAt(i)==',')
				break;
			System.out.println(buf.charAt(i));
			jsonvalue.append(buf.charAt(i));
			
		}
		System.out.println(jsonvalue);
		System.out.println(value);
		for(int j=jsonvalue.indexOf(":")+1;j<jsonvalue.length();j++) {
			
			value.append(jsonvalue.charAt(j));
		}
		System.out.println(jsonvalue);
		System.out.println(value);
	}
}
