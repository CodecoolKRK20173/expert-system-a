import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;

public class Answer {

    private List<Value> possibleValues;

    public Answer(){

        this.possibleValues = new ArrayList<Value>();
    }

    public boolean evaluateAnswerByInput(String input) throws InputMismatchException {

        boolean reponse = false;
        if (input.equals("yes") || input.equals("no")) {
            for (Value value : possibleValues) {
                for (String option : value.getInputPattern()) {
                    if (option.equals(input)){
                        return reponse = true;
                    } else {
                        return reponse = false;
                    }
                }
            }
        } 
        else{
            throw new InputMismatchException("Answer must have only [yes] or [no] answer ");
        } 
        return reponse;
    }

    public void addValue(Value value){
        
        this.possibleValues.add(value);
    }

    
}