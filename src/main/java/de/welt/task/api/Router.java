package de.welt.task.api;

import de.welt.task.utilities.JsonSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static spark.Spark.before;
import static spark.Spark.get;

/**
 * Assigns the API routes with respective handlers.
 */
final class Router {

    private static final Logger LOG = LoggerFactory.getLogger(Router.class);

    void httpRoutes() {

        before((request, response) -> LOG.info("Request for [{}]", request.uri()));

        get("/aggregations/:id", new ApplicationHandler(), JsonSupport.jsonTransformer());
    }
}
