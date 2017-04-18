package com.maths.eval;

import java.util.Stack;

/**
 * Created by fchoi on 4/18/2017.
 */
public interface Operation<T> {
    void exec(Stack<T> stack);
}
