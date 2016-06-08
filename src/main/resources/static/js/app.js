var registrationButton = document.getElementById('registration-button');
var writeButton = document.getElementById('write-button');

registrationButton.addEventListener("click", registrationButtonClick);
writeButton.addEventListener("click", writeButtonClick);

function registrationButtonClick(){
    console.log("RegistrationButton Click");
}
function writeButtonClick(){
    console.log("WriteButton Click");
}