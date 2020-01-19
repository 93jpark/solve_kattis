import java.util.Scanner;

public class Bijele {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] set = {1,1,2,2,2,8};

        for(int i = 0; i < 6; i++){
            set[i] -= sc.nextInt();
        }

        for ( int i : set) {
            System.out.print(i+" ");
        }
    }
}
