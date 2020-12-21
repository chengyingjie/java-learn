package com.jesse.learn.algorithm.twopoint;

public class BuildLinked {

    private LinkedNode head;

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        BuildLinked buildLinked = new BuildLinked();
        LinkedNode node = buildLinked.buildLinkedByAddHead(array);
        while (node != null) {
            System.out.print(node.getData());
            node = node.getNext();
        }
    }


    /**
     * 头插法构建链表
     *
     * @param array
     * @return
     */
    public LinkedNode buildLinkedByAddHead(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        for (int i = 0; i < array.length; i++) {
            addHeadNode(array[i]);
        }

        return head;
    }

    private void addHeadNode(int val) {
        LinkedNode node = new LinkedNode(val);
        if (head == null) {
            head = node;
            return;
        }

        node.setNext(head);
        head = node;
    }

    /**
     * 构建环形链表
     *
     * @param array
     * @param pos
     * @return
     */
    public LinkedNode buildCycleLinked(int[] array, int pos) {
        if (array == null || array.length == 0) {
            return null;
        }

        for (int i = 0; i < array.length; i++) {
            addTailNode(array[i]);
        }

        LinkedNode head = buildLinkedByTail(array);

        LinkedNode posNode = head;
        for (int i = 1; i < pos; i++) {
            posNode = posNode.getNext();
        }

        LinkedNode tailNode = head;
        while (tailNode.getNext() != null) {
            tailNode = tailNode.getNext();
        }

        tailNode.setNext(posNode);

        return head;
    }

    /**
     * 尾插法构建链表
     *
     * @param array
     * @return
     */
    public LinkedNode buildLinkedByTail(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        for (int i = 0; i < array.length; i++) {
            addTailNode(array[i]);
        }

        return head;
    }

    private void addTailNode(int val) {
        LinkedNode node = new LinkedNode(val);
        if (head == null) {
            head = node;
            return;
        }

        LinkedNode tmp = head;
        while (tmp.getNext() != null) {
            tmp = tmp.getNext();
        }

        tmp.setNext(node);
    }


    /**
     * 指定位置插入元素
     *
     * @param val
     * @param index
     * @return
     */
    public LinkedNode addNodeAtIndex(int val, int index) {
        if (index == 1) {
            addHeadNode(val);
        } else if (index == nodeSize()) {
            addTailNode(val);
        } else {
            int offset = 1;
            LinkedNode cur = head, pre = null;
            while (cur != null) {
                if (offset == index) {
                    LinkedNode node = new LinkedNode(val);
                    node.setNext(cur);
                    pre.setNext(node);
                    return head;
                }

                pre = cur;
                cur = cur.getNext();
                offset++;
            }
        }

        return head;
    }

    private int nodeSize() {
        int size = 1;
        LinkedNode node = head;
        while (node != null) {
            node = node.getNext();
            size++;
        }

        return size;
    }
}
