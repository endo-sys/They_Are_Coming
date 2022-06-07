package main;

import main.Enemyspawner.Enemyspawner;
import main.Enemyspawner.bomberspawner;
import main.Enemyspawner.fastersspawner;
import main.Gameobject.*;
import processing.core.PApplet;
import processing.core.PImage;
import processing.sound.SoundFile;
import processing.sound.*;

import java.util.ArrayList;

public class Spacegame extends PApplet {
    public static void main(String []args){
        PApplet.main(new String[]{Spacegame.class.getName()});
    }

    public static PImage startscreen,endscreen, bg, oyuncuresmi,laserresmi,bossremi,düşmanlazeri,düşmanresmi,bombacıresmi,player2resim,bombaresmi,fsresmi,tunahocaresmi,misslepciture;
     public static SoundFile file1;

public static  int time3;
    public static Player p1;
    public static  player2 p2;
    public static PApplet parent;


public  static  ArrayList<fastest_enemy>fs1s;
    public static ArrayList<laser> lasers;
    public static ArrayList<missle>missles;
    public static ArrayList<enemy> emenies;
    public static ArrayList<bomberenemy> bombers;
    public static ArrayList<bomb> bombs;
    public static final String tagplayer="player";
    public static final String tagenemy ="enemy";
    public static float deltatime;
    public static Enemyspawner enemyspawner;
    public static bomberspawner bomberspawner;
    public static fastersspawner fastersspawner;
    public static boss1 boss;
    SoundFile backs;
    SoundFile lsd;



    public  void settings(){
        size(1280,720);
        fullScreen();
        bg = loadImage("res/space.jpg");
        oyuncuresmi =loadImage("res/playership.png");
        player2resim= loadImage("res/player2.png");
        bombaresmi= loadImage("res/bomb1.png");
        laserresmi= loadImage("res/laser.png");
        fsresmi = loadImage("res/fs1.png");
        düşmanresmi = loadImage("res/enemyRed2.png");
        bombacıresmi= loadImage("res/bombacı.png");
        bossremi= loadImage("res/boss.png");
        misslepciture = loadImage("res/MİSSLE.png");
        p1 = new Player(this,oyuncuresmi,tagplayer,width/2-oyuncuresmi.width/2,height-oyuncuresmi.height,2.0f);
        p2 = new player2(this,player2resim,width/2-player2resim.width/2,height-player2resim.height,3.5f);
        boss = new boss1(this,bossremi,true,width,-300+ bossremi.height,"enemy");
        lasers = new ArrayList<laser>();
        missles= new ArrayList<missle>();
        emenies= new ArrayList<enemy>();
        bombers= new ArrayList<bomberenemy>();
        fs1s = new ArrayList<fastest_enemy>();
        bombs= new ArrayList<bomb>();
        time1= millis();
        lsd = new SoundFile(this,"res/lasersound.wav");


    }
    int stage = 0;

    public void  setup(){
        stage = 1;
        SoundFile backs;
        SoundFile lsd;
        startscreen = loadImage("res/startscreen.jpg");
       wrap(startscreen,-240,-80,startscreen.width,startscreen.height);

        // backs= new SoundFile(this, "res/song.wav");

        //backs.play();



    }


