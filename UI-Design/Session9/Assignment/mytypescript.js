"use strict";
exports.__esModule = true;
var empDetails;
var vehicleDetails;
var planDetails;
//This function submit employee form and validate it's inputs
function submitEmpForm() {
    if (validateEmpForm()) {
        empDetails = document.getElementById('employeeForm');
        var empName = document.getElementById('EmpName').value;
        var empContactNumber = document.getElementById('EmpContactNumber').value;
        document.getElementById('vehicleFormHeading').innerHTML = "Vehicle Registration For EID : " + empName.slice(0, 2) + empContactNumber.slice(0, 4) + empName.slice(2, 4);
        //(<HTMLInputElement>document.getElementById('EmpId')).value = empName.slice(0, 2) + empContactNumber.slice(0, 4) + empName.slice(2, 4);
        hideEmpForm();
        showVehicleForm();
    }
}
//This funcation submit vehicle form and validate it's inputs
function submitVehicleForm() {
    if (validateVehicleForm()) {
        vehicleDetails = document.getElementById('vehicleForm');
        hideVehicleForm();
        showSelectPlanForm();
        showCurrency();
    }
}
//This function submit plan selector form 
function submitPlanForm() {
    planDetails = document.getElementById('planForm');
    hideSelectPlanForm();
    showConfirmDetailsForm();
    document.getElementById('CDEmpName').innerHTML = empDetails.elements[0].value;
    document.getElementById('CDVehicleType').innerHTML = vehicleDetails.elements[1].value;
    document.getElementById('CDVehicleNumber').innerHTML = vehicleDetails.elements[2].value;
    if (planDetails.elements[1].checked == true) {
        document.getElementById('CDPlan').innerHTML = planDetails.elements[1].value;
    }
    else if (planDetails.elements[2].checked == true) {
        document.getElementById('CDPlan').innerHTML = planDetails.elements[2].value;
    }
    else if (planDetails.elements[3].checked == true) {
        document.getElementById('CDPlan').innerHTML = planDetails.elements[3].value;
    }
}
//This function display prices according to selected currrency
function showCurrency() {
    var currencyType = document.getElementById('CurrencySelect').value;
    var typeOfVehicle = vehicleDetails.elements[1].value;
    var dataRow;
    var currencyArray = [[5, 100, 500], [10, 200, 1000], [20, 500, 3500]];
    if (typeOfVehicle == "Cycle") {
        dataRow = 0;
    }
    else if (typeOfVehicle == "MotorCycle") {
        dataRow = 1;
    }
    else if (typeOfVehicle == "FourWheeler") {
        dataRow = 2;
    }
    if (currencyType == "INR") {
        document.getElementById('DailyCost').innerHTML = currencyArray[dataRow][0].toString();
        document.getElementById('MonthlyCost').innerHTML = currencyArray[dataRow][1].toString();
        document.getElementById('YearlyCost').innerHTML = currencyArray[dataRow][2].toString();
    }
    if (currencyType == "USD") {
        document.getElementById('DailyCost').innerHTML = convertToUSD(currencyArray[dataRow][0]).toString();
        document.getElementById('MonthlyCost').innerHTML = convertToUSD(currencyArray[dataRow][1]).toString();
        document.getElementById('YearlyCost').innerHTML = convertToUSD(currencyArray[dataRow][2]).toString();
    }
    if (currencyType == "YEN") {
        document.getElementById('DailyCost').innerHTML = convertToYEN(currencyArray[dataRow][0]).toString();
        document.getElementById('MonthlyCost').innerHTML = convertToYEN(currencyArray[dataRow][1]).toString();
        document.getElementById('YearlyCost').innerHTML = convertToYEN(currencyArray[dataRow][2]).toString();
    }
    showTotal();
}
//This function show totol according to selected plan
function showTotal() {
    if (document.getElementById('DailyPlan').checked == true) {
        document.getElementById('TotalCost').value = document.getElementById('DailyCost').innerHTML;
    }
    else if (document.getElementById('MonthlyPlan').checked == true) {
        document.getElementById('TotalCost').value = document.getElementById('MonthlyCost').innerHTML;
    }
    else if (document.getElementById('YearlyPlan').checked == true) {
        document.getElementById('TotalCost').value = document.getElementById('YearlyCost').innerHTML;
    }
}
//validate name of employee
function nameFunction(keyPress) {
    if (keyPress.keyCode == 13) {
        document.getElementById('final-message').innerHTML = "";
        var empName = document.getElementById('employeeForm')[0];
        if (!empName.checkValidity()) {
            alert("Please enter valid name");
            document.getElementById('error-box').innerHTML = "Please enter valid name";
            return false;
        }
        else {
            document.getElementById('error-box').innerHTML = "";
            document.getElementById('emp-name-row').style.display = "none";
            document.getElementById('emp-email-row').style.display = "inherit";
            var name_1 = document.getElementById("EmpName").value;
            document.getElementById("message").innerHTML = "Hello " + name_1 + " Please enter your email ";
        }
        return false;
    }
}
//validate email
function emailFunction(keyPress) {
    if (keyPress.keyCode == 13) {
        //validating email
        var empEmail = document.getElementById('employeeForm')[1];
        if (!empEmail.checkValidity()) {
            alert('Please enter valid email');
            document.getElementById('error-box').innerHTML = "Please enter valid email";
            return false;
        }
        else {
            document.getElementById('error-box').innerHTML = "";
            document.getElementById('emp-email-row').style.display = "none";
            document.getElementById('emp-gender-row').style.display = "inherit";
            document.getElementById("message").innerHTML = "Please select your gender ";
        }
        return false;
    }
}
//validate gender
function genderFunction() {
    document.getElementById('emp-gender-row').style.display = "none";
    document.getElementById('emp-password-row').style.display = "inherit";
    document.getElementById('emp-confirm-password-row').style.display = "inherit";
    document.getElementById("message").innerHTML = "Please enter your password ";
}
function passwordFunction(keyPress) {
    var empPassword = document.getElementById("EmpPassword").value;
    if (empPassword.length < 4) {
        document.getElementById('EmpPassword').style.borderColor = "red";
    }
    else if (empPassword.length < 7) {
        document.getElementById('EmpPassword').style.borderColor = "orange";
    }
    else {
        document.getElementById('EmpPassword').style.borderColor = "green";
    }
    if (keyPress.keyCode == 13) {
        //validating password
        var empPassword_1 = document.getElementById('employeeForm')[4];
        if (!empPassword_1.checkValidity()) {
            alert('Please enter valid password');
            document.getElementById('password-error').innerHTML = "Please enter valid password";
            return false;
        }
        return false;
    }
}
function confirmPassword(keyPress) {
    var empPassword = document.getElementById("EmpConfirmPassword").value;
    if (empPassword.length < 4) {
        document.getElementById('EmpConfirmPassword').style.borderColor = "red";
    }
    else if (empPassword.length < 7) {
        document.getElementById('EmpConfirmPassword').style.borderColor = "orange";
    }
    else {
        document.getElementById('EmpConfirmPassword').style.borderColor = "green";
    }
    if (keyPress.keyCode == 13) {
        //validating password and confirm password
        var empPassword_2 = document.getElementById('employeeForm')[4];
        if (!empPassword_2.checkValidity()) {
            document.getElementById('password-error').innerHTML = "Please enter valid password";
            alert('Please enter valid password');
            return false;
        }
        else {
            document.getElementById('password-error').innerHTML = "";
            var empConfirmPassword = document.getElementById('employeeForm')[5];
            if (!empConfirmPassword.checkValidity()) {
                alert('Please enter valid confirm password');
                document.getElementById('error-box').innerHTML = "Please enter valid confirm password";
                return false;
            }
            else if (empConfirmPassword.value != empPassword_2.value) {
                alert('Please enter same password');
                document.getElementById('error-box').innerHTML = "Please enter same password";
                return false;
            }
            else {
                document.getElementById('error-box').innerHTML = "";
                document.getElementById('password-error').innerHTML = "";
                document.getElementById('emp-password-row').style.display = "none";
                document.getElementById('emp-confirm-password-row').style.display = "none";
                document.getElementById("message").innerHTML = "Please enter your contact ";
                document.getElementById("emp-contact-row").style.display = "inherit";
                document.getElementById("emp-submit-row").style.display = "inherit";
            }
        }
        return false;
    }
}
//This function submit confirm details form
function submitConfirmDetails() {
    document.getElementById('confirmDetailsForm').submit();
    alert('Registration Successfull');
    document.getElementById('final-message').innerHTML = "Registration Successfull";
    document.getElementById('final-message').style.color = "green";
}
//This function cancel the registration
function cancelRegistration() {
    document.getElementById('confirmDetailsForm').submit();
    alert('Registration Cancelled');
    document.getElementById('final-message').innerHTML = "Registration Cancelled";
    document.getElementById('final-message').style.color = "red";
}
//This function convert INR to USD
function convertToUSD(value) {
    return (Math.round((value / 72) * 100) / 100);
}
//This function convert INR to YEN
function convertToYEN(value) {
    return (Math.round((value * 1.53) * 100) / 100);
}
//This function hide employee form
function hideEmpForm() {
    document.getElementById('error-box').innerHTML = "";
    document.getElementById('EmployeeRegisterDiv').style.display = "none";
}
//This function show the vehicle form
function showVehicleForm() {
    document.getElementById('VehicleRegisterDiv').style.display = "inherit";
}
//This function hide the vehicle form
function hideVehicleForm() {
    document.getElementById('VehicleRegisterDiv').style.display = "none";
}
//This fuction show the select plan form
function showSelectPlanForm() {
    document.getElementById('SelectPlanDiv').style.display = "inherit";
}
//This function hide the select plan form
function hideSelectPlanForm() {
    document.getElementById('SelectPlanDiv').style.display = "none";
}
//This function show the confirm details form
function showConfirmDetailsForm() {
    document.getElementById('ConfirmDetailsDiv').style.display = "inherit";
}
//This function hide the confirm details form
function hideConfirmDetailsForm() {
    document.getElementById('ConfirmDetailsDiv').style.display = "none";
}
//This function validate Emplyoee form
function validateEmpForm() {
    //validating gender
    if (document.getElementById('EmpGenderM').checked == false && document.getElementById('EmpGenderF').checked == false) {
        alert('Please select gender');
        return false;
    }
    //validating contact number
    var empContact = document.getElementById('employeeForm')[6];
    if (!empContact.checkValidity()) {
        alert('Please enter valid contact number');
        document.getElementById('error-box').innerHTML = "Please enter valid contact number";
        return false;
    }
    return true;
}
function vehicleName(keyPress) {
    if (keyPress.keyCode == 13) {
        var vehicleName_1 = document.getElementById('vehicleForm')[0];
        if (!vehicleName_1.checkValidity()) {
            alert('Please enter valid vehicle name');
            document.getElementById('error-box').innerHTML = "Please enter valid vehicle name";
            return false;
        }
        else {
            document.getElementById('error-box').innerHTML = "";
            document.getElementById('vehicle-name').style.display = "none";
            document.getElementById('vehicle-type').style.display = "inherit";
            document.getElementById('vehicle-message').innerHTML = "Which vehicle do you have ?";
        }
        return false;
    }
}
function vehicleType() {
    document.getElementById('vehicle-type').style.display = "none";
    document.getElementById('vehicle-number').style.display = "inherit";
    //document.getElementById('vehicle-empId').style.display = "inherit";
    document.getElementById('vehicle-message').innerHTML = "please Enter your vehicle number";
}
function vehicleNumber(keyPress) {
    if (keyPress.keyCode == 13) {
        var vehicleNumber_1 = document.getElementById('vehicleForm')[2];
        if (vehicleNumber_1.value == "") {
            alert('Please enter valid vehicle number');
            document.getElementById('error-box').innerHTML = "Please enter valid vehicle number";
            return false;
        }
        else {
            document.getElementById('error-box').innerHTML = "";
            document.getElementById('vehicle-number').style.display = "none";
            //document.getElementById('vehicle-empId').style.display = "none";
            document.getElementById('vehicle-identification').style.display = "inherit";
            document.getElementById('vehicle-submit').style.display = "inherit";
            document.getElementById('vehicle-message').innerHTML = "please write your vehicle identification";
        }
        return false;
    }
}
//This function validate vehicle form inputs
function validateVehicleForm() {
    var vehicleIdentification = document.getElementById('vehicleForm')[4];
    if (vehicleIdentification.value == "") {
        alert('Please enter vehicle identifications');
        document.getElementById('error-box').innerHTML = "Please enter vehicle identifications";
        return false;
    }
    return true;
}
