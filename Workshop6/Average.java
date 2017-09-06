import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Average {
    public static void main(String[] args) throws IOException {
        File f = new File("score.txt");
        Scanner in = new Scanner(f);
        String s;
        double sum = 0.0;
        int count = 0;
        while (in.hasNext()) {
            s = in.next();
            int score = in.nextInt();
            sum += score;
            count++;
        }
        if (count > 0)
            System.out.println(sum / count);
    }
}