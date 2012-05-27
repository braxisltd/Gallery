package com.braxisltd.gallery.request;

import com.braxisltd.gallery.request.wrappers.GalleryRequest;
import com.braxisltd.gallery.request.wrappers.GalleryResponse;

import java.io.OutputStreamWriter;

public class ErrorHandler implements RequestHandler {
    public ErrorHandler(Exception e) {
    }

    @Override
    public boolean canHandle(GalleryRequest request) {
        return false;
    }

    @Override
    public void handle(GalleryRequest request, GalleryResponse response) throws Exception {
        OutputStreamWriter writer = new OutputStreamWriter(response.getOutputStream());
        writer.append("Sorry, an error has occurred.");
        writer.flush();
        writer.close();
    }
}
