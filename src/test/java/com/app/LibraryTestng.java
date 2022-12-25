package com.app;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class LibraryTestng {
	@Test
	public void post() {
		JsonPath js = new JsonPath(BaseClass.payLoad1());
		RestAssured.baseURI="https://rahulshettyacademy.com/Library/Addbook.php";
		given().log().all().header("Content-Type","application/json")
		.body(js.getString(null))
		
	}

}
