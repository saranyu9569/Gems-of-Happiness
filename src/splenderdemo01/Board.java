package splenderdemo01;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;


public class Board extends JFrame implements ActionListener {

    static JButton pick = new JButton();
    static JButton buy = new JButton();
    Player p1;
    Player p2;
    JLabel countred = new JLabel();
    JLabel countyellow = new JLabel();
    JLabel countgreen = new JLabel();
    JLabel countblue = new JLabel();
    JLabel countpurple = new JLabel();
    JLabel background = new JLabel();
    JButton exitgame = new JButton();

    static JButton redgem = new JButton();
    static JButton yellowgem = new JButton();
    static JButton greengem = new JButton();
    static JButton bluegem = new JButton();
    static JButton purplegem = new JButton();
    JButton endturn = new JButton();
    JLabel gemredp1 = new JLabel();
    JLabel gemyellowp1 = new JLabel();
    JLabel gemgreenp1 = new JLabel();
    JLabel gembluep1 = new JLabel();
    JLabel gempurplep1 = new JLabel();
    JLabel gemredp2 = new JLabel();
    JLabel gemyellowp2 = new JLabel();
    JLabel gemgreenp2 = new JLabel();
    JLabel gembluep2 = new JLabel();
    JLabel gempurplep2 = new JLabel();

    JLabel namep1 = new JLabel();
    JLabel namep2 = new JLabel();
    JLabel nameturn = new JLabel();

    JLabel scorep1 = new JLabel();
    JLabel scorep2 = new JLabel();
    JLabel countgemp1 = new JLabel();
    JLabel countgemp2 = new JLabel();
    JLabel cardredp1 = new JLabel();
    JLabel cardyellowp1 = new JLabel();
    JLabel cardgreenp1 = new JLabel();
    JLabel cardbluep1 = new JLabel();
    JLabel cardpurplep1 = new JLabel();
    JLabel cardredp2 = new JLabel();
    JLabel cardyellowp2 = new JLabel();
    JLabel cardgreenp2 = new JLabel();
    JLabel cardbluep2 = new JLabel();
    JLabel cardpurplep2 = new JLabel();

    JButton card00 = new JButton();
    JButton card01 = new JButton();
    JButton card02 = new JButton();
    JButton card03 = new JButton();
    JButton card10 = new JButton();
    JButton card11 = new JButton();
    JButton card12 = new JButton();
    JButton card13 = new JButton();
    JButton card20 = new JButton();
    JButton card21 = new JButton();
    JButton card22 = new JButton();
    JButton card23 = new JButton();

    JButton noble1 = new JButton();
    JButton noble2 = new JButton();
    JButton noble3 = new JButton();
  
    ImageIcon gem[] = new ImageIcon[5];
    ImageIcon exit;
    ImageIcon pickg;
    ImageIcon buyc;
    ImageIcon end;

    Font KIdDOS;

    CardDeck deck;
    int countdeck[] = {0, 0, 0};
    int choice;
    ClickSound click = new ClickSound();
    
    Board(Player pone, Player ptwo) {    
        CardDeck Deck = new CardDeck();
        deck = Deck;
        ImageIcon image = new ImageIcon(new ImageIcon("src\\logo.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
        ImageIcon bg = new ImageIcon(new ImageIcon("src\\BG.png").getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT));

        Font();
        this.p1 = pone;
        this.p2 = ptwo;
        p1.name = JOptionPane.showInputDialog("Enter player one name :");
        p2.name = JOptionPane.showInputDialog("Enter player two name :");
        addGameControlButton();
        addplayer1Label(p1);
        addplayer2Label(p2);
        addcard(deck);
        addnoble(deck);
        removeactioncard();
        background.setBounds(0, 0, 1920, 1080);
        background.setIcon(bg);
        this.setTitle("Splendor Gem of happiness");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1920, 1080);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        this.setLayout(null);
        this.setVisible(true);
        this.setIconImage(image.getImage());  //set logo icon
        this.getContentPane().setBackground(Color.black); //set bg
        buy.setEnabled(false);
        this.add(background);
    }

