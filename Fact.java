import java.util.*;


public class Fact {
    private String id;
    private String description;
    private Map<String, Boolean> values;

    public Fact(String id, String description, Map<String, Boolean> values){
        this.id = id;
        this.description = description;
        this.values = values;
    }

    public Set<String> getIdSet(){
        Set<String> idSet = new Set<>();
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
}