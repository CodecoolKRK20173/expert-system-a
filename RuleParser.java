import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class RuleParser extends XMLParser{
    private RuleRepository ruleRepository;

    public static void main(String[] args) {
        RuleParser ruleParser = new RuleParser();
        ruleParser.getRuleRepository();
       
    }

    public RuleParser(){
        super("Rules.xml");
    }

    public RuleRepository getRuleRepository(){
        ruleRepository = new RuleRepository();
        NodeList nList = document.getElementsByTagName("Rule");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            Element element = (Element) nNode;
            
            Question question = createQuestion(element);
            ruleRepository.addQuestion(question);
        }
        ruleRepository.printAllQuestions();
        return ruleRepository;      
    }

    private Question createQuestion(Element element){
        String id = element.getAttribute("id");
        String questionText = element.getElementsByTagName("Question").item(0).getTextContent();
        Answer answer = new Answer(); // need to add other code here (read answer from XML)
        Question question = new Question(id, questionText, answer);
        return question;
    }


    
}