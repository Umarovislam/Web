package readers.dom;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import tariff.Species;
import tariff.TariffBonus;

/**
 * Class ReaderDOM
 */
public class ReaderDOM {

    private static Logger LOGGER = LogManager.getLogger(ReaderDOM.class);

    public List<TariffBonus> tbList;

    /**
     * The method show work of DOM parser
     * @param pathXml - path to XML
     */
    public void xmlReaderDOM(String pathXml) {

        File xmlFile = new File(pathXml);
        // creating DOM parser
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        tbList = new ArrayList<>();

        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            LOGGER.debug("Root element in XML file:" + doc.getDocumentElement().getNodeName());
            System.out.println("\nRoot element :" + doc.getDocumentElement().getNodeName());

            NodeList nodeList = doc.getElementsByTagName("TariffBonus");
            //now XML is loaded as Document in memory, lets convert it to Object List


            LOGGER.debug("Now XML is loaded as Document in memory, convert it to TariffBonus object List.");

            for (int i = 0; i < nodeList.getLength(); i++) {
                tbList.add(getTariffBonus(nodeList.item(i)));
            }

            System.out.println("TariffBonuses in the XML file by DOM: ");

            for (TariffBonus tb : tbList) {
                System.out.println(tb.toString());
            }

        } catch (SAXException | ParserConfigurationException | IOException e1) {
            e1.printStackTrace();
        }
    }

    /**
     * The method parse elements from XML to TariffBonus
     * @param node - node
     * @return TariffBonus object
     */
    private static TariffBonus getTariffBonus(Node node) {

        TariffBonus tariffBonus = new TariffBonus();

        if (node.getNodeType() == Node.ELEMENT_NODE) {

            Element element = (Element) node;

            tariffBonus.setCostTariff(Integer.parseInt(getTagValue("costTariff", element)));
            tariffBonus.setCostMinuteInNet(Integer.parseInt(getTagValue("costMinuteInNet", element)));
            tariffBonus.setCostSms(Integer.parseInt(getTagValue("costSms", element)));
            tariffBonus.setCostMegabyte(Integer.parseInt(getTagValue("costMegabyte", element)));

            String stringSpecies = getTagValue("species", element);

            if(stringSpecies.equals("SMART")){
                tariffBonus.setSpecies(Species.SMART);
            }
            else if(stringSpecies.equals("SMARTMINI")){
                tariffBonus.setSpecies(Species.SMARTMINI);
            }
            else if(stringSpecies.equals("ABSOLUTE")){
                tariffBonus.setSpecies(Species.ABSOLUTE);
            }
            else if(stringSpecies.equals("MEGA")){
                tariffBonus.setSpecies(Species.MEGA);
            }

            tariffBonus.setPackageInternet(Integer.parseInt(getTagValue("packageInternet", element)));
            tariffBonus.setPackageMinute(Integer.parseInt(getTagValue("packageMinute", element)));
        }

        return tariffBonus;
    }

    /**
     *
     * @param tag - tag
     * @param element - element
     * @return node value
     */
    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }

    public List<TariffBonus> getTbList() {
        return tbList;
    }
}