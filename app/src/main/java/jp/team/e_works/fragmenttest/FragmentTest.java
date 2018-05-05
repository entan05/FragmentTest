package jp.team.e_works.fragmenttest;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.CheckResult;
import android.support.annotation.ColorInt;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * fragment
 */
public class FragmentTest extends Fragment {
    private static final String TAG = "FragmentTest";

    private static final String KEY_NAME = "name";
    private static final String KEY_COLOR = "color";

    private String mName;
    private @ColorInt
    int mColor;

    @CheckResult
    public static FragmentTest createInstance(String name, @ColorInt int color) {
        FragmentTest fragment = new FragmentTest();

        Bundle args = new Bundle();
        args.putString(KEY_NAME, name);
        args.putInt(KEY_COLOR, color);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();
        if (args != null) {
            mName = args.getString(KEY_NAME, "");
            mColor = args.getInt(KEY_COLOR, Color.TRANSPARENT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_layout, container, false);

        view.setBackgroundColor(mColor);
        ((TextView) view.findViewById(R.id.fragment_text)).setText(mName);

        Log.d(TAG, Integer.toHexString(mColor));

        return view;
    }
}
