package com.koolob.oneutils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 这是一个存储临时数据的地方
 * @author dong
 *
 */
public class Mem {

	private static Map<String,Object> memory = new HashMap<String,Object>();
	
	public static String save(Object v){
		String k = UUID.randomUUID().toString();
		return save(k,v);
	}

	public static String save(String k,Object v){
		memory.put(k, v);
		return k;
	}

	public static Object load(String k){
		return memory.containsKey(k) ? memory.get(k) : null;
	}

}
