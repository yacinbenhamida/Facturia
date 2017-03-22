package application.facturia;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Inscription extends AppCompatActivity {
DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
<<<<<<< HEAD
    }



=======
            }

    public void signupBtnEvent(View v) {
        EditText nom = (EditText)findViewById(R.id.zoneNom);
        EditText mail = (EditText)findViewById(R.id.zoneMail);
        EditText pass = (EditText)findViewById(R.id.zonePass);

        String nomch = nom.getText().toString();
        String mailch = mail.getText().toString();
        String passch = pass.getText().toString();
        Contact c = new Contact(nomch,mailch,passch);
        helper.insertContact(c);
    }
>>>>>>> new
}



