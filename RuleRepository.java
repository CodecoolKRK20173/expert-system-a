import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RuleRepository {
    
    private List<Question> rules;
    private QuestionIterator rulesIterator;

    public RuleRepository(){
        rules = new ArrayList<>();
        this.rulesIterator = new QuestionIterator(this);
    }

    public void addQuestion(Question question){
        rules.add(question);
    }

    public List<Question> getRulesList(){
        return this.rules;
    }

    public Iterator<Question> getIterator(){
        return this.rulesIterator;
    }
    
}