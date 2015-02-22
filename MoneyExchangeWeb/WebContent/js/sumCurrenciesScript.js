$(document).ready(function() {
	$('#addButton').click(function() {
		console.log('clicked');
		$.ajax({
			type : "GET",
			url : "SumCurrenciesServlet",
			data : {
				addentAmount1 : $('#addentAmountTextBox1').val(),
				addentCurrency1 : $('#addentCurrencyComboBox1 option:selected').text(),
				addentCurrency2 :  $('#addentCurrencyComboBox2 option:selected').text(),
				addentAmount2 : $('#addentAmountTextBox2').val(),
				resultCurrency :  $('#resultCurrencyComboBox option:selected').text()
				
//						addentAmount1 :10,
//				addentCurrency1 : "USD",
//				addentCurrency2 : "EUR",
//				addentAmount2 :   20,
//				resultCurrency : "TL"
			
			},
		}).done(function(data) {
			console.log($('#addentAmountTextBox1').val());
			$('#resultTextBox').val(data)
		});

	});

});