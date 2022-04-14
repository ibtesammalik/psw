package com.jwt.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class HashSignature {

	private static boolean verifySignatory(String json) throws NoSuchAlgorithmException {
		MessageDigest digest;

		digest = MessageDigest.getInstance("SHA-256");


		
		byte[] hash = digest.digest(json.getBytes(StandardCharsets.UTF_8));
		String encoded = Base64.getEncoder().encodeToString(hash);
		System.out.println(encoded);
		return true;

	}
	
		
	public static void main(String[] args) {
		String json="{\"gdNumber\":\"KPPI-HC-11-15-07-2021\",\"gdStatus\":\"01\",\"consignmentCategory\":\"Commercial\",\"gdType\":\"Home Consumption\",\"collectorate\":\"Qasim International Container Terminal\",\"blAwbNumber\":\"BL-24923231\",\"blAwbDate\":\"20210922\",\"virAirNumber\":\"KEWB-0005-010112020\",\"consignorConsigneeInfo\":{\"ntnFtn\":\"0425425\",\"strn\":\"1700003019489\",\"consigneeName\":\"PSW\",\"consigneeAddress\":\"PECHS\",\"consignorName\":\"M/S. International Jute Traders\",\"consignorAddress\":\"95, MOTIJHEEL COMMERCIAL AREA (2ND FLOOR) BANGLADESH.\"},\"financialInfo\":{\"importerIban\":\"PK35MCIB0021000194940001\",\"modeOfPayment\":\"Letter of Credit\",\"finInsUniqueNumber\":\"MIB-IMP-000002-22062021\",\"currency\":\"USD\",\"invoiceNumber\":\"AS1234567\",\"invoiceDate\":\"20200223\",\"totalDeclaredValue\":5000.0002,\"deliveryTerm\":\"CFR\",\"fobValueUsd\":1,\"freightUsd\":1,\"cfrValueUsd\":1,\"insuranceUsd\":0,\"landingChargesUsd\":100,\"assessedValueUsd\":50,\"otherCharges\":0,\"exchangeRate\":158},\"generalInformation\":{\"packagesInformation\":[{\"numberOfPackages\":100,\"packageType\":\"Box\"},{\"numberOfPackages\":100,\"packageType\":\"Pallete\"}],\"containerVehicleInformation\":[{\"containerOrTruckNumber\":\"ASF9999991\",\"sealNumber\":\"SL2674\",\"containerType\":\"20FT\"},{\"containerOrTruckNumber\":\"ASF9999992\",\"sealNumber\":\"SL2674\",\"containerType\":\"40FT\"}],\"netWeight\":\"1.89400 MT\",\"grossWeight\":\"1.11400 MT\",\"portOfShipment\":\"CHN\",\"portOfDelivery\":\"DAV\",\"portOfDischarge\":\"DAV\",\"terminalLocation\":\"Qasim International Container Terminal\"},\"itemInformation\":[{\"hsCode\":\"8446.1000\",\"quantity\":6,\"unitPrice\":20,\"totalValue\":120,\"importValue\":120,\"uom\":\"KG\"},{\"hsCode\":\"9246.1000\",\"quantity\":6,\"unitPrice\":20,\"totalValue\":120,\"importValue\":120,\"uom\":\"KG\"}],\"negativeList\":{\"country\":\"AUS\",\"supplier\":\"M/S. International Jute Traders\",\"commodities\":[\"0402.1000\",\"0402.2000\"]}}";
		try {
			verifySignatory(json);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
