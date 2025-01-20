package splenderdemo01;

import javax.swing.JOptionPane;

public class Player {

    int[] gem = {0, 0, 0, 0, 0};// collect gems in player1
    int[] card = {0, 0, 0, 0, 0};// collect cards color in player1
    int[] countgem = {0, 0, 0, 0, 0}; // gem pick in this round
    int score = 0; // collect score
    int countpick = 0; // to check how many gems did you already pick
    static int pick;
    static int choice;
    String name;
    int buy;
    static boolean win = false;

    public void BuyCard(Card Card, Board board, int turn) {
        if (gem[0] + card[0] >= Card.gem.get(0) && gem[1] + card[1] >= Card.gem.get(1) && gem[2] + card[2] >= Card.gem.get(2) && gem[3] + card[3] >= Card.gem.get(3) && gem[4] + card[4] >= Card.gem.get(4)) {
            int total;

            for (int i = 0; i <= 4; i++) {
                total = Card.gem.get(i) - card[i];
                if (total > 0) {
                    int old = gem[i];
                    gem[i] = gem[i] - total;
                    GameControl.countgem[i] = GameControl.countgem[i] + (old - gem[i]);
                }
            }

            if (Card.name.equals("red")) {
                card[0]++;

            } else if (Card.name.equals("yellow")) {
                card[1]++;

            } else if (Card.name.equals("green")) {
                card[2]++;

            } else if ((Card.name.equals("blue"))) {
                card[3]++;

            } else if (Card.name.equals("purple")) {
                card[4]++;

            }
            this.score = this.score + Card.score;
            buy = 1;
            if (turn == 1) {
                board.gemredp1.setText(String.valueOf(gem[0]));
                board.gemyellowp1.setText(String.valueOf(gem[1]));
                board.gemgreenp1.setText(String.valueOf(gem[2]));
                board.gembluep1.setText(String.valueOf(gem[3]));
                board.gempurplep1.setText(String.valueOf(gem[4]));
                board.cardredp1.setText(String.valueOf(card[0]));
                board.cardyellowp1.setText(String.valueOf(card[1]));
                board.cardgreenp1.setText(String.valueOf(card[2]));
                board.cardbluep1.setText(String.valueOf(card[3]));
                board.cardpurplep1.setText(String.valueOf(card[4]));
                board.countgemp1.setText(String.valueOf(gem[0] + gem[1] + gem[2] + gem[3] + gem[4]));
                board.scorep1.setText(String.valueOf(this.score));
                board.countred.setText(String.valueOf(GameControl.countgem[0]));
                board.countyellow.setText(String.valueOf(GameControl.countgem[1]));
                board.countgreen.setText(String.valueOf(GameControl.countgem[2]));
                board.countblue.setText(String.valueOf(GameControl.countgem[3]));
                board.countpurple.setText(String.valueOf(GameControl.countgem[4]));

            } else if (turn == 2) {
                board.gemredp2.setText(String.valueOf(gem[0]));
                board.gemyellowp2.setText(String.valueOf(gem[1]));
                board.gemgreenp2.setText(String.valueOf(gem[2]));
                board.gembluep2.setText(String.valueOf(gem[3]));
                board.gempurplep2.setText(String.valueOf(gem[4]));
                board.cardredp2.setText(String.valueOf(card[0]));
                board.cardyellowp2.setText(String.valueOf(card[1]));
                board.cardgreenp2.setText(String.valueOf(card[2]));
                board.cardbluep2.setText(String.valueOf(card[3]));
                board.cardpurplep2.setText(String.valueOf(card[4]));
                board.countgemp2.setText(String.valueOf(gem[0] + gem[1] + gem[2] + gem[3] + gem[4]));
                board.scorep2.setText(String.valueOf(this.score));
                board.countred.setText(String.valueOf(GameControl.countgem[0]));
                board.countyellow.setText(String.valueOf(GameControl.countgem[1]));
                board.countgreen.setText(String.valueOf(GameControl.countgem[2]));
                board.countblue.setText(String.valueOf(GameControl.countgem[3]));
                board.countpurple.setText(String.valueOf(GameControl.countgem[4]));
            }

        } else {
            JOptionPane.showMessageDialog(null, "not enoughgem");
        }
    }

