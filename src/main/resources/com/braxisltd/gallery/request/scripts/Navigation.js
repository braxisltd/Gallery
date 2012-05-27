var braxis = braxis || {};

braxis.Navigation = function () {

};

braxis.Navigation.prototype = {

    initialise:function () {
        var categoryShower = new braxis.CategoryShower($("#categories"));
        $("#navigation li.categories").mouseover(function () {
//            $("#categories").removeClass("hidden");
            categoryShower.show();
        });
        $("#navigation li.categories").mouseout(function () {
            categoryShower.hide();
//            $("#categories").addClass("hidden");
//            setTimeout(
//                function() {
//                    $("#categories").addClass("hidden");
//                },
//                2000
//            )
        });
    }
};

braxis.CategoryShower = function(categoryContainer) {

    var toHide = false;

    function show() {
        toHide = false;
        $("#categories").removeClass("hidden");
    }

    function hide() {
        toHide = true;
        setTimeout(
            function() {
                if (toHide) {
                    $("#categories").addClass("hidden");
                    toHide = false;
                }
            },
            500
        )
    }

    return {
        "show" : show,
        "hide" : hide
    }
}