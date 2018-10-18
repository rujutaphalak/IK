import java.util.ArrayList;

public class SelfLearnSubset {

    public static void main(String []args){
        String str = "abc";
        String[] list=generate_all_subsets(str);
        for(String s:list)
            System.out.println(s);
    }

    static String[] generate_all_subsets(String s) {
        String subset = "";
        ArrayList<String> list = new ArrayList<>();
        list = generateSubsets(s, 0, subset, list);
        return list.stream().toArray(String[]::new);
    }

    private static ArrayList<String> generateSubsets(String s, int i, String subset, ArrayList<String> list){
        if (i==s.length()){
            list.add(subset);
            return list;
        }
        generateSubsets(s,i+1,subset,list);
        generateSubsets(s,i+1,subset+s.substring(i,i+1),list);
        return list;
    }
}
