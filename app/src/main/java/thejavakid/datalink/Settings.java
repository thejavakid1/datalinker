package thejavakid.datalink;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        TextView appname = (TextView)this.findViewById(R.id.appname);
        Bundle b = getIntent().getExtras();
        String value = ""; // or other values
        if(b != null)
        value = b.getString("app");
        appname.setText(value);
        Toast.makeText(this, value, Toast.LENGTH_LONG).show();
    }
}
