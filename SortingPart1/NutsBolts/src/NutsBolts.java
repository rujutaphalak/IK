public class NutsBolts {

    public static void main(String[] args) {
//      int[] nuts = null;
//      int[] bolts = null;
//      int[] nuts = {};
//      int[] bolts = {};
        int[] nuts = {4, 32, 5, 7};
        int[] bolts = {32, 7, 5, 4};

        String[] result = solve(nuts, bolts);
        if (result==null)
            System.out.println("Both or one of the nuts or bolts is empty or null");
        else {
            for (String s : result) {
                System.out.println(s);
            }
        }
    }

    private static String[] solve ( int[] nuts, int[] bolts){
        if (nuts == null || bolts == null)
            return null;
        if (nuts.length == 0 || bolts.length == 0 || nuts.length > Math.pow(10, 5) || bolts.length > Math.pow(10, 5))
            return null;
        String[] result = new String[nuts.length];
        for (int i=0;i<bolts.length;i++) {
            for (int j=0;j<bolts.length;j++) {
                if (nuts[j] == bolts[i]) {
                    result[i] = String.valueOf(nuts[j]) +" "+ String.valueOf(bolts[i]);
                }
            }
        }
        return result;
    }
}

