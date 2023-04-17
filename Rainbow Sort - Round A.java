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
       int n = i();
       int[] arr = new int[n];
       for(int i =0; i<n; i++) arr[i] = i(); 
       
       Set<Integer> set = new HashSet();
       StringBuilder order = new StringBuilder();
       int i = 0;
  
       while(i<n){
         if(set.contains(arr[i])){
            sb.append("Case #").append(tc).append(": IMPOSSIBLE").append("\n");
            return;
         }else{
            set.add(arr[i]);
            order.append(arr[i]).append(" ");
  
            while(i+1<n && arr[i]==arr[i+1]) i++;
            
            i++;
         }
       }
  
       sb.append("Case #").append(tc).append(": ").append(order).append("\n");
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