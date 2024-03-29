var braxis = braxis || {};

braxis.GalleryController = function () {
    this.margin = 10;
};

braxis.GalleryController.prototype = {

    initialise:function () {
        this.resize();
        Galleria.loadTheme('/styles/lib/galleria.classic.js');
        var galleria = $("#gallery").galleria({
            transition:'fade',
            preload:8,
            showInfo:false
        });
    },

    resize: function() {
        $("#gallery").css("height", ($("body").height() - $("div.heading").height() - this.margin) + "px");
    }
};