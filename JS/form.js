function ageCalculator() {
    let dob = new Date(user_dob.value);
    //calculate month difference from current date in time  
    let month_diff = Date.now() - dob.getTime();
    //convert the calculated difference in date format  
    let age_dt = new Date(month_diff);
    //extract year from date      
    let year = age_dt.getUTCFullYear();
    //now calculate the age of the user  
    let age = Math.abs(year - 1970);
    //display the calculated age  
    document.getElementById("age").value = age;
}

function checkErrors() {
    if (fname.value.length < 1 || !(!/[^a-zA-Z]/.test(fname.value))) {
        fnameError.textContent = "Please enter a valid Name!";
        fnameError.style.color = 'red';
        return false;
    }
    if (lname.value.length < 1 || !(!/[^a-zA-Z]/.test(lname.value))) {
        lnameError.textContent = "Please enter a valid Name!";
        lnameError.style.color = 'red';
        return false;
    }
    if (!(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email.value))) {
        emailError.textContent = "Please enter a valid Email address!";
        emailError.style.color = 'red';
        return false;
    }
    if (gender.value.length < 1) {
        genderError.textContent = "Please select a Gender!";
        genderError.style.color = 'red';
        return false;
    }
    if (dob.value.length < 1) {
        dobError.textContent = "Please select a Date!";
        dobError.style.color = 'red';
        return false;
    }
    if (stream.value.length < 1) {
        streamError.textContent = "Please select a Stream!";
        streamError.style.color = 'red';
        return false;
    }

    return true;
}

function savePersonalData() {
    localStorage.fname = form.elements['fname'].value;
    localStorage.lname = form.elements['lname'].value;
    localStorage.email = form.elements['email'].value;
    localStorage.gender = form.elements['gender'].value;
    localStorage.dob = form.elements['dob'].value;
    localStorage.age = form.elements['age'].value;
    localStorage.stream = form.elements['stream'].value;

    return true
}

let form = document.getElementById('user-form'),
    fname = form.elements['fname'],
    lname = form.elements['lname'],
    email = form.elements['email'],
    gender = form.elements['gender'],
    user_dob = form.elements['dob'],
    age = document.getElementById('age'),
    fnameError = document.getElementById('fname-error'),
    lnameError = document.getElementById('lname-error'),
    emailError = document.getElementById('email-error'),
    genderError = document.getElementById('gender-error'),
    dobError = document.getElementById('dob-error'),
    streamError = document.getElementById('stream-error'),
    submit = document.getElementById('personal-details-submit');

age.addEventListener('click', function() {
    ageCalculator();
});

submit.addEventListener('click', function() {
    fnameError.textContent = "";
    lnameError.textContent = "";
    emailError.textContent = "";
    genderError.textContent = "";
    dobError.textContent = "";
    streamError.textContent = "";
    if(checkErrors() && savePersonalData()){
        window.location.replace("./marksheet.html");
    }
    /*console.log(localStorage.fname,
        localStorage.lname,
        localStorage.gender,
        localStorage.email,
        localStorage.dob,
        localStorage.age,
        localStorage.stream,
    );*/
    event.preventDefault();
});