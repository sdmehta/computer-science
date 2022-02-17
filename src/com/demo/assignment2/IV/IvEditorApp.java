package com.demo.assignment2.IV;

import BasicIO.BasicForm;


/**
 * IV Editor Application Class
 * Name: Ameya Chindarkar
 * Student Number: 7023609
 * @author AmeyaC
 */
public class IvEditorApp {
    /**
     * Node array which will hold Head of all lines
     */
    private Node [] lineHeads = new Node[50];


    /**
     * Created Linked List representing line of string
     * @param str
     * @return Node
     */
    private  Node createLine (String str) {
        Node dummy = new Node(' ');

        if(str == null || str.length() == 0) {
            return dummy.next;
        }

        Node prev = dummy;

        for(char c: str.toCharArray()){
            prev.next = new Node(c);
            prev = prev.next;
        }

        return dummy.next;
    }

    /**
     * This method traverse through line and returns  its tail node
     * @param head
     * @return Node
     */
    private Node getTail(Node head){
        Node prev = null;
        Node curr = head;

        while(curr != null){
            prev = curr;
            curr = curr.next;
        }

        return prev;
    }

    /**
     * This method inserts new line or new text in existing line
     * @param ipLine
     * @param ipStart
     * @param ipText
     */
    private void  insert(int ipLine, int ipStart, String ipText){
        Node lineHead = createLine(ipText);

        if(ipStart < 0){
            insertLine(ipLine, lineHead);
        } else {
            insertText(ipLine, ipStart, lineHead);
        }
    }

    /**
     * This method inserts new line at ipLine index and move every line down by 1
     * @param ipLine
     * @param lineHead
     */
    private void insertLine(int ipLine, Node lineHead){
        if(lineHeads[ipLine] == null) {
            lineHeads[ipLine] = lineHead;
        } else {
            Node prev = lineHeads[ipLine];
            Node curr = lineHeads[ipLine + 1];

            for(int i = ipLine +1; i < lineHeads.length; i++){
                curr = lineHeads[i];
                lineHeads[i] = prev;
                prev = curr;
            }

            lineHeads[ipLine] = lineHead;
        }
    }


    /**
     * This method inserts new text in existing line in ipLine at ipStart
     * @param ipLine
     * @param ipStart
     * @param lineHead
     */
    private void insertText(int ipLine, int ipStart, Node lineHead){

        if(lineHead == null) return;

        Node lineTail = getTail(lineHead);

        if (ipStart == 0) {
            lineTail.next = lineHeads[ipLine];
            lineHeads[ipLine] = lineHead;
        }else if (ipStart > 0){
            Node prev = null;
            Node curr = lineHeads[ipLine];

            for (int i = 0; i < ipStart && curr != null; i++){
                prev = curr;
                curr = curr.next;
            }

            if(prev == null){
                lineHeads[ipLine] = lineHead;
            } else {
                prev.next = lineHead;
                lineTail.next = curr;
            }
        }
    }

    /**
     * This method deletes line or a char or text from existing line of ipLine
     * @param ipLine
     * @param ipStart
     * @param ipEnd
     */
    private void delete(int ipLine, int ipStart, int ipEnd){
        if(ipStart < 0) {
            deleteLine(ipLine);
        } else if(ipEnd < 0) {
            deleteChar(ipLine, ipStart);
        } else {
            deleteChars(ipLine, ipStart, ipEnd);
        }
    }

    /**
     * This method deletes line from index ipLine
     * @param ipLine
     */
    private void deleteLine(int ipLine){
        for(int i = ipLine; i < lineHeads.length - 1; i++){
            lineHeads[i] = lineHeads[i + 1];
        }
    }


