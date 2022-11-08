var http_request; // objeto XMLHTTPREQUEST
var obj; // obj aponta para a div de resultado
var browser;

//Mozilla
if (window.XMLHttpRequest) {
    browser = 'ns';
    http_request = new XMLHttpRequest();

    if (http_request.overrideMimeType)
        http_request.overrideMimeType('text/xml');
}

//Internet Explorer
else if (window.ActiveXObject) {
    browser = 'ie';
    try {
        http_request = new ActiveXObject("Msxml2.XMLHTTP");
    } catch (e) {
        try {
            http_request = new ActiveXObject("Microsoft.XMLHTTP");
        } catch (e) {
        }
    }
}

function  enviarRequisicao(arquivo, resultado) {
    obj = document.getElementById(resultado); // obj aponta para a div resultado // obj point to div 'resultado'

    if (http_request == null) {
        alert('Nao foi possivel instanciar XMLHttpRequest.');
        return false;
    }

    http_request.onreadystatechange = mostrarConteudo;
    http_request.open('GET', arquivo, true); // Requisição assíncrona // Assyncronous request
    http_request.send(null);
}

function mostrarConteudo() {
    if (http_request.readyState == 4) {
        if (http_request.status == 200) {
            var xmldoc = http_request.responseXML;

            var size_of_cds = 3; // Cálculo ainda precisa ser dinâmico // Calculation still need to be dinamyc
            var array_cds = [];

            // Getting values from XML, using DOM --------------------------------------------++++++++++++++
            // Obtendo valores do XML com DOM 
            for (var i = 0; i < size_of_cds; i++) {

                var cd = xmldoc.getElementsByTagName("cd").item(i);
                var the_title = cd.getElementsByTagName("title").item(0).firstChild.nodeValue;
                var the_artist = cd.getElementsByTagName("artist").item(0).firstChild.nodeValue;
                var the_country = cd.getElementsByTagName("country").item(0).firstChild.nodeValue;
                var the_price = cd.getElementsByTagName("price").item(0).firstChild.nodeValue;
                var the_year = cd.getElementsByTagName("year").item(0).firstChild.nodeValue;

                // Objeto cd // cd object     
                var obj_cd = {
                    title: the_title,
                    artist: the_artist,
                    country: the_country,
                    price: the_price,
                    year: the_year
                };

                array_cds.push(obj_cd);
//                alert('cd: ' + obj_cd.title);

            }

            // Imprimindo resultados  // printing results -----------------------+++++++++++++++++++++++++
            for (var i = 0; i < size_of_cds; i++) {
                
                // Criando elementos -----------------------------
                // Creating elements 
                var elem_title = document.createElement("b");
                elem_title.innerHTML = "Title: ";
                
                var elem_artist = document.createElement("b");
                elem_artist.innerHTML = "Artist: ";
                
                var elem_country = document.createElement("b");
                elem_country.innerHTML = "Counrty: ";
                
                var elem_price =  document.createElement("b");
                elem_price.innerHTML = "Price: ";
                
                var elem_year = document.createElement("b");
                elem_year.innerHTML = "Year: ";
                
                var break_line = document.createElement("br");
                
                // Criando elementos para os valores do XML ------------------
                // Creating elements for values from XML 
                var elem_title_value = document.createElement("span");
                elem_title_value.innerHTML = array_cds[i].title + " ";
                
                var elem_artist_value = document.createElement("span");
                elem_artist_value.innerHTML = array_cds[i].artist + " ";
                
                var elem_country_value = document.createElement("span");
                elem_country_value.innerHTML = array_cds[i].country + " ";
                
                var elem_price_value = document.createElement("span");
                elem_price_value.innerHTML = array_cds[i].price + " ";
                
                var elem_year_value = document.createElement("span");
                elem_year_value.innerHTML = array_cds[i].year + " ";
                
                // Acrescentado resultados na div resultado
                // Appending results in 'resultado' div
                obj.append(elem_title, elem_title_value, elem_artist, elem_artist_value, elem_country, 
                elem_country_value, elem_price, elem_price_value, elem_year, elem_year_value, break_line);  
                
            }
        } else
            alert('falha');
    }
}