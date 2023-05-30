package vistula.oo.l11_ozen_58407_mid2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MemoryActivityOO extends AppCompatActivity {

    EditText edtNameOO, edtLastNameOO;
    Spinner spinnerTownOO;
    TextView txtNameOO, txtLastNameOO, txtTownOO;
    Button saveToMemory, btnMain;

    private static final String File = "OmerOzen.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_oo);

        edtNameOO = findViewById(R.id.edtNameOO);
        edtLastNameOO = findViewById(R.id.edtLastNameOO);
        spinnerTownOO = findViewById(R.id.spinnerTownOO);
        txtNameOO = findViewById(R.id.txtNameOO);
        txtLastNameOO = findViewById(R.id.txtLastNameOO);
        txtTownOO = findViewById(R.id.txtTownOO);
        saveToMemory = findViewById(R.id.saveToMemoryOO);
        btnMain = findViewById(R.id.btnMainMenu);

        readFromFileOO();

        saveToMemory.setOnClickListener(view -> {
            String name = edtNameOO.getText().toString().trim();
            String lastName = edtLastNameOO.getText().toString().trim();
            String town = spinnerTownOO.getSelectedItem().toString();

            String initial = name+"&"+lastName+"&"+town;

            WriteReadToolsOO.writeToFileOO(File,initial,MemoryActivityOO.this);

            readFromFileOO();
        });

        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MemoryActivityOO.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }

    public void readFromFileOO(){
        String fileOO = WriteReadToolsOO.readFromFileOO(File,MemoryActivityOO.this).trim();
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