//registration link calling
function callRegistrationLink() {
    $(document).ready(function () {
        $('#click_goto_registration').click(function () {
            var URL = "${createLink(controller:'user',action:'register')}";
            $.ajax({
                url: URL,
                data: {},
                success: function (resp) {
                    console.log(resp);
                }
            });
        });
    });
}