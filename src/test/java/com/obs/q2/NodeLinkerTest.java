package com.obs.q2;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class NodeLinkerTest {


    @Test
    public void updateRightNode() {
        Node rootNode = new Node();

        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();
        Node node5 = new Node();
        Node node6 = new Node();
        Node node7 = new Node();
        Node node8 = new Node();
        Node node9 = new Node();
        Node node10 = new Node();

        rootNode.setChildren(new Node[]{node2, node3, node4});
        node2.setChildren(new Node[]{node5, node6});
        node4.setChildren(new Node[]{node7});
        node5.setChildren(new Node[]{node8, node9});
        node7.setChildren(new Node[]{node10});

        NodeLinker linker = new NodeLinker();
        Node result = linker.linkRightNode(rootNode);

        assertThat(result.getChildren()[0].getRight()).isEqualTo(node3);
        assertThat(result.getChildren()[1].getRight()).isEqualTo(node4);
        assertThat(result.getChildren()[0].getChildren()[0].getRight()).isEqualTo(node6);
        assertThat(result.getChildren()[0].getChildren()[1].getRight()).isEqualTo(node7);
        assertThat(result.getChildren()[0].getChildren()[0].getChildren()[0].getRight()).isEqualTo(node9);
        assertThat(result.getChildren()[0].getChildren()[0].getChildren()[1].getRight()).isEqualTo(node10);
    }

}