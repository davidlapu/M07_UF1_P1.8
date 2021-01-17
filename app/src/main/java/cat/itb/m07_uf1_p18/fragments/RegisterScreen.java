package cat.itb.m07_uf1_p18.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.textfield.TextInputEditText;

import cat.itb.m07_uf1_p18.R;

public class RegisterScreen extends Fragment {
    private TextInputEditText editTextUsername, editTextPassword, editTextRepeatPassword,
            editTextEmail, editTextName, editTextSurnames, editTextBirthDate;
    private TextInputEditText[] inputEditTexts;
    private MaterialCheckBox checkBoxTerms;
    private MaterialButton buttonRegister, buttonLogin;
    private AutoCompleteTextView textViewGender;

    public RegisterScreen() {
        // Required empty public constructor
    }

    public static RegisterScreen newInstance(String param1, String param2) {
        RegisterScreen fragment = new RegisterScreen();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_register_screen, container, false);

        editTextUsername = v.findViewById(R.id.RegisterUserName);
        editTextPassword = v.findViewById(R.id.registerPassword);
        editTextRepeatPassword = v.findViewById(R.id.registerRepeatPassword);
        editTextEmail = v.findViewById(R.id.registerEmail);
        editTextName = v.findViewById(R.id.registerName);
        editTextSurnames = v.findViewById(R.id.registerSurname);
        editTextBirthDate = v.findViewById(R.id.registerbirth);
        checkBoxTerms = v.findViewById(R.id.checkboxTerms);
        buttonLogin = v.findViewById(R.id.registerButtonLogin);
        buttonRegister = v.findViewById(R.id.registerButtonRegister);
        textViewGender = v.findViewById(R.id.registerGender);

        inputEditTexts = new TextInputEditText[]{editTextUsername, editTextPassword, editTextRepeatPassword,
                editTextEmail, editTextName, editTextSurnames, editTextBirthDate};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.support_simple_spinner_dropdown_item, new String[]{"Male", "Female"});
        textViewGender.setAdapter(adapter);

        for (TextInputEditText e :
                inputEditTexts) {
            e.setOnFocusChangeListener(this::editTextListener);
        }

        editTextPassword.setOnFocusChangeListener(this::passwordListener);
        buttonRegister.setOnClickListener(this::registerListener);
        buttonLogin.setOnClickListener(this::loginListener);

        return v;
    }

    private void loginListener(View view) {
        Navigation.findNavController(view).navigate(R.id.action_registerScreen_to_loginScreen);
    }

    private void registerListener(View view) {
        boolean allGood = true;

        for (TextInputEditText e :
                inputEditTexts) {
            if (e.getText().toString().isEmpty()) {
                allGood = false;
                e.setError(getString(R.string.required_field));
            }
        }

        if (!checkBoxTerms.isChecked()) {
            allGood = false;
        }

        if (editTextPassword.getText().toString().length() < 8 || editTextRepeatPassword.getText().toString().length() < 8) {
            allGood = false;
        }

        if (allGood) {
            Toast.makeText(getContext(), R.string.created, Toast.LENGTH_LONG).show();
            Navigation.findNavController(view).navigate(R.id.action_registerScreen_to_welcomeScreen);
        } else {
            Toast.makeText(getContext(), R.string.required_field, Toast.LENGTH_LONG).show();
        }

    }

    private void passwordListener(View view, boolean b) {
        TextInputEditText editText = (TextInputEditText) view;

        if (editText.getText().toString().length() < 8) {
            editText.setError(getString(R.string.must));
        } else {
            editText.setError(null);
        }
    }

    private void editTextListener(View view, boolean b) {
        TextInputEditText editText = (TextInputEditText) view;

        if (editText.getText().toString().isEmpty()) {
            editText.setError(getString(R.string.required_field));
        } else {
            editText.setError(null);
        }
    }

}