import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FactRepository {
    private List<Fact> facts;
    private FactIterator factIterator;

    public FactRepository(){
        facts = new ArrayList<>();
        this.factIterator = new FactIterator(this);
    }

    public void addFact(Fact fact){
        this.facts.add(fact);
        
    }

    public Iterator<Fact> getIterator(){
        return this.factIterator;
    }
 
    public List<Fact> getFacts(){
        return this.facts;
    }
}