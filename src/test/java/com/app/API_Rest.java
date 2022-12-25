package com.app;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static  io.restassured.RestAssured.*;

public class API_Rest {
	
	public static void main(String[] args) {
		// given, when ,then 
		// Post Method 
		RestAssured.baseURI="https://rahulshettyacademy.com/";
	String postresponce=given().log().all().queryParam("key", "qaclick123")
		.header("Content-Type", "application/json")
		.body("{\r\n" + 
				"  \"location\": {\r\n" + 
				"    \"lat\": -38.383494,\r\n" + 
				"    \"lng\": 33.427362\r\n" + 
				"  },\r\n" + 
				"  \"accuracy\": 50,\r\n" + 
				"  \"name\": \"Frontline house\",\r\n" + 
				"  \"phone_number\": \"(+91) 983 893 3937\",\r\n" + 
				"  \"address\": \"29, side layout, cohen 09\",\r\n" + 
				"  \"types\": [\r\n" + 
				"    \"shoe park\",\r\n" + 
				"    \"shop\"\r\n" + 
				"  ],\r\n" + 
				"  \"website\": \"http://google.com\",\r\n" + 
				"  \"language\": \"French-IN\"\r\n" + 
				"}").when().post("maps/api/place/add/json")
			.then().log().all().assertThat().statusCode(200)
			.extract().response().asString();
	System.out.println(postresponce);
	JsonPath js = new JsonPath(postresponce);
	String placeid = js.getString("place_id");
	System.out.println(placeid);
	
	//put 
	given().log().all().queryParam("place_id",placeid )
	.queryParam("key","qaclick123" )
	.header("Content-Type", "application/json")
	.body("{\r\n" + 
			"\"place_id\":\""+placeid+"\",\r\n" + 
			"\"address\":\"70 winter walk, USA\",\r\n" + 
			"\"key\":\"qaclick123\"\r\n" + 
			"}")
	.when().put("maps/api/place/update/json")
	.then().log().all().assertThat().statusCode(200);
	
	//get
	
	String getresponse =given().log().all()
			.queryParam("key","qaclick123" )
			.queryParam("place_id",placeid )
	.header("Content-Type", "application/json")
	.when().get("maps/api/place/update/json")
	.then().assertThat().log().all().statusCode(200)
	.extract().response().asString();
	System.out.println(getresponse);
	
	
	
	
	}
	
	
	
	
	
	
	
	

}
