package ua.khpi.oop.abdullin07;

public class WorkExperience {
	private String specialization;
	private int experience;
	
	public WorkExperience (String specialization, int experience)
	{
		this.specialization = specialization;
		this.experience = experience;
	}
	
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
}
