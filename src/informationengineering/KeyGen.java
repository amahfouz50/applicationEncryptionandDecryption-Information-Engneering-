
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

public class KeyGen {

    /**
     * Creates a new instance of KeyGen
     */
    public KeyGen() {

    }

    public void FillPC_1() {
        int index = 0;
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 7; col++) {
                store_num[index] = PC_1[row][col];
                index++;
            }
        }
    }

    public void FillPC_2() {
        int index = 0;
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 6; col++) {
                store_num1[index] = PC_2[row][col];
                index++;
            }
        }
    }

    public void DoPC_1(int[] key_in, int[] key_out) {
        int temp = 0;
        int i = 0;
        int loop = 0;
        int check = 0;
        while (check != 56) {
            temp = store_num[i];
            if (temp == loop) {
                key_out[check] = key_in[loop - 1];
                loop = 0;
                check++;
                i++;
            }
            loop++;
        }

        System.out.println("The Permutted key");
        for (int j = 0; j < key_out.length; j++) {
            System.out.print(key_out[j]);
        }

        int index = 0;
        for (int g = 0; g < 7; g++) {
            for (int j = 0; j < 8; j++) {
                keyS[g][j] = Integer.toString(key_out[index]);
                index++;
            }
        }

        arrayprinter.printarray(keyS, "After PC-1");
    }

    public void DoPC_2(int[] key_in, int[] key_out) {
        int temp = 0;
        int i = 0;
        int loop = 0;
        int check = 0;
        while (check != 48) {
            temp = store_num1[i];
            if (temp == loop) {
                key_out[check] = key_in[loop - 1];
                loop = 0;
                check++;
                i++;
            }
            loop++;
        }

        int index = 0;
        for (int g = 0; g < 6; g++) {
            for (int j = 0; j < 8; j++) {
                finalS[g][j] = Integer.toString(key_out[index]);
                index++;
            }
        }

        arrayprinter.printarray(finalS, "After PC-2");
        index = 0;
    }

    public void DoSegementation(int[] key_out, int[] C, int[] D) {
        int index = 0;
        for (int i = 0; i < 28; i++) {
            C[i] = key_out[i];
        }

        for (int i = 28; i < 56; i++) {
            D[index] = key_out[i];

            index++;
        }

        index = 0;
        for (int g = 0; g < 4; g++) {
            for (int j = 0; j < 7; j++) {
                cS[g][j] = Integer.toString(key_out[index]);
                index++;
            }

        }

        for (int g = 0; g < 4; g++) {
            for (int j = 0; j < 7; j++) {
                dS[g][j] = Integer.toString(key_out[index]);
                index++;
            }

        }
        index = 0;

        arrayprinter.printarray(cS, "Segment Key to C part");
        arrayprinter.printarray(dS, "Segment Key to D part");
    }

    public void Do_OneLeftShitf(int[] side1, int[] side2) {

        int temp = side1[0];
        for (int i = 1; i < side1.length; i++) {

            side1[i - 1] = side1[i];

        }
        side1[side1.length - 1] = temp;
        temp = side2[0];
        for (int i = 1; i < side2.length; i++) {

            side2[i - 1] = side2[i];

        }
        side2[side2.length - 1] = temp;

        System.out.println("After One left shift");
        for (int j = 0; j < side1.length; j++) {
            System.out.print(side1[j]);
        }
    }

    private int[] store_num = new int[56];
    private int[] store_num1 = new int[48];
    private int[][] PC_1 = {{57, 49, 41, 33, 25, 17, 9},
    {1, 58, 50, 42, 34, 26, 18},
    {10, 2, 59, 51, 43, 35, 27},
    {19, 11, 3, 60, 52, 44, 36},
    {63, 55, 47, 39, 31, 23, 15},
    {7, 62, 54, 46, 38, 30, 22},
    {14, 6, 61, 53, 45, 37, 29},
    {21, 13, 5, 28, 20, 12, 4}
    };
    private int[][] PC_2 = {{14, 17, 11, 24, 1, 5},
    {3, 28, 15, 6, 21, 10},
    {23, 19, 12, 4, 26, 8},
    {16, 7, 27, 20, 13, 2},
    {41, 52, 31, 37, 47, 55},
    {30, 40, 51, 45, 33, 48},
    {44, 49, 39, 56, 34, 53},
    {46, 42, 50, 36, 29, 32}
    };
    private String key;
    private String keyS[][] = new String[7][8];
    private String cS[][] = new String[4][7];
    private String dS[][] = new String[4][7];
    private String finalS[][] = new String[6][8];

}
