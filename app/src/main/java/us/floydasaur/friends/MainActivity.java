package us.floydasaur.friends;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText        editName, editPhoneNumber;
    private Button          buttonCreateContact;
    private ContactsManager contactsManager;
    private LinearLayout            contactList;
    private Context                 context;
    private int                     id;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName            = findViewById(R.id.edit_name);
        editPhoneNumber     = findViewById(R.id.edit_phone_number);
        buttonCreateContact = findViewById(R.id.buton_create_contact);
        contactsManager     = new ContactsManager();
        contactList        = findViewById(R.id.layout_linear_list);
        context             = this;

        buttonCreateContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  contactsManager.createContact(id, editName.getText().toString(), editPhoneNumber.getText().toString());
                  Log.i("CheckThis","new contact created");
                  contactList.addView(generateContactView(contactsManager.getContactName(id) + " - " + contactsManager.getContactNumber(id)));
                  Log.i("CheckThis", "id is " + id + " for " + editName.getText().toString());
                  id++;
                  clearEditBoxes();
            }
        });
    }

    private TextView generateContactView(String text){
        TextView contact = new TextView(context);
        contact.setText(text);
        return (contact);
    }

    private void clearEditBoxes(){
        editName.setText("");
        editPhoneNumber.setText("");
    }
}
