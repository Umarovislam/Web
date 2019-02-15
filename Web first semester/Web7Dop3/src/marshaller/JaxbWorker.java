package marshaller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tariff.TariffBonus;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class JaxbWorker
 */
public class JaxbWorker {
    JAXBContext context;

    private static Logger LOGGER = LogManager.getLogger(JaxbWorker.class);

    /**
     * The method demonstrate working of JAXB.
     * @param pathXml - path to XML file
     */
    public void makeMU(String pathXml){
        try {
            List<TariffBonus> tariffBonuses = new ArrayList<>();

            context = JAXBContext.newInstance(TariffBonusList.class);

            unmarshaller(tariffBonuses, pathXml);
            marshaller(tariffBonuses, pathXml);

            LOGGER.debug("All done.");
        }catch (JAXBException e){
            e.printStackTrace();
        }
    }

    /**
     * The method makes marshalling.
     * @param tariffBonuses - list of TariffBonuses objects
     * @param pathXml - path to XML file
     * @throws JAXBException
     */
    public void marshaller(List<TariffBonus> tariffBonuses, String pathXml) throws JAXBException{
        TariffBonusList tariffBonusesList = new TariffBonusList(tariffBonuses);

        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        LOGGER.debug("Marshaling object in XML file.");
        System.out.println("\nMarshaling object in XML file.");

        m.marshal(tariffBonusesList, new File(pathXml));
    }

    /**
     * The method makes unmarshalling.
     * @param tariffBonuses - list of TariffBonuses objects
     * @param pathXml - path to XML file
     * @throws JAXBException
     */
    public void unmarshaller(List<TariffBonus> tariffBonuses, String pathXml)throws JAXBException{
        Unmarshaller um = context.createUnmarshaller();

        TariffBonusList tariffBonusesList = (TariffBonusList) um.unmarshal(new File(pathXml));

        LOGGER.debug("Restore objects from XML file.");
        System.out.println("\nRestored objects from XML file:");

        for (TariffBonus tb: tariffBonusesList.getTariffBonuses()){
            tariffBonuses.add(tb);
            System.out.println(tb);
        }
    }

    /**
     * Class TariffBonusList
     */
    @XmlRootElement(name="tariffs")
    static class TariffBonusList {
        private List<TariffBonus> tariffBonuses;

        public TariffBonusList(){}

        /**
         * Constructor of TariffBonusList class
         * @param tariffBonuses - list of TariffBonuses objects
         */
        public TariffBonusList(List<TariffBonus> tariffBonuses) {
            this.tariffBonuses = tariffBonuses;
        }

        /**
         * The method returns list of TariffBonuses objects
         * @return List of TariffBonuses objects
         */
        public List<TariffBonus> getTariffBonuses() {
            return tariffBonuses;
        }

        /**
         * The method set List of TariffBonuses objects
         * @param tariffBonuses - list of TariffBonuses objects
         */
        @XmlElement(name="TariffBonus")
        public void setTariffBonuses(List<TariffBonus> tariffBonuses) {
            this.tariffBonuses = tariffBonuses;
        }
    }
}
