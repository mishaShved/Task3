package by.tc.epam.task3_1.main;

import by.tc.epam.task3.entity.analyzer.AnalyzerFactory;
import by.tc.epam.task3.entity.analyzer.NodeAnalyzer;
import by.tc.epam.task3.entity.node.Node;
import by.tc.epam.task3.entity.xml_parser.XMLParser;
import by.tc.epam.task3.entity.xml_parser.XMLParserFactory;
import by.tc.epam.task3.view.NodeWriter;

import java.io.FileNotFoundException;
public class Main {

    public static void main(String[] args) {

        XMLParserFactory parserFactory = XMLParserFactory.getInstance();

        AnalyzerFactory analyzerFactory = AnalyzerFactory.getInstance();
        NodeAnalyzer nodeAnalyzer = analyzerFactory.getNodeAnalyzer();

        Node node = null;

        try (XMLParser parser = parserFactory.getParser("xml_file.xml")) {
            while ((node = nodeAnalyzer.analyze(parser.next())) != null) {
                NodeWriter.printInfo(node);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
