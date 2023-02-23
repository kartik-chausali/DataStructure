// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ques = sc.next();
        printEncodings(ques, "");
        
    }
    
    public static void printEncodings(String ques, String ans){
        
        if(ques.length()== 0){
            System.out.println(ans);
            return;
        }else if(ques.length()==1){
            char ch = ques.charAt(0);
            if(ch == '0'){
                return;
            }else{
                //get the actual int value of ch as string given will always be from 1-9
                int chvalue = ch - '0';
             //get the code of ch by this way 
                char code = (char)('a' + chvalue -1);
                System.out.println(ans+code);
            }
        }else{
            char ch = ques.charAt(0);
            String roq = ques.substring(1);
            if(ch == '0'){
                return;
            }else{
                int chvalue = ch - '0';
                char code = (char)('a' + chvalue - 1);
                printEncodings(roq, code+ans);
            }
            
            String firsttwo = ques.substring(0, 2);
            String roq2 = ques.substring(2);
            
            int firsttwovalue = Integer.parseInt(firsttwo);
            if(firsttwovalue <= 26){
                char code = (char)('a' + firsttwovalue -1);
                printEncodings(roq2, ans+code);
            }
        }
    }
}