import greenfoot.*;

public class YangMonster extends Actor {
    private int speed = 2;
    private int direction = 1; // 1 = kanan, -1 = kiri
    private int previousDirection = 1;

    public YangMonster() {
        GreenfootImage img = new GreenfootImage("monsteres.png");
        img.scale(50, 50);
        setImage(img);
    }

    public void act() {
        move();
        checkEdgeOfPlatform();
        checkCollisionWithPlayer();
    }

    private void move() {
        setLocation(getX() + speed * direction, getY());
    }

    private void checkEdgeOfPlatform() {
        int xOffset = getImage().getWidth() / 2 * direction;
        int yOffset = getImage().getHeight() / 2 + 5;

        Actor platformBelow = getOneObjectAtOffset(xOffset, yOffset, Platform.class);
        if (platformBelow == null) {
            direction *= -1;

            // Hanya mirror gambar jika arah berubah
            if (direction != previousDirection) {
                getImage().mirrorHorizontally();
                previousDirection = direction;
            }
        }
    }

    private void checkCollisionWithPlayer() {
        Actor yin = getOneIntersectingObject(Yin.class);
        
        if (yin != null) {
            getWorld().removeObject(yin);
            Greenfoot.setWorld(new GameOver());
        }
    }
}
