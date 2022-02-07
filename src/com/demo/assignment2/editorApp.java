package com.demo.assignment2;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class editorApp {

    public static void main(String[] args) {
        JFrame frame = new JFrame("IV Editor");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 400, 550);
        frame.setResizable(false);

        // 0.1
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        menuBar.add(file);
        JMenu help = new JMenu("Help");
        menuBar.add(help);
        frame.setJMenuBar(menuBar);

        // 0
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentPane);
        contentPane.setLayout(null);

        // 1
        JLabel lblLine = new JLabel("Line");
        lblLine.setBounds(10, 10, 30, 20);
        contentPane.add(lblLine);

        JTextField line = new JTextField();
        line.setBounds(40, 10, 40, 20);
        contentPane.add(line);
        line.setColumns(10);

        JLabel lblStart = new JLabel("Start");
        lblStart.setBounds(120, 10, 40, 20);
        contentPane.add(lblStart);

        JTextField start = new JTextField();
        start.setBounds(155, 10, 40, 20);
        contentPane.add(start);
        start.setColumns(10);

        JLabel lblEnd = new JLabel("End");
        lblEnd.setBounds(250, 10, 40, 20);
        contentPane.add(lblEnd);

        JTextField end = new JTextField();
        end.setBounds(275, 10, 40, 20);
        contentPane.add(end);
        end.setColumns(10);

        // 2
        JLabel lblText = new JLabel("Text");
        lblText.setBounds(10, 40, 40, 20);
        contentPane.add(lblText);

        JTextField text = new JTextField();
        text.setBounds(40, 40, 300, 20);
        contentPane.add(text);
        text.setColumns(10);

        // 3
        JLabel lblEditAction = new JLabel("Edit Action");
        lblEditAction.setBounds(10, 70, 80, 20);
        contentPane.add(lblEditAction);

        JRadioButton insert = new JRadioButton("Insert");
        insert.setBounds(20, 90, 80, 20);
        contentPane.add(insert);

        JRadioButton Delete = new JRadioButton("Delete");
        Delete.setBounds(100, 90, 80, 20);
        contentPane.add(Delete);

        JRadioButton Replace = new JRadioButton("Replace");
        Replace.setBounds(180, 90, 80, 20);
        contentPane.add(Replace);

        // 4
        JLabel lblOutput = new JLabel("Output");
        lblOutput.setBounds(10, 120, 40, 20);
        contentPane.add(lblOutput);

        JTextArea output = new JTextArea();
        output.setBounds(10, 140, 350, 300);
        contentPane.add(output);

        // 5
        JButton btnApplyEdit = new JButton("Apply Edit");
        btnApplyEdit.setBounds(10, 455, 100, 25);
        contentPane.add(btnApplyEdit);

        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(200, 455, 100, 25);
        contentPane.add(btnExit);

        frame.setVisible(true);
    }
}
