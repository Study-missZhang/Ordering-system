/*
	��дһ�����ϵͳ��
		��������
			1������������������ʾһ�������棺
							*****���˵�*****
							�˵�			1
							�ѵ�˵�		2
							����			3
			2�����1����˵�ҳ�棺
							****�������****
							1		������˿ 38.0
							2		�Ǵ��Ｙ 28.0
							3		�������� 31.5
							4		�������� 42.0
							5		������	 23.5
			3������1/2/3...��ʾ�ѵ�˵���
							���ѵ㣺****
			4����0������һ��ҳ��
			5�����2��ʾ�ѵ�˵�
							*****���ѵ�*****
							������   23.5
							�������� 31.5
			6�����3����
							****���ڽ��ˣ����Ժ�****
							�������ˣ�55.0Ԫ
*/
import java.awt.List;
import java.util.Scanner;
/*
	��˵�������
*/
class OrderSystem 
{
	//��ǰ׼��һЩ��Ʒ��չʾ���û���ͬʱ�û����Ե��

	//����һ�����ϣ������洢��Ʒ   
	//<Dish>�����͡�ָ�������ֻ�ܴ�����͵�����
	static java.util.List<Dish> dishList = new java.util.ArrayList<>();

	//�����洢�û��Ѿ����˲�
	static java.util.List<Dish> personList = new java.util.ArrayList<>();

	public static void main(String[] args) 
	{
		//�ȳ�ʼ����Ʒ
		iniDish();
		
		//��ȡ����̨�������ݡ�
		Scanner sc = new Scanner(System.in);
		//��ȡ���ݣ�������Ч��
		//int num = sc.nextInt();
		//System.out.println("��������:");
		
		//whileѭ��Ϊ�������˵����չʾ
		while(true){
			//���û�չʾ���˵�
			showMenu();
			//��ȡ�û����������
			int num = sc.nextInt();
			//�ж������ֵ
			switch(num){
				case 1:
					while(true){  //�˵�������ٷ������˵�
						//�˵�չʾ���û�
						showDishMenu();
						//��ȡ�û���������
						int id = sc.nextInt();
						//�ж�id�ǲ���0
						if(id == 0){
							break;//�������˵�
						}
						Dish dish = dishList.get(id-1);
						System.out.println("*******�����ˣ�*********");
						System.out.println(dish.name +"\t"+ dish.price);
						personList.add(dish);
					}
					break;
				case 2:
					//չʾ�ѵ�˵�
					showPersonDish();
					break;
				case 3:
					//����
					buy();
					return; //���˾ͽ����ˣ�����ʾ���˵���
			}
		}

	}

	//���˵�����
	public static void showMenu(){
		System.out.println("******���˵�******");
		System.out.println("�˵�\t\t1");
		System.out.println("�ѵ�˵�\t2");
		System.out.println("����\t\t3");
		System.out.println("*****���ݱ��ѡ�����*******");
	}

	//չʾ�˵�
	public static void showDishMenu(){
		System.out.println("******�������******");
		//�˵���dishList�����С�����ֻ��Ҫ��������
		for(int i = 0; i < dishList.size(); i++){
			//�Ӽ�����ʹ��i��ȡ��Ʒ����
			Dish dish = dishList.get(i);
			System.out.println(dish.id + "\t" + dish.name + "\t" + dish.price);
		}
		System.out.println("******������Ž��е�ˣ���0������һ��******");
	}

	//չʾ�ѵ�˵�
	public static void showPersonDish(){
		System.out.println("******���ѵ�Ĳ�******");
		//����personList����
		for(int i = 0; i < personList.size(); i++){
			//�Ӽ�����ʹ��i��ȡ��Ʒ����
			Dish dish = personList.get(i);
			System.out.println(dish.id + "\t" + dish.name + "\t" + dish.price);
		}
		System.out.println("******������Ž��е�ˣ���0������һ��******");
	}

	//����
	public static void buy(){
		System.out.println("******���Եȣ����ڽ���******");
		//�ܽ��
		double total = 0f;
		//����personList���ϣ����۸����
		for(int i = 0; i < personList.size(); i++){
			//�Ӽ�����ʹ��i��ȡ��Ʒ����
			Dish dish = personList.get(i);
			total += dish.price;
		}
		System.out.println("�����ι����ѣ�" + total + "Ԫ");
	}

	/*
		һ����ʼ����Ʒ�ķ���,������Ʒ����dishList��
	*/
	public static void iniDish(){
		Dish dish1 = new Dish(1,"������˿",27);
		dishList.add(dish1);
		Dish dish2 = new Dish(2,"��������",29.5);
		dishList.add(dish2);
		Dish dish3 = new Dish(3,"��������",42);
		dishList.add(dish3);
		Dish dish4 = new Dish(4,"���̼�",34);
		dishList.add(dish4);
		Dish dish5 = new Dish(5,"������",24);
		dishList.add(dish5);
	}
}

/*
	��װһ���ࣺ��Ʒ�ࡣ������ʾ�˵�ҳ�档�������������ԣ�1��id��2��������3���۸�

	��Dish�ṩһ���вεĹ��췽���������Ϳ���ֱ�Ӹ�id��name��price��ֵ��
*/