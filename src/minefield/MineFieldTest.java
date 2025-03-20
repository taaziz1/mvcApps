package minefield;
import mvc.AppFactory;

import java.util.Scanner;

public class MineFieldTest {
    public static void main(String[] args) {
        AppFactory factory = new MineFieldFactory();
        MineFieldPanel panel = new MineFieldPanel(factory);
        panel.display();
        MineField mf = (MineField)panel.getModel();
        Scanner sc = new Scanner(System.in);

        int x  = -1;
        int y = -1;
        while(x != 0 || y != 0) {
            x = sc.nextInt();
            y = sc.nextInt();

            try {
                mf.move(x, y);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
