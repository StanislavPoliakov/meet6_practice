package home.stanislavpoliakov.meet6_practice;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_3 extends Fragment {


    public Fragment_3() {
        // Required empty public constructor
    }

    public static Fragment_3 newInstance() {
        Fragment_3 fragment = new Fragment_3();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_3, container, false);
    }

}
