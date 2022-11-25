public class RedDrug extends Drug {
    private int AddLife;

    RedDrug() {}

    RedDrug(int AddLife) {
        this.AddLife = AddLife;
    }

    public void setAddLife(int AddLife) {
        this.AddLife = AddLife;
    }

    public int getAddLife() {
        String size = this.getSize();

        switch(size){
            case "Large":
                AddLife = 120;
                break;
            case "Medium":
                AddLife = 80; 
                break;
            case "Samll":
                AddLife = 50;
                break;
            default:
                AddLife = 0;
                System.out.print("回血失敗\n");
                break;
        }
        if(AddLife != 0) {
            System.out.print("回了" + AddLife + "滴血\n");
        }
        return AddLife;
    }
}