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
            
            Question question = readQuestion(element);
            ruleRepository.addQuestion(question);
        }
        ruleRepository.printAllQuestions();
        return ruleRepository;      
    }

    private Question readQuestion(Element element){
        String id = element.getAttribute("id");
        String questionText = element.getElementsByTagName("Question").item(0).getTextContent();
        //Answer answer = new Answer(); // need to add other code here (read answer from XML)

        NodeList nodeA = element.getElementsByTagName("Answer").item(0);
        Answer answer = readAnswer(nodeA);

        Question question = new Question(id, questionText, answer);
        return question;
    }

    private Answer readAnswer(NodeList nodeA) {
        Element answerElement = (Element)nodeA;
        NodeList answersList = answerElement.getElementsByTagName("Selection");
        Answer createdAnswer = new Answer();

        for (int i = 0; i < answersList.getLength(); i++) {
            createdAnswer.addValue(getValueObject(answersList.item(i)));
        }
        return createdAnswer;
    }


    
}