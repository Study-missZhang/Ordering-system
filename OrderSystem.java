/*
	编写一个点菜系统。
		程序需求：
			1、首先主函数运行显示一个主界面：
							*****主菜单*****
							菜单			1
							已点菜单		2
							结账			3
			2、点击1进入菜单页面：
							****请您点菜****
							1		鱼香肉丝 38.0
							2		糖醋里脊 28.0
							3		宫保鸡丁 31.5
							4		清蒸鲈鱼 42.0
							5		烩三鲜	 23.5
			3、输入1/2/3...显示已点菜单：
							您已点：****
			4、按0返回上一个页面
			5、点击2显示已点菜单
							*****您已点*****
							烩三鲜   23.5
							宫保鸡丁 31.5
			6、点击3结账
							****正在结账，请稍后****
							共消费了：55.0元
*/
import java.awt.List;
import java.util.Scanner;
/*
	点菜的主程序
*/
class OrderSystem 
{
	//提前准备一些菜品，展示给用户，同时用户可以点菜

	//定义一个集合，用来存储菜品   
	//<Dish>：泛型。指这个集合只能存该类型的数。
	static java.util.List<Dish> dishList = new java.util.ArrayList<>();

	//用来存储用户已经点了菜
	static java.util.List<Dish> personList = new java.util.ArrayList<>();

	public static void main(String[] args) 
	{
		//先初始化菜品
		iniDish();
		
		//获取控制台输入内容。
		Scanner sc = new Scanner(System.in);
		//获取内容，有阻塞效果
		//int num = sc.nextInt();
		//System.out.println("请输入编号:");
		
		//while循环为了让主菜单多次展示
		while(true){
			//给用户展示主菜单
			showMenu();
			//获取用户输入的内容
			int num = sc.nextInt();
			//判断输入的值
			switch(num){
				case 1:
					while(true){  //菜单点清楚再返回主菜单
						//菜单展示给用户
						showDishMenu();
						//获取用户输入内容
						int id = sc.nextInt();
						//判断id是不是0
						if(id == 0){
							break;//返回主菜单
						}
						Dish dish = dishList.get(id-1);
						System.out.println("*******您点了：*********");
						System.out.println(dish.name +"\t"+ dish.price);
						personList.add(dish);
					}
					break;
				case 2:
					//展示已点菜单
					showPersonDish();
					break;
				case 3:
					//结账
					buy();
					return; //结账就结束了，不显示主菜单。
			}
		}

	}

	//主菜单方法
	public static void showMenu(){
		System.out.println("******主菜单******");
		System.out.println("菜单\t\t1");
		System.out.println("已点菜单\t2");
		System.out.println("结账\t\t3");
		System.out.println("*****根据编号选择服务*******");
	}

	//展示菜单
	public static void showDishMenu(){
		System.out.println("******请您点菜******");
		//菜单在dishList集合中。所以只需要遍历集合
		for(int i = 0; i < dishList.size(); i++){
			//从集合中使用i获取菜品对象
			Dish dish = dishList.get(i);
			System.out.println(dish.id + "\t" + dish.name + "\t" + dish.price);
		}
		System.out.println("******输入序号进行点菜，按0返回上一级******");
	}

	//展示已点菜单
	public static void showPersonDish(){
		System.out.println("******您已点的菜******");
		//遍历personList集合
		for(int i = 0; i < personList.size(); i++){
			//从集合中使用i获取菜品对象
			Dish dish = personList.get(i);
			System.out.println(dish.id + "\t" + dish.name + "\t" + dish.price);
		}
		System.out.println("******输入序号进行点菜，按0返回上一级******");
	}

	//结账
	public static void buy(){
		System.out.println("******请稍等，正在结账******");
		//总金额
		double total = 0f;
		//遍历personList集合，将价格相加
		for(int i = 0; i < personList.size(); i++){
			//从集合中使用i获取菜品对象
			Dish dish = personList.get(i);
			total += dish.price;
		}
		System.out.println("您本次共消费：" + total + "元");
	}

	/*
		一个初始化菜品的方法,并将菜品存入dishList中
	*/
	public static void iniDish(){
		Dish dish1 = new Dish(1,"鱼香肉丝",27);
		dishList.add(dish1);
		Dish dish2 = new Dish(2,"宫保鸡丁",29.5);
		dishList.add(dish2);
		Dish dish3 = new Dish(3,"清蒸鲈鱼",42);
		dishList.add(dish3);
		Dish dish4 = new Dish(4,"大盘鸡",34);
		dishList.add(dish4);
		Dish dish5 = new Dish(5,"烩三鲜",24);
		dishList.add(dish5);
	}
}

/*
	封装一个类：菜品类。用来显示菜单页面。里面有三个属性：1、id；2、菜名；3、价格

	给Dish提供一个有参的构造方法，这样就可以直接给id、name、price赋值。
*/