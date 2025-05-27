import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ButtonYin extends Actor {
    private boolean activated = false;
    private GreenfootImage normalImage;
    private GreenfootImage pressedImage;

    public ButtonYin() {
        normalImage = new GreenfootImage("lever1.png");              // gambar default
        pressedImage = new GreenfootImage("lever.png");     // gambar setelah ditekan
        normalImage.scale(50, 50);
        pressedImage.scale(50, 50);
        setImage(normalImage);
    }

    public void act() {
        if (!activated && isTouching(Yin.class)) {
            activated = true;
            setImage(pressedImage);  // ganti gambar jadi tombol tertekan
            //Greenfoot.playSound("button.wav");
            if (getWorld() instanceof Level2) {
                ((Level2)getWorld()).openGate();  // panggil method untuk buka gerbang
            }
        }
    }
}
