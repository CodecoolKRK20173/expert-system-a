import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;

public class Answer {

    private List<Value> possibleValues;

    public Answer(){
        this.possibleValues = new ArrayList<Value>();
    }

    public boolean evaluateAnswerByInput(String input) throws InputMismatchException {

        boolean respone = false;
        if (input.equals("yes") || input.equals("no")) {
            for (Value value : possibleValues) {
                return respone = checkCorretoption(value, input);
            }
        } 
        else{
            throw new InputMismatchException("Answer must have only [yes] or [no] answer ");
        } 
        return respone;
    }

    private boolean checkCorretoption(Value value, String input){

        for (String option : value.getInputPattern()) {
            if (option.equals(input)){
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public void addValue(Value value){
        this.possibleValues.add(value);
    }

    
}