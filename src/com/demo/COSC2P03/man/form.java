package com.demo.COSC2P03.man;

import BasicIO.BasicForm;

public class form {

    private BasicForm form;

    public form () {
        int button;
        form = new BasicForm("man", "whatis", "apropos", "quit");
        setupForm();
        for ( ; ; ) {
            button = form.accept();
            if (button == 3) break;
            switch (button) {
                case 1 :
                    System.out.println("case 1");
                    form.writeString("result", "test text area");

            }
        }
        form.close();

    }
    private void setupForm(){
        form.setTitle("Lookup");
        form.addTextField("query", "Query: ");
        form.addTextArea("result", "Result: ");
        form.setEditable("result", false);
    }

    private void fillForm(){

    }

    public static void main(String[] args) {
        form f = new form();
    }
}