    void addGameControlButton() {
        createButton(exitgame, 50, 50, 1800, 45, exit, "src\\Exit.png");
        exitgame.addActionListener((java.awt.event.ActionEvent evt) -> {
            click.playSound("src\\click1.wav");
            exitgameActiomPerfomed(evt);
        });
        exitgame.setEnabled(true);
        createButton(pick, 198, 90, 750, 900, pickg, "src\\pick.png");
        pick.setEnabled(true);
        createButton(buy, 198, 90, 980, 900, buyc, "src\\buy.png");
        buy.setEnabled(true);
        createButton(endturn, 198, 90, 855, 900, end, "src\\endturn.png");
        endturn.setEnabled(true);
        endturn.setVisible(false);
        nameturn.setText(p1.name + " turn");
        nameturn.setBounds(855, 850, 250, 35);
        nameturn.setHorizontalAlignment(SwingConstants.CENTER);
        nameturn.setFont(KIdDOS);
        this.add(nameturn);
        this.add(exitgame);
        this.add(pick);
        this.add(buy);
        this.add(endturn);

        createButton(redgem, 120, 120, 1550, 145, gem[0], "src\\gem\\redgem.png");
        createButton(yellowgem, 120, 120, 1550, 265, gem[1], "src\\gem\\yellowgem.png");
        createButton(greengem, 120, 120, 1550, 385, gem[2], "src\\gem\\greengem.png");
        createButton(bluegem, 120, 120, 1550, 505, gem[3], "src\\gem\\bluegem.png");
        createButton(purplegem, 120, 120, 1550, 625, gem[4], "src\\gem\\purplegem.png");

        createLabel(countred, GameControl.countgem[0], 50, 50, 1700, 185);
        createLabel(countyellow, GameControl.countgem[1], 50, 50, 1700, 305);
        createLabel(countgreen, GameControl.countgem[2], 50, 50, 1700, 425);
        createLabel(countblue, GameControl.countgem[3], 50, 50, 1700, 545);
        createLabel(countpurple, GameControl.countgem[4], 50, 50, 1700, 665);

    }

    void addplayer1Label(Player p1) {
        createLabel(scorep1, p1.score, 70, 70, 480, 880);
        createLabel(countgemp1, p1.gem[0] + p1.gem[1] + p1.gem[2] + p1.gem[3] + p1.gem[4], 70, 70, 480, 980);
        createLabel(gemredp1, p1.gem[0], 40, 40, 425, 1016);
        createLabel(gemyellowp1, p1.gem[1], 40, 40, 333, 1016);
        createLabel(gemgreenp1, p1.gem[2], 40, 40, 241, 1016);
        createLabel(gembluep1, p1.gem[3], 40, 40, 150, 1016);
        createLabel(gempurplep1, p1.gem[4], 40, 40, 58, 1016);
        createLabel(cardredp1, p1.card[0], 40, 40, 395, 980);
        createLabel(cardyellowp1, p1.card[1], 40, 40, 303 + 5, 980);
        createLabel(cardgreenp1, p1.card[2], 40, 40, 211 + 5, 980);
        createLabel(cardbluep1, p1.card[3], 40, 40, 120 + 5, 980);
        createLabel(cardpurplep1, p1.card[4], 40, 40, 28 + 5, 980);
        namep1.setText(p1.name);
        namep1.setBounds(30, 890 + 3, 220, 35);
        namep1.setHorizontalAlignment(SwingConstants.CENTER);
        namep1.setFont(KIdDOS);
        this.add(namep1);
    

    }

