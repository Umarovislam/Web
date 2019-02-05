package readers.sax;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import tariff.Species;
import tariff.TariffBonus;

/**
 * Class MyHandler
 */
public class MyHandler extends DefaultHandler {

    private static Logger LOGGER = LogManager.getLogger(MyHandler.class);

    private List<TariffBonus> tbList = null;
    private TariffBonus tb = null;

    /**
     * The method returns list of TariffBonus objects
     * @return List of TariffBonus objects
     */
    public List<TariffBonus> getTbList() {
        return tbList;
    }

    boolean bCostTariff = false;
    boolean bCostMinuteInNet = false;
    boolean bCostSms = false;
    boolean bCostMegabyte = false;
    boolean bSpecies = false;
    boolean bPackageInternet = false;
    boolean bPackageMinute = false;

    /**
     * Overriding the method startElement().
     * We are overriding this method to set boolean variables that will be used to identify the element.
     * @param uri - the namespace URI
     * @param localName - the local name
     * @param qName - the qualified name
     * @param attributes - the attributes attached to the element
     * @throws SAXException
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {

        LOGGER.debug("Take start element.(SAX)");
        if (qName.equalsIgnoreCase("TariffBonus")) {
            tb = new TariffBonus();

            if (tbList == null)
                tbList = new ArrayList<>();
        } else if (qName.equalsIgnoreCase("costTariff")) {
            bCostTariff = true;
        } else if (qName.equalsIgnoreCase("costMinuteInNet")) {
            bCostMinuteInNet = true;
        } else if (qName.equalsIgnoreCase("costSms")) {
            bCostSms = true;
        } else if (qName.equalsIgnoreCase("costMegabyte")) {
            bCostMegabyte = true;
        } else if (qName.equalsIgnoreCase("species")) {
            bSpecies = true;
        } else if (qName.equalsIgnoreCase("packageInternet")) {
            bPackageInternet = true;
        } else if (qName.equalsIgnoreCase("packageMinute")) {
            bPackageMinute = true;
        }
    }

    /**
     * Overriding the method endElement().
     * @param uri - the namespace URI
     * @param localName - the local name
     * @param qName - the qualified name
     * @throws SAXException
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("TariffBonus")) {
            LOGGER.debug("End element is reached, adding TariffBonus object to list.(SAX)");
            tbList.add(tb);
        }
    }

    /**
     * Overriding the method characters().
     * We are using boolean fields to set the value to correct field in TariffBonus object.
     * @param ch - the characters
     * @param start - the start position in the character array
     * @param length -  the number of characters to use from the character array
     * @throws SAXException
     */
    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

        if (bCostTariff) {
            tb.setCostTariff(Integer.parseInt(new String(ch, start, length)));
            bCostTariff = false;
        } else if (bCostMinuteInNet) {
            tb.setCostMinuteInNet(Integer.parseInt(new String(ch, start, length)));
            bCostMinuteInNet = false;
        } else if (bCostSms) {
            tb.setCostSms(Integer.parseInt(new String(ch, start, length)));
            bCostSms = false;
        } else if (bCostMegabyte) {
            tb.setCostMegabyte(Integer.parseInt(new String(ch, start, length)));
            bCostMegabyte = false;
        } else if (bSpecies) {
            String stringSpecies = new String(ch, start, length);
            if(stringSpecies.equals("SMART")){
                tb.setSpecies(Species.SMART);
            }
            else if(stringSpecies.equals("SMARTMINI")){
                tb.setSpecies(Species.SMARTMINI);
            }
            else if(stringSpecies.equals("ABSOLUTE")){
                tb.setSpecies(Species.ABSOLUTE);
            }
            else if(stringSpecies.equals("MEGA")){
                tb.setSpecies(Species.MEGA);
            }
            bSpecies = false;
        } else if (bPackageInternet) {
            tb.setPackageInternet(Integer.parseInt(new String(ch, start, length)));
            bPackageInternet = false;
        } else if (bPackageMinute) {
            tb.setPackageMinute(Integer.parseInt(new String(ch, start, length)));
            bPackageMinute = false;
        }
    }
}