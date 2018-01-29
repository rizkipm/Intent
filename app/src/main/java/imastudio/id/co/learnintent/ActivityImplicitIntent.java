package imastudio.id.co.learnintent;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityImplicitIntent extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4;

    String noTelp = "085364665287";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);

        btn1 = (Button) findViewById(R.id.btnPhoneCell);
        btn2 = (Button) findViewById(R.id.btnSendEmail);
        btn3 = (Button) findViewById(R.id.btnSendSMS);
        btn4 = (Button) findViewById(R.id.btnViewUrl);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //aksi ketika tombol btnPhoneCell d pencet

                //intent implicit ke no telp
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + noTelp));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
    }
}
