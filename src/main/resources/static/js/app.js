$(document).ready(function(){
    function readURL(input) {
        if (input.files && input.files[0]) {
            var fileReader = new FileReader();
            fileReader.onload = function (event) {
                $('#preview-image').attr('src', event.target.result);
            }
            fileReader.readAsDataURL(input.files[0]);
        }
    }

    $("#input-image").change(function () {
        readURL(this);
    });
});