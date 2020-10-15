package ru.knastnt.kafkatest;

public class UserDTO {
    private String name;
    private int age;
    private Address address;

    public static UserDTO getTestInstance(){
        UserDTO u = new UserDTO();
        UserDTO.Address a = new UserDTO.Address();

        a.setStreet("Ленина");
        a.setHouse(16);

        u.setName("Иван");
        u.setAge(25);
        u.setAddress(a);

        return u;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public static class Address {
        private String street;
        private int house;

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public int getHouse() {
            return house;
        }

        public void setHouse(int house) {
            this.house = house;
        }
    }
}
