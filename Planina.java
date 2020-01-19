import java.util.Scanner;

public class Planina {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int iter = sc.nextInt();
        int init = 2;
        int x = (int) Math.pow(2.0,(double)iter);

        for(int i = 0; i < iter; i++){
            init += (int) Math.pow(2.0,(double)i);
        }
        System.out.println(init*init);
    }
}
