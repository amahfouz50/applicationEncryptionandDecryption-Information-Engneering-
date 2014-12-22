
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

class Permutation {

    /**
     * Creates a new instance of Permutation
     */
    public Permutation() {

    }

    public void FillPermutation() {
        int index = 0;
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                store_num[index] = permutation[row][col];/// from 2D to 1 D
                index++;
            }
        }

    }

    public void FillInversePermutation() {
        int index = 0;
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                store_num[index] = inverperm[row][col];/// from 2D to 1 D
                index++;
            }
        }

    }

    public void DoIP(int[] perm_in, int[] perm_out) {
        int temp = 0;
        int i = 0;
        int loop = 0;
        int check = 0;
        while (perm_in.length != check) {
            temp = store_num[i];
            if (temp == loop) {
                perm_out[check] = perm_in[loop - 1];
                loop = 0;
                check++;
                i++;
            }
            loop++;
        }
        System.out.println("The Permutted output");
        for (int j = 0; j < perm_out.length; j++) {
            System.out.print(perm_out[j]);

        }
        int index = 0;
        for (int g = 0; g < 8; g++) {
            for (int j = 0; j < 8; j++) {
                permS[g][j] = Integer.toString(perm_in[index]);
                index++;
            }
        }

        arrayprinter.printarray(permS, "After Initial Permutation");

    }

    public void DoInverseIP(int[] perm_in, int[] perm_out) {
        int temp = 0;
        int i = 0;
        int loop = 0;
        int check = 0;
        while (perm_in.length != check) {
            temp = store_num[i];
            if (temp == loop) {
                perm_out[check] = perm_in[loop - 1];
                loop = 0;
                check++;
                i++;
            }
            loop++;
        }
        int index = 0;
        for (int d = 0; d < 4; d++) {
            for (int j = 0; j < 8; j++) {
                newBlock64[d][j] = Integer.toString(perm_out[index]);

                index++;
            }
        }
        arrayprinter.printarray(newBlock64, "After IP");

    }
    private int[] store_num = new int[64];
    private int permutation[][] = {{58, 50, 42, 34, 26, 18, 10, 2},
    {60, 52, 44, 36, 28, 20, 12, 4},
    {62, 54, 46, 38, 30, 22, 14, 6},
    {64, 56, 48, 40, 32, 24, 16, 8},
    {57, 49, 41, 33, 25, 17, 9, 1},
    {59, 51, 43, 35, 27, 19, 11, 3},
    {61, 53, 45, 37, 29, 21, 13, 5},
    {63, 55, 47, 39, 31, 23, 15, 7}};

    private int inverperm[][]
            = {{40, 8, 48, 16, 56, 24, 64, 32},
            {39, 7, 47, 15, 55, 23, 63, 31},
            {38, 6, 46, 14, 54, 22, 62, 30},
            {37, 5, 45, 13, 53, 21, 61, 29},
            {36, 4, 44, 12, 52, 20, 60, 28},
            {35, 3, 43, 11, 51, 19, 59, 27},
            {34, 2, 42, 10, 50, 18, 58, 26},
            {33, 1, 41, 9, 49, 17, 57, 25}};
    private String permS[][] = new String[8][8];
    private String newBlock64[][] = new String[4][8];

}
