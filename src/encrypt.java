 
import java.util.Scanner;
 
public class encrypt {
    
    /** Creates a new instance of encrypt */
    public encrypt(  String Plaintext, String Key) {
        
        
        
        
        PlainText=Plaintext;
        keyword=Key;
        
        
    }
    
    public String CheckLenPlain(String plain){
        if(plain.length()%8!=0) {
            int len=8-plain.length()%8;
            
            for(int i=0; i<len; i++)
                plain=plain.concat("*");
            
        } else {
            return plain;
        }
        return plain;
        
    }
    
    
    public void DoEncrpyt_Plaintext(String plain) {
        
        for(int i=0;i<8&&i<plain.length();i++) {
            block[i]=getBinaryBits(plain.charAt(i));// 2D array [8][8]
            
        }
        int index=0;
        for(int i=0; i<8; i++){
            for(int j=0; j<8;j++){
                perm[index]=(int)block[i][j];
                blockS[i][j]=Integer.toString((int)block[i][j]);
                index++;
                
            }
        }
        arrayprinter.printarray(blockS,"PlainText Text in Binary");
        DesPanel.StepsText.append("****************************************************************"+'\n');
        
    }
    
    
    public void DoEncrpyt_keyword() {
        
        
        
        for(int i=0;i<8&&i<keyword.length();i++) {
            block[i]=getBinaryBits(keyword.charAt(i));
            for(int j=0;j<8;j++) {
                
                blockS[i][j]=Integer.toString((int)block[i][j]);
                
                
            }
            //  System.out.println(" ");
        }
        
        
        int index=0;
        for(int i=0; i<8; i++){
            for(int j=0; j<8;j++){
                key_in[index]=(int)block[i][j];
                index++;
                
            }
        }
        
        arrayprinter.printarray(blockS,"KeyWord Text in Binary");
        DesPanel.StepsText.append("****************************************************************"+'\n');
        
    }
    
    public byte[] getBinaryBits(int ch) {
        byte[] bin=new byte[8];
        int tag=1;
        for(int i=0;i<8;i++) {
            bin[7-i]=(byte)((ch&((tag<<i)))>>i);
        }
        return bin;
    }
    
    public void DoSegmentation(int[] perm_out){
        int index=0;
        for(int i=0; i<32; i++)
            Left[i]=perm_out[i];
        
        for(int i=32; i<64; i++){
            Right[index]=perm_out[i];
            
            index++;
        }
        index=0;
        for(int i=0; i<4;i++){
            for(int j=0; j<8; j++){
                LeftS[i][j]=Integer.toString(Left[index]);
                RightS[i][j]=Integer.toString(Right[index]);
                index++;
            }
        }
        arrayprinter.printarray(LeftS,"Left Part");
        arrayprinter.printarray(RightS,"Right Part");
        
    }
    public void XOR(int side1[], int [] side2,int [] result){
        int index=0;
        for(int i=0; i<side1.length; i++){
            if(side1[i]==side2[i])
                result[index]=0;
            else
                result[index]=1;
            index++;
            
        }
        
        
        
        
        
    }
    public void FillC_D(){
        int index=28;
        for(int i=0; i<28; i++)
            C_D[i]=C[i];
        
        for(int i=0; i<28; i++){
            C_D[index]=D[i];
            index++;
        }
        
        
    }
    public void contancate() {
        int index=32;
        for(int i=0; i<32; i++)
            Block64[i]=Left[i];
        
        for(int i=0; i<32; i++){
            Block64[index]=Right[i];
            index++;
        }
    }
    public void swap32() {
        int temp;
        for(int i=0;i<32;i++) {
            temp=Left[i];
            Left[i]=Right[i];
            Right[i]=temp;
        }
        ind=0;
        for(int i=0; i<4;i++){
            for(int j=0; j<8; j++){
                LeftS[i][j]=Integer.toString(Left[ind]);
                RightS[i][j]=Integer.toString(Right[ind]);
                ind++;
            }
        }
        arrayprinter.printarray(LeftS,"Left Part");
        arrayprinter.printarray(RightS,"Right Part");
        ind=0;
    }
    
    public static int[] getByteFromBits(int bits64[]) {
        // int ch[]=new int[8];
        int index=0;
        System.out.println();
        for(int i=0;i<8;i++)
            for(int j=1;j<=8;j++) {
            
            
            ch[i]+=(int)Math.pow(2,(8-j))*bits64[index];
            index++;
            
            }
        
        return ch;
    }
    
