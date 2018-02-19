package by.tc.epam.task3.view;

import by.tc.epam.task3.entity.node.Node;

public class NodeWriter {

    public static void printInfo(Node node){
        System.out.println("Content -- " + node.getContent());
        System.out.println("Node type -- " + node.getType() + "\n");
    }


}
