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
    long n = l();
    
    long curr = 1;
    long min = 1;
    long max = 26;
    long prevChars = 0;

    while(!(n>=min && n<=max)){
       prevChars+=curr*26l;
       curr++;
       
       long prevMax = max;
       max = prevMax+curr*26l;
       min = prevMax+1l;
    }

    min = min-prevChars;
    max = max-prevChars;
    n = n-prevChars;

    long delta = (n/curr)-1;
    char ch = (char)('A'+delta);
    
    if((n%curr)>0){
      if(ch=='Z') ch='A';
      else ch++;
    }

    sb.append("Case ").append("#").append(tc).append(": ").append(ch).append("\n");
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