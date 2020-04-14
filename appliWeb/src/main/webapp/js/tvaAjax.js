window.onload=function(){

	var btnTva = document.getElementById("btnTva");
	
	btnTva.addEventListener("click" , function (){
		var ht = document.getElementById("ht").value;
		var taux = document.getElementById("taux").value;
		
		var url= "TvaAjaxJsonServlet?ht="+ ht+"&taux="+taux;
		console.log(url);
		makeAjaxGetRequest(url ,  cbGererResTva);
	});
	
}
	

function cbGererResTva(texteReponse){
	document.getElementById("jsonResTva").innerHTML = texteReponse;
	var resTva = JSON.parse(texteReponse /* au format json string */)
	document.getElementById("tva").innerHTML= resTva.tva; 
	document.getElementById("ttc").innerHTML= resTva.ttc; 
}

