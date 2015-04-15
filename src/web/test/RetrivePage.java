package web.test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;


public class RetrivePage {
	private static CloseableHttpClient httpclient = HttpClients.createDefault();

	public static boolean downloadPage(String path) throws Exception {
		InputStream input = null;
		OutputStream output = null;
		
		HttpHost proxy = new HttpHost("cn-proxy.sg.oracle.com", 80, "http");
		HttpPost httpPost = new HttpPost(path);
        RequestConfig config = RequestConfig.custom()
                .setProxy(proxy)
                .build();
        httpPost.setConfig(config);
//		List<NameValuePair> pairs = new ArrayList<NameValuePair>();
//		pairs.add(new BasicNameValuePair("loginEmail", "guoliang_wang007@163.com"));
//		pairs.add(new BasicNameValuePair("loginPassword", "wgl@2015"));
//		httpPost.setEntity(new UrlEncodedFormEntity(pairs));
		HttpResponse response = httpclient.execute(httpPost);
		StatusLine statusLine = response.getStatusLine();
		
		
		if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
			HttpEntity entity = response.getEntity();
			return true;
		}
		
		return false;		
	}
	public static void main(String[] args) {
		try {
			RetrivePage.downloadPage("http://www.baidu.com/");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
