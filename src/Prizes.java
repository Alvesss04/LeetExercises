import java.util.Scanner;
import java.util.stream.Stream;

class Prizes {

    static int solution(Integer[] A) {
        int total = 1;
        int prev = A[0];
        for (int i = 1 ; i < A.length; i++){
            if (A[i] != prev) total ++;
            total++;
        }
        return total;
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
