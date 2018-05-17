import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.*;

public class FactParser extends XMLParser{

    public FactParser() {
        
        super("Facts.xml");
        loadXmlDocument("Facts.xml");
    }

    public FactRepository getFactRepository(){
         return new FactRepository();         
    }
}