import javax.swing.*;
import java.awt.*;

public class BMI_Calculator {
    public static double bmiCalc;
    public static double weight;
    public static double height;
    public static JFrame frame = new JFrame("BMI Calculator");
    public static JPanel panel = new JPanel(null);
    public static JButton start = new JButton("Calculate BMI");

    public static void main(String[] args) {
        GUI();
    }

    public static void GUI() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(400, 200);
        frame.setContentPane(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        panel.setSize(400, 200);
        panel.setLayout(new GridBagLayout());
        panel.add(start);

        start.addActionListener(e -> startCalculation());
    }

    public static void startCalculation() {
        try {
            weight = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter weight:"));

            if (weight < 0) {
                throw new Exception("Invalid weight.");
            }

            height = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter height in inches:"));

            if (height < 0) {
                throw new Exception("Invalid height.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cannot compute BMI please use numbers only!");
            return;
        }

        bmiCalc = (weight / (height * height)) * 703.0f;

        JOptionPane.showMessageDialog(null, "Your BMI is: " + String.format("%.1f", bmiCalc) +
                "\nBelow 18.5 BMI -> Underweight" +
                "\n18.5 - 24.9 BMI -> Normal" +
                "\n25.0 - 29.9 BMI -> Overweight" +
                "\n30.0 BMI and Above -> Obesity");
    }
}