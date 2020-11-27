# Kotlin Stack

A mini example of a Kotlin implementation of a web-app stack containing an "all in
one" web server. The web server contains a basic controller capable of serving a greeting endpoint
 as well as an in memory database.

The front-end is a shell application based upon [KVision](https://github.com/rjaros/kvision) (a front end Kotlin framework) that
uses the web server to fetch contents and display them to the user.

# Running

Would recommend running each application from it's own seperate 'process' i.e own terminal
space but the following can be used to start both in parallel.

```bash
kotlin-web-server/./gradlew -p kotlin-web-server bootRun &
kotlin-front-end/./gradlew -p kotlin-front-end run &
```

To kill

```bash
pkill -f '.*GradleDaemon.*'
```

# Populating the DB

On startup the in memory db will be empty, the web server runs on 8080 by default. To populate send
a post request to [local](localhost:8080/save) with

```json
{
	"id" : 1,
	"firstName": "A",
	"lastName" : "NAME"
}
```

# Hitting the front end

The front end should be available on [3000](http://localhost:3000/). An alert will pop up to the user
if they enter a valid `lastName` into the search bar.

