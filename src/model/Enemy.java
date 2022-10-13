package model;

/**
 * This class represents an enemy in the game.<br>
 * @author Yeison Antonio Rodriguez Zuluaga
 */
public class Enemy {


    private String name;
    private int subtractedScore;
    private int addedScore;
    private int positionX;
    private int positionY;
    private EnemyType type;

    /**
     * <b>Constructor</b><br>
     * This method is the constructor of the class Enemy.<br>
     * <b>pre:</b> The parameters must be initialized.<br>
     * <b>post:</b> A new object of the class Enemy has been created.<br>
     * @param name name of the enemy.
     * @param typeNumber A number that represents the type of the enemy.
     * @param subtractedScore score subtracted by the enemy.
     * @param addedScore score added by the enemy.
     * @param positionX position x of the enemy.
     * @param positionY position y of the enemy.
     */
    public Enemy(String name, int typeNumber, int subtractedScore, int addedScore, int positionX, int positionY){
        this.name = name;
        switch(typeNumber){
            case 1:
                type = EnemyType.OGRE;
                break;
            case 2:
                type = EnemyType.ABSTRACT;
                break;
            case 3:
                type = EnemyType.BOSS;
                break;
            case 4:
                type = EnemyType.MAGIC;
                break;
        }
        this.subtractedScore = subtractedScore;
        this.addedScore = addedScore;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    /**
     * <b>calculateEnemyType</b><br>
     * This method return the type of an enemy converted to a integer.<br>
     * <b>pre:</b> The enemy must be initialized.<br>
     * <b>post:</b> The type of the enemy has been returned as an integer.<br>
     * @return The type of the enemy converted to a integer.
     */
    public int calculateEnemyType() {
        switch (type) {
            case OGRE:
                return 1;
            case ABSTRACT:
                return 2;
            case BOSS:
                return 3;
            case MAGIC:
                return 4;
        }
        return 0;
    }

    /**
     * <b>calculateConsonants</b><br>
     * This method calculate the number of consonants in the name of an enemy.<br>
     * <b>pre:</b> The enemy must be initialized.<br>
     * <b>post:</b> The number of consonants in the name of the enemy has been returned.<br>
     * @return the quantity of the consonant in the name of the enemy.
     */
    public int calculateConsonants() {
        int consonants=0;
        for(int i=0; i<name.length(); i++) {
            if(name.charAt(i)!='a' && name.charAt(i)!='e' && name.charAt(i)!='i' && name.charAt(i)!='o' && name.charAt(i)!='u') {
                consonants++;
            }
        }
        return consonants;

    }

    /**
     * <b>Getter.</b><br>
     * @return the name of the enemy.
     */
    public String getName(){
        return name;
    }

    
    /**
     *<b>Getter.</b><br>
     * @return the type of the enemy.
     */
    public EnemyType getType(){
        return type;
    }

    
    /**
     * <b>Getter.</b><br>
     * @return score that the player loses when he collides with the enemy.
     */
    public int getSubtractedScore(){
        return subtractedScore;
    }

    /**
     * <b>Getter.</b><br>
     * @return The score that the player gains when he kills the enemy.
     */
    public int getAddedScore(){
        return addedScore;
    }

    
    /**
     * <b>Getter.</b><br>
     * @return The position of the enemy in the x-axis.
     */
    public int getPositionX(){
        return positionX;
    }

    
    /**
     * <b>Getter.</b><br>
     * @return The position of the enemy in the y-axis.
     */
    public int getPositionY(){
        return positionY;
    }

    
    /**
     * <b>Setter.</b><br>
     * @param name name of the enemy.
     */
    public void setName(String name){
        this.name = name;
    }

    
    /**
     * <b>Setter.</b><br>
     * @param type type of the enemy.
     */
    public void setType(EnemyType type){
        this.type = type;
    }

    
    /**
     * <b>Setter.</b><br>
     * @param subtractedScore score that the player loses when he collides with the enemy.
     */
    public void setSubtractedScore(int subtractedScore){
        this.subtractedScore = subtractedScore;
    }

    
    /**
     * <b>Setter.</b><br>
     * @param addedScore score that the player gains when he kills the enemy.
     */
    public void setAddedScore(int addedScore){
        this.addedScore = addedScore;
    }

    
    /**
     * <b>Setter.</b><br>
     * @param positionX position of the enemy in the x-axis.
     */
    public void setPositionX(int positionX){
        this.positionX = positionX;
    }

    
    /**
     * <b>Setter.</b><br>
     * @param positionY position of the enemy in the y-axis.
     */
    public void setPositionY(int positionY){
        this.positionY = positionY;
    }

    
    /**
     * <b>toString</b><br>
     * This method returns the information of the enemy.<br>
     * @return A message with the information of the enemy.
     */
    public String toString(){
        return  "Name: " + name + "\nType: " + type + "\nSubtracted Score: " + subtractedScore + "\nAdded Score: " + addedScore + "\nPosition: " + positionX + ", " + positionY + "\n";

    }  
    
}
