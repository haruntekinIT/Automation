package com.insider.apiAutomation;

import com.insider.utilities.ConfigurationReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class CRUDoperationsNegScenarios {

    @BeforeClass
    public void beforeClass() {
        baseURI = ConfigurationReader.get("apiUrl");
    }

     /*
    Given both accept type and content type is JSON
    And request json body is:
        {
          "id": 250,
          "category": {
            "id": 57,
            "name": "Mojo"
          },
          "name": "Moggie",
          "photoUrls": [
            "string"
          ],
          "tags": [
            {
              "id": 57,
              "name": "Mojo"
            }
          ],
          "status": "available"
        }
    When the user sends POST request to https://petstore.swagger.io/v2/pet
    Then status code is 200
    And content type should be application/json
    And json payload should be as follows:
    {
          "id": 250,
          "category": {
            "id": 57,
            "name": "Mojo"
          },
          "name": "Moggie",
          "photoUrls": [
            "string"
          ],
          "tags": [
            {
              "id": 57,
              "name": "Mojo"
            }
          ],
          "status": "available"
        }

     */

    //Post a new pet and get it based on test scenario above
    @Test(priority = 1)
    public void postAndGetNewPetNegative1() throws InterruptedException {

        int petIdToTest = 250;
        String petNameToTest1 = "Moggie";

        //POST method
        String jsonPayloadForPost = "{\n" +
                "          \"id\": " + petIdToTest + ",\n" +
                "          \"category\": {\n" +
                "            \"id\": 57,\n" +
                "            \"name\": \"Mojo\"\n" +
                "          },\n" +
                "          \"name\": \"" + petNameToTest1 + "\",\n" +
                "          \"photoUrls\": [\n" +
                "            \"string\"\n" +
                "          ],\n" +
                "          \"tags\": [\n" +
                "            {\n" +
                "              \"id\": 57,\n" +
                "              \"name\": \"Mojo\"\n" +
                "            }\n" +
                "          ],\n" +
                "          \"status\": \"available\"\n" +
                "        }";

        Response response = given().log().all()
                .accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .body(jsonPayloadForPost)
                .when()
                .post("https://petstore.swagger.io/v2/pet");

        Thread.sleep(10000);

        //prints response body
        response.prettyPrint();
        //verifies if status code is 200 or not
        Assert.assertEquals(response.statusCode(), 200);
        //verifies if content type is application/json
        Assert.assertEquals(response.contentType(), "application/json");

        //asserts if posted data is expected or not
        int id = response.path("id");
        String name = response.path("name");
        String status = response.path("status");

        Assert.assertEquals(id, petIdToTest);
        Assert.assertEquals(name, petNameToTest1);
        Assert.assertEquals(status, "available");

        //GET method
        /*
        Given accept type is JSON
        When the user sends GET request to https://petstore.swagger.io/v2/pet/{postedPetId}
        Then status code is 200
        And the id of posted pet is petIdToTest
        And the name of the posted pet is petNameToTest
        And tha status of the posted pet is available
         */
        int idOfPostedPet = response.path("id");

        Response responseGet = given().log().all().accept(ContentType.JSON)
                .pathParam("id", idOfPostedPet)
                .when().get("/{id}");

        Assert.assertEquals(responseGet.getStatusCode(), 200);
        Assert.assertEquals(idOfPostedPet, petIdToTest);
        Assert.assertEquals(name, petNameToTest1);
        Assert.assertEquals(status, "available");

        Thread.sleep(10000);
    }

    /*
    Given both accept type and content type is JSON
    And request json body is:
        {
          "id": 250,
          "category": {
            "id": 57,
            "name": "Mojo"
          },
          "name": "Moggie",
          "photoUrls": [
            "string"
          ],
          "tags": [
            {
              "id": 57,
              "name": "Kojo"
            }
          ],
          "status": "available"
        }
    When the user sends POST request to https://petstore.swagger.io/v2/pet by using same pet ID and different pet name
    Then status code is 400
    And content type should be application/json

    Actual result     : By using same pet id, name and different tags name, the user can create new pet
    Expected result  : By using same pet id, name and different tags name, the user should not be able to create new pet

     */
    @Test(priority = 2)
    public void postAndGetNewPetNegative2() throws InterruptedException {

        int petIdToTest = 250;
        String petNameToTest2 = "Moggie";

        //POST method
        String jsonPayloadForPost = "{\n" +
                "          \"id\": " + petIdToTest + ",\n" +
                "          \"category\": {\n" +
                "            \"id\": 57,\n" +
                "            \"name\": \"Mojo\"\n" +
                "          },\n" +
                "          \"name\": \"" + petNameToTest2 + "\",\n" +
                "          \"photoUrls\": [\n" +
                "            \"string\"\n" +
                "          ],\n" +
                "          \"tags\": [\n" +
                "            {\n" +
                "              \"id\": 57,\n" +
                "              \"name\": \"Kojo\"\n" +
                "            }\n" +
                "          ],\n" +
                "          \"status\": \"available\"\n" +
                "        }";

        Response response = given().log().all()
                .accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .body(jsonPayloadForPost)
                .when()
                .post("https://petstore.swagger.io/v2/pet");

        Thread.sleep(10000);

        //prints response body
        response.prettyPrint();
        //verifies if status code is 200 or not
        Assert.assertEquals(response.statusCode(), 400);
        //verifies if content type is application/json
        Assert.assertEquals(response.contentType(), "application/json");

        //asserts if posted data is expected or not
        int id = response.path("id");
        String name = response.path("name");
        String status = response.path("status");

        Assert.assertEquals(id, petIdToTest);
        Assert.assertEquals(name, petNameToTest2);
        Assert.assertEquals(status, "available");

    }

}