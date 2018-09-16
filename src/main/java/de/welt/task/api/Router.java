package de.welt.task.api;

import de.welt.task.utilities.JsonSupport;

import static spark.Spark.get;

/**
 * Assigns the API routes with respective handlers.
 */
final class Router {

    void httpRoutes() {

        get("/aggregations/:id", new ApplicationHandler(), JsonSupport.jsonTransformer());
    }
}
