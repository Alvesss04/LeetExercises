
import java.util.Scanner;
import java.util.stream.Stream;

class BestTrade {

    static int solution(Integer[] A) {
        int maxProfit = Integer.MIN_VALUE;
        int minValueSeen = Integer.MAX_VALUE;
        for (int i = 0 ; i < A.length; i++){
          maxProfit = Math.max(maxProfit,A[i] - minValueSeen);
          minValueSeen = Math.min(minValueSeen,A[i]);
        }
        return maxProfit;
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