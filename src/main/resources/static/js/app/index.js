var index = {
    init: function() {
        var _this = this;
        /*
        $('#login').on('click', function(e) {
            console.log("login clicked");
            _this.login();
        });
        */
    },
    login: function() {
        var data = {
            userId: $('#id').val(),
            userPassword: $('#password').val()
        };
        console.log(JSON.stringify(data));
        $.ajax({
            type: 'POST',
            url: '/memo/login',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            window.location.href = '/';
        }).fail(function(error){
            console.log("login fail");
            alert(JSON.stringify(error));
            window.location.href = '/memo/login';
        });
    }
}

index.init();