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
    long[] map = new long[26];
    for(int i =0;i<26;i++) map[i] = l();
    
    HashMap<String, String> set = new HashMap();
    int N = i();
    boolean possible = true;
    
    while(N-->0){
       String str = s();
       StringBuilder key = new StringBuilder();
       
       for(int i =0; i<str.length(); i++){
           char ch = str.charAt(i);
           key.append(map[ch-'A']);
       }
       
       String mask = key.toString();
       
       if(set.containsKey(mask)){
        if(!set.get(mask).equals(str)) possible = false;
       }else set.put(mask, str);
    }

    if(possible) sb.append("Case ").append("#").append(tc).append(": ").append("NO\n");
    else sb.append("Case ").append("#").append(tc).append(": ").append("YES\n");
  }
 
  public static void main(String[] args) throws Exception{
    sb = new StringBuilder();
    br = new BufferedReader(new InputStreamReader(System.in));
    // factors = new ArrayList[(int)MAX_M];
    // getFactors();
 
    fact=new long[(int)1e6+10]; fact[0]=fact[1]=1; for(int i=2;i<fact.length;i++)
    { fact[i]=((long)(i%mod)*(long)(fact[i-1]%mod))%mod; }
    
    int t = i();
    int i = 1;
    while (t-- > 0) {
      solve(i++);
    }
    
    out.printLine(sb);
    out.close();
  }

}