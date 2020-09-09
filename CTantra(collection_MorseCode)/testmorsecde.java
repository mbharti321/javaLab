// Type Content here...
import java.util.*;

class MorseCode{
    public char alpha;
    public String code;
    
    MorseCode(char alpha, String code){
        this.alpha = alpha;
        this.code = code;
    }
}


public class testmorsecode{
    static ArrayList<MorseCode> morse = new ArrayList<MorseCode>();
    
    public static char getAlphaChar(String code){
        char alpha = '\0';
        for(MorseCode morseObj : morse){
            if(code.equals(morseObj.code)){
                alpha = morseObj.alpha;
                break;
            }
        }
        return alpha;
    }
    
    public static String getCode(char alpha){
        String code = "\0";
        for(MorseCode morseObj : morse){
            if(morseObj.alpha == alpha){
                code =  morseObj.code;
            }
        }
        return code;
    }
    
    public static String generateString(ArrayList<String> InputMorseCodeList){
        String resultDecodedString = "";
    
        for(String code : InputMorseCodeList){
              //getting first six characters from the morsecode
              //as the length of morsecode might vary as we appended 5 spaces 
              //at the end of the string while taking input
            code = code.substring(0,6);
             //System.out.print(getAlphaChar(code));
            resultDecodedString += getAlphaChar(code);
        }
        return resultDecodedString;
    }
    
    public static String generateMorseCode(String message){
        String resultMorseCode = "";
        
        for(char alpha : message.toCharArray()){
            resultMorseCode += getCode(alpha);
            resultMorseCode += " ";
        }
        return resultMorseCode;
    }
    
    
    public static void main(String[] args){
    
        Scanner scan = new Scanner(System.in);
               
        morse.add(new MorseCode('A', ".-    "));
        morse.add(new MorseCode('B', "-...  "));
        morse.add(new MorseCode('C', "-.-.  "));
        morse.add(new MorseCode('D', "-..   "));
        morse.add(new MorseCode('E', ".     "));
        morse.add(new MorseCode('F', "..-.  "));
        morse.add(new MorseCode('G', "--.   "));
        morse.add(new MorseCode('H', "....  "));
        morse.add(new MorseCode('I', "..    "));
        morse.add(new MorseCode('J', ".---  "));
        morse.add(new MorseCode('K', "-.-   "));
        morse.add(new MorseCode('L', ".-..  "));
        morse.add(new MorseCode('M', "--    "));
        morse.add(new MorseCode('N', "-.    "));
        morse.add(new MorseCode('O', "---   "));
        morse.add(new MorseCode('P', ".--.  "));
        morse.add(new MorseCode('Q', "--.-  "));
        morse.add(new MorseCode('R', ".-.   "));
        morse.add(new MorseCode('S', "...   "));
        morse.add(new MorseCode('T', "-     "));
        morse.add(new MorseCode('U', "..-   "));
        morse.add(new MorseCode('V', "...-  "));
        morse.add(new MorseCode('W', ".--   "));
        morse.add(new MorseCode('X', "-..-  "));
        morse.add(new MorseCode('Y', "-.--  "));
        morse.add(new MorseCode('Z', "--..  "));
        
        morse.add(new MorseCode('0', "----- "));
        morse.add(new MorseCode('1', ".---- "));
        morse.add(new MorseCode('2', "..--- "));
        morse.add(new MorseCode('3', "...-- "));
        morse.add(new MorseCode('4', "....- "));
        morse.add(new MorseCode('5', "..... "));
        morse.add(new MorseCode('6', "-.... "));
        morse.add(new MorseCode('7', "--... "));
        morse.add(new MorseCode('8', "---.. "));
        morse.add(new MorseCode('9', "----. "));
        
        morse.add(new MorseCode(':', "---..."));
        morse.add(new MorseCode('-', "..--.-"));
        morse.add(new MorseCode('@', ".--.-."));
        
        System.out.println("Enter any string to be morse coded");
        String inputString = scan.nextLine();
        String resutString = generateMorseCode(inputString.toUpperCase());
        System.out.println("The string in morse code is " + resutString);
        
        System.out.println("Enter the size of the morse code string you want to decode");
        int count = scan.nextInt();
        
        ArrayList<String> inputMorseList = new ArrayList<String>();
        for(int i = 0; i < count; i++){
            System.out.println("Enter the morse code to decode");
            String morseString = scan.next();
            //Appending 5 spaces to match the morse code length
            morseString = morseString + "     ";
            inputMorseList.add(morseString);
        }
        
        System.out.println("String : " +generateString(inputMorseList));
        
    }
}
