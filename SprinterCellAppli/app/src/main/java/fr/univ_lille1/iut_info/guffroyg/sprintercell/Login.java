package fr.univ_lille1.iut_info.guffroyg.sprintercell;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void loginMember(View view){
        String pseudo = ((EditText)findViewById(R.id.etPseudo)).getText().toString();
        String password = ((EditText)findViewById(R.id.etPassword)).getText().toString();
        if(pseudo!=null && password!=null){
            Member m = new Member(pseudo, null, password);
            if (this.login(m)){
                doLog(view);
            }
            else{
                Toast.makeText(getApplicationContext(), "Bad Connexion", Toast.LENGTH_LONG).show();
            }
        } else{
            Toast.makeText(getApplicationContext(), "Please fill the form, don't leave any field blank", Toast.LENGTH_LONG).show();
        }
    }


    public Boolean login (Member member) {
        Entity<Member> memberEntity = Entity.entity(member, MediaType.APPLICATION_JSON);

        return ClientBuilder.newClient()
                .target("http://37.59.171.4/v1/memberdb/login")
                .request()
                .post(memberEntity)
                .readEntity(Boolean.class);
    }

    public void doLog(View view){
       Intent intent = new Intent(Login.this,CreerProjet.class);
       startActivity(intent);

    }
}
