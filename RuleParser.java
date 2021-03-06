import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class RuleParser extends XMLParser{

    private RuleRepository ruleRepository;


    public RuleParser(){
        loadXmlDocument("Rules.xml");
        this.ruleRepository = new RuleRepository();
        ParseRule();
    }

    private void ParseRule(){
        NodeList nList = document.getElementsByTagName("Rule");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            Element element = (Element) nNode;
            
            Question question = readQuestion(element);
            ruleRepository.addQuestion(question);
        }
    }

    public RuleRepository getRuleRepository(){
        return this.ruleRepository;      
    }

    private Question readQuestion(Element element){
        String id = element.getAttribute("id");
        String questionText = element.getElementsByTagName("Question").item(0).getTextContent();
        Answer answer = createAnswer((Element) element.getElementsByTagName("Answer").item(0));

        Question question = new Question(id, questionText, answer);
        return question;
    }

    private Answer createAnswer(Element answer) {
        NodeList selectionList = answer.getElementsByTagName("selection");
        Answer newAnswer = new Answer();
        for (int i = 0; i < selectionList.getLength(); i++) {
            newAnswer.addValue(getValueObject(selectionList.item(i)));
        }   
        return newAnswer;
    }

    private Value getValueObject(Node selection) {
        NodeList childList = selection.getChildNodes();
        for (int i = 0; i < childList.getLength(); i++) {
            if (childList.item(i) instanceof Element) {
                return getValueInstance((Element) childList.item(i), (Element) selection);
            }
        }
        return null;
    }

    private Value getValueInstance(Element child, Element parent) {
        String name = "value";
        if (child.getTagName().equals("SingleValue")) {
            if (parent.getAttribute(name).equals("true")) {
                SingleValue sv = new SingleValue("yes", true);//>>>>>>>>>Chyba nie potrzebe ?
                return new SingleValue("yes", true);    
            } else { 
                return new SingleValue("no", false); 
            }
            
        } else return null;
    }    
}