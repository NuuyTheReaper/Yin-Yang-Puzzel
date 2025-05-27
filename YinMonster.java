import greenfoot.*;

public class YinMonster extends Actor {
    private int speed = 2;
    private int direction = 1; // 1 = kanan, -1 = kiri
    private int previousDirection = 1;

    public YinMonster() {
        GreenfootImage img = new GreenfootImage("monsterapi.png");
        img.scale(40, 50);
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
        Actor yang = getOneIntersectingObject(Yang.class);
        
        if (yang != null) {
            getWorld().removeObject(yang);
            Greenfoot.setWorld(new GameOver());
        }
    }
}
