package splenderdemo01;


import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
public class Win extends JFrame{
    JLabel background = new JLabel();
    JButton playagain = new JButton();
    JButton exit = new JButton();
    JLabel playername = new JLabel();
    ImageIcon bg;
    ImageIcon again;
    ImageIcon out;
    Font KIdDOS; 
    ClickSound click = new ClickSound();
    
    Win(String name){
       
        click.playSound("src\\win.wav");
        bg= new ImageIcon(new ImageIcon("src\\bgwin.png").getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT));
        ImageIcon image = new ImageIcon(new ImageIcon("src\\logo.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
        createButton(exit, 248, 112, 970, 830, bg, "src\\exitmain.png");
        exit.addActionListener((java.awt.event.ActionEvent evt) -> {
            click.playSound("src\\click1.wav");
            exitPerformed(evt);
        });
        createButton(playagain, 248, 112, 700, 830, again, "src\\playagain.png");
        playagain.addActionListener((java.awt.event.ActionEvent evt) -> {
            click.playSound("src\\click1.wav");
            againPerformed(evt);
        });
        background.setBounds(0, 0, 1920, 1080);
        Font();
        background.setIcon(bg);
        playername.setText(name);
        playername.setBounds(450, 100,1000, 400);
        playername.setHorizontalAlignment(SwingConstants.CENTER);
        playername.setFont(KIdDOS);
        setTitle("Splendor Gem of happiness");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1920, 1080);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        this.setLayout(null);
        this.setVisible(true);
        this.add(playername);
        this.setIconImage(image.getImage());
        this.add(playagain);
        this.add(exit);
        
        this.add(background);
    }
     public void createButton(JButton button, int widht, int height, int x, int y, ImageIcon image, String path) {

        image = new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(widht, height, Image.SCALE_DEFAULT));
        button.setBounds(x, y, widht, height);
        button.setIcon(image);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);

    }
    
    public void exitPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }
    
    public void againPerformed(java.awt.event.ActionEvent evt) {
        Mainmenu main = new Mainmenu();
        dispose();
    }
    public void Font() {
        try {
            KIdDOS = Font.createFont(Font.TRUETYPE_FONT, new File("src/splenderdemo01/KIdDOS-Regular.ttf")).deriveFont(70f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/splenderdemo01/KIdDOS-Regular.ttf")));
        } catch (FontFormatException | IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
