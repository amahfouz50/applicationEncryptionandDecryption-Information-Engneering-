/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
