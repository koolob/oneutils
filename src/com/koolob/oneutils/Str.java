package com.koolob.oneutils;

import java.net.URLEncoder;

public class Str {

	public static boolean isStartWith(String str,String[] matchs){
		for(String match : matchs){
			if(str.startsWith(match)){
				return true;
			}
		}
		return false;
	}
	
	public static String randomNum(int length){
		if(length > 18){
			int team = length/18;
			int tail = length%18;
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<team;i++){
				sb.append(randomNum(18));
			}
			sb.append(randomNum(tail));
			return sb.toString();
		}else{
			return (""+(long)((1+Math.random())*Math.pow(10, length))).substring(1);
		}
	}
	
	public static String urlEncode(String url){
		try {
			return URLEncoder.encode(url,G.character);
		} catch (Exception e) {
			return url;
		}
	}
}
