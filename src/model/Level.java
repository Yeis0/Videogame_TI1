package model;

/**
 * This class represents a level of the game<br>
 * @author Yeison Antonio Rodriguez Zuluaga
 */
public class Level {
    private String name;
    private int score;
    private LevelDifficulty difficulty;

    private Treasure[] treasures;
    private Enemy[] enemies;

    /**
     * <b>Constructor.</b><br>
     * This method is the constructor of the class Level.<br>
     * <b>pre:</b>The parameters must be inicialized<br>
     * <b>post:</b>A new object of the class Level has been created<br>
     * @param name The name of the level.
     * @param score The score needy to pass to the next level.
     */
    public Level(String name, int score){
        this.name = name;
        this.score = score;
        treasures = new Treasure[50];
        enemies = new Enemy[25];
    }


    /**
     * <b>addEnemy</b><br>
     * This method allows to add an enemy to the level.<br>
     * <b>pre:</b>All tghe parameters must be initialized.<br>
     * <b>post:</b>The enemy has been added to the level.<br>
     * @param name The name of the enemy.
     * @param type The type of the enemy.
     * @param subtractedScore The score that the enemy subtracts to the player.
     * @param addedScore The score that the enemy adds to the player.
     * @param positionX The  position in the x axis of the enemy.
     * @param positionY The position in the y axis of the enemy.
     * @return a message that indicates if the enemy was added or not.
     */
    public String addEnemy(String name, int type, int subtractedScore, int addedScore, int positionX, int positionY){
        String msg = "enemy added succesfully";
        boolean added = false;
        Enemy obj= searchEnemy(name);
        if (obj!=null){
            msg = "the enemy already exists in this level";
        }else{

            obj = new Enemy(name, type, subtractedScore, addedScore, positionX, positionY);
            boolean disponibility = isAvailableEnemy();
            if (disponibility){
                for (int i = 0; i < enemies.length&& !added; i++) {
                    if (enemies[i]==null){
                        enemies[i]=obj;
                        added=true;
                        calculateDifficulty();
                    }
                }
            }else{
                msg = "the level is full";
            }

        }
        return msg;
    }

    /**
     * <b>searchEnemy</b><br>
     * This method allows to search an enemy in the level.<br>
     * <b>pre:</b>The name must be initialized.The array enemies must be initialized.<br>
     * <b>post:</b>The enemy has been searched.<br>
     * @param name The  name of the enemy.
     * @return The enemy object that was found.
     */
    public Enemy searchEnemy(String name){
        Enemy obj = null;
        boolean found = false;
        for (int i = 0; i < enemies.length && !found; i++) {
            if (enemies[i]!=null && enemies[i].getName().equalsIgnoreCase(name)){
                obj = enemies[i];
                found = true;
            }
        }
        return obj;
    }

    
    /**
     * <b>isAvailableEnemy</b><br>
     * This method allows to determine if there is an available space in the level to add an enemy.<br>
     * <b>pre:</b>The array enemies must be initialized.<br>
     * <b>post:</b>The availability has been determined.<br>
     * @return a boolean that indicates if there is an available space or not.
     */
    public boolean isAvailableEnemy(){
        boolean available = false;
        for (int i = 0; i < enemies.length&&!available; i++) {
            if (enemies[i]==null){
                available = true;
            }
        }
        return available;
    }

