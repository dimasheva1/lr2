import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Filmlist {
	private List<Film> list;
	private boolean change=false;
	
	public Filmlist()
	{
		list = new ArrayList<Film>();
	}
	
	public void read(File file) throws FileNotFoundException
	{
		Scanner in = new Scanner(file);
		in.nextLine();
		while (in.hasNextLine())
		{
			String str = in.nextLine();
			int first = str.indexOf(",");
            int last = str.lastIndexOf(",");
            int nomer = Integer.parseInt(str.substring(0, first));
            String name1 = str.substring((first+1),last);
            String name;
            String year = " ";
            Pattern p = Pattern.compile("^.+\\d{4}.+$");          
            Matcher m = p.matcher(name1);
            if (m.matches())
            {   	
            	
            	for(int i =0;i<name1.length();i++)
            	{
            		if (Character.isDigit(name1.charAt(i)))
            		{
            			year+=String.valueOf(name1.charAt(i));
            		}	
            	}
            	
            	year=year.substring(year.length()-4,year.length());
            	
            	
            	if(str.charAt(last-1)=='"') 
            		name= name1.substring(1,(name1.lastIndexOf(String.valueOf(year.charAt(3)))-4));
                else
                    name=name1.substring(0,name1.lastIndexOf(String.valueOf(year.charAt(3)))-4);  	
            }
            else
            {
            	if (str.charAt(last-1)=='"') name=name1.substring(1,name1.lastIndexOf("\""));
                else name=name1;  	
            }
            String [] ganr = str.substring(last+1, str.length()).split("\\|");
            list.add(new Film(nomer,name,year,ganr));	
		}	
	}
	
	
	public void printlist()
	{
		for (int i =0;i<list.size();i++)
		{
		  Film tmp = list.get(i);
		  tmp.print();
		}
	}
	
	public void writefile(File file)
	{
		try(FileWriter w = new FileWriter(file,false);)
		{
            w.write("Nomer, Name, Genres");
            w.append('\n');
            for(Film N:list){
                w.write(N.getNomer()+","+N.getName()+"("+N.getYear()+"),");
                String [] g = N.getGanr();
                for (String str:g)
                {
                	w.write(str + "|");
                }
                w.append('\n');
            }
        }
        catch (IOException e){}		
	}
	
	public void add(String na, String y,String[] g) 
	{
		if ((list.size()-1)!=-1)
		{
		int s = list.get(list.size()-1).getNomer();
		list.add(new Film(s+1,na,y,g));
		}
		else list.add(new Film(1,na,y,g));
		change=true;
	}
	
	public void add(Film f) 
	{
		if ((list.size()-1)!=-1)
		{
		list.add(f);
		}
		else list.add(f);
		change=true;
	}
	
	
	public boolean deleteByNomer(int a)
	{
		for(int i=0;i<list.size();i++)	
			{
			  if (list.get(i).getNomer()==a)
			  {
				list.remove(i);
				change=true;
				return true;
			  }
	        }
            return false;
	}
	
	public Filmlist findByGanr(String g)
	{
		Filmlist films = new Filmlist();
		for(Film f:list)
		{
			String []a=f.getGanr();
			for(String str:a) 
			{
				if (str.equals(g)) films.add(f); 
			}
		}
		return films;
	}
		
	public Filmlist findByYear(String y)
	{
		Filmlist films = new Filmlist();
		for(Film f:list)
		{
				if (f.getYear().equals(y)) films.add(f); 
		}
		return films;
	}
	
	public boolean changeYearbyNomer(int nomer,String year)
	{
		for(int i=0;i<list.size();i++)	
		{
		  if (list.get(i).getNomer()==nomer)
		  {
			list.get(i).setYear(year);
			change=true;
			return true;
		  }
        }
		return false;

	}
	
	public void findByName(String name)
	{
		for(int i=0;i<list.size();i++)	
		  if (list.get(i).getName().contains(name))
			list.get(i).print();    
	}
	
	
	public void write_Binfile(File f) throws FileNotFoundException, IOException
	{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
		for(Film N:list)
		{
			oos.writeObject(N);
		}
		oos.close();	
	}
	
	public void read_Binfile(File f)
	{
		try
		{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
        while ((Film)ois.readObject()!=null)
				list.add((Film)ois.readObject());
			} catch (ClassNotFoundException e) {} 
		      catch (IOException e) {}

		
	}
	
	public void clear()
	{
		list.clear();
	}
	
	public boolean getChange()
	{
		return change;
	}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	


