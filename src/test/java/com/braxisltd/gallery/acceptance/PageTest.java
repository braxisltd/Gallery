package com.braxisltd.gallery.acceptance;

import com.braxisltd.gallery.application.ApplicationConfig;
import com.braxisltd.gallery.application.GalleryApplication;
import com.braxisltd.gallery.pages.GalleryPage;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class PageTest {
    protected static WebDriver driver;
    protected static GalleryApplication application;
    protected static ApplicationConfig config = AcceptanceTestConfig.get();
    protected GalleryPage galleryPage;
    private Server server;

    @BeforeClass
    public static void beforeSuperClass() {
        driver = new ChromeDriver();
    }

    @AfterClass
    public static void afterSuperClass() throws Exception {
        driver.close();
    }

    @Before
    public void before() throws Exception {
        galleryPage = new GalleryPage(driver, config);
    }

    public static void startSimple() throws Exception {
        application = new GalleryApplication(config).start();
    }

    protected static void stopSimple() throws IOException {
        application.stop();
    }

    protected void startJetty() throws Exception {
        server = new Server(config.getPort());
        WebAppContext root = new WebAppContext();
        root.setContextPath("/");
        root.setDescriptor("src/test/resources/web.xml");
        root.setResourceBase("src/test/resources");
        root.setParentLoaderPriority(true);
        server.setHandler(root);
        server.start();
    }

    protected void stopJetty() throws Exception {
        server.stop();
    }
}