    /**
     * <b>addTreasure</b><br>
     * This method allows to add a treasure to the level.<br>
     * <b>pre:</b>All the parameters must be initialized.The array treasures must be initialized.<br>
     * <b>post:</b>The treasure has been added to the level.<br>
     * @param name The name of the treasure.
     * @param url An url of the image of the treasure.
     * @param score The score that the treasure adds to the player.
     * @param positionX The position in the x axis of the treasure.
     * @param positionY The position in the y axis of the treasure.
     * @return A message that indicates if the treasure was added or not.
     */
    public String addTreasure(String name,String url,int score, int positionX, int positionY){
        String msg = "treasure added succesfully";
        boolean added=false;
        Treasure obj = new Treasure(name, url,score, positionX, positionY);
        for (int i = 0; i < treasures.length&& !added; i++) {
            if (treasures[i]==null){
                    treasures[i]=obj;
                    added=true;
                    calculateDifficulty();
            }
        }
              
        return msg;
    }

    
    /**
     * <b>searchTreasure</b><br>
     * This method allows to search a treasure in the level.<br>
     * <b>pre:</b>The name must be initialized.The array treasures must be initialized.<br>
     * <b>post:</b>The treasure has been searched.<br>
     * @param name The name of the treasure.
     * @return The treasure object that was found.
     */
    public Treasure searchTreasure(String name){
        Treasure obj = null;
        boolean found = false;
        for (int i = 0; i < treasures.length && !found; i++) {
            if (treasures[i]!=null && treasures[i].getName().equalsIgnoreCase(name)){
                obj = treasures[i];
                found = true;
            }
        }
        return obj;
    }

