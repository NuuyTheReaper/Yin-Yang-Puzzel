import greenfoot.*;

public class StartScreen extends World {
    public StartScreen() {
        super(800, 600, 1);
        setBackground(new GreenfootImage("bg.png"));

        addObject(new PlayButton(), getWidth() / 2, 360);

        GreenfootImage yinLogo = new GreenfootImage("yinkiri.png");
        yinLogo.scale(500, 500);
        getBackground().drawImage(yinLogo, -150, -100);

        GreenfootImage yangLogo = new GreenfootImage("yangkiri.png");
        yangLogo.scale(600, 600);
        getBackground().drawImage(yangLogo, getWidth() - 1000, 100);

        GreenfootImage monsteryangLogo = new GreenfootImage("monster2.png");
        monsteryangLogo.scale(300, 400);
        getBackground().drawImage(monsteryangLogo, getWidth() - 250, -50);

        GreenfootImage monsteryinLogo = new GreenfootImage("monster1.png");
        monsteryinLogo.scale(350, 450);
        getBackground().drawImage(monsteryinLogo, 530, 200);

        GreenfootImage text = new GreenfootImage("tulisan.png");
        text.scale(600, 250);
        getBackground().drawImage(text, +100, 150);
    }
    public void started() {
        SoundManager.playBGM();
    }

    public void stopped() {
        SoundManager.pauseBGM();
    }
    
}
    