package server;

import model.builder.ManagerBuilder;
import model.tariff.Species;
import model.tariff.TariffBonus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import rmi_interface.RMITariffManager;
import server.sort.SortByCostTariff;
import server.sort.SortBySpecies;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Class TariffManager
 */
public class TariffManager extends UnicastRemoteObject implements RMITariffManager {

    private static Logger LOGGER = LogManager.getLogger(TariffManager.class);

    /**
     * Constructor for TariffManager class
     * @throws RemoteException
     */
    public TariffManager() throws RemoteException {
        super();
    }

    /**
     * Overriding method SearchTariffForCostSms
     * @param tariffBonuses - list of TariffBonus objects
     * @param costSms - cost of sms
     * @return
     * @throws RemoteException
     */
    @Override
    public List<TariffBonus> SearchTariffForCostSms(List<TariffBonus> tariffBonuses, int costSms) throws RemoteException {

        TariffBonus tariffBonus;
        List<TariffBonus> result = new LinkedList<>();

        for (int i = 0; i < tariffBonuses.size(); i++) {
            if (tariffBonuses.get(i) instanceof TariffBonus) {
                tariffBonus = tariffBonuses.get(i);
                if (tariffBonus.getCostSms() == costSms) {
                    result.add(tariffBonus);
                }
            }
        }
        return result;
    }

    /**
     * Overriding method SearchTariffForPackageMinute
     * @param tariffBonuses - list of TariffBonus objects
     * @param packageMinute - package of minutes
     * @return
     * @throws RemoteException
     */
    @Override
    public List<TariffBonus> SearchTariffForPackageMinute(List<TariffBonus> tariffBonuses, int packageMinute) throws RemoteException {

        TariffBonus tariffBonus;
        List<TariffBonus> result = new LinkedList<>();

        for (int i = 0; i < tariffBonuses.size(); i++) {
            if (tariffBonuses.get(i) instanceof TariffBonus) {
                tariffBonus = tariffBonuses.get(i);
                if (tariffBonus.getPackageMinute() == packageMinute) {
                    result.add(tariffBonus);
                }
            }
        }
        return result;
    }

    /**
     * Overriding method SortByCostTariff
     * @param tariffBonuses - list of TariffBonus objects
     * @return
     * @throws RemoteException
     */
    @Override
    public List<TariffBonus> SortByCostTariff(List<TariffBonus> tariffBonuses) throws RemoteException {
        Collections.sort(tariffBonuses, new SortByCostTariff());
        return tariffBonuses;
    }

    /**
     * Overriding method SortBySpecies
     * @param tariffBonuses - list of TariffBonus objects
     * @return
     * @throws RemoteException
     */
    @Override
    public List<TariffBonus> SortBySpecies(List<TariffBonus> tariffBonuses) throws RemoteException {
        Collections.sort(tariffBonuses, new SortBySpecies());
        return tariffBonuses;
    }


    public LinkedList Init(){
        TariffBonus smart = ManagerBuilder.getTariffBonus(100,100,10,10, Species.SMART,1024,30);
        TariffBonus mega = ManagerBuilder.getTariffBonus(24,23,14,10, Species.MEGA,2048,360);
        TariffBonus smartMini = ManagerBuilder.getTariffBonus(30,23,16,15,Species.SMARTMINI,1024,100);
        TariffBonus absolute = ManagerBuilder.getTariffBonus(20,45,20,15,Species.ABSOLUTE,1024,100);
        TariffBonus absoluteLite = ManagerBuilder.getTariffBonus(10,65,6,15,Species.ABSOLUTE,1024,50);
        TariffBonus absoluteMax = ManagerBuilder.getTariffBonus(50,60,252,30,Species.ABSOLUTE,2048,200);
        TariffBonus smartPlus = ManagerBuilder.getTariffBonus(150,200,20,20, Species.SMART,512,100);

        List<TariffBonus> tariffBonuses = new LinkedList<>();
        tariffBonuses.add(smart);
        tariffBonuses.add(mega);
        tariffBonuses.add(smartMini);
        tariffBonuses.add(absolute);
        tariffBonuses.add(absoluteLite);
        tariffBonuses.add(absoluteMax);
        tariffBonuses.add(smartPlus);
        return (LinkedList) tariffBonuses;
    }
    /**
     * The method start server
     * @param args
     */
    public static void main(String[] args){
        try {
            LOGGER.debug("Initialize TariffManager.");
            TariffManager tariffManager = new TariffManager();

            LOGGER.debug("Create and export registry on the local host that accepts requests on the port 5000.");

            LocateRegistry.createRegistry(5000);

            LOGGER.debug("Rebind the specified name to a new remote object tariffManager.");

            Naming.rebind("//localhost:5000/TariffManager", tariffManager);
            System.err.println("Server ready");

        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