    public void CheckGem(Board board) {
        if (gem[0] + gem[1] + gem[2] + gem[3] + gem[4] >= 10) {
            board.redgem.setEnabled(false);
            board.yellowgem.setEnabled(false);
            board.greengem.setEnabled(false);
            board.bluegem.setEnabled(false);
            board.purplegem.setEnabled(false);
        } else {
            if (GameControl.countgem[0] == 0) {
                board.redgem.setEnabled(false);

            } else if (countgem[0] == 1 && GameControl.countgem[0] <= 3) {
                if (GameControl.countgem[0] < 3) {
                    board.redgem.setEnabled(false);
                } else if (countgem[1] == 0 && countgem[2] == 0 && countgem[3] == 0 && countgem[4] == 0) {
                    board.redgem.setEnabled(true);
                } else {
                    board.redgem.setEnabled(false);
                }

            } else if (countgem[0] == 2) {
                board.redgem.setEnabled(false);

            } else {
                board.redgem.setEnabled(true);
            }

            if (GameControl.countgem[1] == 0) {
                board.yellowgem.setEnabled(false);
            } else if (countgem[1] == 1 && GameControl.countgem[1] <= 3) {
                if (GameControl.countgem[1] < 3) {
                    board.yellowgem.setEnabled(false);
                } else if (countgem[0] == 0 && countgem[2] == 0 && countgem[3] == 0 && countgem[4] == 0) {
                    board.yellowgem.setEnabled(true);
                } else {
                    board.yellowgem.setEnabled(false);
                }
            } else if (countgem[1] == 2) {
                board.yellowgem.setEnabled(false);
            } else {
                board.yellowgem.setEnabled(true);
            }

            if (GameControl.countgem[2] == 0) {
                board.greengem.setEnabled(false);
            } else if (countgem[2] == 1 && GameControl.countgem[2] <= 3) {
                if (GameControl.countgem[2] < 3) {
                    board.greengem.setEnabled(false);
                } else if (countgem[0] == 0 && countgem[1] == 0 && countgem[3] == 0 && countgem[4] == 0) {
                    board.greengem.setEnabled(true);
                } else {
                    board.greengem.setEnabled(false);
                }
            } else if (countgem[2] == 2) {
                board.greengem.setEnabled(false);
            } else {
                board.greengem.setEnabled(true);
            }

            if (GameControl.countgem[3] == 0) {
                board.bluegem.setEnabled(false);
            } else if (countgem[3] == 1 && GameControl.countgem[3] <= 3) {
                if (GameControl.countgem[3] < 3) {
                    board.bluegem.setEnabled(false);
                } else if (countgem[0] == 0 && countgem[2] == 0 && countgem[1] == 0 && countgem[4] == 0) {
                    board.bluegem.setEnabled(true);
                } else {
                    board.bluegem.setEnabled(false);
                }
            } else if (countgem[3] == 2) {
                board.bluegem.setEnabled(false);
            } else {
                board.bluegem.setEnabled(true);
            }

            if (GameControl.countgem[4] == 0) {
                board.purplegem.setEnabled(false);
            } else if (countgem[4] == 1 && GameControl.countgem[4] <= 3) {
                if (GameControl.countgem[4] < 3) {
                    board.purplegem.setEnabled(false);
                } else if (countgem[0] == 0 && countgem[2] == 0 && countgem[3] == 0 && countgem[1] == 0) {
                    board.purplegem.setEnabled(true);
                } else {
                    board.purplegem.setEnabled(false);
                }
            } else if (countgem[4] == 2) {
                board.purplegem.setEnabled(false);
            } else {
                board.purplegem.setEnabled(true);

            }
        }
    }

