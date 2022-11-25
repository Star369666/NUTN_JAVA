public class Wizard extends Role {
    public Wizard() {}

    public Wizard(String name, int life, int magic) {
        super(name, life, magic);
    }

    public void SmallFire(Role player) {
        final int magic_cost = 25;
        final int attack_warrior = 40;
        final int attack_wizard = 60;

        if(this.getMagic() < magic_cost) {
            System.out.print("魔力不足，攻擊無效!\n");
        }
        else {
            setMagic(getMagic() - magic_cost);

            if(player instanceof Warrior) {
                player.setLife(player.getLift() - attack_warrior);
                System.out.print(player.getName()+"被"+getName()+"打了" + attack_warrior + "滴血\n");
                if(player.getLift() <= 0) {
                    System.out.print(player.getName()+"被"+getName()+"打死了\n");
                    System.exit(0);
                }
            }
            else {
                player.setLife(player.getLift() - attack_wizard);
                System.out.print(player.getName()+"被"+getName()+"打了" + attack_wizard + "滴血\n");
                if(player.getLift() <= 0) {
                    System.out.print(player.getName()+"被"+getName()+"打死了\n");
                    System.exit(0);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Name: " + getName() + "  Life: " + getLift() + "  Magic: " + getMagic() + "\n";
    }
}