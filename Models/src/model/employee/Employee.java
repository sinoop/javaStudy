package model.employee;

public class Employee {
    private final int empId;
    private final Name name;
    private final Address add;

    private Employee(Builder b) {
        this.empId = b.empId;
        this.name = b.name;
        this.add = b.add;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + empId;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return this.empId == ((Employee) obj).empId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", name=" + name +
                ", add=" + add +
                '}';
    }

    public int getEmpId() {
        return empId;
    }

    public Name getName() {
        return name;
    }

    public Address getAdd() {
        return add;
    }

    static public class Builder {
        private int empId;
        private Name name;
        private Address add;

        public Builder empId(final int id) {
            this.empId = id;
            return this;
        }

        public Builder name(final Name name) {
            this.name = name;
            return this;
        }

        public Builder address(final Address address) {
            this.add = address;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }

}
