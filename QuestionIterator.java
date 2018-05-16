import java.util.Iterator;

public class QuestionIterator implements Iterator{
    private List<Question> questionsList;
    private int index;
    

    @Override
    public boolean hasNext(){
        return index < rules.size();
    }

    @Override
    public Fact next(){

    }
}