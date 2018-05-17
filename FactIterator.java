import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FactIterator implements Iterator<Fact>>{

    private FactRepository factRepository;
    private int index = 0;

    public FactIterator(FactRepository factRepository){
        this.factRepository = factRepository;
    }

    @Override
    public boolean hasNext(){
        return this.index < factRepository.getFacts().size();
    }

    @Override
    public Fact next(){
        return factRepository.getFacts().get(this.index++);
    }
}
