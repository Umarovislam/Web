package writers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tariff.TariffBonus;
import javax.xml.stream.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Class WriterStAX
 */
public class WriterStAX {

    private static Logger LOGGER = LogManager.getLogger(WriterStAX.class);

    /**
     * The method write data to XML by StAX.
     * @param pathXml - path to XML
     * @param tariffBonuses - list of TariffBonus objects
     */
    public void xmlWriterStAX(String pathXml, List<TariffBonus> tariffBonuses) {
        try{
        XMLOutputFactory output = XMLOutputFactory.newInstance();
        XMLStreamWriter writer = output.createXMLStreamWriter(new FileWriter(pathXml));

        LOGGER.debug("Write data to XML by StAX.");
        writer.writeStartDocument("1.0");
        writer.writeStartElement("tariffs");

            for (TariffBonus tariffBonus : tariffBonuses) {
                writer.writeStartElement("TariffBonus");

                // costTariff
                writer.writeStartElement("costTariff");
                writer.writeCharacters("" + tariffBonus.getCostTariff());
                writer.writeEndElement();

                // costMinuteInNet
                writer.writeStartElement("costMinuteInNet");
                writer.writeCharacters("" + tariffBonus.getCostMinuteInNet());
                writer.writeEndElement();
                // costSms
                writer.writeStartElement("costSms");
                writer.writeCharacters("" + tariffBonus.getCostSms());
                writer.writeEndElement();
                // costMegabyte
                writer.writeStartElement("costMegabyte");
                writer.writeCharacters("" + tariffBonus.getCostMegabyte());
                writer.writeEndElement();
                // species
                writer.writeStartElement("species");
                writer.writeCharacters("" + tariffBonus.getSpecies());
                writer.writeEndElement();
                // packageInternet
                writer.writeStartElement("packageInternet");
                writer.writeCharacters("" + tariffBonus.getPackageInternet());
                writer.writeEndElement();
                // packageMinute
                writer.writeStartElement("packageMinute");
                writer.writeCharacters("" + tariffBonus.getPackageMinute());
                writer.writeEndElement();

                writer.writeEndElement();
            }
        writer.writeEndElement();

        writer.writeEndDocument();
        writer.flush();
        writer.close();
        } catch(XMLStreamException | IOException e){
            e.printStackTrace();
        }
    }
}
