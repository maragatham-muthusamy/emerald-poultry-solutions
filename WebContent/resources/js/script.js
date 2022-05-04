
function validateName()
{
	var nameError = document.getElementById('name-error');
    var name = document.getElementById('contact-name').value;

    if(name.length ==0)
    {
        nameError.innerHTML='Required';
        return false;
    }
    
    nameError.innerHTML ='';
    return true;
}

function comparePassword()
{
    var passele = document.getElementById('password');
    var confpassele = document.getElementById('confirmpassword');
    
    if(passele != null && confpassele != null)
  	{
		if(passele.value != "") if(passele.value == confpassele.value) return true;
	}

	alert("Passwords empty or don't match");
	return false;
}

function validatePhone()
{
	var phoneError = document.getElementById('phone-error');
    var phone = document.getElementById('contact-phone').value;
    if(phone.length ==0)
    {
        phoneError.innerHTML='Required';
        return false;

    }
    if(phone.length !==10)
    {
        phoneError.innerHTML ='Invalid';
        return false;
    }

    if(!phone.match(/^[0-9]{10}$/))
    {
        phoneError.innerHTML=' Invalid';
        return false;
    }
 
    phoneError.innerHTML = '';
    return true;
}

function validateEmail()
{
	var emailError = document.getElementById('email-error');
    var email = document.getElementById('contact-email').value;
    if(email.length ==0)
    {
        emailError.innerHTML='Required';
        return false;
    }

    if(!email.match("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$"))
    {
        emailError.innerHTML='Invalid';
        return false;
    }
   
    emailError.innerHTML = '';
    return true;
}

function validateMessage()
{
	var max = 50;
    var message = document.getElementById('contact-message');
    var left = max - message.value.length;
    var messageError = document.getElementById('message-error');

    if(left >= 0)
    {
        messageError.innerHTML = left + ' chars left';
        return true;
    }

	message.value = message.value.slice(0, max);
	return false;
}

function validateForm()
{
    if(!validateName() || !validatePhone() || !validateEmail() || !validateMessage())
    {
		var submitError = document.getElementById('submit-error');
        submitError.style.display ='block';
        submitError.innerHtml =" please fix the error to submit";
        setTimeout(
            function()
            {
                submitError.style.display ='none';
            },3000);
        return false;
    }
}

