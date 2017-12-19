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

function pagination(currentPage, direction) {
//	ControlPostback();
	var language = document.getElementById("option").value;
	var topic = document.getElementById("topic").value;
	
	url = "Showdata?page="+ direction + "&currentpage=" + currentPage + "&language=" + language+"&postBack=true"
	+ "&topic=" + topic;
	ControlPostback();
	
	location.href =url;
}

function searchBtnControl(){

	var language = document.getElementById("option").value;
	var topic = document.getElementById("topic").value;
	url= "Showdata?language=" +language+ "&topic=" + topic+"&postBack=true";
	console.log(language);
	console.log(topic);
	ControlPostback();
	location.href =url;
}
