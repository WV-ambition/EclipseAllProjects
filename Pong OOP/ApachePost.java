import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApachePost {


    public static void main(String[] args) throws IOException {

    	URL url = new URL("https://apcsapractice.com/data.csv");
    	HttpURLConnection con = (HttpURLConnection) url.openConnection();
    	con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
    	con.setRequestMethod("GET");

    	BufferedReader in = new BufferedReader(new InputStreamReader(
    	con.getInputStream()));
    	String inputLine;
    	while ((inputLine = in.readLine()) != null) {
    		System.out.println(inputLine);
    	} 


    	in.close();

    	//Read more: https://www.java67.com/2019/03/7-examples-of-httpurlconnection-in-java.html#ixzz6HYOssaF9

    }

}
