import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;

public class Answer {
    private List<Value> possibleValues;

    public Answer(){
        this.possibleValues = new ArrayList<Value>();
    }

    public boolean evaluateAnswerByInput(String input) throws InputMismatchException {
        boolean papier = false;
        
        if (input.equals("yes") || input.equals("no")) {
            for (Value value : possibleValues) {
                for (String option : value.getInputPattern()) {
                    if (option.equals(input)){
                        papier = true;
                    } else {
                        papier = false;
                    }
                }
            }
        } else
            throw new InputMismatchException();
        return papier;
    }

    public void addValue(Value value){
        this.possibleValues.add(value);
    }

    
}