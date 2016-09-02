package com.boundlessgeo.bcs.tiletester.model.dao;

 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Date;

import com.boundlessgeo.bcs.tiletester.utilities.Config;
import com.boundlessgeo.bcs.tiletester.utilities.Pixel;
 
public class DBUtilities {
 
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
 
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
            statement = connection.createStatement();
 
            rs= statement.executeQuery(sql_stmt);
        } catch (SQLException ex) {
            System.out.println("The following error has occured: " + ex.getMessage());
        }
        return rs;
    }
    

	
	public String getByYearAndState(String query, String selectedYear, String selectedState, String filePrefix) {
		String out = "";
		try {
			PreparedStatement ps = getConnection().prepareStatement(query);
			ps.setInt(1, Integer.parseInt(selectedYear));
			ps.setString(2,selectedState);
			ResultSet rs = ps.executeQuery();
			Date date = new Date();
			//out = DBUtilities.convertToCsv(rs, Config.path+filePrefix+"_"+selectedYear+"_"+date.getTime()+".csv");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out + " Finished!";
	}
	
	public Pixel getMetersCenterOfRandomFeature(String featureType){
		String sql = "select st_x(st_centroid(st_transform(geom,900913))) as x, st_y(st_centroid(st_transform(geom,900913))) as y from "+featureType+" offset random() * (select count(*) from "+featureType+") limit 1";
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
