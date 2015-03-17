package com.koolob.oneutils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import android.util.Base64;

/**
 * 加密类
 * @author dong
 *
 */
public class Sec {

	public static String base64_encode(String str){
		return Base64.encodeToString(str.getBytes(), Base64.NO_WRAP);
	}

	public static String base64_decode(String str){
		return new String(Base64.decode(str, Base64.NO_WRAP));
	}
	
	public static String MD5(String base){
		byte[] hash;
	    try {
	        hash = MessageDigest.getInstance("MD5").digest(base.getBytes("UTF-8"));
	    } catch (NoSuchAlgorithmException e) {
	        throw new RuntimeException("Huh, MD5 should be supported?", e);
	    } catch (UnsupportedEncodingException e) {
	        throw new RuntimeException("Huh, UTF-8 should be supported?", e);
	    }
	    StringBuilder hex = new StringBuilder(hash.length * 2);
	    for (byte b : hash) {
	        if ((b & 0xFF) < 0x10) hex.append("0");
	        hex.append(Integer.toHexString(b & 0xFF));
	    }
	    return hex.toString();
	}
}
