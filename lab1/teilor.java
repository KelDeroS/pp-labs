import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class teilor {
    public static BigDecimal nextNum(BigDecimal x, int count)
    {
        BigDecimal num = x;
        for (int i = 0; i < count * 2; i++)
        {
            num = num.multiply(x);
        }
        if (count % 2 == 1)
        {
            num = num.negate();
        }
        num = num.divide(BigDecimal.valueOf(factorial(count * 2 + 1)), MathContext.DECIMAL128);
        return num;
    }

    public static long factorial(int num)
    {
        long fac = 1;
        for (int i = 2; i <= num; i++)
        {
            fac = fac * i;
        }
        return fac;
    }
}
