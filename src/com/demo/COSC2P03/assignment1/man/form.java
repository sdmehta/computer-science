package com.demo.COSC2P03.assignment1.man;

import BasicIO.ASCIIDataFile;
import BasicIO.BasicForm;
import com.demo.COSC2P03.assignment1.mappings.Lookup;
import com.demo.COSC2P03.assignment1.mappings.SortedLookup;

public class form {

    private BasicForm form;
    private Lookup lookup;

    public form() {
        form = new BasicForm("man", "whatis", "apropos", "quit");
        lookup =  new SortedLookup(new ASCIIDataFile());
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
            String output = null;

            if (button == 0) {
                output = getMan(queryInupt);
            } else if (button == 1) {
                output = getWhatIs(queryInupt);
            } else if (button == 2) {
                output = getApropos(queryInupt);
            } else if (button == 3) {
                break;
            }

            form.clear("result");
            form.writeString("result", output);
        }
    }

    private String getMan(String query) {
        String result = null;
        try {
            result = lookup.lookup(query);
        } catch (Exception e) {
            result = "Error - " + e.getMessage();
            System.out.println(e.getMessage());
        } finally {
            return result;
        }
    }

    private String getWhatIs(String query) {
        String result = null;
        try {
            result = lookup.lookup(query).split("\r\n")[0];
        } catch (Exception e) {
            result = "Error - " + e.getMessage();
            System.out.println(e.getMessage());
        } finally {
            return result;
        }
    }

    private String getApropos(String query) {
        String[] keys = lookup.search(query);
        StringBuilder str = new StringBuilder();
        for (String key : keys) {
            str.append(getWhatIs(key));
            str.append("\r\n");
        }

        return str.toString();
    }

    public static void main(String[] args) {
        form f = new form();
    }
}