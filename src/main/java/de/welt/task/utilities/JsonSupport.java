package de.welt.task.utilities;

import spark.ResponseTransformer;

/**
 * Provider for Json payload handling
 */
public interface JsonSupport {

    static ResponseTransformer jsonTransformer() {
        return null;
    }
}
