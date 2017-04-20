package com.maths;

import com.maths.eval.Expression;
import com.maths.eval.Operation;
import com.maths.eval.Operations;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by fchoi on 4/18/2017.
 */
public class Ten {
    public static void main(String[] args) {

        int target;
        if(args.length > 0)
            target = Integer.parseInt(args[0]);
        else
            target = (new Scanner(System.in)).nextInt();


        Expression<Double> expression;
        double value;
        long counter = 0;
        long totalCounter = 0;
        do {
            expression = genEx2();
            value = expression.evaluate().pop();

            counter++;
            totalCounter++;

            if (counter == 10000000) {
                System.out.println("Tried " + totalCounter + " expressions");
                counter = 0;
            }
        } while (Double.isNaN(value) || Double.isInfinite(value) || Math.abs(value - target) > 10e-8);
        System.out.println(expression);
        System.out.println(value);
    }

    // Unclean concatenation
    public static Expression<Double> genEx() {
        Expression<Double> expression = new Expression<>();
        int stackLen = 0;

        int element = 1;

        while(element < 10) {
            if(stackLen < 2) {
                switch((int)(Math.random() * 7)) {
                    case 0:
                        expression.addOperation(Operations.dPush(element++));
                        expression.addOperation(Operations.dCat());
                        break;
                    default:
                        expression.addOperation(Operations.dPush(element++));
                        stackLen++;
                }
            } else {
                switch ((int) (Math.random() * 7)) {
                    case 0:
                        expression.addOperation(Operations.dPush(element++));
                        stackLen++;
                        break;
                    case 1:
                        expression.addOperation(Operations.dPush(element++));
                        expression.addOperation(Operations.dCat());
                        break;
                    case 2:
                        expression.addOperation(Operations.dAdd());
                        stackLen--;
                        break;
                    case 3:
                        expression.addOperation(Operations.dMul());
                        stackLen--;
                        break;
                    case 4:
                        expression.addOperation(Operations.dSub());
                        stackLen--;
                        break;
                    case 5:
                        expression.addOperation(Operations.dDiv());
                        stackLen--;
                        break;
                    case 6:
                        expression.addOperation(Operations.dExp());
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

    // Clean concatenation
    public static Expression<Double> genEx2() {
        Expression<Double> expression = new Expression<>();
        int stackLen = 0;
        boolean canCatClean = false;

        int element = 1;

        while(element < 10) {
            if(stackLen < 2) {
                if(canCatClean) {
                    switch((int)(Math.random() * 7)) {
                        case 0:
                            expression.addOperation(Operations.dPush(element++));
                            expression.addOperation(Operations.dCat());
                            canCatClean = true;
                            break;
                        default:
                            expression.addOperation(Operations.dPush(element++));
                            stackLen++;
                            canCatClean = true;
                    }
                } else {
                    expression.addOperation(Operations.dPush(element++));
                    stackLen++;
                    canCatClean = true;
                }
            } else {
                if(canCatClean) {
                    switch ((int) (Math.random() * 7)) {
                        case 0:
                            expression.addOperation(Operations.dPush(element++));
                            stackLen++;
                            canCatClean = true;
                            break;
                        case 1:
                            expression.addOperation(Operations.dPush(element++));
                            expression.addOperation(Operations.dCat());
                            canCatClean = true;
                            break;
                        case 2:
                            expression.addOperation(Operations.dAdd());
                            stackLen--;
                            canCatClean = false;
                            break;
                        case 3:
                            expression.addOperation(Operations.dMul());
                            stackLen--;
                            canCatClean = false;
                            break;
                        case 4:
                            expression.addOperation(Operations.dSub());
                            stackLen--;
                            canCatClean = false;
                            break;
                        case 5:
                            expression.addOperation(Operations.dDiv());
                            stackLen--;
                            canCatClean = false;
                            break;
                        case 6:
                            expression.addOperation(Operations.dExp());
                            stackLen--;
                            canCatClean = false;
                            break;
                    }
                } else {
                    switch ((int) (Math.random() * 5)) {
                        case 0:
                            expression.addOperation(Operations.dPush(element++));
                            stackLen++;
                            canCatClean = true;
                            break;
                        case 1:
                            expression.addOperation(Operations.dAdd());
                            stackLen--;
                            canCatClean = false;
                            break;
                        case 2:
                            expression.addOperation(Operations.dMul());
                            stackLen--;
                            canCatClean = false;
                            break;
                        case 3:
                            expression.addOperation(Operations.dSub());
                            stackLen--;
                            canCatClean = false;
                            break;
                        case 4:
                            expression.addOperation(Operations.dDiv());
                            stackLen--;
                            canCatClean = false;
                            break;
                        case 5:
                            expression.addOperation(Operations.dExp());
                            stackLen--;
                            canCatClean = false;
                            break;
                    }
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
