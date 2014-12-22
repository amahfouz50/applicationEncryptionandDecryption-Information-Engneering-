
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
public class combinationcode {

    char matrix[][] = new char[5][5];
    char plain_text[] = new char[55];
    char first[] = new char[66];
    int first_count = 0;

    public void get_plain_text(String t1) {
        plain_text = new char[22];
        plain_text = t1.toCharArray();

    }
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------

    public void create_matrix() {
        int alpha = 97;
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                matrix[row][col] = (char) alpha++;
            }
        }
    }
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------   

    public void generate_first_arr(int flag) {
        first_count = 0;
        for (int string_count = 0; string_count < plain_text.length; string_count++) {
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 5; col++) {
///////////////////////                    
//                    if (plain_text[string_count] == 'z') {
//                        if (flag == 0) {
//                            first[first_count++] = 'd';
//                            first[first_count++] = 'b';
//                        }
//                    }
/////////////////////
                    if (plain_text[string_count] == matrix[row][col]) {
///////////////////////                      
                        if (flag == 0) {
                            first[first_count++] = matrix[0][row];
                            first[first_count++] = matrix[0][col];
                        }
/////////////////////////                        
                        if (flag == 1) {
                            first[string_count] = matrix[0][row];
                            first[string_count + plain_text.length] = matrix[0][col];
                        }
/////////////////////////
                    }
                }
            }
        }
    }
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------   

    public String generate_cipher() {//takemetoyourleader
        String s = "";
        int row = 0;
        int col = 0;
        for (int r = 0; r < plain_text.length; r++) {
            for (int z = 0; z < 5; z++) {
                if (first[r] == matrix[0][z]) {
                    row = z;
                }
                if (first[r + plain_text.length] == matrix[0][z]) {
                    col = z;
                }
            }
            s = s + matrix[row][col];
        }
        return (s);
    }
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------  

    public String generate_plain() {
        String s = "";
        int row = 0;
        int col = 0;
        for (int r = 0; r < plain_text.length * 2; r = r + 2) {
            for (int z = 0; z < 5; z++) {
                if (first[r] == matrix[0][z]) {
                    row = z;
                }
                if (first[r + 1] == matrix[0][z]) {
                    col = z;
                }
            }
            s = s + matrix[row][col];
        }
        return (s);
    }
}
