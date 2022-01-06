package com.calculator;

import java.util.ArrayDeque;
import java.util.Deque;

public class Calculator_Unzip implements Calculator {
    @Override
    public int calculate(String exp) {
        Deque<Integer> sta = new ArrayDeque<>();
        int sign = 1;
        sta.push(sign);

        int num = 0, res = 0;
        for(char c : exp.toCharArray()) {
            if(Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '+' || c == '-') {
                res += num * sign;
                sign = sta.peek() * (c == '+' ? 1 : -1);
                num = 0;
            } else if (c == '(') {
                sta.push(sign);
            } else if (c == ')') {
                sta.pop();
            }
        }
        res += num * sign;
        return res;
    }
}
