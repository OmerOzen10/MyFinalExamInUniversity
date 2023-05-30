package vistula.oo.l11_ozen_58407_mid2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ConverterOO extends AppCompatActivity {

    private static final String File = "OmerOzen.txt";

    TextView txtNameOO, txtLastNameOO, txtTownOO;
    EditText edtTemp;
    TextView txtCelcius, txtFahrenheit, txtKelvin;
    Button btnConvert, btnMainMenu;
    Spinner spinnerOO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter_oo);

        txtNameOO = findViewById(R.id.txtNameOO);
        txtLastNameOO = findViewById(R.id.txtLastNameOO);
        txtTownOO = findViewById(R.id.txtTownOO);
        edtTemp = findViewById(R.id.edtTempOO);
        txtCelcius = findViewById(R.id.txtCelcius);
        txtFahrenheit = findViewById(R.id.txtFahrenheit);
        txtKelvin = findViewById(R.id.txtKelvin);
        btnConvert = findViewById(R.id.btnConvertOO);
        btnMainMenu = findViewById(R.id.btnMainMenu);
        spinnerOO = findViewById(R.id.spinnerOO);
        readFromFileOO();


        btnConvert.setOnClickListener(view -> {

            try {
                tempConvertOO();
            }catch (Exception e){
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void readFromFileOO(){
        String fileOO = WriteReadToolsOO.readFromFileOO(File,ConverterOO.this).trim();
        String[] initialOO = fileOO.split("&");

        if (initialOO.length==3){
            String name = initialOO[0];
            String lastName = initialOO[1];
            String town = initialOO[2];

            txtNameOO.setText(name);
            txtLastNameOO.setText(lastName);
            txtTownOO.setText(town);
        }
    }

    @SuppressLint("SetTextI18n")
    private void tempConvertOO(){
        double Temp = Double.parseDouble(edtTemp.getText().toString());

        if (spinnerOO.getSelectedItem().toString().equals("Celcius")){
            txtCelcius.setText(Double.toString(Temp));
            txtFahrenheit.setText(Double.toString(ConverterToolsOO.CtoF(Temp)));
            txtKelvin.setText(Double.toString(ConverterToolsOO.CtoK(Temp)));
        } else if (spinnerOO.getSelectedItem().toString().equals("Fahrenheit")) {
            txtCelcius.setText(Double.toString(ConverterToolsOO.FtoC(Temp)));
            txtFahrenheit.setText(Double.toString(Temp));
            txtKelvin.setText(Double.toString(ConverterToolsOO.FtoK(Temp)));
        } else if (spinnerOO.getSelectedItem().toString().equals("Kelvin")) {
            txtCelcius.setText(Double.toString(ConverterToolsOO.KtoC(Temp)));
            txtFahrenheit.setText(Double.toString(ConverterToolsOO.KtoF(Temp)));
            txtKelvin.setText(Double.toString(Temp));
        }
    }
}