    /**
     * <b>isAvailableTreasure</b><br>
     * This method allows to determine if there are available spaces in the level to add the treasure that the user indicates.<br>
     * <b>pre:</b>The array treasures must be initialized.The amount of treasures must be initialized.<br>
     * <b>post:</b>The availability has been determined.<br>
     * @param amount the amount of treasures that the user wants to add.
     * @return An boolean that indicates if there are enough available spaces or not.
     */
    public boolean isAvailableAmount(int amount){
        boolean available = false;
        int count=0;
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i]==null){
                count++;
            }
        }
        if (count>=amount){
            available = true;
        }
        
        return available;
    }

    /**
     * <b>sumTreasures</b><br>
     * This method sumes the score of the treasures in the level<br>
     * <b>pre:</b>The array treasures must be initialized.<br>
     * <b>post:</b>The score of the treasures has been summed.<br>
     * @return The sum of the score of the treasures in the level.
     */
    public int sumTreasures(){

        int sum=0;
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i]!=null){
                sum+=treasures[i].getAddScore();
            }
        }
        return sum;
    }

    /**
     * <b>sumEnemies</b><br>
     * This method sumes the score of the enemies in the level<br>
     * <b>pre:</b>The array enemies must be initialized.<br>
     * <b>post:</b>The score of the enemies has been summed.<br>
     * @return The sum of the score of the enemies in the level.
     */
    public int sumEnemies(){

        int sum=0;
        for (int i = 0; i < enemies.length; i++) {
            if (enemies[i]!=null){
                sum+=enemies[i].getAddedScore();
            }
        }
        return sum;
    }

    /**
     * <b>sumEnemies</b><br>
     * This method determine the difficulty of the level based in the score of it's enemies and treasures.<br>
     * <b>pre:</b>The array enemies and treasures must be initialized.<br>
     * <b>post:</b>The difficulty of the level has been determined.<br>
     */
    public void calculateDifficulty(){
        int sumTreasures = sumTreasures();
        int sumEnemies = sumEnemies();
        if (sumTreasures>sumEnemies){
            difficulty = LevelDifficulty.EASY;
        }else if (sumTreasures<sumEnemies){
            difficulty = LevelDifficulty.HARD;
        }else{
            difficulty = LevelDifficulty.MEDIUM;
        }

    }

    /**
     * <b>showEnemies</b>
     * This method allows to show the enemies of the level.<br>
     * <b>pre:</b>The array enemies must be initialized.<br>
     * <b>post:</b>The enemies have been shown.<br>
     * @return A message that indicates the enemies of the level.
     */
    public String showEnemies(){
        String msg = "";
        int count = countEnemies();
        if (count==0) {
            msg = "There are no enemies in this level";
        }else if(count==1) {
            msg = "There is 1 enemy in this level";
            for (int i = 0; i < enemies.length; i++) {
                if (enemies[i]!=null){
                    msg += enemies[i].getName();
                }
            }
        }else{
            msg = "Enemies in this level:\n";
            for (int i = 0; i < enemies.length; i++) {
                if (enemies[i]!=null){
                    msg += enemies[i].getName()+", ";
                }
            }
        }
        return msg;
    }

    /**
     * <b>countEnemies</b><br>
     * This method allows to count the enemies of the level.<br>
     * <b>pre:</b>The array enemies must be initialized.<br>
     * <b>post:</b>The enemies have been counted.<br>
     * @return The amount of enemies in the level.
     */
    public int countEnemies(){
        int count=0;
        for (int i = 0; i < enemies.length; i++) {
            if (enemies[i]!=null){
                count++;
            }
        }
        return count;
    }

    /**
     * <b>showTreasures</b><br>
     * This method allows to show the treasures of the level.<br>
     * <b>pre:</b>The array treasures must be initialized.<br>
     * <b>post:</b>A message with the name of the treasures in the level.
     * @return A message that indicates the treasures of the level.
     */
    public String showTreasures(){
        String msg = "";
        int count = countTreasures();
        String[] names = treasuresNames();
        if (count==0) {
            msg = "There are no treasures in this level";
        }else if(count==1) {
            msg = "There is 1 treasure in this level:\n";
            for (int i = 0; i < treasures.length; i++) {
                if (treasures[i]!=null){
                    msg += treasures[i].getName();
                }
            }
        }else{
            msg = "Treasures in this level:\n";
            for (int i = 0; i < names.length; i++) {
                if (names[i]!=null){
                    msg += names[i]+", ";
                }
            }
            msg = msg.substring(0, msg.length()-2)+".";
        }
        return msg;
    }

    /**
     * <b>countTreasures</b><br>
     * This method count the amount of treasures in a level.<br>
     * <b>pre:</b> The array treasures must be initialized.<br>
     * <b>Pos:</b> The amount of treasures has been counted.<br>
     * @return The amount of treasures in the level.
     */
    public int countTreasures(){
        int count=0;
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i]!=null){
                count++;
            }
        }
        return count;
    }

    /**
     * <b>treasureAmount</b>
     * This method allows to know the amount of an especific treasure in the level.<br>
     * <b>pre:</b> The array treasures must be initialized.<br>
     * <b>pos:</b> The amount of the specified treasure have been returned.<br>
     * @param name The name of the treasure to be counted.
     * @return The amount of the specified treasure in the level.
     */
    public int treasureAmount(String name){
        int count=0;
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i]!=null && treasures[i].getName().equalsIgnoreCase(name)){
                count++;
            }
        }
        return count;
    }

    /**
     * <b>totalEnemiesPerType.</b><br>
     * This method counts the amount of enemies of an especific type.<br>
     * <b>pre:</b> The array enemies must be initialized.<br>
     * <b>pos:</b> The amount of the specified enemy type has been counted.<br>
     * @param type The type of the enemy to be counted.
     * @return The amount of the specified enemy type in the level.
     */
    public int totalEnemiesPerType(int type){
        int count=0;
        for (int i = 0; i < enemies.length; i++) {

            if (enemies[i]!=null&&enemies[i].calculateEnemyType()==type){
                count++;
            }
        }
        return count;
    }

    /**
     * <b>treasuresNames</b><br>
     * This method creates a array that contains the names of the treasure in the level.<br>
     * if a treasures appears more than a time in the level, it's name just gonna appears once in the array.<br>
     * <b>pre:</b> The array treasures must be initialized.<br>
     * <b>pos:</b> The array with the names of the treasures has been created.<br>
     * @return An array with the names of the treasures in the level.
     */
    public String[] treasuresNames(){
        int amount=countTreasures();
        String[] treasureNames=new String[amount];
        for (int i=0; i < treasures.length; i++) {
            if (treasures[i]!=null){
                int nameFound = 0;
                for(int k = 0; k < treasureNames.length; k++) {
                    if (treasures[i].getName().equalsIgnoreCase(treasureNames[k])){
                        nameFound++;
                    }if (nameFound==0&&k==treasureNames.length-1) {
                        treasureNames[i] = treasures[i].getName();
                    }
                }
            }
        }
        return treasureNames;
    }

    /**
     * <b>treasuresNameAmount</b><br>
     * This method creates a array that contains the amount of the names of the treasures in the level.<br>
     * <b>pre:</b> The array treasures must be initialized.<br>
     * <b>pos:</b> The array with the amount of the names of the treasures has been created.<br>
     * @return An array with the amount of the names of  treasures in the level.
     */
    public int[] treasuresNameAmount(){
        int amount=countTreasures();
        int[] treasureAmount=new int[amount];
        for (int i=0; i < treasures.length; i++) {
            if (treasures[i]!=null){
                for(int k = 0; k < treasureAmount.length; k++) {
                    if (treasures[i].getName().equalsIgnoreCase(treasuresNames()[k])){
                        treasureAmount[k]++;
                    }
                }
            }
        }
        return treasureAmount;
    }

    /**
     * <b>biggestEnemy</b><br>
     * This method find the enemy with the highest score in the level.<br>
     * <b>pre:</b> The array enemies must be initialized.<br>
     * <b>pos:</b> The enemy with the highest score has been found.<br>
     * @return The enemy with the highest score in the level.
     */
    public Enemy biggestEnemy(){
        Enemy biggest = null;
        for (int i = 0; i < enemies.length; i++) {
            if (enemies[i]!=null){
                if (biggest==null){
                    biggest = enemies[i];
                }else if (enemies[i].getAddedScore()>biggest.getAddedScore()){
                    biggest = enemies[i];
                }
            }
        }
        return biggest;
    }

    /**
     * <b>countEnemyConsonants</b><br>
     * This method count the consonants in the names of all enemies in the level.<br>
     * <b>pre:</b> The array enemies must be initialized.<br>
     * <b>pos:</b> The consonants in the names of all enemies in the level has been counted.<br>
     * @return The consonants in the names of all enemies in the level.
     */
    public int countEnemyConsonants(){
        int count=0;
        for (int i = 0; i < enemies.length; i++) {
            if (enemies[i]!=null){
                count+=enemies[i].calculateConsonants();
            }
        }
        return count;
    }

    /**
     * <b>Getter.</b>
     * @return The name of the level.
     */
    public String getName(){
        return name;
    }

    
    /**
     * <b>Getter.</b>
     * @return The score required to advance to the next level.
     */
    public int getScore(){
        return score;
    }

    
    /**
     * <b>Getter.</b>
     * @return  The difficulty of the level.
     */
    public LevelDifficulty getDifficulty(){
        return difficulty;
    }

    
    /**
     * <b>Getter.</b>
     * @return The array of treasures in the level.
     */
    public Treasure[] getTreasures(){
        return treasures;
    }

    
    /**
     * <b>Getter.</b>
     * @return The array of enemies in the level.
     */
    public Enemy[] getEnemies(){
        return enemies;
    }

    
    /**
     * <b>Setter.</b>
     * @param name The new name of the level.
     */
    public void setName(String name){
        this.name = name;
    }

    
    /**
     * <b>Setter.</b>
     * @param score The new score required to advance to the next level.
     */
    public void setScore(int score){
        this.score = score;
    }

    
    /**
     * <b>Setter.</b>
     * @param difficulty The new difficulty of the level.
     */
    public void setDifficulty(LevelDifficulty difficulty){
        this.difficulty = difficulty;
    }

    
    /**
     * <b>Setter.</b>
     * @param treasures The new array of treasures in the level.
     */
    public void setTreasures(Treasure[] treasures){
        this.treasures = treasures;
    }

    
    /**
     * <b>Setter.</b>
     * @param enemies The new array of enemies in the level.
     */
    public void setEnemies(Enemy[] enemies){
        this.enemies = enemies;
    }

    /**
     * <b>toString</b><br>
     * This method allows to show the information of the level.
     * @return A message with the information of the level.
     */
    public String toString(){
        return  "Name: " + name + " Score: " + score + " Difficulty: " + difficulty;
    }
    
}
