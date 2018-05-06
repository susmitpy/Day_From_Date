package susmit.dayfromdate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        get_input();
    }

    public void get_input(){
         final EditText day, month, year;
         Button go;
         day = findViewById(R.id.etday);
         month = findViewById(R.id.etmonth);
         year = findViewById(R.id.etyear);
         go = findViewById(R.id.go);
         go.setOnClickListener(
                 new Button.OnClickListener(){
                     @Override
                     public void onClick(View view) {
                         String Day;
                         Calendar mycal;
                         Date mydate;
                         SimpleDateFormat df;
                         if(day.getText().toString() == "" || month.getText().toString() == "" || year.getText().toString() == ""){
                             String error = "No Input!!";
                             display(error);
                         }else{
                             int mon;
                             int d = Integer.parseInt(day.getText().toString());
                             int m = Integer.parseInt(month.getText().toString());
                             int y = Integer.parseInt(year.getText().toString());
                             mon = m - 1;
                             mycal = new GregorianCalendar(y, mon, d);
                             mydate = mycal.getTime();
                             df = new SimpleDateFormat("EEEE");
                             Day = df.format(mydate);
                             display(Day);
                         }
                     }

          });
    }

    public void display(String Day){
        TextView display;
        display = findViewById(R.id.display);
        display.setText(Day);

    }




}
