# welt-coding-task

## Intro
This is the implementation of **Mashup API** application. The *Java* application
runs locally and it exposes API to invoke the merging functionality.

It combines data from the proposed sources and consolidates them into a single
payload.

## How to run
The application can be compiled and executed by running the following command:
```bash
sh run-app.sh
```

## How to combine data
The application exposes a simplistic API to invoke the aggregation.
In order to trigger it, execute the following command:
```bash
curl http://localhost:8080/aggregations/{user-id}
```
After the successful execution of the command, a json payload is received.
