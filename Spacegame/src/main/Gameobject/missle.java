package main.Gameobject;

import main.Boxcollider.collisionbox;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

import static main.Spacegame.lasers;
import static main.Spacegame.p1;

public class missle extends bomb{
     private collisionbox collisionbox1;
      private String tag;
     private float health;
    public missle(PApplet parent, PImage picture, String tag, float x, float y, float speed, float damage){
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
        pos.y+=speed;
        pos.x=p1.getPos().x-pos.x;

        collisionbox1.movecollationsdecettor(pos);
        for(laser l: lasers){
            if (l.tag==tag==false&&collisionbox1.collationsdecettor(l.collisionbox1)){
                this.speed=-speed;
            }
        }
    }}