    public void turn(Board board) {

        pick = 0;
        countgem[0] = 0;
        countgem[1] = 0;
        countgem[2] = 0;
        countgem[3] = 0;
        countgem[4] = 0;
        board.removeactioncard();
        board.nameturn.setVisible(true);
        board.buy.setVisible(true);
        //board.buy.setVisible(true);
        board.redgem.setEnabled(false);
        board.yellowgem.setEnabled(false);
        board.greengem.setEnabled(false);
        board.bluegem.setEnabled(false);
        board.purplegem.setEnabled(false);
        checkpick(board);
        checkbuy(board);
    }

    public void checkpick(Board board) {
        if (gem[0] + gem[1] + gem[2] + gem[3] + gem[4] == 10) {
            board.pick.setVisible(true);
            board.pick.setEnabled(false);

        } else {
            board.pick.setVisible(true);
            board.pick.setEnabled(true);
        }
    }

    public void checkbuy(Board board) {
        
        int out = 0;
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 3; j++) {
                if (i == 0) {
                    if (gem[0] + card[0] >= board.deck.Row1.get(j).gem.get(0) && gem[1] + card[1] >= board.deck.Row1.get(j).gem.get(1) && gem[2] + card[2] >= board.deck.Row1.get(j).gem.get(2) && gem[3] + card[3] >= board.deck.Row1.get(j).gem.get(3) && gem[4] + card[4] >= board.deck.Row1.get(j).gem.get(4)) {
                        board.buy.setVisible(true);
                        board.buy.setEnabled(true);
                        
                        out = 1;
                        break;
                    }
                } else if (i == 1) {
                    if (gem[0] + card[0] >= board.deck.Row2.get(j).gem.get(0) && gem[1] + card[1] >= board.deck.Row2.get(j).gem.get(1) && gem[2] + card[2] >= board.deck.Row2.get(j).gem.get(2) && gem[3] + card[3] >= board.deck.Row2.get(j).gem.get(3) && gem[4] + card[4] >= board.deck.Row2.get(j).gem.get(4)) {
                        board.buy.setVisible(true);
                        board.buy.setEnabled(true);
                        
                        out = 1;
                        break;
                    }
                } else if (i == 2) {
                    if (gem[0] + card[0] >= board.deck.Row3.get(j).gem.get(0) && gem[1] + card[1] >= board.deck.Row3.get(j).gem.get(1) && gem[2] + card[2] >= board.deck.Row3.get(j).gem.get(2) && gem[3] + card[3] >= board.deck.Row3.get(j).gem.get(3) && gem[4] + card[4] >= board.deck.Row3.get(j).gem.get(4)) {
                        board.buy.setVisible(true);
                        board.buy.setEnabled(true);
                        
                        out = 1;
                        break;
                    }
                }
            }
            if (out == 1) {
                break;
            } else {
                continue;
            }
        }
    }

    public void checknoble(Board board, int turn) {
        for (int i = 0; i <= 2; i++) {
            if (card[0] >= board.deck.Row4.get(i).gem.get(0) && card[1] >= board.deck.Row4.get(i).gem.get(1) && card[2] >= board.deck.Row4.get(i).gem.get(2) && card[3] >= board.deck.Row4.get(i).gem.get(3) && card[4] >= board.deck.Row4.get(i).gem.get(4)) {
                ClickSound click = new ClickSound();
                click.playSound("src\\click2.wav");
                score = score += board.deck.Row4.get(i).score;

                if (i == 0) {
                    board.noble1.setVisible(false);
                } else if (i == 1) {
                    board.noble2.setVisible(false);
                } else if (i == 2) {
                    board.noble3.setVisible(false);
                }
            } else {
                continue;
            }
        }
        if (turn == 1) {
            board.scorep1.setText(String.valueOf(score));
        } else if (turn == 2) {
            board.scorep2.setText(String.valueOf(score));
        }
    }

}
