function sendLanguageAndTopicParameters() {
	var language = document.getElementById("option").value;
	var topic = document.getElementById("topic").value;
    $.post("/simple_web/Showdata?language="+language+"&topic="+topic+"&loadPage=true",
        function(data) {
    });
}

function pagination(currentPage, direction) {
	var language = document.getElementById("option").value;
	var topic = document.getElementById("topic").value;
	location.href = "Showdata?page="+ direction + "&currentpage=" + currentPage + "&loadPage=true" + "&language=" + language
	+ "&topic=" + topic;
}

