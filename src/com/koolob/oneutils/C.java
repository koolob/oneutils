package com.koolob.oneutils;

import java.io.File;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
/**
 * 通用工具类
 * @author dong
 *
 */
public class C {

	/**
	 * 检查传入的参数中是否有空的存在
	 * @param objects
	 * @return
	 */
	public static boolean checkNull(Object... objects) {
		for(Object o : objects){
			if(o == null){
				return true;
			}
			if(o instanceof String && ((String) o).trim().equals("")){
				return true;
			}
			if(o instanceof File && !((File) o).exists()){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * dip转px
	 * @param context
	 * @param dpValue
	 * @return
	 */
	public static int dip2px(Context context, float dpValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}

	/**
	 * px转dip
	 * @param context
	 * @param pxValue
	 * @return
	 */
	public static int px2dip(Context context, float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}
	
	public static void exitWithError(String error){
		throw new RuntimeException(error);
	}
	
	/**
	 * 使用系统浏览器打开网页
	 * @param url
	 * @param c
	 */
	public static void redirectToBrower(String url,Context c){
		Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url)); 
		c.startActivity(i);
	}
	
	/**
	 * 一个计数器
	 * @author dong
	 */
	public static class Counter{
		private int value = 0;
		public Counter(int i){
			this.value = i;
		}
		public int value(){
			return this.value;
		}
		public void increase(){
			this.value++; 
		}
		public void decrease(){
			this.value--;
		}
	}
	
}
