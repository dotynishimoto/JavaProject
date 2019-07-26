import java.util.Scanner;
/**
 * The game
 * 
 * @author Douglas Torita Nishimoto
 * @version 15 Devember 2015
 */
public class Game
{
    private Scanner keybd;
    private Keyword word;

    /**
     * Constructors
     */
    public Game()
    {
        keybd=new Scanner(System.in);
    }

    
    /**
     * method to let the first player choose a word.
     */
    public void setWord(){
        System.out.println("Choose a word: ");
        word=new Keyword(keybd.next());
        System.out.println("Your word: " + word.getWord()+ " has been saved.");
        System.out.println("");
        System.out.println("");

    }

    
    /**
     * where the game begins
     */
    public void gameIteration(){
        /**
         * in case when the 2 player already lost and try to guess a character again.
         */
        if(word.countError()>=5){
            System.out.println("You already lost the game.");
           return;
        }
        
        /**
         * in case when the 2 player already won and try to guess a character again.
         */
        else if(word.completed()){
        System.out.println("You already won!");
        return;}
        
        /**
         * the 2 player will enter a character
         */
        String input;
        System.out.println("Choose a character: ");
        input=keybd.next();
        System.out.println("");
        
        

        /**
         * if it is a 1 character will run
         */
        if(input.length()==1){
            /**
             * if it is a right character it will appear this message, 
             */
            if(word.TryChar(input.charAt(0))){
                System.out.println("Congratulations, you got a character"); 
            }
            
            /**
             * if it is wrong will appear this message
             */
            else{
                System.out.println("Wrong, keep trying!");
            
            }
            
            /**
             * calling the methods from the other class
             */
             System.out.println(word.getMaskedText());
             System.out.println("You have: "+word.countError()+ " mistakes.");
             System.out.println("Characters that has been typed but not right: "+word.getWrong());
             System.out.println("-------------------------------------------------------");
        }
        /**
         * if the 2 player types more than 1 character
         */
            else{
                System.out.println("Please type only 1 character.");
            }
            
            /**
             * You have 5 chances, if you miss them you lose the game
             */
           if(word.countError()>=5){
            System.out.println("You lost the game.");
           
        }
        /**
         * if you guess right all the characters you win the game
         */
        else if(word.completed()){
        System.out.println("Congratulaions! You won!");}
        }
        

    }
