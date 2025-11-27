Feature: Training Course Management API
  As a Training & Development manager at the bank
  I want to manage internal training courses
  So that employees can access high-quality development programs

  Background:
    Given the API is available at "/api/training-courses"

  # ==================================================================
  # CREATE - Mandatory
  # ==================================================================
  Scenario: Successfully create a new training course
    When the client sends a POST request with the following data:
      """
      {
        "title": "Clean Architecture with Spring Boot",
        "description": "Advanced course on hexagonal architecture and DDD",
        "price": 2890.00,
        "durationInHours": 40,
        "level": "ADVANCED"
      }
      """
    Then the HTTP status code should be 201
    And the response should contain a course with title "Clean Architecture with Spring Boot"
    And the field "active" should be true
    And the field "id" should be present

  Scenario: Fail to create a course with negative price
    When the client sends a POST request with the following data:
      """
      {
        "title": "Invalid Course",
        "price": -100.00,
        "durationInHours": 20,
        "level": "BASIC"
      }
      """
    Then the HTTP status code should be 400

  Scenario: Fail to create a course with zero duration
    When the client sends a POST request with the following data:
      """
      {
        "title": "Invalid Duration",
        "price": 1500.00,
        "durationInHours": 0,
        "level": "INTERMEDIATE"
      }
      """
    Then the HTTP status code should be 400

  # ==================================================================
  # READ - List active courses (with pagination & sorting) - Mandatory + Bonus
  # ==================================================================
  Scenario: List only active courses with pagination and sorting
    Given there are 15 active courses and 5 inactive courses in the system
    When the client requests page 0 of size 10 sorted by "price,desc"
    Then the HTTP status code should be 200
    And the response should contain exactly 10 courses
    And all returned courses should have "active" equal to true
    And the courses should be sorted by price in descending order

  Scenario: Pagination returns empty page when exceeding bounds
    Given there are 8 active courses
    When the client requests page 5 of size 10
    Then the HTTP status code should be 200
    And the response should contain an empty list

  # ==================================================================
  # READ - Get by ID (only if active) - Mandatory
  # ==================================================================
  Scenario: Retrieve an active course by ID
    Given an active course with ID 1 exists
    When the client requests the course with ID 1
    Then the HTTP status code should be 200
    And the response should contain the course with ID 1
    And the field "active" should be true

  Scenario: Return 404 when requesting an inactive course by ID
    Given an inactive course with ID 99 exists
    When the client requests the course with ID 99
    Then the HTTP status code should be 404

  Scenario: Return 404 when course ID does not exist
    When the client requests the course with ID 9999
    Then the HTTP status code should be 404

  # ==================================================================
  # UPDATE - Bonus (highly valued)
  # ==================================================================
  Scenario: Successfully update an existing active course
    Given an active course with ID 3 exists
    When the client sends a PUT request to "/3" with:
      """
      {
        "title": "Updated: Domain-Driven Design Fundamentals",
        "description": "Updated description",
        "price": 3200.00,
        "durationInHours": 48,
        "level": "ADVANCED"
      }
      """
    Then the HTTP status code should be 200
    And the response should contain a course with title "Updated: Domain-Driven Design Fundamentals"

  # ==================================================================
  # DELETE (Soft-delete) - Bonus
  # ==================================================================
  Scenario: Deactivate a course (soft-delete)
    Given an active course with ID 5 exists
    When the client sends a DELETE request to "/5"
    Then the HTTP status code should be 204
    And subsequent GET request to "/5" should return 404
    And the course should remain in the database with "active" = false