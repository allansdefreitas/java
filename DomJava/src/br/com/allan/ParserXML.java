package br.com.allan;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Allan Santos
 */
public class ParserXML {

    public static void main(String[] args) throws Exception {

        File xmlFile = new File("bookstore.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document doc = documentBuilder.parse(xmlFile); // doc aponta para o arquivo XML

        
    /* Processar o arquivo XML Bookstore apresentando os resultados das seguintes
    questões no console:
    /* a) Obter o elemento raiz. */
        System.out.println("Nó raíz: " + doc.getDocumentElement().getNodeName());
          
    /* b) Crie um elemento publisher, acrescente o atributo name a este elemento, set o valor do
    atributo para saraiva, e adicione-o ao elemento book da posição 0; */
        Element element_publisher = doc.createElement("publisher");
        Attr attribute_name = doc.createAttribute("name");
        attribute_name.setNodeValue("saraiva"); 
     
        // Vincula attr ao elemento publisher
        element_publisher.setAttributeNode(attribute_name);
        doc.getElementsByTagName("book").item(0).appendChild(element_publisher);
        
        // Testando. Parei aqui _______________________________
        //System.out.println("teste: "+ );
        
        //Element element_book = (Element) doc.getElementsByTagName("book").item(0);
        //element_book.setAttributeNode(attribute_name);
        
        
    /* c) Obtenha o nó atributo do elemento publisher recém criado; */
    /* d) Obtenha o nó pai do elemento publisher; */
    /* e) Clone o nó book posição 1 e adicione-o ao documento; */
    /* f) Obtenha o texto (conteúdo) do elemento author posição 0; */
    /* g) Imprima todos os nomes e valores dos elementos filhos de bookstore. */
   
      

        /* Element newBookElement = doc.createElement("book");
        doc.getElementsByTagName("bookstore").item(0).appendChild(newBookElement); */
    }
}
