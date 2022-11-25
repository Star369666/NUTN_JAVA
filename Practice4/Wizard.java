public class Wizard extends Role implements MagicRecoverable {
    public Wizard() {}

    public Wizard(String name, int life, int magic) {
        super(name, life, magic);
    }

    public void SmallFire(Role player) {
        final int magic_cost = 25;
        final int attack_warrior = 40;
        final int attack_wizard = 60;

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
    public double recoverMagic() {
        return MAGICRATE * 0.5;
    }
}