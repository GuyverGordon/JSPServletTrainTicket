changeNumber();

function checkform(theform){
	var why = "";
	
	if(theform.CaptchaInput.value == ""){
		why += "- Please Enter CAPTCHA Code.\n";
	}
	
	if(theform.CaptchaInput.value != ""){
		if(ValidCaptcha(theform.CaptchaInput.value) == false){
			changeNumber();
			document.getElementById('CaptchaInput').value = "";
			return false;
		} else
			return true;
	}
	
	if(why != ""){
		alert(why);
		return false;
	}
}

function changeNumber() {
	var a = Math.ceil(Math.random() * 9)+ '';
	var b = Math.ceil(Math.random() * 9)+ '';
	var c = Math.ceil(Math.random() * 9)+ '';
	var d = Math.ceil(Math.random() * 9)+ '';

	var code = a + b + c + d;

	document.getElementById('txtCaptcha').value = code;
	document.getElementById('CaptchaDiv').innerHTML = code;
}

function ValidCaptcha(){
	var str1 = removeSpaces(document.getElementById('txtCaptcha').value);
	var str2 = removeSpaces(document.getElementById('CaptchaInput').value);
	if (str1 == str2){
		return true;
	} else {
		return false;
	}
}

function removeSpaces(string){
	return string.split(' ').join('');
}