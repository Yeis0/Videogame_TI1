package model;

/**
 * This class represents a player in the game.
 * @author Yeison Antonio Rodriguez Zuluaga
 * @version 1.10.2022
 */
public class Player {

    private String name;
    private String nickName;
    private int score;
    private int lifes;

    private Level currentLevel;


    /**
     * <b>Constructor.</b><br>
     * This method is the constructor of the class Player.<br>
     * <b>pre:</b> The parameters must be initialized.<br>
     * <b>post:</b> A new object of the class Player has been created.<br>
     * @param name The name of the player.
     * @param nickName The nickname of the player.
     * @param level The initial level of the player.
     */
    public Player(String name, String nickName, Level level){
        this.name = name;
        this.nickName = nickName;
        score = 10;
        lifes = 5;
        currentLevel = level;
        
    }
    
    /**
     * <b>Getter.</b><br>
     * @return The name of the player.
     */
    public String getName(){
        return name;
    }

    
    /**
     * <b>Getter.</b><br>
     * @return The nickname of the player.
     */
    public String getNickName(){
        return nickName;
    }

    
    /**
     * <b>Getter.</b><br>
     * @return The score of the player.
     */
    public int getScore(){
        return score;
    }

    
    /**
     * <b>Getter.</b><br>
     * @return The lifes of the player.
     */
    public int getLifes(){
        return lifes;
    }

    /**
     * <b>Getter.</b><br>
     * @return The current level of the player.
     */
    public Level getCurrentLevel(){
        return currentLevel;
    }

    /**
     * <b>Setter.</b><br>
     * @param name The new name of the player.
     */
    public void setName(String name){
        this.name = name;
    }

    
    /**
     * <b>Setter.</b><br>
     * @param nickName The new nickname of the player.
     */
    public void setNickName(String nickName){
        this.nickName = nickName;
    }

    
    /**
     * <b>Setter.</b><br>
     * @param score The new score of the player.
     */
    public void setScore(int score){
        this.score = score;
    }

    
    /**
     * <b>Setter.</b><br>
     * @param lifes The new lifes of the player.
     */
    public void setLifes(int lifes){
        this.lifes = lifes;
    }
    
    /**
     * <b>Setter.</b><br>
     * @param newCurrentLevel The new current level of the player.
     */
    public void setCurrentLevel(Level newCurrentLevel){
        currentLevel = newCurrentLevel;
    }
    
    /**
     * <b>toString</b><br>
     * This methos shows the information of the player.<br>
     * @return A message that indicates if the score was added or not.
     */
    public String toString(){
        return "Name: " + name + " NickName: " + nickName + " Score: " + score + " Lifes: " + lifes + " CurrentlyLevel: " + currentLevel.getName();
    }
    
}
