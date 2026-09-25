import java.util.LinkedList;

public class prob10 {

    public int smallestIndex(int[] nums) {
        int index = nums.length;
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            int count = 0;
            while(num > 0){
                count += (num%10);
                num /= 10;
            }
            if (count == i) return i;
        }
        return -1;
    }

}
