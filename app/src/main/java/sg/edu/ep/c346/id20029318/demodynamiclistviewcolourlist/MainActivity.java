package sg.edu.ep.c346.id20029318.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etElement, etPosIndex;
    Button btnAdd;
    ListView lvColour;
    // ArrayList <String> alColours;
    // ArrayAdapter<String> aaColour; - somehow does not run with this declaration

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColour);
        etPosIndex = findViewById(R.id.editIndexPos);
        btnAdd = findViewById(R.id.butAddItem);
        lvColour = findViewById(R.id.listViewColour);

        ArrayList <String> alColours = new ArrayList<>();
        alColours.add("Red");
        alColours.add("Orange");

        ArrayAdapter<String> aaColour = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,alColours);
        lvColour.setAdapter(aaColour);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String col = etElement.getText().toString(); //get colour from input
                int pos = Integer.parseInt(etPosIndex.getText().toString()); //get position in arraylist
                if (etPosIndex == null) {
                    alColours.add(col);
                }
                else {
                    alColours.add(pos,col); // add colour to arrayList
                }

                aaColour.notifyDataSetChanged();
            }
        });

        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String colour = alColours.get(position);
                Toast.makeText(MainActivity.this, colour, Toast.LENGTH_SHORT).show();
                Log.d("LV click", colour); //shown in Logcat
            }
        });
    }
}
