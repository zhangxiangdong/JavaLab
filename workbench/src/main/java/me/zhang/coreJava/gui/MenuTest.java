package me.zhang.coreJava.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by zhangxiangdong on 2017/11/3.
 */
public class MenuTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(MenuFrame::new);
    }

}

class MenuFrame extends JFrame {

    public MenuFrame() throws HeadlessException {
        setPreferredSize(new Dimension(400, 300));

        JMenuBar menuBar = new JMenuBar();

        /* File */
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic('F');
        JMenuItem newItem = new JMenuItem("New", 'N');
        JMenuItem openItem = new JMenuItem("Open", 'O');
        JMenuItem saveItem = new JMenuItem("Save", 'S');
        // 添加动作快捷键（打开：Ctrl + O）
        openItem.setAccelerator(KeyStroke.getKeyStroke("ctrl 0"));
        openItem.addActionListener(e -> {
            System.out.println("Open new file...");
        });
        JMenuItem exitItem = new JMenuItem("Exit", 'E');
//        exitItem.addActionListener(e -> {
//            System.exit(0);
//        });
        fileMenu.add(newItem);
        fileMenu.addSeparator();
        fileMenu.add(openItem);
        fileMenu.addSeparator();
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        ButtonGroup group = new ButtonGroup();
        JRadioButtonMenuItem insertItem = new JRadioButtonMenuItem("Insert");
        insertItem.setSelected(true);
        JRadioButtonMenuItem overtypeItem = new JRadioButtonMenuItem("Overtype");
        group.add(insertItem);
        group.add(overtypeItem);
        fileMenu.add(insertItem);
        fileMenu.add(overtypeItem);
        fileMenu.addSeparator();
        fileMenu.add(new AbstractAction(exitItem.getText()) {

            {
                putValue(Action.MNEMONIC_KEY, (int) 'E');
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        /* Help */
        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutItem = new JMenuItem("About");

        String filePath = System.getProperty("user.dir") + "/Workbench/src/main/java/me/zhang/coreJava/gui/about.png";
        Image image = Toolkit.getDefaultToolkit().getImage(filePath);
        ImageIcon imageIcon = new ImageIcon(image);
        aboutItem.setIcon(imageIcon);

        JCheckBoxMenuItem readonlyItem = new JCheckBoxMenuItem("Read-only");
        readonlyItem.addActionListener(e -> {
            boolean saveOk = !readonlyItem.isSelected();
            saveItem.setEnabled(saveOk);
        });
        helpMenu.add(readonlyItem);
        helpMenu.add(aboutItem);

        menuBar.add(fileMenu);
        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        addMouseListener(new PopUpClickListener());

        pack();
        setLocationByPlatform(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

class PopUpMenu extends JPopupMenu {

    public PopUpMenu() {
        JMenuItem cutItem = new JMenuItem("Cut");
        JMenuItem copyItem = new JMenuItem("Copy");
        JMenuItem pasteItem = new JMenuItem("Paste");
        add(cutItem);
        add(copyItem);
        add(pasteItem);
    }

}

class PopUpClickListener extends MouseAdapter {

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        if (e.isPopupTrigger()) {
            doPopUp(e);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
        if (e.isPopupTrigger()) {
            doPopUp(e);
        }
    }

    private void doPopUp(MouseEvent e) {
        PopUpMenu menu = new PopUpMenu();
        menu.show(e.getComponent(), e.getX(), e.getY());
    }

}