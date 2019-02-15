package logic;

import readers.dom.ReaderDOM;
import readers.sax.ReaderSAX;
import readers.stax.ReaderStAX;
import tariff.Species;
import tariff.TariffBonus;
import writers.WriterDOM;
import writers.WriterStAX;

import java.util.List;

import static validation.Validation.checkXMLforXSD;

/**
 * Class Logic
 */
public class Logic {
    String pathXml = "D:\\Java Project\\Web7Dop_2\\tariffs.xml";
    String pathXsd = "D:\\Java Project\\Web7Dop_2\\schema.xsd";
    boolean b;
    List<TariffBonus> tariffBonuses;

    /**
     * The method initialize and start xmlReaders.
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
     * The method initialize and start xmlReaderDOM.
     */
    public void readXMLWithDOM(){
        ReaderDOM readerDOM = new ReaderDOM();
        readerDOM.xmlReaderDOM(pathXml);
        tariffBonuses = readerDOM.getTbList();
    }

    /**
     * The method initialize and start writeStAX.
     */
    public void writeStAX(){
        WriterStAX writerStAX = new WriterStAX();
        TariffBonus smartPlus = new TariffBonus(150,200,20,20, Species.SMART,512,100);//TariffBonus absoluteMax = new TariffBonus(50,60,252,30,Species.ABSOLUTE,2048,200);

        tariffBonuses.add(smartPlus);

        writerStAX.xmlWriterStAX(pathXml, tariffBonuses);
    }

    /**
     * The method initialize and start writeDOM.
     */
    public void writeDOM(){
        WriterDOM writerDOM = new WriterDOM();
        TariffBonus absoluteLite = new TariffBonus(10,65,6,15, Species.ABSOLUTE,1024,50);

        tariffBonuses.add(absoluteLite);

        writerDOM.xmlWriterDOM(pathXml, tariffBonuses);
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
