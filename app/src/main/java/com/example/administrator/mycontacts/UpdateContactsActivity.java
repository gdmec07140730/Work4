package com.example.administrator.mycontacts;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateContactsActivity extends Activity {
    private EditText nameET,mobileET,qqET,danweiET,addressET;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);
        nameET = (EditText) findViewById(R.id.name);
        mobileET = (EditText)findViewById(R.id.mobile);
        qqET = (EditText)findViewById(R.id.qq);
        danweiET = (EditText)findViewById(R.id.danwei);
        addressET = (EditText)findViewById(R.id.address);
        Bundle localBundle = getIntent().getExtras();
        int id = localBundle.getInt("user_ID");
        ContactsTable ct = new ContactsTable(this);
        user = ct.getUserByID(id);
        nameET.setText(user.getNAME());
        mobileET.setText(user.getMOBILE());
        qqET.setText(user.getQQ());
        danweiET.setText(user.getDANWEI());
        addressET.setText(user.getADDRESS());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE,1,Menu.NONE,"保存");
        menu.add(Menu.NONE,1,Menu.NONE,"返回");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                if (!nameET.getText().toString().equals("")) {
                    User user = new User();
                    User.setName(nameET.getText().toString());
                    User.setAddress(addressET.getText().toString());
                    User.setDanwei(danweiET.getText().toString());
                    User.setQq(qqET.getText().toString());
                    User.setMoblie(mobileET.getText().toString());
                    ContactsTable ct = new ContactsTable(UpdateContactsActivity.this);

                    if (ct.addDate(user)) {
                        Toast.makeText(UpdateContactsActivity.this, "添加成功！", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(UpdateContactsActivity.this, "添加失败", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(UpdateContactsActivity.this, "请先输入数据！", Toast.LENGTH_SHORT).show();
                }
                break;
            case 2:
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
