import java.security.*;

public class Game {
    private static final SecureRandom s = new SecureRandom();
    public static void main(String[] args) throws Exception {
        Role[] player = new Role[6];
        int i, choose, choose2;

        for(i = 0; i < 3; i++) {
            player[i] = new Warrior("戰士" + (i+1), 400, 100);
            player[i+3] = new Wizard("法師" + (i+1), 280, 200);
        }

        for(i = 0; i < 6; i++) {
            System.out.print(player[i]);
        }

        while(true) {
            choose = s.nextInt(6);
            do {
                choose2 = s.nextInt(6);
            } while(choose == choose2);

            if(player[choose] instanceof Warrior) {
                ((Warrior)player[choose]).NewMoon(player[choose2]);
            }
            else {
                ((Wizard)player[choose]).SmallFire(player[choose2]);
            }

            if(player[choose2].getLift() < 40) {
                System.out.print(player[choose2].getName());
                player[choose2].Drink(new RedDrug());
            }
            if(player[choose].getMagic() < 30) {
                System.out.print(player[choose2].getName());
                player[choose].Drink(new BlueDrug());
            }
        }
    }
}