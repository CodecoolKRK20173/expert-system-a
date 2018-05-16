import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;

public class Answer {
    private List<Value> possibleValues;

    public Answer(){
        this.possibleValues = new ArrayList<Value>();
    }

    public boolean evaluateAnswerByInput(String input){
        return true;
    }

    public void addValue(Value value){
        this.possibleValues.add(value);
    }
}