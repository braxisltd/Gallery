package com.braxisltd.gallery.request.wrappers;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

public class ServletResponse extends GalleryResponse {
    private HttpServletResponse response;

    public ServletResponse(HttpServletResponse response) {
        this.response = response;
    }

    @Override
    public OutputStream getOutputStream() throws IOException {
        return response.getOutputStream();
    }

    @Override
    public void set(String key, String value) {
        response.setHeader(key, value);
    }

    @Override
    public void setDate(String key, long value) {
        response.setDateHeader(key, value);
    }
}
