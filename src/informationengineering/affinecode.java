
/*
 *   I am Ahmed Reda Mahfouz
 *   Student at the Faculty of Computing and Information Menoufia University 
 *   Department of Computer Science
 *
 *   *       Please Visit us at www.github.com/amahfouz50     *
 *  This Program was Developed by www.github.com/amahfouz50 forums Team
 *  *           Please Don't Remove This Comment       *
 */
/**
 *
 * @author Ahmed Mahfouz
 */
package informationengineering;

/**
 *
 * @author AhmedMahfouz
 */
public class affinecode {

    char plan_text[];
    int k;
    static int m;
    int inv_M = 0;
    int len = 0;
    int div[] = new int[22];
    int rem[] = new int[22];
    int inv[] = new int[22];
//----------------------------\

    void get_plan_text(String t1) {
        plan_text = new char[22];
        plan_text = t1.toCharArray();
    }
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------

    void get_key(String t2) {
        k = Integer.parseInt(t2);
    }
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------  

    void get_mul(String t3) {
        m = Integer.parseInt(t3);
    }
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------

    public String Affine_Encryption() {
        String f = "";
        for (int i = 0; i < plan_text.length; i++) {
            int p = (int) plan_text[i] - (int) 'a';
            //   System.out.println(p);
            int c = ((m * p) + k) % 26;
            char r = (char) (c + (int) 'a');
            f = f + r;
        }
        return f;
    }
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------

    public void get_inverse() {
        rem[0] = 26;
        rem[1] = m;
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

    public String Affine_Decryption() {

        String f = "";
        for (int i = 0; i < plan_text.length; i++) {
            int c = (int) plan_text[i] - (int) 'a';
            int p = inv_M * (c - k);
//////////            
            if (p < 0) {
                for (int j = 1;; j++) {
                    p = p + (j * 26);
                    if (p > 0) {
                        break;
                    }
                }
            }
/////////////            
            p = p % 26;
            char r = (char) (p + (int) 'a');
            f = f + r;
        }
        return f;
    }
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------           

    public static int findGCD(int number1, int number2) {
        if (number2 == 0) {
            return number1;
        }
        return findGCD(number2, number1 % number2);
    }
}
