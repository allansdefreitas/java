
var request;
function sendVote(candidate)
{

    var url = "ElectionSystem?candidateName=" + candidate;
    if (window.XMLHttpRequest) {
        request = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        request = new ActiveXObject("Microsoft.XMLHTTP");
    }
    try {
        request.onreadystatechange = showResult; /* This function will run */
        request.open("GET", url, true);
        request.send();
    } catch (e) {
        alert(e);
    }
}

function showResult() {
    if (request.readyState == 4) {

        var text = request.responseText;
        var resposta = JSON.parse(text);
        var response = "";
        for ( var i = 0; i < resposta.length; i++ ) {
            response = response + "<span><b> " + resposta[i].name + "</b> with <b>"+ resposta[i].votes + "</b> votes</span><br />";

        }

        document.getElementById('resultDiv').innerHTML = response;
    }
}

//ActiveX é uma tecnologia da Microsoft para o desenvolvimento de páginas dinâmicas.
//Mozilla, Safari, Shrome e outros navegadores implementam uma classe XMLHttpRequest que suporta os métodos e propriedades do objeto ActiveX original da Microsoft.


