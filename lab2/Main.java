import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int sizeX = scanner.nextInt(), sizeY = scanner.nextInt();

        int matrix[][] = new int[sizeX][sizeY];
        Random rand = new Random();

        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                matrix[i][j] = rand.nextInt(50);
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        int diagSize = Math.min(sizeX, sizeY);
        boolean symmetric = true;
        for (int i = 1; i < diagSize; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (!(matrix[i][j] == matrix[j][i]))
                {
                    symmetric = false;
                    break;
                }
            }
            if (symmetric == false)
            {
                break;
            }
        }
        if (symmetric == false)
        {
            System.out.println("Not symmetric");
        }
        else
        {
            System.out.println("Is symmetric");
        }

        int crossElement = -1;
        for (int i = 0; i < sizeX; i++)
        {
            if (i == sizeY - 1 - i)
            {
                crossElement = i;
            }
        }
        if (crossElement == -1)
        {
            System.out.println("No intersection");
            return;
        }

        int max = matrix[0][0], maxIDx = 0, maxIDy = 0;
        for (int i = 1; i < diagSize; i++)
        {
            if (max < matrix[i][i])
            {
                max = matrix[i][i];
                maxIDx = maxIDy = i;
            }
        }
        for (int i = 0; i < diagSize; i++)
        {
            if (max < matrix[i][sizeY - i - 1])
            {
                max = matrix[i][sizeY - i - 1];
                maxIDx = i;
                maxIDy = sizeY - i - 1;
            }
        }

        int tmp = matrix[crossElement][crossElement];
        matrix[crossElement][crossElement] = max;
        matrix[maxIDx][maxIDy] = tmp;

        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}