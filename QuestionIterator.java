import java.util.Iterator;

public class QuestionIterator implements Iterator{
    private RuleRepository ruleRepository;
    private int index;
    


    @Override
    public boolean hasNext(){
        return index < this.ruleRepository.getRulesList().size();
    }

    @Override
    public Question next(){
        if (hasNext()){
            index ++;
            return this.ruleRepository.getRulesList().get(index);
        }

    }
}