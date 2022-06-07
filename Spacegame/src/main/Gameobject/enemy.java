package main.Gameobject;

import main.Boxcollider.collisionbox;
import main.Spacegame;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

import static main.Spacegame.lasers;


public class enemy extends gameobject{
    private collisionbox collisionbox1;
    private float  speed;
    private float health;

    public float getHealth() {
        return health;
    }

   private float lefttime;
    private float cooldownMax = 17000;
   private float cooldownMin = 10000;
    public enemy(PApplet parent, PImage image, String tag,float x, float y, float speed){
        super(parent,image,true,tag,x,y);
        this.health=10;
        this.speed=speed;
        this.collisionbox1 = new collisionbox(parent,pos,new PVector(image.width,image.height));
        lefttime= parent.random(cooldownMin, cooldownMax);
    }
    public void render(){
        super.render();

    }
    public void moveandfire(){
        super.act();

        lefttime -=150;
        if (pos.y<=parent.height){
            pos.y += speed;
        ateş();}







        for(laser l: lasers){
            if (l.tag==tag==false&&collisionbox1.collationsdecettor(l.collisionbox1)){
                health-=l.damage;
                l.health-=l.damage;
            }}
    }
    public void ateş() {
        if (lefttime <= 0) {
                laser laser = new laser(parent, Spacegame.laserresmi,tag,
                        pos.x + image.width / 2 -Spacegame.laserresmi.width / 2,
                    pos.y + Spacegame.laserresmi.height*1.5f , 4,10);
            Spacegame.lasers.add(laser);


            lefttime = parent.random(cooldownMin, cooldownMax);


    }
}}
