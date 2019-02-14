package example.api.zhaojie.preferencedemo;

import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends PreferenceActivity {
    private boolean isClick = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        addPreferencesFromResource(R.xml.preference);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Preference mPreference = getPreferenceScreen().findPreference(getResources().getString(R.string.preference_key));
        mPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                if(isClick) {
                    preference.setSummary("++++++++++++++");
                    isClick = false;
                } else {
                    preference.setSummary("--------------");
                    isClick = true;
                }
                return false;
            }
        });

    }
}
