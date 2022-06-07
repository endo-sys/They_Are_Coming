package main.Gameobject;

import main.Boxcollider.collisionbox;
import main.Spacegame;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

import static main.Spacegame.lasers;

public class fastest_enemy extends  gameobject {
    private float speed;
    private float health;

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public collisionbox getColllsionbox1() {
        return colllsionbox1;
    }

    private collisionbox colllsionbox1;



    public fastest_enemy(PApplet parent, PImage img,String tag, float x, float y, float speed,float health) {
        super(parent, img,true,tag, x, y);
        this.speed = speed;
        this.colllsionbox1= new collisionbox(parent,pos,new PVector(img.width,img.height));
        this.health= health;


    }

    public void render() {
        super.render();
    }

    public void act() {



        colllsionbox1.show_collation();
        pos.x=Spacegame.p1.pos.x;
        pos.y+=speed;
        colllsionbox1.movecollationsdecettor(pos);
            for(laser l: lasers){
                if (l.tag==tag==false&&colllsionbox1.collationsdecettor(l.collisionbox1)){
                    health-=l.damage;
                    l.health-=l.damage;
                }}
        }}







