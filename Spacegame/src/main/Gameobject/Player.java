package main.Gameobject;

import main.Boxcollider.collisionbox;
import main.Spacegame;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

import static main.Spacegame.*;
import static processing.core.PApplet.println;

public class Player extends gameobject{
    private collisionbox collisionbox1;
   private float  speed;


    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getSpeed() {
        return speed;
    }

    private double health;

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    private int score;

    public void setScore(int score) {
        this.score = score;
    }

    int cooldown=30;
    float lefttime;

    public Player(PApplet parent,PImage image,String tag,float x,float y,float speed){
        super(parent,image,true,tag,x,y);

        this.speed= speed;
        this.health = 180;
        this.score = 0;
        this.lefttime=0;
        collisionbox1 = new collisionbox(parent,pos, new PVector(image.width,image.height));

    }
    public void render(){
        super.render();
    }
    public void move(){
        if (this.health<=0){
            println("died");
        }
        else {
collisionbox1.show_collation();
        if(lefttime>0)lefttime--;

        if (controls[0])pos.y -= speed*Spacegame.getDeltatime();
        if (controls[2])pos.y += speed*Spacegame.getDeltatime();
        if (controls[1])pos.x -= speed*Spacegame.getDeltatime();
        if (controls[3]) pos.x += speed*Spacegame.getDeltatime();



        if(controls[4])
            fire();
        collisionbox1.movecollationsdecettor(pos);
        for(laser l: lasers){
            if (l.tag==tag==false&&collisionbox1.collationsdecettor(l.collisionbox1)){
                health-=l.damage;
                l.health-=10;
            }
        }
        for (bomb b: Spacegame.bombs){
            if (collisionbox1.collationsdecettor(b.collisionbox1)){
                health-=b.damage;
                b.health-=b.damage;
            }
        }
        for (fastest_enemy fs:fs1s){
            if (collisionbox1.collationsdecettor(fs.getColllsionbox1())){
                health-=30;
                fs.setHealth(0);

            }
        }

    }}
    public void fire(){
        if(lefttime<=0){
            laser laser1 = new laser(parent,Spacegame.laserresmi,tag,pos.x+image.width/2-Spacegame.laserresmi.width/2,pos.y-Spacegame.laserresmi.height*0.75f,-15f,15);
            lasers.add(laser1);
            lefttime=cooldown;
        }
    }


    public int getScore() {
        return score;
    }
    public int scoresup(int score){
        this.score+=score;
        return score;

    }
}


