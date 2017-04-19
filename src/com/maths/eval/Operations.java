package com.maths.eval;

import java.util.Stack;

/**
 * Created by fchoi on 4/18/2017.
 */
public class Operations {
    public static Operation<Double> dAdd() {
        return new Operation<Double>() {
            @Override
            public void exec(Stack<Double> stack) {
                stack.push(stack.pop() + stack.pop());
            }

            @Override
            public String toString() {
                return "+";
            }
        };
    }

    public static Operation<Double> dMul() {
        return new Operation<Double>() {
            @Override
            public void exec(Stack<Double> stack) {
                stack.push(stack.pop() * stack.pop());
            }

            @Override
            public String toString() {
                return "*";
            }
        };
    }

    public static Operation<Double> dSub() {
        return new Operation<Double>() {
            @Override
            public void exec(Stack<Double> stack) {
                stack.push(- stack.pop() + stack.pop());
            }

            @Override
            public String toString() {
                return "-";
            }
        };
    }

    public static Operation<Double> dDiv() {
        return new Operation<Double>() {
            @Override
            public void exec(Stack<Double> stack) {
                stack.push(1 / stack.pop() * stack.pop());
            }

            @Override
            public String toString() {
                return "/";
            }
        };
    }

    public static Operation<Double> dExp() {
        return new Operation<Double>() {
            @Override
            public void exec(Stack<Double> stack) {
                double b = stack.pop();
                double a = stack.pop();
                stack.push(Math.pow(a, b));
            }

            @Override
            public String toString() {
                return "^";
            }
        };
    }

    public static Operation<Double> dCat() {
        return new Operation<Double>() {
            @Override
            public void exec(Stack<Double> stack) {
                stack.push(stack.pop() + stack.pop() * 10);
            }

            @Override
            public String toString() {
                return "||";
            }
        };
    }

    public static Operation<Double> dPush(final double value) {
        return new Operation<Double>() {
            @Override
            public void exec(Stack<Double> stack) {
                stack.push(value);
            }

            @Override
            public String toString() {
                return String.valueOf(value);
            }
        };
    }
}
