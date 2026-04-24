//2452. Words Within Two Edits of Dictionary
import java.util.*;
class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();
        int d = dictionary.length, q = queries.length;

        for(String str : queries){
            for(String dict : dictionary){
                int max = 0;
                for(int i=0; i<dict.length(); i++){
                    if(dict.charAt(i)!=str.charAt(i)) max++;
                }
                if(max <= 2) {
                    ans.add(str);
                    break;
                }
            }
        }

        return ans;
    }
}


