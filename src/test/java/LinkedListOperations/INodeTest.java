package LinkedListOperations;

import org.junit.Assert;
import org.junit.Test;

public class INodeTest<T> {
    @Test
    public void given3Numbers_WhenLinked_ShouldPassLinkedListTest() {

        //initialising each node with a key
        INode<Integer> myFirstNode = new INode<>(56);
        INode<Integer> mySecondNode = new INode<>(30);
        INode<Integer> myThirdNode = new INode<>(70);

        //setting next node for each node using setter method
        myFirstNode.setNext(mySecondNode);
        mySecondNode.setNext(myThirdNode);

        //checking if next nodes are set as expected
        boolean result = myFirstNode.getNext().equals(mySecondNode) && mySecondNode.getNext().equals(myThirdNode);
        Assert.assertTrue(result);
    }
}

