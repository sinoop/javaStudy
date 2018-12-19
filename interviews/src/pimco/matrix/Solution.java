package pimco.matrix;

import java.io.*;
import java.util.*;


class Result {

    /*
     * Complete the 'findMatrix' function below.
     *
     * The function is expected to return a 2D_INTEGER_ARRAY.
     * The function accepts 2D_INTEGER_ARRAY a as parameter.
     */

    public static List<List<Integer>> findMatrix(List<List<Integer>> a) {
        List<List<Integer>> b =  new ArrayList<>();

        for (int i = 0; i < a.size(); i++) {
            List<Integer> aRowItems = new ArrayList<>();
            b.add(aRowItems);

            for (int j = 0; j < a.get(0).size(); j++) {
                int sum = 0;
                sum = a.get(i).get(j);

                if(i-1 >= 0){
                    sum += b.get(i-1).get(j);
                }
                if(j-1 >= 0){
                    sum += b.get(i).get(j-1);

                    if(i-1 >= 0 ){
                        sum -= b.get(i-1).get(j-1);
                    }
                }
                b.get(i).add(sum);
            }
        }
        return b;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int aRows = Integer.parseInt(bufferedReader.readLine().trim());
        int aColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> a = new ArrayList<>();

        for (int i = 0; i < aRows; i++) {
            String[] aRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> aRowItems = new ArrayList<>();

            for (int j = 0; j < aColumns; j++) {
                int aItem = Integer.parseInt(aRowTempItems[j]);
                aRowItems.add(aItem);
            }

            a.add(aRowItems);
        }

        List<List<Integer>> result = Result.findMatrix(a);

        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                bufferedWriter.write(String.valueOf(result.get(i).get(j)));

                if (j != result.get(i).size() - 1) {
                    bufferedWriter.write(" ");
                }
            }

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
