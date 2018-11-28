/**
 * 
 */
var getJSON = function(url, callback) {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', url, true);
    xhr.responseType = 'json';
    xhr.onload = function() {
      var status = xhr.status;
      if (status === 200) {
        callback(null, xhr.response);
      } else {
        callback(status, xhr.response);
      }
    };
    xhr.send();
};

function LoadYourStuff() {    
    window.alert("sometext");
       $.ajax({
          cache: false,
           type: "GET",
            url: '@Url.Action("Test","Default")',
       dataType: "html",
        success: function (data) { $("#testcontainer").hide().html(data).fadeIn("slow");}
       });
   }

function LoadYourStuff() {    
    var xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function() {
   	if (this.readyState == 4 && this.status == 200) {
     	
     		  var myObj = JSON.parse(this.responseText);
     	   	window.alert("nombre ::" + myObj.nombre);
     	  
   	}
		};
		xhttp.open("GET", "/nuevo", true);
		xhttp.send();
	}

function validar() {
	    var x = document.forms["miFormulario"]["desde"].value;
	    alert(x);
	    if (x == "") {
	        alert("Name must be filled out");
	        return false;
	    }
}