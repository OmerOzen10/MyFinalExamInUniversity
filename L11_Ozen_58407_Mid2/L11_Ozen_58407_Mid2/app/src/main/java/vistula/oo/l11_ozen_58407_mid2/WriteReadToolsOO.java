package vistula.oo.l11_ozen_58407_mid2;

import android.content.Context;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class WriteReadToolsOO {

    static void writeToFileOO(String file, String str, Context ctx ){
        try{
            FileOutputStream fileOutput = ctx.openFileOutput(file,ctx.MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(fileOutput);

            try{
                osw.write(str);
            }catch (IOException e){
                Toast.makeText(ctx, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
            osw.flush();
            osw.close();
        }catch (IOException e){
            Toast.makeText(ctx, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    static String readFromFileOO(String file, Context ctx){
        int readBlockSize = 100;

        try{
            FileInputStream fileInput = ctx.openFileInput(file);

            InputStreamReader isr = new InputStreamReader(fileInput);
            char[] inputBuffer = new char[readBlockSize];
            String str = "";
            int charRead;

            while ((charRead = isr.read(inputBuffer))>0){
                String readString = String.copyValueOf(inputBuffer,0,charRead);
                str += readString;
                inputBuffer = new char[readBlockSize];
            }
            return str;
        }catch (IOException e){
            Toast.makeText(ctx, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return file;
    }

}
