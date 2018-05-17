public class ESProvider{
    private FactParser factParser;
    private RuleParser ruleParser;

    public ESProvider(FactParser factParser, RuleParser ruleParser){
        this.factParser = factParser;
        this.ruleParser = ruleParser;
    }
    
    public void collectAnswer(){
        

    }

    public boolean getAnswerByQuestion(String questionID){
        return true;
    }

    public String evaluate(){
        return "Test";
    }
}