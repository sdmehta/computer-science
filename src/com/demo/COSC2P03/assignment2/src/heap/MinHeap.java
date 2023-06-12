package com.demo.COSC2P03.assignment2.src.heap;

import com.demo.COSC2P03.assignment2.src.Node;

public class MinHeap {
    Node[] heap = new Node[512];
    int pos = 0;

    public void add(Node data) {
        heap[++pos] = data;
        int tempPos = pos;

        while (tempPos / 2 != 0) {
            int parentPosition = tempPos / 2;

            if (heap[tempPos].compareTo(heap[parentPosition]) < 0) {

                swap(tempPos, parentPosition);
                tempPos = parentPosition;
            } else {
                break;
            }
        }
    }

    public Node poll() {
        Node result = null;

        if (isEmpty()) return result;

        result = heap[1];
        heap[1] = heap[pos];
        heap[pos--] = null;

        int tmpPos = 1;

        while (tmpPos < pos) {
            Node left = null;
            Node right = null;
            left = tmpPos * 2 <= pos ? heap[tmpPos * 2] : null;
            right = tmpPos * 2 + 1 <= pos ? heap[tmpPos * 2 + 1] : null;

            int lowerPos = 0;

            if (left != null && right != null)
                lowerPos = (left.compareTo(right) <= 0) ? tmpPos * 2 : tmpPos * 2 + 1;
            else if (left != null)
                lowerPos = tmpPos * 2;
            else
                break;

            if (heap[tmpPos].compareTo(heap[lowerPos]) > 0)
                swap(tmpPos, lowerPos);

            tmpPos = lowerPos;
        }

        return result;
    }

    private void swap(int i, int j) {
        Node temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public boolean isEmpty() {
        if (pos == 0) {
            return true;
        }

        return false;
    }
}
