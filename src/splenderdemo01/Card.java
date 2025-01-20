package splenderdemo01;

import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Card{
    public String name;
    public int category;
    public ArrayList<Integer> gem;
    public int score;
    public ImageIcon image;
    String nameimage;

    public Card(String name,ArrayList<Integer> gem,int score,int category,ImageIcon image,String nameimage){
        this.name = name;
        this.gem = gem;
        this.score = score;
        this.category = category;
        this.image=image;
        this.nameimage=nameimage;
    }
}