    void addplayer2Label(Player p2) {
        createLabel(scorep2, p2.score, 70, 70, 1400, 880);
        createLabel(countgemp2, p2.gem[0] + p2.gem[1] + p2.gem[2] + p2.gem[3] + p2.gem[4], 70, 70, 1400, 980);
        createLabel(gemredp2, p2.gem[0], 40, 40, 1870 + 3, 1016);
        createLabel(gemyellowp2, p2.gem[1], 40, 40, 1778 + 3, 1016);
        createLabel(gemgreenp2, p2.gem[2], 40, 40, 1686 + 3, 1016);
        createLabel(gembluep2, p2.gem[3], 40, 40, 1595 + 3, 1016);
        createLabel(gempurplep2, p2.gem[4], 40, 40, 1503 + 3, 1016);
        createLabel(cardredp2, p2.card[0], 40, 40, 1840 + 3, 980);
        createLabel(cardyellowp2, p2.card[1], 40, 40, 1748 + 3, 980);
        createLabel(cardgreenp2, p2.card[2], 40, 40, 1656 + 3, 980);
        createLabel(cardbluep2, p2.card[3], 40, 40, 1565 + 3, 980);
        createLabel(cardpurplep2, p2.card[4], 40, 40, 1473 + 3, 980);
        namep2.setText(p2.name);
        namep2.setBounds(1645, 890 + 3, 220, 35);
        namep2.setHorizontalAlignment(SwingConstants.CENTER);
        namep2.setFont(KIdDOS);
        this.add(namep2);
       

    }

    void addcard(CardDeck deck) {

        createCardButton(card20, 150, 210, 500, 585, deck.Row1.get(0).image);
        createCardButton(card21, 150, 210, 680, 585, deck.Row1.get(1).image);
        createCardButton(card22, 150, 210, 860, 585, deck.Row1.get(2).image);
        createCardButton(card23, 150, 210, 1040, 585, deck.Row1.get(3).image);
        createCardButton(card10, 150, 210, 500, 330, deck.Row2.get(0).image);
        createCardButton(card11, 150, 210, 680, 330, deck.Row2.get(1).image);
        createCardButton(card12, 150, 210, 860, 330, deck.Row2.get(2).image);
        createCardButton(card13, 150, 210, 1040, 330, deck.Row2.get(3).image);
        createCardButton(card00, 150, 210, 500, 75, deck.Row3.get(0).image);
        createCardButton(card01, 150, 210, 680, 75, deck.Row3.get(1).image);
        createCardButton(card02, 150, 210, 860, 75, deck.Row3.get(2).image);
        createCardButton(card03, 150, 210, 1040, 75, deck.Row3.get(3).image);
    }

