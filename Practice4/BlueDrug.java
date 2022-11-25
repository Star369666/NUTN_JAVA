public class BlueDrug extends Drug {
    private int AddMagic;

    BlueDrug() {}

    BlueDrug(int add) {
        this.AddMagic = add;
    }

    public void setAddLMagic(int AddMagic) {
        this.AddMagic = AddMagic;
    }

    public int getAddMagic() {
        String size = this.getSize();

        switch(size) {
            case "Large":
                AddMagic = 100;
                break;
            case "Medium":
                AddMagic = 60;
                break;
            case "Samll":
                AddMagic = 30;
                break;
            default:
                AddMagic = 0;
                System.out.print("回魔失敗\n");
                break;
        }
        if(AddMagic != 0) {
            System.out.print("回了" + AddMagic + "滴魔\n");
        }
        return AddMagic;
    }
}