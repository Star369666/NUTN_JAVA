import java.awt.*;
import java.awt.event.*;

public class HW_AWT_1 {
    static Frame fra = new Frame("DSG Calculator");
    static Panel pan = new Panel(new GridLayout(3,3));
    static Panel pan_calculator = new Panel(new GridLayout(4,1));
    static Panel pan_equal_clear = new Panel(new GridLayout(2,1,0,7));
    static Label lab = new Label("0 ", Label.RIGHT);
    static Label title_shower = new Label("DSG Calculator");
    static Button zero = new Button("0");
    static Button dot = new Button(".");
    public static void main(String[] args) {
        fra.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        });
        int i;
        String[] cal = {"+", "-", "x", "/"};
        String letter = "Serif";
        Button but = new Button();
        fra.setLayout(null);
        fra.setBackground(new Color(238,238,238));
        fra.setBounds(280,150,455,305);
        fra.setResizable(false);

        lab.setBounds(40,40,266,55);
        lab.setFont(new Font(letter, Font.BOLD, 28));
        lab.setBackground(new Color(255,175,176));
        
        title_shower.setBounds(325, 55, 120, 20);
        title_shower.setFont(new Font(letter, Font.BOLD+Font.ITALIC, 14));

        pan.setBounds(40,105,191,130);
        for(i = 0; i < 9; i++) {
            but = new Button(Integer.toString(i+1));
            but.setFont(new Font(letter, Font.BOLD, 15));
            but.setBackground(new Color(223,233,244));
            pan.add(but);
        }

        pan_calculator.setBounds(251,105,56,175);
        for(i = 0; i < 4; i++) {
            but = new Button(cal[i]);
            but.setFont(new Font(letter, Font.BOLD, 20));
            but.setBackground(new Color(223,233,244));
            pan_calculator.add(but);
        }
        pan_calculator.setBackground(new Color(223,233,244));

        pan_equal_clear.setBounds(326,105, 100,173);
        but = new Button("=");
        but.setFont(new Font(letter, Font.BOLD, 32));
        but.setForeground(Color.RED);
        but.setBackground(new Color(223,233,244));
        pan_equal_clear.add(but);
        but = new Button("Clear");
        but.setFont(new Font(letter, Font.BOLD, 24));
        but.setForeground(Color.RED);
        but.setBackground(new Color(223,233,244));
        pan_equal_clear.add(but);

        zero.setBounds(40,232,127,45);
        zero.setFont(new Font(letter, Font.BOLD, 15));
        zero.setBackground(new Color(223,233,244));

        dot.setBounds(166,232,65,45);
        dot.setFont(new Font(letter, Font.BOLD, 15));
        dot.setBackground(new Color(223,233,244));

        fra.add(lab);
        fra.add(title_shower);
        fra.add(pan);
        fra.add(pan_calculator);
        fra.add(zero);
        fra.add(dot);
        fra.add(pan_equal_clear);
        fra.setVisible(true);
    }
}