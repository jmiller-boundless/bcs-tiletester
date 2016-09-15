package com.boundlessgeo.bcs.tiletester;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.boundlessgeo.bcs.tiletester.utilities.Pixel;
import com.boundlessgeo.bcs.tiletester.utilities.TileCoordConverter;
import com.jayway.restassured.RestAssured;
@RunWith(Parameterized.class)
public class RandomTileTest extends FunctionalTest {
/*    @Test
    public void basicPingTest() {
    	TileCoordConverter tcc = new TileCoordConverter();
    	String gmapaddress = tcc.getGMapAddressString(5, new Pixel(0,0));
        given().log().all().when().get(gmapaddress).then().statusCode(200);
    }
    @Test
    public void responseTimeTest() {
        long time = 
    	given().log().all().when().get("/5/5/11.png").then().extract().response().time();
        
        assertThat(time, lessThan(5000L));
    }*/
    //aero-poly,agriculture,amenity-areas,beach,building,forest,grass,highway-label,park,parking-area,placenames-medium,route-bridge-0
    //route-bridge-1,route-bridge-2,route-bridge-3,route-bridge-4,route-bridge-5,route-fill, route-line, route-tunnels,route-turning-circles, water-outline,water,wetland
    
	private String featureType;
	
    public RandomTileTest(String featureType) {
        this.featureType = featureType;
     }

     @Parameterized.Parameters
     public static Collection featureTypes() {
        return Arrays.asList(new Object[] {
        		"\"aero-poly\"",
        		"agriculture",
        		"\"amenity-areas\"",
        		"beach",
        		"building",
        		"forest",
        		"grass",
        		"\"highway-label\"",
        		"park",
        		"\"parking-area\"",
        		"\"placenames-medium\"",
        		"\"route-bridge-0\"",
        		"\"route-bridge-1\"",
        		"\"route-bridge-2\"",
        		"\"route-bridge-3\"",
        		"\"route-bridge-4\"",
        		"\"route-bridge-5\"",
        		"\"route-fill\"", 
        		"\"route-line\"", 
        		"\"route-tunnels\"",
        		"\"route-turning-circles\"", 
        		"\"water-outline\"",
        		"water",
        		"wetland"
        });
     }
    
     
     @Test
     public void level0Test(){
     	Pixel meters = dbu.getMetersCenterOfRandomFeature(featureType);
     	Integer z = 0;
     	TileCoordConverter tcc = new TileCoordConverter();
     	
     	Pixel tile = tcc.metersToTileGoogle(meters.getX(), meters.getY(), z);
     	String gmapaddress = tcc.getGMapAddressString(z, tile);
     	long time = given().when().get(gmapaddress).then().statusCode(200).extract().response().time();
     	System.out.println("Feature Type: "+featureType+" Zoom Level: "+z+" Address: "+RestAssured.baseURI+RestAssured.basePath+gmapaddress + " Time To Load: "+time);
     	assertThat(time, lessThan(5000L));

     }
     @Test
     public void level1Test(){
     	Pixel meters = dbu.getMetersCenterOfRandomFeature(featureType);
     	Integer z = 1;
     	TileCoordConverter tcc = new TileCoordConverter();
     	
     	Pixel tile = tcc.metersToTileGoogle(meters.getX(), meters.getY(), z);
     	String gmapaddress = tcc.getGMapAddressString(z, tile);
     	long time = given().when().get(gmapaddress).then().statusCode(200).extract().response().time();
     	System.out.println("Feature Type: "+featureType+" Zoom Level: "+z+" Address: "+RestAssured.baseURI+RestAssured.basePath+gmapaddress + " Time To Load: "+time);
     	assertThat(time, lessThan(5000L));

     }
     @Test
     public void level2Test(){
     	Pixel meters = dbu.getMetersCenterOfRandomFeature(featureType);
     	Integer z = 2;
     	TileCoordConverter tcc = new TileCoordConverter();
     	
     	Pixel tile = tcc.metersToTileGoogle(meters.getX(), meters.getY(), z);
     	String gmapaddress = tcc.getGMapAddressString(z, tile);
     	//System.out.println("Feature Type: "+featureType+" Zoom Level: "+z+" Address: "+gmapaddress);
     	//long time = given().when().get(gmapaddress).then().statusCode(200).extract().response().time();
     	long time = given().when().get(gmapaddress).then().statusCode(200).extract().response().time();
    	System.out.println("Feature Type: "+featureType+" Zoom Level: "+z+" Address: "+RestAssured.baseURI+RestAssured.basePath+gmapaddress + " Time To Load: "+time);
     	assertThat(time, lessThan(5000L));

     }
     @Test
     public void level3Test(){
     	Pixel meters = dbu.getMetersCenterOfRandomFeature(featureType);
     	Integer z = 3;
     	TileCoordConverter tcc = new TileCoordConverter();
     	
     	Pixel tile = tcc.metersToTileGoogle(meters.getX(), meters.getY(), z);
     	String gmapaddress = tcc.getGMapAddressString(z, tile);
     	long time = given().when().get(gmapaddress).then().statusCode(200).extract().response().time();
     	System.out.println("Feature Type: "+featureType+" Zoom Level: "+z+" Address: "+RestAssured.baseURI+RestAssured.basePath+gmapaddress + " Time To Load: "+time);
     	assertThat(time, lessThan(5000L));

     }
     @Test
     public void level4Test(){
     	Pixel meters = dbu.getMetersCenterOfRandomFeature(featureType);
     	Integer z = 4;
     	TileCoordConverter tcc = new TileCoordConverter();
     	
     	Pixel tile = tcc.metersToTileGoogle(meters.getX(), meters.getY(), z);
     	String gmapaddress = tcc.getGMapAddressString(z, tile);
     	long time = given().when().get(gmapaddress).then().statusCode(200).extract().response().time();
     	System.out.println("Feature Type: "+featureType+" Zoom Level: "+z+" Address: "+RestAssured.baseURI+RestAssured.basePath+gmapaddress + " Time To Load: "+time);
     	assertThat(time, lessThan(5000L));

     }
     @Test
     public void level5Test(){
     	Pixel meters = dbu.getMetersCenterOfRandomFeature(featureType);
     	Integer z = 5;
     	TileCoordConverter tcc = new TileCoordConverter();
     	
     	Pixel tile = tcc.metersToTileGoogle(meters.getX(), meters.getY(), z);
     	String gmapaddress = tcc.getGMapAddressString(z, tile);
     	long time = given().when().get(gmapaddress).then().statusCode(200).extract().response().time();
     	System.out.println("Feature Type: "+featureType+" Zoom Level: "+z+" Address: "+RestAssured.baseURI+RestAssured.basePath+gmapaddress + " Time To Load: "+time);
     	assertThat(time, lessThan(5000L));

     }
     
