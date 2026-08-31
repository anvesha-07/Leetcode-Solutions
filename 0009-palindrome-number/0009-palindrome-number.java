class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }else{
            int rev = 0;
            int original = x;
            while(x!=0){
                int  div = x % 10;
                 x = x/10;
                rev =  rev * 10 + div;
            }
        if(original == rev){
            return true;
        }else{
            return false;
        }
        }
}  
}