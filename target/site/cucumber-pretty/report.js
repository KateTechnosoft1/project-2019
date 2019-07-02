$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("hotels.feature");
formatter.feature({
  "line": 2,
  "name": "Verify user can only view the result by selected property class",
  "description": "",
  "id": "verify-user-can-only-view-the-result-by-selected-property-class",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@web"
    }
  ]
});
formatter.before({
  "duration": 4962119306,
  "status": "passed"
});
formatter.background({
  "line": 5,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 6,
  "name": "I am on default locations search result screen",
  "keyword": "Given "
});
formatter.match({
  "location": "Hotels.iAmOnAHotelsPage()"
});
formatter.result({
  "duration": 4970971793,
  "status": "passed"
});
formatter.scenario({
  "line": 23,
  "name": "List of all of hotel within 10 miles radius of airport or downtown",
  "description": "",
  "id": "verify-user-can-only-view-the-result-by-selected-property-class;list-of-all-of-hotel-within-10-miles-radius-of-airport-or-downtown",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 22,
      "name": "@hotels-radius"
    }
  ]
});
formatter.step({
  "line": 24,
  "name": "I verify system displays all hotels within 10 miles radius of airport",
  "keyword": "Then "
});
formatter.step({
  "line": 25,
  "name": "I verify Hilton Hotel is within radius",
  "keyword": "And "
});
formatter.match({
  "location": "Hotels.verifyRadius()"
});
formatter.result({
  "duration": 8530127509,
  "status": "passed"
});
formatter.match({
  "location": "Hotels.verifyHiltonRadius()"
});
formatter.result({
  "duration": 530627751,
  "status": "passed"
});
formatter.after({
  "duration": 334047859,
  "status": "passed"
});
});