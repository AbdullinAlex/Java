package ua.khpi.oop.abdullin06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import ua.khpi.oop.abdullin03.TypeOfString;
import ua.khpi.oop.zanochkyn03.DeleteWords;


public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Container container = new Container("It's a text.");
		container.add("1It's a sentece wich started neither vowel nor conconent!");
		container.add("You are the best! Is that sentence started on vowel?");
		container.add("Is that sentence started on conconent?");
		container.add("This sentence stareted on conconent.");
		container.add("5*5=25?");
		
		boolean endprog = true;
		Scanner inStr = new Scanner(System.in);
		Scanner inInt = new Scanner(System.in);
		
		while(endprog) 
		{
			System.out.println("Menu:");
			System.out.println("1. Enter new data");
			System.out.println("2. Show data");
			System.out.println("3. Add element in container");
			System.out.println("4. Delete element from container");
			System.out.println("5. Clear container");
			System.out.println("6. Find element in container");
			System.out.println("7. Sort container by alphabet");
			System.out.println("8. Compare elements in container");
			System.out.println("9. Type of string.");
			System.out.println("10. Zanochkin class");
			System.out.println("11. Serialize container");
			System.out.println("12. Deserialize");
			System.out.println("13. Exit");
			System.out.println("Enter option:");
			int menu = inInt.nextInt();
			System.out.println();
			switch (menu) 
			{
			case 1:
				container.clear();
				System.out.println("Enter amount of sentences");
				int numofsentences = inInt.nextInt();
				String[] strmas = new String[numofsentences];
				System.out.println("Enter new container:");
				for (int i = 0; i < numofsentences; i++) 
					strmas[i] = inStr.nextLine();
				container = new Container(strmas);
				System.out.println("\nNew container:");
				container.printContainer();
				break;
			case 2:
				container.printContainer();
				break;
			case 3:
				System.out.println("Enter data to add:");
				container.add(inStr.nextLine());
				System.out.println();
				container.printContainer();
				break;
			case 4:
				System.out.println("Enter element to delete:");
				boolean delete = container.remove(inStr.nextLine());
				if (delete) 
				{
					System.out.println("\nContainer:");
					container.printContainer();
				}
				else 
					System.out.println("\nThere is no such element in container");
				break;
			case 5:
				container.clear();
				System.out.println("Container cleared\n");
				break;
			case 6:
				System.out.println("Enter element to find:");
				int position = container.find(inStr.nextLine());
				if (position != -1) 
					System.out.println("Position: " + (position+1) + "\n");
				else 
					System.out.println("There is no such element\n");
				break;
			case 7:
				System.out.println("1. Ascending");
				System.out.println("2. Descending");
				int sortAlphabet = inInt.nextInt();
				if(sortAlphabet == 1 || sortAlphabet == 2) {
					container.sortAlphabet(sortAlphabet);
					System.out.println();
					container.printContainer();
				}
				else 
					System.out.println("Try one more time");
				break;
			case 8:
				container.printContainer();
				System.out.println("Enter positions of elements (from 1 to " + container.size() + "):");
				int position1 = inInt.nextInt();
				int position2 = inInt.nextInt();
				int comp = container.compareElements(position1, position2);
				if (comp == 1) 
					System.out.println("Elements on positions " + position1 + " and " + position2 + " are equal\n"); 
				else if (comp == 0)
					System.out.println("Elements on positions " + position1 + " and " + position2 + " are NOT equal\n");
				else
					System.out.println("Wrong position\n");
				break;
			case 9:
				int sentenses = TypeOfString.countsentences(container.toString());
				TypeOfString.findtypes(container.toString(),sentenses);
				break;
			case 10:
				System.out.println("Enter count of letters and words with that count will be deleted (which starded on conconent):");
		        int count = inInt.nextInt();
		        DeleteWords.findAndDelete(container.toString(), count);
				break;
			case 11:
				FileOutputStream fos = new FileOutputStream("Serialization.ser");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(container);
				oos.close();
				System.out.println("Serialization is complete\n");
				break;
			case 12:
				FileInputStream fis = new FileInputStream("Serialization.ser");
				ObjectInputStream ois = new ObjectInputStream(fis);
				Container temp = (Container) ois.readObject();
				ois.close();
				System.out.println("Deserialization is complete\n");
				temp.printContainer();
				break;
			case 13:
				endprog = false;
				container.clear();
				inInt.close();
				inStr.close();
				break;
			default:
				System.out.println("Wrong command\n");
				break;
			}
		}
		System.out.println("End");
		}
		
	}

