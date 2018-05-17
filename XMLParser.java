import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public abstract class XMLParser{

    protected Document document;

    public void loadXmlDocument(String xmlPath){
        try{
            File path = new File(xmlPath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            this.document = dBuilder.parse(path);
            this.document.getDocumentElement().normalize();
        }
        catch (FactoryConfigurationError e) {
            e.printStackTrace();
        }
        catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        catch (SAXException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}