package com.example.tay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Switch;
import android.widget.Spinner;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.CheckBox;
import android.view.View.OnClickListener;
import android.content.Intent;

import android.app.AlertDialog;

public class MainActivity extends AppCompatActivity {

    TextView txtwten;
    EditText gettxtten;
    EditText gettxtsdt;
    CheckBox getdichvu;
    RadioButton getVIP;
    RadioButton getthuong;
    RadioButton getgiuong;
    RadioButton getghe;
    Spinner getdonvi;

    Button btnHuy;
    Button getbtnThanhToan;
    Button getBtnHuy;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText gettxtten =  (EditText)findViewById(R.id.txtten);
        final EditText gettxtsdt =  (EditText)findViewById(R.id.txtsdt);
        final CheckBox getdichvu =  (CheckBox) findViewById(R.id.checkBox);
        final RadioButton getVIP =  (RadioButton) findViewById(R.id.rbtnvip);
        final RadioButton getthuong =  (RadioButton) findViewById(R.id.rbtnthuong);
        final RadioButton getghe =  (RadioButton) findViewById(R.id.rbtnghe);
        final RadioButton getgiuong =  (RadioButton) findViewById(R.id.rbtngiuong);
        final Spinner getdonvi =  (Spinner) findViewById(R.id.spinner);


        getBtnHuy = (Button) findViewById(R.id.btncancle);
        getbtnThanhToan = (Button) findViewById(R.id.btnbook);

        getbtnThanhToan.setOnClickListener(new View.OnClickListener() {
                                               public void onClick(View v) {

                                                   String msg = "Tên: " + gettxtten.getText().toString() +
                                                           System.getProperty("line.separator") +
                                                           "Số điện thoại: " + gettxtsdt.getText().toString();


                                                   msg += System.getProperty("line.separator") + "Số tiền: 1.200.000 " +
                                                           getdonvi.getSelectedItem().toString();

                                                   info(v, msg);
                                                   gettxtten.setText(""  );
                                                   gettxtsdt.setText("");

                                                   if(getVIP.isChecked())
                                                       msg +=  getVIP.getText().toString();
                                                   if(getthuong.isChecked())
                                                       msg +=  getthuong.getText().toString();


                                               }
                                           }
        );
        getBtnHuy.setOnClickListener(new View.OnClickListener() {
                                         public void onClick(View v) {
                                             cancel(v);
                                         }
                                     }
        );
    }
    public void cancel(View v){
        System.exit(0);
    }

    public void info(View v, String msg){
        AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
        dlgAlert.setMessage(msg);
        dlgAlert.setTitle("ĐẶT VÉ ONLINE");
        dlgAlert.setPositiveButton("OK", null);
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
    }
}
