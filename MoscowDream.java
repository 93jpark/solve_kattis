import java.util.Scanner;

public class MoscowDream {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int n = sc.nextInt();

        boolean flag = true;

        if( a <= 0 ||  b <= 0 || c <= 0 ){
            flag = false;
        }

        if( n < 3 || n > 20  ) {
            flag = false;
        }

        if ( a+b+c < n ) {
            flag = false;
        }

        if(flag){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
