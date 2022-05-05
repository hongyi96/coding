package test;

import cn.hutool.core.util.RandomUtil;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class InviteTest {
    public static String GetInvitationCode() {


        //自定义进制，长度为34。  0和1与o和l容易混淆，不包含在进制中。

        char[] r = new char[]{'Q', 'w', 'E', '8', 'a', 'S', '2', 'd', 'Z', 'x', '9', 'c', '7', 'p', 'O', '5', 'i', 'K', '3', 'm', 'j', 'U', 'f', 'r', '4', 'V', 'y', 'L', 't', 'N', '6', 'b', 'g', 'H'};

        char[] b = new char[]{'q', 'W', 'e', '5', 'A', 's', '3', 'D', 'z', 'X', '8', 'C', '2', 'P', 'o', '4', 'I', 'k', '9', 'M', 'J', 'u', 'F', 'R', '6', 'v', 'Y', 'T', 'n', '7', 'B', 'G', 'h'};

        char[] buf = new char[33];
        //生成5位的邀请码
        int s = 5;
        int binLen = r.length;

        int charPos = 33;

        //以当前的毫秒数作为标准
        int id = (int) System.currentTimeMillis() / 1000;

        while (id / binLen > 0) {
            int k = (int) (id % binLen);
            buf[--charPos] = r[k];
            id /= binLen;
        }

        buf[--charPos] = r[(int) (id % binLen)];

        String str = new String(buf, charPos, (33 - charPos));

        //长度不够5位时自动随机补全
        if (str.length() < s) {

            StringBuilder sb = new StringBuilder();
            Random rd = new Random();
            for (int i = 1; i <= s - str.length(); i++) {
                sb.append(b[rd.nextInt(33)]);
            }
            str += sb.toString();
        }
        return str.toUpperCase();

    }


    public static String test() {
        return RandomUtil.randomString(5);

    }

    public static void main(String[] args) {
        Set<String> strings = new HashSet<String>();
        for (int i = 0; i < 10000; i++) {
            strings.add(test());
        }
        System.out.println(strings);
        System.out.println(strings.size());
    }
}
