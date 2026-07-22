class Solution {
    public String toLowerCase(String s) {
        char[] Chars = s.toCharArray();
        for(int i =0; i < Chars.length;i++) {
            if(Chars[i] >='A' && Chars[i] <='Z'){ 
                Chars[i] += 32;
            }
        }
        return new String(Chars);
        
    }
}
