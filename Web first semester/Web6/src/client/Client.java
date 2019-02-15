package client;

import model.tariff.TariffBonus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import rmi_interface.RMITariffManager;
import server.TariffManager;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;

/**
 * Class Client
 */
public class Client {
    private static RMITariffManager tariffManager;
    private static Logger LOGGER = LogManager.getLogger(Client.class);
    private static TariffManager tr;

    static {
        try {
            tr = new TariffManager();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * The method start client
     * @param args
     * @throws MalformedURLException
     * @throws RemoteException
     * @throws NotBoundException
     */
    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {

        tariffManager = (RMITariffManager) Naming.lookup("//localhost:5000/TariffManager");

        LOGGER.debug("Initialize tariff bonuses and add them to list.");

        List<TariffBonus> tariffBonuses = new LinkedList<TariffBonus>( tr.Init());
        System.out.println("Tariffs: ");
        for(TariffBonus tariffBonus: tariffBonuses){
            System.out.println(tariffBonus);
        }

        LOGGER.debug("Searching result by cost sms.");
        System.out.println("\nSearch result by cost sms: ");
        printResult(tariffManager.SearchTariffForCostSms(tariffBonuses, 20));

        LOGGER.debug("Searching result by package minutes.");
        System.out.println("\nSearch result by package minutes: ");
        printResult(tariffManager.SearchTariffForPackageMinute(tariffBonuses, 100));

        LOGGER.debug("Sorting by cost of tariff.");
        System.out.println("\nResult of sorting by cost of tariff: ");
        printResult(tariffManager.SortByCostTariff(tariffBonuses));
    }

    public static void printResult(List<TariffBonus> result){
        for(TariffBonus tariffBonus:result){
            System.out.println(tariffBonus);
        }
    }
}
