import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public abstract class XMLParser{

    protected Document document;

    public XMLParser(String xmlPath){
        loadXmlDocument(xmlPath);
    }
    
    public void loadXmlDocument(String xmlPath){
        try{
            File path = new File(xmlPath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            this.document = dBuilder.parse(path);
            this.document.getDocumentElement().normalize();
            System.out.println("Root element :" + this.document.getDocumentElement().getNodeName()); //test
           
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


}