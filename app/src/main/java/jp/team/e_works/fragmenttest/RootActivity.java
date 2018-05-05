package jp.team.e_works.fragmenttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RootActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root);

        findViewById(R.id.root2test01).setOnClickListener(this);
        findViewById(R.id.root2test02).setOnClickListener(this);
        findViewById(R.id.root2Test03).setOnClickListener(this);
        findViewById(R.id.root2test04).setOnClickListener(this);
        findViewById(R.id.root2test05).setOnClickListener(this);
        findViewById(R.id.root2test06).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.root2test01:
                intent = new Intent(RootActivity.this, FragmentTest01Activity.class);
                break;

            case R.id.root2test02:
                intent = new Intent(RootActivity.this, FragmentTest02Activity.class);
                break;

            case R.id.root2Test03:
                intent = new Intent(RootActivity.this, FragmentTest03Activity.class);
                break;

            case R.id.root2test04:
                intent = new Intent(RootActivity.this, FragmentTest04Activity.class);
                break;

            case R.id.root2test05:
                intent = new Intent(RootActivity.this, FragmentTest05Activity.class);
                break;

            case R.id.root2test06:
                intent = new Intent(RootActivity.this, FragmentTest06Activity.class);
                break;

            default:
                intent = null;
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }
}
