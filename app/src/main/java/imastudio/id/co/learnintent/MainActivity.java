package imastudio.id.co.learnintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnImplicit, btnExplicit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnImplicit = (Button)findViewById(R.id.btnImplicit);
        btnExplicit = (Button)findViewById(R.id.btnExplicit);


        //memanggil kelas ActivityImplicitIntent
        btnImplicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a1 = new Intent(getApplicationContext(), ActivityImplicitIntent.class);
                startActivity(a1);
            }
        });

        //memanggil class ActivityExplicitIntent
        btnExplicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a2 = new Intent(getApplicationContext(), ActivityExplicitIntent.class);
                startActivity(a2);
            }
        });
    }

}
