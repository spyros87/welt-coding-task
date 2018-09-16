package de.welt.task.api;

import com.spotify.futures.CompletableFutures;
import de.welt.task.domain.ResponseContainer;
import de.welt.task.domain.User;
import de.welt.task.domain.UserPost;
import de.welt.task.utilities.JsonSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;
import spark.Route;

import java.time.Instant;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.function.Supplier;

import static com.google.common.net.MediaType.JSON_UTF_8;
import static org.asynchttpclient.Dsl.asyncHttpClient;

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

        LOG.info("Requesting information for Entity: [{}]", id);

        CompletableFuture<User> userResponseFuture = asyncHttpClient().prepareGet("http://jsonplaceholder.typicode.com/users/" + id)
                                                                      .execute()
                                                                      .toCompletableFuture()
                                                                      .thenApply(response -> {
                                                                          LOG.info("parsing response from [{}, {}]", response.getUri(), Instant.now().toEpochMilli());
                                                                          return (User) JsonSupport.jsonParser(response.getResponseBody(), User.class);
                                                                      });

        CompletableFuture<UserPost[]> postResponseFuture = asyncHttpClient().prepareGet("http://jsonplaceholder.typicode.com/posts?userId=" + id)
                                                                            .execute()
                                                                            .toCompletableFuture()
                                                                            .thenApply(response -> {
                                                                                LOG.info("parsing response from [{}, {}]", response.getUri(), Instant.now().toEpochMilli());
                                                                                return (UserPost[]) JsonSupport.jsonParser(response.getResponseBody(), UserPost[].class);
                                                                            });

        return CompletableFutures.combine(userResponseFuture, postResponseFuture, ResponseContainer::new);
    }

}
