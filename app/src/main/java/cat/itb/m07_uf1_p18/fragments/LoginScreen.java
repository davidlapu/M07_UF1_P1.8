package cat.itb.m07_uf1_p18.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import cat.itb.m07_uf1_p18.R;

public class LoginScreen extends Fragment {
    TextInputEditText editTextName, editTextPassword;
    MaterialButton loginButton, registerButton;

    public LoginScreen() {
    }

    public static LoginScreen newInstance() {
        LoginScreen fragment = new LoginScreen();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_login_screen, container, false);

        editTextName = v.findViewById(R.id.editTextUserName);
        editTextPassword = v.findViewById(R.id.editTextPassword);
        loginButton = v.findViewById(R.id.loginButtonLogin);
        registerButton = v.findViewById(R.id.loginButtonRegister);

        loginButton.setOnClickListener(this::loginClicked);
        registerButton.setOnClickListener(this::registerClicked);

        return v;
    }

    private void registerClicked(View view) {
        Navigation.findNavController(view).navigate(R.id.action_loginScreen_to_registerScreen);
    }

    private void loginClicked(View view) {
        boolean allGood = true;
        if (editTextName.getText().toString().isEmpty()) {
            editTextName.setError(getString(R.string.required_field));
            allGood = false;
        } else {
            editTextName.setError(null);
        }

        if (editTextPassword.getText().toString().length() < 8) {
            editTextPassword.setError(getString(R.string.must));
            allGood = false;
        } else {
            editTextPassword.setError(null);
        }

        if (allGood) {
            Navigation.findNavController(view).navigate(R.id.action_loginScreen_to_welcomeScreen);
        }

    }


}