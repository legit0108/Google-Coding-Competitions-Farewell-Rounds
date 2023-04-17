import java.util.*;


import java.io.*;

public class Solution {
  static StringBuilder sb;
  static dsu dsu;
  static long fact[];
  static long mod = (long)1e9+7;
  static BufferedReader br;
  static HashMap<Long, Long> map;

  static ArrayList<Integer>[] factors;
  static int MAX_M = (int)1e5;
  static int minOps = Integer.MAX_VALUE;

  static void solve(int tc) throws Exception{
    int p = Integer.parseInt(br.readLine());
    String[] arr = br.readLine().split(" ");
    StringBuilder last = new StringBuilder();
    StringBuilder ans = new StringBuilder();

    for(int i=0; i<p; i++){
      int[] map = getFrequencyMap(arr[i]);
      StringBuilder curr = new StringBuilder();

      if(i==0){
          for(int j=0; j<26; j++){
            char ch = (char)('A'+j);

            while(map[j]>0){
               curr.append(ch);
               map[j]--;
            }
          }
      }else{
          curr = generateString(last, 0, map);

          if(curr.length()>100){
            sb.append("Case #").append(tc).append(": ").append("IMPOSSIBLE\n");
            return;
          }
      }

      ans.append(curr.toString()).append(" ");
      last = curr;
    }

    sb.append("Case #").append(tc).append(": ").append("POSSIBLE\n");
    sb.append(ans).append("\n");
  }

  private static StringBuilder generateString(StringBuilder last, int index, int[] map){
    StringBuilder curr = new StringBuilder();

    if(index==last.length()){
      for(int i =0; i<26; i++){
        char ch = (char)('A'+i);

        while(map[i]>0){
          curr.append(ch);
          map[i]--;
        }
      }
      
      return curr;
    }else{
      char ch = last.charAt(index);

      if(map[ch-'A']==0){
        for(int i=(ch-'A'+1); i<26; i++){
          if(map[i]!=0){
            ch = (char)('A'+i);
            curr.append(ch);
            map[i]--; 
            
            for(int j =0; j<26; j++){
              ch = (char)('A'+j);
    
              while(map[j]>0){
                curr.append(ch);
                map[j]--;
              }
            }
  
            return curr;
          }
        }
        
        curr = new StringBuilder("afhweiuhwajioejwoiehrwerrukhqeiruhqjiweujqorwheiruhwuhweirhjwurhfweiufqhiruwerhwirwehfiurehfiwurhiweuhrwieurhwiurhwieurhwiuehiuwheriwurhwiuelhworhweirhwerh"); // max length of input is 100 return length > 100 to invalidate
        return curr;
      }else{
        curr.append(ch);
        map[ch-'A']--; 
        curr.append(generateString(last, index+1, map));
        map[ch-'A']++;

        if(curr.length()>100){
          curr = new StringBuilder();
          
          for(int i=(ch-'A'+1); i<26; i++){
            if(map[i]!=0){
              ch = (char)('A'+i);
              curr.append(ch);
              map[i]--; 
              
              for(int j =0; j<26; j++){
                ch = (char)('A'+j);
      
                while(map[j]>0){
                  curr.append(ch);
                  map[j]--;
                }
              }
    
              return curr;
            }
          }
          
          curr = new StringBuilder("afhweiuhwajioejwoiehrwerrukhqeiruhqjiweujqorwheiruhwuhweirhjwurhfweiufqhiruwerhwirwehfiurehfiwurhiweuhrwieurhwiurhwieurhwiuehiuwheriwurhwiuelhworhweirhwerh"); // max length of input is 100 return length > 100 to invalidate
          return curr;
      }else return curr;
    }
  }
}

  private static int[] getFrequencyMap(String str){
    int n = str.length();
    int[] map = new int[26];

    for(int i=0; i<n; i++){
      map[str.charAt(i)-'A']++;
    }

    return map;
  }
  public static void main(String[] args) throws Exception{
    sb = new StringBuilder();
    br = new BufferedReader(new InputStreamReader(System.in));
    
    // factors = new ArrayList[(int)MAX_M];
    // getFactors();
 
    fact=new long[(int)1e6+10]; fact[0]=fact[1]=1; for(int i=2;i<fact.length;i++)
    { fact[i]=((long)(i%mod)*(long)(fact[i-1]%mod))%mod; }
    
    int t = Integer.parseInt(br.readLine());
    int i = 1;
    while (t-- > 0) {
      solve(i++);
    }
    
    out.printLine(sb);
    out.close();
  }
}