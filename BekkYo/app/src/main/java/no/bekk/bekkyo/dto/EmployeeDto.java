package no.bekk.bekkyo.dto;

public class EmployeeDto {

    private String Name;
    private String MobilePhone;
    private String Email;
    private String Gender;
    private String Department;
    private String Seniority;
    private String PracticeGroup;
    private String Id;

    public String getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getMobilePhone() {
        return MobilePhone;
    }

    public String getEmail() {
        return Email;
    }

    public String getGender() {
        return Gender;
    }

    public String getDepartment() {
        return Department;
    }

    public String getSeniority() {
        return Seniority;
    }

    public String getPracticeGroup() {
        return PracticeGroup;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setMobilePhone(String mobilePhone) {
        this.MobilePhone = mobilePhone;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public void setGender(String gender) {
        this.Gender = gender;
    }

    public void setDepartment(String department) {
        this.Department = department;
    }

    public void setSeniority(String seniority) {
        this.Seniority = seniority;
    }

    public void setPracticeGroup(String practiceGroup) {
        this.PracticeGroup = practiceGroup;
    }

    public void setId(String id) {
        this.Id = id;
    }
}
