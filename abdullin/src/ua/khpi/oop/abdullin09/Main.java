package ua.khpi.oop.abdullin09;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import ua.khpi.oop.abdullin07.Challanger;
import ua.khpi.oop.abdullin07.DemandsToWork;
import ua.khpi.oop.abdullin07.WorkExperience;

public class Main {

	public static void main(String[] args) {
		MyContainer<Challanger> recruitingAgency = new MyContainer<Challanger>();
		
		boolean endprog = false;
		Scanner inInt = new Scanner(System.in);
		Scanner inStr = new Scanner(System.in);
		int menu;
		int menuSerialization;
		int menuDeserialization;
		
		while(!endprog)
		{
			System.out.println("1. Show all challanger");
			System.out.println("2. Add challanger");
			System.out.println("3. Delete chellanger");
			System.out.println("4. Clear list");
			System.out.println("5. Is empty recruiting agency?");
			System.out.println("6. Serialize data");
			System.out.println("7. Deserialize data");
			System.out.println("0. Exit");
			System.out.print("Enter option: ");
			try 
			{
				menu =  inInt.nextInt();
			}
			catch(java.util.InputMismatchException e) 
			{
				System.out.println("Error! ������ �����.");
				endprog = true;
				menu = 0;
			}
			System.out.println();
			switch(menu) 
			{
			case 1:
				if(recruitingAgency.getSize() > 0) {
					for(var element : recruitingAgency) {
						element.print();
					}
				}
				else {
					System.out.println("The recruiting agency is empty!\n");
				}
				break;
			case 2:
				String education;
				int day;
				int month;
				int year;
				String specializationPrevious;
				int experience;
				String specializationNext;
				int minSalary;
				String conditions;
				
				System.out.println("Enter education of challanger: ");
				try {
					education = inStr.nextLine();
				}catch(java.util.InputMismatchException e) {
					System.out.println("Error! Incorect input!");
					break;
				}
				
				System.out.println("Enter day of dismissal: ");
				try {
					day = inInt.nextInt();
				} catch(java.util.InputMismatchException e) {
					System.out.println("Error! Incorect input!");
					break;
				}
				
				System.out.println("Enter month of dismissal: ");
				try {
					month = inInt.nextInt();
				} catch(java.util.InputMismatchException e) {
					System.out.println("Error! Incorect input!");
					break;
				}
				
				System.out.println("Enter year of dismissal: ");
				try {
					year = inInt.nextInt();
				} catch(java.util.InputMismatchException e) {
					System.out.println("Error! Incorect input!");
					break;
				}

				System.out.println("Enter pervious job: ");
				try {
					specializationPrevious = inStr.nextLine();
				} catch(java.util.InputMismatchException e) {
					System.out.println("Error! Incorect input!");
					break;
				}
				
				System.out.println("Enter experience of working: ");
				try {
					experience = inInt.nextInt();
				} catch(java.util.InputMismatchException e){
					System.out.println("Error! Incorect input!");
					break;
				}
				
				System.out.println("Enter next job: ");
				try {
					specializationNext = inStr.nextLine();
				} catch(java.util.InputMismatchException e) {
					System.out.println("Error! Incorect input!");
					break;
				}
				
				System.out.println("Enter min salary: ");
				try {
					minSalary = inInt.nextInt();
				}catch (java.util.InputMismatchException e) {
					System.out.println("Error! Incorect input!");
					break;
				}
				
				System.out.println("Enter whishes to the next job: ");
				try {
					conditions = inStr.nextLine();
				} catch(java.util.InputMismatchException e){
					System.out.println("Error! Incorect input!");
					break;
				}
				int id = recruitingAgency.getSize();
				
				WorkExperience workExperienceAdd = new WorkExperience(specializationPrevious, experience);
				DemandsToWork demandsToWorkAdd = new DemandsToWork(specializationNext,minSalary,conditions);
				Challanger challangerAdd = new Challanger(id++,education,day,month,year,workExperienceAdd,demandsToWorkAdd);
				recruitingAgency.add(challangerAdd);
				break;
			case 3:
				System.out.println("Enter ID to delete: ");
				int delete = inInt.nextInt();
				boolean isExist = false;
				if(recruitingAgency.getSize() > 0) {
					for(var element : recruitingAgency) {
						if(element.getRegistrationNum() == delete) {
							isExist = true;
						}
					}
					if(isExist) {
						if(recruitingAgency.delete(delete))
							System.out.println("Challanger was deleted successfully.");
						else
							System.out.println("Error! Wrong ID.");
					}
					else
						System.out.println("Error! Wrong ID.");
				}
				break;
			case 4:
				recruitingAgency.clear();
				System.out.println("RecruitingAgency is empty now.\n");
				break;
			case 5:
				if(recruitingAgency.isEmpty())
					System.out.println("Recruiting agency is empty.\n");
				else
					System.out.println("Recruiting agency is not empty.");
				break;
			case 6:
				String filenameSerialization;
				String filenameXML;
				
				System.out.println("1. Serialization");
				System.out.println("2. XML serialization");
				System.out.println("0. Exit serialization");
				try 
				{
					menuSerialization =  inInt.nextInt();
				}
				catch(java.util.InputMismatchException e) 
				{
					System.out.println("Error! ������ �����.");
					menuSerialization = 0;
				}
				switch(menuSerialization) 
				{
				case 1:
					System.out.println("\nEnter file name: ");
					filenameSerialization = inStr.nextLine();
					if (filenameSerialization.indexOf(".ser") == -1) {
						filenameSerialization += ".ser";
					}
					try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream (filenameSerialization)))){
						oos.writeObject(recruitingAgency);
						System.out.println("Serialization successful.");
					} catch (Exception e){
						System.out.println(e.getMessage());
					}
					break;
				case 2:
					System.out.print("Enter XML filename: ");
					filenameXML = inStr.nextLine();
					if (filenameXML.indexOf(".xml") == -1)
						filenameXML += ".xml";
					try(XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream (filenameXML)))){
						encoder.writeObject(recruitingAgency);
						System.out.println("Serialization successful.");
					} catch (Exception e){
						System.out.println(e.getMessage());
					}
					break;
				case 0:
					break;
				default:
					System.out.println("Error! Wrong num in menu.");
					break;
				}
				break;
			case 7:
				String filenameDeserialization;
				
				System.out.println("1. Deserialization");
				System.out.println("2. XML deserialization");
				System.out.println("0. Exit deserialization");
				try 
				{
					menuDeserialization =  inInt.nextInt();
				}
				catch(java.util.InputMismatchException e) 
				{
					System.out.println("Error! ������ �����.");
					menuDeserialization = 0;
				}
				switch(menuDeserialization) 
				{
				case 1:
					System.out.println("\nEnter file name: ");
					filenameDeserialization = inStr.nextLine();
					if (filenameDeserialization.indexOf(".ser") == -1) {
						filenameDeserialization += ".ser";
					}
					try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream (filenameDeserialization)))){
						recruitingAgency.clear();
						recruitingAgency = (MyContainer<Challanger>) ois.readObject();
						System.out.println("Deserialization successful.");
					} catch (Exception e){
						System.out.println(e.getMessage());
					}
					break;
				case 2:
					System.out.print("Enter XML filename: ");
					filenameDeserialization = inStr.nextLine();
					if (filenameDeserialization.indexOf(".xml") == -1)
						filenameDeserialization += ".xml";
					try(XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream (filenameDeserialization)))){
						recruitingAgency.clear();
						recruitingAgency = (MyContainer<Challanger>) decoder.readObject();
						System.out.println("Deserialization successful.");
					} catch (Exception e){
						System.out.println(e.getMessage());
					}
					break;
				case 0:
					break;
				default:
					System.out.println("Error! Wrong num in menu.");
					break;
				}
				break;
			case 0:
				endprog = true;
				inInt.close();
				inStr.close();
				break;
			default:
				System.out.println("Error! Wrong num in menu.");
				break;
			}
		}
	}
}
