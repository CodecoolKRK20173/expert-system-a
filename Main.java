public class Main{

    public static void main(String[] args) {
   
        ESProvider esp = new ESProvider(new FactParser(), new RuleParser());
        esp.runApplication();

        
    }
}