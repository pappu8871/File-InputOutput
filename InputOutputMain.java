package com.inputoutput;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Main {
	String filePath = "D:\\inputoutput\\AddressBook.txt";
	public void writeObject(ArrayList<Object> listAddress) throws IOException {
		File file = new File(filePath);
		if (!file.exists()) {
			boolean isCreated = file.createNewFile();
			System.out.println(isCreated);
		}
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream objOutputStream = new ObjectOutputStream(fos);
		for (Object obj : listAddress) {

			objOutputStream.writeObject(obj);
			objOutputStream.reset();
		}
		objOutputStream.close();
	}

	public ArrayList<AddressBookUC13> readObject() throws ClassNotFoundException, IOException {
		ArrayList<AddressBookUC13> listAddress = new ArrayList<AddressBookUC13>();
		FileInputStream fis = new FileInputStream("D:\\inputoutput\\AddressBook.txt");
		ObjectInputStream obj = new ObjectInputStream(fis);
		try {
			while (fis.available() != -1) {
				AddressBookUC13 acc = (AddressBookUC13) obj.readObject();
				listAddress.add(acc);
			}
		} catch (EOFException ex) {
		}
		return listAddress;

	}
	public static void main(String[] args) throws ClassNotFoundException {

		try {
			ArrayList<Object> listAddress = new ArrayList<Object>();
			listAddress.add(new AddressBookUC13("Pappu", "kumar", "patna", "bihar", "8871312779"));
			listAddress.add(new AddressBookUC13("Rama", "kumar", "patna", "bihar", "98075151452"));
			listAddress.add(new AddressBookUC13("Ramu", "kumar", "patna", "bihar", "9931995657"));

			Main main = new Main();
			main.writeObject(listAddress);
			ArrayList<AddressBookUC13> listAddressBookUC13 = main.readObject();
			System.out.println("listisze:" + listAddressBookUC13.size());
			if (listAddressBookUC13.size() > 0) {
				for (AddressBookUC13 addressBookUC13 : listAddressBookUC13) {
					System.out.println(((AddressBookUC13)addressBookUC13).toString());
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
