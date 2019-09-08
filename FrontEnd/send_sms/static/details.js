$(document).ready(function() {


    $(document).on('click', '#btnSubmit', function(e){
        number = encodeURIComponent('+91'+$("#sms_number").val().split(';'))
        message = encodeURIComponent($("#message").val())
        mType=encodeURIComponent(1)
        console.log(number)
        console.log(message)
        var url = 'http://localhost:8081/gateway/publish/send/mType/'+mType+'/contactNum/'+number+'/message/'+message
        $.ajax({
            url : url, 
            type : 'GET', 
            success : function(data) {
                console.log("Message sent...")
            },
        });

    });

    $(document).on('click', '#btnBulkSubmit', function(e){
        numbers = '91'+$("#bulk_sms_numbers").val().split(';')
        message = $("#bulk_message").val()
        console.log(numbers)
        console.log(message)
        var url = '/gateway/publish/send/mType/1/contactNum/'+number
        $.ajax({
            type : "POST", 
            url : url, 
            data:{
                'value[]': {
                    'messageId': 1,
                    'messageType':1,
                    'message': message,
                    'contactNumber': number,
                    },
                csrfmiddlewaretoken: $('input[name=csrfmiddlewaretoken]').val(),
            },
            success : function(data) {
                    
              },
        });

    });

});