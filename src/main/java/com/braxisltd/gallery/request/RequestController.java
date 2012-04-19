package com.braxisltd.gallery.request;

import org.simpleframework.http.Request;
import org.simpleframework.http.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private RequestHandler[] handlers;

    public RequestController(RequestHandler... handlers) {
        this.handlers = handlers;
    }

    public void handleRequest(Request request, Response response) {
        logger.debug(String.format("Loading resource for %s", request.getTarget()));
        try {
            for (RequestHandler handler : handlers) {
                if (handler.canHandle(request)) {
                    handler.handle(request, response);
                    return;
                }
            }
        } catch (Exception e) {
            logger.error(String.format("An error occurred handling a request for %s", request.getTarget()), e);
            try {
                new ErrorHandler(e).handle(request, response);
            } catch (Exception errorsError) {
                logger.error("An error occurred when the ErrorHandler tried to handle the error... Oh dear!", errorsError);
            }
        }
    }
}
