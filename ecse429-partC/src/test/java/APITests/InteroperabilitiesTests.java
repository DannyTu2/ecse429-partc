package APITests;

import io.restassured.RestAssured;
import io.restassured.response.*;
import io.restassured.specification.RequestSpecification;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;


public class InteroperabilitiesTests {

    int ID;
    int ID2;

    int ID21;
    int ID22;

    int ID31;
    int ID32;

    public InteroperabilitiesTests() {
        RestAssured.baseURI = "http://localhost:4567";
    }

    //Interoperabilites will be shortened to intero
    // create Intero test
    @Test
    public void testCreateInteroProjectOfCategory() throws JSONException {

        String title = "Test";
        String description = "Random";

        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("title", title);
        requestParams.put("description", description);

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


        String title1 = "Test";
        String description1 = "Random";

        RequestSpecification request1 = RestAssured.given();

        JSONObject requestParams1 = new JSONObject();
        requestParams1.put("title", title1);
        requestParams1.put("description", description1);

        request1.body(requestParams1.toJSONString());

        Response response1 = request1.post("/categories/"+ID+"/projects");
        response1.then();
        String body1 = response1.getBody().asString();
        org.json.JSONObject jsonResponse1 = new org.json.JSONObject(body1);
        ID2 = jsonResponse1.getInt("id");

        response1.then()
                .assertThat()
                .statusCode(equalTo(201))
                .body("title", equalTo(title1),
                        "description", equalTo(description1));
    }



    // delete project of category test
    @Test
    public void testDeleteProjectOfCategory() {

        RequestSpecification request = RestAssured.given();
        request.delete("/categories/" + ID + "/projects/"+ID2).then().assertThat().statusCode(200);
    }

    // create Intero test for category of todo
    @Test
    public void testCreateInteroCategoryOfTodo() throws JSONException {

        String title = "Test";
        String description = "Random";

        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("title", title);
        requestParams.put("description", description);

        request.body(requestParams.toJSONString());

        Response response = request.post("/todos");
        response.then();
        String body = response.getBody().asString();
        org.json.JSONObject jsonResponse = new org.json.JSONObject(body);
        ID21 = jsonResponse.getInt("id");

        response.then()
                .assertThat()
                .statusCode(equalTo(201))
                .body("title", equalTo(title),
                        "description", equalTo(description));


        String title1 = "Test";
        String description1 = "Random";

        RequestSpecification request1 = RestAssured.given();

        JSONObject requestParams1 = new JSONObject();
        requestParams1.put("title", title1);
        requestParams1.put("description", description1);

        request1.body(requestParams1.toJSONString());

        Response response1 = request1.post("/todos/"+ID21+"/categories");
        response1.then();
        String body1 = response1.getBody().asString();
        org.json.JSONObject jsonResponse1 = new org.json.JSONObject(body1);
        ID22 = jsonResponse1.getInt("id");

        response1.then()
                .assertThat()
                .statusCode(equalTo(201))
                .body("title", equalTo(title1),
                        "description", equalTo(description1));
    }



    // delete project of category test
    @Test
    public void testDeleteCategoryOfTodos() {

        RequestSpecification request = RestAssured.given();
        request.delete("/todos/" + ID21 + "/categories/"+ID22).then().assertThat().statusCode(200);
    }

    // create Intero test for category of todo
    @Test
    public void testCreateInteroTaskOfProject() throws JSONException {

        String title = "Test";
        String description = "Random";

        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("title", title);
        requestParams.put("description", description);

        request.body(requestParams.toJSONString());

        Response response = request.post("/projects");
        response.then();
        String body = response.getBody().asString();
        org.json.JSONObject jsonResponse = new org.json.JSONObject(body);
        ID31 = jsonResponse.getInt("id");

        response.then()
                .assertThat()
                .statusCode(equalTo(201))
                .body("title", equalTo(title),
                        "description", equalTo(description));


        String title1 = "Test";
        String description1 = "Random";

        RequestSpecification request1 = RestAssured.given();

        JSONObject requestParams1 = new JSONObject();
        requestParams1.put("title", title1);
        requestParams1.put("description", description1);

        request1.body(requestParams1.toJSONString());

        Response response1 = request1.post("/projects/"+ID31+"/tasks");
        response1.then();
        String body1 = response1.getBody().asString();
        org.json.JSONObject jsonResponse1 = new org.json.JSONObject(body1);
        ID32 = jsonResponse1.getInt("id");

        response1.then()
                .assertThat()
                .statusCode(equalTo(201))
                .body("title", equalTo(title1),
                        "description", equalTo(description1));
    }



    // delete project of category test
    @Test
    public void testDeleteTasksOfProject() {

        RequestSpecification request = RestAssured.given();
        request.delete("/projects/" + ID31 + "/tasks/"+ID32).then().assertThat().statusCode(200);
    }

}

