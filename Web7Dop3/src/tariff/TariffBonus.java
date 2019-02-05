package tariff;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "TariffBonus")
// opredelyayem posledovatelnost tegov v XML
@XmlType(propOrder = {"costTariff", "costMinuteInNet", "costSms", "costMegabyte", "species",
        "packageInternet", "packageMinute"})
/**
 * Class TariffBonus
 */
public class TariffBonus{
    private int costTariff;
    private int costMinuteInNet;
    private int costSms;
    private int costMegabyte;
    private Species species;
    private int packageMinute;
    private int packageInternet;


    /**
     * Constructor of class TariffBonus
     * @param costTariff - cost of the tariff
     * @param costMinuteInNet - cost of minutes in the Ethernet
     * @param costSms - cost of the sms
     * @param costMegabyte - cost of megabyte
     * @param species - species
     * @param packageInternet - megabytes in package Internet
     * @param packageMinute - minutes in package Minute
     */
    public TariffBonus(int costTariff, int costMinuteInNet, int costSms, int costMegabyte, Species species,
                       int packageInternet, int packageMinute) {
        this.costTariff = costTariff;
        this.costMinuteInNet=costMinuteInNet;
        this.costSms=costSms;
        this.costMegabyte=costMegabyte;
        this.species = species;
        this.packageInternet = packageInternet;
        this.packageMinute = packageMinute;
    }

    public TariffBonus(){}

    /**
     * The method returns the value of the field packageMinute
     * @return the value of the field packageMinute
     */
    public int getPackageMinute() {
        return packageMinute;
    }

    /**
     * The method returns the value of the field packageInternet
     * @return the value of the field packageInternet
     */
    public int getPackageInternet() {
        return packageInternet;
    }

    /**
     * The method changes the value of the field packageInternet
     * @param packageInternet - megabytes in package Internet
     */
    public void setPackageInternet(int packageInternet) {
        this.packageInternet = packageInternet;
    }

    /**
     * The method changes the value of the field packageMinute
     * @param packageMinute - minutes in package Minute
     */
    public void setPackageMinute(int packageMinute) {
        this.packageMinute = packageMinute;
    }

    /**
     * The method returns the value of the field species
     * @return the value of the field species
     */
    public Species getSpecies() {
        return species;
    }

    /**
     * The method changes the value of the field species
     * @param species - species
     */
    public void setSpecies(Species species) {
        this.species = species;
    }

    /**
     * The method returns the value of the field costTariff
     * @return the value of the field costTariff
     */
    public int getCostTariff() {
        return costTariff;
    }

    /**
     * The method changes the value of the field costTariff
     * @param costTariff - cost of the tariff
     */
    public void setCostTariff(int costTariff) {
        this.costTariff = costTariff;
    }

    /**
     * The method returns the value of the field costMinuteInNet
     * @return the value of the field costMinuteInNet
     */
    public int getCostMinuteInNet(){
        return costMinuteInNet;
    }

    /**
     * The method changes the value of the field costMinuteInNet
     * @param costMinuteInNet - cost of minutes in the Ethernet
     */
    public void setCostMinuteInNet(int costMinuteInNet) {
        this.costMinuteInNet=costMinuteInNet;
    }

    /**
     * The method returns the value of the field costSms
     * @return the value of the field costSms
     */
    public int getCostSms(){
        return costSms;
    }

    /**
     * The method changes the value of the field costSms
     * @param costSms - cost of the sms
     */
    public void setCostSms(int costSms) {
        this.costSms=costSms;
    }

    /**
     * The method returns the value of the field costMegabyte
     * @return the value of the field costMegabyte
     */
    public int getCostMegabyte(){
        return costMegabyte;
    }

    /**
     * The method changes the value of the field costMegabyte
     * @param costMegabyte - cost of megabyte
     */
    public void setCostMegabyte(int costMegabyte) {
        this.costMegabyte=costMegabyte;
    }

    /**
     * Overriding the method toString()
     * @return string
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" Tariff:[Bonus(Package minute = " + packageMinute + ", PackageInternet = " + packageInternet
                + ") " + "Cost of the tariff = "+ costTariff +", Cost minute in net = " + costMinuteInNet +
                ", Cost megabyte = " + costMegabyte+ ", Cost sms = " + costSms + ", tariff species - " + species + "]");
        return stringBuilder.toString();
    }
}