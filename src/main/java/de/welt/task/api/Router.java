package de.welt.task.api;

import spark.Spark;

/**
 * Assigns the API routes with respective handlers.
 */
final class Router {

    void httpRoutes() {

        Spark.get("/aggregations/:id", (request, response) -> "Hello");
    }
}
