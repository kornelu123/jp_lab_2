package org.example;

import javax.swing.*;
import java.util.HashSet;

public class ContactSet {
    private static HashSet<Contact> contacts = new HashSet<>();

    public static void addToSet(String name, String num, String mail){
        Contact con = new Contact(name,num,mail);
        contacts.add(con);
    }

    public static boolean deleteFromSet(String name, String num, String mail){
        Contact con = new Contact(name,num, mail);

        if(contacts.contains(con)){
            contacts.remove(con);
            return true;
        }
        return false;
    }
    public static boolean edit(String oldName, String newName, String oldNum, String newNum, String oldMail, String newMail){
        if(!deleteFromSet(oldName, oldNum, oldMail)){
            return false;
        }
        addToSet(newName,newName,newNum);
        return true;
    }
}
