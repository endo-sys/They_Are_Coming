package main.Gameobject;

import main.Boxcollider.collisionbox;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

import static main.Spacegame.lasers;

public class laser extends bomb  {
collisionbox collisionbox1;
String tag;
float health;

    public float getHealth() {
        return health;
    }

    public laser(PApplet parent, PImage picture, String tag, float x, float y, float speed, float damage){
        super(parent,picture,x,y);
        this.speed=speed;
        this.damage=damage;
        this.collisionbox1= new collisionbox(parent,pos,new PVector(picture.width,picture.height));
        this.tag=tag;
        this.health=10;
    }
    public void render(){
        parent.image(picture,pos.x,pos.y);
    }
    public void hareket(){
        collisionbox1.show_collation();
        pos.y+=speed;

        collisionbox1.movecollationsdecettor(pos);
        for(laser l: lasers){
            if (l.tag==tag==false&&collisionbox1.collationsdecettor(l.collisionbox1)){
                health-=l.damage;
            }
    }
}}


