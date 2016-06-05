package com.example.restservicedemo;

import com.example.restservicedemo.domain.Chair;
import com.example.restservicedemo.domain.Person;
import com.jayway.restassured.RestAssured;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;

import static com.jayway.restassured.RestAssured.delete;
import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.path.json.JsonPath.from;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;


public class ChairServiceTest {
	
	private static Chair c1;
	private static Chair c2;
	private static Chair c3;

    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/restservicedemo/api";
		c1 = new Chair("Oxford", 1999);
		c2 = new Chair("Mirabel", 2016);
		c3 = new Chair("Pawlosz", 2010);
    }
    
	@Before
	@After
	public void clearDB(){
		delete("/chair/").then().assertThat().statusCode(200);
		delete("/person/").then().assertThat().statusCode(200);
	}
	
    @Test
    public void addChairs() throws JSONException {

        given().
                contentType(MediaType.APPLICATION_JSON).
                body(c1).
                when().
                post("/chair/add").then().assertThat().statusCode(201);


        String chairs = get("/chair/all").asString();

        HashMap<Chair, Person> returnedChairs = from(chairs).get("chair");

        JSONObject json = new JSONObject(returnedChairs);

        Chair rChair = get("/chair/" + json.get("id")).as(Chair.class);

        assertThat(c1.getModel(), equalToIgnoringCase(rChair.getModel()));
    }

	@Test
	public void getAllChairs(){

		given().
				contentType(MediaType.APPLICATION_JSON).
				body(c1).
				when().
				post("/chair/add").then().assertThat().statusCode(201);
		given().
				contentType(MediaType.APPLICATION_JSON).
				body(c2).
				when().
				post("/chair/add").then().assertThat().statusCode(201);
		given().
				contentType(MediaType.APPLICATION_JSON).
				body(c3).
				when().
				post("/chair/add").then().assertThat().statusCode(201);

		String result = get("/chair/all/").asString();

		List<Chair> chairs = from(result).get("chair");

		assertNotNull(chairs);
		assertEquals(3, chairs.size());

	}

}