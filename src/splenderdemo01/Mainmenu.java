package splenderdemo01;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Mainmenu extends JFrame {

    JLabel background = new JLabel();
    JButton exitgame = new JButton();
    JButton startgame = new JButton();
    JButton howtoplaygame = new JButton();
    JButton next = new JButton();
    JButton close = new JButton();
    JButton back = new JButton();
    ImageIcon exit;
    ImageIcon start;
    ImageIcon play;
    ImageIcon nextimg;
    ImageIcon closeimg;
    ImageIcon backimg;
    ImageIcon bg;
    ImageIcon rule[] = new ImageIcon[7];
    int i = 1;
    Player p1 = new Player();
    Player p2 = new Player();
    
    
    Mainmenu() {
        ClickSound click = new ClickSound();
        addrule();
        ImageIcon image = new ImageIcon(new ImageIcon("src\\logo.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
        bg = new ImageIcon(new ImageIcon("src\\mainbg.png").getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT));
        createButton(howtoplaygame, 248, 112, 840, 680, play, "src\\howto.png");
        howtoplaygame.addActionListener((java.awt.event.ActionEvent evt) -> {
            click.playSound("src\\click1.wav");
            rulePerformed(evt);
        });
        createButton(exitgame, 248, 112, 840, 830, exit, "src\\exitmain.png");
        exitgame.addActionListener((java.awt.event.ActionEvent evt) -> {
            click.playSound("src\\click1.wav");
            exitPerformed(evt);
        });
        createButton(startgame, 248, 112, 840, 530, start, "src\\start.png");
        startgame.addActionListener((java.awt.event.ActionEvent evt) -> {
            click.playSound("src\\click1.wav");
            startPerformed(evt);
        });
        createButton(next, 198, 90, 1100, 830, nextimg, "src\\next.png");
        next.setVisible(false);
        next.addActionListener((java.awt.event.ActionEvent evt) -> {
            click.playSound("src\\click1.wav");
            nextPerformed(evt);
        });
        createButton(close, 198, 90, 850, 830, closeimg, "src\\close.png");
        close.addActionListener((java.awt.event.ActionEvent evt) -> {
            click.playSound("src\\click1.wav");
            closePerformed(evt);
        });
        close.setVisible(false);
        createButton(back, 198, 90, 600, 830, backimg, "src\\back.png");
        back.setVisible(false);
        back.addActionListener((java.awt.event.ActionEvent evt) -> {
            click.playSound("src\\click1.wav");
            backPerformed(evt);
        });
        background.setBounds(0, 0, 1920, 1080);
        background.setIcon(bg);
        setTitle("Splendor Gem of happiness");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1920, 1080);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        this.setLayout(null);
        this.setVisible(true);
        this.setIconImage(image.getImage());

        this.add(exitgame);
        this.add(startgame);
        this.add(howtoplaygame);
        this.add(next);
        this.add(close);
        this.add(back);
        this.add(background);

    }

    public void startPerformed(java.awt.event.ActionEvent evt) {
        
        Board board = new Board(p1,p2);
        board.setVisible(true);
        dispose();
    }

    public void rulePerformed(java.awt.event.ActionEvent evt) {
        
        i = 0;
        background.setIcon(rule[i]);
        exitgame.setVisible(false);
        startgame.setVisible(false);
        howtoplaygame.setVisible(false);
        next.setVisible(true);
        close.setVisible(true);
        back.setVisible(true);
        back.setEnabled(false);
        next.setEnabled(true);
    
    }

    public void exitPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }
     public void nextPerformed(java.awt.event.ActionEvent evt) {
        if(i+1<=6){
            i++;
            background.setIcon(rule[i]);
            back.setEnabled(true);
          
            if(i==6){
                next.setEnabled(false);
            }
        }
    }
     
     public void backPerformed(java.awt.event.ActionEvent evt) {
        if(i-1>=0){
            i--;
            background.setIcon(rule[i]);
            next.setEnabled(true);
            if(i==0){
                back.setEnabled(false);
            }
        }
    }
    public void closePerformed(java.awt.event.ActionEvent evt) {
        background.setIcon(bg);
        exitgame.setVisible(true);
        startgame.setVisible(true);
        howtoplaygame.setVisible(true);
        next.setVisible(false);
        close.setVisible(false);
        back.setVisible(false);
    }

    public void createButton(JButton button, int widht, int height, int x, int y, ImageIcon image, String path) {

        image = new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(widht, height, Image.SCALE_DEFAULT));
        button.setBounds(x, y, widht, height);
        button.setIcon(image);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);

    }

    public void addrule() {
        rule[0] = new ImageIcon(new ImageIcon("src\\Rules1.png").getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT));
        rule[1] = new ImageIcon(new ImageIcon("src\\Rules2.png").getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT));
        rule[2] = new ImageIcon(new ImageIcon("src\\Rules3.png").getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT));
        rule[3] = new ImageIcon(new ImageIcon("src\\Rules4.png").getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT));
        rule[4] = new ImageIcon(new ImageIcon("src\\Rules5.png").getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT));
        rule[5] = new ImageIcon(new ImageIcon("src\\Rules6.png").getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT));
        rule[6] = new ImageIcon(new ImageIcon("src\\Rules7.png").getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT));
    }

}
