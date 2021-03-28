package ua.khpi.oop.abdullin09;

import java.io.Serializable;

import ua.khpi.oop.abdullin07.DemandsToWork;
import ua.khpi.oop.abdullin07.WorkExperience;

public class Challanger implements Serializable{
	private int registrationNum;
	private String education;
	private int dismissalDay;
	private int dismissalMonth;
	private int dismissalYear;
	private DemandsToWork demandsToWork;
	private WorkExperience workExperience;
	
	
	private static final long serialVersionUID = -136410610945474890L;
	
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
