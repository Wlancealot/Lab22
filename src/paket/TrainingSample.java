package paket;

/**
 * Created by korobovka on 23.03.2017.
 */
public class TrainingSample {
    public static void main(String[] args) {
        class Tst4Methods {
            final int cpBits = 21;
            // System.out.println(String.format("%04d", Integer.parseInt(Integer.toBinaryString(i))));
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
        }
        Tst4Methods tstEx = new Tst4Methods();
        int i = 5;
        i = 0x1E_EE_EE;
        //System.out.println(String.format("%032d", Integer.parseInt(Integer.toBinaryString(i))));
        System.out.println(String.format("%032d", Integer.toBinaryString(i)));
        i = tstEx.ROLCodePoint(i,2);
        System.out.println(String.format("%032d", Integer.parseInt(Integer.toBinaryString(i))));
    }
}