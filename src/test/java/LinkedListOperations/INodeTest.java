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

        //check if next nodes are set (as expected)
        boolean result = myFirstNode.getNext().equals(mySecondNode) && mySecondNode.getNext().equals(myThirdNode);
        Assert.assertTrue(result);
    }
    
    @Test
    public void given3Numbers_WhenAddedToLinkedList_ShouldBeAddedToTop() {
        //initialize node objects
        INode<Integer> myFirstNode = new  INode<>(70);
        INode<Integer> mySecondNode = new INode<>(30);
        INode<Integer> myThirdNode = new  INode<>(56);

        //create a linked list
        MyLinkedList myLinkedList = new MyLinkedList();
        //add nodes to the linked list
        myLinkedList.add(myFirstNode);
        myLinkedList.add(mySecondNode);
        myLinkedList.add(myThirdNode);
        boolean result = myLinkedList.head.equals(myThirdNode) && myLinkedList.head.getNext().equals(mySecondNode) && myLinkedList.tail.equals(myFirstNode);
        Assert.assertTrue(result);
    }
    
    @Test
    public void given3Numbers_WhenAddedToLinkedList_ShouldBeAppendedToBottom() {
        //initialise node objects
        INode<Integer> myFirstNode = new INode<>(70);
        INode<Integer> mySecondNode = new INode<>(30);
        INode<Integer> myThirdNode = new INode<>(56);

        //create a linked list
        MyLinkedList myLinkedList = new MyLinkedList();
        //add nodes to the linked list
        myLinkedList.append(myFirstNode);
        myLinkedList.append(mySecondNode);
        myLinkedList.append(myThirdNode);
        boolean result = myLinkedList.head.equals(myFirstNode) && myLinkedList.head.getNext().equals(mySecondNode) && myLinkedList.tail.equals(myThirdNode);
        Assert.assertTrue(result);
    }
    
    
    @Test
    public void given3Numbers_WhenInserting2ndInBetween_ShouldPassLinkedListTest() {
        //initialise node objects
        INode<Integer> myFirstNode =  new  INode<>(70);
        INode<Integer> mySecondNode = new INode<>(30);
        INode<Integer> myThirdNode =  new  INode<>(56);

        //create a linked list
        MyLinkedList myLinkedList = new MyLinkedList();
        //add nodes to the linked list
        myLinkedList.add(myFirstNode);
        myLinkedList.append(myThirdNode);
        myLinkedList.insert(myFirstNode , mySecondNode);
        boolean result = myLinkedList.head.equals(myFirstNode) && myLinkedList.head.getNext().equals(mySecondNode) && myLinkedList.tail.equals(myThirdNode);
        Assert.assertTrue(result);
    }
    
    @Test
    public void given3NumbersInList_AfterDeleting1stElement_ShouldHave2ndElementAtHead() {
        //initialise node objects
        INode<Integer> myFirstNode = new INode<>(56);
        INode<Integer> mySecondNode = new INode<>(30);
        INode<Integer> myThirdNode = new INode<>(70);
        //create a linked list
        MyLinkedList myLinkedList = new MyLinkedList();
        //add nodes to the linked list
        myLinkedList.append(myFirstNode);
        myLinkedList.append(mySecondNode);
        myLinkedList.append(myThirdNode);
        //delete first element
        myLinkedList.pop();
        boolean result = myLinkedList.head.equals(mySecondNode);
        Assert.assertTrue(result);
    }
    
    @Test
    public void given3NumbersInList_AfterDeletingLastElement_ShouldReturnLastElement() {
        //initialise node objects
        INode<Integer> myFirstNode = new INode<>(56);
        INode<Integer> mySecondNode = new INode<>(30);
        INode<Integer> myThirdNode = new INode<>(70);
        //create a linked list
        MyLinkedList myLinkedList = new MyLinkedList();
        //add nodes to the linked list
        myLinkedList.append(myFirstNode);
        myLinkedList.append(mySecondNode);
        myLinkedList.append(myThirdNode);
        //delete first element
        INode result = myLinkedList.popLast();
        Assert.assertEquals(myThirdNode,  result);
    }

    @Test
    public void given3NumbersInList_WhenWithMatchingValueOfSearchNode_ShouldReturnTrue() {
        //initialise node objects
        INode<Integer> myFirstNode = new INode<>(56);
        INode<Integer> mySecondNode = new INode<>(30);
        INode<Integer> myThirdNode = new INode<>(70);
        //create a linked list
        MyLinkedList myLinkedList = new MyLinkedList();
        //add nodes to the linked list
        myLinkedList.append(myFirstNode);
        myLinkedList.append(mySecondNode);
        myLinkedList.append(myThirdNode);
        //check if node with value 30 is present
        boolean result = myLinkedList.search(mySecondNode);
        Assert.assertTrue(result);
    }
}

