class DoublyEndedQueue {

    // Time -> O(n)
    // Space -> O(n) for storing data
    private static class Node {

        int data;
        Node next;
        Node prev;

        public Node(int value) {
            data = value;
        }
    }

    Node front;
    Node rear;
    int size;

    public void pushToFront(int value) {
        Node node = new Node(value);
        if (front == null) {
            front = rear = node;
            node.next = node.prev = node;
        } else {
            node.next = front;
            node.prev = rear;
            front.prev = node;
            rear.next = node;
            front = node;
        }
        size++;
    }

    public void pushToRear(int value) {
        Node node = new Node(value);
        if (rear == null) {
            front = rear = node;
        } else {
            node.prev = rear;
            node.next = front;
            front.prev = node;
            rear.next = node;
            rear = node;
        }
        size++;
    }

    public void popFromFront() {
        if (front == null) {
            return;
        } else {
            front.next.prev = rear;
            front = front.next;
            rear.next = front;
        }
        size--;
    }

    public void popFromRear() {
        if (rear == null) {
            return;
        } else {
            rear.prev.next = front;
            rear = rear.prev;
            front.prev = rear;
        }
        size--;
    }

    public int getSize() {
        return this.size;
    }

    // Time -> O(n)
    // Space -> O(1) since we are not using any extra space
    public String toString() {
        String str = new String();
        Node node = front;
        while (node.next != front) {
            str = str + ", " + node.data;
            node = node.next;
        }
        str = str + ", " + node.data + " | SIZE - " + getSize();
        return str;
    }

    public static void main(String[] args) throws java.lang.Exception {
        DoublyEndedQueue dq = new DoublyEndedQueue();
        dq.pushToFront(3);
        dq.pushToFront(2);
        dq.pushToRear(7);
        dq.pushToRear(9);
        dq.pushToFront(1);
        dq.pushToRear(19);

        System.out.println(dq);
        dq.popFromRear();
        dq.popFromFront();
        System.out.println(dq);

    }
}