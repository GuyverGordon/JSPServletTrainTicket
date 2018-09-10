$(document).ready( function() {
	var dateToday = new Date();
	var dd = dateToday.getDate();
	var mm = dateToday.getMonth() + 1;
	var yyyy = dateToday.getFullYear();
	
	if (dd < 10) {
		dd= '0' + dd;
	}
	if (mm < 10) {
		mm = '0' + mm;
	}
	
	dateToday = yyyy + '-' + mm + '-' + dd;
	$('#day')[0].setAttribute("min", dateToday);
});