    void addnoble(CardDeck Deck) {
        createCardButton(noble1, 150, 150, 240, 190, Deck.Row4.get(0).image);
        createCardButton(noble2, 150, 150, 240, 370, Deck.Row4.get(1).image);
        createCardButton(noble3, 150, 150, 240, 550, Deck.Row4.get(2).image);

    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == redgem) {
            click.playSound("src\\gemm.wav");
            if (GameControl.turn == 1) {
                GameControl.countgem[0] = GameControl.countgem[0] - 1;
                countred.setText(String.valueOf(GameControl.countgem[0]));
                p1.countgem[0] = p1.countgem[0] + 1;
                p1.gem[0] = p1.gem[0] + 1;
                countgemp1.setText(String.valueOf(p1.gem[0] + p1.gem[1] + p1.gem[2] + p1.gem[3] + p1.gem[4]));
                gemredp1.setText(String.valueOf(p1.gem[0]));
                p1.pick = p1.pick + 1;
                if (p1.countgem[0] == 2) {
                    p1.pick = 3;
                } else {
                    p1.CheckGem(this);
                }
                checkturn();

            } else if (GameControl.turn == 2) {
                GameControl.countgem[0] = GameControl.countgem[0] - 1;
                countred.setText(String.valueOf(GameControl.countgem[0]));
                p2.countgem[0] = p2.countgem[0] + 1;
                p2.gem[0] = p2.gem[0] + 1;
                gemredp2.setText(String.valueOf(p2.gem[0]));
                countgemp2.setText(String.valueOf(p2.gem[0] + p2.gem[1] + p2.gem[2] + p2.gem[3] + p2.gem[4]));
                p2.pick = p2.pick + 1;
                if (p2.countgem[0] == 2) {
                    p2.pick = 3;
                } else {
                    p2.CheckGem(this);
                }
                checkturn();
            }
        } else if (evt.getSource() == yellowgem) {
            click.playSound("src\\gemm.wav");
            if (GameControl.turn == 1) {
                GameControl.countgem[1] = GameControl.countgem[1] - 1;
                countyellow.setText(String.valueOf(GameControl.countgem[1]));
                p1.countgem[1] = p1.countgem[1] + 1;
                p1.gem[1] = p1.gem[1] + 1;
                gemyellowp1.setText(String.valueOf(p1.gem[1]));
                countgemp1.setText(String.valueOf(p1.gem[0] + p1.gem[1] + p1.gem[2] + p1.gem[3] + p1.gem[4]));
                p1.pick = p1.pick + 1;
                if (p1.countgem[1] == 2) {
                    p1.pick = 3;
                } else {
                    p1.CheckGem(this);

                }
                checkturn();

            } else if (GameControl.turn == 2) {
                GameControl.countgem[1] = GameControl.countgem[1] - 1;
                countyellow.setText(String.valueOf(GameControl.countgem[1]));
                p2.countgem[1] = p2.countgem[1] + 1;
                p2.gem[1] = p2.gem[1] + 1;
                gemyellowp2.setText(String.valueOf(p2.gem[1]));
                countgemp2.setText(String.valueOf(p2.gem[0] + p2.gem[1] + p2.gem[2] + p2.gem[3] + p2.gem[4]));
                p2.pick = p2.pick + 1;
                if (p2.countgem[1] == 2) {
                    p2.pick = 3;
                } else {
                    p2.CheckGem(this);

                }
                checkturn();

            }
        } else if (evt.getSource() == greengem) {
            click.playSound("src\\gemm.wav");
            if (GameControl.turn == 1) {
                GameControl.countgem[2] = GameControl.countgem[2] - 1;
                countgreen.setText(String.valueOf(GameControl.countgem[2]));
                p1.countgem[2] = p1.countgem[2] + 1;
                p1.gem[2] = p1.gem[2] + 1;
                gemgreenp1.setText(String.valueOf(p1.gem[2]));
                countgemp1.setText(String.valueOf(p1.gem[0] + p1.gem[1] + p1.gem[2] + p1.gem[3] + p1.gem[4]));
                p1.pick = p1.pick + 1;
                if (p1.countgem[2] == 2) {
                    p1.pick = 3;
                } else {
                    p1.CheckGem(this);

                }
                checkturn();

            } else if (GameControl.turn == 2) {
                GameControl.countgem[2] = GameControl.countgem[2] - 1;
                countgreen.setText(String.valueOf(GameControl.countgem[2]));
                p2.countgem[2] = p2.countgem[2] + 1;
                p2.gem[2] = p2.gem[2] + 1;
                gemgreenp2.setText(String.valueOf(p2.gem[2]));
                countgemp2.setText(String.valueOf(p2.gem[0] + p2.gem[1] + p2.gem[2] + p2.gem[3] + p2.gem[4]));
                p2.pick = p2.pick + 1;
                if (p2.countgem[2] == 2) {
                    p2.pick = 3;
                } else {
                    p2.CheckGem(this);

                }
                checkturn();

            }
        } else if (evt.getSource() == bluegem) {
            click.playSound("src\\gemm.wav");
            if (GameControl.turn == 1) {
                GameControl.countgem[3] = GameControl.countgem[3] - 1;
                countblue.setText(String.valueOf(GameControl.countgem[3]));
                p1.countgem[3] = p1.countgem[3] + 1;
                p1.gem[3] = p1.gem[3] + 1;
                gembluep1.setText(String.valueOf(p1.gem[3]));
                countgemp1.setText(String.valueOf(p1.gem[0] + p1.gem[1] + p1.gem[2] + p1.gem[3] + p1.gem[4]));
                p1.pick = p1.pick + 1;
                if (p1.countgem[3] == 2) {
                    p1.pick = 3;
                } else {
                    p1.CheckGem(this);

                }
                checkturn();

            } else if (GameControl.turn == 2) {
                GameControl.countgem[3] = GameControl.countgem[3] - 1;
                countblue.setText(String.valueOf(GameControl.countgem[3]));
                p2.countgem[3] = p2.countgem[3] + 1;
                p2.gem[3] = p2.gem[3] + 1;
                gembluep2.setText(String.valueOf(p2.gem[3]));
                countgemp2.setText(String.valueOf(p2.gem[0] + p2.gem[1] + p2.gem[2] + p2.gem[3] + p2.gem[4]));
                p2.pick = p2.pick + 1;
                if (p2.countgem[3] == 2) {
                    p2.pick = 3;
                } else {
                    p2.CheckGem(this);

                }
                checkturn();

            }
        } else if (evt.getSource() == purplegem) {
            click.playSound("src\\gemm.wav");
            if (GameControl.turn == 1) {
                GameControl.countgem[4] = GameControl.countgem[4] - 1;
                countpurple.setText(String.valueOf(GameControl.countgem[4]));
                p1.countgem[4] = p1.countgem[4] + 1;
                p1.gem[4] = p1.gem[4] + 1;
                gempurplep1.setText(String.valueOf(p1.gem[4]));
                countgemp1.setText(String.valueOf(p1.gem[0] + p1.gem[1] + p1.gem[2] + p1.gem[3] + p1.gem[4]));
                p1.pick = p1.pick + 1;
                if (p1.countgem[4] == 2) {
                    p1.pick = 3;
                } else {
                    p1.CheckGem(this);

                }
                checkturn();

            } else if (GameControl.turn == 2) {
                GameControl.countgem[4] = GameControl.countgem[4] - 1;
                countpurple.setText(String.valueOf(GameControl.countgem[4]));
                p2.countgem[4] = p2.countgem[4] + 1;
                p2.gem[4] = p2.gem[4] + 1;
                gempurplep2.setText(String.valueOf(p2.gem[4]));
                countgemp2.setText(String.valueOf(p2.gem[0] + p2.gem[1] + p2.gem[2] + p2.gem[3] + p2.gem[4]));
                p2.pick = p2.pick + 1;
                if (p2.countgem[4] == 2) {
                    p2.pick = 3;
                } else {
                    p2.CheckGem(this);

                }
                checkturn();

            }
        } else if (evt.getSource() == pick) {
            click.playSound("src\\click1.wav");
            nameturn.setVisible(false);
            pick.setVisible(false);
            buy.setVisible(false);
            redgem.setEnabled(true);
            yellowgem.setEnabled(true);
            greengem.setEnabled(true);
            bluegem.setEnabled(true);
            purplegem.setEnabled(true);
            endturn.setVisible(true);
            if (GameControl.turn == 1) {
                nameturn.setText(p2.name + " turn");
                p1.CheckGem(this);
            } else if (GameControl.turn == 2) {
                nameturn.setText(p1.name + " turn");
                p2.CheckGem(this);
            }
            

        } else if (evt.getSource() == buy) {
            click.playSound("src\\click1.wav");
            nameturn.setVisible(false);
            pick.setVisible(false);
            buy.setVisible(false);
            redgem.setEnabled(false);
            yellowgem.setEnabled(false);
            greengem.setEnabled(false);
            bluegem.setEnabled(false);
            purplegem.setEnabled(false);
            endturn.setVisible(true);
            setactioncard();

            if (GameControl.turn == 1) {
                nameturn.setText(p2.name + " turn");

            } else if (GameControl.turn == 2) {
                nameturn.setText(p1.name + " turn");

            }
            
        } else if (evt.getSource() == endturn) {
            if (GameControl.turn == 1) {
                GameControl.turn++;
                p2.turn(this);
                endturn.setVisible(false);

            } else if (GameControl.turn == 2) {
                GameControl.turn--;
                p1.turn(this);
                endturn.setVisible(false);
            }
        } else if (evt.getSource() == card20) {
            click.playSound("src\\card.wav");
            if (GameControl.turn == 1) {
                p1.BuyCard(deck.Row1.get(0), this,GameControl.turn);
                if (p1.buy == 1) {
                    deck.ReplaceRow1(0);
                    card20.setIcon(deck.Row1.get(0).image);
                    removeactioncard();
                    p1.checknoble(this,GameControl.turn);
                    p1.buy = 0;

                }
            } else if (GameControl.turn == 2) {
                p2.BuyCard(deck.Row1.get(0), this,GameControl.turn);
                if (p2.buy == 1) {
                    deck.ReplaceRow1(0);
                    card20.setIcon(deck.Row1.get(0).image);
                    removeactioncard();
                    p2.checknoble(this,GameControl.turn);
                    p2.buy = 0;
                }
            }
            checkwin();
        } else if (evt.getSource() == card21) {
            click.playSound("src\\card.wav");
            if (GameControl.turn == 1) {
                p1.BuyCard(deck.Row1.get(1), this,GameControl.turn);
                if (p1.buy == 1) {
                    deck.ReplaceRow1(1);
                    card21.setIcon(deck.Row1.get(1).image);
                    removeactioncard();
                    p1.checknoble(this,GameControl.turn);
                    p1.buy = 0;

                }
            } else if (GameControl.turn == 2) {
                p2.BuyCard(deck.Row1.get(1), this,GameControl.turn);
                if (p2.buy == 1) {
                    deck.ReplaceRow1(1);
                    card21.setIcon(deck.Row1.get(1).image);
                    removeactioncard();
                    p2.checknoble(this,GameControl.turn);
                    p2.buy = 0;
                }
            }
            checkwin();
        } else if (evt.getSource() == card22) {
            click.playSound("src\\card.wav");
            if (GameControl.turn == 1) {
                p1.BuyCard(deck.Row1.get(2), this,GameControl.turn);
                if (p1.buy == 1) {
                    deck.ReplaceRow1(2);
                    card22.setIcon(deck.Row1.get(2).image);
                    removeactioncard();
                    p1.checknoble(this,GameControl.turn);
                    p1.buy = 0;

                }
            } else if (GameControl.turn == 2) {
                p2.BuyCard(deck.Row1.get(2), this,GameControl.turn);
                if (p2.buy == 1) {
                    deck.ReplaceRow1(2);
                    card22.setIcon(deck.Row1.get(2).image);
                    removeactioncard();
                    p2.checknoble(this,GameControl.turn);
                    p2.buy = 0;
                }
            }
            checkwin();
        } else if (evt.getSource() == card23) {
            click.playSound("src\\card.wav");
            if (GameControl.turn == 1) {
                p1.BuyCard(deck.Row1.get(3), this,GameControl.turn);
                if (p1.buy == 1) {
                    deck.ReplaceRow1(3);
                    card23.setIcon(deck.Row1.get(3).image);
                    removeactioncard();
                    p1.checknoble(this,GameControl.turn);
                    p1.buy = 0;

                }
            } else if (GameControl.turn == 2) {
                p2.BuyCard(deck.Row1.get(3), this,GameControl.turn);
                if (p2.buy == 1) {
                    deck.ReplaceRow1(3);
                    card23.setIcon(deck.Row1.get(3).image);
                    removeactioncard();
                    p2.checknoble(this,GameControl.turn);
                    p2.buy = 0;
                }
            }
            checkwin();
        } else if (evt.getSource() == card10) {
            click.playSound("src\\card.wav");
            if (GameControl.turn == 1) {
                p1.BuyCard(deck.Row2.get(0), this,GameControl.turn);
                if (p1.buy == 1) {
                    deck.ReplaceRow2(0);
                    card10.setIcon(deck.Row2.get(0).image);
                    removeactioncard();
                    p1.checknoble(this,GameControl.turn);
                    p1.buy = 0;

                }
            } else if (GameControl.turn == 2) {
                p2.BuyCard(deck.Row2.get(0), this,GameControl.turn);
                if (p2.buy == 1) {
                    deck.ReplaceRow2(0);
                    card10.setIcon(deck.Row2.get(0).image);
                    removeactioncard();
                    p2.checknoble(this,GameControl.turn);
                    p2.buy = 0;
                }
            }
            checkwin();
        } else if (evt.getSource() == card11) {
            click.playSound("src\\card.wav");
            if (GameControl.turn == 1) {
                p1.BuyCard(deck.Row2.get(1), this,GameControl.turn);
                if (p1.buy == 1) {
                    deck.ReplaceRow2(1);
                    card11.setIcon(deck.Row2.get(1).image);
                    removeactioncard();
                    p1.checknoble(this,GameControl.turn);
                    p1.buy = 0;

                }
            } else if (GameControl.turn == 2) {
                p2.BuyCard(deck.Row2.get(1), this,GameControl.turn);
                if (p2.buy == 1) {
                    deck.ReplaceRow2(1);
                    card11.setIcon(deck.Row2.get(1).image);
                    removeactioncard();
                    p2.checknoble(this,GameControl.turn);
                    p2.buy = 0;
                }
            }
            checkwin();
        } else if (evt.getSource() == card12) {
            click.playSound("src\\card.wav");
            if (GameControl.turn == 1) {
                p1.BuyCard(deck.Row2.get(2), this,GameControl.turn);
                if (p1.buy == 1) {
                    deck.ReplaceRow2(2);
                    card12.setIcon(deck.Row2.get(2).image);
                    removeactioncard();
                    p1.checknoble(this,GameControl.turn);
                    p1.buy = 0;

                }
            } else if (GameControl.turn == 2) {
                p2.BuyCard(deck.Row2.get(2), this,GameControl.turn);
                if (p2.buy == 1) {
                    deck.ReplaceRow2(2);
                    card12.setIcon(deck.Row2.get(2).image);
                    removeactioncard();
                    p2.checknoble(this,GameControl.turn);
                    p2.buy = 0;
                }
            }
            checkwin();
        } else if (evt.getSource() == card13) {
            click.playSound("src\\card.wav");
            if (GameControl.turn == 1) {
                p1.BuyCard(deck.Row2.get(3), this,GameControl.turn);
                if (p1.buy == 1) {
                    deck.ReplaceRow2(3);
                    card13.setIcon(deck.Row2.get(3).image);
                    removeactioncard();
                    p1.checknoble(this,GameControl.turn);
                    p1.buy = 0;

                }
            } else if (GameControl.turn == 2) {
                p2.BuyCard(deck.Row2.get(3), this,GameControl.turn);
                if (p2.buy == 1) {
                    deck.ReplaceRow2(3);
                    card13.setIcon(deck.Row2.get(3).image);
                    removeactioncard();
                    p2.checknoble(this,GameControl.turn);
                    p2.buy = 0;
                }
            }
            checkwin();
        } else if (evt.getSource() == card00) {
            click.playSound("src\\card.wav");
            if (GameControl.turn == 1) {
                p1.BuyCard(deck.Row3.get(0), this,GameControl.turn);
                if (p1.buy == 1) {
                    deck.ReplaceRow3(0);
                    card00.setIcon(deck.Row3.get(0).image);
                    removeactioncard();
                    p1.checknoble(this,GameControl.turn);
                    p1.buy = 0;

                }
            } else if (GameControl.turn == 2) {
                p2.BuyCard(deck.Row3.get(0), this,GameControl.turn);
                if (p2.buy == 1) {
                    deck.ReplaceRow3(0);
                    card00.setIcon(deck.Row3.get(0).image);
                    removeactioncard();
                    p2.checknoble(this,GameControl.turn);
                    p2.buy = 0;

                }
            }
            checkwin();
        } else if (evt.getSource() == card01) {
            click.playSound("src\\card.wav");
            if (GameControl.turn == 1) {
                p1.BuyCard(deck.Row3.get(1), this,GameControl.turn);
                if (p1.buy == 1) {
                    deck.ReplaceRow3(1);
                    card01.setIcon(deck.Row3.get(1).image);
                    removeactioncard();
                    p1.checknoble(this,GameControl.turn);
                    p1.buy = 0;

                }
            } else if (GameControl.turn == 2) {
                p2.BuyCard(deck.Row3.get(1), this,GameControl.turn);
                if (p2.buy == 1) {
                    deck.ReplaceRow3(1);
                    card01.setIcon(deck.Row3.get(1).image);
                    removeactioncard();
                    p2.checknoble(this,GameControl.turn);
                    p2.buy = 0;
                }
            }
            checkwin();
        } else if (evt.getSource() == card02) {
            click.playSound("src\\card.wav");
            if (GameControl.turn == 1) {
                p1.BuyCard(deck.Row3.get(2), this,GameControl.turn);
                if (p1.buy == 1) {
                    deck.ReplaceRow3(2);
                    card02.setIcon(deck.Row3.get(2).image);
                    removeactioncard();
                    p1.checknoble(this,GameControl.turn);
                    p1.buy = 0;

                }
            } else if (GameControl.turn == 2) {
                p2.BuyCard(deck.Row3.get(2), this,GameControl.turn);
                if (p2.buy == 1) {
                    deck.ReplaceRow3(2);
                    card02.setIcon(deck.Row3.get(2).image);
                    removeactioncard();
                    p2.checknoble(this,GameControl.turn);
                    p2.buy = 0;
                }
            }
            checkwin();
        } else if (evt.getSource() == card03) {
            click.playSound("src\\card.wav");
            if (GameControl.turn == 1) {
                p1.BuyCard(deck.Row3.get(3), this,GameControl.turn);
                if (p1.buy == 1) {
                    deck.ReplaceRow3(3);
                    card03.setIcon(deck.Row3.get(3).image);
                    removeactioncard();
                    p1.checknoble(this,GameControl.turn);
                    p1.buy = 0;

                }
            } else if (GameControl.turn == 2) {
                p2.BuyCard(deck.Row3.get(3), this,GameControl.turn);
                if (p2.buy == 1) {

                    deck.ReplaceRow3(3);
                    card03.setIcon(deck.Row3.get(3).image);
                    removeactioncard();
                    p2.checknoble(this,GameControl.turn);
                    p2.buy = 0;

                }
            }
            checkwin();
        }
    }

    public void createButton(JButton button, int widht, int height, int x, int y, ImageIcon image, String path) {

        image = new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(widht, height, Image.SCALE_DEFAULT));
        button.setBounds(x, y, widht, height);
        button.setIcon(image);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setEnabled(false);
        button.addActionListener(this);
        this.add(button);

    }

    public void createCardButton(JButton button, int widht, int height, int x, int y, ImageIcon image) {
        button.setBounds(x, y, widht, height);
        button.setIcon(image);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.addActionListener(this);
        this.add(button);

    }

    public void createLabel(JLabel label, int num, int widht, int height, int x, int y) {
        label.setText(String.valueOf(num));
        label.setBounds(x, y, widht, height);
        label.setFont(KIdDOS);
        this.add(label);
    }

    private void Font() {
        try {
            KIdDOS = Font.createFont(Font.TRUETYPE_FONT, new File("src/splenderdemo01/KIdDOS-Regular.ttf")).deriveFont(40f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/splenderdemo01/KIdDOS-Regular.ttf")));
        } catch (FontFormatException | IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void exitgameActiomPerfomed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void checkturn() {
        if (GameControl.turn == 1) {
            if (p1.pick == 3) {

                GameControl.turn++;
                p2.turn(this);
                endturn.setVisible(false);
            }
        } else if (GameControl.turn == 2) {
            if (p2.pick == 3) {
                GameControl.turn--;
                p1.turn(this);
                endturn.setVisible(false);
            }
        }

    }

    void setactioncard() {

        card20.addActionListener(this);
        card21.addActionListener(this);
        card22.addActionListener(this);
        card23.addActionListener(this);
        card10.addActionListener(this);
        card11.addActionListener(this);
        card12.addActionListener(this);
        card13.addActionListener(this);
        card00.addActionListener(this);
        card01.addActionListener(this);
        card02.addActionListener(this);
        card03.addActionListener(this);

    }

    void removeactioncard() {

        card20.removeActionListener(this);
        card21.removeActionListener(this);
        card22.removeActionListener(this);
        card23.removeActionListener(this);
        card10.removeActionListener(this);
        card11.removeActionListener(this);
        card12.removeActionListener(this);
        card13.removeActionListener(this);
        card00.removeActionListener(this);
        card01.removeActionListener(this);
        card02.removeActionListener(this);
        card03.removeActionListener(this);
    }

    void checkwin() {
        if (p1.score >= 15) {
            Win win = new Win(p1.name);
            win.setVisible(true);
            dispose();
        } else if (p2.score >= 15) {
            Win win = new Win(p2.name);
            win.setVisible(true);
            dispose();
        }
    }
}
