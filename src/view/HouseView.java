package view;

import domain.House;
import service.HouseService;
import utils.Utility;

public class HouseView {

    private boolean loop = true;
    private HouseService hs = new HouseService(10);

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    public void mainMenu(){//显示主菜单
        char input = 'a';

        do {
            System.out.println("--------------------------房屋出租系统--------------------------");
            System.out.println("--------------------------1.新增房屋---------------------------");
            System.out.println("--------------------------2.查找房屋---------------------------");
            System.out.println("--------------------------3.删除房屋---------------------------");
            System.out.println("-------------------------4.修改房屋信息-------------------------");
            System.out.println("--------------------------5.房屋列表---------------------------");
            System.out.println("----------------------------6.退出----------------------------");
            System.out.println("\n请输入你的选择：");

            input = Utility.readChar();
            switch(input){
                case '1':{
                    System.out.println("----------------------------添加房屋----------------------------");
                    House house = addHouse(hs.add());
                    if(house == null) System.out.println("添加失败！");
                    break;
                }
                case '2':{
                    searchHouse();
                    break;
                }
                case '3':{
                    delHouse();
                    break;
                }
                case '4':{
                    changeInfo();
                    break;
                }
                case '5':{
                    this.listHouse();
                    break;
                }
                case '6':{
                    this.setLoop(false);
                    break;
                }
                default:{
                    System.out.println("您的输入有误！请重新输入！");
                    Utility.Sleep();
                    break;
                }
            }

        }while(isLoop());


    }

    public void listHouse(){
        System.out.println("----------------------------房屋列表----------------------------");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态");

        House[] houses = hs.list();
        for(int i = 0; i < houses.length && houses[i] != null; i ++){
            System.out.println(houses[i].toString());
        }

        System.out.println("-------------------------房屋列表显示完毕-------------------------");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // 如果线程在睡眠期间被中断，将抛出InterruptedException
            e.printStackTrace();
        }
    }

    public House addHouse(House house){
        Utility.Sleep();
        System.out.println("----------------------------添加成功----------------------------");
        return house;
    }

    public void delHouse(){
        System.out.println("----------------------------删除房屋----------------------------");
        System.out.println("请输入需要删除的房屋编号：");
        int a = Utility.readInt();
        while(a >= hs.getHouseCount()){
            System.out.println("此编号无效！请重新输入编号！");
            Utility.Sleep();
            System.out.println("请输入需要删除的房屋编号：");
            a = Utility.readInt();
        }
        hs.delete(a);
        System.out.println("----------------------------删除成功----------------------------");
        Utility.Sleep();
    }

    public void searchHouse(){
        System.out.println("----------------------------查找房屋----------------------------");
        System.out.println("请输入需要查找的房屋编号：");
        int a = Utility.readInt();
        while(a >= hs.getHouseCount()){
            System.out.println("此编号无效！请重新输入编号！");
            Utility.Sleep();
            System.out.println("请输入需要查找的房屋编号：");
            a = Utility.readInt();
        }
        System.out.println("----------------------------查找成功----------------------------");
        System.out.println(hs.search(a).toString());
        Utility.Sleep();
    }

    public void changeInfo(){
        System.out.println("--------------------------修改房屋信息---------------------------");
        System.out.println("请输入需要修改的房屋编号：");
        int a = Utility.readInt();
        while(a >= hs.getHouseCount()){
            System.out.println("此编号无效！请重新输入编号！");
            Utility.Sleep();
            System.out.println("请输入需要修改的房屋编号：");
            a = Utility.readInt();
        }
        hs.change(a);
        System.out.println("---------------------------修改成功-----------------------------");
        Utility.Sleep();
    }
}
