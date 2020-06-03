package me.zhang.coreJava.gui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by zhangxiangdong on 2017/10/31.
 */
public class SelectorTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(SelectorFrame::new);
    }

}

class SelectorFrame extends JFrame {

    private static final int DEFAULT_FONT_SIZE = 18;
    private final JTextArea textArea;
    private final JCheckBox boldCheckBox;
    private final JCheckBox italicCheckBox;
    private final JPanel buttonPanel;
    private final ButtonGroup group;

    public SelectorFrame() throws HeadlessException {
        setPreferredSize(new Dimension(400, 300));

        textArea = new JTextArea("Computation using data flow graphs for scalable machine learning.");
        textArea.setFont(new Font("Serif", Font.PLAIN, DEFAULT_FONT_SIZE));
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setOpaque(false);
        textArea.setEditable(false);
        textArea.setFocusable(false);
        add(textArea, BorderLayout.CENTER);

        /* check boxes */
        JPanel checkBoxPanel = new JPanel();
        boldCheckBox = new JCheckBox("Bold");
        italicCheckBox = new JCheckBox("Italic");
        FontStyleAction l = new FontStyleAction();
        boldCheckBox.addActionListener(l);
        italicCheckBox.addActionListener(l);
        checkBoxPanel.add(boldCheckBox);
        checkBoxPanel.add(italicCheckBox);
        add(checkBoxPanel, BorderLayout.SOUTH);

        /* border */
        Border etched = BorderFactory.createEtchedBorder();
        Border titled = BorderFactory.createTitledBorder(etched, "Choose Font Style");
        checkBoxPanel.setBorder(titled);

        /* radio buttons */
        buttonPanel = new JPanel();
        group = new ButtonGroup();
        addRadioButton("Small", 8);
        addRadioButton("Medium", 12);
        addRadioButton("Large", DEFAULT_FONT_SIZE);
        addRadioButton("X-Large", 24);
        add(buttonPanel, BorderLayout.NORTH);

        /* border */
        Border bevel = BorderFactory.createBevelBorder(BevelBorder.RAISED);
        buttonPanel.setBorder(bevel);

        /* combo box */
        JComboBox<String> faceBox = new JComboBox<>();
        faceBox.addItem("Serif");
        faceBox.addItem("SansSerif");
        faceBox.addItem("Monospaced");
        faceBox.addItem("Dialog");
        faceBox.addActionListener(e -> {
            Font currentFont = textArea.getFont();
            textArea.setFont(new Font(faceBox.getItemAt(faceBox.getSelectedIndex()),
                    currentFont.getStyle(), currentFont.getSize()));
        });
        JPanel comboPanel = new JPanel();
        comboPanel.add(faceBox);
        add(comboPanel, BorderLayout.WEST);

        /* slider */
        JPanel sliderPanel = new JPanel();
        JSlider slider = new JSlider(SwingConstants.VERTICAL, 12, 28, 28);
        slider.addChangeListener(e -> {
            JSlider s = (JSlider) e.getSource();
            int newValue = s.getValue();
            Font currentFont = textArea.getFont();
            textArea.setFont(new Font(currentFont.getName(), currentFont.getStyle(), newValue));
        });
        sliderPanel.add(slider);
        add(sliderPanel, BorderLayout.EAST);

        pack();

        setLocationByPlatform(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void addRadioButton(String label, int size) {
        JRadioButton radioButton = new JRadioButton(label);
        radioButton.addActionListener(e -> {
            Font currentFont = textArea.getFont();
            textArea.setFont(new Font(currentFont.getName(), currentFont.getStyle(), size));
        });
        group.add(radioButton);
        buttonPanel.add(radioButton);
    }

    class FontStyleAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int mode = 0;
            if (boldCheckBox.isSelected()) {
                mode += Font.BOLD;
            }
            if (italicCheckBox.isSelected()) {
                mode += Font.ITALIC;
            }
            //noinspection MagicConstant
            Font currentFont = textArea.getFont();
            textArea.setFont(new Font(currentFont.getName(), mode, currentFont.getSize()));
        }
    }

}
