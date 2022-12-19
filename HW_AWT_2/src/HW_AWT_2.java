import java.awt.*;
import java.awt.event.*;

public class HW_AWT_2 extends Frame implements ActionListener, TextListener, ItemListener {
    static class WinLis extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }
    static input user = new input();
    static HW_AWT_2 fra = new HW_AWT_2();
    static Button compute = new Button("Compute BMI");
    static Button exit = new Button("Exit");
    static Label lab_name = new Label("名字");
    static Label lab_weight = new Label("體重");
    static Label lab_height = new Label("身高");
    static Label kilogram = new Label("(公斤)");
    static Label centmeter = new Label("(公分)");
    static Label gender = new Label("性別");
    static Label lab_age = new Label("年齡");
    static Label result = new Label();
    static Label info = new Label();
    static TextField name = new TextField();
    static TextField weight = new TextField();
    static TextField height = new TextField();
    static Checkbox male = new Checkbox("男生");
    static Checkbox female = new Checkbox("女生");
    static Choice age = new Choice(); 
    public static void main(String[] args) {
        CheckboxGroup grp = new CheckboxGroup();
        String letter = "Serif";
        Font f1 = new Font(letter, Font.BOLD, 15);
        Font f2 = new Font(letter, Font.BOLD, 20);
        Font f3 = new Font(letter, Font.BOLD, 18);
        Font f4 = new Font(letter, Font.PLAIN , 15);

        /* Frame settings */
        fra.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        });
        fra.setLayout(null);
        fra.setTitle("BMI");
        fra.setBackground(new Color(238,238,238));
        fra.setBounds(280,150,492,468);
        fra.setResizable(false);

        /* Label setting listers */
        compute.addActionListener(fra);
        exit.addActionListener(fra);
        name.addTextListener(fra);
        weight.addTextListener(fra);
        height.addTextListener(fra);
        male.addItemListener(fra);
        female.addItemListener(fra);
        age.addItemListener(fra);

        /* Label setting bounds */
        final int text_size1 = 50;
        final int text_size2 = 40;
        final int text_x = 45;
        final int text_bonus = 45;
        final int left_bonus = 250;
        lab_name.setBounds(text_x, 53, text_size1, text_size2);
        lab_weight.setBounds(text_x, lab_name.getY()+text_bonus, text_size1, text_size2);
        lab_height.setBounds(text_x, lab_weight.getY()+text_bonus, text_size1, text_size2);
        gender.setBounds(text_x, lab_height.getY()+text_bonus, text_size1, text_size2);
        lab_age.setBounds(text_x, gender.getY()+text_bonus, text_size1, text_size2);
        kilogram.setBounds(text_x+left_bonus, lab_weight.getY(), text_size1, text_size2);
        centmeter.setBounds(text_x+left_bonus, lab_height.getY(), text_size1, text_size2);

        /* Label setting fonts */
        lab_name.setFont(f1);
        lab_weight.setFont(f1);
        lab_height.setFont(f1);
        gender.setFont(f1);
        lab_age.setFont(f1);
        kilogram.setFont(f4);
        centmeter.setFont(f4);

        /* Compute setting */
        compute.setBackground(new Color(223,233,244));
        compute.setBounds(text_x, 400, 200, 40);
        compute.setFont(f2);

        /* Exit setting */
        exit.setBackground(new Color(223,233,244));
        exit.setBounds(text_x+250, 400,120, 40);
        exit.setFont(f3);

        /* TextField setting bounds */
        final int field_width = 180;
        final int field_height = 19;
        final int field_x_bonus = 50;
        final int field_y_bonus = 12;
        name.setBounds(text_x+field_x_bonus, lab_name.getY()+field_y_bonus, field_width, field_height);
        weight.setBounds(text_x+field_x_bonus, lab_weight.getY()+field_y_bonus, field_width, field_height);
        height.setBounds(text_x+field_x_bonus, lab_height.getY()+field_y_bonus, field_width, field_height);

        /* Checkbox setting */
        male.setCheckboxGroup(grp);
        female.setCheckboxGroup(grp);

        final int check_bonus = 10;
        male.setBounds(name.getX()+10, gender.getY()+check_bonus, 50, 20);
        male.setFont(new Font(letter, Font.PLAIN , 17));
        female.setBounds(male.getX()+76, gender.getY()+check_bonus, 50, 20);
        female.setFont(new Font(letter, Font.PLAIN , 17));

        /* Choice setting */
        for(int i = 1; i < 101; i++) {
            age.add(Integer.toString(i));
        }
        age.setBounds(name.getX(), lab_age.getY()+9, 60, 30);

        /* Result setting */
        result.setBounds(fra.getWidth()/2-200, lab_age.getY()+52, 400, 50);
        result.setFont(new Font(letter, Font.BOLD+Font.ITALIC, 32));
        result.setForeground(Color.BLUE);
        result.setAlignment(Label.CENTER);

        /* Infomation setting */
        info.setBounds(result.getX(), result.getY()+63, 400, 30);
        info.setFont(new Font(letter, 0, 22));
        info.setAlignment(Label.CENTER);

        fra.setVisible(true);
        fra.add(lab_name);
        fra.add(lab_weight);
        fra.add(lab_height);
        fra.add(gender);
        fra.add(kilogram);
        fra.add(centmeter);
        fra.add(lab_age);
        fra.add(name);
        fra.add(weight);
        fra.add(height);
        fra.add(male);
        fra.add(female);
        fra.add(compute);
        fra.add(exit);
        fra.add(age);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Button but = (Button)e.getSource();
        if(male.getState() == true) {
            user.setGender(0);
        } 
        else if(female.getState() == true) {
            user.setGender(1);
        }

        if(but == compute) {
            double BMI = user.getWeight()/(Math.pow(user.getHeight()/100, 2));

            
            if(user.getGender()==0) {
                info.setText(user.getName() + "(" + user.getAge() + "歲, 男生):");
            }
            else if(user.getGender()==1){
                info.setText(user.getName() + "(" + user.getAge() + "歲, 女生):");
            }

            if(BMI < 18.5) {
                result.setText("Under weight");
                info.setText(info.getText()+"Eat more!");
            }
            else if(18.5 <= BMI && BMI <= 23.9) {
                result.setText("Normal weight");
                info.setText(info.getText()+"Great!");
            }
            else if(24 <= BMI && BMI < 26.9) {
                result.setText("Over weight");
                info.setText(info.getText()+"Remember to do excrcises!");
            }
            else {
                result.setText("Obesity");
                info.setText(info.getText()+"Go on diet, now!");
            }
            fra.add(info);
            fra.add(result);
        }
        else {
            System.exit(0);
        }
    }

    @Override
    public void textValueChanged(TextEvent e) {
        TextField tex = (TextField)e.getSource();
        if(tex == name) {
            user.setName(tex.getText());
        }
        else if(tex == weight){
            user.setWeight(Double.valueOf(tex.getText()));
        }
        else if(tex == height) {
            user.setHeight(Double.valueOf(tex.getText()));
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        String in = age.getSelectedItem();
        if(male.getState()) {
            user.setGender(0);
        }
        else if(female.getState()) {
            user.setGender(1);
        }
        if(!(in.equals(null)) && !(in.equals("0"))) {
            user.setAge(Integer.valueOf(in));
        }
    }
}