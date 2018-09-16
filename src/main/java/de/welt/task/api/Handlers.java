package de.welt.task.api;

/**
 * Registers the handlers on the respective routes.
 */
public interface Handlers {

    static void routing() {
        new Router().httpRoutes();
    }
}
