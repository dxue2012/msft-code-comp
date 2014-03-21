import java.io.File;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.lang.StringBuilder;
public class TextQueryMatch
{
    private static String createRegEx(String input)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("(.*\\s+|\\s*)");
        int length = input.length();
        for (int i = 0; i < length; i++)
        {
            char c = input.charAt(i);

            sb.append(Pattern.quote(Character.toString(c)));
            sb.append("\\s*");
        }
        sb.append(".*");
        return sb.toString();
    }
    public static void main(String args[]) throws Exception
    {
        String fileName = args[0];
        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        int count = sc.nextInt();
        sc.nextLine();
        boolean matches[] = new boolean[count];
        for (int i = 0; i < count; i++)
        {
            String pattern = sc.nextLine().toLowerCase();
           // System.out.println(pattern);

            pattern = createRegEx(pattern);

            String body = sc.nextLine().toLowerCase();
            if (Pattern.matches(pattern, body))
                matches[i] = true;
           // System.out.println(pattern);
           // System.out.println(body);
           // System.out.println(matches[i]);
           // System.out.println();
        }
        System.out.println(count);
        for (int i = 0; i < count; i++)
        {
            System.out.println(matches[i]);
        }
    }
}
