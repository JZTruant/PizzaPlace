package com.fox;
import java.util.ArrayList;
public class Pizza
{
	private String name = " ";
	private double price = 0.0;
	private String size = " ";
	private int count = 0;
	private ArrayList<String> list = new ArrayList<String>();
	private ArrayList<String> req = new ArrayList<String>();
	private String[] validToppings = {"extra cheese","light cheese","light sausage","sausage","extra sausage","green peppers","light green peppers",
	"extra green peppers","mushrooms","extra mushrooms","light mushrooms","onions","extra onions","light onions","light red onions","red onions",
	"extra red onions","light green onions","green onions","extra green onions","pepperoni","extra pepperoni","light pepperoni",
	"italian seasonings","extra italian seasonings","light italian seasonings","baby spinach","extra baby spinach","light baby spinach","black olives","light black olives",
	"extra black olives","light green olives","green olives","extra green olives","tomatoes","extra tomatoes","light tomatoes",
	"giardiniera peppers","extra giardiniera peppers","light giardiniera peppers","light pineapple","pineapple","extra pineapple","chopped chicken","light chopped chicken",
	"extra chopped chicken","roasted red peppers","extra roasted red peppers","italian beef","light roasted red peppers","light italian beef",
	"extra italian beef","canadian bacon","light canadian bacon","extra canadian bacon","chopped bacon","extra chopped bacon","light chopped bacon",
	"ground beef","extra ground beef","light ground beef","light garlic","garlic","extra garlic","broccoli","extra broccoli","light broccoli","light basil","basil","extra basil","extra pizza sauce","light pizza sauce"};
	
	public Pizza(String name)
	{
		this.name = name;
		count = 1;
	}
	
	public ArrayList<String> getReq()
	{
		return this.req;
	}
	
	public void setReq(ArrayList<String> req)
	{
		this.req = req;
	}
	
	public int getCount()
	{
		return this.count;
	}
	
