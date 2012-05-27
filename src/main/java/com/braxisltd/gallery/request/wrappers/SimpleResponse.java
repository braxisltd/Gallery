package com.braxisltd.gallery.request.wrappers;

import org.simpleframework.http.Response;

import java.io.IOException;
import java.io.OutputStream;

public class SimpleResponse extends GalleryResponse {
    private Response response;

    SimpleResponse(Response response) {
        this.response = response;
    }

    @Override
    public OutputStream getOutputStream() throws IOException {
        return response.getOutputStream();
    }

    @Override
    public void set(String key, String value) {
        response.set(key, value);
    }

    @Override
    public void setDate(String key, long value) {
        response.setDate(key, value);
    }
}
