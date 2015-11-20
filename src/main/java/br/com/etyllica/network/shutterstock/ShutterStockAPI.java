package br.com.etyllica.network.shutterstock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Base64;
import java.util.List;

import br.com.etyllica.network.shutterstock.model.ShutterStockDataItem;
import br.com.etyllica.network.shutterstock.model.ShutterStockResponse;

import com.google.gson.Gson;

public class ShutterStockAPI {
	
	//https://api.shutterstock.com/v2/images/search?query=restaurant
	//&safe=true&image_type=photo&orientation=horizontal
	//&category=Interiors&people_number=0&page=1&per_page=3
	
	private static final String SHUTTER_STOCK_ENDPOINT = "https://api.shutterstock.com/v2";
	public static final int FIRST_PAGE = 0;
	public static final int PAGE_SIZE = 3;
	
	public static List<ShutterStockDataItem> queryImages(String username, String password, String query) throws IOException {
		return requestResults(username, password, query, FIRST_PAGE, PAGE_SIZE);
	}

	public static List<ShutterStockDataItem> queryImages(String username, String password, int page, int pageSize, String query) throws IOException {
		return requestResults(username, password, query, page, pageSize);
	}
	
	private static String requestJson(String username, String password, String query, int page, int pageSize)
			throws MalformedURLException, IOException {
		String fixedQuery = fixQuery(query);
		
		URL url = new URL(SHUTTER_STOCK_ENDPOINT+"/images/search?"+
				//https://api.shutterstock.com/v2/images/search?query=restaurant
				//&image_type=photo
				//&safe=true
				//&orientation=horizontal
				//&category=Interiors
				
				//&people_number=0
				"page="+page+"&per_page="+pageSize+"&query="+fixedQuery+"&image_type=photo"+
				"&category=Interiors&people_number=0");
		
		URLConnection connection = url.openConnection();
		
		encodeAuthentication(username, password, connection);

		String line;
		StringBuilder builder = new StringBuilder();
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		while((line = reader.readLine()) != null) {
			builder.append(line);
		}

		String json = builder.toString();
		return json;
	}

	private static void encodeAuthentication(String username, String password, URLConnection connection) {
		String userCredentials = username+":"+password;
		String basicAuth = "Basic " + new String(Base64.getEncoder().encodeToString(userCredentials.getBytes()));
		connection.setRequestProperty ("Authorization", basicAuth);
	}
	
	private static String fixQuery(String query) {
		return query.replaceAll(" ", "%20");
	}

	public static List<ShutterStockDataItem> requestResults(String username, String password, String query, int page, int pageSize)
			throws MalformedURLException, IOException {
		String json = requestJson(username, password, query, page, pageSize);
		
		ShutterStockResponse response = new Gson().fromJson(json, ShutterStockResponse.class);
		return response.getData();
	}
	
	private static List<ShutterStockDataItem> requestResultsWithParams(String username, String password, String query, int page, int pageSize, String extraParams)
			throws MalformedURLException, IOException {
		
		return requestResults(username, password, query+extraParams, page, pageSize);
	}
	
}
