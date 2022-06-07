package main.Gameobject;

import main.Boxcollider.collisionbox;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

import static main.Spacegame.bombaresmi;

public class bomb {
     PApplet parent;
    PVector pos;

    public PVector getPos() {
        return pos;
    }

    float speed;
    PImage picture;
    float damage;
    float health;
    collisionbox collisionbox1;
    public float getHealth() {
        return health;
    }



    public bomb(PApplet parent, PImage picture, float x, float y){
        this.parent=parent;
        pos = new PVector(x,y);
        this.picture=picture;
        this.damage=30;
        this.health=10;
        collisionbox1= new collisionbox(parent,pos,new PVector(picture.width,picture.height));
        this.speed=20;

    }
    public void render(){
        parent.image(bombaresmi,pos.x,pos.y);
    }
    public void act(){


        pos.y+=picture.width;

        collisionbox1.movecollationsdecettor(pos);
    }


    }





