package cat.itb.m07_uf1_p18.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.button.MaterialButton;

import cat.itb.m07_uf1_p18.R;

public class HomeScreen extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_screen, container, false);

        MaterialButton buttonLogin = view.findViewById(R.id.homeButtonLogin),
                buttonRegister = view.findViewById(R.id.homeButtonRegister);

        buttonLogin.setOnClickListener(this::loginClicked);
        buttonRegister.setOnClickListener(this::registerClicked);

        return view;
    }

    private void loginClicked(View view) {
        Navigation.findNavController(view).navigate(R.id.action_homeScreen_to_loginScreen);
    }

    private void registerClicked(View view) {
        Navigation.findNavController(view).navigate(R.id.action_homeScreen_to_registerScreen);
    }
}
