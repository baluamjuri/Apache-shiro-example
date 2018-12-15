function validateForm() {
    var x = document.forms["myForm"]["fname"].value;
    if (x == "") {
        alert("Name must be filled out");
        return false;
    }
}

$(document).ready(function() {
    $('#loginForm').submit(function() {
        $.ajax({
            type: "POST",
            url: '/login',
            data: {
                username: $("#username").val(),
                password: $("#password").val()
            },
            success: function(data)
            {
                if (data === 'Correct') {
                    window.location.replace('/index');
                }
                else {
                    alert(data);
                }
            }
        });
        //this is mandatory other wise your from will be submitted.
        return false; 
    });

});