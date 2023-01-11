import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Main {

    public static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }


    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        BigDecimal x;
        int k;
        String s = scanner.next();
        while (!isDouble(s))
        {
            System.out.println("Input double value");
            s = scanner.next();
        }
        x = BigDecimal.valueOf(Double.parseDouble(s));
        s = scanner.next();
        while (!isInteger(s))
        {
            System.out.println("Input integer value");
            s = scanner.next();
        }
        k = Integer.parseInt(s);

        double E = Math.pow(10, -k);

        int i = 1;
        BigDecimal nextNumber = teilor.nextNum(x, i), sum = x;

        if (k > 100)
        {
            System.out.println("k out of range");
            return;
        }
        if (k < -3)
        {
            System.out.println("k out of range");
            return;
        }

        while (Math.abs(Double.parseDouble(String.valueOf(nextNumber))) >= E)
        {
            sum = sum.add(nextNumber);
            i++;
            nextNumber = teilor.nextNum(x, i);
        }
        System.out.println(sum.setScale(3, RoundingMode.HALF_UP));
        System.out.println(BigDecimal.valueOf(Math.sin(Double.parseDouble(String.valueOf(x)))).setScale(3, RoundingMode.HALF_UP));
    }
}