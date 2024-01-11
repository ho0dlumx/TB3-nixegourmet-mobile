package com.example.project_application;

        import static java.util.logging.Level.SEVERE;

        import android.os.Bundle;
        import android.widget.Toast;

        import androidx.appcompat.app.AppCompatActivity;

        import com.example.project_application.R;
        import com.example.project_application.adapter.CustomerAPI;
        import com.example.project_application.adapter.Retrofitservice;
        import com.example.project_application.model.Customer;
        import com.google.android.material.button.MaterialButton;
        import com.google.android.material.textfield.TextInputEditText;

        import java.util.logging.Level;
        import java.util.logging.Logger;

        import retrofit2.Call;
        import retrofit2.Callback;
        import retrofit2.Response;

public class SignActivity  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        initializeComponents();


    }
//
    private void initializeComponents(){
        TextInputEditText inputEditTextPassword= findViewById(R.id.passaword);
        TextInputEditText inputEditTextName = findViewById(R.id.Name_sign);
        TextInputEditText inputEditTextAdress= findViewById(R.id.Adress);
        TextInputEditText inputEditTextPhone= findViewById(R.id.Phonenumber);
        TextInputEditText inputEditTextEmail= findViewById(R.id.email);
        MaterialButton buttonsave= findViewById(R.id.save);

        Retrofitservice retrofitservice= new Retrofitservice();
        buttonsave.setOnClickListener(view -> {
            String password= String.valueOf(inputEditTextPassword.getText());
            String name = String.valueOf(inputEditTextName.getText());
            String adress= String.valueOf(inputEditTextAdress.getText());
            String phone= String.valueOf(inputEditTextPhone.getText());
            String email= String.valueOf(inputEditTextEmail.getText());


            Customer customer = new Customer();
            customer.setName(name);
            customer.setAddress(adress);
            customer.setEmail(email);
            customer.setPassword(password);
            customer.setPhone(phone);

            CustomerAPI customerApi= retrofitservice.getRetrofit().create(CustomerAPI.class);

            customerApi.createCustomer(customer)
                    .enqueue(new Callback<Customer>() {
                        @Override
                        public void onResponse(Call<Customer> call, Response<Customer> response) {
                            Toast.makeText(SignActivity.this, "Save Sucessful!", Toast.LENGTH_SHORT).show();

                        }

                        @Override
                        public void onFailure(Call<Customer> call, Throwable t) {
                            Toast.makeText(SignActivity.this, "Save failed!", Toast.LENGTH_SHORT).show();
                            Logger.getLogger(SignActivity.class.getName()).log(SEVERE,"Error Ocurred",t);
                        }
                    });
        });
    }
}