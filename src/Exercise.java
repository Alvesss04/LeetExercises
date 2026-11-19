import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<Integer> solution(List<Integer> A) {
        ArrayList<Integer> answer = new ArrayList<>();
        int pass = 0;
        int passedHonor = 0;
        int failed = 0;

        if (A == null){
            answer.add(0);
            answer.add(0);
            answer.add(0);
            return answer;
        }

        for (Integer score : A){
            if (score == null) continue;
            if (score > 80) passedHonor ++;
            else if (score < 50) failed ++;
            else pass++;
        }
        answer.add(failed);
        answer.add(pass);
        answer.add(passedHonor);

        return answer;
    }
}
