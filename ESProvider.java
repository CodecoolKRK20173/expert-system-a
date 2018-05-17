import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ESProvider {

    private final String CLEARSCREEN = "\033[H\033[2J";
    private FactParser factParser;
    private RuleParser ruleParser;
    private Map<String, Boolean> questionAnswers;

    public ESProvider(FactParser factParser, RuleParser ruleParser) {
        this.factParser = factParser;
        this.ruleParser = ruleParser;
    }

    public void runApplication() {
        
        System.out.println(CLEARSCREEN);
        collectAnswer();
        this.factParser.parseFacts();
        String userWeapon = evaluate();
        UserUI.displayMessage(userWeapon);
    }

    public void collectAnswer() {

        ruleParser.getRuleRepository();
        Iterator<Question> questionIterator = ruleParser.getRuleRepository().getIterator();

        questionAnswers = new HashMap<String, Boolean>();
        Question question;
        String input;

        while (questionIterator.hasNext()) {
            question = questionIterator.next();
            System.out.println(question.getQuestion());
            input = UserUI.getUserInput();
            questionAnswers.put(question.getId(), question.getEvaluatedAnswer(input));
        }
    }

    private boolean getAnswerByQuestion(String questionID) { // Unnecessary method
        return questionAnswers.get(questionID);
    }

    public String evaluate() {

        Iterator<Fact> factIterator = factParser.getFactRepository().getIterator();
        while (factIterator.hasNext()) {
            Fact fact = factIterator.next();
            if (fact.getValues().equals(questionAnswers)) {
                return fact.getDescription();
            }
        }
        return null;
    }

}