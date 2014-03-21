import java.io.File;
import java.util.Scanner;
public class ClockAngles
{
    private static double roundAngles(double angle)
    {
        double abs = Math.abs(angle);
        if (abs > 180.0)
            abs = 360.0 - abs;
        return abs;
    }

    public static void main(String args[]) throws Exception
    {
        String fileName = args[0];
        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        int count = sc.nextInt();
        sc.nextLine();
        double[][] angles = new double[count][3];
        for (int i = 0; i < count; i++)
        {
            String input = sc.nextLine();
            String[] data = input.split(":");
            int hours = Integer.parseInt(data[0]);
            int minutes = Integer.parseInt(data[1]);
            int seconds = Integer.parseInt(data[2]);

            double sAng = 6 * seconds;
            double mAng = 6 * minutes + 0.1 * seconds;
            double hAng = 30 * hours + 0.5 * minutes + seconds/120.0;
            angles[i][0] = hAng;
            angles[i][1] = mAng;
            angles[i][2] = sAng;
        }
        System.out.println(count);
        for (int i = 0; i < count; i++)
        {
            double hmAng = angles[i][0] - angles[i][1];
            hmAng = roundAngles(hmAng);
            double hsAng = angles[i][0] - angles[i][2];
            hsAng = roundAngles(hsAng);
            double msAng = angles[i][1] - angles[i][2];
            msAng = roundAngles(msAng);

            System.out.format("%.2f, %.2f, %.2f\n", hmAng, hsAng, msAng);
        }
    }
}
