package APITests;

import io.restassured.RestAssured;
import io.restassured.response.*;
import io.restassured.specification.RequestSpecification;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;

public class CategoriesTests {

    int ID;

    public CategoriesTests() {
        RestAssured.baseURI = "http://localhost:4567";
    }

    //create project test
    @Test
    public void testCreateCategory() throws JSONException {

        String title = "CategoryTest";
        String description = "Random";

        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("title",title);
        requestParams.put("description",description);

        request.body(requestParams.toJSONString());

        Response response = request.post("/categories");
        response.then();
        String body = response.getBody().asString();
        org.json.JSONObject jsonResponse = new org.json.JSONObject(body);
        ID = jsonResponse.getInt("id");

        response.then()
                .assertThat()
                .statusCode(equalTo(201))
                .body("title", equalTo(title),
                        "description", equalTo(description));
    }

    // edit project test
    @Test
    public void testModifyCategory() {

        int categoryID = ID;
        String newTitle = "title";
        String newDescription = "newDescription";

        RequestSpecification request = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("title", newTitle);
        requestParams.put("description", newDescription);

        request.body(requestParams.toJSONString());

        Response response = request.post("/categories/" + categoryID);

        response.then()
                .assertThat()
                .statusCode(equalTo(200))
                .body("title", equalTo(newTitle),
                        "description", equalTo(newDescription));
    }

    //delete project test
    @Test
    public void testDeleteCategory(){
        int categoryID = ID;

        RequestSpecification request = RestAssured.given();

        request.delete("/categories/" + categoryID).then().assertThat().statusCode(200);


    }



}
