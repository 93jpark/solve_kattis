import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ColdPuter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        sc.nextLine();
        int count = 0;
        List inputs = new LinkedList();

        for(int i = 0; i < input; i ++){
            int temp = sc.nextInt();
            if(temp < 0){
                count++;
            }
        }

        System.out.println(count);

    }

}
