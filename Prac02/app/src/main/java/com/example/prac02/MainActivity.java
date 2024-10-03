package com.example.prac02;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {
    private EmployeeViewModel employeeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Khởi tạo ViewModel
        employeeViewModel = new ViewModelProvider(this).get(EmployeeViewModel.class);

        // Khai báo các View
        EditText etEmployeeId = findViewById(R.id.etEmployeeID);
        EditText etEmployeeName = findViewById(R.id.etEmployeeName);
        EditText etEmployeeBirth = findViewById(R.id.etEmployeeBirth);
        EditText etEmployeeSalary = findViewById(R.id.etEmployeeSalary);
        Button btnUpdate = findViewById(R.id.btnUpdate);
        TextView tvEmployeeInfo = findViewById(R.id.tvEmployeeInfo);

        // Khi nhấn nút "Update", thêm dữ liệu mới vào TextView
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = etEmployeeId.getText().toString();
                String name = etEmployeeName.getText().toString();
                String birth = etEmployeeBirth.getText().toString();
                String salary = etEmployeeSalary.getText().toString();

                // Cập nhật dữ liệu vào ViewModel
                employeeViewModel.setEmployeeID(id);
                employeeViewModel.setEmployeeName(name);
                employeeViewModel.setEmployeeBirth(birth);
                employeeViewModel.setEmployeeSalary(salary);

                // Thêm dữ liệu mới vào dưới dữ liệu cũ
                appendToTextView(tvEmployeeInfo);
            }
        });
    }

    // Hàm để thêm thông tin nhân viên mới vào TextView với dấu "-" ngăn cách
    private void appendToTextView(TextView textView) {
        String id = employeeViewModel.getEmployeeID().getValue();
        String name = employeeViewModel.getEmployeeName().getValue();
        String birth = employeeViewModel.getEmployeeBirth().getValue();
        String salary = employeeViewModel.getEmployeeSalary().getValue();

        // Tạo chuỗi dữ liệu mới
        String newEntry = (id != null ? id : "") + " - " +
                (name != null ? name : "") + " - " +
                (birth != null ? birth : "") + " - " +
                (salary != null ? salary : "");

        // Lấy nội dung hiện tại của TextView
        String currentText = textView.getText().toString();

        // Thêm dữ liệu mới vào dưới cùng của nội dung cũ
        textView.setText(currentText + "\n" + newEntry);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}