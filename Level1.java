import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends World {
    public boolean yinReached = false;
    public boolean yangReached = false;
public void started() {
        
    }

    public Level1() {
        super(800, 600, 1);
        prepare();
    }

    public void act() {
        if (yinReached && yangReached) {
            Greenfoot.setWorld(new Level2());
        }
    }

    private void prepare() {
        SoundManager.stopBGM();
        SoundManager.playBGM();
        Yin yin = new Yin();
        Yang yang = new Yang();

        addObject(new Platform(), 400, 590);
        addObject(new pijakan(), 300, 510);

        
        addObject(new DarkZone1(), 620, 415);
        addObject(new DarkZone1(), 670, 415);
        addObject(new DarkZone(), 720, 415);
        addObject(new panjang_pijakan_banget(), 590, 445);
        addObject(new YinMonster(), 670, 405);

        
        addObject(new YangPlatform(), 350, 280);
        addObject(new YangPlatform(), 700, 370);

        addObject(new pijakan(), 430, 180);
        addObject(new YangPlatform(), 530, 320);

        
        addObject(new YinPlatform(), 100, 280);
        addObject(new YinPlatform(), 100, 280);

        
        addObject(new LightZone(), 60, 360);
        addObject(new LightZone(), 100, 360);
        addObject(new LightZone(), 150, 360);
        addObject(new panjang_pijakan(), 150, 390);
        addObject(new YangMonster(), 150, 350);

    
        addObject(new YinPlatform(), 250, 180);
        addObject(new panjang_pijakan(), 680, 130);
        addObject(new GoalArea(), 720, 80); // Tujuan di posisi ini
        
        addObject(yin, 100, 500);
        addObject(yang, 700, 500);
    }
    

    public void stopped() {
        SoundManager.pauseBGM();
    }
}

