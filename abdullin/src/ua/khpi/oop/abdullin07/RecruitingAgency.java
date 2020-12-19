package ua.khpi.oop.abdullin07;

public class RecruitingAgency {
	Challanger[] mas = new Challanger[3];
	
	/**
	 * ����� ������ ������� ������
	 */
	public void printAll() {
		for(int i = 0 ; i < mas.length; i++) {
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
			System.out.println("---------------------");
		}
	}
}
