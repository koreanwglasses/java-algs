package com.maths.eval;

import java.util.Stack;

/**
 * Created by fchoi on 4/18/2017.
 */
public class Expression<T> {
    private Stack<Operation<T>> expression;

    public Expression () {
        expression = new Stack<>();
    }

    public void addOperation(Operation<T> operation) {
        expression.add(0, operation);
    }

    public Stack<Operation<T>> getExpressionStackCopy() {
        return (Stack<Operation<T>>) expression.clone();
    }

    public Stack<T> evaluate() {
        Stack<Operation<T>> expressionStack = getExpressionStackCopy();
        Stack<T> stack = new Stack<>();

        while(!expressionStack.empty()) {
            expressionStack.pop().exec(stack);
        }

        return stack;
    }

    @Override
    public String toString() {
        String result = "";
        for(int i = expression.size() - 1; i >= 0; i--) {
            result += expression.get(i).toString() + " ";
        }
        return result;
    }
}
