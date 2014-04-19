//
//	jQuery Validate example script
//
//	Prepared by David Cochran
//
//	Free for your use -- No warranties, no guarantees!
//
$(document).ready(function () {

    $('#form-register').validate({

        rules: {
            description: {
                maxlength: 255,
                required: true
            },
            shortDescription: {
                maxlength: 255,
                required: true
            },
            employeeId: {
                required: true
            }

        },
        messages: {
            description: {
                required: "Gelieve een beschrijving in te vullen",
                maxlength: "Gelieve maximaal {0} karakters te gebruiken"
            },
            shortDescription: {
                required: "Gelieve een korte beschrijving in te vullen",
                maxlength: "Gelieve maximaal {0} karakters te gebruiken"
            },
            employeeId: {
                required: "Gelieve een medewerker te selecteren"
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

