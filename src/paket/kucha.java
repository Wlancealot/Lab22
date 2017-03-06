package paket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import paket.Gammo;

public class kucha {
    public kucha() {
    }

    public static void main(String[] args) throws Exception  {
        int i = -1;
        byte[] encryptedByteArray;

        while (i != 0) {
            System.out.println("Vibery deistvie");

            System.out.println("1-> XOR");

            System.out.println("2-> Cicle");

            System.out.println("3-> pozicii");

            System.out.println("4-> exit");

            Scanner in = new Scanner(System.in);
            i = in.nextInt();
            BufferedReader reader = new BufferedReader( new InputStreamReader (System.in));
            switch (i) {
                case 1:
                    String pKey = "sekret";
                    System.out.print("Введите строку: ");
                    String pText = reader.readLine();
                    encryptedByteArray = encode(pText, pKey);
                    decode(encryptedByteArray, pKey);
                    break;
                case 2:
                    System.out.print("Введите строку: ");
                    String str = reader.readLine();
                    System.out.println("Ключ: ");
                    String key1 = reader.readLine();
                    int key = Integer.parseInt(key1);
                    Gammo x = new Gammo(str, key);
                    x.Print();
                    System.out.println("Шифрование..");
                    x.SHIFR();
                    x.Print();
                    System.out.println("Расшифровывание..");
                    x.DESHIFR();
                    x.Print();
                    break;
                case 3:
                    ;
                    break;
                case 4:
                    System.exit(0);
                    break;
                default: System.out.println("Введите число от 1 до 3");
                    break;

            }

        }
    }
      public static byte[] encode(String ppText, String pKey) { // Strings are immutable, you must return result
        // Если возвращать String то работает только с ASCII 127 - символов.
        //String retStr;
        byte[] txt = ppText.getBytes();
        byte[] key = pKey.getBytes();
        byte[] res = new byte[txt.length]; // not String length, but byte array length

        for(int i = 0; i < txt.length; i++) {
            res[i] = (byte)(txt[i] ^ key[i % key.length]);
        }
        //retStr = new String(res); // result String
        System.out.println("Encoded bytes: " + Arrays.toString(res));
        return res;
      }

     public static void  decode(byte[] ppText, String pKey) {
        String resStr;
        byte[] res = new byte[ppText.length];
         byte[] key = pKey.getBytes();

        for(int i = 0; i < ppText.length; i++) {
            res[i] = (byte)(ppText[i] ^ key[i % key.length]);
        }
        resStr = new String(res); // result String
        System.out.println("Decoded string: " + resStr);

    }
}
