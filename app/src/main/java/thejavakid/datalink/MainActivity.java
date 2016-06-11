package thejavakid.datalink;

import android.app.Notification;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<PackageInfo> Apps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Apps = this.getPackageManager().getInstalledPackages(PackageManager.GET_META_DATA);
        setContentView(R.layout.activity_main);
        final ListView appSelect = (ListView) this.findViewById(R.id.Apps);
        int i = 0;
        List<String> AdapterList = new ArrayList<String>();

        for (PackageInfo App : Apps) {
            if (App.packageName != null) {
                AdapterList.add(i, App.packageName);
                i++;
            } else {
                break;
            }
        }
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, AdapterList);
        try {
            appSelect.setAdapter(adapter);
        }catch (Exception e){
            e.printStackTrace();

        }
        assert appSelect != null;
        appSelect.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object listItem = adapter.getItem(position);
                Toast.makeText(view.getContext(), adapter.getItem(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
