import java.util.Scanner;
import java.io.File;

public class Ndrome
{
    public static void main(String[] args) throws Exception {
        int n;
        String s;
        int size;
        Scanner in = new Scanner(new File(args[0]));
        while (in.hasNextLine())
        {
            int count = 0;
            String currString = in.nextLine();
            System.out.print(currString + "|");
            String[] splited = currString.split("\\|");
            s = splited[0];

            n = Integer.parseInt(splited[1]);

            size = s.length() / n;
            String[] palindrome = new String[size];

            for (int i = 0; i < palindrome.length; i++)
                palindrome[i] = "";

            for (int i = 0; i < s.length(); i++) {
                palindrome[i/n] += Character.toString(s.charAt(i));
            }

            for (int j = 0; j <= size/2; j++)
            {
                if (palindrome[j].equals(palindrome[size-1-j]))
                    count++;
            }

            if (count == size/2+1)
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}
