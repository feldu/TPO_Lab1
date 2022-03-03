package tpo.lab1.function;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

import static java.lang.Math.PI;

public class Sec implements Calculable {
    @Override
    public BigDecimal calculate(double x) {
        if ((x % (PI / 2) == 0 || x % ((3 * PI) / 2) == 0) && x % PI != 0) return null;

        BigDecimal cos = new BigDecimal(0);
        for (int n = 0; n < 100; n++) {
            cos = cos.add(new BigDecimal(-1)
                    .pow(n)
                    .multiply(new BigDecimal(x).pow(2 * n))
                    .divide(new BigDecimal(calculateFactorial(2 * n)), 1000, RoundingMode.HALF_UP));
        }
        return BigDecimal.ONE.divide(cos, 16, RoundingMode.HALF_UP);
    }

    private BigInteger calculateFactorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++)
            result = result.multiply(BigInteger.valueOf(i));
        return result;
    }
}
