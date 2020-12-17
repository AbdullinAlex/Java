package ua.khpi.oop.abdullin05;

import ua.khpi.oop.abdullin05.Container.MyIterator;

public class Main {

	public static void main(String[] args) {
		Container container = new Container("It's a text.","1It's a sentece wich started neither vowel nor conconent!", "You are the best!");
		MyIterator<String> iterator = container.iterator();
		
		System.out.println("Cycle while:");
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		System.out.println("Cycle for each:");
		iterator = container.iterator();
		Object[] array = container.toArray();
		for(Object arr : array) {
			System.out.println(arr);
		}
		
		System.out.println("Removing one item from container");
		System.out.println("Check removing:" + container.remove("It's a text."));
		System.out.println(container.toString());
		
		System.out.println("Size of container:" + container.size());
		
		System.out.println("Add some new items.");
		container.add("Is that sentence started on vowel?");
		container.add("Is that sentence started on conconent?");
		container.add("This sentence stareted on conconent.");
		container.add("5*5=25?");
		
		System.out.println("Show data: " + container.toString());
		
		System.out.println("Size of container:" + container.size());
		
		System.out.println("Contains string " + "'1It's a sentece wich started neither vowel nor conconent!': " + container.contains("1It's a sentece wich started neither vowel nor conconent!"));
		
		Container newcontainer = new Container("You are the best!", "5*5=25?", "Is that sentence started on vowel?");
		System.out.println("Show data of new container: " + newcontainer.toString());
		System.out.println("Contains all: " + container.containsAll(newcontainer));
		
		System.out.println("Clear contaainers");
		newcontainer.clear();
		container.clear();
	}
}
