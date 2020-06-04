package com.payeasy.la.factory;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;

@Component
public class AuthorizarionHeader {
	public String getAuthorizationString() {
		String plainCreds = "rzp_test_noTCk9GBfFxgt1:iRNJRDbT5JIDY475BoIzM86d";
		byte[] plainCredsBytes = plainCreds.getBytes();
		byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
		String base64Creds = new String(base64CredsBytes);
		
		return "Basic " + base64Creds;
	}
}
