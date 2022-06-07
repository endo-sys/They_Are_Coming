package main.Boxcollider;

import processing.core.PApplet;
import processing.core.PVector;

public class collisionbox {
    private PApplet parent;
    private PVector pos;
    private PVector imagesize;

    public collisionbox(PApplet parent,PVector pos,PVector imagesize){
        this.parent=parent;
        this.pos=pos;
        this.imagesize=imagesize;
    }
    public boolean collationsdecettor(collisionbox a){
        return (pos.x <a.pos.x +a.imagesize.x&&pos.x+imagesize.x>a.pos.x&&pos.y<a.pos.y+imagesize.y&&pos.y+imagesize.y>a.pos.y);
    }
    public void movecollationsdecettor(PVector a){
        this.pos= a;

    }
    public void show_collation(){
        parent.push();
        parent.stroke(0,255,0);
        parent.noFill();
        parent.rect(pos.x,pos.y, imagesize.x, imagesize.y);
        parent.pop();
    }
}


