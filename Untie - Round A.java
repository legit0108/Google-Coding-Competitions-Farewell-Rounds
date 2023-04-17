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
    String s = s();
    int n = s.length();
    
    int start = 0;
    int end = n-1;

    long count = 0;
    for(int i =0; i<n; i++){
      if(s.charAt(i)==s.charAt(0)) count++;
    }

    if(count==n){
      sb.append("Case ").append("#").append(tc).append(": ").append((count+1)/2).append("\n");
    }else{
     count = 0;
     if(s.charAt(start)==s.charAt(end)){
       long count1 = 1;
       while(start<end && s.charAt(start)==s.charAt(start+1)){
         start++;
         count1++;
       }
       start++;
       
       long count2 = 1;
       while(end>start && s.charAt(end)==s.charAt(end-1)){
        end--;
        count2++;
       }
       end--;
       
       count = count1+count2;
    }
     
    long moves = count/2; 
    int i = start;

    while(i<=end){
      long sameCount = 1;
      
      while(i+1<=end && s.charAt(i)==s.charAt(i+1)){
        i++;
        sameCount++;
      }

      moves+=sameCount/2;
      i++;
    }

    sb.append("Case ").append("#").append(tc).append(": ").append(moves).append("\n");
  }
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
