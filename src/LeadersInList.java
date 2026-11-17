import java.util.Scanner;
import java.util.stream.Stream;

class LeadersInList {

    static int solution(Integer[] A) {
        int max =Integer.MIN_VALUE;
        int leaders = 0;
        for (int i = A.length-1; i >= 0;i-- ){
            if (A[i] > max){
                max = A[i];
                leaders++;
            }
        }
        return leaders;
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