import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FactRepository {
    List<Fact> fact = new ArrayList<>();

    public void addFact(Fact fact){
        this.fact.add(fact);
    }

    // public Iterator<Fact> getIterator(){

    // }
}