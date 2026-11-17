import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

class Tracks{

    static int solution(Integer[] A) {
        List<Integer> rows = new ArrayList<>();
        for (int h : A) {
            int best = -1;
            for (int r = 0; r < rows.size(); r++)
                if (rows.get(r) <= h && (best == -1 || rows.get(r) > rows.get(best)))
                    best = r;
            if (best == -1) rows.add(h);
            else rows.set(best, h);
        }
        return rows.size();
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
