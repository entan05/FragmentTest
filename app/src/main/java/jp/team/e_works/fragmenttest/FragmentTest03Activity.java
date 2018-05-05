package jp.team.e_works.fragmenttest;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;

/**
 * 単一のViewGroupに複数のFragment
 */
public class FragmentTest03Activity extends AppCompatActivity {
    private FragmentTest mFragment01;
    private FragmentTest mFragment02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_test03);

        final CheckBox clearCheck = (CheckBox)findViewById(R.id.fragment_test03_isClear);

        final Switch switch01 = (Switch)findViewById(R.id.fragment_switch01);
        switch01.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                if (isChecked) {
                    mFragment01 = FragmentTest.createInstance("Fragment01", clearCheck.isChecked() ? 0x80ff1493 : 0xffff1493);
                    transaction.add(R.id.Fragment_test03_container, mFragment01);
                } else if (mFragment01 != null) {
                    transaction.remove(mFragment01);
                    mFragment01 = null;
                }

                transaction.commit();
                switch01.setChecked(isChecked);
            }
        });

        final Switch switch02 = (Switch)findViewById(R.id.fragment_switch02);
        switch02.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                if (isChecked) {
                    mFragment02 = FragmentTest.createInstance("Fragment02", clearCheck.isChecked() ? 0x804169e1 : 0xff4169e1);
                    transaction.add(R.id.Fragment_test03_container, mFragment02);
                } else if (mFragment02 != null) {
                    transaction.remove(mFragment02);
                    mFragment02 = null;
                }

                transaction.commit();
                switch02.setChecked(isChecked);
            }
        });

        Switch switch03 = (Switch)findViewById(R.id.fragment_switch03);
        switch03.setVisibility(View.GONE);
        Switch switch04 = (Switch)findViewById(R.id.fragment_switch04);
        switch04.setVisibility(View.GONE);
    }
}
