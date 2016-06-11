package thejavakid.datalink;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        TextView appname = (TextView)this.findViewById(R.id.appname);
        Bundle b = getIntent().getExtras();
        String value = "";
        if(b != null)
        value = b.getString("app");
        assert appname != null;
        appname.setText(value);
    }
}
