package yl.lbnts.leetcode.algorithm;

import java.util.Stack;

public class MinStack {

    public static void main(String[] args) {
        MinStack minStackk = new MinStack();

        minStackk.push(512);
        minStackk.push(-1024);
        minStackk.push(-1024);
        minStackk.push(512);

        System.out.println(minStackk);
        System.out.println("MyStack Top Element: " + minStackk.top());
        System.out.println("MyStack get Minimal Element val: " + minStackk.getMin());

        minStackk.pop();

        System.out.println(minStackk);
        System.out.println("MyStack Top Element: " + minStackk.top());
        System.out.println("MyStack get Minimal Element val: " + minStackk.getMin());

        minStackk.pop();

        System.out.println(minStackk);
        System.out.println("MyStack Top Element: " + minStackk.top());
        System.out.println("MyStack get Minimal Element val: " + minStackk.getMin());

        minStackk.pop();

        System.out.println(minStackk);
        System.out.println("MyStack Top Element: " + minStackk.top());
        System.out.println("MyStack get Minimal Element val: " + minStackk.getMin());

    }

    Stack<Integer> commonStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    private static Integer min = Integer.MAX_VALUE;

    public MinStack() {

    }

    public void push(int val) {
        commonStack.push(val);

        if (minStack.empty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        final int currentVal = commonStack.peek();
        commonStack.pop();

        if (minStack.peek().equals(currentVal)) {
            minStack.pop();
        }
    }

    public int top() {
        return commonStack.peek();
    }

    public int getMin() {
        if (minStack.empty()) {
            return 0;
        } else
            return minStack.peek();
    }

    @Override
    public String toString() {
        return "MinStack{" +
                "commonStack=" + commonStack +
                ", minStack=" + minStack +
                '}';
    }
}
