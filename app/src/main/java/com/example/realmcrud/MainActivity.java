package com.example.realmcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    EditText cnameedt,cduredt,cdescedt,ctrackedt;
    Realm realm;
    String cname,cdur,cdesc,ctrack,btn_readdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cnameedt = findViewById(R.id.c_name1);
        cduredt= findViewById(R.id.c_dur1);
        cdescedt= findViewById(R.id.c_disc1);
        ctrackedt = findViewById(R.id.c_trk1);

        Button submitbtn = findViewById(R.id.btn_add1);
        Button readdata = findViewById(R.id.btn_readdata1);

        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cname= cnameedt.getText().toString();
                cdesc= cdescedt.getText().toString();
                cdur= cduredt.getText().toString();
                ctrack= ctrackedt.getText().toString();

                if (TextUtils.isEmpty(cname)){
                    cnameedt.setError("Please enter the Course Name");
                } else if (TextUtils.isEmpty(cdesc)){
                    cnameedt.setError("Please enter the Course Description");
                } else if(TextUtils.isEmpty(cdur)){
                    cnameedt.setError("Please enter the Course Duration");
                } else if(TextUtils.isEmpty(ctrack)){
                    cnameedt.setError("Please enter the Course Track");
                } else {
                    addDataToDatabase(cname,cdesc,cdur,ctrack);
                    Toast.makeText(MainActivity.this, "Course Added to the Database", Toast.LENGTH_SHORT).show();
                    cnameedt.setText("");
                    cduredt.setText("");
                    cdescedt.setText("");
                    ctrackedt.setText("");
                }
            }
        });

        readdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, ReadCourseActivity.class);
                startActivity(intent);
            }
        });

        realm = Realm.getDefaultInstance();

    }

    private void addDataToDatabase(String cname, String cdesc, String cdur, String ctrack) {

        DataModel model = new DataModel();
        Number id = realm.where(DataModel.class).max("id");
        long nextId = 1;

        if (id==null){
            nextId=1;
        }else {
            nextId=id.intValue()+1;
        }
        model.setId(nextId);
        model.setC_name(cname);
        model.setC_desc(cdesc);
        model.setC_dur(cdur);
        model.setC_track(ctrack);

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealm(model);
            }
        });

    }
}