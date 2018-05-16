import java.util.ArrayList;
import java.util.List;

public abstract class Value {

    private List<String> params;
    private boolean selectionType;

    public Value(List<String> params, boolean selectionType) {
        this.params = params;
        this.selectionType = selectionType;
    }

    public List<String> getInputPattern() {
        return this.params;
    }

    public boolean getSelectionType() {
        return this.selectionType;
    }
    
}