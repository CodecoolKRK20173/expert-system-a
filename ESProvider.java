import java.util.HashMap;
import java.util.InputMismatchException;
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
    public void runApplication(){
        collectAnswer();
        this.factParser.parseFacts();
        display(evaluate());
    }
    public void display(String message){
        System.out.println("Perfect firearm for you is: " + message);
    }
    
    public void collectAnswer(){
        ruleParser.getRuleRepository();

       Iterator<Question> questionIterator = ruleParser.getRuleRepository().getIterator();
        questionAnswers = new HashMap<String, Boolean>();
        Question question;
        String input;
        
        while(questionIterator.hasNext()){
            question = questionIterator.next();
            input = getUserInput();
            questionAnswers.put(question.getId(), question.getEvaluatedAnswer(input));
            System.out.println("id" + question.getId());
            System.out.println("boolean" + question.getEvaluatedAnswer(input));
        }
    }

    private boolean getAnswerByQuestion(String questionID){
        return questionAnswers.get(questionID);
    }
    private boolean ifFactChoosen(Fact fact){
        for(String evalId : fact.getIdSet()){
            if(fact.getValueById(evalId, fact.getValues().get(evalId)) != getAnswerByQuestion(evalId)){

                return false;
            }
        }
        return true;
    }   

    public String evaluate(){
        Iterator<Fact> factIterator = factParser.getFactRepository().getIterator();
        Fact fact;

        while(factIterator.hasNext()){
            fact = factIterator.next();
            if(ifFactChoosen(fact)){
                System.out.println("duupp");
                return fact.getDescription();
            }
        }
        return "maczeta";
    }






    public String getUserInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your answer ");
      
        try{
            String input = scanner.nextLine();
            return input;
        }
        catch(InputMismatchException e){
            System.out.println("Something wrong is with format ");
        }
        return null;
    }
}