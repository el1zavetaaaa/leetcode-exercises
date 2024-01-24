package yl.lbnts.leetcode.algorithm;

import java.util.Arrays;

public class MyStack {

    public static void main(String[] args) {
        MyStack myStack = new MyStack();

        myStack.push(-2);
        myStack.push(0);
        myStack.push(-3);

        System.out.println(myStack);
        System.out.println("MyStack Top Element: " + myStack.top());
        System.out.println("MyStack get Minimal Element val: " + myStack.getMin());

        myStack.pop();

        System.out.println(myStack);
        System.out.println("MyStack Top Element: " + myStack.top());
        System.out.println("MyStack get Minimal Element val: " + myStack.getMin());
    }

    protected Integer[] arr = new Integer[1];

    private static int elementCount = 0;

    public MyStack() {
    }

    public void push(int val) {
        add(val, arr, elementCount);
    }

    private void add(final int val, Integer[] arr, final int index) {
        if (index == arr.length) {
            arr = grow();
        }
        arr[index] = val;
        elementCount = index + 1;
    }

    private Integer[] grow() {
        return grow(elementCount + 1);
    }

    private Integer[] grow(final int newCapacity) {
        return arr = Arrays.copyOf(arr, newCapacity);
    }


    public void pop() {
        Integer[] newArr = new Integer[arr.length - 1];

        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
        elementCount--;
    }

    public int top() {
        return arr[arr.length - 1];
    }

    public int getMin() {
        int min = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        return min;

    }

    @Override
    public String toString() {
        return "MyStack{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }
}
