package matin.farhad.Uni;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private EditText etInput;
    private TextView tvResult;
    private Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        etInput = findViewById(R.id.etInput);
        tvResult = findViewById(R.id.tvResult);
        btnCalculate = findViewById(R.id.btnCalculate);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.unit_conversions, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = etInput.getText().toString();
                if (!inputText.isEmpty()) {
                    double inputValue = Double.parseDouble(inputText);
                    String selectedConversion = spinner.getSelectedItem().toString();

                    double result = 0;
                    String resultText = "";


                    switch (selectedConversion) {
                        case "سانتی متر به اینچ":
                            result = inputValue / 2.54;
                            resultText = String.format("%.3f اینچ", result);
                            break;
                        case "اینچ به سانتی متر":
                            result = inputValue * 2.54;
                            resultText = String.format("%.3f سانتی متر", result);
                            break;
                        case "مثقال به گرم":
                            result = inputValue * 4.608;
                            resultText = String.format("%.3f گرم", result);
                            break;
                        case "گرم به مثقال":
                            result = inputValue / 4.608;
                            resultText = String.format("%.3f مثقال", result);
                            break;

                    }

                    // نمایش نتیجه
                    tvResult.setText(resultText);
                } else {
                    tvResult.setText("لطفاً مقدار را وارد کنید");
                }
            }
        });
    }
}
