import javax.xml.crypto.Data;
import java.lang.reflect.Array;
import java.util.*;

public class StringsMix {

    public static void main(String[] args) {
        //System.out.println(mix("A aaaa bbb c", "& aaa bbb c d"));


        //System.out.println(mix("my&friend&Paul has heavy hats! &","my friend John has many many friends &"));

        System.out.println(mix("mmmmm m nnnnn y&friend&Paul has heavy hats! &","my frie n d Joh n has ma n y ma n y frie n ds n&"));

        //System.out.println(mix("Are the kids at home? aaaaa fffff","Yes they are here! aaaaa fffff"));
    }


    // char ASCII code table -> 97 ~ 122
    public static String mix(String s1, String s2) {

        HashMap<Character, Integer> h1 = mapping(s1);
        HashMap<Character, Integer> h2 = mapping(s2);

        h1 = sortByValues(h1);
        h2 = sortByValues(h2);

        return getString(h1,h2);
        //return getString(t1,t2);
    }

    public static HashMap<Character, Integer> mapping(String s){

        HashMap<Character, Integer> t = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= 97 && s.charAt(i) <= 122){
                if(t.containsKey(s.charAt(i))){
                    t.put(s.charAt(i), t.get(s.charAt(i))+1);
                } else {
                    t.put(s.charAt(i), 1);
                }
            }
        }

        Iterator i = t.keySet().iterator();
        ArrayList<Character> list = new ArrayList<Character>();

        do{
            list.add((char)i.next());
        }while(i.hasNext());

        for( Character c : list){
            if(t.get(c).equals(1)){
                t.remove(c);
            }
        }


        return t;
    }

    public static String getString(HashMap<Character, Integer> m1, HashMap<Character, Integer>m2){

        System.out.println(m1);
        System.out.println(m2);

        List<Datas> list = new LinkedList<Datas>();

        Set s1 = m1.entrySet();
        Set s2 = m2.entrySet();

        Iterator i1 = s1.iterator();
        Iterator i2 = s2.iterator();

        Map.Entry e1 = (Map.Entry) i1.next();
        Map.Entry e2 = (Map.Entry) i2.next();


        do{

            char k1 = e1 == null ? 0 : (char)e1.getKey();
            char k2 = e2 == null ? 0 : (char)e2.getKey();

            int v1 = e1 == null ? 0 :  (int)e1.getValue();
            int v2 = e2 == null ? 0 : (int)e2.getValue();


            //System.out.println("1:"+k1+" "+v1);
            //System.out.println("2:"+k2+" "+v2);

            if(v1 > v2) {
                if(!isContain(list,k1)){
                    list.add(new Datas(1,k1,v1));
                }
                e1 = i1.hasNext() ? (Map.Entry)i1.next() : null;    //  iterator for map1
            } else if (v2 > v1){
                if(!isContain(list,k2)){
                    list.add(new Datas(2,k2,v2));
                }
                e2 = i2.hasNext() ? (Map.Entry)i2.next() : null;    //  iterator for map2

            } else if (v1 == v2 && k1 != k2){
                if(!isContain(list,k1)){
                    list.add(new Datas(1,k1,v1));
                } else {
                    if(list.get(getSameKeyData(list,k1)).redun == v1){
                        list.get(getSameKeyData(list,k1)).origin = 0;
                        System.out.println("REACHED");
                    }
                }
                e1 = i1.hasNext() ? (Map.Entry)i1.next() : null;

                if(!isContain(list,k2)){
                    list.add(new Datas(2,k2,v2));
                } else {
                    if(list.get(getSameKeyData(list,k2)).redun == v1){
                        list.get(getSameKeyData(list,k2)).origin = 0;
                        System.out.println("REACHED");
                    }
                }
                e2 = i2.hasNext() ? (Map.Entry)i2.next() : null;

            } else if(v1 == v2 && k1 == k2){
                list.add(new Datas(0,k1,v1));
                e1 = i1.hasNext() ? (Map.Entry)i1.next() : null;
                e2 = i2.hasNext() ? (Map.Entry)i2.next() : null;
            }

        }while(i1.hasNext() || i2.hasNext());

        for(Datas datas : list){
            System.out.println(datas.c+" "+datas.redun);
        }

        //return "";
        return getResultString(list);
    }

    private static String getResultString(List<Datas> list){

        String s = "";

        for(Datas d : list){
            char origin = ' ';
            if(d.origin == 0){
                origin = '=';
            } else if (d.origin == 1){
                origin = '1';
            } else if (d.origin == 2){
                origin = '2';
            }

            s += ""+origin+":";
            for(int i = 0; i < d.redun; i++){ s += d.c; }
            s += '/';
        }

        return s;
    }

    public static HashMap<Character, Integer> sortByValues(HashMap<Character, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<Character, Integer> > list =
                new LinkedList<Map.Entry<Character, Integer> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer> >() {
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<Character, Integer> temp = new LinkedHashMap<Character, Integer>();
        for (Map.Entry<Character, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

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

    public static boolean isContain(List<Datas> list, char c){

        for(Datas d : list){
            if(d.c == c){
                return true;
            }
        }

        return false;
    }

    public static int getSameKeyData(List<Datas> list, char c){

        int count = 0;
        for(Datas datas : list){
            if(datas.c == c){
                return count;
            }
            count++;
        }

        return -1;
    }

}

