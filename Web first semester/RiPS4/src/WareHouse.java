import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Semaphore;

/**
 * Программа, имитирующая Склад со определённым товаром,
 * используя примитивные языковые конструкции для синхронизации потоков исполнения
 * @version 1.0
 * @author Islam Uamrov
 */
public class WareHouse extends Thread{
    private ArrayList<Product> prod = new ArrayList<>();
    private int i;
    private Semaphore sm;
    /**
     * Конструирует объект Склада
     * @param init Количество товаров
     * @param n Количество окон
     */
    public WareHouse(Semaphore sme,int n, Long init){
        this.sm = sme;
        Product pr = new Product(init);
        for (int i =0; i < n; i++){
            prod.add(i,pr);
        }
    }

    public int getTotalLeft(){
        int i = 0;
        for(Product j : this.prod)
            i +=j.getAmount();
        return i;
    }
    public void run(){
        try {
            sm.acquire();
            prod.get(i).release(1);
            sm.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setI(int i) {
        this.i = i;
    }
}
