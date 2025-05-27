import greenfoot.*;

public class Yang extends Actor {
    int vSpeed = 0;
    int acceleration = 1;
    int jumpStrength = -14;
    boolean onGround;

    private boolean isFacingLeft = false;
    private GreenfootImage imgKiri = new GreenfootImage("yinkanan.png");
    private GreenfootImage imgKanan = new GreenfootImage("yinkiri.png");

    public Yang() {
        imgKanan.scale(100, 100);
        imgKiri.scale(100, 100);
        setImage(imgKiri); // default arah kanan
    }

    public void act() {
        checkYinPlatformDanger();  
        if (getWorld() == null) return;

        fall();
        if (getWorld() == null) return;

        moveControl();
        if (getWorld() == null) return;

        checkGateCollision();
        if (getWorld() == null) return;

        checkPlatform();
        if (getWorld() == null) return;

        checkGoal();
        if (getWorld() == null) return;

        checkWrongZone();
    }

    public void moveControl() {
        if (Greenfoot.isKeyDown("left")) {
            setLocation(getX() - 5, getY());
            if (!isFacingLeft) {
                setImage(imgKiri);
                isFacingLeft = true;
            }
        }

        if (Greenfoot.isKeyDown("right")) {
            setLocation(getX() + 5, getY());
            if (isFacingLeft) {
                setImage(imgKanan);
                isFacingLeft = false;
            }
        }

        if (onGround && Greenfoot.isKeyDown("up")) {
            vSpeed = jumpStrength;
            onGround = false;
            Greenfoot.playSound("jump.wav");

        }
    }

    public void fall() {
        setLocation(getX(), getY() + vSpeed);
        if (vSpeed < 10) {
            vSpeed += acceleration;
        }
    }

    void checkPlatform() {
        int offset = getImage().getHeight() / 2 + 5;
        Actor platform = getOneObjectAtOffset(0, offset, Platform.class);
        Actor yangPlatform = getOneObjectAtOffset(0, offset, YangPlatform.class);
        Actor landed = (platform != null) ? platform : yangPlatform;

        if (landed != null && vSpeed >= 0) {
            vSpeed = 0;
            onGround = true;
            setLocation(getX(), landed.getY() - getImage().getHeight() / 2);
        } else {
            onGround = false;
        }
    }

    public void checkGoal() {
        Actor goal = getOneObjectAtOffset(0, 0, GoalArea.class);
        if (goal != null) {
            World world = getWorld();
            if (world instanceof Level1) {
                ((Level1) world).yangReached = true;
            } else if (world instanceof Level2) {
                ((Level2) world).yangReached = true;
            }
            getWorld().removeObject(this);
        }
    }

    public void checkWrongZone() {
        Actor dark = getOneObjectAtOffset(0, 0, DarkZone.class);
        if (dark != null) {
            getWorld().removeObject(this);
            Greenfoot.setWorld(new GameOver());
        }
    }

    public void checkYinPlatformDanger() {
        Actor danger = getOneObjectAtOffset(0, 0, YinPlatform.class);
        if (danger != null) {
            getWorld().removeObject(this);
            Greenfoot.setWorld(new GameOver());
        }
    }

    private void checkGateCollision() {
        Actor gate = getOneIntersectingObject(Gate.class);
        if (gate != null) {
            int overlap = (getImage().getWidth() + gate.getImage().getWidth()) / 2 - Math.abs(getX() - gate.getX());
            if (getX() < gate.getX()) {
                setLocation(getX() - overlap, getY());
            } else {
                setLocation(getX() + overlap, getY());
            }
        }
    }
}
