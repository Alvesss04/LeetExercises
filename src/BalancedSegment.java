import java.util.Scanner;
import java.util.stream.Stream;

class BalancedSegment {

    static int solution(Integer[] A) {
        int max = 1;
        int currentSum = 1;
        int currentNumber = A[0];
        for (int i = 1; i < A.length; i++){
            if (currentNumber == A[i]) {
                currentSum++;
                max = Math.max(max,currentSum);
            }else{
                currentSum = 1;
                currentNumber = A[i];
            }
        }
        return max;
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