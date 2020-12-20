package ua.khpi.oop.abdullin08;

import ua.khpi.oop.abdullin07.Challanger;

public class RecruitingAgency {
	private int size = 0;
	Challanger[] mas = new Challanger[size];
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	public void add(Challanger challanger) {
		Challanger[] newmas = new Challanger[size+1];
		for(int i = 0; i < size; i++)
			newmas[i] = mas[i];
		size++;
		newmas[size-1] = challanger;
		mas = newmas;
	}
	
	public boolean remove(int num) {
		if(num > 0 || num < size) {
			Challanger[] newmas = new Challanger[size-1];
			for (int i = 0; i < num; i++) 
				newmas[i] = mas[i];
			for (int i = num, j = num + 1; j < size; i++, j++) 
				newmas[i] = mas[j];
			size--;
			mas = newmas;
			return true;
		}
		return false;
	}
	public boolean removeID(int ID) {
		int num = -1;
		for(int i = 0; i < size; i++ ) {
			if(mas[i].getRegistrationNum() == ID) {
				num = i;
				break;
			}
		}
		if(num != -1) 
			return remove(num);
		else
			return false;
	}
	
	public void clear() {
		size = 0;
		Challanger[] newmas = new Challanger[size];
		mas = newmas;
	}
	
	public void printID(int ID) {
		int num = -1;
		for(int i = 0; i < size; i++ ) {
			if(mas[i].getRegistrationNum() == ID) {
				num = i;
				break;
			}
		}
		if(num != -1)
			print(num+1);
		else
			System.out.println("������ �������� ID.");
	}
	public void print(int num) {
		if(num > 0 || num < size) {
			System.out.println("ID: " + mas[num-1].getRegistrationNum());
			System.out.println("�����������: " + mas[num-1].getEducation());
			System.out.println("���� ����������: " + mas[num-1].getDismissalDay()+"/"+mas[num-1].getDismissalMonth()+"/"+mas[num-1].getDismissalYear());
			System.out.println("---���� ������---");
			System.out.println("����� ���������� ������: " + mas[num-1].getWorkExperience().getSpecialization());
			if(mas[num-1].getWorkExperience().getExperience() <= 4)
				System.out.println("����: " + mas[num-1].getWorkExperience().getExperience() + " ���(�)");
			else
				System.out.println("����: " + mas[num-1].getWorkExperience().getExperience() + " ���");
			System.out.println("---������� �� �������� ������---" );
			if(mas[num-1].getDemandsToWork().getMinSalary() == 0 && mas[num-1].getDemandsToWork().getSpecialization() == null && mas[num-1].getDemandsToWork().getConditions() == null)
				System.out.println("��������� �� ����� ������� ������� �� �������� ������");
			else {
				if( mas[num-1].getDemandsToWork().getMinSalary() != 0)
					System.out.println("�������� ����������� ��������: " +  mas[num-1].getDemandsToWork().getMinSalary());
				else
					System.out.println("�������� ����������� ��������: ���������� �� ����� ��������� � ����� ����� " );
				if(mas[num-1].getDemandsToWork().getSpecialization() != null)
					System.out.println("�������� �������� ������: " + mas[num-1].getDemandsToWork().getSpecialization());
				else
					System.out.println("�������� �������� ������: ���������� �� ����� ��������� � ����� �����");
				if(mas[num-1].getDemandsToWork().getConditions() != null)
					System.out.println("�������� ������� �������� ������: " + mas[num-1].getDemandsToWork().getConditions());
				else
					System.out.println("�������� ������� �������� ������: ���������� �� ����� ��������� � ����� �����");
			}
			System.out.println("------------------------------------------");
		}
		else
			System.out.println("������ ������� �������.");
	}
	/**
	 * ����� ������ ������� ������
	 */
	public void printAll() {
		if(size > 0) {
			for(int i = 0 ; i < size; i++) {
				System.out.println("ID: " + mas[i].getRegistrationNum());
				System.out.println("�����������: " + mas[i].getEducation());
				System.out.println("���� ����������: " + mas[i].getDismissalDay()+"/"+mas[i].getDismissalMonth()+"/"+mas[i].getDismissalYear());
				System.out.println("---���� ������---");
				System.out.println("����� ���������� ������: " + mas[i].getWorkExperience().getSpecialization());
				if(mas[i].getWorkExperience().getExperience() <= 4)
					System.out.println("����: " + mas[i].getWorkExperience().getExperience() + " ���(�)");
				else
					System.out.println("����: " + mas[i].getWorkExperience().getExperience() + " ���");
				System.out.println("---������� �� �������� ������---" );
				if(mas[i].getDemandsToWork().getMinSalary() == 0 && mas[i].getDemandsToWork().getSpecialization() == null && mas[i].getDemandsToWork().getConditions() == null)
					System.out.println("��������� �� ����� ������� ������� �� �������� ������");
				else {
					if( mas[i].getDemandsToWork().getMinSalary() != 0)
						System.out.println("�������� ����������� ��������: " +  mas[i].getDemandsToWork().getMinSalary());
					else
						System.out.println("�������� ����������� ��������: ���������� �� ����� ��������� � ����� ����� " );
					if(mas[i].getDemandsToWork().getSpecialization() != null)
						System.out.println("�������� �������� ������: " + mas[i].getDemandsToWork().getSpecialization());
					else
						System.out.println("�������� �������� ������: ���������� �� ����� ��������� � ����� �����");
					if(mas[i].getDemandsToWork().getConditions() != null)
						System.out.println("�������� ������� �������� ������: " + mas[i].getDemandsToWork().getConditions());
					else
						System.out.println("�������� ������� �������� ������: ���������� �� ����� ��������� � ����� �����");
				}
				System.out.println("------------------------------------------");
			}
		}
		else
			System.out.println("������������ �� ������ ����.");
	}
}
