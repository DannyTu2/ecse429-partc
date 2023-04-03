package APITests;

import io.restassured.RestAssured;
import io.restassured.response.*;
import io.restassured.specification.RequestSpecification;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;


public class ProjectsTests {

    int ID;

    public ProjectsTests() {
        RestAssured.baseURI = "http://localhost:4567";
    }

    //create project test
    @Test
    public void testCreateProject() throws JSONException {

        String title = "ProjectTest";
        boolean completed = false;
        String description = "Random";

        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("title",title);
        requestParams.put("completed", completed);
        requestParams.put("description",description);

        request.body(requestParams.toJSONString());

        Response response = request.post("/projects");
        response.then();
        String body = response.getBody().asString();
        org.json.JSONObject jsonResponse = new org.json.JSONObject(body);
        ID = jsonResponse.getInt("id");

        response.then()
                .assertThat()
                .statusCode(equalTo(201))
                .body("title", equalTo(title),
                        "completed", equalTo(String.valueOf(completed)),
                        "description", equalTo(description));
    }

    // edit project test

    @Test
    public void testModifyProject() {

        int projectID = ID;
        String newTitle = "title";
        boolean newCompleted = true;
        String newDescription = "newDescription";

        RequestSpecification request = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("title", newTitle);
        requestParams.put("completed", newCompleted);
        requestParams.put("description", newDescription);

        request.body(requestParams.toJSONString());

        Response response = request.post("/projects/" + projectID);

        response.then()
                .assertThat()
                .statusCode(equalTo(200))
                .body("title", equalTo(newTitle),
                        "completed", equalTo(String.valueOf(newCompleted)),
                        "description", equalTo(newDescription));
    }

    //delete project test

    @Test
    public void testDeleteProject(){
        int projectId = ID;

        RequestSpecification request = RestAssured.given();

        request.delete("/projects/" + projectId).then().assertThat().statusCode(200);


    }






}
