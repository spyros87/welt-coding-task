package de.welt.task.api;

import de.welt.task.domain.ResponseContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.concurrent.CompletionStage;
import java.util.function.Supplier;

import static com.google.common.net.MediaType.JSON_UTF_8;

public class ApplicationHandler implements Route {

    private static final Logger LOG = LoggerFactory.getLogger(ApplicationHandler.class);

    @Override
    public Object handle(Request request, Response response) throws Exception {
        String id = request.params(":id");
        return responseHandler(response, () -> callRemoteServiceWithParameter(id));
    }

    private Object responseHandler(Response response, Supplier<CompletionStage<? extends Object>> callback) {

        response.status(200);
        response.type(JSON_UTF_8.toString());

        return callback.get().toCompletableFuture().join();
    }

    private CompletionStage<ResponseContainer> callRemoteServiceWithParameter(String id) {

        return null;
    }
}
