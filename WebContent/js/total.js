$(document).ready( function() {
	var dateToday = new Date();
	var mm = dateToday.getMonth() + 1;
	var yyyy = dateToday.getFullYear();
	
	if (mm < 10) {
		mm = '0' + mm;
	}
	
	dateToday = yyyy + '-' + mm;
	$('#yearExp')[0].setAttribute("min", yyyy);
	
	$('#creditForm').submit( function(event) {
		var subMonth = $('#monthExp').val();
		var subYear = $('#yearExp').val();
		
		if (subMonth < 10) {
			subMonth = '0' + subMonth;
		}
		
		var subDate = subYear + '-' +  subMonth;
		if (subDate < dateToday) {
			dateToday = mm + '/' + yyyy;
			event.preventDefault();
			alert("Expiration date must be after " + dateToday);
		}
		
	});
});