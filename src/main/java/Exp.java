

import java.util.*;
import java.util.function.*;
import java.lang.*;

public class Exp
{
	public enum Gender
	{
			MALE, FEMALE, NONE
	}
	
	public interface StringOperation
	{
		String operate(String a, String b);
	}
	
	public String evaluateLambda(StringOperation operation)
	{
		return operation.operate("Chocolate","Milk");
	}
	
	public class Item
	{
		
		
		String name;
		
		Gender gender;
		public int age;
		public String favoriteColor;
		public String favoriteAnimal;
		
		public Item leftItem;
		public Item rightItem;
		
		public Item(String n, int a)
		{
			name = n;
			age = a;
			leftItem = null;
			rightItem = null;
			gender = Gender.NONE;
		}
		
		public void printItem()
		{
			System.out.println("Item: " + name + " Gender: "+gender.toString());
		}
		
		
		
		public String toString()
		{
			return (name.toString()+" "+gender).toUpperCase();
		}
		
		public void setAsMale()
		{
			gender = Gender.MALE;
		}
		
		public void setAsFemale()
		{
			gender = Gender.FEMALE;
		}
	}
	
	public void doWork()
	{
		ArrayList<Item> list = new ArrayList<Item>();
		list.add(new Item("Minbari",22));
		list.add(new Item("Vorlon",101));
		
		list.forEach((x)->{x.printItem();});
		
		HashMap<String,Item> hashMap = new HashMap<String,Item>();
		hashMap.put("item 1",new Item("Human",34));
		hashMap.get("item 1").setAsMale();
		hashMap.put("item 2",new Item("Narn",35));
		hashMap.forEach((key,value)->System.out.println("key: "+key+" value: "+value));
		
		
		Item item1 = new Item("Sinclair",44);
		item1.setAsMale();
		Item item2 = new Item("Ivanova",32);
		item2.setAsFemale();
		Item item3 = new Item("Garibaldi",35);
		item3.setAsMale();
		item1.leftItem = item2;
		item1.rightItem = item3;
		
		Item item4 = new Item("Zach",27);
		item4.setAsMale();
		item3.leftItem = item4;
		
		StringOperation operation = (a,b) ->{
			return(a + b);
		};
		String result1 = operation.operate("Butt","Buddy");
		System.out.println("o1: "+result1);
		
		String result2 = evaluateLambda(
			(a,b)->
			{
				System.out.println("Hello inside of lambda expression: "+ item4.name);
				return (a+b.toUpperCase());
			}
	);
		
		System.out.println("o2: "+result2);
		
		
		
	}
	
	public void Exp()
	{
	}
	
	/*
	public static void main(String [] args)
	{
		System.out.println("Hello World!");
		Exp exp = new Exp();
		exp.doWork();
		
	}
	*/

}