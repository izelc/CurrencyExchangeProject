$(document).ready(function() {
	$('#calculateButton').click(function() {
		console.log('clicked');
		$.ajax({
			type : "GET",
			url : "ConvertServlet",
			data : {
				amount : $('#amountTextBox').val(),
				toCurrency : $('#toCurrencyComboBox option:selected').text(),
				fromCurrency : $('#fromCurrencyComboBox option:selected').text()
			},
		}).done(function(data) {
			$('#resultTextBox').val(data)
		});

	});

});