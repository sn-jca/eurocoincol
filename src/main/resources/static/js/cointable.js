function functionclick(){
    json= JSON.stringify(($("form").serializeArray()));
    var result = { };
    $.each($('form').serializeArray(), function() {
        result[this.name] = this.value;
    });
    console.log(result);
     $.ajax({
            type: 'POST',
            url: '/api/coin/add',
            data: JSON.stringify(result),
            success: function(result) {  location.reload();  },
            contentType: "application/json",
            dataType: 'json'
        });

}

$(document).ready( function () {
	 var table = $('#coinsTable').DataTable({
			"sAjaxSource": "/api/coins",
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"aoColumns": [
			    { "mData": "id"},
				{ "mData": "description" },
		        { "mData": "value" },
				{ "mData": "country" },
				{ "mData": "commemorative" }
			]
	 });

	/* $.ajax({
             url: "/api/coins",
             contentType: "application/json",
             dataType: 'json',
             success: function(result){
                 console.log(result);
             }
         })*/

    $.get("/api/coins", function(data, status){
        console.log(data);
      });

     var json = '{"country" : "France", "description" : "piece 2 euros commemorative CDG", "value" : 2,"year" : 2019}';



});