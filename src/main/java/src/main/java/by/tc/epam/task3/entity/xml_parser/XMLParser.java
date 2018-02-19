package by.tc.epam.task3.entity.xml_parser;


import java.io.IOException;

public interface XMLParser extends AutoCloseable{

    String next() throws IOException;

}
