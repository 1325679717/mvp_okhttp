package com.example.myt.easy_frame.network;



import com.example.myt.easy_frame.utils.LogUtil;
import com.example.myt.easy_frame.utils.StringUtill;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;


public class GetParamsUtill {

	/**
	 * 此处的加密的key是写死的 只是为了调试
	 */
	 public static String ENCRYPT_KEY = "";//

	private String url;

	private static String GLOBAL_PARAMS_KEY = "EncryptedValue";//

    private boolean isParticipateEncrypt ;

    private String appendParams;

	Map<String, String> paramMap = new HashMap<String, String>();

	public GetParamsUtill(String url) {
		this.url = url;
	}

	public void add(String name, String value) {

        /*if (name.contains("password")){
            value= MD5Util.getMD5Str(value + pwdKey);
        }*/

		this.paramMap.put(name, value);

	}
	public String getHttpUrl(){
		return url;
	}
    public void add(String name, String value, boolean isnotEncryt){

        if (name.equals("Password")){
//            value=MD5Util.getMD5Str(value+"|"+pwdKey);
        }

        this.paramMap.put(name, value);


    }



	/**
	 * 对参数排序后添加
	 * 
	 * @param
	 */
	public Request.Builder getParams (Map<String,String> map) {
		Request.Builder builder = new Request.Builder();
		List<String> paramKeyList = new ArrayList<String>();

		Set<String> keySet = paramMap.keySet();
		StringBuffer sb = new StringBuffer();

		for (String key : keySet) {
			paramKeyList.add(key);

		}
		List<String> newKeyList = StringUtill.sortStr(paramKeyList);

		for (String key : newKeyList) {
			map.put(key,paramMap.get(key));
			sb.append(paramMap.get(key)).append("|");

		}

		StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("?");


		if (paramMap != null) {

			for (Map.Entry<String, String> entry : paramMap.entrySet()) {
				stringBuffer.append(entry.getKey())
						.append("=").append(entry.getValue()).append("&");

			}


            this.appendParams=stringBuffer.substring(0, stringBuffer.length() - 1);
		}
//		builder.url(url);
		return builder;

	}

    public String getApandParams(){
        return  this.appendParams;

    }

}
