package expression;

public class Add extends AbstractBinaryOperation {
    public Add(CommonExpression firstExpression, CommonExpression secondExpression) {
        super(firstExpression, secondExpression);
    }

    @Override
    public int getLevel() {
        return 1;
    }

    @Override
    public String getSymbol() {
        return "+";
    }

    @Override
    public boolean getOrder() {
        return false;
    }

    public int function(int a, int b) {
        return a + b;
    }
}