import java.util.*;

class FirstNegativeInSlidingWindow {

    // Time -> O(arr.length)
    // Space -> O(k)
    // 1. process all number from 1st window and add to queue of negative indices
    // 2. loop from i=k to i<arr.length
    // inside loop print previous window's 1st negative number
    // check to remove according to current window i.e. queue.peek() <= i-k
    // add new element from current window only if it is
    // print 1st negative from queue again for the last window.
    public static void slidingWindow(int[] arr, int k) {
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < k; i++) {
            if (arr[i] < 0) {
                queue.offer(i);
            }
        }

        for (int i = k; i < arr.length; i++) {
            // print for previous window
            if (!queue.isEmpty()) {
                System.out.println(arr[queue.peek()]);
            } else {
                System.out.println(0);
            }

            if (!queue.isEmpty() && queue.peek() <= i - k) {
                queue.poll();
            }

            if (arr[i] < 0) {
                queue.offer(i);
            }
        }

        if (!queue.isEmpty()) {
            System.out.println(arr[queue.peek()]);
        } else {
            System.out.println(0);
        }

    }

    public static void main(String[] args) throws java.lang.Exception {
        slidingWindow(new int[] {
                12,
                -1,
                -7,
                8,
                -15,
                30,
                16,
                28
        }, 3);
    }
}