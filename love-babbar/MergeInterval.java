import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'getMergedIntervals' function below.
     *
     * The function is expected to return a 2D_INTEGER_ARRAY.
     * The function accepts 2D_INTEGER_ARRAY intervals as parameter.
     */
     /*
     [[1,2], [2,3], [6,11], [7, 7]]
     [[1,3], [6,11]]
     */

    public static List<List<Integer>> getMergedIntervals(List<List<Integer>> intervals) {
    // Write your code here
        List<R> sorted = new ArrayList<>();
        
        for (int i = 0; i< intervals.size() ; i++) {
            R r = new R();
            r.first = intervals.get(i).get(0);
            r.second = intervals.get(i).get(1);
            sorted.add(r);
        }
        Collections.sort(sorted);
        // System.out.println(sorted.get(0).first);
        // System.out.println(sorted.get(0).second);
        
        List<R> merged = new ArrayList<>(); 
        merged.add(sorted.get(0));
        for (int i = 1; i < sorted.size(); i++) {
            R last = merged.get(merged.size()-1);
            
            int lf = last.first;
            int lsec = last.second;
            
            if (lsec >= sorted.get(i).first) {
                if (lf > sorted.get(i).first) {
                    last.first = sorted.get(i).first;
                }
                if (lsec < sorted.get(i).second) {
                    last.second = sorted.get(i).second;
                }
            } else {
                merged.add(sorted.get(i));
            }
            
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i< merged.size() ; i++) {
            List<Integer> n = new ArrayList<>();
            n.add(merged.get(i).first);
            n.add(merged.get(i).second);
            res.add(n);
        }
        return res;
    }

}
class R implements Comparable<R> {
    
    public int first;
    public int second;
    
    
    public int compareTo(R r) 
    {
        if (this.first > r.first  ) {
            return 1;
        } else if (this.first < r.first) {
            return -1;
        } else {
            if (this.second < r.second) {
                return -1;
            } else {
                return 1;
            }
        }
        
    }
     
}


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int intervalsRows = Integer.parseInt(bufferedReader.readLine().trim());
        int intervalsColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> intervals = new ArrayList<>();

        IntStream.range(0, intervalsRows).forEach(i -> {
            try {
                intervals.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<List<Integer>> result = Result.getMergedIntervals(intervals);

        result.stream()
            .map(
                r -> r.stream()
                    .map(Object::toString)
                    .collect(joining(" "))
            )
            .map(r -> r + "\n")
            .collect(toList())
            .forEach(e -> {
                try {
                    bufferedWriter.write(e);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
