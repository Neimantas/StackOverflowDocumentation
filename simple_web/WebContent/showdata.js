function sendLanguageAndTopicParameters() {
	var language = document.getElementById("option").value;
	var topic = document.getElementById("topic").value;
    $.post("/simple_web/Showdata?language="+language+"&topic="+topic,
        function(data) {
    });
    
    
}

