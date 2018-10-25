package Parsers;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public interface MySAXParser {
    public void parse() throws ParserConfigurationException, SAXException, IOException;
}
