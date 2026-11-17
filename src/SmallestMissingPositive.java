import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.Stream;

    class SmallestMissingPositive {

        static int solution(Integer[] A) {
            HashSet<Integer> small = new HashSet<>(Arrays.asList(A));
            for (int i = 1; i < Integer.MAX_VALUE; i++){
                if (!small.contains(i)) return i;
            }
            return -1;
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

