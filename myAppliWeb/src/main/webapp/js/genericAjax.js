
function makeAjaxGetRequest(url,callback) {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && (xhr.status == 200 || xhr.status == 0)) {
		    callback(xhr.responseText);
		}
	};
	//var token = localStorage.getItem("token");
	
	xhr.open("GET", url, true);
	/*if(token!=null){
		xhr.setRequestHeader("Authorization", "Bearer "+token);
	}*/
	xhr.send(null);
}
