package com.braxisltd.gallery.servlet;

import com.braxisltd.gallery.application.ApplicationConfig;
import com.braxisltd.gallery.application.ConfigProvider;
import com.braxisltd.gallery.request.*;
import com.braxisltd.gallery.request.wrappers.GalleryRequest;
import com.braxisltd.gallery.request.wrappers.GalleryResponse;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GalleryServlet extends HttpServlet {

    private ApplicationConfig config;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        String configPath = servletConfig.getInitParameter("configPath");
        if (configPath != null) {
            config = ConfigProvider.provide(configPath, ApplicationConfig.class);
        } else {
            config = ConfigProvider.provide(ApplicationConfig.class);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        new RequestController(
                new AboutHandler(config),
                new GalleryHandler(config),
                new ImageHandler(config),
                new StyleHandler(),
                new ScriptHandler())
                .handleRequest(GalleryRequest.requestFor(req), GalleryResponse.responseFor(resp));
    }
}