    /**
     * This method to delete a character in line ipLine from index ipStart
     * @param ipLine
     * @param ipStart
     */
    private void deleteChar(int ipLine, int ipStart){
        Node head = lineHeads[ipLine];

        Node prev = null;
        Node curr = head;

        for(int i=0; i < ipStart && curr != null; i++){
            prev = curr;
            curr = curr.next;
        }

        if(prev == null){
            lineHeads[ipLine] = head.next;
        } else if(curr != null) {
            prev.next = curr.next;
        }
    }

    /**
     * This method to delete multiple characters in line ipLine from index ipStart to ipEnd
     * @param ipLine
     * @param ipStart
     * @param ipEnd
     */
    private void deleteChars(int ipLine, int ipStart, int ipEnd){
        Node head = lineHeads[ipLine];

        Node prev = null;
        Node curr = head;

        int i = 0;
        while(i < ipStart && curr != null) {
            prev = curr;
            curr = curr.next;
            i++;
        }

        while(i < ipEnd && curr != null) {
            curr = curr.next;
            i++;
        }

        if(prev == null){
            lineHeads[ipLine] = curr != null ? curr.next : null;
        } else if(curr != null) {
            prev.next = curr.next;
        } else {
            prev.next = null;
        }
    }

    /**
     * This method to replace text from line.
     * Calls delete and insert
     * @param ipLine
     * @param ipStart
     * @param ipEnd
     * @param ipText
     */
    private void replace(int ipLine, int ipStart, int ipEnd, String ipText) {
        delete(ipLine, ipStart, ipEnd);
        insert(ipLine, ipStart, ipText);
    }



    /**
     * This method to write all the given inputs into the output textarea in the form
     * @param form
     */
    private void writeOutput(BasicForm form) {
        StringBuilder output = new StringBuilder();

        int lineNumber = 0;
        for(Node lineHead: lineHeads){
            String lineNumberText = lineNumber < 10 ? "  " + lineNumber++ + " : " : " " + lineNumber++ + " : ";
            output.append(lineNumberText);
            while(lineHead != null){
                output.append(lineHead.data);
                lineHead = lineHead.next;
            }
            output.append("\r\n");
        }

        form.clear("O");
        form.writeString("O", output.toString());
    }

    /**
     * method to create the form
     * @return BasicForm
     */
    private BasicForm createForm() {
        String[] RadioLabel = {"Insert","Delete","Replace"};
        BasicForm form = new BasicForm("Apply Edit","Exit");
        form.addTextField("L","Line",4,15,10);
        form.addTextField("S","Start",4,100,10);
        form.addTextField("E","End",4,200,10);
        form.addTextField("T","Text",30);
        form.addRadioButtons("action","Edit Action",false,RadioLabel);
        form.addTextArea("O","OutPut",20,40);
        return  form;
    }

    /**
     * main method which is starting point of IV Editor application
     * @param args
     */
    public static void main(String[] args){
        IvEditorApp app = new IvEditorApp();

        BasicForm form =app.createForm();

        int ipLine;
        int ipStart;
        int ipEnd;
        String ipText;
        String ipAction;

        do {
            int button = form.accept();
            if(button == 1) {
                System.exit(0);
            }
            //1. read inputs
            ipLine = form.readInt("L");
            String ipStartStr = form.readString("S") == null || "".equals(form.readString("S")) ? "-1" : form.readString("S");
            ipStart = Integer.valueOf(ipStartStr);
            String ipEndStr = form.readString("E") == null || "".equals(form.readString("E")) ? "-1" : form.readString("E");
            ipEnd = Integer.valueOf(ipEndStr);
            ipText = form.readString("T");
            ipAction = form.readString("action");

            //2. check action and process
            if(ipAction.equals("Insert")){
                app.insert(ipLine, ipStart, ipText);
            }else if (ipAction.equals("Delete")){
                app.delete(ipLine, ipStart, ipEnd);
            }else if (ipAction.equals("Replace")){
                app.replace(ipLine, ipStart, ipEnd, ipText);
            }

            //3. write output
            app.writeOutput(form);
        }while(true);
    }
}