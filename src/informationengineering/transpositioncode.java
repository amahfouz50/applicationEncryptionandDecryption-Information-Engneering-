
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
public class transpositioncode {

    char plan_text[];
    char real_plan_text[];
    char key[] = new char[22];
    char key_copy[];
    int index[] = new int[22];
    char k[];
    int K_C;
    int kk;
    String result;
    char[] alphabet = {' ', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public void plan_text_arr(String t1) {
        plan_text = new char[22];
        plan_text = t1.toCharArray();
    }
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------

    public void key_arr(String t2) {
        k = new char[22];
        k = t2.toCharArray();
        key_copy = t2.toCharArray();
    }
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------

    public void key_distribution() {
        K_C = 0;
        for (int i = 0; i < plan_text.length; i++) {
            if (K_C == k.length) {
                K_C = 0;
            }
            key[i] = k[K_C++];
        }
    }
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------    
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------

    public void selectionsort() {
        int in, out, min;
        for (out = 0; out < k.length; out++) {
            min = out;
            for (in = out + 1; in < k.length; in++) {
                if (k[in] < k[min]) {
                    min = in;
                }
            }
            char y = k[out];
            k[out] = k[min];
            k[min] = y;
        }
    }
//////////////////////
    ///////////////////////////

    public void key_order() {
        selectionsort();

        for (int i = 0; i < k.length; i++) {
            for (int ii = 0; ii < k.length; ii++) {
                if (k[i] == key_copy[ii]) {
                    index[i] = ii;
                }
            }
        }
    }

    public static String decryp(String txt, String key) {
        String s = null;

        int[] arrayindex = new int[key.length()];

        double levels = Math.ceil((txt.length() / key.length()));
        char[] arrange = new char[key.length()];
        for (int i = 0; i < key.length(); i++) {
            for (int j = 0; j < key.length(); j++) {
                if (key.charAt(i) <= key.charAt(j)) {
                    arrayindex[i] = j;
                }

            }
        }

        char[][] text = new char[(int) levels][key.length()];
        int x = 0;
        for (int i = 0; i < key.length(); i++) {
            for (int j = 0; j < levels; j++) {
                text[j][i] = txt.charAt(x++);
            }
        }
        int p = key.length() - 1;

        return s;
    }
//    public static void main(String[] args) {
//        transpositioncode c=new transpositioncode();
//        c.decryp("ndreeowem", "sec");
//    }

}
