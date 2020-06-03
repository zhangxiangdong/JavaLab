package me.zhang.coreJava.gui;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

/**
 * Created by zhangxiangdong on 2017/10/30.
 */
public class TextLayoutTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(TextFrame::new);
    }

}

class TextFrame extends JFrame {

    public TextFrame() throws HeadlessException {
        setPreferredSize(new Dimension(300, 300));

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));

        JLabel usernameLabel = new JLabel("Username: ", JLabel.CENTER);
        JTextField usernameField = new JTextField(20);
        JLabel passwordLabel = new JLabel("Password: ", SwingConstants.CENTER);
        JPasswordField pwdField = new JPasswordField(20);
        // 设置回显字符
        pwdField.setEchoChar('密');

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(pwdField);
        add(panel, BorderLayout.NORTH);

        JTextArea area = new JTextArea(20, 100);
        area.setText("TensorFlow is an open source software library for numerical computation using data flow graphs. " +
                "The graph nodes represent mathematical operations, " +
                "while the graph edges represent the multidimensional data arrays (tensors) that flow between them. " +
                "This flexible architecture lets you deploy computation to one or more CPUs or GPUs in a desktop, " +
                "server, or mobile device without rewriting code. TensorFlow also includes TensorBoard, " +
                "a data visualization toolkit.\n" +
                "\n" +
                "TensorFlow was originally developed by researchers and engineers working on the Google Brain" +
                " team within Google's Machine Intelligence Research organization for the purposes of conducting" +
                " machine learning and deep neural networks research. The system is general enough to be applicable" +
                " in a wide variety of other domains, as well.\n" +
                "\n" +
                "If you want to contribute to TensorFlow, be sure to review the contribution guidelines." +
                " This project adheres to TensorFlow's code of conduct. By participating, " +
                "you are expected to uphold this code.\n" +
                "\n" +
                "We use GitHub issues for tracking requests and bugs. So please see TensorFlow Discuss for " +
                "general questions and discussion, and please direct specific questions to Stack Overflow.");
        area.setLineWrap(true);
        /* pane with scroll bar */
        JScrollPane scrollPane = new JScrollPane(area);
        add(scrollPane, BorderLayout.CENTER);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener((e -> {
            // 打印输入框中输入的密码
            System.out.println(Arrays.toString(pwdField.getPassword()));
        }));
        add(submitButton, BorderLayout.SOUTH);

        pack();

        setLocationByPlatform(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
