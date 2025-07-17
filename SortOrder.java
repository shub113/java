
class SortOrder {

    public static int[] sortOrders(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        int index = 0;

        while (index <= j) {
            if (arr[index] == 0) {
                arr[index] = arr[i];
                arr[i] = 0;
                i++;
            } else if (arr[index] == 2) {
                arr[index] = arr[j];
                arr[j] = 2;
                j--;
            }
            index++;
        }
        return arr;

    }

    public static void main(String[] args) throws java.lang.Exception {
        int[] ans = sortOrders(new int[] {
                2,
                1,
                0,
                0,
                1,
                0,
                1,
                0,
                0,
                1
        });
        for (int i : ans) {
            System.out.println(i);
        }
    }
}