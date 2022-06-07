package main.Enemyspawner;

import main.Gameobject.enemy;
import main.Spacegame;
import processing.core.PApplet;

import java.util.ArrayList;


public class Enemyspawner {
    public static PApplet father;
private static ArrayList<enemy> enemies1 ;

    private float maxcooldown;
    private float mincooldown;
    private float lefttime;






    public Enemyspawner(PApplet parent, float mincooldown, float maxcooldown) {
        this.father = parent;
        this.maxcooldown=maxcooldown;
        this.mincooldown = mincooldown;
        lefttime = parent.random(mincooldown, maxcooldown);
enemies1 = new ArrayList<enemy>();


    }

    public void update() {
        lefttime-=1066;


        if (lefttime<=0) {
            enemy enemy2 = new enemy(father, Spacegame.düşmanresmi, Spacegame.tagenemy, father.random(Spacegame.düşmanresmi.width,father.width-Spacegame.düşmanresmi.width), -150, 1.4f);
            Spacegame.emenies.add(enemy2);
            this.lefttime = father.random(mincooldown, maxcooldown);


        }



}
public static void spawn(){
    for(int j=enemies1.size()-1;j>=0;j--){
        enemies1.get(j).render();}
}
public static  void act(){
    for (int i=enemies1.size()-1;i>=0;i--){
        if (enemies1.get(i).getHealth()<=0||enemies1.get(i).getPos().y>father.height- Spacegame.düşmanresmi.height){
            enemies1.remove(i);



            Spacegame.p1.scoresup(10);
        }
        else {
            enemies1.get(i).act();
        }
    }
}
}



















