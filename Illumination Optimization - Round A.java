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
    long m = l();
    long r = l();
    int n = i();
    long[] arr = new long[n];
    TreeSet<Long> set = new TreeSet();
    
    for(int i =0; i<n; i++){ 
      arr[i] = l();
      set.add(arr[i]);
    }
   
    long count = 0;
    long maxReach = 0;
    Set<Long> used = new HashSet();
    
    while(maxReach<m){
       Long curr = set.floor(maxReach+r);

       if(curr==null || used.contains(curr)){
          sb.append("Case ").append("#").append(tc).append(": ").append("IMPOSSIBLE").append("\n");
          return;
       }else{
          used.add(curr);
          maxReach = curr+r;
          count++;
       }
    }

    sb.append("Case ").append("#").append(tc).append(": ").append(count).append("\n");
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