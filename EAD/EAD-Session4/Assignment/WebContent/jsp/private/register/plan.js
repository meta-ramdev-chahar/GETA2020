function showCurrency(){
	var currency = document.getElementById('CurrencySelect').value;
	var vehicleType = document.getElementById('vehicleType').innerHTML.trim();
	var dataRow;
	var currencyArray = [[5,100,500],[10,200,1000],[20,500,3500]];
	if(vehicleType == "Cycle")
	{
		dataRow = 0;
	}
	else if(vehicleType== "MotorCycle")
	{
		dataRow = 1;
	}
	else if(localeCompare(vehicleType) == "FourWheeler")
	{
		dataRow = 2;
	}
	if(currency == "INR"){
		document.getElementById('DailyCost').innerHTML = currencyArray[dataRow][0];
		document.getElementById('MonthlyCost').innerHTML = currencyArray[dataRow][1];
		document.getElementById('YearlyCost').innerHTML = currencyArray[dataRow][2];
	}
	if(currency == "USD"){
		document.getElementById('DailyCost').innerHTML = convertToUSD(currencyArray[dataRow][0]);
		document.getElementById('MonthlyCost').innerHTML = convertToUSD(currencyArray[dataRow][1]);
		document.getElementById('YearlyCost').innerHTML = convertToUSD(currencyArray[dataRow][2]);
	}
	if(currency == "YEN"){
		document.getElementById('DailyCost').innerHTML = convertToYEN(currencyArray[dataRow][0]);
		document.getElementById('MonthlyCost').innerHTML = convertToYEN(currencyArray[dataRow][1]);
		document.getElementById('YearlyCost').innerHTML = convertToYEN(currencyArray[dataRow][2]);
	}
	showTotal();
}
//This function show total according to selected plan
function showTotal(){
	if(document.getElementById('DailyPlan').checked == true){
		document.getElementById('TotalCost').value = document.getElementById('DailyCost').innerHTML;
	}else if(document.getElementById('MonthlyPlan').checked == true){
		document.getElementById('TotalCost').value = document.getElementById('MonthlyCost').innerHTML;
	}else if(document.getElementById('YearlyPlan').checked == true){
		document.getElementById('TotalCost').value = document.getElementById('YearlyCost').innerHTML;
	}
}
//This function convert INR to USD
function convertToUSD(value){
	return (Math.round((value/72)*100)/100);
}
//This function convert INR to YEN
function convertToYEN(value){
	return (Math.round((value*1.48)*100)/100);
}