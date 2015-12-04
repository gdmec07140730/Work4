package com.example.administrator.mycontacts;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FindDialog extends Dialog {
    private Button find, cancel;
    private Context appcontext;

    public FindDialog(Context context) {
        super(context);
        appcontext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find);
        setTitle("联系人查询");
        find = (Button) findViewById(R.id.find);
        cancel = (Button) findViewById(R.id.cancel);
        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText value = (EditText) findViewById(R.id.value);
                ContactsTable ct = new ContactsTable(appcontext);
                User[] users = ct.findUserByKey(value.getText().toString());
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < users.length; i++) {
                    sb.append("姓名：" + users[i].getNAME()+ "电话：" + users[i].getMOBILE());
                }
                Toast.makeText(appcontext, sb.toString(), Toast.LENGTH_LONG).show();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                dismiss();
            }
        });
    }
}
