$(document).ready(function () {

    var currentTime = new Date();
    var currentUserId = $('#userId').text();
    console.log(currentUserId);
    var currentPage;

    if (currentUserId.length > 0) {
        setUser(currentUserId);
    }
    setPageView(0);

    function setUser(userId) {
        $.ajax({
            url: "/rest/user/" + userId
        }).then(function (data) {
            $('.user-data-div').html("<strong><p>" + data.name + "</p></strong>"
                + "<p>" + data.description + "</p>");
        });
    }

    function setPageView(pageNumber) {
        $.ajax({
            url: "/rest/articles/page/" + pageNumber
        }).then(function (data) {
            currentPage = pageNumber;
            $('.body-articles').html("");
            $.each(data.content, function (i, item) {
                var dateString = getDateString(item.date);
                $('.body-articles').append(
                    "<tr class='row'>" +
                    "<td class='col-lg-2 text-center'>" + "<img class='profile-image' src='/user/" + item.userId + "/profile'/> </td>" +
                    "<td class='col-lg-2'>" + item.userId + "</td>" +
                    "<td class='col-lg-3'>" + item.content + "</td>" +
                    "<td class='col-lg-3 row'>"
                    + "<form method='post'>"
                    + "<input type='submit' class='btn btn-primary col-lg-4' value='추천'>"
                    + "</form>"
                    + "<form method='post'>"
                    + "<input type='submit' class='btn btn-danger col-lg-4' value='반대'>"
                    + "</form>"
                    + "<form method='post'>"
                    + "<input type='submit' class='btn btn-info col-lg-4' value='삭제'>"
                    + "</form>" +
                    "</td>" +
                    "<td class='col-lg-2 article-content'>" + dateString + "</td>" +
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
                if (start < 1) {
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
                setPageView($(this).html() - 1);
            });
        });
    }

    function getDateString(date){
        var returnString = "";
        var diff = parseInt((currentTime - date) / 1000);
        if(diff < 3600){
            diff = parseInt(diff / 60) + 1;
            returnString = diff + "분 전"
        } else if(diff < 86400){
            diff = parseInt(diff / 3600) + 1;
            returnString = diff + "시간 전"
        } else{
            returnString = date.toLocaleDateString();
        }
        return returnString;
    }

});