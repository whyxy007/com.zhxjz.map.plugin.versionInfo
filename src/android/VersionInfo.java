package com.zhxjz.map.plugin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;

/**
 * 
 * @author yangxy
 * 
 */
public class VersionInfo extends CordovaPlugin {

	private Context mContext;

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		this.mContext = cordova.getActivity();
		try {
			if(action.equals("getVersionName")) {
				String versionName = getCurrentVerName();
				callbackContext.success(versionName);
			}
			else if(action.equals("getVersionCode")) {
				int versionCode = getCurrentVerCode();
				callbackContext.success(versionCode);
			}
			return true;
		} catch (Exception e) {
			callbackContext.error(e.getMessage());
			return false;
		}
	}

	/**
     * 获取应用当前版本代码
     */
    private int getCurrentVerCode(){
    	String packageName = this.mContext.getPackageName();
    	int currentVer = -1;
    	try {
			currentVer = this.mContext.getPackageManager().getPackageInfo(packageName, 0).versionCode;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
    	return currentVer;
    }
    
    /**
     * 获取应用当前版本名称
     */
    private String getCurrentVerName(){
    	String packageName = this.mContext.getPackageName();
    	String currentVerName = "";
    	try {
    		currentVerName = this.mContext.getPackageManager().getPackageInfo(packageName, 0).versionName;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
    	return currentVerName;
    }

}
