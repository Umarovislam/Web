package Structure;

/**
 *Structure.Rational Fraction is the real and imaginary fields that correspond to the real and imaginary parts
 * @author  Islam Umarov
 * @version 1.0
 * @since  12.09.2018
 */

public class Rational {
    /**
     * @param real real part
     *@param imaginary imaginary part
     * @return int value int
   */
    private int real;

    private int imaginary;

    public Rational(){}

    /**
     *
     * @param a real number
     * @param bi  maginary number
     *
     */
    public Rational(int a, int bi){
        this.real = a;
        this.imaginary = bi;
    }

    public int getReal() {
        return real;
    }

    public void setReal(int real) {
        this.real = real;
    }

    public int getImaginary() {
        return imaginary;
    }

    public void setImaginary(int imaginary) {
        this.imaginary = imaginary;
    }
    public String toString(){
        return "\n real: " + this.getReal() +
                "\n imaginary: " + this.getImaginary();
    }
}