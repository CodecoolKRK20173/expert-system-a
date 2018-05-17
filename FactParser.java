import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.*;

public class FactParser extends XMLParser {

    private FactRepository factRepository;

    public FactParser() {
        loadXmlDocument("Facts.xml");
        this.factRepository = new FactRepository();
        parseFacts();
    }

    private void parseFacts() {
        NodeList nodeList = document.getElementsByTagName("Fact");
        
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node nNode = nodeList.item(i);
            detailParse(nNode);
        }
    }

    private void detailParse(Node nNode) {
        final int CHILDNODES = 1;
        final int ELEMENTINNODES = 0;

        Element eElement = (Element) nNode;
        String id = eElement.getAttribute("id");
        String description = eElement.getChildNodes().item(CHILDNODES).getAttributes().item(ELEMENTINNODES)
                .getNodeValue();

        Fact fact = new Fact(id, description);
        addValuesToFacts(fact, eElement);
    }

    private void addValuesToFacts(Fact fact, Element eElement) {

        int evalsCount = eElement.getElementsByTagName("Eval").getLength();
        for (int j = 0; j < evalsCount; j++) {
            boolean evalBoolean = Boolean.valueOf(eElement.getElementsByTagName("Eval").item(j).getTextContent());
            String evalID = eElement.getElementsByTagName("Eval").item(j).getAttributes().item(0).getNodeValue();
            fact.addIdValue(evalID, evalBoolean);
        }
        factRepository.addFact(fact);

    }

    public FactRepository getFactRepository() {
        return this.factRepository;
    }
}