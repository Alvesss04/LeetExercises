class Solution {
    public static int solution(int[] chapters, int[] evenings) {
        int currEvening = -1;
        int remainTime = 0;

        for (int chapter : chapters){
            while (chapter > remainTime){
                currEvening++;
                if (currEvening == evenings.length) return -1;
                remainTime = evenings[currEvening];
            }
            remainTime -= chapter;
        }
        return currEvening + 1;
    }
}