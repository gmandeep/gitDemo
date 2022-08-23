Feature: validating place APIs

  Scenario: verify add place
    Given add place Payload "<name>" "<language>" "<address>"
    When user calls addplaceAPI with post http request
    Then the API response is successful with status code 200
    And "status" in response body is "OK"
		And "scope" in response body is "APP"

Examples:

	| name | language | address |
	| rahul | english | delhi  |
 	| dsdd | french |  calcutta |
