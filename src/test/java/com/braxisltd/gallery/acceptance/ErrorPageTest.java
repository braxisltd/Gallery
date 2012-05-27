package com.braxisltd.gallery.acceptance;

import com.braxisltd.gallery.application.ApplicationConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;
import static org.mockito.Mockito.*;

public class ErrorPageTest extends PageTest {

    @Before
    public void beforeClass() throws Exception {
        config = mock(ApplicationConfig.class);
        when(config.getScheme()).thenReturn("http");
        when(config.getHost()).thenReturn("localhost");
        when(config.getPort()).thenReturn(8080);
        when(config.getDirectoryRoot()).thenReturn("should not exist");
        startSimple();
        galleryPage.goTo();
    }

    @After
    public void afterClass() throws IOException {
        stopSimple();
        config = AcceptanceTestConfig.get();
    }

    @Test
    public void shouldShowErrorPage() throws Exception {
        assertThat(driver.getPageSource().toLowerCase(), containsString("an error has occurred"));
    }

}
