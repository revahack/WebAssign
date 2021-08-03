function validate() {
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    if (username == "group1" && password == "qwerty") {
        // alert("Login Successful");
        //return false;
    } else {
        alert("login failed");
    }
}