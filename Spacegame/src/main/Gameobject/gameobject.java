package main.Gameobject;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class gameobject {
     protected PApplet parent;
     protected  String tag;
     protected  boolean alive;

    public PApplet getParent() {
        return parent;
    }

    public void setParent(PApplet parent) {
        this.parent = parent;
    }

    protected PVector pos;

    public PVector getPos() {
        return pos;
    }

    public void setPosx(float x) {
        this.pos.x=x;
    }
    public void setPosy(float y){
        this.pos.y=y;
    }

    protected PImage image;


    public PImage getImage() {
        return image;
    }

    public void setImage(PImage image) {
        this.image = image;
    }

    public gameobject(PApplet parent, PImage image,boolean alive,String tag, float x, float y){
        this.parent=parent;
        this.image = image;
        this.tag=tag;
        this.pos = new PVector(x,y);
        this.alive=alive;
    }
    public void render(){
        parent.image(image,pos.x,pos.y);
    }
public void act(){

}
}