    public void Chooser(int choice){
        if(choice==1){
            System.out.println("before One left shift " + index);
            for(int j=0; j<C.length; j++)
                System.out.print(C[j]);
            key.Do_OneLeftShitf(C,D);
            System.out.println();
            System.out.println("After One left shift " + index);
            for(int j=0; j<C.length; j++)
                System.out.print(C[j]);
        }
        
        else{
            
            for(int j=0; j<C.length; j++)
                System.out.print(C[j]);
            
            key.Do_OneLeftShitf(C,D);
            key.Do_OneLeftShitf(C,D);
            System.out.println(" LEFT= ");
            
            for(int j=0; j<C.length; j++)
                System.out.print(C[j]);
            
            System.out.println(" Right= ");
            
            for(int j=0; j<D.length; j++)
                System.out.print(D[j]);
            
        }
        
    }
    
    public void DoDecryption() {
        DesPanel.StepsText.append("************************DECIPHER***********************************"+'\n');
        int start=0;
      
        int counter=0;
        int end=64;
        for(int f=0; f<PlainText.length()/8; f++){
            
              int Round=1;
            for(int h=start; h<end; h++ ){
                newBlock64_[counter]=Integer.parseInt(finalEncry.substring(h,h+1));
                counter++;
            }
            DesPanel.StepsText.append("*********Block Number *********"+(f+1)+'\n');
            ind=0;
            DesPanel.StepsText.append("*********Cipher Block In Round ********* "+ Round+'\n');
            for(int d=0 ; d<8; d++){
                for(int j=0; j<8; j++){
                    newBlock64_S[d][j]=Integer.toString(newBlock64[ind]);
                    ind++;
                }
            }
            arrayprinter.printarray(newBlock64_S,"Cipher Block");
            
            
            
            p= new Permutation();
            
            p.FillPermutation();//step1 from 2D to 1D
            p.DoIP(newBlock64_,perm_out);
            DoSegmentation(perm_out);
            
            int adder=48;
            
            while(Round<=16) {
                DesPanel.StepsText.append("*********Round Number********* "+Round+'\n');
                for(int i=0; i<48; i++) {
                    reversedkey[i]=Integer.parseInt(key_reverse.substring((key_reverse.length()-adder)+i,(key_reverse.length()-adder)+i+1));
                    
                }
                System.out.println();
                ESTable Etable = new ESTable();
                Etable.FillETable();//step3 array from 2D to 1D
                Etable.DoETable(Right,Right_out);//step3
                DesPanel.StepsText.append("*********Right Part XORED with Round Key********* "+Round+'\n');
                XOR(Right_out,reversedkey,XOR_Out);//step1
                ind=0;
                for(int g=0; g<6; g++){
                    for(int j=0; j<8; j++){
                        XORS[g][j]=Integer.toString(XOR_Out[ind]);
                        ind++;
                        
                    }
                }
                arrayprinter.printarray(XORS,"XOR Result");
                ind=0;
                SBox sbox= new SBox();
                
                sbox.DoSBox(XOR_Out,after_SBox);//step2 32bits - include permitation
                DesPanel.StepsText.append("*********Left Part XORED with Output Function in Round********* "+Round+'\n');
                XOR(Left,after_SBox,aft_XOR_fuc);//XOR
                
                
                
                for(int g=0; g<4; g++){
                    for(int j=0; j<8; j++){
                        aft_XOR_fucS[g][j]=Integer.toString(aft_XOR_fuc[ind]);
                        ind++;
                        
                    }
                }
                ind=0;
                arrayprinter.printarray(aft_XOR_fucS,"XOR Result");
                
                adder=adder+48;
                Round++;
                DesPanel.StepsText.append("*********Left=Right & Right=Left*********"+'\n');
                for(int i=0;i<32;i++) {
                    Left[i]=Right[i];
                    Right[i]=aft_XOR_fuc[i];
                }
                
                
            }
            
            ind=0;
            for(int g=0; g<4; g++){
                for(int j=0; j<8; j++){
                    LeftS[g][j]=Integer.toString(Right[ind]);
                    RightS[g][j]=Integer.toString(aft_XOR_fuc[ind]);
                    ind++;
                    
                }
            }
            arrayprinter.printarray(LeftS,"Left Part");
            arrayprinter.printarray(RightS,"Right Part");
            
            DesPanel.StepsText.append("********After Swap Operation********* " +'\n');
            swap32();
            
            
            
            
            contancate();
            System.out.println("/nBit Swap :");
            for(int i=0;i<64;i++) {
                System.out.print(Block64[i]);
            }
            
            p.FillInversePermutation();//step1 from 2D to 1D
            p.DoInverseIP(Block64,newBlock64);//step1 -array
            
            System.out.println("The decyption code: ");
            for(int i=0; i<64; i++) {
                if(binDec==null)
                    binDec=Integer.toString(newBlock64[i]);
                else
                    binDec+=Integer.toString(newBlock64[i]);
                System.out.print(newBlock64[i]);
            }
            System.out.println(" ");
            ch=getByteFromBits(newBlock64);
            
            
            for(int i=0; i<8; i++){
                System.out.print((char)ch[i]);
                if(finalDecry==null)
                    finalDecry=Character.toString((char)ch[i]);
                else
                    finalDecry+=Character.toString((char)ch[i]);
            }
            
            for(int i=0; i<8; i++)
                ch[i]=0;
            start=end;
            end=end+64;
            counter=0;
            
        }
        
        
    }
    
