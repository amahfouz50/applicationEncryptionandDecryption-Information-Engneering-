
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

public class PolyAlphabet {

    public String encrypt(String s, String key) {
        int x = 0;
        int b = 0;
        int[] arr = new int[s.length()];
        int[] ar = new int[key.length()];
        String outer = "";
        String all = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String ss = s.toUpperCase();
        String keys = key.toUpperCase();
        if (ss.length() == 0) {
            System.out.println("not data enter ");
        } else {
            for (int i = 0; i < ss.length(); i++) {

                for (int n = 0; n < all.length(); n++) {
                    if (ss.charAt(i) == all.charAt(n)) {
//                   b=n;
                        arr[i] = n;

                        break;
                    }
                }
            }
            //  }
            for (int z = 0; z < keys.length(); z++) {
                for (int n = 0; n < all.length(); n++) {

                    if (keys.charAt(z) == all.charAt(n)) {
                        ar[z] = n;
                        break;
                    }

                }
            }
        }
        for (int z = 0; z < ss.length(); z++) {
            outer += all.charAt((arr[z] + ar[z % (keys.length())]) % 26);

        }

        return outer;
    }

    public String decrypt(String s, String key) {
        int x = 0;
        int b = 0;
        int[] arr = new int[s.length()];
        int[] ar = new int[key.length()];
        String outer = "";
        String all = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String ss = s.toUpperCase();
        String keys = key.toUpperCase();
        if (ss.length() == 0) {
            System.out.println("not data enter ");
        } else {
            for (int i = 0; i < ss.length(); i++) {

                for (int n = 0; n < all.length(); n++) {
                    if (ss.charAt(i) == all.charAt(n)) {
//                   b=n;
                        arr[i] = n;

                        break;
                    }
                }
            }

            for (int z = 0; z < keys.length(); z++) {
                for (int n = 0; n < all.length(); n++) {

                    if (keys.charAt(z) == all.charAt(n)) {
                        ar[z] = n;
                        break;
                    }

                }
            }
        }
//                for(int z=0;z<ss.length();z++){
//                    if(keys.charAt(i)==all.charAt(z)){
//                        x=b+z;
//                        outer+=all.charAt(x%27);
//                         System.out.println("second");
//                        x=0;
//                        break;
//                    }
//                }

        for (int z = 0; z < ss.length(); z++) {
            if ((arr[z] - (ar[z % (keys.length())])) >= 0) {

                outer += all.charAt((arr[z] - (ar[z % (keys.length())])));
            } else {
                outer += all.charAt((arr[z] - (ar[z % (keys.length())])) + 27);

            }
        }

        return outer;

    }

}
