package com.braxisltd.gallery.request;

import com.braxisltd.gallery.request.wrappers.GalleryRequest;
import com.braxisltd.gallery.request.wrappers.GalleryResponse;
import org.simpleframework.http.Request;
import org.simpleframework.http.Response;

public interface RequestHandler {
    boolean canHandle(GalleryRequest request);
    void handle(GalleryRequest request, GalleryResponse response) throws Exception;
}
