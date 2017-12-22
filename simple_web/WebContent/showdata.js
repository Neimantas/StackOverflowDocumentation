//Then using servlet js, add ControlPostback() for postback, always add this function last.

 var url="";
 
function ControlPostback(){
	var firstArg = url.indexOf("?");
	if(firstArg != -1) url += "&postBack=true";
	else {
		url +="?postBack=true";
	}
}


function passid(id) {
	location.href = 'Answer?topicid=' + id;
}

function pageCycleButton(currentPage, direction) {
	var language = document.getElementById("option").value;
	var topic = document.getElementById("topic").value;
	url = "Showdata?page=" + direction + "&currentpage=" + currentPage + "&language=" + language +"&topic=" + topic
	+ "&action=pageCycleButton";
	
	ControlPostback();
	location.href = url;
}

function searchBtnControl() {
	var language = document.getElementById("option").value;
	var topic = document.getElementById("topic").value;
	url= "Showdata?language=" + language + "&topic=" + topic + "&action=searchButton";
	
	ControlPostback();
	location.href =url;
}
