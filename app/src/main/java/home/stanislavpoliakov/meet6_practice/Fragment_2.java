package home.stanislavpoliakov.meet6_practice;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment_2 extends Fragment {
    private final String LOG_TAG = "meet6_logs";

    public static Fragment_2 newInstance() {
        Fragment_2 fragment = new Fragment_2();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(LOG_TAG, "Fragment 2: Button Clicked");
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.layout_for_fragment_2, Fragment_3.newInstance())
                        .addToBackStack(null)
                        .commit();
            }
        });
    }
}
