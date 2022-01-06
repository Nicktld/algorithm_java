package com.calculator;

import java.util.ArrayDeque;
import java.util.Deque;

public class Calculator_Recursion implements Calculator {

    class EvalRs {
        int val, idx;
        EvalRs(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
    @Override
    public int calculate(String exp) {
        return helper(exp, 0).val;
    }

    EvalRs helper(String exp, int start) {
        Deque<Integer> stack = new ArrayDeque<>();
        int num = 0;
        char prevOps = '+';
        for(int i = start; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if(Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                update(stack, num, prevOps);
                prevOps = c;
                num = 0;
            } else if (c == '(') {
                EvalRs rs = helper(exp, i + 1);
                num = rs.val;
                i = rs.idx;
            } else if (c == ')') {
                update(stack, num, prevOps);
                return new EvalRs(getSum(stack), i);
            }
        }
        update(stack, num, prevOps);
        return new EvalRs(getSum(stack), exp.length());
    }

    private void update(Deque<Integer> stack, int num, char prevOps) {
        switch (prevOps) {
            case '+':
                stack.push(num);
                break;
            case '-':
                stack.push(-num);
                break;
            case '*':
                stack.push(stack.pop() * num);
                break;
            case '/':
                stack.push(stack.pop() / num);
                break;
        }
    }

    private int getSum(Deque<Integer> stack) {
        int sum = 0;
        while(!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
