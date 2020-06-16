package trabajo.fin.grado.util;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import trabajo.fin.grado.TestCase;

public class PredicateEvaluator {
    private ExpressionParser expressionParser=new SpelExpressionParser();
    public boolean evaluate(TestCase testCase) throws IllegalArgumentException {
        boolean result = false;
        Expression exp = expressionParser.parseExpression(testCase.getPredicate().toString());
        EvaluationContext context = new StandardEvaluationContext(testCase);
        Object assertionResult = exp.getValue(context);
        if (assertionResult instanceof Boolean) {
            result = (Boolean) assertionResult;
        } else {
            throw new IllegalArgumentException("The assertion '" + testCase.getPredicate() + "' is not a valid, since its evaluation does not return a boolean result");

        }
        return result;
    }

    public boolean evaluate(String clause, TestCase testCase) throws IllegalArgumentException {
        boolean result = false;
        Expression exp = expressionParser.parseExpression(clause);
        EvaluationContext context = new StandardEvaluationContext(testCase);
        Object assertionResult = exp.getValue(context);
        if (assertionResult instanceof Boolean) {
            result = (Boolean) assertionResult;
        } else {
            throw new IllegalArgumentException("The assertion '" + testCase.getPredicate() + "' is not a valid, since its evaluation does not return a boolean result");
        }
        return result;
    }
}
