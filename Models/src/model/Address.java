package model;

public class Address {
    private final String houseName;
    private final String aptNumber;
    private final String streetName;
    private final String city;
    private final String state;
    private final String country;

    private Address(Builder b) {
        this.houseName = b.houseName;
        this.aptNumber = b.aptNumber;
        this.streetName = b.streetName;
        this.city = b.city;
        this.state = b.state;
        this.country = b.country;
    }

    public String getHouseName() {
        return houseName;
    }

    public String getAptNumber() {
        return aptNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "houseName='" + houseName + '\'' +
                ", aptNumber='" + aptNumber + '\'' +
                ", streetName='" + streetName + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public static class Builder {
        private String houseName;
        private String aptNumber;
        private String streetName;
        private String city;
        private String state;
        private String country;

        public Builder houseName(String houseName) {
            this.houseName = houseName;
            return this;
        }
        public Builder aptNumber(String aptNumber) {
            this.aptNumber = aptNumber;
            return this;
        }
        public Builder streetName(String streetName) {
            this.streetName = streetName;
            return this;
        }
        public Builder city(String city) {
            this.city = city;
            return this;
        }
        public Builder state(String state) {
            this.state = state;
            return this;
        }
        public Builder country(String country) {
            this.country = country;
            return this;
        }

        public Address build(){
            return new Address(this);
        }
    }





}
