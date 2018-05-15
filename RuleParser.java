import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class RuleParser extends XMLParser{

    public static void main(String[] args) {
        RuleParser ruleParser = new RuleParser();
        ruleParser.getRuleRepository();
    }

    public RuleParser(){
        super("Rules.xml");
    }

    public RuleRepository getRuleRepository(){
        RuleRepository ruleRepository = new RuleRepository();
        
        NodeList nList = document.getElementsByTagName("Rule");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            Element eElement = (Element) nNode;
            
            String question = eElement.getElementsByTagName("Question")
            .item(0).getTextContent();
 
        }
        return ruleRepository;
            
    }
    
}