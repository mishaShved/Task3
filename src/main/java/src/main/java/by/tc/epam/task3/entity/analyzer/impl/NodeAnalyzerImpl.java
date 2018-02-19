package by.tc.epam.task3.entity.analyzer.impl;

import by.tc.epam.task3.entity.analyzer.NodeAnalyzer;
import by.tc.epam.task3.entity.node.Node;
import by.tc.epam.task3.entity.node.node_type.NodeType;

import java.util.regex.Pattern;

public class NodeAnalyzerImpl implements NodeAnalyzer {

    private static String closeTagPattern = "</+.+>";
    private static String openTagPattern = "<+.+>";
    private static String contentTagPattern = "[^<>]+";
    private static String tagWithoutBodyPattern = "<+.+/>";
    private static String contentFindPattern = "[<>/]";


    public Node analyze(String nodeInTextFormat) {

        if(nodeInTextFormat.isEmpty()){
            return null;
        }

        Node node = new Node();

        Pattern p = Pattern.compile(contentFindPattern);
        node.setContent(p.matcher(nodeInTextFormat).replaceAll(""));

        if(isTagWithoutBody(nodeInTextFormat)){
            node.setType(NodeType.TAG_WITHOUT_BODY);
        }else if(isCloseTag(nodeInTextFormat)){
            node.setType(NodeType.CLOSE_TAG);
        }else if(isOpenTag(nodeInTextFormat)){
            node.setType(NodeType.OPEN_TAG);
        }else if(isContent(nodeInTextFormat)){
            node.setType(NodeType.TAG_CONTENT);
        }

        return node;

    }


    private boolean isCloseTag(String nodeInTextFormat){
        Pattern p = Pattern.compile(closeTagPattern);
        return p.matcher(nodeInTextFormat).matches();
    }

    private boolean isOpenTag(String nodeInTextFormat){
        Pattern p = Pattern.compile(openTagPattern);
        return p.matcher(nodeInTextFormat).matches();
    }

    private boolean isContent(String nodeInTextFormat){
        Pattern p = Pattern.compile(contentTagPattern);
        return p.matcher(nodeInTextFormat).matches();
    }

    private boolean isTagWithoutBody(String nodeInTextFormat){
        Pattern p = Pattern.compile(tagWithoutBodyPattern);
        return p.matcher(nodeInTextFormat).matches();
    }

}
