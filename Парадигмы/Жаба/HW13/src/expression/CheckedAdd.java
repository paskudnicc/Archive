package expression;

import expression.exceptions.OverflowException;

public class CheckedAdd extends AbstractBinaryOperation {
    public CheckedAdd(CommonExpression firstExpression, CommonExpression secondExpression) {
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
    public boolean isAssociative() {
        return false;
    }

    private int max(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    private int min(int a, int b) {
        if (a < b) {
            return a;
        }
        return b;
    }

    public int oper(int a, int b) {
        int max = max(a, b);
        int min = min(a, b);
        if (((max > 0) && (Integer.MAX_VALUE - max < min)) || ((min < 0) && Integer.MIN_VALUE - min > max)) {
            throw new OverflowException("Adding overflow");
        }
        return a + b;
    }
}