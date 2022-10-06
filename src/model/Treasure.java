package model;

/**
 * This class represents a treasure in the game.
 * @author Yeison Antonio Rodriguez Zuluaga
 * @version 1.10.2022
 */
public class Treasure {

    private String name;
    private String url;
    private int addScore;
    private int positionX;
    private int positionY;

    /**
     * <b>Constructor</b><br>
     * This method is the constructor of the class Treasure.<br>
     * <b>pre:</b> The parameters must be initialized.<br>
     * <b>post:</b> A new object of the class Treasure has been created.<br>
     * @param name The name of the treasure.
     * @param url The url of the image that represents  the treasure.
     * @param addScore The score added by the treasure.
     * @param positionX The position of the treasure in the x-axis.
     * @param positionY The position of the treasure in the y-axis.
     */
    public Treasure(String name, String url, int addScore, int positionX, int positionY){
        this.name = name;
        this.url = url;
        this.addScore = addScore;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    
    /**
     * <b>Getter.</b><br>
     * @return name The name of the treasure.
     */
    public String getName(){
        return name;
    }

    
    /**
     * <b>Getter.</b><br>
     * @return The url of the image that represents the treasure.
     */
    public String getUrl(){
        return url;
    }

    
    /**
     * <b>Getter.</b><br>
     * @return The score added by the treasure.
     */
    public int getAddScore(){
        return addScore;
    }

    
    /**
     * <b>Getter.</b><br>
     * @return The position of the treasure in the x-axis.
     */
    public int getPositionX(){
        return positionX;
    }

    
    /**
     * <b>Getter.</b><br>
     * @return The position of the treasure in the y-axis.
     */
    public int getPositionY(){
        return positionY;
    }

    
    /**
     * <b>Setter.</b><br>
     * @param name The name of the treasure.
     */
    public void setName(String name){
        this.name = name;
    }

    
    /**
     * <b>Setter.</b><br>
     * @param url the url of the image that represents the treasure.
     */
    public void setUrl(String url){
        this.url = url;
    }

    
    /**
     * <b>Setter.</b><br>
     * @param addScore The score added by the treasure.
     */
    public void setAddScore(int addScore){
        this.addScore = addScore;
    }

    
    /**
     * <b>Setter.</b><br>
     * @param positionX The position of the treasure in the x-axis.
     */
    public void setPositionX(int positionX){
        this.positionX = positionX;
    }

    
    /**
     * <b>Setter.</b><br>
     * @param positionY The position of the treasure in the y-axis.
     */
    public void setPositionY(int positionY){
        this.positionY = positionY;
    }

    
    /**
     * <b>toString</b><br>
     * This method returns the information of the treasure.
     * @return The information of the treasure.
     */
    public String toString (){
        return "Name "+ name + " Url " + url + " AddScore " + addScore + " Position " + positionX + " " + positionY;
    }
    
}
