
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
public class fullViginer {

    public String encrypt(String s, String key) {
        int arr[] = new int[s.length()];
        int ar[] = new int[key.length()];

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
                        arr[i] = n;
                        break;
                    }
                }

            }
            for (int i = 0; i < keys.length(); i++) {
                for (int n = 0; n < all.length(); n++) {
                    if (keys.charAt(i) == all.charAt(n)) {
                        ar[i] = n;

                        break;
                    }
                }
            }
        }
        int j = 0;
        for (int i = 0; i < ss.length(); i++) {

            outer += all.charAt(((arr[i] + (ar[j])) % 26));
            j++;
            if (j == ar.length) {
                j = 0;
            }
            //   outer="aay bn ";
        }
        return outer;
    }

    public String decrypt(String s, String key) {
        int arr[] = new int[s.length()];
        int ar[] = new int[key.length()];

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
                        arr[i] = n;
                        break;
                    }
                }

            }
            for (int i = 0; i < keys.length(); i++) {
                for (int n = 0; n < all.length(); n++) {
                    if (keys.charAt(i) == all.charAt(n)) {
                        ar[i] = n;

                        break;
                    }
                }
            }
        }
        int j = 0;
        for (int i = 0; i < ss.length(); i++) {
            int x = arr[i] - (ar[j]);
            if (x >= 0) {
                outer += all.charAt(x % 26);
            } else {
                x += 26;
                outer += all.charAt(x % 26);
            }
            j++;
            if (j == ar.length) {
                j = 0;
            }
            //   outer="aay bn ";
        }
        return outer;
    }

}
