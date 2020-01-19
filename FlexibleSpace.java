import java.util.*;

public class FlexibleSpace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int overall = sc.nextInt();
        int num_p = sc.nextInt();

        ArrayList list = new ArrayList<Integer>();

        for (int i = 0; i < num_p; i++) {
            list.add(sc.nextInt());
        }

        list.add(overall);  //  10
        Set set = new HashSet<Integer>(list);
        //list.add(0);        //  0



        for(int i = 0; i < list.size()-1; i++){
            for(int j = i+1; j < list.size(); j++){
                int temp = (int)list.get(i) - (int)list.get(j);
                temp = Math.abs(temp);
                //System.out.println(temp);
                set.add(temp);
            }
        }

        list = new ArrayList<Integer>(set);
        Collections.sort(list);
        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i));
            System.out.print(" ");
        }
    }
}
