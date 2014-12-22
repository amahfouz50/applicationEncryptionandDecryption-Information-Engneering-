/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informationengineering;

import javax.swing.JOptionPane;

/**
 *
 * @author AhmedMahfouz
 */
public class RSAcode {
    int e , p ,q,d,n;
    // the sheet algorithm for computing RSAcode Algorithm
    
    public String encrypt (String plain){
        String sb = null;
        e=5;//an odd number
        p=7;
        q=17; // two prime numbers
        
        if (((((p-1)*(q-1))-1)%e)==0){
            
            n=p*q; //public key
            d=((p-1)*(q-1)*(e-1)+1)/e ;
            
            for (int i = 0; i < plain.length(); i++) {
                int mTemp= plain.codePointAt(i)-97;
                
                sb +=(int)(Math.pow(mTemp, e)%n) +"";   //cipher = m^e mod n
                
            }
            
        }
        
        return sb;
    }
    
    public StringBuilder decrept (String cipher){
        StringBuilder sb=new StringBuilder();
         e=Integer.parseInt(JOptionPane.showInputDialog("enter private  key ")); //an odd number
        p=Integer.parseInt(JOptionPane.showInputDialog("enter p key "));;
        q=Integer.parseInt(JOptionPane.showInputDialog("enter q key "));; // two prime numbers
       
        if (((((p-1)*(q-1))-1)%e)==0){
            
            n=p*q; //public key
            d=((p-1)*(q-1)*(e-1)+1)/e ;
            
            for (int i = 0; i < cipher.length(); i++) {
                int mTemp= cipher.codePointAt(i)-97;
                
                sb.append((int)(Math.pow(mTemp, d)%n));   //cipher = m^e mod n
                
            }
            
        }
        
        return sb;
    }
    
    public static void main(String[] args) {
      new RSAcode().encrypt("l");
    }
}
