package ua.khpi.oop.abdullin15;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Comparator;

import ua.khpi.oop.abdullin07.DemandsToWork;
import ua.khpi.oop.abdullin07.WorkExperience;


public class Challanger implements Serializable { 
	private static final long serialVersionUID = -5616690429713031285L;
	
	private int registrationNum;
	private String education;
	private int dismissalDay;
	private int dismissalMonth;
	private int dismissalYear;
	private DemandsToWork demandsToWork;
	private WorkExperience workExperience;
	
	/**
	 * �����������
	 * @param registrationNum ID ����������
	 * @param education ����������� �����������
	 * @param dismissalDay ���� ���������� �����������
	 * @param dismissalMonth ����� ���������� �����������
	 * @param dismissalYear ��� ���������� �����������
	 * @param workExperience ���� ������ �����������
	 * @param demandsToWork ��������� � �������� ������
	 */
	public Challanger(int registrationNum, String education, int dismissalDay, int dismissalMonth, int dismissalYear, WorkExperience workExperience, DemandsToWork demandsToWork ) {
		this.registrationNum = registrationNum;
		this.education = education;
		this.dismissalDay = dismissalDay;
		this.dismissalMonth = dismissalMonth;
		this.dismissalYear = dismissalYear;
		this.workExperience = workExperience;
		this.demandsToWork = demandsToWork;
	}
	public Challanger() 
	{
		super();
	}
	/**
	 * ������ ID �����������
	 * @return ID �����������
	 */
	public int getRegistrationNum() {
		return registrationNum;
	}
	/**
	 * ������ ID �����������
	 * @param registrationNum ID �����������
	 */
	public void setRegistrationNum(int registrationNum) {
		this.registrationNum = registrationNum;
	}
	/**
	 * ������ ����������� �����������
	 * @return ����������� �����������
	 */
	public String getEducation() {
		return education;
	}
	/**
	 * ������ ����������� �����������
	 * @param education ����������� �����������
	 */
	public void setEducation(String education) {
		this.education = education;
	}
	/**
	 * ������ ��� ����������
	 * @return ���� ����������
	 */
	public int getDismissalDay() {
		return dismissalDay;
	}
	/**
	 * ������ ��� ��������� 
	 * @param dismissalDay ���� ���������� 
	 */
	public void setDismissalDay(int dismissalDay) {
		this.dismissalDay = dismissalDay;
	}
	/**
	 * ������ ������ ��������� 
	 * @return ����� ���������
	 */
	public int getDismissalMonth() {
		return dismissalMonth;
	}
	/**
	 * ������ ������ ����������
	 * @param dismissalMonth ����� ����������
	 */
	public void setDismissalMonth(int dismissalMonth) {
		this.dismissalMonth = dismissalMonth;
	}
	/**
	 * ������ ���� ���������� �����������
	 * @return ��� ����������
	 */
	public int getDismissalYear() {
		return dismissalYear;
	}
	/**
	 * ������ ���� ���������� �����������
	 * @param dismissalYear ��� ����������
	 */
	public void setDismissalYear(int dismissalYear) {
		this.dismissalYear = dismissalYear;
	}
	/**
	 * ������ ����� ������ �����������
	 * @return 
	 */

	/**
	 * ������ ���������� � �������� ������
	 * @return
	 */
	public DemandsToWork getDemandsToWork() {
		return demandsToWork;
	}
	public WorkExperience getWorkExperience() {
		return workExperience;
	}
	public void setWorkExperience(WorkExperience workExperience) {
		this.workExperience = workExperience;
	}
	/**
	 * ������ ���������� � �������� ������ 
	 * @param demandsToWork 
	 */
	public void setDemandsToWork(DemandsToWork demandsToWork) {
		this.demandsToWork = demandsToWork;
	}
	
	public void print() {
		System.out.println("ID: " + getRegistrationNum());
		System.out.println("�����������: " + getEducation());
		System.out.println("���� ����������: " + getDismissalDay()+"/" + getDismissalMonth()+"/"+getDismissalYear());
		System.out.println("---���� ������---");
		System.out.println("����� ���������� ������: " + getWorkExperience().getSpecialization());
		if(getWorkExperience().getExperience() <= 4)
			System.out.println("����: " + getWorkExperience().getExperience() + " ���(�)");
		else
			System.out.println("����: " + getWorkExperience().getExperience() + " ���");
		System.out.println("---������� �� �������� ������---" );
		if(getDemandsToWork().getMinSalary() == 0 && getDemandsToWork().getSpecialization() == null && getDemandsToWork().getConditions() == null)
			System.out.println("��������� �� ����� ������� ������� �� �������� ������");
		else {
			if(getDemandsToWork().getMinSalary() != 0)
				System.out.println("�������� ����������� ��������: " + getDemandsToWork().getMinSalary());
			else
				System.out.println("�������� ����������� ��������: ���������� �� ����� ��������� � ����� ����� " );
			if(getDemandsToWork().getSpecialization() != null)
				System.out.println("�������� �������� ������: " + getDemandsToWork().getSpecialization());
			else
				System.out.println("�������� �������� ������: ���������� �� ����� ��������� � ����� �����");
			if(getDemandsToWork().getConditions() != null)
				System.out.println("�������� ������� �������� ������: " + getDemandsToWork().getConditions());
			else
				System.out.println("�������� ������� �������� ������: ���������� �� ����� ��������� � ����� �����");
		}
		System.out.println("------------------------------------------");
		
	}
}

class idComparator implements Comparator<Challanger>{
	@Override
	public int compare(Challanger o1, Challanger o2) {
		if(o1.getRegistrationNum() > o2.getRegistrationNum())
			return 1;
		else if (o1.getRegistrationNum() < o2.getRegistrationNum())
			return -1;
		else
			return 0;
	}
}

class workExperienceComparator implements Comparator<Challanger>{
	public int compare(Challanger o1, Challanger o2) {
		if(o1.getWorkExperience().getExperience() > o2.getWorkExperience().getExperience())
			return 1;
		else if (o1.getWorkExperience().getExperience() < o2.getWorkExperience().getExperience())
			return -1;
		else
			return 0;
	}
}

class minSalazyComparator implements Comparator<Challanger>{
	@Override
	public int compare(Challanger o1, Challanger o2) {
		if(o1.getDemandsToWork().getMinSalary() > o2.getDemandsToWork().getMinSalary())
			return 1;
		else if (o1.getDemandsToWork().getMinSalary() < o2.getDemandsToWork().getMinSalary())
			return -1;
		else
			return 0;
	}
	
}