//
//	jQuery Validate example script
//
//	Prepared by David Cochran
//
//	Free for your use -- No warranties, no guarantees!
//
$(document).ready(function () {

    $('#form-login').validate({

        rules: {
            username: {
                maxlength: 255,
                required: true
            },
            password: {
                maxlength: 255,
                required: true
            }

        },
        messages: {
            username: {
                required: "Gelieve een gebruikersnaam in te vullen"
            },
            password: {
                required: "Gelieve een wachtwoord in te vullen"
            }
        },

        highlight: function (element) {
            $(element)
                .closest('.form-group').addClass('error');
        },
        success: function (element) {
            $(element)
                .addClass('valid')
                .closest('.form-group').removeClass('error');
        }
    });

}); // end document.ready

