
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

public class arrayprinter {

    /**
     * Creates a new instance of arrayprinter
     */
    public arrayprinter() {
    }

    public static void printarray(String[][] arr, String label) {
        DesPanel.StepsText.append("-- " + label + " -- " + '\n');
        //System.out.println("-- "+label+" -- ");
        for (int i = 0; i < arr.length; i++) {
            DesPanel.StepsText.append("| ");
            for (int j = 0; j < arr[0].length; j++) {

                DesPanel.StepsText.append(arr[i][j] + " ");
            }
            DesPanel.StepsText.append("| " + '\n');
        }
    }
}
