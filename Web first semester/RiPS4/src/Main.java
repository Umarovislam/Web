import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Main {
    static WareHouse wareHouse;
    public static void main(String[] ars) throws InterruptedException {
        System.out.printf("input count of Window \n");
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Semaphore sm = new Semaphore(n);
        System.out.println("Input start value");
        Long init = sc.nextLong();
        wareHouse = new WareHouse(sm,n,init);

        Thread [] th = new Thread[n];

        for (int i = 0; i < n; i++){
            wareHouse.setI(1);
            th[i] = new Thread(wareHouse);
            th[i].start();
        }
        for (int i = 0; i < 4; i++){
            th[i].join();
        }
        System.out.print(wareHouse.getTotalLeft());
    }
}