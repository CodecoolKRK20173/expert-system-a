import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FactRepository {
    private List<Fact> facts = new ArrayList<>();
    private FactIterator factIterator;

    public void addFact(Fact fact){
        this.facts.add(fact);
        this.factIterator = new FactIterator(this);
    }

    public Iterator<Fact> getIterator(){
        return this.factIterator;
    }
 
    public List<Fact> getFacts(){
        return this.facts;
    }
}