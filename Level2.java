import greenfoot.*;

public class Level2 extends World {
    public boolean yinReached = false;
    public boolean yangReached = false;
    
    private Gate gate;    // Gerbang untuk Yin
    private Gate1 gate1;  // Gerbang untuk Yang
    private Gate2 gate2;  // Gerbang yang bisa digeser
    private Gate2 gate3;  // Gerbang jebakan

    public Level2() {
        super(800, 600, 1);
        prepare();
    }

    private void prepare() {
        SoundManager.stopBGM();
        SoundManager.playBGM();
        
        Yin yin = new Yin();
        Yang yang = new Yang();
        
        // Platform dan pijakan
        addObject(new Platform(), 400, 590);
        addObject(new panjang_pijakan_banget(), 600, 450);
        addObject(new pijakan(), 500, 310);
        addObject(new pijakan(), 600, 370);
        addObject(new pijakan(), 150, 390);
        addObject(new panjang_pijakan1(), 730, 310);
        addObject(new pijakan(), 200, 230);
        addObject(new pijakan(), 400, 230);

        // Musuh
        addObject(new YangMonster(), 600, 410);
        addObject(new YinMonster(), 800, 270);

        // Tombol dan Gerbang
        ButtonYin button = new ButtonYin();
        addObject(button, 700, 280);
        gate = new Gate();
        addObject(gate, 500, 520);

        ButtonYang buttonYang = new ButtonYang();
        addObject(buttonYang, 600, 560);
        gate1 = new Gate1();
        addObject(gate1, 300, 330);

        Buttonall buttonall = new Buttonall();
        addObject(buttonall, 780, 560);
        gate2 = new Gate2();
        addObject(gate2, 280, 400);

        Buttonall1 buttonall1 = new Buttonall1(); // tombol jebakan
        addObject(buttonall1, 400, 200);
        gate3 = new Gate2(); // jebakan yang menghilang
        addObject(gate3, 600, 230);

        // Area tujuan
        addObject(new YinPlatform(), 100, 150);
        addObject(new YangPlatform(), 700, 150);
        addObject(new GoalArea(), 100, 100); // untuk Yin
        addObject(new GoalArea(), 700, 100); // untuk Yang

        // Tambahkan pemain
        addObject(yin, 100, 500);
        addObject(yang, 700, 500);
    }

    // Dipanggil dari GoalArea jika Yin sampai tujuan
    public void setYinReached() {
        yinReached = true;
        checkWinCondition();
    }

    // Dipanggil dari GoalArea jika Yang sampai tujuan
    public void setYangReached() {
        yangReached = true;
        checkWinCondition();
    }

    // Cek apakah keduanya sudah sampai tujuan
    private void checkWinCondition() {
        if (yinReached && yangReached) {
            Greenfoot.setWorld(new YouWin());
        }
    }

    // Gerbang dibuka oleh tombol tertentu
    public void openGate() {
        removeObject(gate);
    }

    public void openGate1() {
        removeObject(gate1);
    }

    public void openGate2() {
        if (gate2 != null) {
            int x = gate2.getX();
            int newY = gate2.getY() + 100; // turun 100 piksel
            gate2.setLocation(x, newY);
        }
    }

    public void openGate3() {
        removeObject(gate3); // gerbang jebakan menghilang
    }
}
