package com.app;

import io.restassured.path.json.JsonPath;

public class SampleApi {
	public static void main(String[] args) {
		JsonPath js = new JsonPath(PayLoad.payLoad1());
		int count = js.getInt("courses.size()");
		System.out.println("No of courses returned by API:"+count);
		int amt = js.getInt("dashboard.purchaseAmount");
		System.out.println("Purchase Amount:" + amt);
		String title = js.getString("courses.title[0]");
		System.out.println("Title of the first course:" +title);
		System.out.println("All course titles and their respective Prices:");
		for(int i=0; i<count; i++) {
			String allTitles = js.get("courses["+i+"].title");
			int allPrices = js.getInt("courses["+i+"].price");
			System.out.println(allTitles);
			System.out.println(allPrices);
		}
		String RPA = js.getString("courses[2].copies");
		System.out.println("No of copies sold by RPA Course:"+RPA);
		int sum =0;
		for(int i=0; i<count; i++) {
		int totalPrice = js.getInt("courses["+i+"].price");
		sum= sum+ totalPrice ;
		}
		System.out.println("Sum of all Course prices:"+sum);
		if(sum == amt) {
			System.out.println("Sum of all Course prices matches with Purchase Amount: True");
		}
			else  {
				System.out.println("Sum of all Course prices matches with Purchase Amount: Flase");	
			}
		}
		
		
	}


