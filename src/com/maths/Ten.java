package com.maths;

import com.maths.eval.Expression;
import com.maths.eval.Operation;
import com.maths.eval.Operations;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by fchoi on 4/18/2017.
 */
public class Ten {
    public static void main(String[] args) {
        Stack<Double> elements = new Stack<>();

        for(double i = 1; i < 10; i += 1) {
            elements.add(0, i);
        }

        Expression<Double> expression = genEx((Stack<Double>) elements.clone());

        System.out.println(expression);
        System.out.println(expression.evaluate().pop());
    }

    public static Expression<Double> genEx(Stack<Double> elements) {
        Expression<Double> expression = new Expression<>();
        int stackLen = 0;
        while(!elements.empty()) {
            if(stackLen < 2) {
                expression.addOperation(Operations.dPush(elements.pop()));
                stackLen++;
            } else {
                switch((int)(Math.random() * 5)) {
                    case 0:
                        expression.addOperation(Operations.dPush(elements.pop()));
                        stackLen++;
                        break;
                    case 1:
                        expression.addOperation(Operations.dAdd());
                        stackLen--;
                        break;
                    case 2:
                        expression.addOperation(Operations.dMul());
                        stackLen--;
                        break;
                    case 3:
                        expression.addOperation(Operations.dSub());
                        stackLen--;
                        break;
                    case 4:
                        expression.addOperation(Operations.dDiv());
                        stackLen--;
                        break;
                }
            }
        }
        while(stackLen > 1) {
            switch((int)(Math.random() * 4)) {
                case 0:
                    expression.addOperation(Operations.dAdd());
                    stackLen--;
                    break;
                case 1:
                    expression.addOperation(Operations.dMul());
                    stackLen--;
                    break;
                case 2:
                    expression.addOperation(Operations.dSub());
                    stackLen--;
                    break;
                case 3:
                    expression.addOperation(Operations.dDiv());
                    stackLen--;
                    break;
            }
        }
        return expression;
    }
}
