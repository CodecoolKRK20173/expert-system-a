import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RuleRepository {
    private List<Question> rules;
    private QuestionIterator<Question> rulesIterator;

    public RuleRepository(){
        rules = new ArrayList<>();
        rulesIterator = new QuestionIterator();
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