$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("darkskytime.feature");
formatter.feature({
  "line": 2,
  "name": "Verify timeline is displayed with 2 hour increments",
  "description": "",
  "id": "verify-timeline-is-displayed-with-2-hour-increments",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@web"
    }
  ]
});
formatter.before({
  "duration": 4190646226,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "I am on Darksky homepage",
  "keyword": "Given "
});
formatter.match({
  "location": "DarkskyTime.iAmOnDarkSkyHomeTime()"
});
formatter.result({
  "duration": 727485195,
  "status": "passed"
});
formatter.scenario({
  "line": 9,
  "name": "Verify timeline is displayed with 2 hour increments",
  "description": "",
  "id": "verify-timeline-is-displayed-with-2-hour-increments;verify-timeline-is-displayed-with-2-hour-increments",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 8,
      "name": "@darksky-time"
    }
  ]
});
formatter.step({
  "line": 10,
  "name": "I verify timeline is displayed with two hours incremented",
  "keyword": "Then "
});
formatter.match({
  "location": "DarkskyTime.verifyTimeline()"
});
formatter.result({
  "duration": 347095362,
  "status": "passed"
});
formatter.after({
  "duration": 170763428,
  "status": "passed"
});
});