package imastudio.id.co.learnintent;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ActivityImplicitIntent extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4;

    String noTelp = "085364665287";

    //tambahkan permission
    private static final int PERMISSION_REQUEST_CODE = 1;

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

        //aksi sms
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dataIsiSMS = "Hallo, Ini adalah sms";
                //android permission 6.0
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {

                    if (checkSelfPermission(Manifest.permission.SEND_SMS)
                            == PackageManager.PERMISSION_DENIED) {

                        Log.d("permission", "permission denied to SEND_SMS - requesting it");
                        String[] permissions = {Manifest.permission.SEND_SMS};

                        requestPermissions(permissions, PERMISSION_REQUEST_CODE);

                    }
                }

                Intent intent = new Intent(getApplicationContext(), ActivityImplicitIntent.class);
                //tentang pendingintent
                //https://developer.android.com/reference/android/app/PendingIntent.html
                //fungsi dari pending intent adalah mengirimkan kode ke aplikasi lain
                PendingIntent pi = PendingIntent.getActivity(getApplicationContext(), 0, intent, 0);

                //memanggil library SMSManager dan memanggil string dataIsiSMS
                SmsManager sms = SmsManager.getDefault();
                sms.sendTextMessage(noTelp, null, dataIsiSMS, pi, null);

                Toast.makeText(getApplicationContext(), "SMS Berhasil dikirim", Toast.LENGTH_SHORT).show();
            }
        });


        //aksi email
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String  untuk pengiriman email
                String emailTujuan = "rizki@imastudio.co.id";
                String emailTujuan2 = "rizki@imastudio.co.id";
                String subjectEmail = "Haloooo";
                String isiEmail = "Ini isi email nya ya";

                //intent email
                Intent nEmail = new Intent(Intent.ACTION_SEND);
                nEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{emailTujuan, emailTujuan2});
                nEmail.putExtra(Intent.EXTRA_SUBJECT, subjectEmail);
                nEmail.putExtra(Intent.EXTRA_TEXT, isiEmail);

                //format kode untuk pengiriman email
                nEmail.setType("message/rfc822");
                startActivity(Intent.createChooser(nEmail, "Pilih email cliend"));
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //memanggil url
                String urlWeb = "http://www.google.co.id";
                //memanggil urlweb ketika intent
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlWeb));
                startActivity(intent);
            }
        });
    }
}
