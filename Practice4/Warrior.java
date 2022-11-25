public class Warrior extends Role implements LifeRecoverable {
    public Warrior() {}

    public Warrior(String name, int life, int magic) {
        super(name, life, magic);
    }

    public void NewMoon(Role player) {
        final int magic_cost = 10;
        final int attack_warrior = 25;
        final int attack_wizard = 40;

        if(getMagic() < magic_cost) {
            System.out.print("魔力不足，攻擊無效!\n");
        }
        else {
            setMagic(getMagic() - magic_cost);

            if(player instanceof Warrior) {
                object_attacked(player, attack_warrior);
                super.is_dead(player);
            }
            else {
                object_attacked(player, attack_wizard);
                super.is_dead(player);
            }
        }
    }

    @Override
    public String toString() {
        return "Name: " + getName() + "  Life: " + getLift() + "  Magic: " + getMagic() + "\n";
    }

    @Override
    public double recoverLife() {
        return LIFERATE * 0.2;
    }
}