
/**
 * This lab took me approximately 20 minutes to do. I learned about recursion, 
 * and struggled with some parts. However, I found my problems when I used 
 * the recursion diagram. 
 */
public class P4_Iyer_Meenakshi_Fibonacci
{
    public static void main(){
        System.out.println();
        System.out.println("Fib(0) = " + fibonacci(0));
        System.out.println("Fib(3) = " + fibonacci(3));
        System.out.println("Fib(11) = " + fibonacci(11));
        System.out.println("Fib(20) = " + fibonacci(20));
        System.out.println("7*8 = "+multiply(7,8));
        System.out.println("5*1 = "+multiply(5,1));
        System.out.println("5*0 = "+multiply(5,0));
        System.out.println("0*9  = "+multiply(0,9));
        System.out.println("0*0 = "+multiply(0,0));
        System.out.println("45*11 = "+multiply(45,11));
        System.out.println("-7*8 = "+multiply2(-7,8));
        System.out.println("-7*-8 = "+multiply2(-7,-8));
        System.out.println("7*-8 = "+multiply2(7,-8));
        System.out.println("-7*9 = "+multiply2(-7,9));
        System.out.println("-7*-9 = "+multiply2(-7,-9));
        System.out.println("7*-9 = "+multiply2(7,-9));
        System.out.println(test(3));
        
        
    }
    
    public static int fibonacci(int n){
        
        
        if(n==0 ){
           return 0; 
        }
        else if(n==1 ){
           return 1; 
        }
        
        else{
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
    
    public static int multiply(int a, int b){
        if(a==0 || b==0){
            return 0;
        }
        else if(a==1){
            return b;
        }
        else if(b==1){
            return a;
        }
        
        else{
            return (multiply(a, b-1)) + a;
        }
        
    }
    
    
    public static int multiply2(int a, int b){
        if(a==0 || b==0){
            return 0;
        }
        else if(a==1){
            return b;
        }
        else if(b==1){
            return a;
        }
        
        
        else{
            if(b<0 && a<0){
                a = a*(-1);
                b=b*(-1);
                return (multiply2(a, b-1)) + a;
            }
            
            if(b<0 && a>0){
                return (multiply2(a, b+1)) - a;
            }
            return (multiply2(a, b-1)) + a;
        }
        
    }
    
    public static int test(int n){
        if(n==6){
            return 6;
        }
        
        return 2*test(n+1);
    }
}
