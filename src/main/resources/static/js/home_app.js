$(document).ready(function () {

    var currentPage;

    getPage(0);

    function getPage(pageNumber) {
        $.ajax({
            url: "/rest/articles/page/" + pageNumber
        }).then(function (data) {
            currentPage = pageNumber;
            $('.body-articles').html("");
            $.each(data.content, function (i, item) {
                $('.body-articles').append(
                    "<tr class='row'>" +
                    "<td class='col-lg-2 text-center'>" + "<img class='profile-image' src='/user/" + item.userId + "/profile'/> </td>" +
                    "<td class='col-lg-2'>" + item.userId + "</td>" +
                    "<td class='col-lg-3'>" + item.content + "</td>" +
                    "<td class='col-lg-3 row'>"
                    + "<form method='post'>"
                    + "<input type='submit' class='btn btn-primary col-lg-4'>"
                    + "</form>"
                    + "<form method='post'>"
                    + "<input type='submit' class='btn btn-danger col-lg-4'>"
                    + "</form>"
                    + "<form method='post'>"
                    + "<input type='submit' class='btn btn-info col-lg-4'>"
                    + "</form>" +
                    "</td>" +
                    "<td class='col-lg-2 article-content'>" + item.date + "</td>" +
                    "</tr>"
                );
            });

            $('.pagination').html("");
            var start = currentPage - 2;
            if (currentPage <= 2) {
                start = 0;
            }
            var end = start + 4;
            if (data.totalPages - 1 < end) {
                end = data.totalPages - 1;
                start = end - 4;
                if(start < 1){
                    start = 1;
                }
            }
            for (i = start; i <= end; i++) {
                if (i == currentPage) {
                    $('.pagination').append(
                        "<li class='active'><a class='page-a'>" + (i + 1) + "</a></li>"
                    );
                }
                else {
                    $('.pagination').append(
                        "<li><a class='page-a'>" + (i + 1) + "</a></li>"
                    );
                }
            }
            $('.page-a').click(function () {
                getPage($(this).html() - 1);
            });
        });
    }

});