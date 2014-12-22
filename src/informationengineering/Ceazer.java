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

/**
 *
 * @author AhmedMahfouz
 */
public class Ceazer {
    
    public String encrypt(String s,int z){
        String outer="";
        String all=" ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String ss=s.toUpperCase();
        if(ss.length()==0)
            System.out.println("not data enter");
        else
        {
        for(int i=0;i<s.length();i++){
            for(int n=0;n<all.length();n++){
                if(ss.charAt(i)==all.charAt(n)){
                    int c=(n+z)%27;
                    outer+=all.charAt(c);
                    break;
            }

        }
        }
        
    }
    return outer;
    }
    
    public String decrypt(String s,int z){
        String outer="";
        String all=" ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String ss=s.toUpperCase();
        if(ss.length()==0)
            System.out.println("not data enter");
        else
        {
        for(int i=0;i<s.length();i++){
            for(int n=0;n<all.length();n++){
                if(ss.charAt(i)==all.charAt(n)){
                    int c=(n-z)%27;
                    if(c<0)
                        c=c+27;
                    outer+=all.charAt(c);
                    break;
            }

        }
        }
        System.out.println(outer);
    }
        
        return outer;
    }
    
    
    
}
