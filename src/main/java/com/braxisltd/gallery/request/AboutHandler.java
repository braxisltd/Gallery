package com.braxisltd.gallery.request;

import com.braxisltd.gallery.Domain.About;
import com.braxisltd.gallery.Domain.Category;
import com.braxisltd.gallery.Domain.Heading;
import com.braxisltd.gallery.application.ApplicationConfig;
import com.braxisltd.gallery.request.models.AboutModel;
import com.braxisltd.gallery.request.wrappers.GalleryRequest;
import com.braxisltd.gallery.request.wrappers.GalleryResponse;

import java.util.List;

public class AboutHandler extends ViewRequestHandler {

    public AboutHandler(ApplicationConfig config) {
        super(config);
    }

    @Override
    public boolean canHandle(GalleryRequest request) {
        return request.getTarget().equals("/");
    }

    @Override
    public void handle(GalleryRequest request, GalleryResponse response) throws Exception {
        List<Category> categories = loadCategories();
        String heading = new Heading(config()).load().getHeading();
        view("about.ftl")
                .withModel("model", new AboutModel(new About(config()).load(), heading, categories))
                .render(response);
    }

}
