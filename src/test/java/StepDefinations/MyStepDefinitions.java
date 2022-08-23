package StepDefinations;


import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static org.junit.Assert.*;  //add manually
import static io.restassured.RestAssured.*;
import pojo.AddPlace;
import pojo.Location;
import resources.TestDataBuild;
import resources.Utils;


@RunWith(Cucumber.class)
public class MyStepDefinitions extends Utils {
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	
	TestDataBuild data = new TestDataBuild();
	 @Given("^add place Payload \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	    public void add_place_payload_something_something_something(String name, String language, String address) throws Throwable {
	  		 
		 resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		 res=given().spec(requestSpecification()).body(data.addPlacePayload(name,language, address));
    }

    @When("^user calls addplaceAPI with post http request$")
    public void user_calls_something_with_post_http_request() throws Throwable {
    	 response =res.when().post("/maps/api/place/add/json").
    			then().spec(resspec).extract().response();
        
    }

    @Then("^the API response is successful with status code 200$")
    public void the_api_response_is_successful_with_status_code_200() throws Throwable {
    	assertEquals(response.getStatusCode(),200);
       
    }

    @And("^\"([^\"]*)\" in response body is \"([^\"]*)\"$")
    public void something_in_response_body_is_something(String key, String value) throws Throwable {
       String resp = response.asString();
       JsonPath js = new JsonPath(resp);
       assertEquals(js.get(key).toString(), value);
       
    }
}