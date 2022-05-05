package test;

import java.math.BigDecimal;

public class Score {
    public static void main(String[] args) {
        int b = 0;
        int c = 1;
        int e = 0;
        int d = 0;
        //感染分
        int p = 0;

        // 综合分数 (c / (b + 1) + (d + e) / (c + 1)) * 100 + (15 / (b + 1)) ^ 3 - p
        BigDecimal score =
                new BigDecimal(100)
                        .multiply(new BigDecimal(c).divide(new BigDecimal(b + 1))
                                .add(new BigDecimal(d + e).divide(new BigDecimal(c + 1))))
                        .add(new BigDecimal(15).divide(new BigDecimal(b + 1)).pow(3))
                        .subtract(new BigDecimal(p));
        System.out.println(score);
    }
}
