package de.welt.task;

import de.welt.task.api.Handlers;

import static spark.Spark.exception;
import static spark.Spark.port;

public final class Boot {

    public static void main(String[] args) {

        port(8080);

        Handlers.routing();

        exception(Exception.class, (exception, request, response) -> {
            response.status(503);
            response.body(exception.getMessage());
        });
    }
}
