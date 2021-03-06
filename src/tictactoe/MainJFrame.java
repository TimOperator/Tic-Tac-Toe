/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.Toolkit;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Tim
 */
public class MainJFrame extends javax.swing.JFrame {

    private boolean activeGame;
    private Field field;
    private FieldStatusEnum player;
    private FieldStatusEnum defPlayer;
    private FieldStatusEnum botPlayer;
    /**
     * Creates new form MainJFrame
     */
    public MainJFrame() {
        initComponents();
        setIcon();
        activeGame = false;
        field = new Field(jButton1, jButton2, jButton3, jButton4, jButton5, jButton6, jButton7, jButton8, jButton9);
        player = FieldStatusEnum.X;
        setEnabledField(false);
        //showField();
    }
    
    private void startGame() {
        botCheckBox.setEnabled(false);
        xRadio.setEnabled(false);
        oRadio.setEnabled(false);
        startGameButton.setText("Stop Game");
        activeGame = true;
        setEnabledField(true);
        field.resetField();
        //showField();
    }
    
    private void stopGame(boolean win, FieldStatusEnum winner) {
        //Message win/lost
        if (win && winner != FieldStatusEnum.NONE) {
            if (botCheckBox.isSelected()) {
                if (winner == defPlayer) {
                    JOptionPane.showMessageDialog(null, "You won!");
                } else if (winner == botPlayer) {
                    JOptionPane.showMessageDialog(null, "Computer won!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Player " + winner + " won!");
            }
            
        } else if (winner == FieldStatusEnum.NONE) {
            JOptionPane.showMessageDialog(null, "Spiel zuende\nUnentschieden");
        }
        botCheckBox.setEnabled(true);
        xRadio.setEnabled(true);
        oRadio.setEnabled(true);
        startGameButton.setText("Start Game");
        activeGame = false;
        setEnabledField(false);
    }
    
    private void setEnabledField(boolean bo) {
        jButton1.setEnabled(bo);
        jButton2.setEnabled(bo);
        jButton3.setEnabled(bo);
        jButton4.setEnabled(bo);
        jButton5.setEnabled(bo);
        jButton6.setEnabled(bo);
        jButton7.setEnabled(bo);
        jButton8.setEnabled(bo);
        jButton9.setEnabled(bo);
    }
    
    private void resetField() {
        field.resetField();
        //showField();
    }
    
    private void setPos(int x, int y, JButton button) {
        button.setEnabled(false);
        if (botCheckBox.isSelected()) {
            field.setFieldPos(x, y, defPlayer);
            button.setText(defPlayer.toString());
        } else {
            field.setFieldPos(x, y, player);
            button.setText(player.toString());
        }
        FieldStatusEnum status = field.isWon();
        if (status != FieldStatusEnum.NONE || (!field.isDraw())) {
            stopGame(field.isDraw(), status);
            return;
        } else if (!botCheckBox.isSelected()) {
            if (player == FieldStatusEnum.O) {
                player = FieldStatusEnum.X;
                xRadio.setSelected(true);
            } else {
                player = FieldStatusEnum.O;
                oRadio.setSelected(true);
            }
        }
        //Bot action
        if (botCheckBox.isSelected()) {
            Random rd = new Random();
            int xRand;
            int yRand;
            do {
                xRand = rd.nextInt(3);
                yRand = rd.nextInt(3);
            } while (field.getFieldPos(xRand, yRand) != FieldStatusEnum.NONE);
            field.setFieldPos(xRand, yRand, botPlayer);
            status = field.isWon();
            if (status != FieldStatusEnum.NONE) {
                stopGame(field.isDraw(), status);
                return;
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        startGameButton = new javax.swing.JButton();
        xRadio = new javax.swing.JRadioButton();
        oRadio = new javax.swing.JRadioButton();
        fieldPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        botCheckBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tic Tac Toe");
        setMinimumSize(new java.awt.Dimension(250, 350));
        setName("frame"); // NOI18N
        setResizable(false);

        startGameButton.setText("Start Game");
        startGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startGameButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(xRadio);
        xRadio.setSelected(true);
        xRadio.setText("X");
        xRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xRadioActionPerformed(evt);
            }
        });

        buttonGroup1.add(oRadio);
        oRadio.setText("O");
        oRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oRadioActionPerformed(evt);
            }
        });

        fieldPanel.setMinimumSize(new java.awt.Dimension(50, 50));
        fieldPanel.setLayout(new java.awt.GridLayout(3, 3));

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        fieldPanel.add(jButton1);

        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        fieldPanel.add(jButton2);

        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        fieldPanel.add(jButton3);

        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        fieldPanel.add(jButton4);

        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        fieldPanel.add(jButton5);

        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        fieldPanel.add(jButton6);

        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        fieldPanel.add(jButton7);

        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        fieldPanel.add(jButton8);

        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        fieldPanel.add(jButton9);

        botCheckBox.setSelected(true);
        botCheckBox.setLabel("Gegen Computer spielen");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(fieldPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(startGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(xRadio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(oRadio)
                        .addGap(18, 18, 18)
                        .addComponent(botCheckBox)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xRadio)
                    .addComponent(oRadio)
                    .addComponent(botCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(startGameButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startGameButtonActionPerformed
        if (botCheckBox.isSelected()) {
            if (xRadio.isSelected()) {
                defPlayer = FieldStatusEnum.X;
                botPlayer = FieldStatusEnum.O;
            } else {
                defPlayer = FieldStatusEnum.O;
                botPlayer = FieldStatusEnum.X;
            }
        }
        if (activeGame) {
            stopGame(false, FieldStatusEnum.NONE);
        } else {
            startGame();
        }
    }//GEN-LAST:event_startGameButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setPos(0, 0, this.jButton1);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void xRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xRadioActionPerformed
        player = FieldStatusEnum.X;
    }//GEN-LAST:event_xRadioActionPerformed

    private void oRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oRadioActionPerformed
        player = FieldStatusEnum.O;
    }//GEN-LAST:event_oRadioActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setPos(0,1,this.jButton2);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        setPos(0,2,this.jButton3);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        setPos(1,0,this.jButton4);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        setPos(1,1,this.jButton5);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        setPos(1,2,this.jButton6);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        setPos(2,0,this.jButton7);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        setPos(2,1,this.jButton8);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        setPos(2,2,this.jButton9);
    }//GEN-LAST:event_jButton9ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox botCheckBox;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel fieldPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JRadioButton oRadio;
    private javax.swing.JButton startGameButton;
    private javax.swing.JRadioButton xRadio;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img.png")));
    }
}
