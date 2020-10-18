function addCoin(){
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

function deleteCoin(id){
     $.ajax({
            type: 'DELETE',
            url: '/api/coin/'+id,
            success: function(result) {  location.reload();  }
        });
}

$(document).ready( function () {

    $('#exampleModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget)
        var id = button.data('id')
        var modal = $(this)
        modal.find('.modal-title').text('Do you really want to delete coin n° ' + id)
        document.getElementById("modal_button").onclick = function() { deleteCoin(id); }
     })

	 var table = $('#coinsTable').DataTable({
			"sAjaxSource": "/api/coins",
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"aoColumns": [
			    { "mData": "id" ,"mRender": function (data, type, row){
                    return '<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal" data-id='+data+'>Delete</button>';
                }},
				{ "mData": "description" },
		        { "mData": "value" },
				{ "mData": "country" },
				{ "mData": "commemorative" }
			]
	 });
});
