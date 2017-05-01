package br.com.allan;

import java.io.File;
import java.time.Clock;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author Allan Santos
 */
public class XMLParser {

    public static void main(String[] args) throws Exception {

        File xmlFile = new File("bookstore.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document doc = documentBuilder.parse(xmlFile); // doc aponta para o arquivo XML

        /* Processar o arquivo XML Bookstore apresentando os resultados das seguintes ++++++++++++++++++++++++++++++++++++++++++++++++++
        questões no console:
        
        /* a) Obter o elemento raiz. --------------------------------------------------------------------------- Ok*/
        System.out.println("Nó raíz: " + doc.getDocumentElement().getNodeName());

        /* b) Crie um elemento publisher, acrescente o atributo name a este elemento, set o valor do
        atributo para saraiva, e adicione-o ao elemento book da posição 0;  ------------------------------------ Ok */
        Element element_publisher = doc.createElement("publisher");
        Attr attribute_name = doc.createAttribute("name");
        attribute_name.setNodeValue("saraiva");

        // Vincula attr ao elemento publisher
        element_publisher.setAttributeNode(attribute_name);
        doc.getElementsByTagName("book").item(0).appendChild(element_publisher);

        /* c) Obtenha o nó atributo do elemento publisher recém criado; --------------------------------------- FALTA */
        //Element element_publisher_c = (Element) doc.getDocumentElement().getFirstChild().getNodeName();
        System.out.println("c: " + element_publisher.getAttribute("name"));

        /* d) Obtenha o nó pai do elemento publisher;  --------------------------------------------------------- Ok */
        System.out.println("d: " + element_publisher.getParentNode().getNodeName());

        /* e) Clone o nó book posição 1 e adicione-o ao documento; --------------------------------------------- Ok */
        //Element element = doc.getElementsByTagName("book").item(1).;
        Node old_no_book = doc.getElementsByTagName("book").item(1);
        Node new_no_book = old_no_book.cloneNode(true);

        // Adicionando o novo nó como filho de bookstore
        doc.getDocumentElement().appendChild(new_no_book);

        /* f) Obtenha o texto (conteúdo) do elemento author posição 0; -------------------------------------------- Ok */
        System.out.println("f: " + doc.getElementsByTagName("author").item(0).getTextContent());

        /* g) Imprima todos os nomes e valores dos elementos filhos de bookstore. --------------------------------- FALTA */
        final int SIZE_OF_ELEMENTS = 1; // quantidade de filhos de bookstore

        for (int i = 0; i < SIZE_OF_ELEMENTS; i++) {
            System.out.println("g: " + doc.getDocumentElement().getChildNodes().getLength());

        }

    }

}
