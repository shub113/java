import java.util.*;

class StackInsertAtBottom {

    // Time -> O(n)
    // Space -> O(n) for the recursion stack
    public static Stack<Integer> insert(Stack<Integer> stack, int num) {
        if (stack.isEmpty()) {
            stack.push(num);
        } else {
            int popedNum = stack.pop();
            insert(stack, num);
            stack.push(popedNum);
        }
        return stack;
    }

    public static void main(String[] args) throws java.lang.Exception {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(7);
        stack.push(1);
        stack.push(3);

        insert(stack, 9);

        System.out.println(stack);

    }
}