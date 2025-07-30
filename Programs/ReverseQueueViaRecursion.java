import java.util.*;

class ReverseQueueViaRecursion {
    // Time -> O(n) each element is qued once and dequeued once
    // Space -> O(n) for the recursion stack
    public static void reverse(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return;
        }

        // remove from rear
        int element = queue.poll();

        // reverse remaining queue
        reverse(queue);

        // add to front
        queue.offer(element);
    }

    public static void main(String[] args) throws java.lang.Exception {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);

        System.out.println("Original - " + queue);

        reverse(queue);

        System.out.println("Reversed - " + queue);

    }
}