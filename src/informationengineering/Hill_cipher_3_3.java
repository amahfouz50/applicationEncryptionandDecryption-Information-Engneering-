package informationengineering;

 

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public final class Hill_cipher_3_3 {

    int plain_textlength = 0;
    JButton Hill_E, Hill_D;
    JLabel Plan_Text, encryption, decryption, key;
    JFrame frame;
    JPanel p;
    JTextField t1, t2, t3;
    char string_text[] = new char[55];
    int strint_count = 0;
    char plain_text[] = new char[55];
    char plain_text2[] = new char[55];
    int plain_2_n[] = new int[55];
    JTextField t_key_arr[][] = new JTextField[3][3];
    int key_arr[][] = new int[3][3];
    int minors_arr[][] = new int[3][3];
    int minors_arr2[][] = new int[3][3];
    int rem[] = new int[22];
    int div[] = new int[22];
    int inv[] = new int[22];
    int len;
    int inv_M;
    int flag = 0;
/////////////////////////////////////////////////////////////////////////////////
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------ 

    public void GUI() {
        frame = new JFrame("Encryption");
        frame.setVisible(true);
        frame.setSize(820, 220);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(300, 250);
        p = new JPanel(null);
p.setBackground(Color.cyan);
////////        
        Hill_E = new JButton("Combination Encryption");
        Hill_E.setBounds(10, 10, 200, 25);
        p.add(Hill_E);

        Hill_D = new JButton("Combination Decryption");
        Hill_D.setBounds(600, 10, 200, 25);
        p.add(Hill_D);
////////
////////        
        Plan_Text = new JLabel("plain text");
        Plan_Text.setBounds(250, 10, 100, 30);
        p.add(Plan_Text);

        encryption = new JLabel("Encryption");
        encryption.setBounds(250, 40, 100, 30);
        p.add(encryption);

        decryption = new JLabel("Dncryption");
        decryption.setBounds(250, 70, 100, 30);
        p.add(decryption);

        key = new JLabel("Key");
        key.setBounds(20, 50, 60, 33);
        p.add(key);

        t1 = new JTextField();
        t1.setBounds(350, 10, 220, 25);
        p.add(t1);


        t2 = new JTextField();
        t2.setBounds(350, 40, 220, 25);
        p.add(t2);

        t3 = new JTextField();
        t3.setBounds(350, 70, 220, 25);
        p.add(t3);
//////////////                                          key TextFields
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                JTextField t = new JTextField();
                t.setBounds(20 + 35 * col, 80 + 30 * row, 35, 30);
                p.add(t);
                t_key_arr[row][col] = t;
            }
        }
