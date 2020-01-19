import java.util.*;

public class StringMix {

    public static void main(String[] args) {
        System.out.println(mix("A aaaa bbb c", "& aaa bbb c d"));


        System.out.println(mix("my&friend&Paul has heavy hats! &","my friend John has many many friends &"));

        System.out.println(mix("mmmmm m nnnnn y&friend&Paul has heavy hats! &","my frie n d Joh n has ma n y ma n y frie n ds n&"));

        System.out.println(mix("Are the kids at home? aaaaa fffff","Yes they are here! aaaaa fffff"));
        System.out.println(mix("codewars", "codewars"));
    }


    public static String mix(String s1, String s2) {

        return getResultString(compArr(s1,s2));

    }

    // mapping method do mapping from given string to integer array.
    // In this array, each index indicates alphabet i.e. 0 = a, 1 = b ..
    public static int[] mapping(String s){

        int[] mapArray = new int[26];
        int base  = 97; //  a-z is 97 - 122 from ASCII code.

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= 97 && s.charAt(i) <= 122){
                mapArray[s.charAt(i)-base]++;
            }
        }

        return mapArray;
    }

    //  compArr method compare two arrays, and construct layer ArrayList for result String
    public static ArrayList<Datas>[] compArr(String s1, String s2){

        int[] arr1 = mapping(s1);
        int[] arr2 = mapping(s2);

        //  set store how many repeat of character from both strings
        Set<Integer> set = new HashSet<>();
        for(int n : arr1){
            if(n>1){    //  only take greater than 1
                set.add(n);
            }
        }
        for(int n : arr2){
            if(n>1){
                set.add(n);
            }
        }

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list, Collections.reverseOrder()); //  # of repeated times in descending order
        ArrayList<Datas>[] layer = new ArrayList[list.size()];  //  each layer contains repeated character

        for(int l = 0; l < list.size(); l++){

            //  initialize layer array what will contain Datas object.
            //  Datas object store information for repeated character, repeated time, and where it from
            layer[l] = new ArrayList<>();

            for(int i = 0; i < arr1.length; i++){

                int a1 = arr1[i];
                int a2 = arr2[i];

                //  only check the element corresponding to the list
                if(list.get(l) == a1 || list.get(l) == a2){

                    //initialize variables for Datas constructor
                    int origin = -1;
                    char c = '@';
                    int redun = -1;

                    // origin = 0 : both
                    // origin = 1 : from 1st string
                    // origin = 2 : from 2nd string

                    if(a1 > a2){
                        origin = 1;
                        c = (char)(i+97);
                        redun = list.get(l);
                    } else if (arr1[i] < arr2[i]){
                        origin = 2;
                        c = (char)(i+97);
                        redun = list.get(l);
                    } else if (arr1[i] == arr2[i] && arr1[i]>1 ){
                        origin = 0;
                        c = (char)(i+97);
                        redun = list.get(l);
                    }
                    layer[l].add(new Datas(origin,c,redun));
                    arr1[i] = -1;
                    arr2[i] = -1;
                }
            }
        }

        return layer;
    }

    //  getResultString method do make result string based on ArrayList layer.
    public static String getResultString(ArrayList<Datas>[] layer){

        //  initialize result string
        String result = "";

        for(int i = 0; i < layer.length; i++){
            //  each following string will contain repeated string
            String fromTwo = "";
            String fromBoth = "";
            for(Datas d : layer[i]){
                //  following two boolean variable distinguish which case is it
                boolean twoFlag = false;
                boolean bothFlag = false;
                if(d.origin == 0){
                    fromBoth += "=:";
                    bothFlag = true;
                } else if(d.origin == 2){
                    fromTwo += d.origin + ":";
                    twoFlag = true;
                } else{
                    result += d.origin + ":";
                }
                for(int n = 0; n < d.redun; n++){
                    if(bothFlag){
                        fromBoth += d.c;
                    } else if(twoFlag){
                        fromTwo += d.c;
                    } else {
                        result += d.c;
                    }
                }
                if(bothFlag){
                    fromBoth += "/";
                } else if(twoFlag){
                    fromTwo += "/";
                } else {
                    result += "/";
                }
            }
            result += fromTwo;
            result += fromBoth;

        }
        //  trim last slash
        if(result.length()!=0){
            result = result.substring(0,result.length()-1);
        }
        return result;
    }

    //  Datas class is for data storing
    public static class Datas{
        int origin;
        char c;
        int redun;

        public Datas(int origin, char c, int redun){
            this.origin = origin;
            this.c = c;
            this.redun = redun;
        }
    }


}


// 2:nnnnn/1:aaaa/1:hhh/2:mmm/2:yyy/2:dd/2:ff/2:ii/2:rr/=:ee/=:ss
// 2:nnnnn/1:aaaa/1:hhh/2:mmm/2:yyy/2:dd/2:ff/2:ii/2:rr/=:ee/=:ss/
// 2:nnnnn/1:aaaa/1:aaa/1:hhh/2:mmm/2:yyy/2:dd/0:ee/2:ff/1:hh/2:ii/2:rr/0:ss/2:yy/

