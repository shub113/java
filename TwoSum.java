import java.util.*;

// Example of dynymic array
class TowSum {
    public int[] solutionSquareN(int[] arr, int target) {

        for (int i = 0; i < arr.length - 1; i++) {
            int findNum = target - arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] == findNum) {
                    return new int[] {
                            i,
                            j
                    };
                }
            }
        }
        return new int[] {
                -1, -1
        };
    }

    public int[] solutionN(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int diff = target - arr[i];
            if (map.containsKey(diff)) {
                return new int[] {
                        map.get(diff), i
                };
            }
            map.put(arr[i], i);
        }
        return new int[] {
                -1, -1
        };
    }

    public static void main(String[] args) throws java.lang.Exception {
        TowSum ts = new TowSum();
        int[] ans = ts.solutionSquareN(new int[] {
                4,
                6,
                8,
                5,
                9,
                3
        }, 9);
        int[] ans2 = ts.solutionN(new int[] {
                4,
                6,
                8,
                5,
                9,
                3
        }, 9);
        for (int i : ans) {
            System.out.println(i);
        }
        for (int i : ans2) {
            System.out.println(i);
        }
    }
}