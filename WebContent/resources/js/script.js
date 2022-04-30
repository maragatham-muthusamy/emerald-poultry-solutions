var nameError = document.getElementById('name-error');
var phoneError = document.getElementById('phone-error');
var emailError = document.getElementById('email-error');
var submitError = document.getElementById('submit-error');

function validateName()
{
    var name = document.getElementById('contact-name').value;
    if(name.length ==0)
    {
        nameError.innerHTML='Name is required';
        return false;
    }
    
    nameError.innerHTML ='valid';
    return true;
}

function validatePhone()
{
    var phone = document.getElementById('contact-phone').value;
    if(phone.length ==0)
    {
        phoneError.innerHTML='Phonenumber is required';
        return false;

    }
    if(phone.length !==10)
    {
        phoneError.innerHTML ='Invalid Phone Number';
        return false;
    }

    if(!phone.match(/^[0-9]{10}$/))
    {
        phoneError.innerHTML=' Invalid';
        return false;
    }
 
    phoneError.innerHTML = 'valid';
    return true;
}

function validateEmail()
{
    var email = document.getElementById('contact-email').value;
    if(email.length ==0)
    {
        emailError.innerHTML='Email is required';
        return false;
    }

    if(!email.match("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$"))
    {
        emailError.innerHTML='Email Invalid';
        return false;
    }
   
    emailError.innerHTML = 'valid';
    return true;
}

function validateMessage()
{
    var message = document.getElementById('contact-message').value;
    messageError.innerHTML = 'valid';
    /*var required = 30;
    var left = required - message.length;
    var messageError = document.getElementById('meassage-error');

    if(left > 0)
    {
        messageError.innerHTML = 'a ' + left + 'more characters required';
        return true;
    }

    alert("valid");

    messageError.innerHTML = 'valid';*/
    return true;
   
}

function validateForm()
{
    if(!validateName() || !validatePhone() ||!validateEmail() ||!validateMessage())
    {
        submitError.style.display ='block';
        submitError.innerHtml =" please fix the error to submit";
        setTimeout(
            function()
            {
                submitError.style.display ='none';
            },3000);
        return false;
    }
    else
    {
        alert("Message added successfully")
    }
}

