public class Role {
    private String Name;
    private int Life;
    private int Magic;

    Role() {}

    Role(String name, int life, int magic) {
        this.Name = name;
        this.Life = life;
        this.Magic = magic;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setLife(int life) {
        this.Life = life;
    }

    public void setMagic(int magic) {
        this.Magic = magic;
    }

    public String getName() {
        return this.Name;
    }

    public int getLift() {
        return this.Life;
    }

    public int getMagic() {
        return this.Magic;
    }

    public void is_dead(Role player) {
        if(this.getLift() < 0) {
            System.out.print(player.getName()+"被"+getName()+"打死了\n");
                System.exit(0);
        }
    }

    public void object_attacked(Role player, int damage) {
        player.setLife(player.getLift() - damage);
        System.out.print(player.getName()+"被"+getName()+"打了" + damage + "滴血\n");
    }

    public void Drink(Drug potion) {
        if(potion instanceof RedDrug) {
            setLife(getLift() + ((RedDrug)potion).getAddLife());
        }
        else {
            setMagic(getMagic() + ((BlueDrug)potion).getAddMagic());
        }
    }
}