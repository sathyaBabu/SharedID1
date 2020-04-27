package sathya.sharedid.sharedid1;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button   buttonSave ;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView)findViewById(R.id.textView2);

    }

    public void SaveToFile(View view) {

        File file ;
        FileOutputStream fileOutputStream ;
        String str = editText.getText().toString();

        file = getFilesDir();
        try {
            fileOutputStream = openFileOutput("Sathya.txt", Context.MODE_PRIVATE);
            fileOutputStream.write(str.getBytes());
            textView.setTextColor(Color.BLUE);
            textView.setText(str+"\n Wrote Data to \n"+file.getAbsolutePath());
        } catch (FileNotFoundException e) {
            textView.setTextColor(Color.RED);
            textView.setText(e.toString());

        } catch (IOException e) {

            textView.setTextColor(Color.RED);
            textView.setText(e.toString());
        }


    }
}
