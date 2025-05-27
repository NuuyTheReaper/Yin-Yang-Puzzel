import greenfoot.*;

public class PlayButton extends Actor {
    public PlayButton() {
        GreenfootImage image = new GreenfootImage("play.png");
        image.scale(150, 60); // ubah ukuran tombol jika perlu
        setImage(image);
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new Level1()); // ganti ke level pertama
        }
    }
}
