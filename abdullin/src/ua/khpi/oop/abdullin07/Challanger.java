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
	 * Конструктор
	 * @param registrationNum ID претндента
	 * @param education образование претендента
	 * @param dismissalDay день увольнения претендента
	 * @param dismissalMonth месяц увольнения претендента
	 * @param dismissalYear год увольнения претендента
	 * @param workExperience опыт работы претендента
	 * @param demandsToWork пожелания к будующей работе
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
	 * Геттер ID претендента
	 * @return ID претендента
	 */
	public int getRegistrationNum() {
		return registrationNum;
	}
	/**
	 * Сеттер ID претендента
	 * @param registrationNum ID претендента
	 */
	public void setRegistrationNum(int registrationNum) {
		this.registrationNum = registrationNum;
	}
	/**
	 * Геттер образования претендента
	 * @return образование претендента
	 */
	public String getEducation() {
		return education;
	}
	/**
	 * Сеттер образования претендента
	 * @param education Образование претендента
	 */
	public void setEducation(String education) {
		this.education = education;
	}
	/**
	 * Геттер дня увольнения
	 * @return день увольнения
	 */
	public int getDismissalDay() {
		return dismissalDay;
	}
	/**
	 * Сеттер дня увольнеия 
	 * @param dismissalDay день увольнения 
	 */
	public void setDismissalDay(int dismissalDay) {
		this.dismissalDay = dismissalDay;
	}
	/**
	 * Геттер месяца увольнеия 
	 * @return месяц увоьнения
	 */
	public int getDismissalMonth() {
		return dismissalMonth;
	}
	/**
	 * Сеттер месяца увольнения
	 * @param dismissalMonth месяц увольнения
	 */
	public void setDismissalMonth(int dismissalMonth) {
		this.dismissalMonth = dismissalMonth;
	}
	/**
	 * Геттер года увольнения претендента
	 * @return год увольнения
	 */
	public int getDismissalYear() {
		return dismissalYear;
	}
	/**
	 * Сеттер года увольнения претендента
	 * @param dismissalYear год увольнения
	 */
	public void setDismissalYear(int dismissalYear) {
		this.dismissalYear = dismissalYear;
	}
	/**
	 * Геттер опыта работы претендента
	 * @return 
	 */
	public WorkExperience getWorkExperience() {
		return workExperience;
	}
	/**
	 * Сеттер опыта работы претендента
	 * @param workExperience
	 */
	public void setWorkExoerience(WorkExperience workExperience) {
		this.workExperience = workExperience;
	}
	/**
	 * Геттер требований к будующей работе
	 * @return
	 */
	public DemandsToWork getDemandsToWork() {
		return demandsToWork;
	}
	/**
	 * Сеттер требований к будующей работе 
	 * @param demandsToWork 
	 */
	public void setDemandsToWork(DemandsToWork demandsToWork) {
		this.demandsToWork = demandsToWork;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
