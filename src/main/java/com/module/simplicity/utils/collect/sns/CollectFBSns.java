package com.module.simplicity.utils.collect.sns;

import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class CollectFBSns implements Callable<Integer>{

	private String url;
		
	public CollectFBSns(String url) {
		this.url = url;
	}

	public Integer call() throws Exception {
		if(url == null || url.length() < 1) {
			System.out.println("have not url data");
			return null;
		}
		
		URL url = new URL(this.url);
		InputStreamReader reader = new InputStreamReader(url.openConnection().getInputStream(), "UTF-8");
		JSONTokener tokenizer = new JSONTokener(reader);
		JSONArray jsonArray = new JSONArray(tokenizer);
		
		if(jsonArray.length() > 0) {
			JSONObject jsonObject =  jsonArray.getJSONObject(0);
	        int shareCount = (Integer) jsonObject.get("share_count");
	        int likeCount = (Integer) jsonObject.get("like_count");
	        int commentCount = (Integer) jsonObject.get("comment_count");
	        int totalCount = (Integer) jsonObject.get("total_count");
	        int clickCount = (Integer) jsonObject.get("click_count");
	        String commentsFbid = (String) jsonObject.get("comments_fbid");
	        int commentsboxCount = (Integer) jsonObject.get("commentsbox_count");
	        
	    	System.out.println("shareCount = " + shareCount);
	    	System.out.println("likeCount = " + likeCount);
	    	System.out.println("commentCount = " + commentCount);
	    	System.out.println("totalCount = " + totalCount);
	    	System.out.println("clickCount = " + clickCount);
	    	System.out.println("commentsFbid = " + commentsFbid);
	    	System.out.println("commentsboxCount = " + commentsboxCount);
		}
		
		return 1;
	}
    
}
