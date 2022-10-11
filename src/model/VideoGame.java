package model;
import java.util.Random;

/**
 * This class contains the information of the game, and is communicated with the user interface.
 * @author Yeison Antonio Rodriguez Zuluaga
 *
 */
public class VideoGame {
    /**
     * A global variable that is a random number generator.
     */
    public static Random random = new Random();

    private String name;
    private int screenResolutionX;
    private int screenResolutionY;

    private Level[] levels;
    private Player[] players;

    /**
     * <b>Constructor</b><br>
     * This method is the constructor of the class VideoGame.<br>
     * <b>Pre:</b> The parameters must be initialized.<br>
     * <b>Post:</b> A new object of the class VideoGame has been created.<br>
     * @param name The name of the game.
     */
    public VideoGame(String name){
        this.name = name;
        levels= new Level[10];
        players = new Player[20];
        screenResolutionX = 1280;
        screenResolutionY = 700;
        fillLevels();
    }

    /**
     * <b>fillLevels</b><br>
     * This method fills the array of levels.<br>
     * <b>Pre:</b> The levels array must be initialized.<br>
     * <b>Post:</b> The levels array has been filled.<br>
     */
    public void fillLevels(){
        int score=11;
        int level=1;
        for(int i = 0; i < levels.length; i++){
            if(i<levels.length-1){
                levels[i] = new Level(String.valueOf(level),score);
                score*=2;
                level++;
            }else if (i==levels.length-1){
                score=Integer.MAX_VALUE;
                levels[i] = new Level(String.valueOf(level),score);
            }  
        }
    } 
    
    /**
     * <b>addPlayer</b><br>
     * This method adds a player to the array of players.<br>
     * <b>Pre:</b> The array players must be initialized. The parameters must be initialized.<br>
     * <b>Post:</b> A new player has been added to the array of players.<br>
     * @param name The name of the player.
     * @param nickName The nickname of the player.
     * @return A message that indicates if the player was added or not.
     */
    public String addPlayer(String name, String nickName){
        String message = "Player added succesfully";
        Player obj= searchPlayer(nickName);
        if (obj!=null){
            message = "The player already exists";
        }else{
            obj = new Player(name, nickName,levels[0]);
            boolean disponibility = isAvailablePlayer();
            if (disponibility){
                boolean added =false;
                for (int i = 0; i < players.length&& !added; i++) {
                    if (players[i]==null){
                        players[i]=obj;
                        added=true;
                    }
                }
            }else{
                message = "The game is full";
            }
        }       
        
        return message;
    }

    /**
     * <b>searchPlayer</b><br>
     * This method searches a player in the array of players.<br>
     * <b>Pre:</b> The array players must be initialized. The parameter must be initialized.<br>
     * <b>Post:</b> The player has been searched.<br>
     * @param nickName The nickname of the player.
     * @return The Player object that was found.
     */
    public Player searchPlayer(String nickName){
        Player obj = null;
        boolean find= false;
        if (players != null) {
            for (int i = 0; i < players.length && !find; i++) {
                if (players[i] != null && players[i].getNickName().equals(nickName)) {
                    obj = players[i];
                    find=true;
                }
            }
        }

        return obj;
    }



    /**
     * <b>isAvailablePlayer</b><br>
     * This method searches a level in the array of levels.<br>
     * <b>Pre:</b> The array players must be initialized.<br>
     * <b>post</b> The availability of the array of players has been searched.<br>
     * @return A boolean that indicates availability in the array of levels.
     */
    public boolean isAvailablePlayer(){
        boolean disponibility = false;
        for (int i = 0; i < players.length && !disponibility; i++) {
            if (players[i]==null){
                disponibility=true;
            }
        }
        return disponibility;
    }

    /**
     * <b>generatePosition</b><br>
     * This method generates a random position in the x or y axis.<br>
     * <b>Pre:</b> The attributes screenResolutionX and screenResolutionY must be initialized.<br>
     * <b>Post:</b> A random position has been generated.<br>
     * @param res the resolution of the screen in one of the axis.
     * @return A random position in the x or y axis.
     */
    public int generatePosition(int res){
        int pos;
        pos= random.nextInt(res+1);
        return pos;

    }

