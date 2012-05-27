package com.braxisltd.gallery.request;

import com.braxisltd.gallery.request.wrappers.GalleryRequest;
import com.braxisltd.gallery.request.wrappers.GalleryResponse;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class RequestControllerTest {

    private final RequestHandler firstAdded = mock(RequestHandler.class);
    private final RequestHandler secondAdded = mock(RequestHandler.class);
    private final GalleryRequest request = mock(GalleryRequest.class);
    private final GalleryResponse response = mock(GalleryResponse.class);
    private final RequestController requestController = new RequestController(firstAdded, secondAdded);

    @Before
    public void before() throws Exception {
    }

    @Test
    public void firstShouldServiceRequest() throws Exception {
        stub(firstAdded.canHandle(request)).toReturn(true);
        stub(secondAdded.canHandle(request)).toReturn(false);

        requestController.handleRequest(request, response);

        verify(firstAdded).handle(request, response);
        verify(secondAdded, never()).handle(request, response);
    }

    @Test
    public void secondShouldServiceRequest() throws Exception {
        stub(firstAdded.canHandle(request)).toReturn(false);
        stub(secondAdded.canHandle(request)).toReturn(true);

        requestController.handleRequest(request, response);

        verify(firstAdded, never()).handle(request, response);
        verify(secondAdded).handle(request, response);
    }
}
