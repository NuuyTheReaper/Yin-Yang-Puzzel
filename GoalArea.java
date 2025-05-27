import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GoalArea extends Actor {
    private boolean yinDetected = false;
    private boolean yangDetected = false;

    public GoalArea() {
        GreenfootImage img = new GreenfootImage("pintu.png");
        img.scale(80, 80); // ubah ukuran sesuai kebutuhan
        setImage(img);
    }

    public void act() {
        if (getWorld() instanceof Level2) {
            Level2 level = (Level2) getWorld();

            if (!yinDetected && isTouching(Yin.class)) {
                level.setYinReached();
                yinDetected = true; // agar tidak terdeteksi berulang kali
            }

            if (!yangDetected && isTouching(Yang.class)) {
                level.setYangReached();
                yangDetected = true;
            }
        }
    }
}
