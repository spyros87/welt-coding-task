package de.welt.task;

import static spark.Spark.exception;
import static spark.Spark.get;
import static spark.Spark.port;

public final class Boot {

    public static void main(String[] args) {

        port(8080);

        get("/aggregations/:id", (request, response) -> "Hello");

        exception(Exception.class, (exception, request, response) -> {
            response.status(503);
            response.body(exception.getMessage());
        });
    }
}
