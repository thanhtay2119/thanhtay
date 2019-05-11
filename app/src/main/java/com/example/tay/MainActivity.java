package com.example.tay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
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

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.List;

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

    Button getbtnThanhToan;
    Button getBtnHuy;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button getBtnHuy = (Button) findViewById(R.id.btncancle);
        Button getbtnThanhToan =  (Button)findViewById(R.id.btnbook);
        final EditText gettxtten =  (EditText)findViewById(R.id.txtten);
        final EditText gettxtsdt =  (EditText)findViewById(R.id.txtsdt);
        final CheckBox getdichvu =  (CheckBox) findViewById(R.id.checkBox);
        final RadioButton getVIP =  (RadioButton) findViewById(R.id.rbtnvip);
        final RadioButton getthuong =  (RadioButton) findViewById(R.id.rbtnthuong);
        final RadioButton getghe =  (RadioButton) findViewById(R.id.rbtnghe);
        final RadioButton getgiuong =  (RadioButton) findViewById(R.id.rbtngiuong);
        final Spinner getdonvi =  (Spinner) findViewById(R.id.spinner);

        final int nam = 1200000;
        final int ngoi = 800000;
        final int dv = 60000;

        getBtnHuy.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cancel(v);

            }
        });


        List<String> lan_array =  new ArrayList<String>();
        lan_array.add("USD");
        lan_array.add("VND");

//kh?i t?o d?i tu?ng ArrayAdapter dùng t?p h?p d? li?u và layout spinner m?c d?nh

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, lan_array);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//gán d?i tu?ng adapter d?n spinner

        getdonvi.setAdapter(adapter);

        getbtnThanhToan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                float tt = 0;
                String a = "VND";
                String b = getdonvi.getSelectedItem().toString();
                String msg = "Tên: " + gettxtten.getText().toString() +
                        System.getProperty("line.separator") +
                        "SĐT: " + gettxtsdt.getText().toString()
                        + System.getProperty("line.separator") +
                        "Thành viên: ";

                gettxtten.setText("");
                gettxtsdt.setText("");



                if(getVIP.isChecked())
                    msg += getVIP.getText().toString()+ System.getProperty("line.separator") +"Loại vé: ";
                if(getthuong.isChecked())
                    msg += getthuong.getText().toString()+ System.getProperty("line.separator") +"Loại vé: ";

                if(getgiuong.isChecked())
                    msg += getgiuong.getText().toString()+ System.getProperty("line.separator") +"Dịch vụ: ";
                if(getghe.isChecked())
                    msg += getghe.getText().toString()+ System.getProperty("line.separator") +"Dịch vụ: ";


                if(getdichvu.isChecked())
                    msg += "Có";
                else
                    msg += "Không";


                msg += System.getProperty("line.separator") + "Hình thức thanh toán : " +
                        getdonvi.getSelectedItem().toString();

                if(getVIP.isChecked())
                {
                    if(getgiuong.isChecked()&& getdichvu.isChecked()){
                        tt = (nam + dv)*70/100;
                        if(b.equals(a))
                            msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "VNĐ";
                        else {
                            tt = tt/20000;
                            msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "USD";
                        }
                    }
                    else if(getghe.isChecked() && getdichvu.isChecked())
                    {
                        tt = (ngoi + dv)*70/100;
                        //msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "VNĐ";
                        if(b.equals(a))
                            msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "VNĐ";
                        else {
                            tt = tt/20000;
                            msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "USD";
                        }
                    }
                    else if(getgiuong.isChecked())
                    {
                        tt = nam*70/100;
                        //msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "VNĐ";
                        if(b.equals(a))
                            msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "VNĐ";
                        else {
                            tt = tt/20000;
                            msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "USD";
                        }
                    }
                    else if(getghe.isChecked())
                    {
                        tt = ngoi*70/100;
                        //msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "VNĐ";
                        if(b.equals(a))
                            msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "VNĐ";
                        else {
                            tt = tt/20000;
                            msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "USD";
                        }
                    }

                }
                if(getthuong.isChecked())
                {
                    if(getgiuong.isChecked()&& getdichvu.isChecked()){
                        tt = nam + dv;
                        //msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "VNĐ";
                        if(b.equals(a))
                            msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "VNĐ";
                        else {
                            tt = tt/20000;
                            msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "USD";
                        }
                    }
                    else if(getghe.isChecked() && getdichvu.isChecked())
                    {
                        tt = ngoi + dv;
                        //msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "VNĐ";
                        if(b.equals(a))
                            msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "VNĐ";
                        else {
                            tt = tt/20000;
                            msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "USD";
                        }
                    }
                    else if(getgiuong.isChecked())
                    {
                        tt = nam;
                        //msg += System.getProperty("line.separator") + "Thành ti?n: " +  tt + "VNĐ";
                        if(b.equals(a))
                            msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "VNĐ";
                        else {
                            tt = tt/20000;
                            msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "USD";
                        }
                    }
                    else if(getghe.isChecked())
                    {
                        tt = ngoi;
                        //msg += System.getProperty("line.separator") + "Thành ti?n: " +  tt + "VNĐ";
                        if(b.equals(a))
                            msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "VNĐ";
                        else {
                            tt = tt/20000;
                            msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + " USD";
                        }
                    }

                }


                msg +=System.getProperty("line.separator") + "Cảm ơn quý khách !!!";



                info (v,msg);
              getVIP.setChecked(false);
               getthuong.setChecked(false);
                getgiuong.setChecked(false);
              getghe.setChecked(false);
                getdichvu.setChecked(false);

            }
        });

    }
    public void info(View v, String msg){
        AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
        dlgAlert.setMessage(msg);
        dlgAlert.setTitle("Thông Tin ");
        dlgAlert.setPositiveButton("OK", null);
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
    }
    public void cancel(View v) {System.exit(  0);}
}