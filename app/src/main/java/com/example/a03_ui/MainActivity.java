package com.example.a03_ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void onButtonClick(View view) {
        // Button
        TextView text1 = (TextView) findViewById(R.id.text1);
        int id = view.getId();
        /*
            Android Gardle 8.0.0 부터는 switch문에 R.id.~가 더이상 선언되지 않음
            따라서 if문으로 바꿔서 해결(switch문 앞에 커서를 두고 alt+anter)
            다른 방법으로는 사용할 값을 final로 선언해야 하는데 개발자는 R.java를 임의로 건들 수 없으므로 위의 방법 추천
        */
        if (id == R.id.button1) {
            text1.setText("hello");
        } else if (id == R.id.button2) {
            text1.setText("world");
        }

        // EditText
        TextView edit = (EditText) findViewById(R.id.edit);
        String str = edit.getText().toString();
        /*
            Toast 메세지
            사용자에게 짧은 메시지 형식으로 정보를 전달하는 팝업
            메시지를 표시할 공간만 차지하고 시간이 지나면 자동으로 사라지는 메시지
            메시지에 대한 사용자의 응답을 필요하지 않고 단순히 사용자에게 정보를 전달할 용도로 많이 사용
            형식 : Toast.makeText(현재 프로세스의 Context 정보, 사용자에게 보여줄 문자열, Toast 메시지를 화면에 띄우는 시간)
        */
        Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();

        // Switch
        Switch switch1 = (Switch) findViewById(R.id.switch1);
        TextView textResult = (TextView) findViewById(R.id.textResult);
        if (id == R.id.switch_button) {
            if (switch1.isChecked()) textResult.setText("Swtich On");
            else textResult.setText("Swtich Off");
        }

    }

}