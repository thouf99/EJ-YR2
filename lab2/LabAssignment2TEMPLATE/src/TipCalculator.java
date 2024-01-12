import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TipCalculator extends JFrame implements ActionListener {
    double billPrice;
    double tip;
    long people;

    JLabel outcome;
    JTextField cost_num;
    JTextField tip_val;
    JTextField people_val;

    TipCalculator(){
        this.setSize(200,190);
        this.setTitle("Meal Splitter");
        this.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel bPrice = new JLabel("Price ");
        this.add(bPrice);

        //add in a JTextField
        cost_num = new JTextField(5);
        cost_num.setActionCommand("costField");
        cost_num.addActionListener(this);
        this.add(cost_num);

        JLabel tip = new JLabel("Tip (%) ");
        this.add(tip);

        tip_val = new JTextField(5);
        tip_val.setActionCommand("tipField");
        tip_val.addActionListener(this);
        this.add(tip_val);

        JLabel people = new JLabel("People: ");
        this.add(people);

        people_val = new JTextField(5);
        people_val.setActionCommand("peopleField");
        people_val.addActionListener(this);
        this.add(people_val);

        JButton convert = new JButton("Calculate");
        this.add(convert);
        convert.addActionListener(this);
        outcome = new JLabel("Each person should pay £???");
        this.add(outcome);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TipCalculator();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //add action listener
        double c = 0.0;
        double t = 0.0;
        long p = 0;

        try{
            c = Double.parseDouble(cost_num.getText());
            t = Double.parseDouble(tip_val.getText());
            p = Long.parseLong(people_val.getText());

        }catch(NumberFormatException numExcep){
            JOptionPane.showMessageDialog(null, "You must enter a valid number");
            cost_num.setText("");
            tip_val.setText("");
            people_val.setText("");
        }
        System.out.println(e.getActionCommand());
        if(e.getActionCommand().equals("Calculate") || e.getActionCommand().equals("costField")
            || e.getActionCommand().equals("tipField") || e.getActionCommand().equals("peopleField")){
            double a = ((((c/100)*t) + c)/p);
            double round =  Math.ceil(a * 100) / 100;
//            double round = (double) Math.round(a*100)/100;
            outcome.setText("Each person pays £" + round);
        }

    }
}
