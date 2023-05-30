package vistula.oo.l11_ozen_58407_mid2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtNameOO, edtLastNameOO;
    Spinner spinnerTownOO;
    ImageView imgOO;
    TextView txtNameOO, txtLastNameOO, txtTownOO;
    Button saveToMemory, goToImg;
    private static final String File = "OmerOzen.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edtNameOO = findViewById(R.id.edtNameOO);
        edtLastNameOO = findViewById(R.id.edtLastNameOO);
        spinnerTownOO = findViewById(R.id.spinnerTownOO);
        imgOO = findViewById(R.id.imgViewOO);
        txtNameOO = findViewById(R.id.txtNameOO);
        txtLastNameOO = findViewById(R.id.txtLastNameOO);
        txtTownOO = findViewById(R.id.txtTownOO);
        saveToMemory = findViewById(R.id.saveToMemoryOO);
        goToImg = findViewById(R.id.goToImgOO);



        readFromFileOO();

        spinnerTownOO.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (spinnerTownOO.getSelectedItem().toString().equals("Warsaw")){
                    imgOO.setImageResource(R.drawable.image);
                } else if (spinnerTownOO.getSelectedItem().toString().equals("Istanbul")) {
                    imgOO.setImageResource(R.drawable.istanbul);
                }else if (spinnerTownOO.getSelectedItem().toString().equals("Berlin")){
                    imgOO.setImageResource(R.drawable.berlin);
                } else if (spinnerTownOO.getSelectedItem().toString().equals("Amsterdam")) {
                    imgOO.setImageResource(R.drawable.amsterdam);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        saveToMemory.setOnClickListener(view -> {
            String name = edtNameOO.getText().toString().trim();
            String lastName = edtLastNameOO.getText().toString().trim();
            String town = spinnerTownOO.getSelectedItem().toString();

            String initial = name+"&"+lastName+"&"+town;

            WriteReadToolsOO.writeToFileOO(File,initial,MainActivity.this);

            readFromFileOO();
        });

        goToImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ImageActivityOO.class);
                startActivity(intent);
            }
        });
    }

    public void readFromFileOO(){
        String fileOO = WriteReadToolsOO.readFromFileOO(File,MainActivity.this).trim();
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
}