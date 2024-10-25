package vn.edu.tlu.ex9;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ImageButton btn_play, btn_stop;
    Boolean flag = true;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_play = findViewById(R.id.btn_play);
        btn_stop = findViewById(R.id.btn_stop);
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, Myservice.class);
                startService(intent1);
                if (flag == true) {
                    btn_play.setImageResource(R.drawable.stop);
                    flag = false;
                } else {
                    btn_play.setImageResource(R.drawable.play);
                    flag = true;
                }
            }
        });
        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this, Myservice.class);
                stopService(intent2);
                btn_play.setImageResource(R.drawable.play);
            }
        });
    }
}