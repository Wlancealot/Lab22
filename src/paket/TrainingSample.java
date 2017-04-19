package paket;

/**
 * Created by korobovka on 23.03.2017.
 */
public class TrainingSample {
    public static void main(String[] args) {
        class Tst4Methods {
            final int cpBits = 21; // codepoint bits quantity
            // System.out.println(String.format("%04d", Integ  er.parseInt(Integer.toBinaryString(i))));
            // You'd better change hard-coded "%04d" to "%0" + n + "d"
            //  StringBuilder sb = new StringBuilder();
            // http://stackoverflow.com/questions/31365984/java-integer-parseint-for-32-bit-signed-binary-string-throws-numberformatexcep
            // http://stackoverflow.com/questions/4421400/how-to-get-0-padded-binary-representation-of-an-integer-in-java
            // String.format("%16s", Integer.toBinaryString(1)).replace(" ", "0")
            /**
             *  cycle shift left only 21 letter bits
             * @param arg2shift
             * @param shiftCnt
             * @return arg2shift with 21 letter bits rotated left on shiftCnt
             */
            int ROLCodePoint(int arg2shift, int shiftCnt) {
                int lowPart, highPart;
                lowPart = (arg2shift >> (cpBits - shiftCnt % cpBits)) & 0x1F_FF_FF; // form lower part of result
                highPart = (arg2shift << (shiftCnt % cpBits)) & 0x1F_FF_FF;
                return (lowPart | highPart)&0x1F_FF_FF;
            }
            /**
             *  cycle shift rightonly 21 letter bits
             * @param arg2shift
             * @param shiftCnt
             * @return arg2shift with 21 letter bits rotated right on shiftCnt
             */
            int RORCodePoint(int arg2shift, int shiftCnt) {
                return ROLCodePoint(arg2shift, (cpBits - shiftCnt % cpBits ));
            }
            //int[] codePoints = str.codePoints().toArray();
            /**
             *
             * @param str - string to encrypt
             * @return encrypted string
             */
            String Encrypt(String str) {
                return "";
            }
        }

        Tst4Methods tstEx = new Tst4Methods();
        int i = 512;
        //int i = 0x1E_EE_EE;
        int shiftN = 8;
        //System.out.println(String.format("%032d", Integer.parseInt(Integer.toBinaryString(i))));
        System.out.println("Original i = " + i);
        System.out.println(String.format("%1$32s", Integer.toBinaryString(i)).replace(" ", "0"));
        i = tstEx.ROLCodePoint(i,shiftN);
        System.out.println(String.format("%1$32s", Integer.toBinaryString(i)).replace(" ", "0"));
        System.out.println("Left Shifted \"i\" = " + i);
        //System.out.println(Math.pow(2,17));
        i = tstEx.RORCodePoint(i,shiftN);
        System.out.println("Right Shifted(original) \"i\" = "  + i);
    }
}
