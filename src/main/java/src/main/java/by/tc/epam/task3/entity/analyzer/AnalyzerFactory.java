package by.tc.epam.task3.entity.analyzer;

import by.tc.epam.task3.entity.analyzer.impl.NodeAnalyzerImpl;

public class AnalyzerFactory {
    private static final AnalyzerFactory ourInstance = new AnalyzerFactory();
    private final NodeAnalyzer nodeAnalyzer = new NodeAnalyzerImpl();

    public static AnalyzerFactory getInstance() {
        return ourInstance;
    }

    private AnalyzerFactory() {
    }

    public NodeAnalyzer getNodeAnalyzer() {
        return nodeAnalyzer;
    }
}