    public String getBinDec(){
        return binDec;
    }
    public void DoEncryption(){
        DesPanel.StepsText.append("************************CIPHER***********************************"+'\n');
        DoEncrpyt_keyword();
        int start=0;
        int end=8;
        PlainText=CheckLenPlain(PlainText);
//        System.out.println("PlainTETX: "+ PlainText.substring(start,start+9));
        
        String temp;
        for(int f=0; f<PlainText.length()/8; f++){
            
            
            temp=PlainText.substring(start,end);
            
            DoEncrpyt_Plaintext(temp);
            
            
            System.out.println("The Orginal Massage code: ");
            for(int i=0;i<64;i++) {
                if(binCi==null)
                    binCi=Integer.toString(perm[i]);
                else
                    binCi+=Integer.toString(perm[i]);
                System.out.print(perm[i]);
            }
            int Round=1;
            
            DesPanel.StepsText.append("*********Block Number *********"+(f+1)+'\n');
            System.out.println(" ");
            Permutation p= new Permutation();
            p.FillPermutation();//step1 from 2D to 1D
            p.DoIP(perm,perm_out);//step1 -array
            DoSegmentation(perm_out);//step2 to Left and Right
            // Here u will work on Right (32 Bits ) & Left 32 Bits
            ////////////////////////////////////////////////////////////////////////
            /////////////////////////////key Generation////////////////////////////
            
            key.FillPC_1();//step1 -array
            System.out.println();
            DesPanel.StepsText.append("*********Key Generation*********" +'\n');
            key.DoPC_1(key_in,key_out);//step1
            
            key.DoSegementation(key_out,C,D);//step2
            
            while(Round<=16) {
                DesPanel.StepsText.append("*********Round Number********* "+Round+'\n');
                
                int chooser=num_Left[index_chooser];
                ESTable Etable = new ESTable();
                Etable.FillETable();//step3 array from 2D to 1D
                Etable.DoETable(Right,Right_out);//step3
                
                ////////////////////////////////////////////////////////////////////////
                System.out.println();
                Chooser(chooser);//step 3 - shift
                System.out.println("Chooser = "+chooser);
                key.FillPC_2();//step4 array
                FillC_D();//step4 contacnate 56bits
                DesPanel.StepsText.append("*********Key For Round Number********* "+Round+'\n');
                key.DoPC_2(C_D,final_key);//step4 here the key of Round 1
                for(int i=0; i<48;i++) {
                    if(key_reverse==null)
                        key_reverse=Integer.toString(final_key[i]);
                    else
                        key_reverse+=Integer.toString(final_key[i]);
                    
                }
                
                
                ////////////////////////////////////////////////////////////////////////
                ////////////////////////////////////////////////////////////////////////
                DesPanel.StepsText.append("*********Right Part XORED with Round Key********* "+Round+'\n');
                XOR(Right_out,final_key,XOR_Out);//step1
                ind=0;
                for(int g=0; g<6; g++){
                    for(int j=0; j<8; j++){
                        XORS[g][j]=Integer.toString(XOR_Out[ind]);
                        ind++;
                        
                    }
                }
                ind=0;
                
                arrayprinter.printarray(XORS,"XOR Result");
                System.out.print("\nXOR :");
                for(int j=0;j<48;j++) {
                    System.out.print(XOR_Out[j]);
                }
                SBox sbox= new SBox();
                
                sbox.DoSBox(XOR_Out,after_SBox);//step2 32bits - include permitation
                System.out.print("\nS-BOX :");
                for(int j=0;j<32;j++) {
                    System.out.print(after_SBox[j]);
                }
                System.out.print("\n AFter XOR  :");
                DesPanel.StepsText.append("*********Left Part XORED with Output Function in Round********* "+Round+'\n');
                XOR(Left,after_SBox,aft_XOR_fuc);//XOR
                
                
           
                for(int g=0; g<4; g++){
                    for(int j=0; j<8; j++){
                        aft_XOR_fucS[g][j]=Integer.toString(aft_XOR_fuc[ind]);
                        ind++;
                        
                    }
                }
                ind=0;
                arrayprinter.printarray(aft_XOR_fucS,"XOR Result");
                
                for(int j=0;j<32;j++) {
                    System.out.print(aft_XOR_fuc[j]);
                }
                
                
                Round++;
                index++;
                index_chooser++;
                
                DesPanel.StepsText.append("*********Left=Right & Right=Left*********"+'\n');
                for(int i=0;i<32;i++) {
                    Left[i]=Right[i];
                    Right[i]=aft_XOR_fuc[i];
                }
                
                ind=0;
                for(int g=0; g<4; g++){
                    for(int j=0; j<8; j++){
                        LeftS[g][j]=Integer.toString(Right[ind]);
                        RightS[g][j]=Integer.toString(aft_XOR_fuc[ind]);
                        ind++;
                        
                    }
                }
                arrayprinter.printarray(LeftS,"Left Part");
                arrayprinter.printarray(RightS,"Right Part");
                
                
            }
            
            DesPanel.StepsText.append("********After Swap Operation*********"+'\n');
            swap32();
            
            contancate();
            System.out.println("/nBit Swap :");
            for(int i=0;i<64;i++) {
                System.out.print(Block64[i]);
            }
            
            p.FillInversePermutation();//step1 from 2D to 1D
            DesPanel.StepsText.append("********* Inverse Permutation Operation in Round *********"+(f+1)+'\n');
            p.DoInverseIP(Block64,newBlock64);//step1 -array
            System.out.println(" ");
            System.out.println("/nThe Encyption code: ");
            for(int i=0; i<newBlock64.length; i++){
                System.out.print(newBlock64[i]);
                if(finalEncry==null)
                    finalEncry=Integer.toString(newBlock64[i]);
                else
                    finalEncry+=Integer.toString(newBlock64[i]);
                
            }
            start=end;
            end=end+8;
            index_chooser=0;
            
        }
        System.out.println("");
        System.out.println("Final :"+ finalEncry);
        
        
        
    }
    public String getEncryption(){
        return finalEncry;
    }
    
