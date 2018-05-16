import java.util.Iterator;

public class QuestionIterator implements Iterator{

    @Override
    public boolean hasNext(){
        return index < rules.size();
    }

    @Override
    public Fact next(){

    }
}