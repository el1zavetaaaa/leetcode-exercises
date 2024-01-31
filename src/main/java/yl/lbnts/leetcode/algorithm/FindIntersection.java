package yl.lbnts.leetcode.algorithm;


public class FindIntersection {

    public static void main(String[] args) {
        System.out.println(findIntersection(new String[]{"1,3,4,7,13", "1,2,4,13,15"}));
        System.out.println(findIntersection(new String[]{"1,3,9,10,17,18", "1,4,9,10"}));
    }

    public static String findIntersection(String[] strArr) {
        // code goes here
        String [] arr1 = strArr[0].split(",");
        String [] arr2 = strArr[1].split(",");
        StringBuilder result = new StringBuilder();

        int resultLength = 0;

        if (arr1.length < arr2.length)
        {
            resultLength = arr1.length;
        }
        else {
            resultLength = arr2.length;
        }

        int k =0;
        for(int i=0; i< resultLength; i++){
            if(Integer.parseInt(arr1[i]) == Integer.parseInt(arr2[k]))
            {
                result.append(arr1[i]).append(",");
                k++;
            } else if( Integer.parseInt(arr1[i]) > Integer.parseInt(arr2[k])){
                i--;
                k++;
            }
        }

        return result.substring(0, result.length() -1);
    }
}
