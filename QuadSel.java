import java.util.Scanner;

public class QuadSel {

    public static void main(String []Args){

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int location = 0;

        if(x > 0){
            if(y > 0)
                location = 1;
            else
                location = 4;
        } else {
            if(y > 0)
                location = 2;
            else
                location = 3;
        }

        System.out.println(location);
    }

}
