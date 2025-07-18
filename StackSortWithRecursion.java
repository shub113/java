import java.util.*;

class SortStackWithRecursion {

    public static Stack<Integer> insertAtCorrectPosition(Stack<Integer> stack, int num) {
        if (stack.isEmpty() || num >= stack.peek()) {
            stack.push(num);
            return stack;
        }

        int popedElement = stack.pop();
        insertAtCorrectPosition(stack, num);
        stack.push(popedElement);
        return stack;
    }

    // Time -> O(n^2) since each sort calls insertAtCorrectPosition which takes O(n)
    // Space -> O(n) for the recursion stack
    public static Stack<Integer> sort(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return stack;
        }
        int popedElement = stack.pop();
        sort(stack);
        insertAtCorrectPosition(stack, popedElement);
        return stack;
    }

    public static void main(String[] args) throws java.lang.Exception {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(7);
        stack.push(1);
        stack.push(3);

        sort(stack);

        System.out.println(stack);

    }
}