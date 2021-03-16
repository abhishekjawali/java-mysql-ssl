package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.Statement;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	private static final String DB_USER = "DB-USER-NAME";
	private static final String DB_PASSWORD = "DB-PASSWORD";
	private static final String DB_URL = "jdbc:mysql://DB-URL";
	// This key store has only the prod root ca.
	private static final String KEY_STORE_FILE_PATH = "classpath:clientkeystore.jks";
	private static final String KEY_STORE_PASS = "password";

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);


		System.setProperty("javax.net.ssl.trustStore", KEY_STORE_FILE_PATH);
		System.setProperty("javax.net.ssl.trustStorePassword", KEY_STORE_PASS);

		Properties properties = new Properties();
		properties.setProperty("sslMode", "Verify_CA");
		properties.put("user", DB_USER);
		properties.put("password", DB_PASSWORD);
		properties.put("enabledTLSProtocols", "TLSv1.2");

		Connection connection;
		try {
			connection = DriverManager.getConnection(
				DB_URL, properties);
					String connClientInfo = connection.getClientInfo().toString();
					System.out.println("Connection client info "+ connClientInfo);
					Statement stmt=connection.createStatement();
	
		ResultSet rs=stmt.executeQuery("SELECT 1 from dual");
		rs.next();
		String res = rs.getString(1);
		System.out.println("the result is "+res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(0);
	}

}
