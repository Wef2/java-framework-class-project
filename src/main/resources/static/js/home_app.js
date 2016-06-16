$(document).ready(function () {

    getPage(0);

    var totalPages;
    var isFirst;
    var isLast;

    function getPage(pageNumber){
        $.ajax({
            url: "/rest/articles/page/" + pageNumber
        }).then(function (data) {
            totalPages = data.totalPages;
            isFirst = data.first;
            isLast = data.last;

            console.log(totalPages);
            console.log(isFirst);
            console.log(isLast);
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

            var i = 0;
            while(i < totalPages){
                $('.paging-btn-group').append(
                    "<button class='btn btn-default'>" + i + "</button>"
                );
                i = i + 1;
            }
            console.log(item);
        });
    }


});