    /**
     * <b>addEnemy</b><br>
     * This method add an enemy to a level.<br>
     * <b>Pre:</b>  the level must exist.<br>
     * <b>Post:</b> The enemy added in the level.<br>
     * @param name The name of the enemy.
     * @param typeNumber a number that indicates the type of enemy.
     * @param subtractedScore The score that is subtracted when the enemy is killed.
     * @param addedScore The score that is added when the enemy is killed.
     * @param levelName The level where the enemy will be added.
     * @return A message that indicates if the enemy was added or not.
     */
    public String addEnemy(String name, int typeNumber, int subtractedScore, int addedScore, String levelName){
        String message="";
        int posx = generatePosition(screenResolutionX);
        int posy = generatePosition(screenResolutionY);
        Level obj = searchLevel(levelName);
        if (obj!=null){
            message = obj.addEnemy(name, typeNumber, subtractedScore, addedScore, posx, posy);
        
        }else{
            message = "The level doesn't exist";
        }
        return message;
    }
    
    /**
     * <b>searchLevel</b><br>
     * This method searches a level in the array of levels.<br>
     * <b>Pre:</b> The array levels must be initialized. The parameter must be initialized.<br>
     * <b>Post:</b> The level has been searched.<br>
     * @param name The name of the level.
     * @return The Level object that was found.
     */
    public Level searchLevel(String name){

        Level obj = null;
        boolean find = false;
        for (int i = 0; i < levels.length && !find; i++) {
            if (levels[i]!=null && levels[i].getName().equals(name)){
                obj = levels[i];
                find = true;
            }
        }
        return obj;

    }

    /**
     * <b>addTreasure</b><br>
     * This method add a treasure to a level.<br>
     * <b>Pre:</b>  the level must exist.<br>
     * <b>Post:</b> The class Level adds the treasure.<br>
     * @param name The name of the treasure.
     * @param url The url of the image that represents the treasure.
     * @param addedScore The score that is added when the treasure is found.
     * @param levelName the level where the treasure will be added.
     * @param treasureAmount The amount of treasures that will be added.
     * @return A message that indicates if the treasures were added or not.
     */
    public String addTreasure(String name, String url, int addedScore, String levelName,int treasureAmount){
        String message="";
        Level obj = searchLevel(levelName);
        if (obj!=null){
            boolean added = obj.isAvailableAmount(treasureAmount);
            if (added){
                do{
                    int posx = generatePosition(screenResolutionX);
                    int posy = generatePosition(screenResolutionY);
                    message = obj.addTreasure(name, url, addedScore, posx, posy);
                    treasureAmount--;
                }while(treasureAmount>0);

            }else{
                message = "The amount of treasures is not available";
            }
        
        }else{
            message = "The level doesn't exist";
        }
        return message;
    }

    /**
     * <b>changePlayerScore</b><br>
     * This method allows to change the score of a player.<br>
     * <b>Pre:</b> The player must exist, the score must be positive<br>
     * <b>Post:</b> The score of the player has been changed.<br>
     * @param nickName The nickname of the player.
     * @param score The new score that will be added to the player.
     * @return A message that indicates if the score was added or not.
     */
    public String ChangePlayerScore(String nickName, int score){
        String message = "Score changed succesfully";

        Player obj = searchPlayer(nickName);
        if (obj!=null){
            obj.setScore(score);
        }else{
            message = "The player doesn't exist";
        }

        return message;
    }

    /**
     * <b>changePlayerLevel</b><br>
     * This method allows to increase the level of a player.<br>
     * <b>Pre:</b> The player must exist, the player must have enough score to increase the level.<br>
     * <b>Post:</b> The level of the player has been increased.<br>
     * @param nickName The nickname of the player.
     * @return A message that indicates if the level was increased or not.
     */
    public String changePlayerLevel(String nickName){
        String message = "Level changed succesfully";
        Player obj = searchPlayer(nickName);
        if (obj!=null){
            Level level = obj.getCurrentLevel();
            int score = obj.getScore();
            
            if(level.getScore()<=score){
                int index=index(level);

                if (index<levels.length-1) {
                    obj.setCurrentLevel(levels[index + 1]);
                    message += " to " + obj.getCurrentLevel().getName();
                }
            }else{
                if (level.getName().equals("10")){
                    message = "The player is in the last level";
                }else{
                    
                    message = "The player doesn't have enough score.";
                    message+=" Missing "+(level.getScore()-score)+" points to reach the next level";
                }
            }
            
        }else
            message = "The player doesn't exist";
        
        return message;
    }

    /**
     * <b>index</b><br>
     * This method searches the index of a level in the array of levels.<br>
     * <b>Pre:</b> The array levels must be initialized. The level must exists in the array.<br>
     * <b>Post:</b> The index has been searched.<br>
     * @param level The level that will be searched.
     * @return The index of the level in the array of levels.
     */
    public int index(Level level){
        int index=0;
        boolean find = false;
        for (int i = 0; i < levels.length && !find; i++) {
            if (levels[i]!=null && levels[i].equals(level)){
                index = i;
                find=true;
            }
        }
        return index;
    }

