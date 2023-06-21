package service.serviceImpl;

import db.DataBase;
import model.Phone;
import service.PhoneService;

import java.util.List;
import java.util.Optional;

public class PhoneServiceImpl implements PhoneService {

    private DataBase dataBase;

    public PhoneServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public String addPhone(Phone phone) {
        dataBase.getPhones().add(phone);
        return "Phone add successfully : " + phone.toString();
    }

    @Override
    public Phone getPhoneById(int phoneId) {
        List<Phone> phones = dataBase.getPhones();
        Optional<Phone> optionalPhone = phones.stream()
                .filter(phone -> phone.getId() == phoneId)
                .findFirst();


        return optionalPhone.orElse(null);
    }

    @Override
    public Phone updatePhoneNameById(int phoneId, String newName) {
        List<Phone> phones = dataBase.getPhones();
        Optional<Phone> optionalPhone = phones.stream()
                        .filter(phone -> phone.getId() == phoneId)
                                .findFirst();
        optionalPhone.ifPresent(phone -> phone.setName(newName));
        return optionalPhone.orElse(null);
    }

    @Override
    public List<Phone> getAllPhones() {
        List<Phone> phones = dataBase.getPhones();

        return phones;
    }

    @Override
    public List<Phone> getAllPhonesByBrand(String brand) {
        List<Phone> phones = dataBase.getPhones();
        phones.stream().filter(phone -> phone.getBrand() == brand).forEach(System.out::println);

        return null;
    }

    @Override
    public void deletePhoneById(int phoneId) {
        List<Phone> phoneList = dataBase.getPhones();
        phoneList.removeIf(phone -> phone.getId()==phoneId);
        System.out.println("Deleted!!!!!");
    }
}
