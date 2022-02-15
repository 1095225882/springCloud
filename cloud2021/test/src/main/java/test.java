import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class test {
    public static void main(String[] args) {

    }

    /**
     * 冒泡排序
     */

    public void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[i] > nums[j]) {
                    int t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}


/**
 * 静态内部类
 */
class Sig {
    private Sig() {
    }

    private static class SigHolder {
        private static final Sig INSTANCE = new Sig();
    }

    public Sig getInstance() {
        return SigHolder.INSTANCE;
    }
}