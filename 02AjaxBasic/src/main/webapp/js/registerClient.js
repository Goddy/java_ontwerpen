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
            name: {
                maxlength: 50,
                required: true
            },
            email: {
                required: true,
                email: true
            },
            vat: {
                maxlength: 20,
                required: true
            },
            street: {
                maxlength: 50,
                required: true
            },
            number: {
                maxlength: 10,
                required: true
            },
            postalCode: {
                maxlength: 15,
                required: true
            },
            city: {
                maxlength: 50,
                required: true
            },
            country: {
                maxlength: 50,
                required: true
            },
            phone: {
                maxlength: 50,
                required: true
            }

        },
        messages:{
            name:{
                required: "Gelieve een naam in te vullen",
                maxlength: "Gelieve maximaal {0} karakters te gebruiken"
            },
            email:{
                required: "Gelieve een email adres in te vullen",
                email: "Het email adres is niet volgens de standaard"
            },
            phone:{
                required: "Gelieve een telefoonnummer in te vullen",
                maxlength: "Gelieve maximaal {0} karakters te gebruiken"
            },
            vat:{
                required: "Gelieve het BTW nummer in te vullen",
                maxlength: "Gelieve maximaal {0} karakters te gebruiken"
            },
            street:{
                required: "Gelieve een straat in te vullen",
                maxlength: "Gelieve maximaal {0} karakters te gebruiken"
            },
            number:{
                required: "Gelieve een nummer in te vullen",
                maxlength: "Gelieve maximaal {0} karakters te gebruiken"
            },
            postalCode:{
                required: "Gelieve een postcode in te vullen",
                maxlength: "Gelieve maximaal {0} karakters te gebruiken"
            },
            city:{
                required: "Gelieve een stad in te vullen",
                maxlength: "Gelieve maximaal {0} karakters te gebruiken"
            },
            country:{
                required: "Gelieve een land in te vullen",
                maxlength: "Gelieve maximaal {0} karakters te gebruiken"
            }

        },

        //Todo: fix bug (label not removed)
        highlight: function(element) {
            element
                .closest('.form-group').addClass('error');
        },
        success: function(element) {
            element
                .addClass('valid')
                .closest('.form-group').removeClass('error');
        }
    });

}); // end document.ready

