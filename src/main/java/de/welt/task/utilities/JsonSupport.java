package de.welt.task.utilities;

import spark.ResponseTransformer;

/**
 * Provider for Json payload handling
 */
public interface JsonSupport {

    static Object jsonParser(String json, Class parseToClass) {
        return GsonProvider.gsonInstance().fromJson(json, parseToClass);
    }

    static ResponseTransformer jsonTransformer() {
        return GsonProvider.gsonInstance()::toJson;
    }
}
