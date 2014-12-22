package informationengineering;


 import java.io.UnsupportedEncodingException;

 
public class ReversedBinary {

    public static String  encrypt(String txt1,String txt2) throws UnsupportedEncodingException {
        String x=txt1;
        String y=txt2;
        byte[] infoBin = null;
        infoBin = x.getBytes("UTF-8");
        byte[] infoBin2 = null;
        infoBin2 = y.getBytes("UTF-8");
                String [] binary=new String[infoBin.length];
                                String [] binary2=new String[infoBin.length];
                      String [] binary3=new String[infoBin.length];


int i=0;
        for (byte b : infoBin) {
 
             binary[i]=Integer.toBinaryString(b);
             i++;
             if(i>=binary.length)i=0;
    }
        
            for (byte b : infoBin2) {
 
             binary2[i]=Integer.toBinaryString(b);
             i++;
             if(i>=binary2.length)i=0;
    }
            
            String Ciper="";
        for(int c=0;c<binary.length;c++){
             binary3[i]="";
            for(int p=0;p<binary[c].length();p++){
            if(binary[i].charAt(p)==binary2[i].charAt(p)){
            binary3[i]+='0';
            }
            else{
                        binary3[i]+='1';

            }
            }
            System.out.println(binary[c]+"--"+binary2[c]+"--"+binary3[i]);
    //   int num = Integer.parseInt(binary3[i],2);
           
            int num=integerfrmbinary(binary3[i]);
            Ciper+=(num);    
        }
        return Ciper;
    
}
public static int integerfrmbinary(String str){
    double j=0;
    for(int i=0;i<str.length();i++){
        if(str.charAt(i)== '1'){
         j=j+ Math.pow(2,str.length()-1-i);
     }

    }
    return  (int) j;

}  }