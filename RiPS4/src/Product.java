import java.util.Arrays;
import java.util.concurrent.Semaphore;

public class Product {
    private Long product;
    //private int n;
    public Product(Long init) {
        this.product = init;
       // Arrays.fill(product,init);
    }
    public Long getAmount(){
        return this.product;
    }

    /**
     * Отпускает товар с окон пока товаров не останется
     * @param amonut Количество отпускаемого товара
     *
     * */
    public void release(int amonut) throws InterruptedException{
        this.product -= amonut;
        System.out.println(Thread.currentThread() + " Window left " + product);
        // notify();
    }
}
