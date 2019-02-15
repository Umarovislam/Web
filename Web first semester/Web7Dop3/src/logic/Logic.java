package logic;

import marshaller.JaxbWorker;
import readers.dom.ReaderDOM;
import readers.sax.ReaderSAX;
import readers.stax.ReaderStAX;
import static validation.Validation.checkXMLforXSD;

/**
 * Class Logic
 */
public class Logic {
    String pathXml = "D:\\Java Project\\Web7Dop3\\tariffs.xml";
    String pathXsd = "D:\\Java Project\\Web7Dop3\\schema.xsd";
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
     * The method initialize and start jaxbWorker
     */
    public void startJaxbWorker(){
        JaxbWorker jaxbWorker = new JaxbWorker();
        jaxbWorker.makeMU(pathXml);
    }
    /**
     * The method make validation
     * @return boolean b
     * @throws Exception
     */
    public boolean makeValidation() throws Exception{
        return b = checkXMLforXSD(pathXml, pathXsd);
    }
}
