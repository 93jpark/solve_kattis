import java.util.*;

public class DirReduction2 {
    public static void main(String[] args){
        dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"});

        dirReduc(new String[]{"NORTH","SOUTH","SOUTH","EAST","WEST","NORTH"});
    }

    public static String[] dirReduc(String[] arr){

        LinkedList<String> q = new LinkedList();

        for(String str : arr){
            if(str.equals("EAST")){
                if(q.contains("WEST")){
                    q.remove("WEST");
                } else {
                    q.add("EAST");
                }
            }
            if(str.equals("WEST")){
                if(q.contains("EAST")){
                    q.remove("EAST");
                } else {
                    q.add("WEST");
                }
            }

            if(str.equals("NORTH")){
                if(q.contains("SOUTH")){
                    q.remove("SOUTH");
                } else {
                    q.add("NORTH");
                }
            }

            if(str.equals("SOUTH")){
                if(q.contains("NORTH")){
                    q.remove("NORTH");
                } else {
                    q.add("SOUTH");
                }
            }

        }
        return q.toArray(new String[0]);
    }
}
