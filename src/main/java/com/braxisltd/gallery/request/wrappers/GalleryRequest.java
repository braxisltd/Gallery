package com.braxisltd.gallery.request.wrappers;

import org.simpleframework.http.Request;

import javax.servlet.http.HttpServletRequest;

public class GalleryRequest {
    private final String target;

    private GalleryRequest(String target) {
        this.target = target;
    }

    public static GalleryRequest requestFor(Request request) {
        return new GalleryRequest(request.getTarget());
    }

    public static GalleryRequest requestFor(HttpServletRequest request) {
        return new GalleryRequest(request.getRequestURI());
    }

    public String getTarget() {
        return target;
    }
}
