import java.util.*;

public class DirReduction {
    public static void main(String[] args){
        //System.out.println(dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"}));

        //print(dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"}));

        //System.out.println(dirReduc(new String[]{"NORTH","SOUTH","SOUTH","EAST","WEST","NORTH"}));
        print(dirReduc(new String[]{"NORTH","SOUTH","SOUTH","EAST","WEST","NORTH"}));


        //System.out.println(dirReduc(new String[]{"NORTH", "WEST", "SOUTH", "EAST"}));
        //print(dirReduc(new String[]{"NORTH", "WEST", "SOUTH", "EAST"}));
    }

    public static String[] dirReduc(String[] arr){
        //This is recursive method. So, if length of arr is less then 2, just retrun arr.
        if(arr.length < 2){
            return arr;
        }

        //list contains simplified direction sequece.
        List<String> list = new ArrayList<String>();
        //flag variable indicate whether reduction was occurred or not
        Boolean flag = false;

        for(int i = 0; i < arr.length-1; i++){
            if(arr[i].equals("EAST") && arr[i+1].equals("WEST")){
                arr[i] = "";
                arr[i+1] = "";
                flag = true;
            } else if(arr[i].equals("WEST") && arr[i+1].equals("EAST")){
                arr[i] = "";
                arr[i+1] = "";
                flag = true;
            } else if(arr[i].equals("NORTH") && arr[i+1].equals("SOUTH")){
                arr[i] = "";
                arr[i+1] = "";
                flag = true;
            } else if(arr[i].equals("SOUTH") && arr[i+1].equals("NORTH")){
                arr[i] = "";
                arr[i+1] = "";
                flag = true;
            } else if(!arr[i].isEmpty()) {
                list.add(arr[i]);
            }

            //checking the last element of given array
            if((i == (arr.length - 2)) && !arr[arr.length - 1].isEmpty()){
                list.add(arr[i+1]);
            }
        }

        //  if reduction was occurred, then do dirReduc again.
        if(flag){
            return dirReduc(list.toArray(new String[0]));
        }

        return list.toArray(new String[0]);

    }

    public static void print(String[] arr){
        for(String s : arr){
            System.out.print(s+" ");
        }
        System.out.println();
    }

}
