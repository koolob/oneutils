package com.koolob.oneutils;

import android.util.Log;

public class L {
	public static final int v = 0;
	public static final int d = 1;
	public static final int i = 2;
	public static final int w = 3;
	public static final int e = 4;
	private static int outputLevel = v;
	private static String tag = "";
	public static void setOutputLevel(int lvl){
		if(lvl > e || lvl < v){
			lvl = v;
		}
		outputLevel = lvl;
	}
	
	public static void v(String msg){
		if(outputLevel <= v){
			Log.v(tag, msg);
		}
	}
	
	public static void d(String msg){
		if(outputLevel <= d){
			Log.d(tag, msg);
		}
	}
	
	public static void i(String msg){
		if(outputLevel <= i){
			Log.i(tag, msg);
		}
	}
	
	public static void w(String msg){
		if(outputLevel <= w){
			Log.w(tag, msg);
		}
	}
	
	public static void e(String msg){
		if(outputLevel <= e){
			Log.e(tag, msg);
		}
	}
}
