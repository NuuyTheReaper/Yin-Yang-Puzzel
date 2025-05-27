import greenfoot.*;

public class GameOver extends World {
    private GreenfootImage gameOverImage;

    public GameOver() {
        super(800, 600, 1);

        // Hentikan BGM agar tidak bertabrakan
        SoundManager.stopBGM();
        Greenfoot.playSound("hit.mp3");

        // Mainkan suara game over
        Greenfoot.playSound("gameover.mp3");

        // Buat background semi-transparan
        GreenfootImage bg = new GreenfootImage(getWidth(), getHeight());
        bg.setColor(new Color(0, 0, 0, 180)); // hitam transparan
        bg.fill();
        setBackground(bg);

        // Muat dan resize gambar Gameover.png
        gameOverImage = new GreenfootImage("Gameover.png");
        gameOverImage.scale(400, 400); // ubah ukuran gambar

        // Hitung posisi tengah
        int imgX = (getWidth() - gameOverImage.getWidth()) / 2;
        int imgY = (getHeight() / 2) - gameOverImage.getHeight() / 2 - 20;

        // Tampilkan gambar di tengah
        getBackground().drawImage(gameOverImage, imgX, imgY);

        // Tampilkan teks di bawah gambar
        showText("Tekan 'Enter' untuk bermain ulang", getWidth() / 2, imgY + gameOverImage.getHeight() - 100);
    }

    public void act() {
        if (Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(new Level1());
        }
    }
}
