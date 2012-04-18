package com.braxisltd.gallery.application;

import org.slf4j.LoggerFactory;

import java.io.IOException;

public class RunProd {

    public static void main(String[] args) {
        try {
            new GalleryApplication(ConfigProvider.provide(ApplicationConfig.class)).start();
        } catch (IOException e) {
            LoggerFactory.getLogger(RunDev.class).error("An error occurred starting the application", e);
        }
    }
}
