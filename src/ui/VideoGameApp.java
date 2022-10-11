package ui;
import java.util.Scanner;
import model.VideoGame;

/**
 *  This class is the main class of the application.
 *  It creates a new instance of the videogame and allows the user to interact with it.
 * @author Yeison Antonio Rodriguez Zuluaga
 */
public class VideoGameApp {

    /**
     * A global variable that is used to read the user's input.
     */
    public static Scanner sc = new Scanner(System.in);
    
    private VideoGame vg;

    public VideoGameApp() {
        System.out.println("Welcome to the video game!\nplease,enter the name of the game:");
        String name = sc.nextLine();
        vg = new VideoGame(name);
    }
    /**
     *This is the main method of the application.<br>
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        VideoGameApp vga = new VideoGameApp();
        int option;
        do{
            System.out.println("1. Create a new player\n2. Create a new enemy and assign it to a level");
            System.out.println("3. Create a new treasure and assign it to a level\n4. Modify the score af a player\n5. increase the level of a player\n6.Show the treasures and enemies of a level");
            System.out.println("7.Show the quantity of an especific treasure in all levels\n8.Show the quantity of an especific enemy type in all levels\n9.Show the name of the most common treasure in all levels");
            System.out.println("10.Show the enemy with the highest score and its level\n11.Show the quantity of consonants in the name of all the enemies\n12.Show a top 5 of the players with the highest score");
            System.out.println("13.Exit");
            System.out.println("Type a number to select an option");
            option = sc.nextInt();
            switch(option){  
                case(1):
                    vga.addPlayer();
                    break;
                case(2):
                    vga.addEnemy();
                    break;
                case(3):
                    vga.addTreasure();
                    break;
                case(4):
                    vga.changePlayerScore();
                    break;
                case(5):
                    vga.changePlayerLevel();
                    break;
                case(6):
                    vga.showTreasuresAndEnemies();
                    break;
                case(7):
                    vga.showTreasuresQuantity();
                    break;
                case(8):
                    vga.showEnemiesPerType();
                    break;
                case(9):
                    vga.mostCommonTreasure();
                    break;
                case(10):
                    vga.biggestEnemy();
                    break;
                case(11):
                    vga.countConsonants();
                    break;
                case(12):
                    vga.topFive();
                    break;
                case(13):
                    System.out.println("Thank you for using the app\nGoodbye...");
                    break;
                default:
                    System.out.println("Please enter a valid option\n");
                    break;
        }
        }while(option != 13);
    }

    /**
     * <b>addPlayer</b><br>
     * This method allows the user to create a new player.
     */
    public  void addPlayer(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the name of the player");
        String name = sc.nextLine();
        System.out.println("Please enter the nickname of the player");
        String nickName = sc.nextLine();
        String message = vg.addPlayer(name, nickName);
        System.out.println(message);
    }

    /**
     * <b>addEnemy</b><br>
     * This method allows the user to create a new enemy and assign it to a level.
     */
    public void addEnemy(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the name of the enemy");
        String name = sc.nextLine();
        System.out.println("Please enter a number to select the type of the enemy");
        int type;
        do{
            System.out.println("1.Ogre\n2.Abstract\n3.Boss\n4.boss");
            type = sc.nextInt();
            if (type<1 || type>4){
                System.out.println("Please enter a valid number");
            }
        }while(type<1 || type>4);
        System.out.println("Please enter the score that will be substracted to the player");
        int substractedScore = sc.nextInt();
        System.out.println("Please enter the score that will be added to the player");
        int addedScore = sc.nextInt();
        sc.nextLine();
        System.out.println("Please enter the level in which the enemy will be added");
        String level = sc.nextLine();
        String message = vg.addEnemy(name, type, substractedScore, addedScore, level);
        System.out.println(message);

    }

    /**
     * <b>addTreasure</b><br>
     * This method allows the user to create a new treasure and assign it to a level.
     */
    public void addTreasure(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the name of the treasure");
        String name = sc.nextLine();
        System.out.println("Please enter the URL of the image of the treasure");
        String url = sc.nextLine();
        System.out.println("Please enter the score that will be added to the player");
        int addedScore = sc.nextInt();
        sc.nextLine();
        System.out.println("Please enter the level in which the treasure will be added");
        String level = sc.nextLine();
        System.out.println("Please enter the amount of treasures that will be added to the level, if you want to add only one treasure, please enter 1");
        System.out.println("please do not enter numbers smaller than 1");
        int amount;
        do{
            amount = sc.nextInt();
            if (amount<1){
                System.out.println("Please enter a valid number");
            }
        }while(amount<1);
        sc.nextLine();
        String message = vg.addTreasure(name, url, addedScore, level,amount);
        System.out.println(message);
    }

    /**
     * <b>changePlayerScore</b>
     * This method allows the user to modify the score of a player.
     */
    public void changePlayerScore(){
        int score=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the nickname of the player");
        String nickName = sc.nextLine();
        do{
            System.out.println("Please enter the new score of the player");
            score = sc.nextInt();
            if (score<0){
                System.out.println("The score can't be negative");
            }
        }while(score<0);

        String message = vg.ChangePlayerScore(nickName, score);
        System.out.println(message);
    }

    /**
     * <b>changePlayerLevel</b><br>
     * This method allows the user to increase the level of a player.
     */
    public void changePlayerLevel(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the nickname of the player");
        String nickName = sc.nextLine();
        String message = vg.changePlayerLevel(nickName);
        System.out.println(message);
    }

    /**
     * <b>showTreasuresAndEnemies</b><br>
     * This method allows the user to see the treasures and enemies of a level.
     */
    public void showTreasuresAndEnemies(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the level in which the treasures and enemies will be shown");
        String level = sc.nextLine();
        String message = vg.enemiesAndTreasures(level);
        System.out.println(message);
    }

    /**
     * <b>showTreasuresQuantity</b><br>
     * This method allows the user to see the amount of treasures of a level.
     */
    public void showTreasuresQuantity(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the name of the treasure");
        String name = sc.nextLine();
        String message = vg.treasureAmount(name);
        System.out.println(message);
    }

    /**
     * <b>showEnemiesPerType</b><br>
     * This method allows the user to see the amount of enemies of a type.
     */
    public void showEnemiesPerType(){

        int type;
        System.out.println("Please enter a number to select the type of the enemy");
        do {
            System.out.println("1.Ogre\n2.Abstract\n3.Boss\n4.boss");
            type = sc.nextInt();
            if (type < 1 || type > 4) {
                System.out.println("Please enter a valid number");
            }
        }while (type < 1 || type > 4);
        System.out.println(vg.totalEnemiesPerType(type));
    }

    /**
     * <b>biggestEnemy</b><br>
     * This method allows the user to see the biggest enemy of a level.
     */
    public void biggestEnemy(){
        System.out.println(vg.biggestEnemy());
    }

    /**
     * <b>countConsonants</b><br>
     * This method allows the user to see the amount of consonants in the name of all the enemies.
     */
    public void countConsonants(){
        System.out.println(vg.countConsonants());
    }

    /**
     *<b>topFive</b><br>
     * This method shows the top five players of the game.
     */
    public void topFive(){
        System.out.println("if there are players with the same score, they will be shown in the order in which they were added");
        System.out.println(vg.topFive());
    }

    /**
     * <b>mostCommonTreasure</b><br>
     * This method shows the most common treasure of the game.
     */
    public void mostCommonTreasure(){
        System.out.println(vg.mostCommonTreasure());
    }
}
