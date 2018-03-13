var apiUrlCouties = "http://localhost:8080/counties/rest/counties";
$(document).ready(function() {
	console.log("HEJ");
	$('#nav_admin').on("click", showCountiesTable());

});

function showCountiesTable() {
	insertTable();
	console.log("HEJ Ho");
	$.ajax({
		type : 'GET',
		url : apiUrlCouties,
		dataType : "json",
		destroy: true,
		success : function(data) {

			userTable = $('#countiesTable').DataTable({
				data : data,
				columns : [ {
					data : "id"
				}, {
					data : "population"
				}, {
					data : "areaRank"
				}, {
					data : "areaTotal"
				}, {
					data : "capital"
				}, {
					data : "motto"
				}, {
					data : "flag"
				}, {
					data : "name"
				}, {
					data : "province"
				}, {
					data : "neighbourNo"
				}, {
					className : "center",
					render : function(data, type, row) {
						return "<button onClick=\"editCounty(" + row.id + ")\" data-toggle=\"modal\" data-target=\"#editUserModal\" value=\"Edit\">Edit</button>";
					},
				}, {
					className : "center",
					render : function(data, type, row) {
						return "<button onClick=\"deleteCounty(" + row.id + ")\" value=\"Delete\">Delete</button>";
					},
				} ]
			})
		}
	});
}

function saveCounty(){
	console.log("New County");
	var county = {
			"population" : $('#in_population').val(),
			"areaRank" : $('#in_areaRank').val(),
			"areaTotal" : $('#in_areaTotal').val(),
			"capital" : $('#in_capital').val(),
			"flag" : $('#in_flag').val(),
			"motto" : $('#in_motto').val(),
			"name" : $('#in_name').val(),
			"province" : $('#in_province').val(),
			"neighbourNo" : $('#in_neighbourNo').val()
	}
	
	$.ajax({
		type: "POST",
		contentType: 'application/json',
		url: apiUrlCouties,
		dataType : "json",
		data :  JSON.stringify(county),
		success : function(data){
			showCountiesTable();
		},
		failure : function(data){
			console.log(data);
		},
	});
	
}

function deleteCounty(id) {
	$.ajax({
		type: "DELETE",
		contentType: 'application/json',
		url: apiUrlCouties + '/' + id,
		dataType : "json",
		success : function(data){
			showCountiesTable();
		},
		failure : function(data){
			console.log(data);
		},
	});
}
function updateCounty() {
	console.log("Update");
	var county = {
			"id" : $('#in_id').val(),
			"population" : $('#in_population').val(),
			"areaRank" : $('#in_areaRank').val(),
			"areaTotal" : $('#in_areaTotal').val(),
			"capital" : $('#in_capital').val(),
			"flag" : $('#in_flag').val(),
			"motto" : $('#in_motto').val(),
			"name" : $('#in_name').val(),
			"province" : $('#in_province').val(),
			"neighbourNo" : $('#in_neighbourNo').val()
	}
	
	$.ajax({
		type: "PUT",
		contentType: 'application/json',
		url: apiUrlCouties + '/' + $('#in_id').val(),
		dataType : "json",
		data :  JSON.stringify(county),
		success : function(data){
			showCountiesTable();
		},
		failure : function(data){
			console.log(data);
		},
	});
	
}

function editCounty(id) {
	console.log("HEJ Ho ho" + id);
	$.ajax({
		type : 'GET',
		url : apiUrlCouties + '/' + id,
		dataType : "json",
		success : function(data) {
			$('#in_id').val(data.id);
			$('#in_population').val(data.population);
			$('#in_areaRank').val(data.areaRank);
			$('#in_areaTotal').val(data.areaTotal);
			$('#in_capital').val(data.capital);
			$('#in_flag').val(data.flag);
			$('#in_motto').val(data.motto);
			$('#in_name').val(data.name);
			$('#in_province').val(data.province);
			$('#in_neighbourNo').val(data.neighbourNo);
		}
	});
}
function insertTable() {
	$('#admin').html(
			'<div class="card-body">'
			+'<div class="table-responsive">'
			+'	<table id="countiesTable" class="table table-bordered" cellspacing="0" width="100%">'
			+'		<thead>'
			+'			<tr>'
			+'				<th>ID</th>'
			+'				<th>Population</th>'
			+'				<th>Area Rank</th>'
			+'				<th>Area Total</th>'
			+'				<th>Capital</th>'
			+'				<th>Flag</th>'
			+'				<th>Motto</th>'
			+'				<th>Name</th>'
			+'				<th>Province</th>'
			+'				<th>Neighbours No</th>'
			+'				<th>Edit</th>'
			+'				<th>Delelte</th>'
			+'			</tr>'
			+'		</thead>'
		
			+'		<tfoot>'
			+'			<tr>'
			+'				<th>ID</th>'
			+'				<th>Population</th>'
			+'				<th>Area Rank</th>'
			+'				<th>Area Total</th>'
			+'				<th>Capital</th>'
			+'				<th>Flag</th>'
			+'				<th>Motto</th>'
			+'				<th>Name</th>'
			+'				<th>Province</th>'
			+'				<th>Neighbours No</th>'
			+'				<th>Edit</th>'
			+'				<th>Delete</th>'
			+'			</tr>'
			+'		</tfoot>'
			+'	</table>'
			+'</div>'
			+'</div>'
	);
}
// {
// id
// population
// areaRank
// areaTotal
// capital
// flag
// motto
// name
// province
// neighbourNo
// },
// columns: [
// { data: "id" },
// { data: "email" },
// { data: "password" },
// { data: "role" },
// {
// className: "center",
// render: function(data, type, row) {
// return "<button onClick=\"editUser(" +row.id+ ",'"+ row.email +"', '"+
// row.password +"', '"+ row.role +"');\" value=\"Edit\">Edit</button>";
// },
// }
// ]
