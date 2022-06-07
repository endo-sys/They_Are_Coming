package main.Enemyspawner;

import main.Gameobject.bomberenemy;
import main.Spacegame;
import processing.core.PApplet;

public class bomberspawner {
   private PApplet parent;
   private float spawnercooldownmin;
   private float spawnercooldownmax;
   private float spawnerleftime;

public  bomberspawner(PApplet parent,float cooldownmin,float cooldownmax){
    this.parent=parent;
    this.spawnercooldownmin=cooldownmin;
    this.spawnercooldownmax=cooldownmin;
    this.spawnerleftime= parent.random(cooldownmin,cooldownmax);
}
public void  spawn(){
spawnerleftime-=1062;
    if (spawnerleftime<=0){
   bomberenemy bm1= new bomberenemy(parent,"bomber", Spacegame.bombacıresmi,0,0,1.7f);
   bomberenemy bm2 = new bomberenemy(parent,"bomber",Spacegame.bombacıresmi,parent.width-Spacegame.bombacıresmi.width,0,1.7f);
    int a= (int)parent.random(0,2);
    if (a==1){
        Spacegame.bombers.add(bm2);
    }
    else {

   Spacegame.bombers.add(bm1);}
this.spawnerleftime= parent.random(spawnercooldownmin,spawnercooldownmax);
}
}}
