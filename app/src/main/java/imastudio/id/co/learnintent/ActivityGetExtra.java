package imastudio.id.co.learnintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityGetExtra extends AppCompatActivity {

    TextView txtNama;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_extra);

        txtNama = (TextView)findViewById(R.id.txtHalo);

        Intent a1 = getIntent();
        //mengambil data yang sudah d put sebelum nya dengan variable nama
        String ambilNama = a1.getStringExtra("nama");

        //menampilkan nilai ke textview
        txtNama.setText("Hy, " + ambilNama);



    }
}
