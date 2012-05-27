package com.braxisltd.gallery.acceptance;

import com.braxisltd.gallery.Domain.Category;
import com.braxisltd.gallery.util.TestUtil;
import org.junit.Test;

public class GalleryTest extends PageTest {

    private static final Category CATEGORY_ONE = Category.fromName("Category One");
    private static final Category CATEGORY_TWO = Category.fromName("Category Two");

    @Test
    public void shouldNavigateGalleryCategoriesInSimple() throws Exception {
        startSimple();
        galleryPage.goTo();
        galleryPage.assertHeadingPresent(config);
        galleryPage.assertAboutTextPresent(config);
        galleryPage.assertPageContainsInvisibleCategory(CATEGORY_ONE);
        galleryPage.assertPageContainsInvisibleCategory(CATEGORY_TWO);
        galleryPage.selectCategory(CATEGORY_ONE);
        galleryPage.assertHeadingPresent(config);
        galleryPage.assertImagesShownAre(TestUtil.imagesFor(CATEGORY_ONE, config));
        galleryPage.selectCategory(CATEGORY_TWO);
        galleryPage.assertHeadingPresent(config);
        galleryPage.assertImagesShownAre(TestUtil.imagesFor(CATEGORY_TWO, config));
        stopSimple();
    }

    @Test
    public void shouldNavigateGalleryCategoriesInServletContainer() throws Exception {
        startJetty();
        galleryPage.goTo();
        galleryPage.assertHeadingPresent(config);
        galleryPage.assertAboutTextPresent(config);
        galleryPage.assertPageContainsInvisibleCategory(CATEGORY_ONE);
        galleryPage.assertPageContainsInvisibleCategory(CATEGORY_TWO);
        galleryPage.selectCategory(CATEGORY_ONE);
        galleryPage.assertHeadingPresent(config);
        galleryPage.assertImagesShownAre(TestUtil.imagesFor(CATEGORY_ONE, config));
        galleryPage.selectCategory(CATEGORY_TWO);
        galleryPage.assertHeadingPresent(config);
        galleryPage.assertImagesShownAre(TestUtil.imagesFor(CATEGORY_TWO, config));
        stopJetty();
    }

}
