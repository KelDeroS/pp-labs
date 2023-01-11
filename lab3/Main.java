import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main
{
    public static String swap(String word)
    {
        char[] cword = word.toCharArray();
        char t = cword[0];

        cword[0] = cword[cword.length - 1];
        cword[cword.length - 1] = t;

        return String.valueOf(cword);
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String line;
        line = scanner.nextLine();
        ArrayList<String> array = new ArrayList<>();
        while (line != "")
        {
            String tmp = "", newLine = "";
            char[] cline = line.toCharArray();
            for (int i = 0; i < line.length(); i++)
            {
                if (cline[i] != ' ' && cline[i] != ',' && cline[i] != '.')
                {
                    tmp += cline[i];
                }
                else
                {
                    //System.out.println(tmp);
                    if (tmp != "")
                    {
                        newLine += swap(tmp);
                    }
                    newLine += cline[i];
                    tmp = "";
                }
            }
            if (tmp != "")
            {
                newLine += swap(tmp);
            }
            array.add(newLine);
            line = scanner.nextLine();
        }

        for (int i = 0; i < array.size(); i++)
        {
            System.out.println(array.get(i));
        }
    }
}