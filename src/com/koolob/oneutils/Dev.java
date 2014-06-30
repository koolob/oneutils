package com.koolob.oneutils;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;

public class Dev {

	public static boolean isNetworkAvailable(Context context) { 
		ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE); 
		if (connectivity == null) {   
	    } else {   
	        NetworkInfo[] info = connectivity.getAllNetworkInfo();   
	        if (info != null) {   
	            for (int i = 0; i < info.length; i++) {   
	                if (info[i].getState() == NetworkInfo.State.CONNECTED) {   
	                    return true;   
	                }   
	            }   
	        }   
	    }   
	    return false; 
	}
	
	public static boolean isWifi(Context context) {   
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);   
        NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();   
        if (activeNetInfo != null && activeNetInfo.getType() == ConnectivityManager.TYPE_WIFI) {   
            return true;   
        }   
        return false; 
	}    
    
	public static boolean isMobileNet(Context context) {   
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);   
        NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();   
        if (activeNetInfo != null && activeNetInfo.getType() == ConnectivityManager.TYPE_MOBILE) {   
            return true;   
        }   
        return false; 
	}
	
	public static String getIMSI(Context context){
		TelephonyManager telManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE); 
		return telManager.getSubscriberId();
	}
	
	public static String getSimOperator(Context context){
		TelephonyManager telManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE); 
		return telManager.getSimOperator();
	}
	
	public static String getMacAddress(Context c){
		String macAddress = null;
		WifiManager wifiMgr = (WifiManager) c.getSystemService(Context.WIFI_SERVICE);
		WifiInfo info = (null == wifiMgr ? null : wifiMgr.getConnectionInfo());
		if (null != info) {
			macAddress = info.getMacAddress();
		}
		return macAddress;
	}
	
	public static String getBlueToothAddress(){
		String btAddress = "";
		BluetoothAdapter bt= BluetoothAdapter.getDefaultAdapter(); 
		if(bt != null){
			btAddress = bt.getAddress();
		}
		return btAddress;
	}
	
	public static Account[] getAccounts(Context c,String accountstype){
		AccountManager manage = AccountManager.get(c);
		return accountstype == null ? manage.getAccounts() : manage.getAccountsByType(accountstype);
	}

	
	public static String[] getAccountsName(Context c,String accountstype){
		Account[] accounts = getAccounts(c,accountstype);
		String[] accountnames = new String[accounts.length];
		for(int i=0;i<accounts.length;i++){
			accountnames[i] = accounts[i].name;
		}
		return accountnames;
	}
}
