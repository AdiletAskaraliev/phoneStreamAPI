package db;

import model.Phone;

import java.util.List;

public class DataBase {
    private List<Phone> phones;

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public DataBase(List<Phone> phones) {
        this.phones = phones;
    }

    @Override
    public String toString() {
        return "DataBase " +
                "phones= " + phones;
    }
}
