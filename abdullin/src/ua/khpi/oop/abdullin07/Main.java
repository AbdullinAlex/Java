package ua.khpi.oop.abdullin07;

public class Main {

	public static void main(String[] args) {
		RecruitingAgency list = new RecruitingAgency();
		WorkExperience workExperience1 = new WorkExperience("������",4);
		DemandsToWork demandsToWork1 = new DemandsToWork("�������� �� ��������",7800,"������� ��������� �� ������.");
		list.mas[0] = new Challanger(39821,"������� �� ������",13,05,2020,workExperience1,demandsToWork1);
		workExperience1 = new WorkExperience("�������",14);
		demandsToWork1 = new DemandsToWork(null,0,null);
		list.mas[1] = new Challanger(15301,"������ �����������",15,10,2014, workExperience1,demandsToWork1);
		workExperience1 = new WorkExperience("���������",38);
		demandsToWork1 = new DemandsToWork("���������",15000,"����� � �����.");
		list.mas[2] = new Challanger(3004,"������ �����������",14,03,2020, workExperience1,demandsToWork1);
		list.printAll();
		list.mas[2].getDemandsToWork().setConditions("����� � �����.");
		list.mas[1].getDemandsToWork().setMinSalary(9300);
		list.printAll();
	}

}
