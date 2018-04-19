package com.fox;
import java.util.Scanner;
import java.util.ArrayList;
public class main
{
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[]args)
	{
		boolean ordering = true;
		ArrayList<Pizza> pizzaList = new ArrayList<Pizza>();
		int pizzaCount = 0;
		
		while(ordering)
		{
			String size = " ";
			int input = pizzaChoose();
			
			if(input!=7)
			{
				size = pizzaSize(input);
			}
			else
			{
				size = "Individual";
			}
			
			Pizza pizza = pizzaType(input,size);
			
			System.out.println("Would you like to add toppings? (Y/N)");
			toppingsAdd(scan.nextLine(),pizza);
			
			System.out.println("Would you like to add a special request (Y/N)");
			String put = scan.nextLine();
			while(!put.toLowerCase().equals("n")&&!put.toLowerCase().equals("y"))
			{
				System.out.println("Invalid option entered. Please enter (Y/N)");
				put = scan.nextLine();
			}
			
			boolean folg = true;
			String request = " ";
			ArrayList<String> requests = new ArrayList<String>();
			
			while(folg)
			{
				System.out.println("Please enter special request");
				requests.add(scan.nextLine());
				
				System.out.println("Would you like to add another special request (Y/N)");
				put = scan.nextLine();
				while(!put.toLowerCase().equals("n")&&!put.toLowerCase().equals("y"))
				{
					System.out.println("Invalid option entered. Please enter (Y/N)");
					put = scan.nextLine();
				}
				
				if(put.toLowerCase().equals("n"))
				{
					folg = false;
				}
			}
			
			System.out.println("Would you like to modify your order? (Y/N)");
			String edit = scan.nextLine();
			while(!edit.toLowerCase().equals("n")&&!edit.toLowerCase().equals("y"))
			{
				System.out.println("Invalid option entered. Please enter (Y/N)");
				edit = scan.nextLine();
			}
			
			boolean galf = true;
			String ed = " ";
			ArrayList<String> savedToppings = new ArrayList<String>(pizza.getList());
			while(edit.toLowerCase().equals("y"))
			{
				System.out.println("What would you like to modify: ");
				System.out.println("1. Modify type\n2. Modify Size\n3. Replace Topping\n4. Remove Topping"+
				"\n5. Add More Topping(s)");
				int inp = scan.nextInt();
				scan.nextLine();
				
				while(galf)
				{
					switch(inp)
					{
						case 1:
						input = pizzaChoose();
						savedToppings = new ArrayList<String>(pizza.getList());
						pizza = pizzaType(input,size);
						
						for(int x = 0;x<savedToppings.size();++x)
						{
							pizza.addTopping(savedToppings.get(x));
						}
						pizza.setPrice(pizza.calculatePrice(pizza.getSize(),pizza.getName(),savedToppings));
						galf = false;
						break;
						
						case 2:
						savedToppings = new ArrayList<String>(pizza.getList());
						pizza.setPrice(0);
						pizza.setSize(pizzaSize(input));
						pizza.setPrice(pizza.calculatePrice(pizza.getSize(),pizza.getName(),savedToppings));
						galf = false;
						break;
						
						case 3:
						System.out.println("What topping would you like to modify?");
						ed = scan.nextLine();
						System.out.println("What topping do you want to replace this with?");
						pizza.modifyTopping(ed,scan.nextLine());
						pizza.setPrice(pizza.calculatePrice(pizza.getSize(),pizza.getName(),savedToppings));
						galf = false;
						break;
						
						case 4:
						System.out.println("What topping would you like to remove?");
						ed = scan.nextLine();
						pizza.removeTopping(ed);
						savedToppings = new ArrayList<String>(pizza.getList());
						pizza.setPrice(pizza.calculatePrice(pizza.getSize(),pizza.getName(),savedToppings));
						galf = false;
						break;
						
						case 5:
						toppingsAdd("y",pizza);
						savedToppings = new ArrayList<String>(pizza.getList());
						pizza.setPrice(pizza.calculatePrice(pizza.getSize(),pizza.getName(),savedToppings));
						galf = false;
						break;
					}
				}
				
				System.out.println("Would you like to further modify your order (Y/N)?");
				edit = scan.nextLine();
				while(!edit.toLowerCase().equals("n")&&!edit.toLowerCase().equals("y"))
				{
					System.out.println("Invalid option entered. Please enter (Y/N)");
					edit = scan.nextLine();
				}
				
				if(edit.equals("y"))
				{
					galf = true;
				}
			}
			
			pizza.setPrice(pizza.calculatePrice(pizza.getSize(),pizza.getName(),savedToppings));
			System.out.println("Would you like to order another pizza? (Y/N)");
			String more = scan.nextLine();
			
			while(!more.toLowerCase().equals("n")&&!more.toLowerCase().equals("y"))
			{
				System.out.println("Invalid option entered. Please enter (Y/N)");
				more = scan.nextLine();
			}
			
			if(more.toLowerCase().equals("n"))
			{
				ordering = false;
			}
			
			if(pizzaCount >= 2)
			{
				System.out.println("Would you like to remove a pizza? (Y/N)");
				String removeInput = scan.nextLine();
				while(!removeInput.toLowerCase().equals("n")&&!removeInput.toLowerCase().equals("y"))
				{
					System.out.println("Invalid option entered. Please enter (Y/N)");
					removeInput = scan.nextLine();
				}
				
				if(removeInput.toLowerCase().equals("y"))
				{
					System.out.println("Enter the index of the pizza you would like to remove: ");
					int indexx = scan.nextInt();
					scan.nextLine();
					
					if(pizzaList.contains(pizzaList.get(indexx-1)))
					{
						pizzaList.remove(indexx-1);
					}
					else
					{
						System.out.println("There is no pizza with index = "+indexx);
					}
				}
			}
			
			for(int x = 0;x<pizzaList.size();++x)
			{
				if(pizza.equalss(pizzaList.get(x)))
				{
					pizzaList.remove(x);
					pizza.addCount(1);
				}
			}
			
			pizza.setReq(requests);
			pizzaList.add(pizza);
			++pizzaCount;
		}
		Pizza.orderSummary(pizzaList);
		
		//When I am done learning generics: Add call to addTopping method and pass it an argument that is a generic pizza type so that all pizza types can be accepted
		//after i am done with program: see if there is a better way to instantiate pizza objects than what i have done. 
	}
	
	public static Pizza pizzaType(int inpu,String size)
	{
		switch(inpu)
		{
			case 1:
			return new CheesePizza(size);

			case 2:
			return new SausagePizza(size);
			
			case 3:
			return new PepperoniPizza(size);
			
			case 4:
			return new SpecialPizza(size);
			
			case 5:
			return new VeggiePiePizza(size);
			
			case 6:
			return new BruschettaPizza(size);
			
			case 7:
			return new GlutenFreePizza();
		}
		
		return new CheesePizza(size);
	}
	
	public static String pizzaSize(int input)
	{
		boolean flag = true;
		String size = " ";
		
		while(flag)
		{
			System.out.println("\nWhat size would you like your pizza to be?\n"+
			"1. Individual\n2. Small\n3. Medium\n4. Large\n5. Family");
			int input2 = scan.nextInt();
			scan.nextLine();
			size = " ";
			switch(input2)
			{
				case 1:
				size = "Individual";
				flag = false;
				break;
				
				case 2:
				size = "Small";
				flag = false;
				break;
				
				case 3:
				size = "Medium";
				flag = false;
				break;
				
				case 4:
				size = "Large";
				flag = false;
				break;
				
				case 5:
				size = "Family";
				flag = false;
				break;
				
				default:
				System.out.println("\nInvalid size entered");
				break;
			}
		}
		
		return size;
	}
	
	public static int pizzaChoose()
	{
		System.out.println("What kind of pizza would you like to order?\n"+
		"1. Cheese\n2. Sausage\n3. Pepperoni\n4. Special\n5. Veggie Pie\n6. Bruschetta\n7. Gluten Free 10\"");
		int input = scan.nextInt();
		scan.nextLine();
		boolean flag = true;
		
		
		while(input!=1&&input!=2&&input!=3&&input!=4&&input !=5&&input!=6&&input!=7)
		{
			System.out.println("\nInvalid type entered. Please enter a valid type of pizza:\n"+
			"1. Cheese\n2. Sausage\n3. Pepperoni\n4. Special\n5. Veggie Pie\n6. Bruschetta\n7. Gluten Free 10\"");
			input = scan.nextInt();
			scan.nextLine();
		}
		
		return input;
	}
	
	public static void toppingsAdd(String a,Pizza pizza)
	{
		String top = a;
		while(!top.toLowerCase().equals("n")&&!top.toLowerCase().equals("y"))
		{
			System.out.println("Invalid option entered. Please enter (Y/N)");
			top = scan.nextLine();
		}
		while(top.toLowerCase().equals("y"))
		{
			System.out.println("What topping would you like to add: \n"+
			"(If putting an topping on a certain side only, \nplease enter fraction with topping.)\n"+
			"(If putting another topping on a certain side only, \nplease enter a \"+\" with the topping.)");
			String topping = scan.nextLine();
			pizza.addTopping(topping);
			System.out.println("Would you like to add more toppings? (Y/N)");
			top = scan.nextLine();
			while(!top.toLowerCase().equals("n")&&!top.toLowerCase().equals("y"))
			{
				System.out.println("Invalid option entered. Please enter (Y/N)");
				top = scan.nextLine();
			}
		}
	}
}

//add toppings method