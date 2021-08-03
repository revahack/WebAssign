function validate() {
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    if (username == "group1" && password == "qwerty") {
        
        window.location.replace("./form_validation.html");
        
    } else {
        alert("login failed");
    }
}