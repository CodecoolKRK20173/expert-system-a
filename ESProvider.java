import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class ESProvider{
    
    private final String clearSreen = "\033[H\033[2J";
    private FactParser factParser;
    private RuleParser ruleParser;
    private Map<String, Boolean> questionAnswers;

    public ESProvider(FactParser factParser, RuleParser ruleParser){

        this.factParser = factParser;
        this.ruleParser = ruleParser;
    }
    
    public void runApplication(){

        System.out.println(clearSreen);
        collectAnswer();
        String userWeapon = evaluate();
        display(userWeapon);

    }
    
    public void collectAnswer(){
        ruleParser.getRuleRepository();

       Iterator<Question> questionIterator = ruleParser.getRuleRepository().getIterator();

        questionAnswers = new HashMap<String, Boolean>();
        Question question;
        String input;
        
        while(questionIterator.hasNext()){
            question = questionIterator.next();
            System.out.println(question.getQuestion());
            input = getUserInput();
            questionAnswers.put(question.getId(), question.getEvaluatedAnswer(input));
        }
    }

    private boolean getAnswerByQuestion(String questionID){
        return questionAnswers.get(questionID);
    }

    public String evaluate(){

        Iterator<Fact> factIterator = factParser.getFactRepository().getIterator();
        String userWeapon;
        while (factIterator.hasNext()){
            Fact fact = factIterator.next();
            if (fact.getValues().equals(questionAnswers)){
                return fact.getDescription();
            }
        }
        return null;
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
    public void display(String message){

        System.out.println("Perfect firearm for you is: " + message);
    }

}