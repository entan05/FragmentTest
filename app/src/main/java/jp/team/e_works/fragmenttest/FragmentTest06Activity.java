package jp.team.e_works.fragmenttest;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.transition.TransitionSet;
import android.view.Gravity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

/**
 * アニメーション
 */
public class FragmentTest06Activity extends AppCompatActivity {
    private FragmentTest mFragment01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_test06);

        ((Switch)findViewById(R.id.fragment_switch01)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                if (isChecked) {
                    mFragment01 = FragmentTest.createInstance("Fragment01", 0xffff1493);

                    TransitionSet ts = new TransitionSet();
                    ts.addTransition(new Slide(Gravity.RIGHT));

                    mFragment01.setEnterTransition(ts);

                    transaction.add(R.id.Fragment_test06_container, mFragment01);
                } else if (mFragment01 != null) {
                    transaction.remove(mFragment01);
                    mFragment01 = null;
                }

                transaction.commit();
            }
        });

        findViewById(R.id.fragment_switch02).setVisibility(View.GONE);
        findViewById(R.id.fragment_switch03).setVisibility(View.GONE);
        findViewById(R.id.fragment_switch04).setVisibility(View.GONE);
    }
}
