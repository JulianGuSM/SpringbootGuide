$(document).ready(function () {
    $.ajax({
        url: "http://localhost:8080/hello"
    }).then(function (data, status, jqxhr) {
        $('.greet-id').append(data.id);
        $('.greet-content').append(data.content);
        console.log(jqxhr)
    });
});