    @Test
    public void level6Test(){
    	Pixel meters = dbu.getMetersCenterOfRandomFeature(featureType);
    	Integer z = 6;
    	TileCoordConverter tcc = new TileCoordConverter();
    	
    	Pixel tile = tcc.metersToTileGoogle(meters.getX(), meters.getY(), z);
    	String gmapaddress = tcc.getGMapAddressString(z, tile);
    	long time = given().when().get(gmapaddress).then().statusCode(200).extract().response().time();
    	System.out.println("Feature Type: "+featureType+" Zoom Level: "+z+" Address: "+RestAssured.baseURI+RestAssured.basePath+gmapaddress + " Time To Load: "+time);
    	assertThat(time, lessThan(5000L));

    }

    @Test
    public void level7Test(){
    	Pixel meters = dbu.getMetersCenterOfRandomFeature(featureType);
    	Integer z = 7;
    	TileCoordConverter tcc = new TileCoordConverter();
    	
    	Pixel tile = tcc.metersToTileGoogle(meters.getX(), meters.getY(), z);
    	String gmapaddress = tcc.getGMapAddressString(z, tile);
    	long time = given().when().get(gmapaddress).then().statusCode(200).extract().response().time();
    	System.out.println("Feature Type: "+featureType+" Zoom Level: "+z+" Address: "+RestAssured.baseURI+RestAssured.basePath+gmapaddress + " Time To Load: "+time);
    	assertThat(time, lessThan(5000L));

    }
    @Test
    public void level8Test(){
    	Pixel meters = dbu.getMetersCenterOfRandomFeature(featureType);
    	Integer z = 8;
    	TileCoordConverter tcc = new TileCoordConverter();
    	
    	Pixel tile = tcc.metersToTileGoogle(meters.getX(), meters.getY(), z);
    	String gmapaddress = tcc.getGMapAddressString(z, tile);
    	long time = given().when().get(gmapaddress).then().statusCode(200).extract().response().time();
    	System.out.println("Feature Type: "+featureType+" Zoom Level: "+z+" Address: "+RestAssured.baseURI+RestAssured.basePath+gmapaddress + " Time To Load: "+time);
    	assertThat(time, lessThan(5000L));

    }
    @Test
    public void level9Test(){
    	Pixel meters = dbu.getMetersCenterOfRandomFeature(featureType);
    	Integer z = 9;
    	TileCoordConverter tcc = new TileCoordConverter();
    	
    	Pixel tile = tcc.metersToTileGoogle(meters.getX(), meters.getY(), z);
    	String gmapaddress = tcc.getGMapAddressString(z, tile);
    	long time = given().when().get(gmapaddress).then().statusCode(200).extract().response().time();
    	System.out.println("Feature Type: "+featureType+" Zoom Level: "+z+" Address: "+RestAssured.baseURI+RestAssured.basePath+gmapaddress + " Time To Load: "+time);
    	assertThat(time, lessThan(5000L));

    }
    @Test
    public void level10Test(){
    	Pixel meters = dbu.getMetersCenterOfRandomFeature(featureType);
    	Integer z = 10;
    	TileCoordConverter tcc = new TileCoordConverter();
    	
    	Pixel tile = tcc.metersToTileGoogle(meters.getX(), meters.getY(), z);
    	String gmapaddress = tcc.getGMapAddressString(z, tile);
    	long time = given().when().get(gmapaddress).then().statusCode(200).extract().response().time();
    	System.out.println("Feature Type: "+featureType+" Zoom Level: "+z+" Address: "+RestAssured.baseURI+RestAssured.basePath+gmapaddress + " Time To Load: "+time);
    	assertThat(time, lessThan(5000L));

    }
    @Test
    public void level11Test(){
    	Pixel meters = dbu.getMetersCenterOfRandomFeature(featureType);
    	Integer z = 11;
    	TileCoordConverter tcc = new TileCoordConverter();
    	
    	Pixel tile = tcc.metersToTileGoogle(meters.getX(), meters.getY(), z);
    	String gmapaddress = tcc.getGMapAddressString(z, tile);
    	long time = given().when().get(gmapaddress).then().statusCode(200).extract().response().time();
    	System.out.println("Feature Type: "+featureType+" Zoom Level: "+z+" Address: "+RestAssured.baseURI+RestAssured.basePath+gmapaddress + " Time To Load: "+time);
    	assertThat(time, lessThan(5000L));

    }
    @Test
    public void level12Test(){
    	Pixel meters = dbu.getMetersCenterOfRandomFeature(featureType);
    	Integer z = 12;
    	TileCoordConverter tcc = new TileCoordConverter();
    	
    	Pixel tile = tcc.metersToTileGoogle(meters.getX(), meters.getY(), z);
    	String gmapaddress = tcc.getGMapAddressString(z, tile);
    	long time = given().when().get(gmapaddress).then().statusCode(200).extract().response().time();
    	System.out.println("Feature Type: "+featureType+" Zoom Level: "+z+" Address: "+RestAssured.baseURI+RestAssured.basePath+gmapaddress + " Time To Load: "+time);
    	assertThat(time, lessThan(5000L));

    }
    @Test
    public void level13Test(){
    	Pixel meters = dbu.getMetersCenterOfRandomFeature(featureType);
    	Integer z = 13;
    	TileCoordConverter tcc = new TileCoordConverter();
    	
    	Pixel tile = tcc.metersToTileGoogle(meters.getX(), meters.getY(), z);
    	String gmapaddress = tcc.getGMapAddressString(z, tile);
    	long time = given().when().get(gmapaddress).then().statusCode(200).extract().response().time();
    	System.out.println("Feature Type: "+featureType+" Zoom Level: "+z+" Address: "+RestAssured.baseURI+RestAssured.basePath+gmapaddress + " Time To Load: "+time);
    	assertThat(time, lessThan(5000L));

    }
    @Test
    public void level14Test(){
    	Pixel meters = dbu.getMetersCenterOfRandomFeature(featureType);
    	Integer z = 14;
    	TileCoordConverter tcc = new TileCoordConverter();
    	
    	Pixel tile = tcc.metersToTileGoogle(meters.getX(), meters.getY(), z);
    	String gmapaddress = tcc.getGMapAddressString(z, tile);
    	long time = given().when().get(gmapaddress).then().statusCode(200).extract().response().time();
    	System.out.println("Feature Type: "+featureType+" Zoom Level: "+z+" Address: "+RestAssured.baseURI+RestAssured.basePath+gmapaddress + " Time To Load: "+time);
    	assertThat(time, lessThan(5000L));

    }
    @Test
    public void level15Test(){
    	Pixel meters = dbu.getMetersCenterOfRandomFeature(featureType);
    	Integer z = 15;
    	TileCoordConverter tcc = new TileCoordConverter();
    	
    	Pixel tile = tcc.metersToTileGoogle(meters.getX(), meters.getY(), z);
    	String gmapaddress = tcc.getGMapAddressString(z, tile);
    	long time = given().when().get(gmapaddress).then().statusCode(200).extract().response().time();
    	System.out.println("Feature Type: "+featureType+" Zoom Level: "+z+" Address: "+RestAssured.baseURI+RestAssured.basePath+gmapaddress + " Time To Load: "+time);
    	assertThat(time, lessThan(5000L));

    }
    @Test
    public void level16Test(){
    	Pixel meters = dbu.getMetersCenterOfRandomFeature(featureType);
    	Integer z = 16;
    	TileCoordConverter tcc = new TileCoordConverter();
    	
    	Pixel tile = tcc.metersToTileGoogle(meters.getX(), meters.getY(), z);
    	String gmapaddress = tcc.getGMapAddressString(z, tile);
    	long time = given().when().get(gmapaddress).then().statusCode(200).extract().response().time();
    	System.out.println("Feature Type: "+featureType+" Zoom Level: "+z+" Address: "+RestAssured.baseURI+RestAssured.basePath+gmapaddress + " Time To Load: "+time);
    	assertThat(time, lessThan(5000L));

    }
    
 
   

}
