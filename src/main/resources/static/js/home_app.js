$(document).ready(function () {

    $.ajax({
        url: "/rest/articles/page/1"
    }).then(function (data) {
        $.each(data.content, function(i, item) {
            $('.body-articles').append(
                "<div class='row'>" + item.id + "</div>"
            );
            console.log(item);
        });
    });

});