package vistula.oo.l11_ozen_58407_mid2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageActivityOO extends AppCompatActivity {


    private static final String File = "OmerOzen.txt";

    TextView txtNameOO, txtLastNameOO, txtTownOO;

    ImageView imgMainOO, imgConverterOO, imgMemoryOO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_oo);

        txtNameOO = findViewById(R.id.txtNameOO);
        txtLastNameOO = findViewById(R.id.txtLastNameOO);
        txtTownOO = findViewById(R.id.txtTownOO);

        imgMainOO = findViewById(R.id.imgMainOO);
        imgConverterOO = findViewById(R.id.imgCalculatorOO);
        imgMemoryOO = findViewById(R.id.imgMemoryOO);

        readFromFileOO();


        imgMainOO.setOnClickListener(view -> {
            Intent intent = new Intent(ImageActivityOO.this,MainActivity.class);
            startActivity(intent);
        });

        imgConverterOO.setOnClickListener(view -> {
            Intent intent = new Intent(ImageActivityOO.this,ConverterOO.class);
            startActivity(intent);
        });

        imgMemoryOO.setOnClickListener(view -> {
            Intent intent = new Intent(ImageActivityOO.this,MemoryActivityOO.class);
            startActivity(intent);
        });

    }

    public void readFromFileOO(){
        String fileOO = WriteReadToolsOO.readFromFileOO(File,ImageActivityOO.this).trim();
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