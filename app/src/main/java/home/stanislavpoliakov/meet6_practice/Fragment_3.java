package home.stanislavpoliakov.meet6_practice;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

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
        return inflater.inflate(R.layout.fragment_3, container, false);
    }

    /**
     * Любопытный момент! Так как первый фрагмент статичен, получается, что он принадлежит Activity,
     * то есть ее ContentView. А значит и добраться до элементов первого фрагмента мы можем, как если бы это были
     * элементы Activity - это первый вариант!
     *
     * Второй вариант - добываем элемент первого фрагмента через SupportFragmentManager
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView = view.findViewById(R.id.textView);

        //Первый вариант - получаем EditText из первого фрагмента, как элемент Activity (из-за статического
        //определения фрагмента
        EditText editText_from_static_fragment = getActivity().findViewById(R.id.editText);


        //Второй вариант - получаем EditText через менеджер фрагментов

        //Fragment static_fragment = getActivity().getSupportFragmentManager().findFragmentById(R.id.fragment_1);
        //editText_from_static_fragment = static_fragment.getView().findViewById(R.id.editText);


        //И меняем текст в textView
        textView.setText(editText_from_static_fragment.getText());
    }
}
