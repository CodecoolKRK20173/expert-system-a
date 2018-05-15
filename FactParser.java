public class FactParser extends XMLParser{

    public FactParser(){
        loadXmlDocument("Facts.xml");
    }

    public FactRepository getFactRepository(){

         return new FactRepository();
        
         
    }
}