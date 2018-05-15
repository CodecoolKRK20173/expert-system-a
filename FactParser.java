import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class FactParser extends XMLParser{

    public FactParser(){
        loadXmlDocument("Facts.xml");

    }
    public void  parseFacts(){
        System.out.println("Root element :" + getDocument().getDocumentElement().getNodeName()); //print node(facts)
        
			
        NodeList nList = getDocument().getElementsByTagName("Fact");
                
        System.out.println("----------------------------");

        for (int i = 0; i < nList.getLength(); i++) {

            Node nNode = nList.item(i);
                    
            System.out.println("\nCurrent Element :" + nNode.getNodeName());
                    
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element eElement = (Element) nNode;

                System.out.println("Fact id : " + eElement.getAttribute("id"));
   
              
                System.out.println("Description : " + eElement.getChildNodes().item(1).getAttributes().item(0).getNodeValue());
            
                System.out.println("family : " + eElement.getElementsByTagName("Eval").item(0).getTextContent());
                System.out.println("money : " + eElement.getElementsByTagName("Eval").item(1).getTextContent());
                System.out.println("comfort : " + eElement.getElementsByTagName("Eval").item(2).getTextContent());
                System.out.println("luxury : " + eElement.getElementsByTagName("Eval").item(3).getTextContent());

            }
        }
    }

    public FactRepository getFactRepository(){

         return new FactRepository();
        
         
    }
}