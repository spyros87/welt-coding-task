package de.welt.task.api;

import de.welt.task.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;
import spark.Route;

import static com.google.common.net.MediaType.JSON_UTF_8;

public class ApplicationHandler implements Route {
    private static final Logger LOG = LoggerFactory.getLogger(ApplicationHandler.class);

    @Override
    public Object handle(Request request, Response response) throws Exception {
        response.status(200);
        response.type(JSON_UTF_8.toString());

        User user = new User();
        String id = request.params(":id");
        user.setId(Integer.valueOf(id));
        user.setName("test");
        return user;
    }
}
