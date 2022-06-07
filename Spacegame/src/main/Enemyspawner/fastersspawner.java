package main.Enemyspawner;

import main.Gameobject.fastest_enemy;
import main.Spacegame;
import processing.core.PApplet;

public class fastersspawner {
    public PApplet father;


    private float maxcooldown;
    private float mincooldown;
    private float lefttime;







    public fastersspawner(PApplet parent, float mincooldown, float maxcooldown) {
        this.father = parent;
        this.maxcooldown=maxcooldown;
        this.mincooldown = mincooldown;
        lefttime = parent.random(mincooldown, maxcooldown);


    }

    public void update() {
        lefttime-=1065;

        if (lefttime<=0) {
            fastest_enemy fs1 = new fastest_enemy(father,Spacegame.fsresmi,"enemy",father.random(father.width-Spacegame.fsresmi.width),-father.height,10,10 );
            Spacegame.fs1s.add(fs1);
            this.lefttime = father.random(mincooldown, maxcooldown);
        }

    }}

