// "static void main" must be defined in a public class.

//Q -> Print all the permutations of a string.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ques = sc.next();
        printPermutations(ques, "");
    }
    
    public static void printPermutations(String ques, String ans){
        
        if(ques.length()==0){
            System.out.println(ans);
            return;
        }
        for(int i = 0; i<ques.length(); i++){
             char ch = ques.charAt(i);
            
            //here while calling we have to be aware of rest of string bcoz if we choose b from abc then 
            //ros should be ac ..
            String roq = ques.substring(0, i) + ques.substring(i+1);
           printPermutations(roq, ch+ans); 
        }
        
       
    }
}