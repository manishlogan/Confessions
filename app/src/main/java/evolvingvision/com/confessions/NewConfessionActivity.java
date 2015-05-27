package evolvingvision.com.confessions;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;

import java.util.HashMap;
import java.util.Map;


public class NewConfessionActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_confession);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_confession, menu);
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

    public void submitConfession(View view){
        Firebase confessionFirebase = new Firebase("https://confessionsdummy.firebaseio.com/");
        Map<String,String> data = new HashMap<String,String>();
        EditText titleText = (EditText)this.findViewById(R.id.newConfessionTitle);
        String title = titleText.getText().toString();

        EditText descriptionText = (EditText)this.findViewById(R.id.newConfessionDescription);
        String description = descriptionText.getText().toString();
        data.put("title",title);
        data.put("description",description);
        confessionFirebase.child("confession").push().setValue(data);
        Toast.makeText(this,"Confession submitted successfully",Toast.LENGTH_LONG).show();
        finish();
    }
}
