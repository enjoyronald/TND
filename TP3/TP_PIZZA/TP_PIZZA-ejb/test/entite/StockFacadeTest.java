/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

import java.nio.file.StandardCopyOption;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import java.nio.file.StandardOpenOption;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.junit.Test;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 *
 * @author enjoy
 */
public class StockFacadeTest {

    public StockFacadeTest() {
    }

    @BeforeClass
    public static void setUpClass() throws IOException {
        Path to = Paths.get("build" + File.separator + "test" + File.separator + "classes" + File.separator + "META-INF" + File.separator + "glassfish-resources.xml");
        Path from = Paths.get("build" + File.separator + "classes" + File.separator + "META-INF" + File.separator + "META-INF" + File.separator + "glassfish-resources.xml");
        Files.createDirectories(to.getParent());
        BufferedWriter out = Files.newBufferedWriter(to, StandardCharsets.UTF_8, StandardOpenOption.CREATE);
        out.write("");
        out.close();
        Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
        //addScopeGlassfish(to);
        
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
        //addScoptePersistence(to);

    }
    static public void addScopeGlassfish(Path glas){
        try {
            File inputFile = glas.toFile();
            DocumentBuilderFactory docFactory
                    = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder
                    = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(inputFile);
            
            Node jdbc_resource= doc.getElementsByTagName("jdbc-resource").item(0);
            NamedNodeMap attr = jdbc_resource.getAttributes();
            Node jndi_name= attr.getNamedItem("jndi-name");
            jndi_name.setTextContent("java:app/"+jndi_name.getTextContent());
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DocumentType doctype = doc.getDoctype();
            if (doctype != null) {
                transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, doctype.getPublicId());
                transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, doctype.getSystemId());
            }
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(glas.toFile());
            transformer.transform(source, result);
            
        } catch (IOException | ParserConfigurationException | DOMException | SAXException e) {
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(StockFacadeTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(StockFacadeTest.class.getName()).log(Level.SEVERE, null, ex);
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
            
            Node jta_data_source= doc.getElementsByTagName("jta-data-source").item(0);
            jta_data_source.setTextContent("java:app/"+jta_data_source.getTextContent());
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DocumentType doctype = doc.getDoctype();
            if (doctype != null) {
                transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, doctype.getPublicId());
                transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, doctype.getSystemId());
            }
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(persist.toFile());
            transformer.transform(source, result);
            
        } catch (IOException | ParserConfigurationException | DOMException | SAXException e) {
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(StockFacadeTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(StockFacadeTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @AfterClass
    public static void tearDownClass() {

    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        StockFacadeLocal instance = (StockFacadeLocal) container.getContext().lookup("java:global/classes/StockFacade");
        List<Stock> lStock = instance.findAll();
        for (Stock elem : lStock) {
            System.out.println("Pizza : " + elem.getPizzaId().getPizzaId());
            System.out.println("  - Prix : " + elem.getPizzaId().getPrix() + " €");
            System.out.println("  - Quantité : " + elem.getQuantite());
        }
    }
}
