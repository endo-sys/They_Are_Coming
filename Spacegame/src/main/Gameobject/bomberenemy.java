package main.Gameobject;

import main.Boxcollider.collisionbox;
import main.Spacegame;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

import java.util.ArrayList;

import static main.Spacegame.bombs;
import static main.Spacegame.lasers;

public class bomberenemy extends gameobject{
    private float speed;
    private float cooldown=4500.0f;
    private float cooldown2=6000.0f;
    private float health;
    private  float lefttime;
    private ArrayList<bomb>boms;

    public float getHealth() {
        return health;
    }

    private collisionbox collisionbox1;
    public bomberenemy(PApplet parent,String tag, PImage image,float x, float y,float speed){
        super(parent,image,true,tag,x,y);
        this.speed=speed;

        this.health=50;
        collisionbox1= new collisionbox(parent,pos,new PVector(image.width,image.height));
        lefttime= parent.random(cooldown, cooldown2);


    }

    @Override
    public void render() {
        super.render();
    }

public void act(){
        super.act();
    lefttime-=Spacegame.getDeltatime();
collisionbox1.show_collation();
    pos.y+=speed;
    collisionbox1.movecollationsdecettor(pos);
    for(laser l: lasers) {
        if (l.tag == tag == false && collisionbox1.collationsdecettor(l.collisionbox1)) {
            health -= l.damage;
            l.health -= 10;
        }}

    dropbomb();

    }


public void dropbomb(){
if (lefttime<=0){
bomb bomb1 = new bomb(parent, Spacegame.bombaresmi,pos.x+image.width/2-Spacegame.bombacıresmi.width/2,pos.y-Spacegame.bombacıresmi.height*0.75f);
   bombs.add(bomb1);}

    }}


