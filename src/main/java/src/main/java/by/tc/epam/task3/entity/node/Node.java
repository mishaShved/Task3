package by.tc.epam.task3.entity.node;

import by.tc.epam.task3.entity.node.node_type.NodeType;

import java.util.Objects;

public class Node {

    private String content;
    private NodeType type;

    public Node() {
    }

    public Node(String content, NodeType type) {
        this.content = content;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public NodeType getType() {
        return type;
    }

    public void setType(NodeType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(content, node.content) &&
                type == node.type;
    }

    @Override
    public int hashCode() {

        return Objects.hash(content, type);
    }

    @Override
    public String toString() {
        return "Node{" +
                "content='" + content + '\'' +
                ", type=" + type +
                '}';
    }
}
