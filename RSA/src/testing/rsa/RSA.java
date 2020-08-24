/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testing.rsa;

import java.io.*;
import java.awt.*;
import java.net.*;
import java.sql.*;
import javax.swing.*;
import java.applet.*;
import java.awt.event.*;
import java.math.*;
import java.util.*;
public class RSA extends JFrame implements ActionListener
{
     public static void main(String[] args)
     {
           final RSA app = new RSA();
     }
     // the whole constructor is for setting up the UI of the form
     public RSA()
     {
           c = getContentPane();
           setBounds(50, 50, 1200, 400);
           setBackground(new Color(204, 204, 204));
           setDefaultCloseOperation(EXIT_ON_CLOSE);
           setTitle("Implementation of RSA");
           setResizable(false);
           c.setLayout(null);
           btnCreateP.addActionListener(this);
           btnCreateQ.addActionListener(this);
           btnCalculateN.addActionListener(this);
           btnCalculateN1.addActionListener(this);
           btnSelectE.addActionListener(this);
           btnCalculateD.addActionListener(this);
           btnCalculateOAEP.addActionListener(this);
           btnEncrypt.addActionListener(this);
           btnDecrypt.addActionListener(this);
           btnCreateP.setBounds(5, 10, 110, 25);
           btnCreateQ.setBounds(5, 40, 110, 25);
           btnCalculateN.setBounds(5, 70, 110, 25);
           btnCalculateN1.setBounds(5, 100, 110, 25);
           btnSelectE.setBounds(5, 160, 110, 25);
           btnCalculateD.setBounds(5, 130, 110, 25);
           btnCalculateOAEP.setBounds(5, 250, 110, 25);
           btnEncrypt.setBounds(5, 280, 110, 25);
           btnDecrypt.setBounds(5, 310, 110, 25);
           txtP.setBounds(120, 10, 1070, 25);
           txtQ.setBounds(120, 40, 1070, 25);
           txtN.setBounds(120, 70, 1070, 25);
           txtN1.setBounds(120, 100, 1070, 25);
           txtE.setBounds(120, 160, 1070, 25);
           txtD.setBounds(120, 130, 1070, 25);
           txtPlainText.setBounds(120, 220, 1070, 25);
           txtOAEP.setBounds(120, 250, 1070, 25);
           txtCipher.setBounds(120, 280, 1070, 25);
           txtDecipher.setBounds(120, 310, 1070, 25);
           lblAnnouncePrivatePublicKeys.setBounds(120, 190, 1070, 25);
           lblEnterPlainText.setBounds(5, 220, 310, 25);
           txtP.setEditable(false);
           txtQ.setEditable(false);
           txtN.setEditable(false);
           txtN1.setEditable(false);
           txtE.setEditable(false);
           txtD.setEditable(false);
           txtOAEP.setEditable(false);
           txtCipher.setEditable(false);
           txtDecipher.setEditable(false);
           txtP.setBackground(new Color(255, 255, 255));
           txtQ.setBackground(new Color(255, 255, 255));
           txtN.setBackground(new Color(255, 255, 255));
           txtN1.setBackground(new Color(255, 255, 255));
           txtE.setBackground(new Color(255, 255, 255));
           txtD.setBackground(new Color(255, 255, 255));
           txtOAEP.setBackground(new Color(255, 255, 255));
           txtCipher.setBackground(new Color(255, 255, 255));
           txtDecipher.setBackground(new Color(255, 255, 255));
           c.add(btnCreateP);
           c.add(btnCreateQ);
           c.add(btnCalculateN);
           c.add(btnCalculateN1);
           c.add(btnSelectE);
           c.add(btnCalculateD);
           c.add(btnCalculateOAEP);
           c.add(btnEncrypt);
           c.add(btnDecrypt);
           c.add(txtP);
           c.add(txtQ);
           c.add(txtN);
           c.add(txtN1);
           c.add(txtE);
           c.add(txtD);
           c.add(txtPlainText);
           c.add(txtOAEP);
           c.add(txtCipher);
           c.add(txtDecipher);
           c.add(lblAnnouncePrivatePublicKeys);
           c.add(lblEnterPlainText);
           show();
     }
     // this method decides which method to call for any particular button click
     public void actionPerformed(ActionEvent e)
     {
           Object source = e.getSource();
           if (source == btnCreateP)
                CreateP_Click();
           else if (source == btnCreateQ)
                btnCreateQ_Click();
           else if (source == btnCalculateN)
                btnCalculateN_Click();
           else if (source == btnCalculateN1)
                btnCalculateN1_Click();
           else if (source == btnSelectE)
                btnSelectE_Click();
           else if (source == btnCalculateD)
                btnCalculateD_Click();
           else if (source == btnCalculateOAEP)
                btnCalculateOAEP_Click();
           else if (source == btnEncrypt)
                btnEncrypt_Click();
           else if (source == btnDecrypt)
                btnDecrypt_Click();
     }
     public void CreateP_Click()
     {
           // step 1.1 in Key Generation (see page # 303 in book, RSA Key Generation)
           // create a large prime p, of 512 bits, almost 150 digits
           bigP = BigInteger.probablePrime(512, new Random(rnd.nextInt()));
           this.txtP.setText(bigP.toString());
     }
     public void btnCreateQ_Click()
     {
           // step 1.2 in Key Generation (see page # 303 in book, RSA Key Generation)
           // create a large prime q, of 512 bits, almost 150 digits
           bigQ = BigInteger.probablePrime(512, new Random(rnd.nextInt()));
           this.txtQ.setText(bigQ.toString());
     }
     public void btnCalculateN_Click()
     {
           if (this.txtQ.getText().length() == 0 || this.txtP.getText().length() == 0)
                JOptionPane.showMessageDialog(this, "Please click 'Create p' and 'Create q' buttons first.", "Warning", JOptionPane.ERROR_MESSAGE);
           else
           {
                // step 3 in Key Generation (see page # 303 in book, RSA Key Generation)
                // calculate n = p x q
                bigN = bigP.multiply(bigQ);
                this.txtN.setText(bigN.toString());
           }
     }
     public void btnCalculateN1_Click()
     {
           if (this.txtQ.getText().length() == 0 || this.txtP.getText().length() == 0)
                JOptionPane.showMessageDialog(this, "Please click 'Create p' and 'Create q' buttons first.", "Warning", JOptionPane.ERROR_MESSAGE);
           else
           {
                // step 4 in Key Generation (see page # 303 in book, RSA Key Generation)
                // calculate n' = (p - 1) x (q - 1)
                bigP = bigP.subtract(BigInteger.ONE);
                bigQ = bigQ.subtract(BigInteger.ONE);
                bigN1 = bigP.multiply(bigQ);
                this.txtN1.setText(bigN1.toString());
           }
     }
     public void btnSelectE_Click()
     {
           if (this.txtN1.getText().length() == 0)
                JOptionPane.showMessageDialog(this, "Please click '(p - 1) x (q - 1)' button first.", "Warning", JOptionPane.ERROR_MESSAGE);
           else if (this.txtD.getText().length() == 0)
                JOptionPane.showMessageDialog(this, "Please click 'Select d' button first.", "Warning", JOptionPane.ERROR_MESSAGE);
           else
           {
                bigE = bigD.modInverse(bigN1);            
                this.txtE.setText(bigE.toString());
           }         
     }
     public void btnCalculateD_Click()
     {
           bigD = BigInteger.probablePrime(256, new Random(rnd.nextInt()));
           this.txtD.setText(bigD.toString());       
     }
     public void btnCalculateOAEP_Click()
     {
           if (this.txtPlainText.getText().length() == 0)
                JOptionPane.showMessageDialog(this, "Please enter a valid numeric value in Plain Text field.", "Warning", JOptionPane.ERROR_MESSAGE);
           else if (this.txtPlainText.getText().length() > 15)
                JOptionPane.showMessageDialog(this, "Please enter a valid numeric value, 5 - 15 digits.", "Warning", JOptionPane.ERROR_MESSAGE);
           else if (!this.IsLong(this.txtPlainText.getText()))
                JOptionPane.showMessageDialog(this, "Please enter a valid numeric value, 5 - 15 digits.", "Warning", JOptionPane.ERROR_MESSAGE);
           else
           {
                // convert input text to integer
                BigInteger plainTextBigInt = new BigInteger(txtPlainText.getText());            
                // get bit length of input text
                int plainTextBitLength = plainTextBigInt.bitLength();
                // m bit message
                m = 50;             
                padding = m - plainTextBitLength;
                // create padded message M of bit length m
                BigInteger M = plainTextBigInt.shiftLeft(padding);             
                // Step 2 - # of bits for random number r
                k = 8;              
                // Step 2 - create new random variable r of k bits
                BigInteger r = new BigInteger(8, new Random(rnd.nextInt()));
                // Step 3 - create G(r) which is m bit integer from r bit integer
                BigInteger Gofr= r.shiftLeft(m - k);
                // Step 4 - create P1, first part of plain text which is M XOR G(r)
                BigInteger P1 = M.xor(Gofr);
                // Step 5 - create P2
                BigInteger HofP1 = P1.shiftRight(k - m);
                BigInteger P2 = HofP1.xor(r);
                // Step 6.1 - Concatenate P1 and P2
                String strTemp = P1.toString() + P2.toString();           
                p1Length = P1.toString().length();
                bigPlain = new BigInteger(strTemp);
                txtOAEP.setText(strTemp);
                //txtOAEP.setText("P1: " + P1 + " P2: " + P2 + " P1 || P2: " + strTemp);
           }
     }   
     public BigInteger OEAPDecryption(BigInteger P1, BigInteger P2)
     {
           BigInteger r = (P1.shiftRight(k - m)).xor(P2);
           BigInteger M = (r.shiftLeft(m - k)).xor(P1);
           BigInteger plainTextBigInt = M.shiftRight(padding);
           return plainTextBigInt;
     }
     public void btnEncrypt_Click()
     {
           if (this.txtOAEP.getText().length() == 0)
                JOptionPane.showMessageDialog(this, "Please click 'Cal ( OAEP )' button first.", "Warning", JOptionPane.ERROR_MESSAGE);
           else if (this.txtN.getText().length() == 0)
                JOptionPane.showMessageDialog(this, "Please click 'n = p x q' button first.", "Warning", JOptionPane.ERROR_MESSAGE);
           else if (this.txtE.getText().length() == 0)
                JOptionPane.showMessageDialog(this, "Please click 'Calculate e' button first.", "Warning", JOptionPane.ERROR_MESSAGE);
           else
           {
                // Encrypt the plain text entered.
                // CAUTION: Plain text should only be numeric and should not be a value bigger than 10 - 15 digits.
                bigCipher = bigPlain.modPow(bigE, bigN);
                this.txtCipher.setText(bigCipher.toString());
           }
     }
     public void btnDecrypt_Click()
     {
           if (this.txtCipher.getText().length() == 0)
                JOptionPane.showMessageDialog(this, "Please click 'Encrypt' button first.", "Warning", JOptionPane.ERROR_MESSAGE);
           else if (this.txtD.getText().length() == 0)
                JOptionPane.showMessageDialog(this, "Please click 'Select d' button first.", "Warning", JOptionPane.ERROR_MESSAGE);
           else
           {
                // Decrypt the encrypted integer back to prove that encryption and decryption are inverse of each other.
                bigPlain = bigCipher.modPow(bigD, bigN);
                BigInteger P1 = new BigInteger(bigPlain.toString().substring(0, p1Length));
                BigInteger P2 = new BigInteger(bigPlain.toString().substring(p1Length));
                bigPlain = this.OEAPDecryption(P1, P2);             
                this.txtDecipher.setText(bigPlain.toString());
                if (new BigInteger(this.txtPlainText.getText()).compareTo(bigPlain) == 0)
                     JOptionPane.showMessageDialog(this, "Since decrypted text is exactly equal to the plain text, hence proved that encryption and decryption are inverse of each other.\n\nRSA implementation completed successfully!", "Congratulations", JOptionPane.INFORMATION_MESSAGE);
           }
     }
     private boolean IsLong(String number)
     {
           boolean isLong = true;
           try
           {
                Long.parseLong(number);
           }
           catch (NumberFormatException nfe)
           {
                isLong = false;
           }
           return isLong;
     }
     private int m, k, padding, p1Length;
     private JButton btnCreateP = new JButton("Create p");
     private JButton btnCreateQ = new JButton("Create q");
     private JButton btnCalculateN = new JButton("n = p x q");
     private JButton btnCalculateN1 = new JButton("(p -1) x (q -1)");
     private JButton btnSelectE = new JButton("Calculate e");
     private JButton btnCalculateD = new JButton("Select d");
     private JButton btnCalculateOAEP = new JButton("Call ( OAEP )");
     private JButton btnEncrypt = new JButton("Encrypt");
     private JButton btnDecrypt = new JButton("Decrypt");
     private JTextField txtP = new JTextField();
     private JTextField txtQ = new JTextField();
     private JTextField txtN = new JTextField();
     private JTextField txtN1 = new JTextField();
     private JTextField txtE = new JTextField();
     private JTextField txtD = new JTextField();
     private JTextField txtPlainText = new JTextField();
     private JTextField txtOAEP = new JTextField();
     private JTextField txtCipher = new JTextField();
     private JTextField txtDecipher = new JTextField();
     private JLabel lblAnnouncePrivatePublicKeys = new JLabel("To be announced publicly: e and n are public keys.To be kept secret: d is private key.");
     private JLabel lblEnterPlainText = new JLabel("Enter Plain Text:");
     private Random rnd = new Random();
     private BigInteger bigP;
     private BigInteger bigQ;
     private BigInteger bigN;
     private BigInteger bigN1;
     private BigInteger bigE;
     private BigInteger bigD;
     private BigInteger bigPlain;
     private BigInteger bigCipher;
     private Container c;

    BigInteger encrypt(BigInteger message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    BigInteger decrypt(BigInteger encrypt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
