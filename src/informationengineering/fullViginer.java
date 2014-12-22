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
public class fullViginer {
    
    public String encrypt(String s,String key){
        int arr[]=new int[s.length()];
        int ar[]=new int[key.length()];
         
        String outer="";
        String all="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String ss=s.toUpperCase();
        String keys=key.toUpperCase();
        
        if(ss.length()==0)
            System.out.println("not data enter ");
            else{
            for(int i=0;i<ss.length();i++){
                for(int n=0;n<all.length();n++){
                    if(ss.charAt(i)==all.charAt(n)){
                        arr[i]=n;
break;
                     }
                }
                
            }
             for(int i=0;i<keys.length();i++){
                for(int n=0;n<all.length();n++){
                    if(keys.charAt(i)==all.charAt(n)){
                        ar[i]=n;
 
                        break;
                    }}}}
        int j=0;
        for(int i=0;i<ss.length();i++){
           
           outer+=all.charAt(((arr[i]+(ar[j]))%26));
            j++;
           if(j==ar.length)j=0;
         //   outer="aay bn ";
        }
         return outer;
    }
    
        public String decrypt(String s,String key){
        int arr[]=new int[s.length()];
        int ar[]=new int[key.length()];
         
        String outer="";
        String all="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String ss=s.toUpperCase();
        String keys=key.toUpperCase();
        
        if(ss.length()==0)
            System.out.println("not data enter ");
            else{
            for(int i=0;i<ss.length();i++){
                for(int n=0;n<all.length();n++){
                    if(ss.charAt(i)==all.charAt(n)){
                        arr[i]=n;
break;
                     }
                }
                
            }
             for(int i=0;i<keys.length();i++){
                for(int n=0;n<all.length();n++){
                    if(keys.charAt(i)==all.charAt(n)){
                        ar[i]=n;
 
                        break;
                    }}}}
        int j=0;
        for(int i=0;i<ss.length();i++){
            int x=arr[i]-(ar[j]);
           if(x>=0){
           outer+=all.charAt(x%26);}
           else{ 
               x+=26;
               outer+=all.charAt(x%26);}
            j++;
           if(j==ar.length)j=0;
         //   outer="aay bn ";
        }
         return outer;
    }
    
}
