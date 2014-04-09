//
//	jQuery Validate example script
//
//	Prepared by David Cochran
//
//	Free for your use -- No warranties, no guarantees!
//
$(document).ready(function(){

    $('#form-register').validate({

        rules: {
            firstName: {
                maxlength: 50,
                required: true
            },
            name: {
                maxlength: 50,
                required: true
            },
            email: {
                required: true,
                email: true
            },

            password: {
                minlength: 10,
                maxlength: 20,
                required: true
            },
            passwordRep: {
                equalTo: "#password"
            },
            role: {
                required: true
            }

        },
        messages:{
            name:{
                required: "Gelieve een naam in te vullen",
                maxlength: "Gelieve maximaal {0} karakters te gebruiken"
            },
            firstName:{
                required: "Gelieve een voornaam in te vullen",
                maxlength: "Gelieve maximaal {0} karakters te gebruiken"
            },
            email:{
                required: "Gelieve een email adres in te vullen",
                email: "Het email adres is niet volgens de standaard"
            },
            role:{
                required: "Gelieve een rol te selecteren"
            },
            password:{
                required: "Gelieve een wachtwoord in te vullen",
                minlength: "Het wachtwoord moet minmaal {} karakters bevatten",
                maxlength: "Het wachtwoord mag maximaal {} karakters bevatten"
            },
            passwordRep: {
                equalTo: "Moet gelijk zijn aan paswoord"
            }

        },

        //Todo: fix bug (label not removed)
        highlight: function(element) {
            $(element)
                .closest('.form-group').addClass('error');
        },
        success: function(element) {
            $(element)
                .addClass('valid')
                .closest('.form-group').removeClass('error');
        }
    });

}); // end document.ready

