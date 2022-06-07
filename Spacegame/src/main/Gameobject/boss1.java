package main.Gameobject;

import main.Boxcollider.collisionbox;
import main.Spacegame;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class boss1 extends gameobject{
    private float speed;
    private float health;
    private collisionbox collisionbox1;
    private  float lefttimeformissle;
    private int  stage;
    public boss1(PApplet parent, PImage img,boolean alive,float x,float y,String tag){
        super(parent,img,true,tag,x,y);
        this.speed=25;
        this.health= 400;
        collisionbox1 = new collisionbox(parent,pos,new PVector(img.width,img.height));
        lefttimeformissle= parent.random(1050,2500);
        this.stage=1;

    }
public void render(){
        super.render();

}
public void act(){
        super.act();
if (this.stage==1){
        pos.x+=this.speed;
laserloop();
    if (pos.x <=-this.image.width/2 ){
        this.speed=25;
    }
    else if (pos.x - getImage().width/2 > parent.width) {
        this.speed = -25f;
    }
}








    if (Spacegame.time3>200000){
        this.stage=2;
        pos.x=0;
        launchmissle();
    }


    }






    public void  laserloop(){
        if (this.stage==1){

    laser laser = new laser(parent, Spacegame.laserresmi,tag,
            pos.x + 2*image.width /6.3f ,
            pos.y + Spacegame.laserresmi.height*6.8f , 2f,10);
            Spacegame.lasers.add(laser);
}
    }
public void launchmissle(){
lefttimeformissle -= 1055;
if (lefttimeformissle<=0){
missle missle1 = new missle(parent,Spacegame.misslepciture,null,pos.x + 2*image.width /6.3f ,
        pos.y + Spacegame.laserresmi.height*6.8f , -4f,10);
Spacegame.missles.add(missle1);
lefttimeformissle= parent.random(1050,2500);
}
else {
lefttimeformissle= parent.random(1050,2500);}
}
}




