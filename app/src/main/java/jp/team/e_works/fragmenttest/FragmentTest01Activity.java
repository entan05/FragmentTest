package jp.team.e_works.fragmenttest;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

/**
 * 単一Fragment
 */
public class FragmentTest01Activity extends AppCompatActivity {
    FragmentTest mFragment01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_test01);

        final Switch switch01 = (Switch) findViewById(R.id.fragment_switch01);
        switch01.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                if (isChecked) {
                    mFragment01 = FragmentTest.createInstance("Fragment01", 0xffff1493);
                    transaction.add(R.id.Fragment_test01_container, mFragment01);
                } else if (mFragment01 != null) {
                    transaction.remove(mFragment01);
                    mFragment01 = null;
                }

                transaction.commit();
                switch01.setChecked(isChecked);
            }
        });

        // 使わないので非表示
        Switch switch02 = (Switch) findViewById(R.id.fragment_switch02);
        switch02.setVisibility(View.GONE);
        Switch switch03 = (Switch) findViewById(R.id.fragment_switch03);
        switch03.setVisibility(View.GONE);
        Switch switch04 = (Switch) findViewById(R.id.fragment_switch04);
        switch04.setVisibility(View.GONE);
    }
}
