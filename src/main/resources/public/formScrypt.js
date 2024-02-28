function module() {
  let nameVar = document.getElementById("coords").value;
  const xhttp = new XMLHttpRequest();
  xhttp.onload = function () {
    document.getElementById("vector").innerHTML = this.responseText;
  };
  xhttp.open("GET", "/module/" + nameVar);
  xhttp.send();
}

function palin() {
  let nameVar = document.getElementById("word").value;
  const xhttp = new XMLHttpRequest();
  xhttp.onload = function () {
    document.getElementById("palindrome").innerHTML = this.responseText;
  };
  xhttp.open("GET", "/palindrome/" + nameVar);
  xhttp.send();
}

function cosReq() {
  let nameVar = document.getElementById("number2").value;
  const xhttp = new XMLHttpRequest();
  xhttp.onload = function () {
    document.getElementById("cosmsg").innerHTML = this.responseText;
  };
  xhttp.open("GET", "/cos/" + nameVar);
  xhttp.send();
}

function sinReq() {
  let nameVar = document.getElementById("number").value;
  const xhttp = new XMLHttpRequest();
  xhttp.onload = function () {
    document.getElementById("sinmsg").innerHTML = this.responseText;
  };
  xhttp.open("GET", "/sin/" + nameVar);
  xhttp.send();
}