    public String getDecryption(){
        return finalDecry;
    }
    public String getBinCi(){
        return binCi;
    }
    private int ind=0;
    private String binDec;
    private String binCi;
    private  static Permutation p;
    private String keyword;
    private int index_chooser=0;
    private String PlainText;
    private static int index=0;
    private String cyphir;
    private static int [] reversedkey=new int[48];
    private static String key_reverse ;
    private static  KeyGen key=new KeyGen();
    private static int Block64[]=new int[64];
    private static int[]num_Left= {1,1,2,2,2,2,2,2,1,2,2,2,2,2,2,1};
    private static int ch[]=new int[8];
    private static int newBlock64[]=new int[64];
    private static int [] aft_XOR_fuc=new int[32];
    private static String [][] aft_XOR_fucS=new String[4][8];
    private static int [] after_SBox=new int[32];
    private static int[] C_D=new int[56];
    private static int[] XOR_Out=new int[48];
    private static int key_in[]=new int[64];
    private static int final_key[]=new int[48];
    private static int key_out[]=new int[56];
    private static int [] Left=new int[32];
    private static int[] Right=new int[32];
    private static int[] Right_out=new int[48];
    private static int[] perm=new int[64];
    private static int[] perm_out= new int[64];
    private static int  newBlock64_[]=new int[64];
    private static int C[]=new int[28];
    private static int D[]=new int[28];
    private byte[][] block=new byte[8][8];
    private String [][] blockS= new String[8][8];
    private String finalEncry;
    private String finalDecry;
    private String Plain_Dec;
    private String LeftS[][] = new String[4][8];
    private String RightS[][] = new String[4][8];
    private String XORS[][] = new String[6][8];
    private String [][] newBlock64_S = new String[8][8];
}
 
