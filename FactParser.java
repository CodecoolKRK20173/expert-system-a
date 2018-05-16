import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.*;

public class FactParser extends XMLParser{

    private FactRepository factRepo;
    private Fact fact;

    public FactParser(){
        super("Facts.xml");
        factRepo = new FactRepository();
    }

    
    public void parseFacts(){
        // System.out.println("Root element :" + document.getNodeName()); //print node(facts)
        
			
        NodeList nList = document.getElementsByTagName("Fact");
                
        // System.out.println("----------------------------");

        for (int i = 0; i < nList.getLength(); i++) {

            Node nNode = nList.item(i);

            Element eElement = (Element) nNode;
            String id = eElement.getAttribute("id");
            System.out.println(id);
            String description = eElement.getChildNodes().item(1).getAttributes().item(0).getNodeValue();
            System.out.println("Description : " + description);
            this.fact = new Fact(id, description);

            for(int k = 0; k < eElement.getElementsByTagName("Eval").getLength(); k++){
                boolean evalBoolean;    
                String evalID = eElement.getElementsByTagName("Eval").item(k).getAttributes().item(0).getNodeValue();
                if(eElement.getElementsByTagName("Eval").item(k).getTextContent().equals("true")){
                    evalBoolean = true;
                }
                else{
                    evalBoolean = false;
                }
               
                this.fact.addIdValue(evalID, evalBoolean);
               // System.out.println(evalID + " : " + evalBoolean);

              
        
            }
     
            System.out.println(fact.getValues().size());
     
        }
        factRepo.addFact(this.fact);
    }

    public FactRepository getFactRepository(){
         return this.factRepo;
    }
}