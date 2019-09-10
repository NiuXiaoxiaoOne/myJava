package queueandstackdemo.test;

import queueandstackdemo.ArrayStack;

/**
 * @author xiaolei
 */
public class TestArrayStack {
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        System.out.println(stack.pop());
        stack.pop();
        System.out.println(stack.peek());
        System.out.println(stack);
    }
}
