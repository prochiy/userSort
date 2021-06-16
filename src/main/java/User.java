public class User implements Comparable{
    private String Name;
    private String Family;
    private String SecondName;
    private Integer age;
    private String passport;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getFamily() {
        return Family;
    }

    public void setFamily(String family) {
        Family = family;
    }

    public String getSecondName() {
        return SecondName;
    }

    public void setSecondName(String secondName) {
        SecondName = secondName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("user {");
        sb.append("Фамилия: ").append(getFamily()).append(",\n");
        sb.append("Имя: ").append(getName()).append(",\n");
        sb.append("Отчество: ").append(getSecondName()).append(",\n");
        sb.append("Возраст: ").append(getAge()).append(",\n");
        sb.append("Паспортные данные: ").append(getPassport()).append("}\n");
        return sb.toString();
    }

    @Override
    public int compareTo(Object o) {
        if(!(o instanceof User)){
            throw new IllegalArgumentException();
        }
        if (getAge() == null && ((User)o).getAge() == null) {
            return 0;
        }
        if (getAge() == null) {
            return -1;
        }
        if (((User)o).getAge() == null) {
            return 1;
        }
        return getAge().compareTo(((User)o).getAge());
    }
}
