package za.co.boitumelo.invoices;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Test;

public class testService {


	public testService() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			testService test = new testService();
			test.testGetOne();
        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
            e.printStackTrace();
        }

	}
	
	@Test
	public void testPost() throws Exception {
		String testInsert = "{\"id\":6, \"client\":\"client one\",\"vatRate\":15,\"invoiceDate\":1514757600000,"
				+ "\"lineItems\":[{\"description\":\"Kelloggs\",\"quantity\":15,\"unitPrice\":28.00}]}";
		
        URL url = new URL("http://localhost:8080/invoices/");//your url i.e fetch data from .
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty( "Content-Type", "application/json"); 
        conn.setRequestProperty( "charset", "utf-8");
        conn.setRequestProperty( "Content-Length", Integer.toString( testInsert.length() ));
        conn.setUseCaches( false );
        conn.setDoOutput(true);
        try( DataOutputStream wr = new DataOutputStream( conn.getOutputStream())) {
        	   wr.writeUTF( testInsert );
        	}
        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP Error code : "
                    + conn.getResponseCode());
        }
        InputStreamReader in = new InputStreamReader(conn.getInputStream());
        BufferedReader br = new BufferedReader(in);
        String output;
        while ((output = br.readLine()) != null) {
            System.out.println(output);
        }
        conn.disconnect();


	}
	
	public void testGetAll() throws Exception {

        URL url = new URL("http://localhost:8080/invoices");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP Error code : "
                    + conn.getResponseCode());
        }
        InputStreamReader in = new InputStreamReader(conn.getInputStream());
        BufferedReader br = new BufferedReader(in);
        String output;
        while ((output = br.readLine()) != null) {
            System.out.println(output);
        }
        conn.disconnect();

	}
	
	public void testGetOne() throws Exception {

        URL url = new URL("http://localhost:8080/invoices/1");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP Error code : "
                    + conn.getResponseCode());
        }
        InputStreamReader in = new InputStreamReader(conn.getInputStream());
        BufferedReader br = new BufferedReader(in);
        String output;
        while ((output = br.readLine()) != null) {
            System.out.println(output);
        }
        conn.disconnect();

	}

}