/////////////
        frame.add(p);
        frame.repaint();
        frame.validate();
    }
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------

    public void get_plan_text() {
        plain_text2 = t1.getText().toCharArray();
        int r;
        for (r = 0; r < plain_text2.length; r++) {
            plain_text[r] = plain_text2[r];
        }

////////////////                                        add ( a , b , c) to plain text
        if (plain_text2.length % 3 != 0) {
            for (int r2 = 0; r2 < 3 - (plain_text2.length % 3); r2++) {
                plain_text[r + r2] = (char) (97 + r2);
                flag = 1;
            }
        }
///////////////                                       increament Length
        if (flag == 1) {
            plain_textlength = plain_text2.length + (3 - (plain_text2.length % 3));
        } else {
            plain_textlength = plain_text2.length;
        }
    }
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------

    public void get_key() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                key_arr[row][col] = Integer.parseInt(t_key_arr[row][col].getText());
            }
        }
    }
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------

    public void Plain_2_n() {
        for (int i = 0; i < plain_textlength; i++) {
            plain_2_n[i] = (int) plain_text[i] - 97;
        }
    }
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------  

    public void Encryption() {
        int sum;
        String s = "";
        for (int a = 0; a < plain_textlength; a = a + 3) {
            for (int row = 0; row < 3; row++) {
                sum = 0;
                for (int col = 0; col < 3; col++) {
                    int p = key_arr[row][col] * plain_2_n[col + a];
                    sum = sum + p;
                }
                sum = sum % 26;
                s = s + (char) (sum + 97);
            }
        }
        t2.setText(s);
    }
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------ 

    public int det_of_key() {
        int d = key_arr[0][0] * ((key_arr[1][1] * key_arr[2][2]) - (key_arr[1][2] * key_arr[2][1]))
                - key_arr[0][1] * ((key_arr[1][0] * key_arr[2][2]) - (key_arr[1][2] * key_arr[2][0]))
                + key_arr[0][2] * ((key_arr[1][0] * key_arr[2][1]) - (key_arr[1][1] * key_arr[2][0]));
        return d;
    }
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------ 

    public void det_of_key_inv() {
        int det = det_of_key();
        while (det < 0) {
            det = det + 26;
        }
///////
        rem[0] = 26;
        rem[1] = det;
        for (len = 0;; len++) {
            div[len] = rem[len] / rem[len + 1];
            rem[len + 2] = rem[len] % rem[len + 1];
            if (rem[len + 2] == 0) {
                break;
            }
        }
///////
        inv[len + 1] = 0;
        inv[len] = 1;
        for (int x = len; x > 0; x--) {
            inv[x - 1] = (div[x - 1] * inv[x]) + inv[x + 1];
        }
/////////
        if (rem[0] * inv[1] > rem[1] * inv[0]) {
            inv_M = -inv[0] + 26;
        } else {
            inv_M = inv[0];
        }
    }
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------ 

    public void get_minors() {
        minors_arr2[0][0] = (key_arr[1][1] * key_arr[2][2]) - (key_arr[1][2] * key_arr[2][1]);
        minors_arr2[0][1] = (key_arr[1][0] * key_arr[2][2]) - (key_arr[1][2] * key_arr[2][0]);
        minors_arr2[0][2] = (key_arr[1][0] * key_arr[2][1]) - (key_arr[1][1] * key_arr[2][0]);

        minors_arr2[1][0] = (key_arr[0][1] * key_arr[2][2]) - (key_arr[0][2] * key_arr[2][1]);
        minors_arr2[1][1] = (key_arr[0][0] * key_arr[2][2]) - (key_arr[0][2] * key_arr[2][0]);
        minors_arr2[1][2] = (key_arr[0][0] * key_arr[2][1]) - (key_arr[0][1] * key_arr[2][0]);

        minors_arr2[2][0] = (key_arr[0][1] * key_arr[1][2]) - (key_arr[0][2] * key_arr[1][1]);
        minors_arr2[2][1] = (key_arr[0][0] * key_arr[1][2]) - (key_arr[0][2] * key_arr[1][0]);
        minors_arr2[2][2] = (key_arr[0][0] * key_arr[1][1]) - (key_arr[0][1] * key_arr[1][0]);
    }
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------  

    public void signs_rule() {
        minors_arr2[0][1] = -minors_arr2[0][1];
        minors_arr2[1][0] = -minors_arr2[1][0];
        minors_arr2[1][2] = -minors_arr2[1][2];
        minors_arr2[2][1] = -minors_arr2[2][1];
    }
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------

    public void transpose() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                minors_arr[row][col] = inv_M * minors_arr2[col][row];
            }
        }
    }
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------

    public void negative_signing() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                while (minors_arr[row][col] < 0) {
                    minors_arr[row][col] = minors_arr[row][col] + 26;
                }
            }
        }
    }
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------ 
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------  

    public void Decryption() {
        int sum;
        String s = "";
        for (int a = 0; a < plain_textlength; a = a + 3) {
            for (int row = 0; row < 3; row++) {
                sum = 0;
                for (int col = 0; col < 3; col++) {
                    int p = minors_arr[row][col] * plain_2_n[col + a];
                    sum = sum + p;
                }
                sum = sum % 26;
                string_text[strint_count++ ] = (char) (sum + 97);
            }
        }
        for (int i = 0; i < plain_text2.length; i++) {
            s = s + string_text[i];

        }
        t3.setText(s);
    }
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------     
/////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////// 
    public Hill_cipher_3_3() {
        GUI();
/////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////         
        Hill_E.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                get_plan_text();
                get_key();
                Plain_2_n();
                Encryption();
            }
        });

/////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////        
        Hill_D.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                plain_text = t2.getText().toCharArray();
                Plain_2_n();
                det_of_key_inv();
                get_minors();
                signs_rule();
                transpose();
                negative_signing();
                Decryption();
            }
        });
    }

/////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////   
    public static void main(String[] args) {
        Hill_cipher_3_3 hill_cipher_3_3 = new Hill_cipher_3_3();
    }
}
