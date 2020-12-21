package DesignPatternsExr.FactoryPattern.core;

import DesignPatternsExr.CommandDesignPattern.command.CommandInterpreter;
import DesignPatternsExr.CommandDesignPattern.command.CommandListener;
import DesignPatternsExr.FactoryPattern.Initializer;
import DesignPatternsExr.FactoryPattern.data.DataStorage;
import DesignPatternsExr.FactoryPattern.model.Enemy;
import DesignPatternsExr.FactoryPattern.model.GameObject;
import DesignPatternsExr.FactoryPattern.model.Player;
import DesignPatternsExr.FactoryPattern.model.Stone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<GameObject> gameObjects;
    public static Player player;
    public static Enemy enemy;
    public static Field field;
    public static Stone stone;


    public static void main(String[] args) throws InterruptedException {

        Scanner scan = new Scanner(System.in);

        gameObjects = Initializer.init();

        for (GameObject gameObject : gameObjects) {
            if (gameObject instanceof Player) {
                player = (Player) gameObject;
            } else if (gameObject instanceof Enemy) {
                enemy = (Enemy) gameObject;
            } else if (gameObject instanceof Field) {
                field = (Field) gameObject;
           }
//            else if (gameObject instanceof Stone) {
//                stone = (Stone) gameObject;
//            }
        }

        CommandListener handler = new CommandInterpreter();

        boolean gameOver = false;

        String input = "";

        while (!gameOver) {
            ArrayList<GameObject> copy = new ArrayList<>(Main.gameObjects);
            for (GameObject gameObject : copy) {
                gameObject.update();
                gameObject.draw();
            }

            Thread.sleep(500);

            System.out.println();
            System.out.println();
            System.out.println("################################################");
            System.out.println("Enter new command:");
            input = scan.nextLine();

            try {
                handler.handelCommand(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            System.out.println();
            System.out.println();
            input = "";
        }
    }
}
