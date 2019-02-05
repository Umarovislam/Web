package readers.sax;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import tariff.TariffBonus;

/**
 * Class ReaderSAX
 */
public class ReaderSAX {

    /**
     * The method show work of SAX parser with our handler
     * @param pathXml - path to XML
     */
    public static void xmlReaderSAX(String pathXml) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            MyHandler handler = new MyHandler();

            saxParser.parse(new File(pathXml), handler);

            List<TariffBonus> tbList = handler.getTbList();

            System.out.println("\nTariffBonuses in the XML file by SAX:");

            for(TariffBonus tb : tbList)
                System.out.println(tb);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}