    /**
     * <b>enemiesAndTreasures</b><br>
     * This method informs the user about the enemies and treasures that are in the level.<br>
     * <b>Pre:</b> The level must exist.<br>
     * <b>Post:</b> The information has been shown.<br>
     * @param levelName The name of the level.
     * @return A message that contains the information.
     */
    public String enemiesAndTreasures(String levelName){
        String message="";
        Level obj = searchLevel(levelName);
        if (obj!=null){
            message = obj.showEnemies()+"\n"+obj.showTreasures();
        }else{
            message = "The level doesn't exist";
        }
        return message;
    }

    /**
     * <b>treasureAmount</b><br>
     * This method informs the user about the amount of an specific treasure in the game.<br>
     * <b>Pre:</b> The treasure must exist.<br>
     * <b>Post:</b> The information has been shown.<br>
     * @param treasureName the name of the treasure.
     * @return A message that contains the information.
     */
    public String treasureAmount(String treasureName){
        int countTreasures=0;
        String message="This treasure doesn't exist";
        for (int i = 0; i < levels.length; i++) {
            if (levels[i]!=null){
                countTreasures+=levels[i].treasureAmount(treasureName);
            }
        }
        if (countTreasures>0){
            message = "There are "+countTreasures+" "+treasureName+" in the game";
        }
        return message;
    }

    /**
     * <b>totalEnemiesPerType</b><br>
     * This method informs the user about the total amount of enemies per type.<br>
     * <b>Pre:</b> The array of enemies must be initialized.<br>
     * <b>Post:</b> The information has been shown.<br>
     * @param type
     * @return
     */
    public String totalEnemiesPerType(int type){
        int countEnemies=0;
        String message="There are no enemies of this type";
        for (int i = 0; i < levels.length; i++) {
            if (levels[i]!=null){
                countEnemies+=levels[i].totalEnemiesPerType(type);
            }
        }
        if (countEnemies>0){
            message = "There are "+countEnemies+" enemies of this type in the game";
        }
        return message;
    }

    /**
     * <b>biggestEnemy</b><br>
     * This method informs the user about the enemy with the biggest score in the game.<br>
     * <b>Pre:</b> The array of enemies must be initialized.<br>
     * <b>Post:</b> The information has been shown.<br>
     * @return
     */
    public String biggestEnemy(){
        String message="There are no enemies in the game";
        int index=-1;
        Enemy enemy=null;
        for(int i=0;i<levels.length;i++){
            if(levels[i]!=null){
                 if (enemy==null){
                     enemy=levels[i].biggestEnemy();
                 }else if(levels[i].biggestEnemy()!=null){
                     if(levels[i].biggestEnemy().getAddedScore()>enemy.getAddedScore()){
                         enemy=levels[i].biggestEnemy();
                         index=i;
                     }
                 }
            }

        }
        if (enemy!=null) {
            message = "The biggest enemy is " + enemy.getName() + " with " + enemy.getAddedScore() + " points and is in the level " + levels[index].getName();
        }
        return message;
    }

    /**
     * <b>countConsonants</b><br>
     * This method counts the consonants in the names of the enemies in the game.<br>
     * <b>Pre:</b> The array of enemies must be initialized.<br>
     * <b>Post:</b> The consonants have been counted.<br>
     * @return
     */
    public String countConsonants(){
        String msg="There are no consonants in the enemies names";
        int count=0;
        for (int i=0;i<levels.length;i++){
            if (levels[i]!=null){
                count+=levels[i].countEnemyConsonants();
            }
        }
        if (count>0){
            msg="There are "+count+" consonants in the enemies names";
        }
        return msg;
    }

    /**
     *<b>topFive</b><br>
     *This method shows the five players with the highest score.<br>
     *if there are less than five players, it shows all the players.<br>
     *if there are players with the same score, it shows them in the orders they were added.<br>
     * <b>Pre:</b> The array of players must be initialized.<br>
     * <b>Post:</b> The players have been shown.<br>
     * @return
     */
    public String topFive(){
        String msg="There are no players in the game";
        Player[] topFive = new Player[5];
         for (int i=0;i<players.length;i++){
                if (players[i]!=null){
                    if (topFive[0]==null){
                        topFive[0]=players[i];
                    }else{
                        for (int j=0;j<topFive.length;j++){
                            if (topFive[j]==null){
                             topFive[j]=players[i];
                             j=topFive.length;
                            }else if (topFive[j].getScore()<players[i].getScore()){
                             for (int k=topFive.length-1;k>j;k--){
                                  topFive[k]=topFive[k-1];
                             }
                             topFive[j]=players[i];
                             j=topFive.length;
                            }
                        }
                    }
                }
          }

        if (topFive[0]!=null){
            msg="The top five players are:\n";
            for (int i=0;i<topFive.length;i++){
                if (topFive[i]!=null){
                    msg+=topFive[i].getNickName()+" with "+topFive[i].getScore()+" points\n";
                }
            }
        }
        return msg;
    }

