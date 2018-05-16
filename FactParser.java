public class FactParser extends XMLParser{

    private String xmlPath = "Facts.xml";

    public FactParser() {
        
        super(xmlPath);
        loadXmlDocument("Facts.xml");
    }

    public FactRepository getFactRepository(){
         return new FactRepository();         
    }
}