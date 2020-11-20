import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;

public class SimpleUi {
    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;

    public static void addComponentsToPane(Container pane) {
//        if (RIGHT_TO_LEFT) {
//            pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
//        }

        JButton button;
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        if (shouldFill) {
            //natural height, maximum width
            c.fill = GridBagConstraints.HORIZONTAL;
        }

        button = new JButton("Button 1");
        c.weighty = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        pane.add(button, c);

        button = new JButton("Button 2");
        c.fill = GridBagConstraints.HORIZONTAL;
//        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 0;
        pane.add(button, c);

        button = new JButton("Button 3");
        c.fill = GridBagConstraints.HORIZONTAL;
//        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 0;
        pane.add(button, c);

        button = new JButton("Long-Named Button 4");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 40;      //make this component tall
        c.weightx = 0.0;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 1;
        pane.add(button, c);

        button = new JButton("5");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;       //reset to default
        c.weighty = 1.0;   //request any extra vertical space
        c.anchor = GridBagConstraints.PAGE_END; //bottom of space
        c.insets = new Insets(10,0,0,0);  //top padding
        c.gridx = 1;       //aligned with button 2
        c.gridwidth = 2;   //2 columns wide
        c.gridy = 2;       //third row
        pane.add(button, c);
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("GridBagLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SimpleUi.createAndShowGUI();
    }
}

//
//import java.awt.GridLayout;
//import java.awt.Label;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.JTabbedPane;
//
//public class SimpleUi {
//
//    private static void createAndShowGUI() {
//
//        // Create and set up the window.
//        final JFrame frame = new JFrame("Split Pane Example",);
//
//        // Display the window.
//        frame.setSize(500, 300);
//        frame.setVisible(true);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        // set grid layout for the frame
//        frame.getContentPane().setLayout(new GridLayout(1, 1));
//
//        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
//
//        tabbedPane.addTab("Tab1", makePanel("This is tab 1"));
//        tabbedPane.addTab("Tab2", makePanel("This is tab 2"));
//
//        frame.add(tabbedPane);
//
//    }
//
//    private static JPanel makePanel(String text) {
//        JPanel p = new JPanel();
//        p.add(new Label(text));
//        p.setLayout(new GridLayout(1, 1));
//        return p;
//    }
//
//    public static void main(String[] args) {
//        SimpleUi.createAndShowGUI();
//    }
//
//}
//


/**
 * Card layout example
 */

//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//
//public class SimpleUi implements ItemListener {
//    JPanel cards; //a panel that uses CardLayout
//    final static String BUTTONPANEL = "Card with JButtons";
//    final static String TEXTPANEL = "Card with JTextField";
//
//    public void addComponentToPane(Container pane) {
//        //Put the JComboBox in a JPanel to get a nicer look.
//        JPanel comboBoxPane = new JPanel(); //use FlowLayout
//        String comboBoxItems[] = { BUTTONPANEL, TEXTPANEL ,"This is my field"};
//        JComboBox cb = new JComboBox(comboBoxItems);
//        cb.setEditable(false);
//        cb.addItemListener(this);
//        comboBoxPane.add(cb);
//
//        //Create the "cards".
//        JPanel card1 = new JPanel();
//        card1.add(new JButton("Button 1"));
//        card1.add(new JButton("Button 2"));
//        card1.add(new JButton("Button 3"));
//
//        JPanel card2 = new JPanel();
//        card2.add(new JTextField("TextField", 20));
//
//        //Create the panel that contains the "cards".
//        cards = new JPanel(new CardLayout());
//        cards.add(card1, BUTTONPANEL);
//        cards.add(card2, TEXTPANEL);
//
//        pane.add(comboBoxPane, BorderLayout.PAGE_START);
//        pane.add(cards, BorderLayout.CENTER);
//    }
//
//    public void itemStateChanged(ItemEvent evt) {
//        CardLayout cl = (CardLayout)(cards.getLayout());
//        cl.show(cards, (String)evt.getItem());
//    }
//
//    /**
//     * Create the GUI and show it.  For thread safety,
//     * this method should be invoked from the
//     * event dispatch thread.
//     */
//    private static void createAndShowGUI() {
//        //Create and set up the window.
//        JFrame frame = new JFrame("CardLayoutDemo");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        //Create and set up the content pane.
//        SimpleUi demo = new SimpleUi();
//        demo.addComponentToPane(frame.getContentPane());
//
//        //Display the window.
//        frame.pack();
//        frame.setVisible(true);
//    }
//
//    public static void main(String[] args) {
//        /* Use an appropriate Look and Feel */
//        try {
//            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
//        } catch (UnsupportedLookAndFeelException ex) {
//            ex.printStackTrace();
//        } catch (IllegalAccessException ex) {
//            ex.printStackTrace();
//        } catch (InstantiationException ex) {
//            ex.printStackTrace();
//        } catch (ClassNotFoundException ex) {
//            ex.printStackTrace();
//        }
//        /* Turn off metal's use of bold fonts */
//        UIManager.put("swing.boldMetal", Boolean.FALSE);
//
//        //Schedule a job for the event dispatch thread:
//        //creating and showing this application's GUI.
//        javax.swing.SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                createAndShowGUI();
//            }
//        });
//    }
//}

//import java.awt.event.*;
//import java.awt.*;
//import javax.swing.*;
//class SimpleUi extends JFrame implements ItemListener {
//
//    // frame
//    static JFrame f;
//
//    // label
//    static JLabel l, l1;
//
//    // combobox
//    static JComboBox c1;
//
//    // main class
//    public static void main(String[] args)
//    {
//        // create a new frame
//        f = new JFrame("frame");
//
//        // create a object
//        SimpleUi s = new SimpleUi();
//
//        // set layout of frame
//        f.setLayout(new FlowLayout());
//
//        // array of string contating cities
//        String s1[] = { "Jalpaiguri", "Mumbai", "Noida", "Kolkata", "New Delhi" };
//
//        // create checkbox
//        c1 = new JComboBox(s1);
//
//        // add ItemListener
//        c1.addItemListener(s);
//
//        // create labels
//        l = new JLabel("select your city ");
//        l1 = new JLabel("Jalpaiguri selected");
//
//        // set color of text
//        l.setForeground(Color.red);
//        l1.setForeground(Color.blue);
//
//        // create a new panel
//        JPanel p = new JPanel();
//
//        p.add(l);
//
//        // add combo box to panel
//        p.add(c1);
//
//        p.add(l1);
//
//        // add panel to frame
//        f.add(p);
//
//        // set the size of frame
//        f.setSize(400, 300);
//
//        f.show();
//    }
//    public void itemStateChanged(ItemEvent e)
//    {
//        // if the state combobox is changed
//        System.out.println(e.getItem()+" "+c1.getSelectedItem());
//        if (e.getItem().equals(c1.getSelectedItem())){
//            l1.setText(c1.getSelectedItem() + " selected");
//        }
//    }
//}

//public class SimpleUi extends JFrame {
//    public static void main(String[] args) {
//        JFrame mainFrame = new JFrame("Library Management System");
//        //button example
//        JPanel mainPanel = new JPanel();
//        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
//
//        JButton button1 = new JButton("button1");
//        JButton button2 = new JButton("button2");
//        JButton button3 = new JButton("button3");
//
//        button1.setBounds(100,100,200,30);
//        button2.setBounds(100,200,200,30);
//        button3.setBounds(100,300,200,30);
//        //add to main panel
//        mainPanel.add(button1);
//        mainPanel.add(button2);
//        mainPanel.add(button3);
//
//        mainPanel.setBackground(Color.BLACK);
//        mainFrame.add(mainPanel);
//        mainFrame.setSize(500,500);
//        mainFrame.setVisible(true);
//        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }
//}
