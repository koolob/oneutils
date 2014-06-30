package com.koolob.oneutils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class Pre {

	private SharedPreferences sp = null;
	private String name = null;
	private Context context = null;
	public Pre(Context c,String n){
		this.context = c;
		this.name = n;
		sp = this.context.getSharedPreferences(this.name, Context.MODE_PRIVATE);
	}

	public void save(String key,String val){
		Editor editor = sp.edit();
		editor.putString(key, val);
		editor.commit();
	}

	public String load(String key){
		String val = sp.getString(key, "");
		return val;
	}
}
