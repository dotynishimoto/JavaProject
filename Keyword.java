import java.util.ArrayList;
/**
 * Final Project
 * 
 * @author Douglas Torita Nishimoto
 * @version 15 December 2015
 */
public class Keyword
{
    /**
     * fields
     */
    private String word;
    private ArrayList<Character> listMistakes;
    private Boolean[] state;

    /**
     * Constructors
     */
    public Keyword(String anyWord)
    {
        word= anyWord; 
        listMistakes= new ArrayList <>(); //created an arraylist to save the wrong characters guessed
        state= new Boolean[anyWord.length()]; // save the character was guessed right
        for(int index=0; index<word.length(); index++){ 
            state[index]= false;
        }
    }

    /**
     * return the word
     */
    public String getWord(){
        return word;
    }

    /**
     * Try a character
     */
    public Boolean TryChar(Character anyChar){
        Boolean result=false; 
        
        for(int index=0; index<word.length(); index++){ 
            if(anyChar==word.charAt(index)){
                state[index]=true; //save the character was guessed right
                result= true; //return true
                if(listMistakes.contains(anyChar)){
                    listMistakes.remove(anyChar); //remove the character that already passed in the else statement and was kept there
                }
            }

            else{
                if(!listMistakes.contains(anyChar) && !result){

                    listMistakes.add(anyChar);} //keep the character was guessed and was not right
                result = result||false; //return false.
            }
        }
        return result; //return the result
    }

    /**
     * count number of mistakes.
     */
    public int countError(){
        return listMistakes.size(); 
    }

    
    /**
     * method to show the character that was guessed right and its own position.
     */
    public String getMaskedText(){
        String text="";
        for(int index=0; index<word.length(); index++){
            if(state[index]){
                text=text+word.charAt(index);}
            else{
                text=text+" _ ";
            }

        }
        return text;
    }

    
    /**
     * method to make a list of the characters guessed and was not right.
     */
    public String getWrong(){
        String text= "";
        for(Character c: listMistakes){
            text= text +", " +c;
        }
        return text;
    }

    
    /**
     * method when you complete the game
     */
    public Boolean completed(){
        for(int index=0; index<word.length(); index++){
            if(!state[index]){
                return false;}
        }
        return true;
    }

}
