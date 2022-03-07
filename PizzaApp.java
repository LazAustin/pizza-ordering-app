import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class PizzaApp {
    JFrame frame;
    JPanel contentPane;
    // radio buttons and button group
    private JRadioButton regularCrustButton;
    private JRadioButton thinCrustButton;
    private JRadioButton handCrustButton;
    private JRadioButton deepCrustButton;
    private ButtonGroup crustButtonGroup;

    // check boxes
    private JCheckBox pepperoniBox;
    private JCheckBox sausageBox;
    private JCheckBox cheeseBox;
    private JCheckBox pepperBox;
    private JCheckBox onionBox;
    private JCheckBox mushroomBox;
    private JCheckBox oliveBox;
    private JCheckBox anchovyBox;

    // text fields
    private JTextField breadSticksText;
    private JTextField buffaloWingsText;
    private JTextField nameText;
    private JTextField addressText;
    private JTextField cityText;
    
    public static void main(String[]args){
     
        PizzaApp pizza = new PizzaApp();
        pizza.start();
    }
    
    public void start(){
        
        frame = new JFrame("GUI Pizza");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setLocationRelativeTo(null);
                
        contentPane = (JPanel)frame.getContentPane();
        contentPane.setLayout(new BorderLayout(6,6));
        contentPane.setBorder(BorderFactory.createEmptyBorder(6,6,6,6));
     
        makeContent();
        makeMenu();
                
        frame.pack();
        frame.setVisible(true);
    }
    
    public void makeMenu(){
    
        JMenuBar menuBar;
        JMenu menu;
        JMenuItem menuItem;
            
        menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        
        menuBar.add(makeFileMenu());
        menuBar.add(makeAboutMenu());
        
        //not visible when I first open app? WHY???
        menuBar.setVisible(true);
    }
        
    public JMenu makeFileMenu(){
        JMenu menu;
        JMenuItem menuItem;
        
        menu = new JMenu("File");
        menuItem = new JMenuItem("New Order");
        menu.add(menuItem);
        menuItem.addActionListener(new newListener());
        menuItem.setMnemonic(KeyEvent.VK_N);
        //add Accelerator
        menuItem = new JMenuItem("Save Order");
        menu.add(menuItem);
        menuItem.addActionListener(new saveListener());
        menuItem.setMnemonic(KeyEvent.VK_S);
        //add Accelerator
        menu.addSeparator();
        menuItem = new JMenuItem("Exit");
        menu.add(menuItem);
        menuItem.addActionListener(new exitListener());
        menuItem.setMnemonic(KeyEvent.VK_X);
        //add Accelerator
        
        return menu;
    }
        
    public JMenu makeAboutMenu(){
        JMenu menu;
        JMenuItem menuItem;
        
        menu = new JMenu("About");
        
        menuItem = new JMenuItem("About GUI Pizza");
        menu.add(menuItem);
        menuItem.addActionListener(new aboutListener());
        
        return menu;
    }   
        
    
    
    public void makeContent(){

        makeNorthRegion();
        makeWestRegion();
        makeCenterRegion();
        makeEastRegion();
        makeSouthRegion();
     
    }
    
    public void makeNorthRegion(){
    
        JLabel pizzaImage = new JLabel(new ImageIcon("pizza.jpg"),JLabel.CENTER);
        contentPane.add(pizzaImage,BorderLayout.NORTH);
    }
    
    public void makeWestRegion(){
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Choose a Crust"));
        crustButtonGroup = new ButtonGroup();
        
        regularCrustButton = new JRadioButton("Regular Crust",true);
        crustButtonGroup.add(regularCrustButton);
        panel.add(regularCrustButton);
        
        thinCrustButton = new JRadioButton("Thin Crust",false);
        crustButtonGroup.add(thinCrustButton);
        panel.add(thinCrustButton);
        
        handCrustButton = new JRadioButton("Hand Tossed",false);
        crustButtonGroup.add(handCrustButton);
        panel.add(handCrustButton);
        
        deepCrustButton = new JRadioButton("Deep Dish", false);
        crustButtonGroup.add(deepCrustButton);
        panel.add(deepCrustButton);
        
        contentPane.add(panel,BorderLayout.WEST);
    }
    
    private void makeCenterRegion(){
        
        JPanel panel;
        panel = new JPanel();
        
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Choose a Topping"));
        
        pepperoniBox = new JCheckBox("Pepperoni",false);
        panel.add(pepperoniBox);
       
        sausageBox = new JCheckBox("Sausage",false);
        panel.add(sausageBox);
        
        cheeseBox = new JCheckBox("Cheese",false);
        panel.add(cheeseBox);
        
        pepperBox = new JCheckBox("Peppers",false);
        panel.add(pepperBox);
        
        onionBox = new JCheckBox("Onions",false);
        panel.add(onionBox);
        
        mushroomBox = new JCheckBox("Mushrooms",false);
        panel.add(mushroomBox);
        
        oliveBox = new JCheckBox("Olives",false);
        panel.add(oliveBox);
        
        anchovyBox = new JCheckBox("Anchovies",false);
        panel.add(anchovyBox);
        
        contentPane.add(panel,BorderLayout.CENTER);
        
    }
    
    private void makeEastRegion(){
        
        JPanel panel;
        panel = new JPanel();
        
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Sides(Enter Quantity)"));
        panel.setPreferredSize(new Dimension(150,0));
        
        JPanel smallPanel = new JPanel();
        smallPanel.setLayout(new BoxLayout(smallPanel,BoxLayout.X_AXIS));
        breadSticksText=new JTextField("",2);
        breadSticksText.setMaximumSize(new Dimension(20,24));
        smallPanel.add(breadSticksText);
        smallPanel.add(new JLabel(" Bread Sticks"));
        smallPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(smallPanel);
        
        smallPanel = new JPanel();
        smallPanel.setLayout(new BoxLayout(smallPanel,BoxLayout.X_AXIS));
        buffaloWingsText=new JTextField("",2);
        buffaloWingsText.setMaximumSize(new Dimension(20,24));
        smallPanel.add(buffaloWingsText);
        smallPanel.add(new JLabel(" Buffalo Wings"));
        smallPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(smallPanel);
        
        contentPane.add(panel, BorderLayout.EAST);
    }
    
    public void makeSouthRegion(){
        JPanel panel;
        panel = new JPanel();
        
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Deliver To:"));
        
        JPanel smallPanel;
        
        smallPanel = new JPanel();
        smallPanel.setLayout(new BoxLayout(smallPanel, BoxLayout.Y_AXIS));
        smallPanel.add(new JLabel("Name:"));
        smallPanel.add(new JLabel("Address:"));
        smallPanel.add(new JLabel("City,St.,Zip"));
        smallPanel.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        panel.add(smallPanel);
        
        smallPanel = new JPanel();
        smallPanel.setLayout(new BoxLayout(smallPanel,BoxLayout.Y_AXIS));
        nameText = new JTextField();
        addressText = new JTextField();
        cityText = new JTextField();
        smallPanel.add(nameText);
        smallPanel.add(addressText);
        smallPanel.add(cityText);
        smallPanel.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));

        panel.add(smallPanel);
        contentPane.add(panel,BorderLayout.SOUTH);
    }    
        
    public class newListener implements ActionListener {
    
        public void actionPerformed(ActionEvent e){
            regularCrustButton.setSelected(true);
            
            pepperoniBox.setSelected(false);
            sausageBox.setSelected(false);
            cheeseBox.setSelected(false);
            pepperBox.setSelected(false);
            onionBox.setSelected(false);
            mushroomBox.setSelected(false);
            oliveBox.setSelected(false);
            anchovyBox.setSelected(false);
            
            breadSticksText.setText("");
            buffaloWingsText.setText("");
            nameText.setText("");
            addressText.setText("");
            cityText.setText("");
        }
    }
    
    public class saveListener implements ActionListener {
        
        public void actionPerformed(ActionEvent e){
            String order = "Pizza Order\n" +
            "===========\n" +
               "Crust:\n";
               
            if (regularCrustButton.isSelected())
                order += "  Regular\n";
            else if (thinCrustButton.isSelected())
                order += "  Thin\n";
            else if (deepCrustButton.isSelected())
                order += "  Deep Dish\n";
            else if (handCrustButton.isSelected())
                order += "  Hand Tossed\n";
            else
                JOptionPane.showMessageDialog(frame,"You must select a crust type!","Crust Type Error",JOptionPane.ERROR_MESSAGE);
            
            order += "Toppings:\n";
            if (pepperoniBox.isSelected())
                order += "  Pepperoni\n";
            if (sausageBox.isSelected())
                order += "  Sausage\n";
            if (cheeseBox.isSelected())
                order += "  Extra Cheese\n";
            if (pepperBox.isSelected())
                order+= "   Peppers\n";
            if (onionBox.isSelected())
                order += "  Onions\n";
            if (mushroomBox.isSelected())
                order += "  Mushrooms\n";
            if (oliveBox.isSelected())
                order += "  Olives\n";
            if (anchovyBox.isSelected())
                order += "  Anchovies\n";
                
            int bs = 0;
            int bw = 0;
            
            try{
                if (!breadSticksText.getText().isEmpty())
                    bs = Integer.parseInt(breadSticksText.getText());
                if (!breadSticksText.getText().isEmpty())
                    bw = Integer.parseInt(breadSticksText.getText());
            }
            
            catch(NumberFormatException nfe){
                JOptionPane.showMessageDialog(frame,
                "Side order entries must be numeric,\n" +
                "and must be whole numbers",
                "Side Order Error",
                JOptionPane.ERROR_MESSAGE);
            }
            
            if (bs > 0 || bw > 0){
                order += "Sides:\n";
                if (bs>0)
                    order+="    " + bs + " Bread Sticks\n";
                if (bw>0)
                    order+="    " + bw + " Buffalo Wings\n";
            }
            
            if (nameText.getText().isEmpty() ||
                addressText.getText().isEmpty()||
                cityText.getText().isEmpty())
                JOptionPane.showMessageDialog(frame,
                "Address fields may not be empty.",
                "Address Error",
                JOptionPane.ERROR_MESSAGE);
            else{
                order += "Deliver To:\n";
                order +="   " + nameText.getText() + "\n";
                order +="   " + addressText.getText() + "\n";
                order +="   " + cityText.getText() + "\n";
            }
        
            order += "\n***END OF ORDER***\n";
            
            try{
            
                PrintStream oFile = new PrintStream("PizzaOrder.txt");
                oFile.print(order);
                oFile.close();
            }   
            catch(IOException ioe){
            
                System.out.println("\n*** I/O Error ***\n" + ioe);
            }
        }   
       
    }
    
    public class exitListener implements ActionListener {
        
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }
    
    public class aboutListener implements ActionListener {
        
        public void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(frame,"GUI Pizza\n\nVersion 1.0\nBuild B20080226-1746\n\n" +
                        "(c) Copyright Merrill Hall 2008\nAll rights reserved\n\n" +
                        "Visit /\nEducation To Go\n" +
                        "Intermediate Java Course", "About GUI Pizza",JOptionPane.INFORMATION_MESSAGE);
                    }
    }
}