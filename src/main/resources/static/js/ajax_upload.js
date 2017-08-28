$(document).ready(function () {

    $("#uploadButton").click(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        customized_ajax_submit();

    });

});

function customized_ajax_submit() {

    // Get form
    var form = $('#upload')[0];

    var data = new FormData(form);

    $("#uploadButton").prop("disabled", true);

    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "/upload",
        data: data,
        processData: false, //prevent jQuery from automatically transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {

            $("#result").text(data);
            console.log("SUCCESS : ", data);
            $("#uploadButton").prop("disabled", false);

        },
        error: function (error) {

            $("#result").text(error.responseText);
            console.log("ERROR : ", error);
            $("#uploadButton").prop("disabled", false);

        }
    });

}