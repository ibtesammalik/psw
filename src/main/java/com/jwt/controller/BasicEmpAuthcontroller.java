package com.jwt.controller;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jwt.config.Iconstants;
import com.jwt.dto.request.PswRequest;
import com.jwt.dto.request.wse00003.Wse00003Dto;
import com.jwt.dto.request.wse00004.Wse00004Dto;
import com.jwt.dto.request.wseWSE00006Export.WseWSE00006Export;
import com.jwt.dto.request.wseWSE00006Import.WseWSE00006Import;
import com.jwt.dto.response.Message;
import com.jwt.dto.response.MsgMap;
import com.jwt.dto.response.PswResponse;
import com.jwt.dto.response.ResponseUnauthorize;
import com.jwt.dto.response.ResponseViewMessage;
import com.jwt.model.PswWsmsgs;
import com.jwt.model.PswWsmsgsRrlog;
import com.jwt.service.RequestMangementService;
import com.jwt.service.TokenMangementService;
import com.jwt.service.saveRequestService;

@RequestMapping("/api/dealers/mcib")
@RestController
public class BasicEmpAuthcontroller {

	@Autowired
	private RequestMangementService reqService;

	@Autowired
	private saveRequestService saveService;

	@Autowired
	private TokenMangementService tokenService;


	// public void process(@RequestBody com.fasterxml.jackson.databind.JsonNode payload) {
	//https://stackoverflow.com/questions/29313687/trying-to-use-spring-boot-rest-to-read-json-string-from-post
	@PostMapping(value= "/edi", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> emmp(@RequestHeader HttpHeaders headers, @RequestBody String jsonBody) {	
		try {
			Gson gson=new Gson();
			JsonObject jsonObject =  gson.fromJson(jsonBody, JsonObject.class);
			PswWsmsgs msg =reqService.getMsgIdSubString(jsonObject.get("processingCode").toString());
			saveService.saveResMsg(new PswWsmsgsRrlog(msg.getMsgid(), jsonObject.toString(),  null, new Date()));
		    System.out.println("DataBlock: "+jsonObject.get("data").toString());
			PswRequest verificationIban = gson.fromJson(jsonObject, PswRequest.class);  
		//	new ObjectMapper().writeValueAsString(verificationIban.getData());
			if( headers.get("Authorization")!=null&&(headers.get("Authorization").toString().substring(1,7).equalsIgnoreCase("Bearer")) ) {
				String bearer=headers.get("Authorization").toString().substring(1,7);
				String token=headers.get("Authorization").toString().replace("["+bearer+" ", "");
				token=token.replace("]", "");
				Map<String, Object> outtoken =tokenService.getForInActiveToken(new StringBuilder(token), "AD");
			//	Map<String, Object> test= new HashMap<String, Object>();test.put("", "");
				if("S".equalsIgnoreCase((String) outtoken.get("P_WSTSTS"))) {
					Object response="No Processing Code Defined";
					if(verifySignatory(jsonObject.get("data").toString(),verificationIban.getSignature())) {

						switch (verificationIban.getProcessingCode()) {
						case "301":	
							response=	VerNtnIbanEmailAddressMoblieNoM1(verificationIban);
							break;
						case "302":
							response=	getAccountDetailsAuthorizedPaymentModesM2(verificationIban);
							break;
						case "101":
							response=	getWSE00003Records(verificationIban);
							break;
						case "102":
							response=	getWSE00004Records(verificationIban);
							break;
						case "307":
							response=	getWSE00006Records(verificationIban);
							break;
						case "306":
							response=	SharingofChangeofBankrequestwithADbyPSWM5(verificationIban);
							break;
						case "308":
							response=	SharingofChangeofBankrequestapprovalOrRejectionMessageWithOldADbyPSW(verificationIban);
							break;

						default:

						}
					}
					else {
						response=	new ResponseViewMessage(verificationIban.getMessageId().toString(),
								new SimpleDateFormat("yyyymmddhhmmss").format(new Date()), Iconstants.BANK_MNEMONIC,Iconstants.PSW_MNEMONIC,
								verificationIban.getProcessingCode(),new  Message(Iconstants.ResponseCode.get("701").getCode(),Iconstants.ResponseCode.get("701").getStatusMessage()));
						saveService.saveReqResMsg(new PswWsmsgsRrlog(msg.getMsgid(), null,  new ObjectMapper().writeValueAsString(response), new Date()));



					}

					return  ResponseEntity
							.status(HttpStatus.OK)
							.contentType(MediaType.APPLICATION_JSON_UTF8)
							.body(response);


				}
				else {
					return  ResponseEntity
							.status(HttpStatus.UNAUTHORIZED)
							.contentType(MediaType.APPLICATION_JSON_UTF8)
							.body(new ResponseUnauthorize(LocalDateTime.now(),"401","Unauthorized",outtoken.get("P_WSTSTS_DESC").toString(),"/connect"));
				}
			}

			else {


				ResponseUnauthorize code=	new ResponseUnauthorize(LocalDateTime.now(),"401","Unauthorized","Unauthorized","/connect");
				return ResponseEntity
						.status(HttpStatus.UNAUTHORIZED)
						.contentType(MediaType.APPLICATION_JSON_UTF8)
						.body(code);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<String>("BadRequest", HttpStatus.BAD_REQUEST);
		}
	}



	private Object VerNtnIbanEmailAddressMoblieNoM1(PswRequest verificationIban) throws Exception {

		ObjectMapper mapper = new ObjectMapper();
	//	if(verifySignatory(new ObjectMapper().writeValueAsString(verificationIban.getData()),verificationIban.getSignature())) {

			Map<String, Object> out =reqService.msg1VerifyIban(verificationIban, "AD");

			MessageDigest digest;

			digest = MessageDigest.getInstance("SHA-256");



			String json = mapper.writeValueAsString(new HashMap<String, Object>()  );
			byte[] hash = digest.digest(json.getBytes(StandardCharsets.UTF_8));
			String encoded = Base64.getEncoder().encodeToString(hash);

			PswResponse response = new  PswResponse(verificationIban.getMessageId().toString(), 
					new SimpleDateFormat("yyyymmddhhmmss").format(new Date()), Iconstants.BANK_MNEMONIC,Iconstants.PSW_MNEMONIC,
					verificationIban.getProcessingCode(), encoded, new Message(out.get("P_WSSTS").toString(),out.get("P_WSSTS_DESC").toString()), new HashMap<String, Object>()  );

			saveService.saveReqResMsg(new PswWsmsgsRrlog(out.get("Message_id").toString(), mapper.writeValueAsString(verificationIban),  mapper.writeValueAsString(response), new Date()));
			return  response;

//		}
//
//		else {
//
//			ResponseViewMessage response=	new ResponseViewMessage(verificationIban.getMessageId().toString(),
//					new SimpleDateFormat("yyyymmddhhmmss").format(new Date()), Iconstants.BANK_MNEMONIC,Iconstants.PSW_MNEMONIC,
//					verificationIban.getProcessingCode(),new  Message(Iconstants.ResponseCode.get("701").getCode(),Iconstants.ResponseCode.get("701").getStatusMessage()));
//			PswWsmsgs msg =reqService.getMsgId(verificationIban.getProcessingCode());
//			saveService.saveReqResMsg(new PswWsmsgsRrlog(msg.getMsgid(), mapper.writeValueAsString(verificationIban),  mapper.writeValueAsString(response), new Date()));
//
//
//			return response;
//		}


	}

	private Object getAccountDetailsAuthorizedPaymentModesM2(PswRequest Iban) throws Exception {

		ObjectMapper mapper = new ObjectMapper();
	//	if(verifySignatory(new ObjectMapper().writeValueAsString(Iban.getData()),Iban.getSignature())) {

			Map<String, Object> out =reqService.msg1VerifyIban(Iban, "AD");


			MessageDigest digest;

			digest = MessageDigest.getInstance("SHA-256");

			MsgMap mapObj=	(MsgMap) out.get("P_WSE00002");
			String json = mapper.writeValueAsString(new HashMap<String, Object>()  );
			if("200".equalsIgnoreCase(out.get("P_WSSTS").toString())) {
				json = mapper.writeValueAsString(mapObj.getData() );
			}
			else {
				mapObj.setData(new HashMap<String, Object>() );
			}


			byte[] hash = digest.digest(json.getBytes(StandardCharsets.UTF_8));
			String encoded = Base64.getEncoder().encodeToString(hash);

			PswResponse response = new  PswResponse(Iban.getMessageId().toString(), 
					new SimpleDateFormat("yyyymmddhhmmss").format(new Date()), Iconstants.BANK_MNEMONIC,Iconstants.PSW_MNEMONIC,
					Iban.getProcessingCode(), encoded, new Message(out.get("P_WSSTS").toString(),out.get("P_WSSTS_DESC").toString()),mapObj.getData()   );

			saveService.saveReqResMsg(new PswWsmsgsRrlog(out.get("Message_id").toString(), mapper.writeValueAsString(Iban),  mapper.writeValueAsString(response), new Date()));
			return  response;

//		}

//		else {
//
//			ResponseViewMessage response=	new ResponseViewMessage(Iban.getMessageId().toString(),
//					new SimpleDateFormat("yyyymmddhhmmss").format(new Date()), Iconstants.BANK_MNEMONIC,Iconstants.PSW_MNEMONIC,
//					Iban.getProcessingCode(),new  Message(Iconstants.ResponseCode.get("701").getCode(),Iconstants.ResponseCode.get("701").getStatusMessage()));
//			PswWsmsgs msg =reqService.getMsgId(Iban.getProcessingCode());
//			saveService.saveReqResMsg(new PswWsmsgsRrlog(msg.getMsgid(), mapper.writeValueAsString(Iban),  mapper.writeValueAsString(response), new Date()));
//
//
//			return response;
//		}


	}

	private Object SharingofChangeofBankrequestwithADbyPSWM5(PswRequest Iban) throws Exception {

		ObjectMapper mapper = new ObjectMapper();
	//	if(verifySignatory(new ObjectMapper().writeValueAsString(Iban.getData()),Iban.getSignature())) {

			Map<String, Object> out =reqService.SharingofChangeofBankrequestwithADbyPSW(Iban, "AD");


			MessageDigest digest;

			digest = MessageDigest.getInstance("SHA-256");

			MsgMap mapObj=	(MsgMap) out.get("P_WSE00005");
			String json=null;
			if(mapObj==null) {
				mapObj= new MsgMap(new HashMap<String, Object>());
				mapObj.setData(new HashMap<String, Object>());
			}
			PswResponse response=null;
			if("S".equalsIgnoreCase(out.get("P_STS").toString())) {
				if("200".equalsIgnoreCase(out.get("P_WSSTS").toString())) {
					json = mapper.writeValueAsString(mapObj.getData() );

				}
				else {
					json = mapper.writeValueAsString(new HashMap<String, Object>() );
				}
				byte[] hash = digest.digest(json.getBytes(StandardCharsets.UTF_8));
				String encoded = Base64.getEncoder().encodeToString(hash);
				response = new  PswResponse(Iban.getMessageId().toString(), 
						new SimpleDateFormat("yyyymmddhhmmss").format(new Date()), Iconstants.BANK_MNEMONIC,Iconstants.PSW_MNEMONIC,
						Iban.getProcessingCode(), encoded, new Message(out.get("P_WSSTS").toString(),out.get("P_WSSTS_DESC").toString()),new HashMap<String, Object>()   );
			}
			else {

				byte[] hash = digest.digest(json.getBytes(StandardCharsets.UTF_8));
				String encoded = Base64.getEncoder().encodeToString(hash);
				response = new  PswResponse(Iban.getMessageId().toString(), 
						new SimpleDateFormat("yyyymmddhhmmss").format(new Date()), Iconstants.BANK_MNEMONIC,Iconstants.PSW_MNEMONIC,
						Iban.getProcessingCode(), encoded, new Message(out.get("P_STS").toString(),out.get("P_STS_DESC").toString()),new HashMap<String, Object>()   );

			}

			saveService.saveReqResMsg(new PswWsmsgsRrlog(out.get("Message_id").toString(), mapper.writeValueAsString(Iban),  mapper.writeValueAsString(response), new Date()));
			return  response;

//		}
//
//		else {
//
//			ResponseViewMessage response=	new ResponseViewMessage(Iban.getMessageId().toString(),
//					new SimpleDateFormat("yyyymmddhhmmss").format(new Date()), Iconstants.BANK_MNEMONIC,Iconstants.PSW_MNEMONIC,
//					Iban.getProcessingCode(),new  Message(Iconstants.ResponseCode.get("701").getCode(),Iconstants.ResponseCode.get("701").getStatusMessage()));
//			PswWsmsgs msg =reqService.getMsgId(Iban.getProcessingCode());
//			saveService.saveReqResMsg(new PswWsmsgsRrlog(msg.getMsgid(), mapper.writeValueAsString(Iban),  mapper.writeValueAsString(response), new Date()));
//
//
//			return response;
//		}


	}

	private Object SharingofChangeofBankrequestapprovalOrRejectionMessageWithOldADbyPSW(PswRequest Iban) throws Exception {

		ObjectMapper mapper = new ObjectMapper();
	//	if(verifySignatory(new ObjectMapper().writeValueAsString(Iban.getData()),Iban.getSignature())) {

			Map<String, Object> out =reqService.SharingofChangeofBankrequestapprovalOrRejectionMessageWithOldADbyPSW(Iban, "AD");


			MessageDigest digest;

			digest = MessageDigest.getInstance("SHA-256");

			MsgMap mapObj=	(MsgMap) out.get("P_WSE00007");
			String json=null;
			if(mapObj==null) {
				mapObj= new MsgMap(new HashMap<String, Object>());
				mapObj.setData(new HashMap<String, Object>());
			}
			PswResponse response=null;
			if("S".equalsIgnoreCase(out.get("P_STS").toString())) {
				if("200".equalsIgnoreCase(out.get("P_WSSTS").toString())) {
					json = mapper.writeValueAsString(mapObj.getData() );

				}
				byte[] hash = digest.digest(json.getBytes(StandardCharsets.UTF_8));
				String encoded = Base64.getEncoder().encodeToString(hash);
				response = new  PswResponse(Iban.getMessageId().toString(), 
						new SimpleDateFormat("yyyymmddhhmmss").format(new Date()), Iconstants.BANK_MNEMONIC,Iconstants.PSW_MNEMONIC,
						Iban.getProcessingCode(), encoded, new Message(out.get("P_WSSTS").toString(),out.get("P_WSSTS_DESC").toString()),new HashMap<String, Object>()   );
			}
			else {

				byte[] hash = digest.digest(json.getBytes(StandardCharsets.UTF_8));
				String encoded = Base64.getEncoder().encodeToString(hash);
				response = new  PswResponse(Iban.getMessageId().toString(), 
						new SimpleDateFormat("yyyymmddhhmmss").format(new Date()), Iconstants.BANK_MNEMONIC,Iconstants.PSW_MNEMONIC,
						Iban.getProcessingCode(), encoded, new Message(out.get("P_STS").toString(),out.get("P_STS_DESC").toString()),new HashMap<String, Object>()   );

			}
			saveService.saveReqResMsg(new PswWsmsgsRrlog(out.get("Message_id").toString(), mapper.writeValueAsString(Iban),  mapper.writeValueAsString(response), new Date()));
			return  response;

//		}
//
//		else {
//
//			ResponseViewMessage response=	new ResponseViewMessage(Iban.getMessageId().toString(),
//					new SimpleDateFormat("yyyymmddhhmmss").format(new Date()), Iconstants.BANK_MNEMONIC,Iconstants.PSW_MNEMONIC,
//					Iban.getProcessingCode(),new  Message(Iconstants.ResponseCode.get("701").getCode(),Iconstants.ResponseCode.get("701").getStatusMessage()));
//			PswWsmsgs msg =reqService.getMsgId(Iban.getProcessingCode());
//			saveService.saveReqResMsg(new PswWsmsgsRrlog(msg.getMsgid(), mapper.writeValueAsString(Iban),  mapper.writeValueAsString(response), new Date()));
//
//
//			return response;
//		}


	}

	/**
	 * Sharing of GD and Financial Information with AD by PSW - Imports
	 * @param pswRequest
	 * @return
	 * @throws Exception
	 */
	private Object getWSE00003Records(PswRequest pswRequest) throws Exception {



		ObjectMapper mapper = new ObjectMapper();


		ObjectMapper om = new ObjectMapper();
		Wse00003Dto wse00003Dto = om.readValue(new ObjectMapper().writeValueAsString(pswRequest), Wse00003Dto.class); 


		System.out.println("Wse0003 GD Shre :   "+mapper.writeValueAsString(pswRequest));

	//	if(verifySignatory(new ObjectMapper().writeValueAsString(wse00003Dto.getData()),pswRequest.getSignature())) {

			Map<String, Object> out =reqService.getWSE00003Records(wse00003Dto, "AD");


			MessageDigest digest;

			digest = MessageDigest.getInstance("SHA-256");

			String json = mapper.writeValueAsString(new HashMap<String, Object>() );
			byte[] hash = digest.digest(json.getBytes(StandardCharsets.UTF_8));
			String encoded = Base64.getEncoder().encodeToString(hash);

			PswResponse response = new  PswResponse(pswRequest.getMessageId().toString(), 
					new SimpleDateFormat("yyyymmddhhmmss").format(new Date()), Iconstants.BANK_MNEMONIC,Iconstants.PSW_MNEMONIC,
					pswRequest.getProcessingCode(), encoded, new Message(out.get("P_WSSTS").toString(),out.get("P_WSSTS_DESC").toString()),new HashMap<String, Object>()   );

			saveService.saveReqResMsg(new PswWsmsgsRrlog(out.get("Message_id").toString(), mapper.writeValueAsString(pswRequest),  mapper.writeValueAsString(response), new Date()));
			return  response;

//		}
//
//		else {
//
//			ResponseViewMessage response=	new ResponseViewMessage(pswRequest.getMessageId().toString(),
//					new SimpleDateFormat("yyyymmddhhmmss").format(new Date()), Iconstants.BANK_MNEMONIC,Iconstants.PSW_MNEMONIC,
//					pswRequest.getProcessingCode(),new  Message(Iconstants.ResponseCode.get("701").getCode(),Iconstants.ResponseCode.get("701").getStatusMessage()));
//			PswWsmsgs msg =reqService.getMsgId(pswRequest.getProcessingCode());
//			saveService.saveReqResMsg(new PswWsmsgsRrlog(msg.getMsgid(), mapper.writeValueAsString(pswRequest),  mapper.writeValueAsString(response), new Date()));
//
//
//			return response;
//		}


	}




	private Object getWSE00004Records(PswRequest pswRequest) throws Exception {

		ObjectMapper mapper = new ObjectMapper();

		ObjectMapper om = new ObjectMapper();
		Wse00004Dto wse00004Dto = om.readValue(new ObjectMapper().writeValueAsString(pswRequest), Wse00004Dto.class); 

	//	if(verifySignatory(new ObjectMapper().writeValueAsString(wse00004Dto.getData()),pswRequest.getSignature())) {

			Map<String, Object> out =reqService.getWSE00004Records(wse00004Dto, "AD");


			MessageDigest digest;

			digest = MessageDigest.getInstance("SHA-256");

			String json = mapper.writeValueAsString(new HashMap<String, Object>() );

			byte[] hash = digest.digest(json.getBytes(StandardCharsets.UTF_8));
			String encoded = Base64.getEncoder().encodeToString(hash);

			PswResponse response = new  PswResponse(pswRequest.getMessageId().toString(), 
					new SimpleDateFormat("yyyymmddhhmmss").format(new Date()), Iconstants.BANK_MNEMONIC,Iconstants.PSW_MNEMONIC,
					pswRequest.getProcessingCode(), encoded, new Message(out.get("P_WSSTS").toString(),out.get("P_WSSTS_DESC").toString()),new HashMap<String, Object>()  );


			saveService.saveReqResMsg(new PswWsmsgsRrlog(out.get("Message_id").toString(), mapper.writeValueAsString(pswRequest),  mapper.writeValueAsString(response), new Date()));
			return  response;

//		}
//
//		else {
//
//			ResponseViewMessage response=	new ResponseViewMessage(pswRequest.getMessageId().toString(),
//					new SimpleDateFormat("yyyymmddhhmmss").format(new Date()), Iconstants.BANK_MNEMONIC,Iconstants.PSW_MNEMONIC,
//					pswRequest.getProcessingCode(),new  Message(Iconstants.ResponseCode.get("701").getCode(),Iconstants.ResponseCode.get("701").getStatusMessage()));
//			PswWsmsgs msg =reqService.getMsgId(pswRequest.getProcessingCode());
//			saveService.saveReqResMsg(new PswWsmsgsRrlog(msg.getMsgid(), mapper.writeValueAsString(pswRequest),  mapper.writeValueAsString(response), new Date()));
//
//
//			return response;
//		}


	}

	private Object getWSE00006Records(PswRequest pswRequest) {

		PswResponse pswResponse=null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			PswWsmsgs msg =reqService.getMsgId(pswRequest.getProcessingCode());
	//		if(verifySignatory(new ObjectMapper().writeValueAsString(pswRequest.getData()),pswRequest.getSignature())) {

				Map<String, Object> out= new HashMap<String, Object>();
				if("01".equalsIgnoreCase((String)pswRequest.getData().get("tradeTranType"))) {  //01 for import
					WseWSE00006Import wsImport = mapper.readValue(new ObjectMapper().writeValueAsString(pswRequest), WseWSE00006Import.class); 
					out =reqService.getWSE00006ImportRecords(wsImport, "AD");
				}
				else if("02".equalsIgnoreCase((String)pswRequest.getData().get("tradeTranType"))) {  //02 for export {
					WseWSE00006Export wsExport = mapper.readValue(new ObjectMapper().writeValueAsString(pswRequest), WseWSE00006Export.class); 
					out =reqService.getWSE00006ExportRecords(wsExport, "AD");
				}

				MessageDigest digest;

				digest = MessageDigest.getInstance("SHA-256");

				MsgMap mapObj=	(MsgMap) out.get("P_WSE00006");
				String json=null;
				if(mapObj==null) {
					mapObj= new MsgMap(new HashMap<String, Object>());
					mapObj.setData(new HashMap<String, Object>());
				}if("S".equalsIgnoreCase(out.get("P_STS").toString())) {
					if("200".equalsIgnoreCase(out.get("P_WSSTS").toString())) {
						json = mapper.writeValueAsString(mapObj.getData() );

					}
					byte[] hash = digest.digest(json.getBytes(StandardCharsets.UTF_8));
					String encoded = Base64.getEncoder().encodeToString(hash);
					pswResponse = new  PswResponse(pswRequest.getMessageId().toString(), 
							new SimpleDateFormat("yyyymmddhhmmss").format(new Date()), Iconstants.BANK_MNEMONIC,Iconstants.PSW_MNEMONIC,
							pswRequest.getProcessingCode(), encoded, new Message(out.get("P_WSSTS").toString(),out.get("P_WSSTS_DESC").toString()),new HashMap<String, Object>()   );
				}
				else {

					byte[] hash = digest.digest(json.getBytes(StandardCharsets.UTF_8));
					String encoded = Base64.getEncoder().encodeToString(hash);
					pswResponse = new  PswResponse(pswRequest.getMessageId().toString(), 
							new SimpleDateFormat("yyyymmddhhmmss").format(new Date()), Iconstants.BANK_MNEMONIC,Iconstants.PSW_MNEMONIC,
							pswRequest.getProcessingCode(), encoded, new Message(out.get("P_STS").toString(),out.get("P_STS_DESC").toString()),new HashMap<String, Object>()   );

				}
				saveService.saveReqResMsg(new PswWsmsgsRrlog(msg.getMsgid(), mapper.writeValueAsString(pswRequest),  mapper.writeValueAsString(pswResponse), new Date()));

				return  pswResponse;

//			}
//
//			else {
//
//				ResponseViewMessage response=	new ResponseViewMessage(pswRequest.getMessageId().toString(),
//						new SimpleDateFormat("yyyymmddhhmmss").format(new Date()), Iconstants.BANK_MNEMONIC,Iconstants.PSW_MNEMONIC,
//						pswRequest.getProcessingCode(),new  Message(Iconstants.ResponseCode.get("701").getCode(),Iconstants.ResponseCode.get("701").getStatusMessage()));
//
//				saveService.saveReqResMsg(new PswWsmsgsRrlog(msg.getMsgid(), mapper.writeValueAsString(pswRequest),  mapper.writeValueAsString(response), new Date()));
//
//
//				return response;
//			}

		}
		catch (Exception e) {
			ResponseViewMessage response;PswWsmsgs msg =reqService.getMsgId(pswRequest.getProcessingCode());
			StringBuilder message=new StringBuilder("Please contact Administrator");
			if( e.getLocalizedMessage().contains("unique constraint")) {
				message= new StringBuilder("Record Already Exist Please Contact Administrator.");
			}
			response=	new ResponseViewMessage(pswRequest.getMessageId().toString(),
					new SimpleDateFormat("yyyymmddhhmmss").format(new Date()), Iconstants.BANK_MNEMONIC,Iconstants.PSW_MNEMONIC,
					pswRequest.getProcessingCode(),new  Message(Iconstants.ResponseCode.get("701").getCode(),message.toString()));


			try {
				saveService.saveReqResMsg(new PswWsmsgsRrlog(msg.getMsgid(), mapper.writeValueAsString(pswRequest),  mapper.writeValueAsString(response), new Date()));
			} catch (Exception e1) {
				e1.printStackTrace();
			}




			response=	new ResponseViewMessage(pswRequest.getMessageId().toString(),
					new SimpleDateFormat("yyyymmddhhmmss").format(new Date()), Iconstants.BANK_MNEMONIC,Iconstants.PSW_MNEMONIC,
					pswRequest.getProcessingCode(),new  Message(Iconstants.ResponseCode.get("701").getCode(),message.toString()));
			e.printStackTrace();
			return response;
		}

	}

	/**
	 * 
	 * @param json (JSON Actual String)
	 * @param signature (Signature In JSON)
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	private boolean verifySignatory(String json , String signature) throws NoSuchAlgorithmException {
		MessageDigest digest;

		digest = MessageDigest.getInstance("SHA-256");


		byte[] hash = digest.digest(json.getBytes(StandardCharsets.UTF_8));
		String encoded = Base64.getEncoder().encodeToString(hash);
		System.out.println("Encoded Signature :"+encoded);
		System.out.println("Actual Signature :"+signature);
		if(signature.equals(encoded)) 
			return true;
		else
			return false;

	}
	private int startIndex(String jsonString) {
		StringBuilder str= new StringBuilder();
		for (int i = jsonString.indexOf("data"); i < jsonString.length(); i++) {
			str.append(jsonString.charAt(i));
			if(jsonString.charAt(i)=='{') {
				return i;
			}

		}
		return 0;
	}

	private int endIndex(String jsonString) {
		StringBuilder str= new StringBuilder();
		for (int i = jsonString.indexOf("signature"); i > 0; i--) {
			str.append(jsonString.charAt(i));
			if(jsonString.charAt(i)=='}') {
				return i;
			}

		}
		return 0;
	}
	private  String simplify(String json) {
	    Gson gson = new GsonBuilder().create();

	    JsonElement el = new JsonParser().parse(json);
	    return gson.toJson(el);
	}
}