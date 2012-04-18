package com.braxisltd.gallery.application;

import org.slf4j.LoggerFactory;

import java.io.IOException;

public class RunDev {

    public static void main(String[] args) {
        try {
            new GalleryApplication(
                    new ApplicationConfig() {
                        @Override
                        public String getScheme() {
                            return "http";
                        }

                        @Override
                        public String getHost() {
                            return "localhost";
                        }

                        @Override
                        public int getPort() {
                            return 80;
                        }

                        @Override
                        public String getDirectoryRoot() {
                            return "C:\\Users\\Darren\\IdeaProjects\\Gallery\\dist\\testimages";
                        }
                    }
            ).start();
        } catch (IOException e) {
            LoggerFactory.getLogger(RunDev.class).error("An error occurred starting the application", e);
        }
    }
}
