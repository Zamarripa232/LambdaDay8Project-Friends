package us.floydasaur.friends;

import java.util.ArrayList;

public class ContactsManager {
    private ArrayList<Contact> contacts;

    public ContactsManager() {
        this.contacts = new ArrayList<>();
    }

    public void createContact(int id, String name, String phoneNumber){
        Contact contact = new Contact(id, name, phoneNumber);
        this.contacts.add(contact);
    }

    public String getContactName(int id) {
        return this.contacts.get(id).getName();
    }

    public String getContactNumber(int id) {
        return this.contacts.get(id).getPhoneNumber();
    }
}
