package writers;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import tariff.TariffBonus;

/**
 * Class WriterDOM
 */
public class WriterDOM {

    private static Logger LOGGER = LogManager.getLogger(WriterDOM.class);

    /**
     * The method write data to XML by DOM.
     * @param pathXml - path to XML
     * @param tariffBonuses - list of TariffBonus objects
     */
    public void xmlWriterDOM(String pathXml, List<TariffBonus> tariffBonuses) {
        try {
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

            LOGGER.debug("The method write data to XML by DOM.");

            Element tariffs = document.createElement("tariffs");
            document.appendChild(tariffs);

            for (TariffBonus tariffBonus : tariffBonuses) {
                Element tb = document.createElement("TariffBonus");
                tariffs.appendChild(tb);

                Element costTariff = document.createElement("costTariff");
                costTariff.setTextContent(""+tariffBonus.getCostTariff());
                tb.appendChild(costTariff);

                Element costMinuteInNet = document.createElement("costMinuteInNet");
                costMinuteInNet.setTextContent(""+tariffBonus.getCostMinuteInNet());
                tb.appendChild(costMinuteInNet);

                Element costSms = document.createElement("costSms");
                costSms.setTextContent(""+tariffBonus.getCostSms());
                tb.appendChild(costSms);

                Element costMegabyte = document.createElement("costMegabyte");
                costMegabyte.setTextContent(""+tariffBonus.getCostMegabyte());
                tb.appendChild(costMegabyte);

                Element species = document.createElement("species");
                species.setTextContent(""+tariffBonus.getSpecies());
                tb.appendChild(species);

                Element packageInternet = document.createElement("packageInternet");
                packageInternet.setTextContent(""+tariffBonus.getPackageInternet());
                tb.appendChild(packageInternet);

                Element packageMinute = document.createElement("packageMinute");
                packageMinute.setTextContent(""+tariffBonus.getPackageMinute());
                tb.appendChild(packageMinute);
            }

            Transformer t=TransformerFactory.newInstance().newTransformer();
            t.transform(new DOMSource(document), new StreamResult(new FileOutputStream(pathXml)));

            System.out.println("Write completed.");

        } catch (ParserConfigurationException | TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
