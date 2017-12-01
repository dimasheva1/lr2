import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
public class Main {
	private static String namefile = "D:\\Уроки\\OOP\\Джава 2 семестр\\Л Р 2\\movies.csv";
	private static String namefile1 = "D:\\Уроки\\OOP\\Джава 2 семестр\\Л Р 2\\movies1.csv";

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		File file = new File(namefile);
		File file1 = new File(namefile1);
		Filmlist list = new Filmlist();
	    
		Scanner in = new Scanner(System.in);
		while (true)
		{
			System.out.println("1.Прочитать с бинарника");
			System.out.println("2.Прочитать с файла");
			System.out.println("3.Поиск по жанру");
			System.out.println("4.Поиск по году");
			System.out.println("5.Поиск по имени");
			System.out.println("6.Печать");
			System.out.println("7.Добавить");
			System.out.println("8.Удалить по номеру");
			System.out.println("9.Изменить год");
			System.out.println("10.Сохранить и выйти");
			
			int i = in.nextInt();
			switch(i) 
			{
			case 1:if (list==null) list.read_Binfile(file1);
	           else {list.clear();list.read_Binfile(file1);} 
				   
		           break;
			case 2:if (list==null) list.read(file);
	               else {list.clear();list.read(file);}
				   
		           break;
			case 3:System.out.println("Введите жанр");
		           String g = in.next();
		           list.findByGanr(g).printlist();
		           break;
		    case 4:System.out.println("Введите год"); 
		           String year = in.next();
		           list.findByYear(year).printlist();
		           break;
		    case 5:System.out.println("Введите имя");
    	           in.nextLine();
                   String name = in.nextLine();
                   list.findByName(name);
		    	
			       break;
		    case 6:list.printlist();
		           break;
		    case 7:System.out.println("Введите название");
			   		in.nextLine();
			   		 name = in.nextLine();
			   		System.out.println("Введите год");
			   		 year = in.next();
			   		System.out.println("Введите жанры через пробел");
			   		in.nextLine();
			   		 g = in.nextLine();
			   		String ganr[] = g.split(" ");
			   		list.add(name, year, ganr); 
		           break;
		    case 8: System.out.println("Введите номер");       
	           		int nomer = in.nextInt();
	           		System.out.println(list.deleteByNomer(nomer));
		           break;
		    case 9:System.out.println("Введите номер");
		           nomer=in.nextInt();
		           System.out.println("Введите год");
		           year = in.next();
		           list.changeYearbyNomer(nomer, year);
		           break;
		    case 10:if (list.getChange()==true)
		            { list.writefile(file);
		              list.write_Binfile(file1);
	    	        }
		    	
		           
			}
		if (i==10) break;
		
		}
	}

}
