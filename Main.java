public class Main{

    public static void main(String[] args) {
        // FactParser factparser = new FactParser();
        // RuleParser ruleParser = new RuleParser();
        ESProvider esp = new ESProvider(new FactParser(), new RuleParser());
      //  factparser.parseFacts();
        
    }
}