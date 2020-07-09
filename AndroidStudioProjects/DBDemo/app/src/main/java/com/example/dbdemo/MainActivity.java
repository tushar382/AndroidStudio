package com.example.dbdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.dbdemo.data.MyDbHandler;
import com.example.dbdemo.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyDbHandler db = new MyDbHandler(MainActivity.this);

       // Creating a contact object for db
        Contact tushar = new Contact();
        tushar.setPhoneNumber("8291418275");
        tushar.setName("Tushar");

        // Adding contact in db
        db.addContact(tushar);

        // Creating a contact object for db
        Contact komal = new Contact();
        komal.setPhoneNumber("9137948146");
        komal.setName("Komal");
        // Adding contact in db
        db.addContact(komal);

        // Creating a contact object for db
        Contact dad = new Contact();
        dad.setPhoneNumber("8108990378");
        dad.setName("Dad");

        // Adding contact in db
        db.addContact(dad);
        Log.d("dbtushar", "ID for Komal and Dad are successfully added.");


        dad.setId(46);
        dad.setName("Changed dad");
        dad.setPhoneNumber("1234567890");
        int affectedRows = db.updateContact(dad);

        Log.d("dbtushar", "No of affected rows are: " + affectedRows);
        db.deleteContactById(7);
       db.deleteContactById(12);
        db.deleteContactById(5);


        ArrayList<String> contacts = new ArrayList<>();
        listView = findViewById(R.id.listView);



        // get all contacts
        List<Contact> allContacts = db.getAllContacts();
        for (Contact contact : allContacts) {
            Log.d("dbtushar", "ID:" + contact.getId() + "\n" +
                    "Name:" + contact.getName() + "\n" +
                    "Phone Number:" + contact.getPhoneNumber() + "\n");

            contacts.add(contact.getName() + "(" + contact.getPhoneNumber() + ")");
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,contacts);
        listView.setAdapter(arrayAdapter);

        Log.d("dbtushar", "Bro you have " + db.getCount() + "contacts in your database");
    }
}
