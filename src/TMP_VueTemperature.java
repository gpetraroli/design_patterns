//import javax.swing.JFrame;
//import javax.swing.JButton;
//import javax.swing.JSlider;
//import javax.swing.JTextField;
//import javax.swing.event.ChangeEvent;
//
//import java.awt.Container;
//import java.awt.Dimension;
//import java.awt.GridBagConstraints;
//import java.awt.GridBagLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.Observable;
//import java.util.Observer;
//
//@SuppressWarnings("deprecation")
//public class TMP_VueTemperature extends JFrame implements Observer {
//  private static final long serialVersionUID = 1L;
//  private JButton plus; private JButton moins;
//  private JTextField valeur; private JSlider jauge;
//  private JButton newWin; // to create a new window
//  private Temperature temp;
//  private TemperatureControleur contr;
//
//  public TMP_VueTemperature(Temperature t, TemperatureControleur c) {
//    super("Vue Temperature MVC");
//    this.temp = t;
//    this.contr = c;
//    temp.addObserver(this);
//    this.setupGraphics();
//    setUpReactionPlus();
//    setUpReactionMoins();
//    setUpReactionValeur();
//    setUpReactionJauge();
//    setUpReactionNew(); // supplément: crée une nouvelle fenêtre, même vue
//    this.update(temp, null);
//    setVisible(true);
//  }
//
//  @Override
//  public void update(Observable o, Object arg) {
//    if (o instanceof Temperature) {
//      Temperature n = (Temperature) o;
//      this.valeur.setText(Integer.toString(n.getValeur()));
//      this.jauge.setValue(n.getValeur());
//      this.repaint();
//    }
//  }
//
//  void setUpReactionPlus() {
//    this.plus.addActionListener((ActionEvent e) -> contr.inc());
//  }
//
//  void setUpReactionMoins() {
//    this.moins.addActionListener((ActionEvent e) -> contr.dec());
//  }
//
//  void setUpReactionValeur2() {
//    this.valeur.addActionListener((ActionEvent e) -> contr.setByText(valeur.getText()));
//  }
//
//  void setUpReactionJauge() {
//    this.jauge.addChangeListener((ChangeEvent e) -> temp.setValeur(jauge.getValue()));
//  }
//
//  void setUpReactionValeur () {
//    this.valeur.addActionListener(new ActionListener() {
//      public void actionPerformed(ActionEvent e) {
//        if (!contr.setByText(valeur.getText())) {
//          valeur.setText(valeur.getText() + " valeur invalide!");
//          TMP_VueTemperature.this.repaint();
//        }
//      }
//    });
//  }
//
//  void setUpReactionNew() {
//    this.newWin.addActionListener(
//        // Il faudrait probablement lancer ça avec un invokeLater, peu importe ici
//        (ActionEvent e) -> contr.newWin());
//  }
//
//  void setupGraphics() {
//    this.plus = new JButton("+");
//    this.moins = new JButton("-");
//    this.newWin = new JButton("new");
//    this.valeur = new JTextField("");
//    this.jauge = new JSlider(-273, 1000);
//    Container c = this.getContentPane();
//    c.setLayout(new GridBagLayout());
//    GridBagConstraints cstr = new GridBagConstraints();
//    cstr.fill = GridBagConstraints.BOTH;
//    cstr.gridx = 0;
//    cstr.gridy = 0;
//    cstr.weightx = 0.5;
//    c.add(plus, cstr);
//    cstr.gridx = 1;
//    cstr.gridy = 0;
//    c.add(moins, cstr);

//    cstr.gridx = 2;
//    cstr.gridy = 0;
//    c.add(newWin, cstr);

//    cstr.gridx = 0;
//    cstr.gridy = 1;
//    cstr.gridwidth = 2;
//    cstr.weightx = 0.0;
//    cstr.weighty = 0.0;
//    c.add(valeur, cstr);


//    cstr.gridx = 0;
//    cstr.gridy = 2;
//    c.add(jauge, cstr);
//    //panel.setBorder(BorderFactory.createTitledBorder("demo"));
//    this.setMaximumSize(new Dimension(30, 50));
//    this.valeur.setFont(valeur.getFont().deriveFont((float) 20.0));
//    plus.setFont(plus.getFont().deriveFont((float) 20.0));
//    moins.setFont(moins.getFont().deriveFont((float) 20.0));
//    jauge.setFont(jauge.getFont().deriveFont((float) 20.0));
//    pack();
//    // exit application when this window is closed
//    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//  }
//
//}
