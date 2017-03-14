function obterVoto(candidato){
    
    enviarVoto(candidato);
}

/*function obterVoto(){
     
    $('btn-vote-james').click(function(){
       enviarVoto("James Kirk"); 
    });
    
    $('btn-vote-spock').click(function(){
       enviarVoto("Spock"); 
    });
}*/
var request;
function enviarVoto(candidato)
{
       
	var url="http://localhost:8084/ElectionsStarfleet/ServidorVotacao?nomeCandidato="+candidato;
	if(window.XMLHttpRequest){
		request=new XMLHttpRequest();
	} else if(window.ActiveXObject){
		request=new ActiveXObject("Microsoft.XMLHTTP");
	}
	try {
		request.onreadystatechange = exibeResultado; // A função que vai rodar
		request.open("GET", url, true);
		request.send();
	} catch(e) {
		alert(e);
	}
}

function exibeResultado(){
	if(request.readyState==4){
		document.getElementById('resultado').innerHTML = request.responseText;
	}
}

//ActiveX é uma tecnologia da Microsoft para o desenvolvimento de páginas dinâmicas.
//Mozilla, Safari, Shrome e outros navegadores implementam uma classe XMLHttpRequest que suporta os métodos e propriedades do objeto ActiveX original da Microsoft.