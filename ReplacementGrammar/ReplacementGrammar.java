import java.io.File;
import java.util.Scanner;

public class ReplacementGrammar
{
    public static void main(String[] args) throws Exception
    {
        // parse input
        Scanner temp = new Scanner(new File(args[0]));
        int lineCount = 0;
        String curr = "";
        while (temp.hasNextLine())
        {
            curr = temp.nextLine();
            if (curr.length() == 0)
                break;
            else
                lineCount++;
        }

        int N = lineCount;

        Scanner in = new Scanner(new File(args[0]));
        String[] toBeReplaced = new String[N];
        String[] replacement = new String[N];

        for (int i = 0; i < N; i++)
        {
            String currString = in.nextLine();
            String[] splited = currString.split("\\|");
            toBeReplaced[i] = splited[0];
            if (splited.length == 2)
                replacement[i] = splited[1];
            else
                replacement[i] = "";
        }

        while (in.hasNextLine())
        {
            curr = in.nextLine();
            if (!curr.equals(""))
                break;
        }

        String message = curr;
        for (int i = 0; i < N; i++)
        {
            message = message.replace(toBeReplaced[i], replacement[i]);
        }

        System.out.println(message);
    }
}
