package ua.khpi.oop.abdullin07;

public class WorkExperience{
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public WorkExperience(String specialization, int experience) {
		super();
		this.specialization = specialization;
		this.experience = experience;
	}
	public WorkExperience() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String specialization;
	private int experience;
	
		

}
