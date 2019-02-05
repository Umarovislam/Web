package Constuctor;
import Structure.Rational;

/**
 *class The complex number of the real and imaginary parts of which,
 *are presented in the form of Structure.Rational Fractions
 * @author  Islam Umarov
 * @version 1.0
 * @since  12.09.2018
 */

public class ComplexNumber {
    private Rational real;
    private Rational imaginary;

    public ComplexNumber(){}
    public ComplexNumber(Rational real, Rational imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }

    public Rational Sum(){
        Rational C = new Rational(this.real.getReal() + this.imaginary.getReal(),this.imaginary.getImaginary() + this.real.getImaginary());
        return C;
    }
    public Rational Substract(){
        Rational C = new Rational(this.real.getReal() - this.imaginary.getReal(),this.imaginary.getImaginary() - this.real.getImaginary());
        return C;
    }
    public Rational Multiply (){
        Rational C = new Rational((this.real.getReal() * this.imaginary.getReal() + this.real.getImaginary()*this.imaginary.getImaginary()) , (this.real.getReal() * this.imaginary.getImaginary() + this.real.getImaginary()*this.imaginary.getReal()));
        return C;
    }
    public Rational Devide(){
        int dev = (int) (Math.pow(this.imaginary.getReal(),2) + Math.pow(this.imaginary.getImaginary(),2));
        Rational C = new Rational(((this.real.getReal() * this.imaginary.getReal() + this.real.getImaginary() * this.imaginary.getImaginary())/dev),(this.real.getImaginary()*this.imaginary.getReal() - this.real.getReal() * this.imaginary.getImaginary())/dev);
        return C;
    }
    public Rational getReal() {
        return real;
    }
    public void setReal(Rational real) {
        this.real = real;
    }

    public Rational getImaginary() {
        return imaginary;
    }

    public void setImaginary(Rational imaginary) {
        this.imaginary = imaginary;
    }
}
