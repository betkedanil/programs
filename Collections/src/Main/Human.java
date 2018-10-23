package Main;

public class Human {
    private String firstName;
    private String lastName;
    private String middleName;
    private int age;

    public Human() {
        super();
    }

    public Human(String firstName, String lastName, String middleName, int age) {
        setFirstName(firstName);
        setLastName(lastName);
        setMiddleName(middleName);
        setAge(age);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Human human = (Human) o;

        if (age != human.age) return false;
        if (firstName != null ? !firstName.equals(human.firstName) : human.firstName != null) return false;
        if (lastName != null ? !lastName.equals(human.lastName) : human.lastName != null) return false;
        return middleName != null ? middleName.equals(human.middleName) : human.middleName == null;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
        result = 31 * result + age;
        return result;
    }
}
