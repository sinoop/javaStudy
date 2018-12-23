package model.employee;

public class Name {
    private final String fname;

    @Override
    public String toString() {
        return "Name{" +
                "fname='" + fname + '\'' +
                ", mname='" + mname + '\'' +
                ", lname='" + lname + '\'' +
                '}';
    }

    private final String mname;
    private final String lname;

    public Name(Builder b) {
        this.fname = b.fname;
        this.mname = b.mname;
        this.lname = b.lname;
    }
    public String getFname() {
        return fname;
    }
    public String getMname() {
        return mname;
    }
    public String getLname() {
        return lname;
    }

    public static class Builder {
        private String fname;
        private String mname;
        private String lname;

        public Builder fname(String fname) {
            this.fname = fname;
            return this;
        }
        public Builder mname(String mname) {
            this.mname = mname;
            return this;
        }
        public Builder lname(String lname) {
            this.lname = lname;
            return this;
        }

        public Name build(){
            return new Name(this);
        }
    }
}
