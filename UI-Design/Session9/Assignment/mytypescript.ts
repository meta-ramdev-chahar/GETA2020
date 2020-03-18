export { }
let empDetails: HTMLFormElement;
let vehicleDetails: HTMLFormElement;
let planDetails: HTMLFormElement;

//This function submit employee form and validate it's inputs
function submitEmpForm(): void {
    if (validateEmpForm()) {
        empDetails = <HTMLFormElement>document.getElementById('employeeForm');
        let empName: string = (<HTMLInputElement>document.getElementById('EmpName')).value;
        let empContactNumber: string = (<HTMLInputElement>document.getElementById('EmpContactNumber')).value;
        document.getElementById('vehicleFormHeading').innerHTML = "Vehicle Registration For EID : "+empName.slice(0, 2) + empContactNumber.slice(0, 4) + empName.slice(2, 4);
        //(<HTMLInputElement>document.getElementById('EmpId')).value = empName.slice(0, 2) + empContactNumber.slice(0, 4) + empName.slice(2, 4);
        hideEmpForm();
        showVehicleForm();
    }
}
//This funcation submit vehicle form and validate it's inputs
function submitVehicleForm(): void {
    if (validateVehicleForm()) {
        vehicleDetails = <HTMLFormElement>document.getElementById('vehicleForm');
        hideVehicleForm();
        showSelectPlanForm();
        showCurrency();
    }
}
//This function submit plan selector form 
function submitPlanForm(): void {
    planDetails = <HTMLFormElement>document.getElementById('planForm');
    hideSelectPlanForm();
    showConfirmDetailsForm();
    document.getElementById('CDEmpName').innerHTML = (<HTMLInputElement>empDetails.elements[0]).value;
    document.getElementById('CDVehicleType').innerHTML = (<HTMLInputElement>vehicleDetails.elements[1]).value;
    document.getElementById('CDVehicleNumber').innerHTML = (<HTMLInputElement>vehicleDetails.elements[2]).value;
    if ((<HTMLInputElement>planDetails.elements[1]).checked == true) {
        document.getElementById('CDPlan').innerHTML = (<HTMLInputElement>planDetails.elements[1]).value;
    }
    else if ((<HTMLInputElement>planDetails.elements[2]).checked == true) {
        document.getElementById('CDPlan').innerHTML = (<HTMLInputElement>planDetails.elements[2]).value;
    }
    else if ((<HTMLInputElement>planDetails.elements[3]).checked == true) {
        document.getElementById('CDPlan').innerHTML = (<HTMLInputElement>planDetails.elements[3]).value;
    }
}
//This function display prices according to selected currrency
function showCurrency(): void {
    let currencyType: string = (<HTMLInputElement>document.getElementById('CurrencySelect')).value;
    let typeOfVehicle: string = (<HTMLFormElement>vehicleDetails.elements[1]).value;
    let dataRow: number;
    let currencyArray: Array<Array<number>> = [[5, 100, 500], [10, 200, 1000], [20, 500, 3500]];

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
function showTotal(): void {
    if ((<HTMLInputElement>document.getElementById('DailyPlan')).checked == true) {
        (<HTMLInputElement>document.getElementById('TotalCost')).value = document.getElementById('DailyCost').innerHTML;
    }
    else if ((<HTMLInputElement>document.getElementById('MonthlyPlan')).checked == true) {
        (<HTMLInputElement>document.getElementById('TotalCost')).value = document.getElementById('MonthlyCost').innerHTML;
    }
    else if ((<HTMLInputElement>document.getElementById('YearlyPlan')).checked == true) {
        (<HTMLInputElement>document.getElementById('TotalCost')).value = document.getElementById('YearlyCost').innerHTML;
    }
}
//validate name of employee
function nameFunction(keyPress: KeyboardEvent): boolean {
    if (keyPress.keyCode == 13) {
        document.getElementById('final-message').innerHTML = "";
        let empName: HTMLInputElement = document.getElementById('employeeForm')[0];
        if (!empName.checkValidity()) {
            alert("Please enter valid name");
            document.getElementById('error-box').innerHTML = "Please enter valid name";
            return false;
        }
        else {
            document.getElementById('error-box').innerHTML = "";
            document.getElementById('emp-name-row').style.display = "none";
            document.getElementById('emp-email-row').style.display = "inherit";
            let name: string = (<HTMLInputElement>document.getElementById("EmpName")).value;
            document.getElementById("message").innerHTML = "Hello " + name + " Please enter your email ";
        }
        return false;
    }
}
//validate email
function emailFunction(keyPress: KeyboardEvent): boolean {
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
function genderFunction(): void {
    document.getElementById('emp-gender-row').style.display = "none";
    document.getElementById('emp-password-row').style.display = "inherit";
    document.getElementById('emp-confirm-password-row').style.display = "inherit";
    document.getElementById("message").innerHTML = "Please enter your password ";
}

function passwordFunction(keyPress: KeyboardEvent): boolean {
    let empPassword: string = (<HTMLInputElement>document.getElementById("EmpPassword")).value;
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
        let empPassword: HTMLInputElement = document.getElementById('employeeForm')[4];
        if (!empPassword.checkValidity()) {
            alert('Please enter valid password');
            document.getElementById('password-error').innerHTML = "Please enter valid password";
            return false;
        }
        return false
    }
}
function confirmPassword(keyPress: KeyboardEvent): boolean {
    let empPassword: string = (<HTMLInputElement>document.getElementById("EmpConfirmPassword")).value;
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
        let empPassword: HTMLInputElement = document.getElementById('employeeForm')[4];
        if (!empPassword.checkValidity()) {
            document.getElementById('password-error').innerHTML = "Please enter valid password";
            alert('Please enter valid password');
            return false;
        }
        else {
            document.getElementById('password-error').innerHTML = "";
            let empConfirmPassword: HTMLInputElement = document.getElementById('employeeForm')[5];
            if (!empConfirmPassword.checkValidity()) {
                alert('Please enter valid confirm password');
                document.getElementById('error-box').innerHTML = "Please enter valid confirm password";
                return false;
            }
            else if (empConfirmPassword.value != empPassword.value) {
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
        return false
    }
}
//This function submit confirm details form
function submitConfirmDetails(): void {
    (<HTMLFormElement>document.getElementById('confirmDetailsForm')).submit();
    alert('Registration Successfull');
    document.getElementById('final-message').innerHTML = "Registration Successfull";
    document.getElementById('final-message').style.color = "green";

}
//This function cancel the registration
function cancelRegistration(): void {
    (<HTMLFormElement>document.getElementById('confirmDetailsForm')).submit();
    alert('Registration Cancelled');
    document.getElementById('final-message').innerHTML = "Registration Cancelled";
    document.getElementById('final-message').style.color = "red";
}
//This function convert INR to USD
function convertToUSD(value: number): number {
    return (Math.round((value / 72) * 100) / 100);
}
//This function convert INR to YEN
function convertToYEN(value: number): number {
    return (Math.round((value * 1.53) * 100) / 100);
}
//This function hide employee form
function hideEmpForm(): void {
    document.getElementById('error-box').innerHTML = "";
    document.getElementById('EmployeeRegisterDiv').style.display = "none";
}
//This function show the vehicle form
function showVehicleForm(): void {
    document.getElementById('VehicleRegisterDiv').style.display = "inherit";
}
//This function hide the vehicle form
function hideVehicleForm(): void {
    document.getElementById('VehicleRegisterDiv').style.display = "none";
}
//This fuction show the select plan form
function showSelectPlanForm(): void {
    document.getElementById('SelectPlanDiv').style.display = "inherit";
}
//This function hide the select plan form
function hideSelectPlanForm(): void {
    document.getElementById('SelectPlanDiv').style.display = "none";
}
//This function show the confirm details form
function showConfirmDetailsForm(): void {
    document.getElementById('ConfirmDetailsDiv').style.display = "inherit";
}
//This function hide the confirm details form
function hideConfirmDetailsForm(): void {
    document.getElementById('ConfirmDetailsDiv').style.display = "none";
}
//This function validate Emplyoee form
function validateEmpForm(): boolean {
    //validating gender
    if ((<HTMLInputElement>document.getElementById('EmpGenderM')).checked == false && (<HTMLInputElement>document.getElementById('EmpGenderF')).checked == false) {
        alert('Please select gender');
        return false;
    }

    //validating contact number
    let empContact: HTMLInputElement = document.getElementById('employeeForm')[6];
    if (!empContact.checkValidity()) {
        alert('Please enter valid contact number');
        document.getElementById('error-box').innerHTML = "Please enter valid contact number";
        return false;
    }
    return true;
}

function vehicleName(keyPress: KeyboardEvent): boolean {
    if (keyPress.keyCode == 13) {
        let vehicleName: HTMLInputElement = document.getElementById('vehicleForm')[0];
        if (!vehicleName.checkValidity()) {
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
        return false
    }
}

function vehicleType(): void {
    document.getElementById('vehicle-type').style.display = "none";
    document.getElementById('vehicle-number').style.display = "inherit";
    //document.getElementById('vehicle-empId').style.display = "inherit";
    document.getElementById('vehicle-message').innerHTML = "please Enter your vehicle number";

}
function vehicleNumber(keyPress: KeyboardEvent): boolean {
    if (keyPress.keyCode == 13) {
        let vehicleNumber: HTMLInputElement = document.getElementById('vehicleForm')[2];
        if (vehicleNumber.value == "") {
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
        return false
    }
}
//This function validate vehicle form inputs
function validateVehicleForm(): boolean {
    let vehicleIdentification: HTMLInputElement = document.getElementById('vehicleForm')[4];
    if (vehicleIdentification.value == "") {
        alert('Please enter vehicle identifications');
        document.getElementById('error-box').innerHTML = "Please enter vehicle identifications";
        return false;
    }
    return true;
}
