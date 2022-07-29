/**
 * @Author hongyi
 * @Date 2022/7/29 15:50
 */

public class RomanToInteger {

    public int romanToInt(String s) {
        int result = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case 'I':
                    if (i + 1 < chars.length && (chars[i + 1] == 'V' || chars[i + 1] == 'X')) {
                        result -= 1;
                    } else {
                        result += 1;
                    }
                    break;

                case 'X':
                    if (i + 1 < chars.length && (chars[i + 1] == 'L' || chars[i + 1] == 'C')) {
                        result -= 10;
                    } else {
                        result += 10;
                    }
                    break;

                case 'C':
                    if (i + 1 < chars.length && (chars[i + 1] == 'D' || chars[i + 1] == 'M')) {
                        result -= 100;
                    } else {
                        result += 100;
                    }
                    break;

                case 'V':
                    result += 5;
                    break;

                case 'L':
                    result += 50;
                    break;

                case 'D':
                    result += 500;
                    break;

                case 'M':
                    result += 1000;
                    break;

                default:
                    break;
            }

        }
        return result;
    }


}
