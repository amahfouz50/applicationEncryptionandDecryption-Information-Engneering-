
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

import java.util.ArrayList;

/**
 *
 * @author AhmedMahfouz
 */
public class playfare {

    static char[][] matrix = new char[5][5];

    public void fillMatrix(String key) {
        int flage = 0;
        int f_row = 0;
        int f_column = 0;
        int reply = 0;

        int w = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                ArrayList<Integer> te;
                if (key.charAt(w) == 'j') {
                    te = checkRedundant('i');
                    key = key.replace('j', 'i');

                } else {
                    te = checkRedundant(key.charAt(w));
                }
                if (te.isEmpty()) {
                    matrix[i][j] = key.charAt(w);
                    w = w + 1;

                } else {
                    w = w + 1;
                    reply += 1;

                }

                if (w == key.length()) {
                    flage = 1;
                    f_row = i;
                    f_column = j;
                    break;

                }
            }

            if (flage == 1) {
                break;
            }

        }
        if (f_column - reply < 0) {
            f_column = 5 + f_column;
            f_column = f_column - reply;
            f_row = f_row - 1;

        } else {
            f_column = f_column - reply;
        }
        remainFill(f_column, f_row);

    }

    public void remainFill(int f_column, int f_row) {
        int cha = 97;
        ArrayList<Character> t = new ArrayList<>();

        while (cha <= 122) {
            if (cha == 'j') {
                cha = cha + 1;
            }
            char c = (char) cha;

            ArrayList<Integer> te = checkRedundant(c);
            if (te.isEmpty()) {
                t.add(c);
                cha = cha + 1;
            } else {
                cha = cha + 1;
            }

        }
        int d = 0;
        int j = f_column + 1;
        for (int i = f_row; i < 5; i++) {
            for (; j < 5; j++) {
                matrix[i][j] = t.get(d);
                d = d + 1;

            }
            j = 0;
        }
        for (int i = 0; i < 5; i++) {
            for (int z = 0; z < 5; z++) {
                System.out.print(matrix[i][z] + " ");
            }
            System.out.println("");
        }

    }

    public ArrayList<ArrayList> devidePlain(String plaintext, String key) {
        fillMatrix(key);

        ArrayList<ArrayList> arr = new ArrayList<>();
        int z = 0;
        int y = 0;
        int w = 0;
        while (z < plaintext.length()) {
            if (z + 2 > plaintext.length()) {
                w = plaintext.length() - z;
                y = z + w;
            } else {
                y = z + 2;
            }
            ArrayList<Character> c = new ArrayList<>();
            for (int x = z; x < y; x++) {

                c.add(plaintext.charAt(x));

            }
            if (c.size() < 2) {
                c.add('x');
            }
            if (c.get(0) == c.get(1)) {
                c.remove(1);
                c.add('x');
                z = z - 1;

            }
            arr.add(c);

            if (z + 2 > plaintext.length()) {
                w = plaintext.length() - z;
                z = z + w;
            } else {
                z = z + 2;
            }

        }
        System.out.println(arr);
//        System.out.println( makeCipher(arr));
        return arr;

    }

    public String encrypt(String plaintext, String key) {

        String fin = "";
        ArrayList<ArrayList> cipher = devidePlain(plaintext, key);
        for (int i = 0; i < cipher.size(); i++) {
            ArrayList<Character> text = cipher.get(i);
            ArrayList<Integer> c1;
            ArrayList<Integer> c2;
            if (text.get(0) == 'j') {
                c1 = checkRedundant('i');
                c2 = checkRedundant(text.get(1));

            } else if (text.get(1) == 'j') {
                c1 = checkRedundant(text.get(0));
                c2 = checkRedundant('i');

            } else {
                c1 = checkRedundant(text.get(0));
                c2 = checkRedundant(text.get(1));

            }

            if (c1.get(0) == c2.get(0)) {
                if (c1.get(1) + 1 == 5) {
                    fin += matrix[c1.get(0)][0];
                } else {
                    fin += matrix[c1.get(0)][c1.get(1) + 1];
                }
                if (c2.get(1) + 1 == 5) {
                    fin += matrix[c2.get(0)][0];
                } else {
                    fin += matrix[c2.get(0)][c2.get(1) + 1];
                }
            } else if (c1.get(1) == c2.get(1)) {
                if (c1.get(0) + 1 == 5) {
                    fin += matrix[0][c1.get(1)];
                } else {
                    fin += matrix[c1.get(0) + 1][c1.get(1)];
                }
                if (c2.get(0) + 1 == 5) {
                    fin += matrix[0][c2.get(1)];
                } else {
                    fin += matrix[c2.get(0) + 1][c1.get(1)];
                }
            } else {
                fin += matrix[c2.get(0)][c1.get(1)];
                fin += matrix[c1.get(0)][c2.get(1)];
            }

        }
        return fin;
//        System.out.println(fin);

    }

    public String decrypt(String plaintext, String key) {

        String fin = "";
        ArrayList<ArrayList> cipher = devidePlain(plaintext, key);
        for (int i = 0; i < cipher.size(); i++) {
            ArrayList<Character> text = cipher.get(i);
            ArrayList<Integer> c1;
            ArrayList<Integer> c2;
            if (text.get(0) == 'j') {
                c1 = checkRedundant('i');
                c2 = checkRedundant(text.get(1));

            } else if (text.get(1) == 'j') {
                c1 = checkRedundant(text.get(0));
                c2 = checkRedundant('i');

            } else {
                c1 = checkRedundant(text.get(0));
                c2 = checkRedundant(text.get(1));
            }

            if (c1.get(0) == c2.get(0)) {
                if (c1.get(1) - 1 == -1) {
                    fin += matrix[c1.get(0)][4];
                } else {
                    fin += matrix[c1.get(0)][c1.get(1) - 1];
                }
                if (c2.get(1) - 1 == -1) {
                    fin += matrix[c2.get(0)][4];
                } else {
                    fin += matrix[c2.get(0)][c2.get(1) - 1];
                }
            } else if (c1.get(1) == c2.get(1)) {
                if (c1.get(0) - 1 == -1) {
                    fin += matrix[4][c1.get(1)];
                } else {
                    fin += matrix[c1.get(0) - 1][c1.get(1)];
                }
                if (c2.get(0) - 1 == -1) {
                    fin += matrix[4][c2.get(1)];
                } else {
                    fin += matrix[c2.get(0) - 1][c1.get(1)];
                }
            } else {
                fin += matrix[c2.get(0)][c1.get(1)];
                fin += matrix[c1.get(0)][c2.get(1)];
            }

        }
        return fin;

    }

    public ArrayList<Integer> checkRedundant(char c) {
        int flage = 0;
        ArrayList<Integer> return_result = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (c == matrix[i][j]) {
                    return_result.add(i);
                    return_result.add(j);
                    flage = 1;
                    break;

                } else if (matrix[i][j] == 0) {
                    flage = 1;
                    break;
                }

            }
            if (flage == 1) {
                break;
            }
        }
        return return_result;
    }

}