	public void addCount(int x)
	{
		this.count = this.count+x;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getSize()
	{
		return this.size;
	}
	
	public void setSize(String size)
	{
		this.size = size;
	}
	
	public double getPrice()
	{
		return this.price;
	}
	
	public void setPrice(double price)
	{
		this.price = price;
	}
	
	public String toString()
	{
		return name+" pizza";
	}
	
	public ArrayList<String> getList()
	{
		return new ArrayList<String>(list);
	}
	
	public boolean addTopping(String topping)
	{
		String newTopping = " ";
		if(topping.substring(0,2).equals("1/"))
		{
			newTopping = topping.substring(4,topping.length());
		}
		else if(topping.substring(0,1).equals("+"))
		{
			if(list.get(list.size()-1).substring(0,2).equals("1/"))
			{
				newTopping = topping.substring(1,topping.length());
			}
			else
			{
				System.out.println("Cannot specify \"+\" unless following a topping that covers a portion of the pizza.");
			}
		}
		else
		{
			newTopping = topping;
		}
		
		if(newTopping.toLowerCase().equals("sausage")&&name.toLowerCase().equals("sausage"))
		{
			System.out.println("Can't add sausage to a sausage pizza...");
		}
		else if(newTopping.toLowerCase().equals("pepperoni")&&name.toLowerCase().equals("pepperoni"))
		{
			System.out.println("Can't add pepperoni to a pepperoni pizza...");
		}
		else if((newTopping.toLowerCase().equals("sausage")||newTopping.toLowerCase().equals("mushrooms")||newTopping.toLowerCase().equals("green peppers")||newTopping.toLowerCase().equals("onions"))&&name.toLowerCase().equals("special"))
		{
			System.out.println("Can't add "+newTopping+" to a special pizza...");
		}
		else if((newTopping.toLowerCase().equals("baby spinach")||newTopping.toLowerCase().equals("mushrooms")||newTopping.toLowerCase().equals("tomatoes")||newTopping.toLowerCase().equals("garlic")||newTopping.toLowerCase().equals("broccoli"))&&name.toLowerCase().equals("veggie pie"))
		{
			System.out.println("Can't add "+newTopping+" to a veggie pie pizza...");
		}
		else if((newTopping.toLowerCase().equals("basil")||newTopping.toLowerCase().equals("tomatoes")||newTopping.toLowerCase().equals("garlic"))&&name.toLowerCase().equals("bruschetta"))
		{
			System.out.println("Can't add "+newTopping+" to a bruschetta pizza...");
		}
		else
		{
			if(validTopping(newTopping.toLowerCase()))
			{
				if(newTopping.toLowerCase().equals("italian beef")||newTopping.toLowerCase().equals("extra italian beef")||newTopping.toLowerCase().equals("chopped bacon")||newTopping.toLowerCase().equals("extra chopped bacon")||newTopping.toLowerCase().equals("canadian bacon")||newTopping.toLowerCase().equals("extra canadian bacon")||newTopping.toLowerCase().equals("ground beef")||newTopping.toLowerCase().equals("extra ground beef"))
				{
					list.add(topping);
					if(size.equals("Individual"))
					{
						this.price += 3.6;
					}
					else if(size.equals("Small"))
					{
						this.price += 4.0;
					}
					else if(size.equals("Medium"))
					{
						this.price += 4.4;
					}
					else if(size.equals("Large"))
					{
						this.price += 4.8;
					}
					else if(size.equals("Family"))
					{
						this.price += 5.2;
					}
				}
				else
				{
					list.add(topping);
					if(size.equals("Individual"))
					{
						this.price += 1.8;
					}
					else if(size.equals("Small"))
					{
						this.price += 2.0;
					}
					else if(size.equals("Medium"))
					{
						this.price += 2.2;
					}
					else if(size.equals("Large"))
					{
						this.price += 2.4;
					}
					else if(size.equals("Family"))
					{
						this.price += 2.6;
					}
				}
				
				return true;
			}
			else
			{
				if(newTopping.equals(" "))
				{
					System.out.println("Invalid topping option entered...");
					return false;
				}
				else
				{
					System.out.println(newTopping+" is an invalid topping...");
					return false;
				}
			}
		}
		return false;
	}
	
	public boolean validTopping(String topping)
	{
		for(int x = 0;x<validToppings.length;++x)
		{
			if(topping.equals(validToppings[x]))
			{
				return true;
			}
		}
		
		return false;
	}
	
	public void modifyTopping(String modifyTopping,String newTopping)
	{
		if(list.indexOf(modifyTopping)!=-1)
		{
			if(validTopping(newTopping)&&addTopping(newTopping))
			{
				list.remove(list.indexOf(newTopping));
				list.set(list.indexOf(modifyTopping),newTopping);
			}
		}
		else
		{
			System.out.println("This topping is not on this pizza...");
		}
	}
		
	public static void orderSummary(ArrayList<Pizza> list)
	{
		double total = 0.0;
		double ind = 0.0;
		for(int y = 0;y<list.size();++y)
		{
			if(list.get(y).getCount()==1)
			{
				System.out.println("\nYou ordered a(n) "+list.get(y).getSize().toLowerCase()+" "+list.get(y).getName().toLowerCase()+" pizza ");
				if(list.get(y).getList().size()>0)
				{
					System.out.println("with: ");
				}
				
				for(int x = 0;x<list.get(y).getList().size();++x)
				{
					System.out.println(list.get(y).getList().get(x));
				}
				
				System.out.println("\nSpecial Requests: ");
				for(int x = 0;x<list.get(y).getReq().size();++x)
				{
					System.out.println(list.get(y).getReq().get(x));
				}
				System.out.println("\nIt will cost: $"+String.format("%.2f",list.get(y).getPrice()));
				total += list.get(y).getPrice();
			}
			else
			{
				System.out.println("\nYou ordered "+list.get(y).getCount()+" "+list.get(y).getSize().toLowerCase()+" "+list.get(y).getName().toLowerCase()+" pizzas ");
				if(list.get(y).getList().size()>0)
				{
					System.out.println("with: ");
				}
				
				for(int x = 0;x<list.get(y).getList().size();++x)
				{
					System.out.println(list.get(y).getList().get(x));
				}
				System.out.println("\nIt will cost: $"+String.format("%.2f",list.get(y).getPrice()));
				total += (list.get(y).getPrice()*list.get(y).getCount());
			}
		}
		String tot = String.format("%.2f",total);
		System.out.println("\nYour total is: $"+tot);
	}
	
	public double calculatePrice(String size,String type,ArrayList<String> toppings)
	{
		double price = 0.0;
		
		if(type.toLowerCase().equals("cheese"))
		{
			if(size.toLowerCase().equals("individual"))
			{
				price += 9.99;
				if(toppings.size()!=0)
				{
					for(int x = 0;x<toppings.size();++x)
					{
						if(toppings.get(x).toLowerCase().equals("italian beef")||toppings.get(x).toLowerCase().equals("extra italian beef")||toppings.get(x).toLowerCase().equals("chopped bacon")||toppings.get(x).toLowerCase().equals("extra chopped bacon")||toppings.get(x).toLowerCase().equals("canadian bacon")||toppings.get(x).toLowerCase().equals("extra canadian bacon")||toppings.get(x).toLowerCase().equals("ground beef")||toppings.get(x).toLowerCase().equals("extra ground beef"))
						{
							price += 3.6;
						}
						else
						{
							price += 1.8;
						}
					}
				}
			}
			else if(size.toLowerCase().equals("small"))
			{
				price += 13.99;
				if(toppings.size()!=0)
				{
					for(int x = 0;x<toppings.size();++x)
					{
						if(toppings.get(x).toLowerCase().equals("italian beef")||toppings.get(x).toLowerCase().equals("extra italian beef")||toppings.get(x).toLowerCase().equals("chopped bacon")||toppings.get(x).toLowerCase().equals("extra chopped bacon")||toppings.get(x).toLowerCase().equals("canadian bacon")||toppings.get(x).toLowerCase().equals("extra canadian bacon")||toppings.get(x).toLowerCase().equals("ground beef")||toppings.get(x).toLowerCase().equals("extra ground beef"))
						{
							price += 4.0;
						}
						else
						{
							price += 2.0;
						}
					}
				}
			}
			else if(size.toLowerCase().equals("medium"))
			{
				price += 16.99;
				if(toppings.size()!=0)
				{
					for(int x = 0;x<toppings.size();++x)
					{
						if(toppings.get(x).toLowerCase().equals("italian beef")||toppings.get(x).toLowerCase().equals("extra italian beef")||toppings.get(x).toLowerCase().equals("chopped bacon")||toppings.get(x).toLowerCase().equals("extra chopped bacon")||toppings.get(x).toLowerCase().equals("canadian bacon")||toppings.get(x).toLowerCase().equals("extra canadian bacon")||toppings.get(x).toLowerCase().equals("ground beef")||toppings.get(x).toLowerCase().equals("extra ground beef"))
						{
							price += 4.4;
						}
						else
						{
							price += 2.2;
						}
					}
				}
			}
			else if(size.toLowerCase().equals("large"))
			{
				price += 19.99;
				if(toppings.size()!=0)
				{
					for(int x = 0;x<toppings.size();++x)
					{
						if(toppings.get(x).toLowerCase().equals("italian beef")||toppings.get(x).toLowerCase().equals("extra italian beef")||toppings.get(x).toLowerCase().equals("chopped bacon")||toppings.get(x).toLowerCase().equals("extra chopped bacon")||toppings.get(x).toLowerCase().equals("canadian bacon")||toppings.get(x).toLowerCase().equals("extra canadian bacon")||toppings.get(x).toLowerCase().equals("ground beef")||toppings.get(x).toLowerCase().equals("extra ground beef"))
						{
							price += 4.8;
						}
						else
						{
							price += 2.4;
						}
					}
				}
			}
			else if(size.toLowerCase().equals("family"))
			{
				price += 22.99;
				if(toppings.size()!=0)
				{
					for(int x = 0;x<toppings.size();++x)
					{
						if(toppings.get(x).toLowerCase().equals("italian beef")||toppings.get(x).toLowerCase().equals("extra italian beef")||toppings.get(x).toLowerCase().equals("chopped bacon")||toppings.get(x).toLowerCase().equals("extra chopped bacon")||toppings.get(x).toLowerCase().equals("canadian bacon")||toppings.get(x).toLowerCase().equals("extra canadian bacon")||toppings.get(x).toLowerCase().equals("ground beef")||toppings.get(x).toLowerCase().equals("extra ground beef"))
						{
							price += 5.2;
						}
						else
						{
							price += 2.6;
						}
					}
				}
			}
		}
		else if(type.toLowerCase().equals("sausage")||type.toLowerCase().equals("pepperoni"))
		{
			if(size.toLowerCase().equals("individual"))
			{
				price += 11.79;
				if(toppings.size()!=0)
				{
					for(int x = 0;x<toppings.size();++x)
					{
						if(toppings.get(x).toLowerCase().equals("italian beef")||toppings.get(x).toLowerCase().equals("extra italian beef")||toppings.get(x).toLowerCase().equals("chopped bacon")||toppings.get(x).toLowerCase().equals("extra chopped bacon")||toppings.get(x).toLowerCase().equals("canadian bacon")||toppings.get(x).toLowerCase().equals("extra canadian bacon")||toppings.get(x).toLowerCase().equals("ground beef")||toppings.get(x).toLowerCase().equals("extra ground beef"))
						{
							price += 3.6;
						}
						else
						{
							price += 1.8;
						}
					}
				}
			}
			else if(size.toLowerCase().equals("small"))
			{
				price += 15.99;
				if(toppings.size()!=0)
				{
					for(int x = 0;x<toppings.size();++x)
					{
						if(toppings.get(x).toLowerCase().equals("italian beef")||toppings.get(x).toLowerCase().equals("extra italian beef")||toppings.get(x).toLowerCase().equals("chopped bacon")||toppings.get(x).toLowerCase().equals("extra chopped bacon")||toppings.get(x).toLowerCase().equals("canadian bacon")||toppings.get(x).toLowerCase().equals("extra canadian bacon")||toppings.get(x).toLowerCase().equals("ground beef")||toppings.get(x).toLowerCase().equals("extra ground beef"))
						{
							price += 4.0;
						}
						else
						{
							price += 2.0;
						}
					}
				}
			}
			else if(size.toLowerCase().equals("medium"))
			{
				price += 19.19;
				if(toppings.size()!=0)
				{
					for(int x = 0;x<toppings.size();++x)
					{
						if(toppings.get(x).toLowerCase().equals("italian beef")||toppings.get(x).toLowerCase().equals("extra italian beef")||toppings.get(x).toLowerCase().equals("chopped bacon")||toppings.get(x).toLowerCase().equals("extra chopped bacon")||toppings.get(x).toLowerCase().equals("canadian bacon")||toppings.get(x).toLowerCase().equals("extra canadian bacon")||toppings.get(x).toLowerCase().equals("ground beef")||toppings.get(x).toLowerCase().equals("extra ground beef"))
						{
							price += 4.4;
						}
						else
						{
							price += 2.2;
						}
					}
				}
			}
			else if(size.toLowerCase().equals("large"))
			{
				price += 22.39;
				if(toppings.size()!=0)
				{
					for(int x = 0;x<toppings.size();++x)
					{
						if(toppings.get(x).toLowerCase().equals("italian beef")||toppings.get(x).toLowerCase().equals("extra italian beef")||toppings.get(x).toLowerCase().equals("chopped bacon")||toppings.get(x).toLowerCase().equals("extra chopped bacon")||toppings.get(x).toLowerCase().equals("canadian bacon")||toppings.get(x).toLowerCase().equals("extra canadian bacon")||toppings.get(x).toLowerCase().equals("ground beef")||toppings.get(x).toLowerCase().equals("extra ground beef"))
						{
							price += 4.8;
						}
						else
						{
							price += 2.4;
						}
					}
				}
			}
			else if(size.toLowerCase().equals("family"))
			{
				price += 25.59;
				if(toppings.size()!=0)
				{
					for(int x = 0;x<toppings.size();++x)
					{
						if(toppings.get(x).toLowerCase().equals("italian beef")||toppings.get(x).toLowerCase().equals("extra italian beef")||toppings.get(x).toLowerCase().equals("chopped bacon")||toppings.get(x).toLowerCase().equals("extra chopped bacon")||toppings.get(x).toLowerCase().equals("canadian bacon")||toppings.get(x).toLowerCase().equals("extra canadian bacon")||toppings.get(x).toLowerCase().equals("ground beef")||toppings.get(x).toLowerCase().equals("extra ground beef"))
						{
							price += 5.2;
						}
						else
						{
							price += 2.6;
						}
					}
				}
			}
		}
		else if(type.toLowerCase().equals("special")||type.toLowerCase().equals("veggie pie")||type.toLowerCase().equals("bruschetta"))
		{
			if(size.toLowerCase().equals("individual"))
			{
				price += 13.99;
				if(toppings.size()!=0)
				{
					for(int x = 0;x<toppings.size();++x)
					{
						if(toppings.get(x).toLowerCase().equals("italian beef")||toppings.get(x).toLowerCase().equals("extra italian beef")||toppings.get(x).toLowerCase().equals("chopped bacon")||toppings.get(x).toLowerCase().equals("extra chopped bacon")||toppings.get(x).toLowerCase().equals("canadian bacon")||toppings.get(x).toLowerCase().equals("extra canadian bacon")||toppings.get(x).toLowerCase().equals("ground beef")||toppings.get(x).toLowerCase().equals("extra ground beef"))
						{
							price += 3.6;
						}
						else
						{
							price += 1.8;
						}
					}
				}
			}
			else if(size.toLowerCase().equals("small"))
			{
				price += 18.99;
				if(toppings.size()!=0)
				{
					for(int x = 0;x<toppings.size();++x)
					{
						if(toppings.get(x).toLowerCase().equals("italian beef")||toppings.get(x).toLowerCase().equals("extra italian beef")||toppings.get(x).toLowerCase().equals("chopped bacon")||toppings.get(x).toLowerCase().equals("extra chopped bacon")||toppings.get(x).toLowerCase().equals("canadian bacon")||toppings.get(x).toLowerCase().equals("extra canadian bacon")||toppings.get(x).toLowerCase().equals("ground beef")||toppings.get(x).toLowerCase().equals("extra ground beef"))
						{
							price += 4.0;
						}
						else
						{
							price += 2.0;
						}
					}
				}
			}
			else if(size.toLowerCase().equals("medium"))
			{
				price += 22.99;
				if(toppings.size()!=0)
				{
					for(int x = 0;x<toppings.size();++x)
					{
						if(toppings.get(x).toLowerCase().equals("italian beef")||toppings.get(x).toLowerCase().equals("extra italian beef")||toppings.get(x).toLowerCase().equals("chopped bacon")||toppings.get(x).toLowerCase().equals("extra chopped bacon")||toppings.get(x).toLowerCase().equals("canadian bacon")||toppings.get(x).toLowerCase().equals("extra canadian bacon")||toppings.get(x).toLowerCase().equals("ground beef")||toppings.get(x).toLowerCase().equals("extra ground beef"))
						{
							price += 4.4;
						}
						else
						{
							price += 2.2;
						}
					}
				}
			}
			else if(size.toLowerCase().equals("large"))
			{
				price += 25.99;
				if(toppings.size()!=0)
				{
					for(int x = 0;x<toppings.size();++x)
					{
						if(toppings.get(x).toLowerCase().equals("italian beef")||toppings.get(x).toLowerCase().equals("extra italian beef")||toppings.get(x).toLowerCase().equals("chopped bacon")||toppings.get(x).toLowerCase().equals("extra chopped bacon")||toppings.get(x).toLowerCase().equals("canadian bacon")||toppings.get(x).toLowerCase().equals("extra canadian bacon")||toppings.get(x).toLowerCase().equals("ground beef")||toppings.get(x).toLowerCase().equals("extra ground beef"))
						{
							price += 4.8;
						}
						else
						{
							price += 2.4;
						}
					}
				}
			}
			else if(size.toLowerCase().equals("family"))
			{
				price += 29.99;
				if(toppings.size()!=0)
				{
					for(int x = 0;x<toppings.size();++x)
					{
						if(toppings.get(x).toLowerCase().equals("italian beef")||toppings.get(x).toLowerCase().equals("extra italian beef")||toppings.get(x).toLowerCase().equals("chopped bacon")||toppings.get(x).toLowerCase().equals("extra chopped bacon")||toppings.get(x).toLowerCase().equals("canadian bacon")||toppings.get(x).toLowerCase().equals("extra canadian bacon")||toppings.get(x).toLowerCase().equals("ground beef")||toppings.get(x).toLowerCase().equals("extra ground beef"))
						{
							price += 5.2;
						}
						else
						{
							price += 2.6;
						}
					}
				}
			}
		}
		else if(type.toLowerCase().equals("gluten free"))
		{
			price += 13.99;
			if(toppings.size()!=0)
			{
				for(int x = 0;x<toppings.size();++x)
					{
						if(toppings.get(x).toLowerCase().equals("italian beef")||toppings.get(x).toLowerCase().equals("extra italian beef")||toppings.get(x).toLowerCase().equals("chopped bacon")||toppings.get(x).toLowerCase().equals("extra chopped bacon")||toppings.get(x).toLowerCase().equals("canadian bacon")||toppings.get(x).toLowerCase().equals("extra canadian bacon")||toppings.get(x).toLowerCase().equals("ground beef")||toppings.get(x).toLowerCase().equals("extra ground beef"))
						{
							price += 3.6;
						}
						else
						{
							price += 1.8;
						}
					}
			}
		}
		
		int mult = toppings.size();
		
		return price;
	}
	
	//////
	
	public boolean removeTopping(String topping)
	{
		String newTopping = " ";
		if(topping.substring(0,2).equals("1/"))
		{
			newTopping = topping.substring(4,topping.length());
		}
		else if(topping.substring(0,1).equals("+"))
		{
			if(list.get(list.size()-1).substring(0,2).equals("1/"))
			{
				newTopping = topping.substring(1,topping.length());
			}
			else
			{
				System.out.println("Cannot specify \"+\" unless following a topping that covers a portion of the pizza.");
			}
		}
		else
		{
			newTopping = topping;
		}
		
		if(getList().contains(topping))
		{
			if(newTopping.toLowerCase().equals("sausage")&&name.toLowerCase().equals("sausage"))
			{
				System.out.println("Can't add sausage to a sausage pizza...");
			}
			else if(newTopping.toLowerCase().equals("pepperoni")&&name.toLowerCase().equals("pepperoni"))
			{
				System.out.println("Can't add pepperoni to a pepperoni pizza...");
			}
			else if((newTopping.toLowerCase().equals("sausage")||newTopping.toLowerCase().equals("mushrooms")||newTopping.toLowerCase().equals("green peppers")||newTopping.toLowerCase().equals("onions"))&&name.toLowerCase().equals("special"))
			{
				System.out.println("Can't add "+newTopping+" to a special pizza...");
			}
			else if((newTopping.toLowerCase().equals("baby spinach")||newTopping.toLowerCase().equals("mushrooms")||newTopping.toLowerCase().equals("tomatoes")||newTopping.toLowerCase().equals("garlic")||newTopping.toLowerCase().equals("broccoli"))&&name.toLowerCase().equals("veggie pie"))
			{
				System.out.println("Can't add "+newTopping+" to a veggie pie pizza...");
			}
			else if((newTopping.toLowerCase().equals("basil")||newTopping.toLowerCase().equals("tomatoes")||newTopping.toLowerCase().equals("garlic"))&&name.toLowerCase().equals("bruschetta"))
			{
				System.out.println("Can't add "+newTopping+" to a bruschetta pizza...");
			}
			else
			{
				if(validTopping(newTopping.toLowerCase()))
				{
					if(newTopping.toLowerCase().equals("italian beef")||newTopping.toLowerCase().equals("extra italian beef")||newTopping.toLowerCase().equals("chopped bacon")||newTopping.toLowerCase().equals("extra chopped bacon")||newTopping.toLowerCase().equals("canadian bacon")||newTopping.toLowerCase().equals("extra canadian bacon")||newTopping.toLowerCase().equals("ground beef")||newTopping.toLowerCase().equals("extra ground beef"))
					{
						list.remove(topping);
						if(size.equals("Individual"))
						{
							this.price -= 3.6;
						}
						else if(size.equals("Small"))
						{
							this.price -= 4.0;
						}
						else if(size.equals("Medium"))
						{
							this.price -= 4.4;
						}
						else if(size.equals("Large"))
						{
							this.price -= 4.8;
						}
						else if(size.equals("Family"))
						{
							this.price -= 5.2;
						}
					}
					else
					{
						list.remove(topping);
						if(size.equals("Individual"))
						{
							this.price -= 1.8;
						}
						else if(size.equals("Small"))
						{
							this.price -= 2.0;
						}
						else if(size.equals("Medium"))
						{
							this.price -= 2.2;
						}
						else if(size.equals("Large"))
						{
							this.price -= 2.4;
						}
						else if(size.equals("Family"))
						{
							this.price -= 2.6;
						}
					}
					
					return true;
				}
				else
				{
					if(newTopping.equals(" "))
					{
						System.out.println("Invalid topping option entered...");
						return false;
					}
					else
					{
						System.out.println(newTopping+" is an invalid topping...");
						return false;
					}
				}
			}
		}
		else
		{
			System.out.println(newTopping+" is not on this pizza...");
		}
		return false;
	}
	
	public boolean equalss(Pizza other) 
	{
		return this.getName().equals(other.getName())
			&& this.getSize().equals(other.getSize())
			&& this.getList().equals(other.getList());
	}
}