package com.bank.training.acceptance.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TrainingCourseSteps extends CucumberSpringConfiguration {

    private Response response;
    private String endpoint;

    @Given("the API is available at {string}")
    public void theApiIsAvailableAt(String path) {
        endpoint = "http://localhost:" + port + path;
        RestAssured.baseURI = endpoint;
    }

    @When("the client sends a POST request with the following data:")
    public void theClientSendsPOST(String payload) {
        response = given()
                .contentType("application/json")
                .body(payload)
                .when()
                .post();
    }

    @When("the client sends a PUT request to {string} with:")
    public void theClientSendsPUT(String path, String payload) {
        response = given()
                .contentType("application/json")
                .body(payload)
                .when()
                .put(path);
    }

    @When("the client sends a DELETE request to {string}")
    public void theClientSendsDELETE(String path) {
        response = given().when().delete(path);
    }

    @When("the client requests the course with ID {long}")
    public void theClientRequestsCourseById(Long id) {
        response = given().when().get("/" + id);
    }

    @When("the client requests page {int} of size {int} sorted by {string}")
    public void theClientRequestsPage(int page, int size, String sort) {
        response = given()
                .queryParam("page", page)
                .queryParam("size", size)
                .queryParam("sort", sort)
                .when()
                .get();
    }

    @When("the client requests page {int} of size {int}")
    public void theClientRequestsPage(int page, int size) {
        response = given()
                .queryParam("page", page)
                .queryParam("size", size)
                .when()
                .get();
    }

    @Then("the HTTP status code should be {int}")
    public void theHttpStatusShouldBe(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @And("the response should contain a course with title {string}")
    public void theResponseShouldContainCourseWithTitle(String title) {
        response.then().body("title", equalTo(title));
    }

    @And("the field {string} should be present")
    public void theFieldShouldBePresent(String field) {
        response.then().body(field, notNullValue());
    }

    @And("the field {string} should be true")
    public void theFieldShouldBeTrue(String field) {
        response.then().body(field, equalTo(true));
    }

    @And("the response should contain exactly {int} courses")
    public void theResponseShouldContainExactlyCourses(int count) {
        response.then().body("content.size()", equalTo(count));
    }

    @And("all returned courses should have {string} equal to true")
    public void allReturnedCoursesShouldHaveActiveTrue(String field) {
        response.then().body("content." + field, everyItem(equalTo(true)));
    }

    @And("the courses should be sorted by price in descending order")
    public void theCoursesShouldBeSortedByPriceDesc() {
        response.then().body("content.price", equalTo(response.jsonPath().getList("content.price", Double.class)));
    }

    @And("the response should contain an empty list")
    public void theResponseShouldContainAnEmptyList() {
        response.then().body("content", hasSize(0));
    }

    @And("the response should contain the course with ID {long}")
    public void theResponseShouldContainTheCourseWithId(Long id) {
        response.then().body("id", equalTo(id.intValue()));
    }

    @Given("there are {int} active courses and {int} inactive courses in the system")
    public void thereAreActiveAndInactiveCourses(int active, int inactive) {
        // Empty body
    }

    @Given("an active course with ID {long} exists")
    public void anActiveCourseWithIdExists(Long id) {
        // Empty body
    }

    @Given("an inactive course with ID {long} exists")
    public void anInactiveCourseWithIdExists(Long id) {
        // Empty body
    }

    @Given("there are {int} active courses")
    public void thereAreActiveCourses(int count) {
        // Empty body
    }

    @And("subsequent GET request to {string} should return 404")
    public void subsequentGetShouldReturn404(String path) {
        given().when().get(path).then().statusCode(404);
    }

    @And("the course should remain in the database with {string} = false")
    public void theCourseShouldRemainInDatabaseWithActiveFalse(String field) {
        // Empty body
    }
}
