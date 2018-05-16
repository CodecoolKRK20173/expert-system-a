import java.util.ArrayList;
import java.util.Arrays;

public class SingleValue extends Value { 

    public SingleValue(String param, boolean selectionType) {
        super(new ArrayList<>(Arrays.asList(param)), selectionType);
    }
    
}