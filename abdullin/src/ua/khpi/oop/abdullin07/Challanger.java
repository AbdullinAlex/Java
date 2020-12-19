package ua.khpi.oop.abdullin07;

public class Challanger {
	private int registrationNum;
	private String education;
	private int dismissalDay;
	private int dismissalMonth;
	private int dismissalYear;
	private WorkExperience workExperience;
	private DemandsToWork demandsToWork;
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
	public WorkExperience getWorkExperience() {
		return workExperience;
	}
	/**
	 * ������ ����� ������ �����������
	 * @param workExperience
	 */
	public void setWorkExoerience(WorkExperience workExperience) {
		this.workExperience = workExperience;
	}
	/**
	 * ������ ���������� � �������� ������
	 * @return
	 */
	public DemandsToWork getDemandsToWork() {
		return demandsToWork;
	}
	/**
	 * ������ ���������� � �������� ������ 
	 * @param demandsToWork 
	 */
	public void setDemandsToWork(DemandsToWork demandsToWork) {
		this.demandsToWork = demandsToWork;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
