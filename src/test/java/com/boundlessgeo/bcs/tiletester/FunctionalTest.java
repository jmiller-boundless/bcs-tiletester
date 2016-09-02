package com.boundlessgeo.bcs.tiletester;

import java.sql.SQLException;

import org.junit.BeforeClass;

import com.boundlessgeo.bcs.tiletester.model.dao.DBUtilities;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.specification.RequestSpecification;

public class FunctionalTest {
	protected static DBUtilities dbu;
	@BeforeClass
    public static void setup() {
        String port = System.getProperty("server.port");
        if (port == null) {
            RestAssured.port = Integer.valueOf(80);
        }
        else{
            RestAssured.port = Integer.valueOf(port);
        }


        String basePath = System.getProperty("server.base");
        if(basePath==null){
            basePath = "";
        }
        RestAssured.basePath = basePath;

        String baseHost = System.getProperty("server.host");
        if(baseHost==null){
            baseHost = "http://b.tile.openstreetmap.org";
        }
        RestAssured.baseURI = baseHost;
        String myUserAgent = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36";
        RequestSpecification requestSpecification = new RequestSpecBuilder().addHeader("User-Agent", myUserAgent).build();
        RestAssured.requestSpecification = requestSpecification;
        try {
			dbu=new DBUtilities();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
