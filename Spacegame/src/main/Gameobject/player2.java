
package main.Gameobject;

import main.Boxcollider.collisionbox;
import main.Spacegame;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class player2 extends Player{
    private collisionbox collisionbox1;
    private float cooldownMin =1000;
    private float cooldownMax = 1500;
    private  float lefttime;
    private float health;
    private String tag ="player";
   public player2(PApplet parent, PImage img,float x,float y,float speed)
    {
        super(parent,img,"player",x,y,speed);
 collisionbox1= new collisionbox(parent,pos,new PVector(img.width,img.height));
        lefttime= parent.random(cooldownMin, cooldownMax);
            }

    public void render() {
        super.render();
    }
    public void hareketet(){
       lefttime-=-1200;
for (int k=Spacegame.lasers.size()-1;k>=0;k--){
    if (Spacegame.lasers.get(k).tag!="player"&&collisionbox1.collationsdecettor(Spacegame.lasers.get(k).collisionbox1)){
        this.health-=Spacegame.lasers.get(k).damage;
        Spacegame.lasers.get(k).health-=Spacegame.lasers.get(k).damage;

    }
}
       collisionbox1.show_collation();
//fire();
        pos.x+=getSpeed();
        if (pos.x<=0){
            setSpeed(4f);



       }

         if (pos.x + getImage().width > parent.width){
             setSpeed(-4f);




        }

        collisionbox1.movecollationsdecettor(pos);


}




    public void fire(){

{
            laser laser1 = new laser(parent,Spacegame.laserresmi,tag,pos.x,pos.x+parent.width/2-Spacegame.laserresmi.width/2,-10,20);
            Spacegame.lasers.add(laser1);
            lefttime=cooldown;


            lefttime = parent.random(cooldownMin,cooldownMax);
    }
}}
