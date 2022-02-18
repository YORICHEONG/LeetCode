package byday.code_2022.code_01.day_09;

/**
 * @Description 按键持续时间最长的键
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2022/1/9 9:16
 * @Tags
 **/
public class SlowestKey {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int[] charValue = new int[26];
        int maxValue = 0;
        int maxCharIndex = 0;
        int maxCharOrder = 0;
        for (int i = 0; i < keysPressed.length(); i++) {
            int index = keysPressed.charAt(i) - 'a';
            if (i == 0) {
                charValue[index] = releaseTimes[i];
                if(charValue[index] > maxValue) {
                    maxValue = charValue[index];
                    maxCharIndex = i;
                    maxCharOrder = index;
                } else if(charValue[index] == maxValue) {
                    if(index > maxCharOrder) {
                        maxCharOrder = index;
                        maxCharIndex = i;
                    }
                }
            } else {
                int pressTime = releaseTimes[i] - releaseTimes[i-1];
                if(pressTime > charValue[index]) {
                    charValue[index] = pressTime;
                }
                if(charValue[index] > maxValue) {
                    maxValue = charValue[index];
                    maxCharIndex = i;
                    maxCharOrder = index;
                } else if(charValue[index] == maxValue) {
                    if(index > maxCharOrder) {
                        maxCharOrder = index;
                        maxCharIndex = i;
                    }
                }
            }
        }
        return (char) ('a' + maxCharOrder);
    }

    public static void main(String[] args) {

    }
}
