package splenderdemo01;

import java.util.ArrayList;

public class Noble{
    public String name;
    public int category;
    public ArrayList<Integer> gem;
    public int score;

    public Noble(String name,ArrayList<Integer> gem,int score,int category){
        this.name = name;
        this.gem = gem;
        this.score = score;
        this.category = category;
    }
}