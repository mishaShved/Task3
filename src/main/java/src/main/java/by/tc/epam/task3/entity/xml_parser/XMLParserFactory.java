package by.tc.epam.task3.entity.xml_parser;

import by.tc.epam.task3.entity.xml_parser.impl.XMLParserImpl;

import java.io.FileNotFoundException;

public class XMLParserFactory {
    private static final XMLParserFactory ourInstance = new XMLParserFactory();
    private static XMLParser parser = null;

    public static XMLParserFactory getInstance() {
        return ourInstance;
    }

    private XMLParserFactory() {
    }

    public XMLParser getParser(String fileName) throws FileNotFoundException {
        if (parser == null){
            parser = new XMLParserImpl(fileName);
        }
        return parser;
    }
}
