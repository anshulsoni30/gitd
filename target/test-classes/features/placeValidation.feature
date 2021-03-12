Feature: validating Place API's
@Addplace @Regression
Scenario Outline: verify if place is being succesfully added using addplaceapi
Given Add place payload with "<name>" "<language>" "<address>"
When user calls "AddPlaceAPI" with "POST" http request
Then the api call is success with status code 200
And "status" in response body is "OK"
And "scope" in response body is "APP"
And verify place_id created maps to "<name>" using "getPlaceAPI"

Examples:
    |name  | language |address|
    |anshul| english  |World class center|
 #  |bittu|french |anajd|

 @deleteplace @Regression
 Scenario: verify if delete place functionality working
 Given deletePlace Payload
 When user calls "deletePlaceAPI" with "POST" http request
 Then the api call is success with status code 200
 And "status" in response body is "OK"