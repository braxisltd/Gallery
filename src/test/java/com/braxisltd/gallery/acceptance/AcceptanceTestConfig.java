package com.braxisltd.gallery.acceptance;

import com.braxisltd.gallery.application.ApplicationConfig;
import com.braxisltd.gallery.application.ConfigProvider;

public class AcceptanceTestConfig {

    private AcceptanceTestConfig() {
    }

    public static ApplicationConfig get() {
        return ConfigProvider.provide("src/test/resources/acceptance-config.properties", ApplicationConfig.class);
    }
}
