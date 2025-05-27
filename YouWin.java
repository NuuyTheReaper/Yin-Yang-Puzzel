import greenfoot.*;

public class YouWin extends World {
    private GreenfootImage winImage;

    public YouWin() {
        super(800, 600, 1);

        // Hentikan BGM agar tidak tabrakan
        SoundManager.stopBGM();

        // Mainkan suara menang
        GreenfootSound winSound = new GreenfootSound("win.mp3");
        winSound.setVolume(90);  // opsional
        //winSound.play();         // untuk sekali main
        winSound.playLoop();  // jika ingin diulang-ulang

        // Buat background putih semi-transparan
        GreenfootImage bg = new GreenfootImage(getWidth(), getHeight());
        bg.setColor(new Color(255, 255, 255, 100)); // putih transparan
        bg.fill();
        setBackground(bg);

        // Muat dan resize gambar youwin.png
        winImage = new GreenfootImage("youwin.png");
        winImage.scale(300, 100);

        // Hitung posisi tengah
        int imgX = (getWidth() - winImage.getWidth()) / 2;
        int imgY = (getHeight() / 2) - winImage.getHeight() / 2 - 20;

        // Gambar di background
        getBackground().drawImage(winImage, imgX, imgY);

        // Tampilkan teks di bawah gambar
        showText("Tekan 'Enter' untuk bermain ulang", getWidth() / 2, imgY + winImage.getHeight() + 25);
    }

    public void act() {
        if (Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(new StartScreen());
        }
    }
}
