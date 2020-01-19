
import java.util.*;

public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String s = "";

        for(int i = 0; i < n; i++){
            int x = sc.nextInt();
            int y = x;

            if(x < 0){
                y *= -1;
            }

            if( y % 2 == 1) {
                s += x + " is odd\n";
            } else {
                s += x + " is even\n";
            }
        }
        System.out.println(s);
    }
}

