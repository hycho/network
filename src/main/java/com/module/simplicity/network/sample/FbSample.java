package com.module.simplicity.network.sample;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class FbSample {
	private static final String prevUrl = "http://api.facebook.com/method/links.getStats?urls=";
	private static final String nextUrl = "&format=json";
	
	public static void main(String[] args) {
			URL url;
		try {
			url = new URL(prevUrl + "http://naon.go.kr/content/html/2015/10/06/85beb944-66f5-4997-b984-41a1f064723c.html" + nextUrl);
			
			InputStreamReader reader = new InputStreamReader(url.openConnection().getInputStream(), "UTF-8");
			JSONTokener tokenizer = new JSONTokener(reader);
			JSONArray jsonArray = new JSONArray(tokenizer);
			
			if(jsonArray.length() > 0) {
				JSONObject jsonObject =  jsonArray.getJSONObject(0);
		        int shareCount = (Integer) jsonObject.get("share_count");
		        int likeCount = (Integer) jsonObject.get("like_count");
		        int commentCount = (Integer) jsonObject.get("comment_count");
		        int totalCount = (Integer) jsonObject.get("total_count");
		        int commentsboxCount = (Integer) jsonObject.get("commentsbox_count");
		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
