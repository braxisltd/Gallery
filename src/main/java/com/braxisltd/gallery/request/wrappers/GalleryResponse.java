package com.braxisltd.gallery.request.wrappers;

import org.simpleframework.http.Response;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

public abstract class GalleryResponse {
    public static GalleryResponse responseFor(Response response) {
        return new SimpleResponse(response);
    }

    public static GalleryResponse responseFor(HttpServletResponse response) {
        return new ServletResponse(response);
    }

    public abstract OutputStream getOutputStream() throws IOException;

    public abstract void set(String key, String value);

    public abstract void setDate(String key, long value);
}
