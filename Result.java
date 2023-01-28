import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.Map.Entry;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'lonelyinteger' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int lonelyinteger(List<Integer> a) {
    // Write your code here
    Map<Integer, Integer> intMap = new HashMap<>();
for(Integer num : a){
    if(intMap.containsKey(num)){
        intMap.put(num,intMap.get(num)+1);
    }else{
        intMap.put(num, 1);
    }
}
/*int loneValue =0;
for(Entry<Integer,Integer> entryOne: intMap.entrySet()){
    if(entryOne.getValue()==1){
        loneValue= entryOne.getKey();
    }
}*/
    Optional<Integer> loneValue  = intMap.entrySet().stream().filter(o -> o.getValue().equals(1)).map(Map.Entry::getKey).findFirst();
    
    return loneValue.get();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.lonelyinteger(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