    float time1,time2;
   public void draw() {
       if(stage==1) {




           textAlign(CENTER);
           textSize(64);
           fill(0, 255, 0);
           text("USE (W-A-S-D) BUTTONS TO MOVE!", 720, 350);

           text("USE (SPACE) BUTTON TO FIRE!", 720, 425);
           fill(255, 255, 255);
           text("KILL AS MANY ENEMIES AS YOU CAN", 720, 500);
           fill(500, 0, 0);
           text("UNTIL YOU ARE DEAD!", 720, 575);
           fill(500, 255, 0);
           text("GOOD LUCK!",720,650);
           fill(255, 255, 255);
           text("PRESS (SPACE or MOUSE) BUTTON TO START!",720,750);




       }

       if(keyPressed==true||mousePressed==true) {
           stage = 2;
       }

       if(stage==2) {

           background(0);
        time2 = millis();
        deltatime=time2-time1;
        wrap(bg,0,0,width,height);
        for(laser l:lasers)
            l.render();
for (missle m:missles){
    m.render();
}
Enemyspawner  enemyspawner= new Enemyspawner(this,1053  ,2500);
bomberspawner bomberspawner = new bomberspawner(this,1060,3000);
fastersspawner fastersspawner= new fastersspawner(this,1060,2500);
       p1.render();
enemyrender();

placetoscreenbomber();
    enemyact();
       bomberenenmyact();
       spawnfs();

       for (int k =bombs.size()-1;k>=0;k--){
           bombs.get(k).render();
       }

for (int i= missles.size()-1;i>=0;i--){
    if (missles.get(i).getHealth()<=0){
        missles.remove(i);
    }
    else {
        missles.get(i).hareket();
    }
}

       for (int i=lasers.size()-1;i>=0;i--){
           if (lasers.get(i).getHealth()<=0||lasers.get(i).getPos().y>=height||lasers.get(i).getPos().y<=-height){
               lasers.remove(i);

           }
           else {
               lsd.play();
               lasers.get(i).hareket();



               lsd.stop();
           }
       }
       for (int j=bombs.size()-1;j>=0;j--){
          if (bombs.get(j).getHealth()<=0||bombs.get(j).getPos().y>=height-bombaresmi.height+bombaresmi.height/3){
               bombs.remove(j);
               p1.scoresup(20);
           }
          else
            {bombs.get(j).act();
           }
       }
p1.move();



       time1=millis();



       if (p1.getScore()>=0 ) {

           boss.render();
           boss.act();
           p2.render();
           p2.hareketet();
             time3=millis();
         }




      else {
           enemyspawner.update();
           bomberspawner.spawn();
           fastersspawner.update();
       }
           System.out.println(p1.getScore());

       }
       if(p1.getHealth()<=0) {
           stage = 1;
           endscreen = loadImage("res/endscreen.jpg");
         image(endscreen,-360,0);
           textAlign(CENTER);
           textSize(104);
           fill(500, 0, 0);
           text("YOU ARE DEAD.", 375, 300);
           text("SCORE: "+p1.getScore(),400,500);
           fill(255, 255, 255);
           text("PRESS ESC TO EXIT", 450, 750);

       }
   }


    public void wrap(PImage img,float x1,float y1,float x2,float y2){
        for(float x = x1;x<x2;x+=img.width){
            for (float y =y1;y<y2;y+=img.height){
                image(img,x,y); }}}

    public static boolean[] controls = new boolean[5];

    public void keyPressed(){
        if(key == 'w' || key == 'W' || keyCode == UP) controls[0] = true;
        else if(key == 'a' || key == 'A' || keyCode == LEFT) controls[1] = true;
        else if(key == 's' || key == 'S' || keyCode == DOWN) controls[2] = true;
        else if(key == 'd' || key == 'D' || keyCode == RIGHT) controls[3] = true;
        else if(key == ' ') controls[4] = true;
    }

    public void keyReleased(){
        if(key == 'w' || key == 'W' ) controls[0] = false;
        else if(key == 'a' || key == 'A' ) controls[1] = false;
        else if(key == 's' || key == 'S' ) controls[2] = false;
        else if(key == 'd' || key == 'D' ) controls[3] = false;
        else if(key == ' ') controls[4] = false;
    }

    public static float getDeltatime() {
        return deltatime;
    }

    public static void setDeltatime(float deltatime) {
        Spacegame.deltatime = deltatime;
    }

    public static float getTime3() {

        return time3;
    }
public static void enemyrender(){
    for(int j=emenies.size()-1;j>=0;j--){
        emenies.get(j).render();}
}
public static void  enemyact(){
    for (int i=emenies.size()-1;i>=0;i--){
        if (emenies.get(i).getHealth()<=0||emenies.get(i).getPos().y> 720+düşmanresmi.height/2){
            emenies.remove(i);



            p1.scoresup(10);
        }
        else {
            emenies.get(i).moveandfire();
        }
    }
}
public static void placetoscreenbomber(){
    for(int i =bombers.size()-1;i>=0;i--){
        bombers.get(i).render();
    }
}
public static void bomberenenmyact(){
    for (int k=bombers.size()-1;k>=0;k--){
        if (bombers.get(k).getHealth()<=0||bombers.get(k).getPos().y>=720){
            bombers.remove(k);

            p1.scoresup(100);
        }
        else {
            bombers.get(k).act();
        }
}

}
public static void spawnfs(){
    for(int k =fs1s.size()-1;k>=0;k--) {
        fs1s.get(k).render();
        if (fs1s.get(k).getHealth() > 0) fs1s.get(k).act();
        else {
            fs1s.remove(k);
            p1.scoresup(15);
        }

    }

}
}