    /**
     * <b>mostCommonTreasure</b><br>
     * This method shows the treasures that appear the most in the game.<br>
     * <b>Pre:</b> The array of treasures must be initialized.<br>
     * <b>Post:</b> The treasures have been shown.<br>
     * @return
     */
    public String mostCommonTreasure(){
        String msg="There are no treasures in the game";
        String[] treasures = new String[totalTreasures()];
        int[] count = new int[totalTreasures()];
        int biggest=0;
        String biggestName="";
        for (int i=0;i<levels.length;i++){
            if(levels[i]!=null){
                String[] treasuresLevel = levels[i].treasuresNames();
                int[] countTreasuresLevel = levels[i].treasuresNameAmount();
                for (int j=0;j<treasuresLevel.length;j++){
                    if (treasuresLevel[j]!=null){
                        for (int k=0;k<treasures.length;k++){
                            if (treasures[k]!=null&&treasures[k].equalsIgnoreCase(treasuresLevel[j])) {
                                count[k] += countTreasuresLevel[j];
                                k = treasures.length;
                            }else if (treasures[k]==null){
                                treasures[k]=treasuresLevel[j];
                                count[k]=countTreasuresLevel[j];
                                k=treasures.length;
                            }
                        }
                    }
                }
            }
        }

        for (int i=0;i<treasures.length;i++){
            if (treasures[i]!=null){
                if (count[i]>biggest){
                    biggest=count[i];
                    biggestName=treasures[i];
                }

            }
        }

        if (biggestName!=""){
            msg="The treasure that appears the most is "+biggestName+" with "+biggest+" times";
        }

        return msg;
    }

    /**
     * <b>totalTreasures</b><br>
     * This method counts the total amount of treasures in the game.<br>
     * <b>Pre:</b> The array of treasures must be initialized.<br>
     * <b>Post:</b> The treasures have been counted.<br>
     * @return
     */
    public int totalTreasures(){
        int total=0;
        for(int i=0;i<levels.length-1;i++){
            if (levels[i]!=null){
                total+=levels[i].countTreasures();
            }
        }
        return total;
    }
    
    /**
     * <b>Getter</b>.<br>
     * @return The name of the game.
     */
    public String getName(){
        return name;
    }

    /** <b>Getter.</b><br>
     * @return The resolution of the screen in the x-axis.
     */
    public int getScreenResolutionX(){
        return screenResolutionX;
    }

    /**
     * <b>Getter.</b><br>
     * @return The resolution of the screen in the y-axis.
     */
    public int getScreenResolutionY(){
        return screenResolutionY;
    }
    
    /**
     * <b>Getter.</b><br>
     * @return The array of the levels in the game.
     */
    public Level[] getLevels(){
        return levels;
    }
    
    /**
     * <b>Getter.</b><br>
     * @return The array of the players in the game.
     */
    public Player[] getPlayers(){
        return players;
    }

    /**
     * <b>Setter.</b><br>
     * @param name The new name of the game.
     */
    public void setName(String name){
        this.name = name;
    }
    
    /**
     * <b>Setter.</b><br>
     * @param screenResolutionX The new resolution of the screen in the x-axis.
     */
    public void setResolutionX(int screenResolutionX){
        this.screenResolutionX = screenResolutionX;
    }
    
    /**
     * <b>Setter.</b><br>
     * @param screenResolutionY The new resolution of the screen in the y-axis.
     */
    public void setResolutionY(int screenResolutionY){
        this.screenResolutionY = screenResolutionY;
    }

    /**
     * <b>Setter.</b><br>
     * @param levels The new array of the levels in the game.
     */
    public void setLevels(Level[] levels){
        this.levels = levels;
    }

    /**
     * <b>Setter.</b><br>
     * @param players The array of the players in the game.
     */
    public void setPlayers(Player[] players){
        this.players = players;
    }

    /**
     * <b>toString</b><br>
     * This method returns the information of the game.<br>
     * @return A message with the information of the game.
     */
    public String toString(){
        return "Name: "+name+"\nResolution: "+screenResolutionX+"x"+screenResolutionY;
    }
      
}
