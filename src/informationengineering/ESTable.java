
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
 *   @author Ahmed Mahfouz
 */

package informationengineering;

 
 

public class ESTable {
    
    /** Creates a new instance of ESTable */
    public ESTable() {
    }
    
    public void FillETable()   {
        int index=0;
        for(int row=0;row<8; row++){
            for(int col=0; col<6; col++){
                store_num[index]=ETable[row][col];
                index++;
            }
        }
        
    }
    public void DoETable(int [] Right_in, int [] Right_out){
        int temp=0;
        int i=0;
        int loop=0;
        int check=0;
        while(check!=48){
            temp=store_num[i];
            if(temp==loop){
                Right_out[check]=Right_in[loop-1];
                loop=0;
                check++;
                i++;
            }
            loop++;
        }
            System.out.println(" ");
            System.out.print(" E- table ");
        for(int j=0;j<48;j++)
            System.out.print(Right_out[j]);
            int index=0;
            for(int g=0; g<6; g++){
                for(int j=0; j<8; j++){
                    RightS[g][j]=Integer.toString(Right_out[index]);
                    index++;
                }
            }
            arrayprinter.printarray(RightS,"After E-Table");
        index=0;
    }
    
    
    private int[] store_num= new int[48];
    private int [][] ETable= {{32, 1, 2, 3, 4, 5},
    {4 ,5 ,6 ,7 ,8 ,9},
    {8 ,9 ,10 ,11 ,12 ,13},
    {12 ,13 ,14 ,15 ,16 ,17},
    {16, 17, 18, 19, 20, 21},
    {20, 21, 22, 23, 24, 25},
    {24, 25, 26, 27, 28, 29},
    {28, 29, 30, 31, 32, 1}};
    private String RightS[][] = new String[6][8];
}
 