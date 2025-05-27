import greenfoot.*;

public class Buttonall1 extends Actor {
    private boolean activated = false;
    private GreenfootImage normalImage;
    private GreenfootImage pressedImage;

    public Buttonall1() {
        normalImage = new GreenfootImage("lever1.png");
        pressedImage = new GreenfootImage("lever2.png");
        normalImage.scale(50, 50);
        pressedImage.scale(50, 50);
        setImage(normalImage);
    }

    public void act() {
    if (!activated && (isTouching(Yin.class) || isTouching(Yang.class))) {
        activated = true;
        setImage(pressedImage);
        if (getWorld() instanceof Level2) {
            ((Level2) getWorld()).openGate3();  // membuka gerbang ketiga
        }
    }
}

}
