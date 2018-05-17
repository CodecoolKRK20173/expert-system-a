import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class ESProvider{
    private FactParser factParser;
    private RuleParser ruleParser;
    private Map<String, Boolean> questionAnswers;

    public ESProvider(FactParser factParser, RuleParser ruleParser){
        this.factParser = factParser;
        this.ruleParser = ruleParser;
    }
    
    public void collectAnswer(){
        Iterator<Question> questionIterator = ruleParser.getRuleRepository().getIterator();
        questionAnswers = new HashMap<String, Boolean>();
        Question question;
        String input;
        
        while(questionIterator.hasNext()){
            question = questionIterator.next();
            input = getUserInput();
            questionAnswers.put(question.getId(), question.getEvaluatedAnswer(input));
        }
        


    }

    public boolean getAnswerByQuestion(String questionID){
        return true;
    }

    public String evaluate(){
        return "Test";
    }
    public String getUserInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your answer ");
        String input = scanner.nextLine();
        return input;
    }
}