package service;

import domain.House;
import utils.Utility;

import java.util.Scanner;

/**
 * 业务层
 * 响应HouseRentalAPP的调用，保存house数组，完成对房屋信息的crud
 */

public class HouseService {
    private House houses[];//存放House对象
    private int houseCount = 1;

    public HouseService(int size) {
        this.houses = new House[size];//制定数组大小

        //进行初始化
        houses[0] = new House();
    }

    public int getHouseCount() {
        return houseCount;
    }

    public House[] list(){
        return houses;
    }

    public House add() {
        if (houseCount >= houses.length) {
            System.out.println("列表已满，无法新增房屋！");
            return null;
        }

        House house = new House();
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入房主姓名：");
        house.setName(sc.next());
        System.out.println("请输入房主电话：");
        house.setTel(sc.next());
        System.out.println("请输入房屋地址：");
        house.setAddr(sc.next());
        System.out.println("请输入房屋租金：");
        house.setRental(sc.nextDouble());
        System.out.println("请输入房子状态：");
        house.setState(sc.next());

        houses[houseCount] = house;
        house.setId(houseCount); // 假设ID是从0开始的索引
        houseCount++;

        return house;
    }

    public void delete(int i){
        for(int a = i; a < houseCount; a ++){
            houses[a] = houses[a + 1];
            if(houses[a] != null) houses[a].setId(houses[a].getId() - 1);
        }
        houses[houseCount - 1] = null;
        houseCount --;
    }

    public House search(int i){
        return houses[i];
    }

    public void change(int i){
        System.out.println("修改房主姓名：（不需要修改请直接回车）");
        String name = Utility.readString(100,"不需要");
        if(name == "不需要");
        else houses[i].setName(name);

        System.out.println("修改房主电话：（不需要修改请直接回车）");
        String tel = Utility.readString(11,"不需要");
        if(tel == "不需要");
        else houses[i].setTel(tel);

        System.out.println("修改房屋地址：（不需要修改请直接回车）");
        String addr = Utility.readString(100,"不需要");
        if(addr == "不需要");
        else houses[i].setAddr(addr);

        System.out.println("修改房屋租金：（不需要修改请直接输入0）");
        double rent = new Scanner(System.in).nextDouble();
        if(rent == 0);
        else houses[i].setRental(rent);

        System.out.println("修改房屋状态：（不需要修改请直接回车）");
        String state = Utility.readString(5,"不需要");
        if(state == "不需要");
        else houses[i].setState(state);
    }
}
