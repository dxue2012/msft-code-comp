import java.io.File;
import java.util.Scanner;

public class FollowDirections
{
    public static final int NORTH = 0;
    public static final int EAST  = 1;
    public static final int SOUTH = 2;
    public static final int WEST  = 3;

    public static void main(String[] args) throws Exception
    {
        int x = 0;
        int y = 0;
        int currDir = NORTH;

        Scanner in = new Scanner(new File(args[0]));

        while (in.hasNextLine())
        {
            String[] splited = in.nextLine().split(" ");
            if (splited[0].equals("Move"))
            {
                int dist = Integer.parseInt(splited[1]);
                if (currDir == NORTH)
                    y += dist;
                else if (currDir == SOUTH)
                    y -= dist;
                else if (currDir == EAST)
                    x += dist;
                else // if (currDir == WEST)
                    x -= dist;
            }
            else // if (splited[1].equals("Turn")
            {
                String dir = splited[1];
                if (dir.equals("right"))
                    currDir = (currDir + 1) % 4;
                else // if (dir.equals("left")
                    currDir = (currDir + 3) % 4;
            }
        }

        System.out.println(x + "," + y);
    }
}
