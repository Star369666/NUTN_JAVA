import java.awt.*;
import java.awt.event.*;

public class AWT_HW_3 extends Frame implements ActionListener, MouseMotionListener, MouseListener {
    static AWT_HW_3 fra = new AWT_HW_3();
    static MenuBar menuBar = new MenuBar();
    static Menu draw = new Menu("繪圖");
    static Menu other = new Menu("其他操作");
    static MenuItem straight = new MenuItem("直線");
    static MenuItem ovel = new MenuItem("橢圓填滿");
    static MenuItem rectangle = new MenuItem("矩形填滿");
    static MenuItem exit = new MenuItem("離開");
    static MenuItem pick = new MenuItem("選取");
    static BasicStroke border = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
    static Graphics g;
    int x1, y1, x2, y2, dx, dy, final_dx, final_dy;
    boolean flag = false;
    String type = "";
    public static void main(String[] args) {
        fra.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        });
        fra.setLayout(null);
        fra.setTitle("繪圖小程式");
        fra.setBounds(50, 50, 600, 500);

        /* Listener setting */
        straight.addActionListener(fra);
        rectangle.addActionListener(fra);
        ovel.addActionListener(fra);
        exit.addActionListener(fra);
        pick.addActionListener(fra);
        fra.addMouseListener(fra);
        fra.addMouseMotionListener(fra);

        /* Menu setting */
        menuBar.add(draw);
        menuBar.add(other);
        draw.add(straight);
        draw.add(ovel);
        draw.add(rectangle);
        other.add(pick);
        other.add(exit);

        fra.setMenuBar(menuBar);
        fra.setVisible(true);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        x1 = e.getX();
        y1 = e.getY();
        if(flag) {
            g = getGraphics();
            update(g);
        }
        else {
            dx = e.getX() - x1;
            dy = e.getY() - y1;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        x2 = e.getX();
        y2 = e.getY();

        if(type.equals("straight")) {
            g.setColor(Color.BLACK);
            g.drawLine(x1, y1, x2, y2);
        }
        else if(type.equals("rectangle")) {
            g.setColor(Color.RED);
            g.drawRect(x1, y1, x2-x1, y2-y1);
            
        }
        else if(type.equals("ovel")) {
            g.setColor(Color.YELLOW);
        }

        final_dx = x2 - x1;
        final_dy = y2 - y1;
    }

    public void mouseDragged(MouseEvent e) {
        x2 = e.getX();
        y2 = e.getY();

        if(flag) {
            g = getGraphics();
            update(g);

            if(type.equals("straight")) {
                g.setColor(Color.BLACK);
                g.drawLine(x1, y1, x2, y2);
            }
            else if(type.equals("rectangle")) {
                g.setColor(Color.RED);
                g.fillRect(x1, y1, x2-x1, y2-y1);
            }
            else if(type.equals("ovel")) {
                g.setColor(Color.YELLOW);
                g.fillOval(x1, y1, x2-x1, y2-y1);
            }
        }
        else {
            x2 -= dx;
            y2 -= dy;
            Graphics g = getGraphics();
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(border);
            update(g);

            if(type.equals("straight")) {
                g.setColor(Color.BLACK);
                g.drawLine(x1, y1, x2+final_dx, y2+final_dy);
            }
            else if(type.equals("rectangle")) {
                g.setColor(Color.RED);
                g.fillRect(x1, y1, final_dx, final_dy);
                g2.drawRect(x1, y1, final_dx, final_dy);
            }
            else if(type.equals("ovel")) {
                g.setColor(Color.YELLOW);
                g.fillOval(x1, y1, final_dx, final_dy);
                g2.drawOval(x1, y1, final_dx, final_dy);
            }

            x1 = x2;
            y1 = y2;
        }
    }
    
    public void mouseEntered(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    public void mouseMoved(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    @Override
    public void actionPerformed(ActionEvent e) {
        MenuItem item = (MenuItem) e.getSource();

        if(item == straight || item == rectangle || item == ovel) {
            flag = true;
            if(item == straight) {
                type = "straight";
            }
            else if(item == rectangle) {
                type = "rectangle";
            }
            else if(item == ovel) {
                type = "ovel";
            }
        }
        else if(item == pick) {
            flag = false;
        }
        else {
            System.exit(0);
        }
    }
}