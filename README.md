# inwent

> INdexer for Web contENT

Elastic is for searching documents. Google is for searching unstructuredd web. This is for describing and searching web content, as found under URLs and identified with URIs. Think: images, videos, audio, etc; think: reddit, 4chan, tumblr, etc.

## Quickstart

> Not much to show, but the OpenAPI is in pretty good shape and the implementation will use it as reference.

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
- localhost:8091
  - this is pgAdmin4 instance
  - admin@inwe.nt / pass
  - use hostname=inwent-postgres, port=5432, user=inwent, pass=inwent-pass
  - localhost:5432 is exposing postgres to your machine if you wanna run code in IDE or smth


