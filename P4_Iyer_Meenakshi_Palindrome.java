
/**
 * This lab took me about an hour an half to do. One part that took me a long time to fix
 * was bc I had a greater than instead of a less than. i also spent some time looking at
 * various methods to convert a char to a String.
 */
public class P4_Iyer_Meenakshi_Palindrome
{
    
    public static void main(){
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        
    }
    public static String reverseI(String a)
    {
        System.out.println(a);
        char[] b = new char[a.length()];
        //System.out.println(new String(b));
        for(int i = a.length()-1; i>=0; i--){
                b[a.length()-1-i] = a.charAt(i);
                //System.out.println(i);
                //System.out.println(b[i]);
            
            
        }
        String c = "";
        for(int i = 0; i<= b.length - 1;i++){
            //System.out.println(b[i]);
            c = c.concat(Character.toString(b[i]));
        }
        //System.out.println(c);
        
        
        return c;
    }
    
    public static String reverseR(String a){
        if(a.length() == 2){
            char temp = a.charAt(0);
            return a.substring(1).concat(Character.toString(temp));
        }
            
        else if(a.length()==0){
            return a;
        }
        else if(a.length()==1){
            return Character.toString(a.charAt(0));
        
    }
     else {
         return Character.toString(a.charAt(a.length()-1)).concat(reverseR(a.substring(0,a.length()-1)));
     
    }
    
}

public static boolean isPalindrome(String a){
    String b = "";
    
    for(int i = 0; i<=a.length()-1; i++){
       
        if((int)(a.charAt(i)) >= 61 && (int)(a.charAt(i))<= 122 || (int)(a.charAt(i)) >= 41 && (int)(a.charAt(i))<= 90 || (int)(a.charAt(i)) >= 30 && (int)(a.charAt(i))<= 39){
            b.concat(Character.toString(a.charAt(i)));
        
    }
    
    else{
       continue; 
    }
}
    
    
    if(b.equals(reverseR(b))){
        return true;
    }
    else
        return false;
}
}
    

