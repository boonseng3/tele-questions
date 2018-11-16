package com.obs.q2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NodeLinker {

    public Node linkRightNode(Node rootNode) {
        List<Node> parents = new ArrayList<>();
        parents.add(rootNode);

        while (!parents.isEmpty()) {
            // get children of the same level
            List<Node> sameLevelChildren = new ArrayList<>();
            for (Node parent : parents) {
                if (parent.getChildren() != null) {
                    sameLevelChildren.addAll(Arrays.asList(parent.getChildren()));
                }
            }
            setRight(sameLevelChildren);
            // move to next level
            parents = sameLevelChildren;
        }

        return rootNode;
    }

    public void setRight(List<Node> sameLevelChildren) {
        if (!sameLevelChildren.isEmpty()) {
            for (int i = 0; i < sameLevelChildren.size() - 1; i++) {
                sameLevelChildren.get(i).setRight(sameLevelChildren.get(i + 1));
            }
        }
    }

}
