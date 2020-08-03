

	import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.FileEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

	 

	public class Main {
	    private static void executeRequest(HttpPost httpPost) {
	        try {
	            HttpClient client = new DefaultHttpClient();
	            HttpResponse response = client.execute(httpPost);
	            System.out.println("Response Code:  " + response.getStatusLine().getStatusCode());
	            System.out.println(EntityUtils.toString(response.getEntity()));
	        } catch (UnsupportedEncodingException e) {
	            e.printStackTrace();
	        } catch (ClientProtocolException e) {
	            e.printStackTrace();
	        } catch (IllegalStateException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	 

	    public void executeMultiPartRequest(String urlString, File file) throws IOException {
	        HttpPost postRequest = new HttpPost(urlString);
	        postRequest = addHeader(postRequest,
	                "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6Imh1Tjk1SXZQZmVocTM0R3pCRFoxR1hHaXJuTSIsImtpZCI6Imh1Tjk1SXZQZmVocTM0R3pCRFoxR1hHaXJuTSJ9.eyJhdWQiOiIwMDAwMDAwMy0wMDAwLTBmZjEtY2UwMC0wMDAwMDAwMDAwMDAvY29nbml6YW50b25saW5lLW15LnNoYXJlcG9pbnQuY29tQGRlMDhjNDA3LTE5YjktNDI3ZC05ZmU4LWVkZjI1NDMwMGNhNyIsImlzcyI6IjAwMDAwMDAxLTAwMDAtMDAwMC1jMDAwLTAwMDAwMDAwMDAwMEBkZTA4YzQwNy0xOWI5LTQyN2QtOWZlOC1lZGYyNTQzMDBjYTciLCJpYXQiOjE1OTYwMTg5MjIsIm5iZiI6MTU5NjAxODkyMiwiZXhwIjoxNTk2MTA1NjIyLCJpZGVudGl0eXByb3ZpZGVyIjoiMDAwMDAwMDEtMDAwMC0wMDAwLWMwMDAtMDAwMDAwMDAwMDAwQGRlMDhjNDA3LTE5YjktNDI3ZC05ZmU4LWVkZjI1NDMwMGNhNyIsIm5hbWVpZCI6IjNiOGNiYmNmLWQ4YWYtNGU0Yy04MmQ1LTY4YjZiNTI4MDg3ZEBkZTA4YzQwNy0xOWI5LTQyN2QtOWZlOC1lZGYyNTQzMDBjYTciLCJvaWQiOiJkYjkxMzI4Ni0yOGVhLTRlZDMtYjUxNy1lNjg0NWMxZGE3MWQiLCJzdWIiOiJkYjkxMzI4Ni0yOGVhLTRlZDMtYjUxNy1lNjg0NWMxZGE3MWQiLCJ0cnVzdGVkZm9yZGVsZWdhdGlvbiI6ImZhbHNlIn0.OedzhoOPv6zIYkPQ5ViL4R3mkKh_8Vc8C4UdVZ_bYdWitunrck8-Dp7Fmue5Q2Qc4CpGy13eATssFzYQEkJb005DjQGfXm77CPiBc3linKrPREN5yfc1AiWjNgdcOen_HHvqG2jdXioNh6U4FQU2pA5avhBf3k7VoR3H0rUQCrqOstOPr8x166eeO45i2RzCDDNTL00eeNi4-1fdPejMlITj6teWhVC9FQr18bj4PDIfyyfpZdgoZdrGAf-uKTVVAPOIWRYg22NyAAwJLm-V2f7fjwcmiIPNsgD8uVSF2iQl114_ETubeJZQnIy1t2BsvcRFod5XR56JUqUOFSyMCQ");
	        try {
	            postRequest.setEntity(new FileEntity(file));
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	        executeRequest(postRequest);
	    }

	 

	    private static HttpPost addHeader(HttpPost httpPost, String accessToken) {
	        httpPost.addHeader("Accept", "application/json;odata=verbose");
	        // Content-Type:application/x-www-form-urlencoded

	 

	        httpPost.setHeader("Authorization", "Bearer " + accessToken);
	        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
	        return httpPost;
	    }

	 

	    public static void main(String args[]) throws IOException {
	        Main fileUpload = new Main();
	        File file = new File("C:/Users/765584/Desktop/share file POC/sample.txt");

	        fileUpload.executeMultiPartRequest("https://cognizantonline-my.sharepoint.com/personal/765584_cognizant_com/_api/web/GetFolderByServerRelativePath(DecodedUrl=@a1)/Files/AddUsingPath(DecodedUrl=@a2,overwrite=@a3,AutoCheckoutOnInvalidData=@a4)?@a1=%27%2Fpersonal%2F765584%5Fcognizant%5Fcom%2FDocuments%27&@a2=%27sample%2Etxt%27&@a3=false&@a4=true&$Expand=ListItemAllFields",file);

	    }
	}

