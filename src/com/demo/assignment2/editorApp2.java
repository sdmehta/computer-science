package com.demo.assignment2;

import BasicIO.BasicForm;

public class editorApp2 {
    public static void main(String[] args) {
        String[] RadioLabel = {"Insert","Delete","Replace"};
        BasicForm form = new BasicForm("Apply Edit","Exit");
        form.addTextField("L","Line",4,15,10);
        form.addTextField("S","Start",4,100,10);
        form.addTextField("E","End",4,200,10);
        form.addTextField("T","Text",30);
        form.addRadioButtons("action","Edit Action",false,RadioLabel);
        form.addTextArea("O","OutPut",20,40);

        //form.show();

        //form.writeString("L", "10");
        System.out.println("before accept");

        do {
            form.accept();
            System.out.println(form.readString("L"));
        }while(true);
        //String s = form.readString("S");
    }
}
