import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

class Jumps {

    static int solution(Integer[] A) {
        int[] arr = new int[A.length];
        Arrays.fill(arr, Integer.MAX_VALUE);
        for (int index = 0 ; index < A.length; index++){
            arr[index+A[index]] = Math.min(arr[index+A[index]], arr[index]+1);
        }
        return arr[arr.length-1];
    }

    public static void main(String[] args) {
        // Read from stdin, solve the problem, write answer to stdout.
        Scanner in = new Scanner(System.in);
        Integer[] A = getIntegerArray(in.next());

        System.out.print(solution(A));
    }

    private static Integer[] getIntegerArray(String str) {
        return Stream.of(str.split("\\,"))
                .map(Integer::valueOf)
                .toArray(Integer[]::new);
    }
}
