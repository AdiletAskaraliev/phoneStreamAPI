import db.DataBase;
import model.Contact;
import model.Phone;
import service.serviceImpl.ContactServiceImpl;
import service.serviceImpl.PhoneServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Phone> phoneList = new ArrayList<>();
        DataBase dataBase = new DataBase(phoneList);
        ContactServiceImpl contactService = new ContactServiceImpl(dataBase);
        PhoneServiceImpl phoneService = new PhoneServiceImpl(dataBase);

        while (true){
            int san = new Scanner(System.in).nextInt();
            switch (san){
                case 1:
                    System.out.println(phoneService.addPhone(new Phone(1, "iPhone 12", "Apple")));
                    System.out.println(phoneService.addPhone(new Phone(2, "Redmi Note 11", "MI")));
                    System.out.println(phoneService.addPhone(new Phone(3, "Samsung Galaxy S23", "Samsung")));
                    System.out.println(phoneService.addPhone(new Phone(4, "6300", "Nokia")));
                    break;
                case 2:
                    System.out.println(phoneService.getPhoneById(4));
                    break;
                case 3:
                    System.out.println(phoneService.updatePhoneNameById(2, "Redmi 10"));
                    break;
                case 4:
                    System.out.println(phoneService.getAllPhones());
                    break;
                case 5:
                    System.out.println(phoneService.getAllPhonesByBrand("Apple"));
                    break;
                case 6:
                    phoneService.deletePhoneById(3);
                    break;
                case 7:
                    System.out.println(contactService.addContactToPhone(1, new Contact("Messi", "996550191030")));
                    System.out.println(contactService.addContactToPhone(1, new Contact("Xavi", "996550191030")));
                    System.out.println(contactService.addContactToPhone(1, new Contact("Pedro", "996550191030")));
                    System.out.println(contactService.addContactToPhone(2, new Contact("Ronaldo", "996777777777")));
                    System.out.println(contactService.addContactToPhone(2, new Contact("Ozil", "996777777777")));
                    System.out.println(contactService.addContactToPhone(2, new Contact("Marcelo", "996777777777")));
                    System.out.println(contactService.addContactToPhone(3, new Contact("Neymar", "996700101117")));
                    System.out.println(contactService.addContactToPhone(4, new Contact("Mbappe", "996555291007")));
                    break;
                case 8:
                    System.out.println(contactService.findContactByName(2, "Ronaldo"));
                    break;
                case 9:
                    System.out.println(contactService.findContactByPhoneNumber(1, "996550191030"));
                    break;
                case 10:
                    System.out.println(contactService.sortContactsByName(2));
                    break;
                case 11:
                    contactService.deleteContactByNameFromPhone(3, "Neymar");
                    break;
                default:
                    break;

            }
        }

    }
}