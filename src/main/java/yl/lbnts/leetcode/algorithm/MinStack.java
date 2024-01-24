package yl.lbnts.leetcode.algorithm;

import java.util.Arrays;

public class MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        System.out.println(minStack);
        System.out.println("MinStack Top Element: " + minStack.top());
        System.out.println("MinStack get Minimal Element val: " + minStack.getMin());

        minStack.pop();

        System.out.println(minStack);
        System.out.println("MinStack Top Element: " + minStack.top());
        System.out.println("MinStack get Minimal Element val: " + minStack.getMin());
    }

    protected Integer[] arr = new Integer[1];

    private static int elementCount = 0;

    public MinStack() {
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
        return "MinStack{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }
}
