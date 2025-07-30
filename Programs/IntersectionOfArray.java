import java.util.*;

class IntersectionOfArray {

    // Space -> O(n+min(n,m))
    // Time -> O(n+m)
    public static Set<Integer> intersection(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> result = new HashSet<>();

        for (int i : arr1) {
            set.add(i);
        }
        for (int i : arr2) {
            if (set.contains(i)) {
                result.add(i);
            }
        }
        return result;
    }

    // Space -> O(0)
    // Time -> O(n^2)
    public static void intersection2(int[] arr1, int[] arr2) {
        Arrays.sort(arr1); // O(n logn)
        Arrays.sort(arr2); // O(m logm)

        int i = 0, j = 0;
        Integer lastAdded = null;

        while (i < arr1.length && j < arr2.length) {
            Integer value = arr1[i]; // direct int and null can't be compared
            if (arr1[i] == arr2[j] && value != lastAdded) {
                System.out.print(arr1[i] + ", ");
                lastAdded = arr1[i];
                i++;
                j++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            } else {
                i++;
            }
        }

    }

    public static void main(String[] args) throws java.lang.Exception {
        System.out.println(intersection(new int[] {
                1,
                3,
                4,
                6,
                8
        }, new int[] {
                3,
                5,
                9,
                4,
                7
        }));
        intersection2(new int[] {
                1,
                3,
                4,
                6,
                8
        }, new int[] {
                3,
                5,
                9,
                4,
                7
        });

    }
}