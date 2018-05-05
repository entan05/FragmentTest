package jp.team.e_works.fragmenttest;

import android.app.FragmentTransaction;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;

/**
 * 親子関係にあるViewGroupへの複数Fragment
 */
public class FragmentTest05Activity extends AppCompatActivity {
    private FragmentTest mFragment01;
    private FragmentTest mFragment02;
    private FragmentTest mFragment03;
    private FragmentTest mFragment04;

    private CheckBox mClearCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_test05);

        mClearCheck = (CheckBox) findViewById(R.id.fragment_test05_isClear);

        ((Switch) findViewById(R.id.fragment_switch01)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                if (isChecked) {
                    mFragment01 = FragmentTest.createInstance(getName(buttonView.getId()), getFragmentColor(buttonView.getId()));
                    transaction.add(R.id.Fragment_test05_container01, mFragment01);
                } else if (mFragment01 != null) {
                    transaction.remove(mFragment01);
                    mFragment01 = null;
                }

                transaction.commit();
            }
        });

        ((Switch) findViewById(R.id.fragment_switch02)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                if (isChecked) {
                    mFragment02 = FragmentTest.createInstance(getName(buttonView.getId()), getFragmentColor(buttonView.getId()));
                    transaction.add(R.id.Fragment_test05_container02, mFragment02);
                } else if (mFragment02 != null) {
                    transaction.remove(mFragment02);
                    mFragment02 = null;
                }

                transaction.commit();
            }
        });

        ((Switch) findViewById(R.id.fragment_switch03)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                if (isChecked) {
                    mFragment03 = FragmentTest.createInstance(getName(buttonView.getId()), getFragmentColor(buttonView.getId()));
                    transaction.add(R.id.Fragment_test05_container03, mFragment03);
                } else if (mFragment03 != null) {
                    transaction.remove(mFragment03);
                    mFragment03 = null;
                }

                transaction.commit();
            }
        });

        ((Switch) findViewById(R.id.fragment_switch04)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                if (isChecked) {
                    mFragment04 = FragmentTest.createInstance(getName(buttonView.getId()), getFragmentColor(buttonView.getId()));
                    transaction.add(R.id.Fragment_test05_container04, mFragment04);
                } else if (mFragment04 != null) {
                    transaction.remove(mFragment04);
                    mFragment04 = null;
                }

                transaction.commit();
            }
        });
    }

    private String getName(int viewId) {
        String result;
        switch (viewId) {
            case R.id.fragment_switch01:
                result = "Fragment01";
                break;

            case R.id.fragment_switch02:
                result = "Fragment02";
                break;

            case R.id.fragment_switch03:
                result = "Fragment03";
                break;

            case R.id.fragment_switch04:
                result = "Fragment04";
                break;

            default:
                result = "";
                break;
        }
        return result;
    }

    private int getFragmentColor(int viewId) {
        int color;
        switch (viewId) {
            case R.id.fragment_switch01:
                color = 0xff1493;
                break;

            case R.id.fragment_switch02:
                color = 0x4169e1;
                break;

            case R.id.fragment_switch03:
                color = 0x228b22;
                break;

            case R.id.fragment_switch04:
                color = 0x4b0082;
                break;

            default:
                color = Color.TRANSPARENT;
                break;
        }
        if (mClearCheck.isChecked()) {
            color += 0x80000000;
        } else {
            color += 0xff000000;
        }
        return color;
    }
}
