package ua.khpi.oop.abdullin07;

public class Main {

	public static void main(String[] args) {
		RecruitingAgency list = new RecruitingAgency();
		WorkExperience workExperience1 = new WorkExperience("Кассир",4);
		DemandsToWork demandsToWork1 = new DemandsToWork("Менеджер по продажам",7800,"Наличие кофеварки на работе.");
		list.mas[0] = new Challanger(39821,"Среднее не полное",13,05,2020,workExperience1,demandsToWork1);
		workExperience1 = new WorkExperience("Учитель",14);
		demandsToWork1 = new DemandsToWork(null,0,null);
		list.mas[1] = new Challanger(15301,"Высшее образование",15,10,2014, workExperience1,demandsToWork1);
		workExperience1 = new WorkExperience("Бухгалтер",38);
		demandsToWork1 = new DemandsToWork("Бухгалтер",15000,"Оффис в цетре.");
		list.mas[2] = new Challanger(3004,"Высшее образование",14,03,2020, workExperience1,demandsToWork1);
		list.printAll();
		list.mas[2].getDemandsToWork().setConditions("Рядом с метро.");
		list.mas[1].getDemandsToWork().setMinSalary(9300);
		list.printAll();
	}

}
