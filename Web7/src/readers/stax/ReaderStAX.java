package readers.stax;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tariff.Species;
import tariff.TariffBonus;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/**
 * Class ReaderStAX
 */
public class ReaderStAX {

    private static Logger LOGGER = LogManager.getLogger(ReaderStAX.class);

    /**
     * The method show work of StAX parser
     * @param pathXml- path to XML
     */
    public static void xmlReaderStAX(String pathXml) {

        List<TariffBonus> tbList = parseXML(pathXml);

        System.out.println("\nTariffBonuses in the XML file by StAX:");

        for(TariffBonus tb : tbList){
            System.out.println(tb.toString());
        }
    }

    /**
     *  The method parses XML file
     * @param pathXml - path to XML
     * @return List of TariffBonus objects
     */
    private static List<TariffBonus> parseXML(String pathXml) {

        List<TariffBonus> tbList = new ArrayList<>();
        TariffBonus tb = null;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();

        try {
            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(pathXml));

            while(xmlEventReader.hasNext()){

                XMLEvent xmlEvent = xmlEventReader.nextEvent();

                if (xmlEvent.isStartElement()){
                    LOGGER.debug("Take start element.");

                    StartElement startElement = xmlEvent.asStartElement();

                    if(startElement.getName().getLocalPart().equals("TariffBonus")){
                        tb = new TariffBonus();
                    }
                    else if(startElement.getName().getLocalPart().equals("costTariff")){
                        xmlEvent = xmlEventReader.nextEvent();
                        tb.setCostTariff(Integer.parseInt(xmlEvent.asCharacters().getData()));
                    }else if(startElement.getName().getLocalPart().equals("costMinuteInNet")){
                        xmlEvent = xmlEventReader.nextEvent();
                        tb.setCostMinuteInNet(Integer.parseInt(xmlEvent.asCharacters().getData()));
                    }else if(startElement.getName().getLocalPart().equals("costSms")){
                        xmlEvent = xmlEventReader.nextEvent();
                        tb.setCostSms(Integer.parseInt(xmlEvent.asCharacters().getData()));
                    }else if(startElement.getName().getLocalPart().equals("costMegabyte")){
                        xmlEvent = xmlEventReader.nextEvent();
                        tb.setCostMegabyte(Integer.parseInt(xmlEvent.asCharacters().getData()));
                    }else if(startElement.getName().getLocalPart().equals("species")){
                        xmlEvent = xmlEventReader.nextEvent();

                        String stringSpecies = xmlEvent.asCharacters().getData();

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
                    }else if(startElement.getName().getLocalPart().equals("packageInternet")){
                        xmlEvent = xmlEventReader.nextEvent();
                        tb.setPackageInternet(Integer.parseInt(xmlEvent.asCharacters().getData()));
                    }else if(startElement.getName().getLocalPart().equals("packageMinute")){
                        xmlEvent = xmlEventReader.nextEvent();
                        tb.setPackageMinute(Integer.parseInt(xmlEvent.asCharacters().getData()));
                    }
                }
                if(xmlEvent.isEndElement()){

                    EndElement endElement = xmlEvent.asEndElement();

                    if(endElement.getName().getLocalPart().equals("TariffBonus")){
                        LOGGER.debug("End element is reached, adding TariffBonus object to list.");
                        tbList.add(tb);
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
        return tbList;
    }
}