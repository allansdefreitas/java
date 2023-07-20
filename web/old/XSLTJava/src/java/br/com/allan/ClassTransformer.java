package br.com.allan;

import java.io.File;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 *
 * @author Allan Santos
 */
public class ClassTransformer {
    
    public static void main(String[] args){
        
    String path = "web";
        try{
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer( new StreamSource (new File( path + "\\cd_catalog.xslt")));
            StreamSource ss= new StreamSource( new File(path + "\\cd_catalog.xml") );
            StreamResult sr = new StreamResult (new File (path + "\\cd_catalog_result.html") );
            transformer.transform(ss, sr);
            System.out.println("Transformed!");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
