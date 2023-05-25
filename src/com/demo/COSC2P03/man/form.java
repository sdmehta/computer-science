package com.demo.COSC2P03.man;

import BasicIO.ASCIIDataFile;
import BasicIO.BasicForm;
import com.demo.COSC2P03.mappings.Lookup;
import com.demo.COSC2P03.mappings.SortedLookup;

public class form {

    private BasicForm form;
    private Lookup lookup;

    public form() {
        form = new BasicForm("man", "whatis", "apropos", "quit");
        lookup =  new SortedLookup(new ASCIIDataFile("C:\\workspaces\\DataStructuresDemo\\src\\com\\demo\\COSC2P03\\lookup.txt"));
        setupForm();
        runForm();
        form.close();
    }

    private void setupForm() {
        form.setTitle("Lookup");
        form.addTextField("query", "Query: ");
        form.addTextArea("result", "Result: ");
        form.setEditable("result", false);
    }

    private void runForm () {
        int button;

        while (true) {
            button = form.accept();
            String queryInupt = form.readString("query");
            String queryOutput = null;

            if (button == 0) {
                queryOutput = lookup.lookup(queryInupt);
            } else if (button == 1) {
                queryOutput = lookup.lookup(queryInupt).split("\r\n")[0];
            } else if (button == 2) {
                queryOutput = "apropos of " + queryInupt;
            } else if (button == 3) {
                break;
            }

            form.clear("result");
            form.writeString("result", queryOutput);
        }
    }

    public static void main(String[] args) {
        form f = new form();
    }
}