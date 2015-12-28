package com.example.administrator.mycontacts;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Administrator on 2015/10/29.
 */
public class AddContactsActivity extends Activity {
    private EditText nameET;
    private EditText mobileET;
    private EditText qqET;
    private EditText danweiET;
    private EditText addressET;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameET=(EditText)findViewById(R.id.name);
        mobileET=(EditText)findViewById(R.id.mobile);
        danweiET=(EditText)findViewById(R.id.danwei);
        qqET=(EditText)findViewById(R.id.qq);
        addressET=(EditText)findViewById(R.id.address);
    }



    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_my_contacts,menu);
        menu.add(0,1,1,"保存");
        menu.add(0, 2, 2, "返回");
        return  true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                if (!nameET.getText().toString().equals("")) {
                    User user = new User();
                    user.setName(nameET.getText().toString());
                    user.setAddress(addressET.getText().toString());
                    user.setDanwei(danweiET.getText().toString());
                    user.setQq(qqET.getText().toString());
                    user.setMoblie(mobileET.getText().toString());
                    ContactsTable ct = new ContactsTable(AddContactsActivity.this);

                    if (ct.addDate(user)) {
                        Toast.makeText(AddContactsActivity.this, "添加成功！", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(AddContactsActivity.this, "添加失败", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(AddContactsActivity.this, "请先输入数据！", Toast.LENGTH_SHORT).show();
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
