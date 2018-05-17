import java.util.*;


public class Fact {
    private String id;
    private String description;
    private Map<String, Boolean> values = new HashMap<>();

    public Fact(String id, String description){
        this.id = id;
        this.description = description;
    }

    public Set<String> getIdSet(){
        Set<String> idSet = new HashSet<>();
        for (Map.Entry<String, Boolean> entry : this.values.entrySet()){
            idSet.add(entry.getKey());
        }
        return idSet;
    }

    public void addIdValue(String id, boolean value){
        this.values.put(id, value);
    }

    public boolean getValueById(String id, boolean value){
       for (Map.Entry<String, Boolean> entry : this.values.entrySet()){
            if (entry.getKey().equals(id) && entry.getValue().equals(value)){
                return true;
            }
       }
       return false;
    }

    public String getDescription(){
        return this.description;
    }
    public Map<String, Boolean> getValues(){
        return this.values;
    }
}