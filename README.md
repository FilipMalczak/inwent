# Backend

I'm too tired right now.
The project is dirty like fishermans balls after a months trip to the sea. I'll clean it up later.

For now:

    bash build.sh
    bash start.sh [whatever]

First command will build the Java projects and their docker images.
Second will bring up the project. If the second command has any arguments,
then it will follow logs of the backend. To stop looking at logs, hit Ctrl+C.

To kill the app, do

    bash stop.sh

See:

- localhost:8090
  - nice admin panel, look around, I may be asking you to look some shit up there
    if (when) you ever submit a bug to me
- localhost:8080/swagger-ui.html
  - "html", not "htm"
- localhost:8080/v3/api-docs

