/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import javax.swing.JButton;

/**
 *
 * @author Tim
 */
public class Field {
    private FieldStatusEnum[][] field;
    private JButton[][] buttonField;
    
    public Field(JButton button1, JButton button2, JButton button3, JButton button4, JButton button5, JButton button6, JButton button7, JButton button8, JButton button9) {
        field = new FieldStatusEnum[3][3];
        buttonField = new JButton[3][3];
        buttonField[0][0] = button1;
        buttonField[0][1] = button2;
        buttonField[0][2] = button3;
        buttonField[1][0] = button4;
        buttonField[1][1] = button5;
        buttonField[1][2] = button6;
        buttonField[2][0] = button7;
        buttonField[2][1] = button8;
        buttonField[2][2] = button9;
        resetField();
    }
    
    public void resetField() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = FieldStatusEnum.NONE;
                buttonField[i][j].setText("");
            }
        }
    }
    
    public void setFieldPos(int x, int y, FieldStatusEnum status) {
        field[x][y] = status;
        buttonField[x][y].setText(status.toString());
        buttonField[x][y].setEnabled(false);
    }
    
    public FieldStatusEnum getFieldPos(int x, int y) {
        return field[x][y];
    }
    
    /**
     * Check wether on of the player has won the game or the game is draw
     * @return true, if someone won, false if the game is draw
     */
    public boolean isDraw() {
        if (isWon() != FieldStatusEnum.NONE) {
            return true;
        }
        int x = 0;
        int o = 0;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (field[i][j] == FieldStatusEnum.O) {
                    o++;
                } else if (field[i][j] == FieldStatusEnum.X) {
                    x++;
                }
            }
        }
        if (x+o >= 9) {
            return false;
        } else {
            return true;
        }
    }
    
    /**
     * Check if one of the player has won the game
     * @return Player, who won or NONE if no one won yet
     */
    public FieldStatusEnum isWon() {
        int x = 0;
        int o = 0;
        
        //Zeilen -
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (field[i][j] == FieldStatusEnum.O) {
                    o++;
                } else if (field[i][j] == FieldStatusEnum.X) {
                    x++;
                }
            }
            if (o == 3) {
                return FieldStatusEnum.O;
            } else if (x == 3) {
                return FieldStatusEnum.X;
            } else {
                x = 0;
                o = 0;
            }
        }
        
        //Spalten |
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (field[j][i] == FieldStatusEnum.O) {
                    o++;
                } else if (field[j][i] == FieldStatusEnum.X) {
                    x++;
                }
            }
            if (o == 3) {
                return FieldStatusEnum.O;
            } else if (x == 3) {
                return FieldStatusEnum.X;
            } else {
                x = 0;
                o = 0;
            }
        }
        
        //Diagonal \
        for(int i = 0; i < 3; ++i) {
            if (field[i][i] == FieldStatusEnum.O) {
                o++;
            } else if (field[i][i] == FieldStatusEnum.X) {
                x++;
            }
        }
        if (o == 3) {
                return FieldStatusEnum.O;
        } else if (x == 3) {
                return FieldStatusEnum.X;
        } else {
                x = 0;
                o = 0;
        }
        
        //Diagonal /
        for(int i = 0; i < 3; ++i) {
            if (field[2-i][i] == FieldStatusEnum.O) {
                o++;
            } else if (field[2-i][i] == FieldStatusEnum.X) {
                x++;
            }
        }
        if (o == 3) {
                return FieldStatusEnum.O;
        } else if (x == 3) {
                return FieldStatusEnum.X;
        } else {
                x = 0;
                o = 0;
        }
        return FieldStatusEnum.NONE;
    }
}
