import greenfoot.*;

public class Yin extends Actor {
    int vSpeed = 0;
    int acceleration = 1;
    int jumpStrength = -15;
    boolean onGround;

    private boolean isFacingLeft = false;
    private GreenfootImage imgKanan = new GreenfootImage("yangkiri.png");
    private GreenfootImage imgKiri = new GreenfootImage("yangkanan.png");

    public Yin() {
        imgKanan.scale(100, 100);
        imgKiri.scale(100, 100);
        setImage(imgKanan); // default arah kanan
    }

    public void act() {
        checkYangPlatformDanger();
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
        if (Greenfoot.isKeyDown("a")) {
            setLocation(getX() - 4, getY());
            if (!isFacingLeft) {
                setImage(imgKiri);
                isFacingLeft = true;
            }
        }

        if (Greenfoot.isKeyDown("d")) {
            setLocation(getX() + 4, getY());
            if (isFacingLeft) {
                setImage(imgKanan);
                isFacingLeft = false;
            }
        }

        if (onGround && Greenfoot.isKeyDown("w")) {
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
        Actor yinPlatform = getOneObjectAtOffset(0, offset, YinPlatform.class);
        Actor landed = (platform != null) ? platform : yinPlatform;

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
                ((Level1) world).yinReached = true;
            } else if (world instanceof Level2) {
                ((Level2) world).yinReached = true;
            }
            getWorld().removeObject(this);
        }
    }

    public void checkWrongZone() {
        Actor light = getOneObjectAtOffset(0, 0, LightZone.class);
        if (light != null) {
            getWorld().removeObject(this);
            Greenfoot.setWorld(new GameOver());
        }
    }

    public void checkYangPlatformDanger() {
        Actor danger = getOneObjectAtOffset(0, 0, YangPlatform.class);
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
