import Constuctor.ComplexNumber;
import Structure.Rational;
/**
 * Examples in the class Main
 * @author  Islam Umarov
 * @version 1.0
 * @since  12.09.2018
 * @param a first
 * @param b Second
 *
 */

public class Main {
    public static void main(String []args){
        Rational a = new Rational(12,23);
        Rational b = new Rational(23,22);
        ComplexNumber com = new ComplexNumber(a,b);
        System.out.printf(a.toString() + " + " + b.toString() + " = " + com.Sum().toString());
        System.out.printf(a.toString() + " - " + b.toString() + " = " + com.Substract().toString());
        System.out.printf(a.toString() + " * " + b.toString() + " = " + com.Multiply().toString());
        System.out.printf(a.toString() + " : " + b.toString() + " = " + com.Devide().toString());
    }
}
