package com.maths.eval;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by fchoi on 4/18/2017.
 */
public class Expression<T> {
    private ArrayList<Operation<T>> expression;

    public Expression () {
        expression = new ArrayList<>();
    }

    public void addOperation(Operation<T> operation) {
        expression.add(operation);
    }

    public Stack<T> evaluate() {
        Stack<T> stack = new Stack<>();

        for(int i = 0; i < expression.size(); i++){
            expression.get(i).exec(stack);
        }

        return stack;
    }

    @Override
    public String toString() {
        String result = "";
        for(int i = 0; i < expression.size(); i++) {
            result += expression.get(i).toString() + " ";
        }
        return result;
    }
}
