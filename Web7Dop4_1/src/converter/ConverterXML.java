package converter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * Class ConverterXML
 */
public class ConverterXML {

    private static Logger LOGGER = LogManager.getLogger(ConverterXML.class);

    /**
     * The method demonstrate work of convertion xml to html
     * @param pathXml - path to XML file
     * @param pathXsl - path to XSL file
     */
    public static void convertXMLtoHTML(String pathXml, String pathXsl) {
        Source xml = new StreamSource(pathXml);
        Source xsl = new StreamSource(pathXsl);

        convertXMLToHTML(xml, xsl);
    }

    /**
     * The method converts xml to html
     * @param pathXml - path to XML file
     * @param pathXsl - path to XSL file
     */
    public static void convertXMLToHTML(Source pathXml, Source pathXsl) {
        StringWriter sw = new StringWriter();

        try {
            LOGGER.debug("Make transformation.");

            FileWriter fw = new FileWriter("tariffTable.html");
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transform = tFactory.newTransformer(pathXsl);
            transform.transform(pathXml, new StreamResult(sw));
            fw.write(sw.toString());
            fw.close();

            System.out.println("tariffTable.html generated successfully.");

        } catch (IOException | TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerFactoryConfigurationError e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}