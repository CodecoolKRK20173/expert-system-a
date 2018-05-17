import java.util.Iterator;

public class QuestionIterator implements Iterator<Question>{
    private RuleRepository ruleRepository;
    private int index;

    public QuestionIterator(RuleRepository ruleRepository){
        this.ruleRepository = ruleRepository;
        this.index = 0;
    }

    @Override
    public boolean hasNext(){
        return index < this.ruleRepository.getRulesList().size();
    }

    @Override
    public Question next(){
            return this.ruleRepository.getRulesList().get(index++);
        

    }
}