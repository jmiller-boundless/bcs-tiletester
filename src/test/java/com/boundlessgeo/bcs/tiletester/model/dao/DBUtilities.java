package com.boundlessgeo.bcs.tiletester.model.dao;

 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.boundlessgeo.bcs.tiletester.utilities.Config;
import com.boundlessgeo.bcs.tiletester.utilities.Pixel;
 
public class DBUtilities {
 
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    Map<String,Pixel>cachedPixel=new HashMap<String,Pixel>();
 
    public DBUtilities() throws SQLException {
        try {
            connection = DriverManager.getConnection(Config.connection_url, Config.prop.getProperty("DATABASE_USER_ID"), Config.prop.getProperty("DATABASE_PASSWORD"));
 
        } catch (SQLException ex) {
            System.out.println("The following error has occured: " + ex.getMessage());
        }
    }
 
    public Connection getConnection() {
        return connection;
    }
 
    public void ExecuteSQLUpdate(String sql_stmt) {
        try {
            statement = connection.createStatement();
 
            statement.executeUpdate(sql_stmt);
        } catch (SQLException ex) {
            System.out.println("The following error has occured: " + ex.getMessage());
        }
    }
    
    public ResultSet ExecuteSQLQuery(String sql_stmt) {
    	ResultSet rs = null;
        try {
        	if(statement==null)
        		statement = connection.createStatement();
            
            rs= statement.executeQuery(sql_stmt);
        } catch (SQLException ex) {
            System.out.println("The following error has occured: " + ex.getMessage());
        }
        return rs;
    }
    

	

	
	public Pixel getMetersCenterOfRandomFeature(String featureType){
		if(cachedPixel.containsKey(featureType)){
			return cachedPixel.get(featureType);
		}
		String sql = "select st_x(st_centroid(st_transform(way,900913))) as x, st_y(st_centroid(st_transform(way,900913))) as y from "+featureType+" offset random() * (select count(*) from "+featureType+") limit 1";
		ResultSet rs = ExecuteSQLQuery(sql);
		
		Pixel pixel = null;
		try {
			while(rs.next()){
				pixel = new Pixel(rs.getDouble("x"),rs.getDouble("y"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			rs.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}
		cachedPixel.put(featureType, pixel);
		return pixel;
	}
	
	
    public void disconnectFromDatabase() {

            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException sex) {
                System.out.println(sex.getMessage());
            } 

    }

    public static String convertToCsv(ResultSet rs,String fileName) throws SQLException, IOException {
        File file = new File(fileName);
        String out="";
        out = file.getCanonicalPath();
    	PrintWriter csvWriter = new PrintWriter(file) ;
        ResultSetMetaData meta = rs.getMetaData() ; 
        int numberOfColumns = meta.getColumnCount() ; 
        String dataHeaders = "\"" + meta.getColumnName(1) + "\"" ; 
        for (int i = 2 ; i < numberOfColumns + 1 ; i ++ ) { 
                dataHeaders += ",\"" + meta.getColumnName(i) + "\"" ;
        }
        csvWriter.println(dataHeaders) ;
        while (rs.next()) {
            String row = "\"" + rs.getString(1) + "\""  ; 
            for (int i = 2 ; i < numberOfColumns + 1 ; i ++ ) {
                row += ",\"" + rs.getString(i) + "\"" ;
            }
        csvWriter.println(row) ;
        }
        csvWriter.close();
        return out;
    }




}
