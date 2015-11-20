import java.io.IOException;
import java.util.List;

import com.dotenv.DotEnv;
import com.imp.network.FileDownloader;

import br.com.etyllica.network.shutterstock.ShutterStockAPI;
import br.com.etyllica.network.shutterstock.model.ShutterStockDataItem;


public class ApiExample {
	
	private static int PAGE_SIZE = 10;
	
	public static void main(String[] args) throws IOException {
		String query = "refrigerator";
		
		DotEnv env = new DotEnv(System.getProperty("user.dir"));
		String key = env.get("API_KEY");
		String secret = env.get("API_SECRET");
		
		queryFor(key, secret, query, 20);
	}
	
	private static void queryFor(String key, String secret, String query, int quantity) throws IOException {
		int count = 0;
		queryFor(key, secret, query, count, quantity);
	}
	
	private static void queryFor(String key, String secret, String query, int offset, int total) throws IOException {
		int remaining = total;
		int page = 0;
		
		while (remaining > 0) {
			page++;
			int pageCount = 0;
			
			int size = remaining > PAGE_SIZE ? PAGE_SIZE : remaining;
			
			List<ShutterStockDataItem> results = ShutterStockAPI.queryImages(key, secret,
					page, size, query);
			
			if(results.isEmpty()) {
				System.err.println("Out of range");
				break;
			}
			
			for(ShutterStockDataItem item: results) {
				String url = item.getAssets().getLargeThumbnail().getUrl();
				
				String ext = extension(url);
				if(ext.length() > 5) {
					continue;
				}
				try {
					System.out.println(url);
					FileDownloader.downloadAsFile(url, fixQuery(query)+(offset+pageCount+1)+ext);
					pageCount++;
				} catch (IOException e) {
					//Try again
				}
			}
			
			offset += pageCount;
			remaining -= pageCount;
		}
	}
	
	private static String fixQuery(String query) {
		return query.replaceAll(" ", "_");
	}
	
	private static String extension(String fileName) {
		String extension = "";

		int i = fileName.lastIndexOf('.');
		if (i > 0) {
			//including "."
		    extension = fileName.substring(i);
		    
		    if (extension.contains("?")) {
			    extension.substring(0, extension.indexOf('?'));
		    }
		}
		
		return extension;
	}
}
