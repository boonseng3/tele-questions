package com.obs.q2;

import java.util.Arrays;
import java.util.Objects;

public class Node {

    public Node[] children;
    public Node right;

    public Node[] getChildren() {
        return children;
    }

    public Node setChildren(Node[] children) {
        this.children = children;
        return this;
    }

    public Node getRight() {
        return right;
    }

    public Node setRight(Node right) {
        this.right = right;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Arrays.equals(children, node.children) &&
                Objects.equals(right, node.right);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(right);
        result = 31 * result + Arrays.hashCode(children);
        return result;
    }
}
