package domain;

public class House {

    private int id = 0;//房屋编号
    private String name = "Zemba";//房主姓名
    private String tel = "17696693148";//
    private String addr = "广西壮族自治区防城港市东兴市江平镇平安东路95号";
    private double rental = 1500.0;//租金
    private String state = "未出租";//{"已出租", "未出租"};

    public House() {
        int id = 0;//房屋编号
        String name = "Zemba";//房主姓名
        int tel[] = {1,7,6,9,6,6,9,3,1,4,8};//
        String addr = "广西壮族自治区防城港市东兴市江平镇平安东路95号";
        double rental = 1500.0;//租金
        String state = "未出租";//{"已出租", "未出租"};

    }



    @Override
    public String toString() {
        return getId() + "\t\t" + getName() + "\t\t" + getTel() + "\t\t"
                 + getAddr() + "\t\t" + getRental() + "\t\t" + getState();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getRental() {
        return rental;
    }

    public void setRental(double rental) {
        this.rental = rental;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
