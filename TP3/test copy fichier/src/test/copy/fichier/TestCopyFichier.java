/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.copy.fichier;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerFactory;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;

/**
 *
 * @author enjoy
 */
public class TestCopyFichier {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Path to, from;
        BufferedWriter out;
        
        to = Paths.get("build" + File.separator + "test" + File.separator + "classes" + File.separator + "META-INF" + File.separator + "glassfish-resources.xml");
        from = Paths.get("build" + File.separator + "classes" + File.separator + "META-INF" + File.separator + "META-INF" + File.separator + "glassfish-resources.xml");
        Files.createDirectories(to.getParent());
        out = Files.newBufferedWriter(to, StandardCharsets.UTF_8, StandardOpenOption.CREATE);
        out.write("");
        out.close();
        Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
        addScopeGlassfish(to.toFile());

        to = Paths.get("build" + File.separator + "test" + File.separator + "classes" + File.separator + "META-INF" + File.separator + "persistence.xml");
        from = Paths.get("build" + File.separator + "classes" + File.separator + "META-INF" + File.separator + "persistence.xml");
        // on s'assure que le repertoire existe 
        Files.createDirectories(to.getParent());
        //on cree le fichier
        out = Files.newBufferedWriter(to, StandardCharsets.UTF_8, StandardOpenOption.CREATE);
        out.write("");
        out.close();
        Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
        // add scope java:app to persistance
        addScoptePersistence(to);
    }
    
    static public void addScopeGlassfish(File glas) {
        try {
            File inputFile = glas;
            DocumentBuilderFactory docFactory
                    = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder
                    = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(inputFile);

            Node jdbc_resource = doc.getElementsByTagName("jdbc-resource").item(0);
            NamedNodeMap attr = jdbc_resource.getAttributes();
            Node jndi_name = attr.getNamedItem("jndi-name");
            jndi_name.setTextContent("java:app/" + jndi_name.getTextContent());
            System.out.println(jndi_name.getTextContent()+" et voila");
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
           
            transformer.setOutputProperty(OutputKeys.INDENT, "yes"); 
            DocumentType doctype = doc.getDoctype();
            if (doctype != null) {
                transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, doctype.getPublicId());
                transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, doctype.getSystemId());
            }
            
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(glas);
            transformer.transform(source, result);

        } catch (IOException | ParserConfigurationException | DOMException | SAXException e) {
            System.out.println("grosse erde");
        } catch (TransformerException ex) {
            Logger.getLogger(TestCopyFichier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static private void addScoptePersistence(Path persist) {
        try {
            File inputFile = persist.toFile();
            DocumentBuilderFactory docFactory
                    = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder
                    = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(inputFile);

            Node jta_data_source = doc.getElementsByTagName("jta-data-source").item(0);
            jta_data_source.setTextContent("java:app/" + jta_data_source.getTextContent());
        } catch (IOException | ParserConfigurationException | DOMException | SAXException e) {
        }
    }
}
