package service.serviceImpl;

import db.DataBase;
import model.Contact;
import model.Phone;
import service.ContactService;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class ContactServiceImpl implements ContactService {

    private DataBase dataBase;

    public ContactServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public String addContactToPhone(int phoneId, Contact contact) {
        dataBase.getPhones().stream()
                .filter(phone -> phone.getId() == phoneId)
                .forEach(phone -> phone.setContact(contact));
        return "Successfully added";
    }

    @Override
    public Contact findContactByName(int phoneId, String contactName) {
        List<Phone> phones = dataBase.getPhones();
        Optional<Contact> optionalContact = phones.stream()
                .filter(phone -> phone.getId() == phoneId)
                .flatMap(phone -> phone.getContacts().stream())
                .filter(contact -> Objects.equals(contact.getName(), contactName))
                .findFirst();


        return optionalContact.orElse(null);
    }

    @Override
    public Contact findContactByPhoneNumber(int phoneId, String phoneNumber) {
        List<Phone> phones = dataBase.getPhones();
        Optional<Contact> optionalContact = phones.stream()
                .filter(phone -> phone.getId() == phoneId)
                .flatMap(phone -> phone.getContacts().stream())
                .filter(contact -> contact.getPhoneNumber().equals(phoneNumber))
                .findFirst();

        return optionalContact.orElse(null);
    }

    @Override
    public List<Contact> sortContactsByName(int phoneId) {
        List<Phone> phones = dataBase.getPhones();
        List<Contact> sortedContacts = phones.stream()
                .filter(phone -> phone.getId() == phoneId)
                .flatMap(phone -> phone.getContacts().stream())
                .sorted(Comparator.comparing(Contact::getName))
                .collect(Collectors.toList());

        return sortedContacts;
    }

    @Override
    public void deleteContactByNameFromPhone(int phoneId, String contactName) {
        List<Phone> phones = dataBase.getPhones();
        for (int i = 0; i < phones.size(); i++) {
            if (phones.get(i).getId()==phoneId && phones.get(i).getName().equals(contactName)){
                System.out.println(phones.get(i) == null);
            }
        }
    }
}
