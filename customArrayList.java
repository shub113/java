// Example of dynymic array
class CustomArrayList {
    private int[] list;
    private int currentIndex;
    private int size;

    public CustomArrayList(int size) {
        list = new int[size];
        currentIndex = 0;
        this.size = size;
    }

    public void insert(int element) {
        list[currentIndex] = element;
        currentIndex++;
        if (currentIndex == size) {
            int[] temp = new int[size * 2];
            for (int i = 0; i < currentIndex; i++) {
                temp[i] = list[i];
            }
            list = temp;
            size = size * 2;
        }

    }

    public int indexOf(int element) {
        // Linear Search
        for (int i = 0; i < currentIndex; i++) {
            if (list[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public void removeElement(int element) {
        int index = indexOf(element);

        if (index == -1) {
            throw new IllegalArgumentException("Element does not exists");
        }
        for (int i = index; i < currentIndex - 1; i++) {
            list[i] = list[i + 1];
        }
        list[currentIndex - 1] = 0;
        currentIndex = currentIndex - 1;
    }

    public String toString() {
        String str = new String();
        for (int i : list) {
            str = str + i + ", ";
        }
        return str;
    }

    public static void main(String[] args) throws java.lang.Exception {
        CustomArrayList list = new CustomArrayList(2);
        list.insert(5);
        System.out.println(list);

        list.insert(10);
        System.out.println(list);

        list.insert(12);
        System.out.println(list);

        list.insert(1);
        System.out.println(list);

        list.insert(40);
        System.out.println(list);

        list.insert(50);

        System.out.println(list);

        System.out.println("Index of 1 is " + list.indexOf(1));
        list.removeElement(1);
        System.out.println(list);
    }
}