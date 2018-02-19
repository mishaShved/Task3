package by.tc.epam.task3.entity.xml_parser.impl;

import by.tc.epam.task3.entity.xml_parser.XMLParser;

import java.io.*;

public class XMLParserImpl implements XMLParser, AutoCloseable{

    private static final int NODE_START = 0;
    private static final String DELETED_SYMBOL = "  ";
    private static final String OPEN_TAG_SYMBOL = "<";
    private static final String CLOSE_TAG_SYMBOL = ">";
    private static final int STARTING_FIND_POINT = 1;

    private StringBuilder currentData = new StringBuilder();
    private BufferedReader reader;

    public XMLParserImpl() {
    }

    public XMLParserImpl(String fileName) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(new File(fileName)));
    }

    public String next() throws IOException {

        String node = null;
        readNewData(currentData);
        trim(currentData);
        node = getNextNode(currentData);
        updateReadedData(currentData);

        return node;
    }

    @Override
    public void close() throws IOException {
        reader.close();
    }


    private void trim(StringBuilder data){

        while(data.indexOf(DELETED_SYMBOL) != -1){
            data.delete(data.indexOf(DELETED_SYMBOL), data.indexOf(DELETED_SYMBOL) + DELETED_SYMBOL.length());
        }
    }

    private void readNewData(StringBuilder data) throws IOException {

        while ((currentData.indexOf(OPEN_TAG_SYMBOL) == -1 || currentData.indexOf(CLOSE_TAG_SYMBOL) == -1)
                && reader.ready()) {
            currentData.append(reader.readLine());
        }

    }

    private int findNodeEnd(StringBuilder data){

        int nodeEnd;

        if(currentData.indexOf(OPEN_TAG_SYMBOL, STARTING_FIND_POINT) != -1 &&
                currentData.indexOf(OPEN_TAG_SYMBOL, STARTING_FIND_POINT) <
                        currentData.indexOf(CLOSE_TAG_SYMBOL, STARTING_FIND_POINT)
                ){
            nodeEnd = currentData.indexOf(OPEN_TAG_SYMBOL, STARTING_FIND_POINT);
        }else{
            nodeEnd = currentData.indexOf(CLOSE_TAG_SYMBOL, STARTING_FIND_POINT) + CLOSE_TAG_SYMBOL.length();
        }

        return nodeEnd;
    }

    private String getNextNode(StringBuilder data){
        int nodeEnd = findNodeEnd(data);
        return currentData.substring(NODE_START,nodeEnd);
    }

    private void updateReadedData(StringBuilder data){
        int nodeEnd = findNodeEnd(data);
        currentData.delete(NODE_START, nodeEnd);
    }


}
