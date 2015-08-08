package unscrambler;
import java.io.*;
import java.util.*;
/**
 *
 * @author Nocturne
 */
public class Unscrambler {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] string = sc.next().toCharArray();

        try (BufferedReader br = new BufferedReader(new FileReader("src/unscrambler/list_of_words.txt"))) {
            String curr;
            while ((curr = br.readLine()) != null) {
                char[] words = curr.toCharArray();
                boolean same = false;
                if(string.length == words.length){
                    int[][] count = new int[2][26];
                    
                    for(char c : string){ count[0][c - 'a']++; }
                    for(char c : words){ count[1][c - 'a']++; }
                    for(int i = 0; i < 26; i++){
                        if(count[0][i] != count[1][i]) break;
                        else same = true;
                    }
                    
                    if(same) System.out.println(curr);
                }
            }
        } catch (IOException e) { e.printStackTrace(); } 
    }
    
}
