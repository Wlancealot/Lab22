package paket;

import java.util.Random;


public class Gammo {
    private String DATA;
    private int KEY;

    Gammo() {
        this.DATA = "";
        this.KEY = 0;
    }

    Gammo(String D, int K) {
        this.DATA = D;
        this.KEY = K;
    }

    void SHIFR() {
        Random R = new Random(KEY);
        byte[] X = DATA.getBytes(), Y = new byte[DATA.length()];
        byte Gamma;
        for (int i = 0; i < DATA.length(); i++) {
            Gamma = (byte) R.nextInt();
            Y[i] = (byte) (X[i] ^ Gamma);
            X[i] = (byte) (Y[i] & 0x80);
            X[i] = (byte) (X[i] >>>= 7);
            Y[i] = (byte) (Y[i] << 1);
            Y[i] = (byte) (Y[i] | X[i]);
        }
        DATA = new String(Y);
    }

    void DESHIFR() {
        Random R = new Random(KEY);
        byte[] X = DATA.getBytes(), Y = new byte[DATA.length()];
        byte Gamma;
        for (int i = 0; i < DATA.length(); i++) {
            Y[i] = (byte) (X[i] & 0x01);
            Y[i] = (byte) (Y[i] << 7);
            X[i] = (byte) (X[i] >>> 1);
            X[i] = (byte) (X[i] | Y[i]);
            Gamma = (byte) R.nextInt();
            Y[i] = (byte) (X[i] ^ Gamma);
        }
        DATA = new String(Y);
    }

    void Print() {
        System.out.println("Строка: " + DATA);
    }
}
