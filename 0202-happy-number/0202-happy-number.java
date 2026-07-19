class Solution {
    public boolean isHappy(int n) {
        int sum = 0;
        int d;
      while (n > 6)
      {
        while (n> 0){
            d = n%10;
            sum = sum + (d*d);
            n = n /10;
        }
        n = sum;
        sum = 0;
      }
if(n == 1)
  return true;
else 
  return false;
    
    }
}