import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.*;

public class FactParser extends XMLParser{

    private FactRepository factRepo;

    public FactParser(){
        super("Facts.xml");
        factRepo = new FactRepository();
    }

    public void parseFacts(){        
        NodeList nList = document.getElementsByTagName("Fact");

        for (int i = 0; i < nList.getLength(); i++) {

            Node nNode = nList.item(i);

            Element eElement = (Element) nNode;
            String id = eElement.getAttribute("id");
            String description = eElement.getChildNodes().item(1).getAttributes().item(0).getNodeValue();
            Fact fact = new Fact(id, description);
            int evalsCount = eElement.getElementsByTagName("Eval").getLength();

            for(int k = 0; k < evalsCount; k++){
                boolean evalBoolean = Boolean.valueOf(eElement.getElementsByTagName("Eval").item(k).getTextContent());    
                String evalID = eElement.getElementsByTagName("Eval").item(k).getAttributes().item(0).getNodeValue();
                // if(eElement.getElementsByTagName("Eval").item(k).getTextContent().equals("true")){
                //     evalBoolean = true;
                // }
                // else{
                //     evalBoolean = false;
                // }
               
                fact.addIdValue(evalID, evalBoolean);
            }
            
            factRepo.addFact(fact);
        }
        System.out.println(factRepo.getFacts().size());
    }

    public FactRepository getFactRepository(){
         return this.factRepo;
    }
}