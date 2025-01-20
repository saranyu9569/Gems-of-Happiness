package splenderdemo01;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ImageIcon;

public class CardDeck {

    String file, name,nameimage;
    int category, score;
    ImageIcon image;
    static ArrayList<Card> Deck1, Deck2, Deck3, Noble, Row1, Row2, Row3, Row4;
    

    public CardDeck(){
        Deck1 = new ArrayList<>();
        Deck2 = new ArrayList<>();
        Deck3 = new ArrayList<>();
        Noble = new ArrayList<>();
        CreateDeck("src\\carddata\\CarddLv1.csv");
       
        CreateDeck("src\\carddata\\CardLv2.csv");
        
        CreateDeck("src\\carddata\\CardLv3.csv");
       
        CreateDeck("src\\carddata\\CardNoble.csv");
        OnBoard();
    }

    //this method is used to read data from file and create a new deck
    public void CreateDeck(String file) {
        
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                ArrayList<Integer> gem = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    gem.add(Integer.parseInt(row[i]));
                }
                score = Integer.parseInt(row[5]);
                name = row[6];
                category = Integer.parseInt(row[7]);
                nameimage=row[8];
                switch (category) {
                    case 1:
                        image = new ImageIcon(new ImageIcon("src\\cardlevel1\\"+nameimage).getImage().getScaledInstance(150, 210, Image.SCALE_DEFAULT));
                        Deck1.add(new Card(name, gem, score, category,image,nameimage));
                        break;
                    case 2:
                        image = new ImageIcon(new ImageIcon("src\\cardlevel2\\"+nameimage).getImage().getScaledInstance(150, 210, Image.SCALE_DEFAULT));
                        Deck2.add(new Card(name, gem, score, category,image,nameimage));
                        break;
                    case 3:
                        image = new ImageIcon(new ImageIcon("src\\cardlevel3\\"+nameimage).getImage().getScaledInstance(150, 210, Image.SCALE_DEFAULT));
                        Deck3.add(new Card(name, gem, score, category,image,nameimage));
                        break;
                    case 4:
                        image = new ImageIcon(new ImageIcon("src\\noblecard\\"+nameimage).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
                        Noble.add(new Card(name, gem, score, category,image,nameimage));
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //this method is used to shuffle all deck cards
    public void shuffle(){
        Collections.shuffle(Deck1);
        Collections.shuffle(Deck2);
        Collections.shuffle(Deck3);
        Collections.shuffle(Noble);
    }

    //this method is used to pick 4 cards from the deck and put on board
    public void OnBoard() {
        shuffle();
        Row1 = new ArrayList<>();
        Row2 = new ArrayList<>();
        Row3 = new ArrayList<>();
        Row4 = new ArrayList<>();

        if (Deck1.size() >= 4) {
            for (int i = 0; i < 4; i++) {
                Card card = Deck1.get(i);
                Row1.add(card);
                Deck1.removeAll(Row1);
            }
        }

        if (Deck2.size() >= 4) {
            for (int i = 0; i < 4; i++) {
                Card card = Deck2.get(i);
                Row2.add(card);
                Deck2.removeAll(Row2);
            }
        }

        if (Deck3.size() >= 4) {
            for (int i = 0; i < 4; i++) {
                Card card = Deck3.get(i);
                Row3.add(card);
                Deck3.removeAll(Row3);
            }
        }

        if (Noble.size() >= 4) {
            for (int i = 0; i < 3; i++) {
                Card card = Noble.get(i);
                Row4.add(card);
                Noble.removeAll(Row4);
            }
        }
    }
    
    public void ReplaceRow1(int i){
        Row1.set(i,Deck1.get(0));
        Deck1.remove(0);
    }

     public void ReplaceRow2(int i){
        Row2.set(i,Deck2.get(0));
        Deck2.remove(0);
    }

    public void ReplaceRow3(int i){
        Row3.set(i,Deck3.get(0));
        Deck3.remove(0);
    }

}