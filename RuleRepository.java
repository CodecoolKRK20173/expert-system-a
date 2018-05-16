import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RuleRepository {
    private List<Question> rules;

    public RuleRepository(){
        rules = new ArrayList<>();
    }

    public void addQuestion(Question question){
        rules.add(question);
    }

    public List<Question> getRulesList(){
        return this.rules;
    }

    //added for testing
    public void printAllQuestions(){
        for (Question question : rules){
            System.out.println(question.getId());
            System.out.println(question.getQuestion());

        }
    }

    // public Iterator<Question> getIterator(){
        
    // }
    
}