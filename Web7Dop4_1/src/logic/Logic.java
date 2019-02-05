package logic;

import converter.ConverterXML;
import readers.dom.ReaderDOM;
import readers.sax.ReaderSAX;
import readers.stax.ReaderStAX;
import static validation.Validation.checkXMLforXSD;

/**
 * Class Logic
 */
public class Logic {
    String pathXml = "D:\\Java Project\\Web7Dop4_1\\tariffs.xml";
    String pathXsd = "D:\\Java Project\\Web7Dop4_1\\schema.xsd";
    String pathXsl = "D:\\Java Project\\Web7Dop4_1\\stylesheet.xsl";
    boolean b;

    /**
     * The method initialize and start xmlReaders
     */
    public void startReaders(){
        ReaderDOM readerDOM = new ReaderDOM();
        readerDOM.xmlReaderDOM(pathXml);

        ReaderSAX readerSAX = new ReaderSAX();
        readerSAX.xmlReaderSAX(pathXml);

        ReaderStAX readerStAX = new ReaderStAX();
        readerStAX.xmlReaderStAX(pathXml);
    }

    /**
     * The method initialize and start converterXML
     */
    public void makeConvertation(){
        ConverterXML converterXML = new ConverterXML();
        converterXML.convertXMLtoHTML(pathXml, pathXsl);
    }

    /**
     * The method make validation
     * @return boolean bмп9
     * @throws Exception
     */
    public boolean makeValidation() throws Exception{
        return b = checkXMLforXSD(pathXml, pathXsd);
    }
}
