package com.example.administrator.mycontacts;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ContactsMessageActivity extends Activity {
    private TextView nameTV,mobileTV,danweiTV,qqTV,addressTV;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message);
        nameTV = (TextView)findViewById(R.id.name);
        mobileTV = (TextView)findViewById(R.id.mobile);
        danweiTV = (TextView)findViewById(R.id.danwei);
        qqTV = (TextView)findViewById(R.id.qq);
        addressTV = (TextView)findViewById(R.id.address);
        Bundle localBundle = getIntent().getExtras();
        int id = localBundle.getInt("user_ID");
        ContactsTable ct = new ContactsTable(this);
        user = ct.getUserByID(id);
        nameTV.setText("姓名："+user.getNAME());
        mobileTV.setText("电话"+user.getMOBILE());
        qqTV.setText("QQ"+user.getQQ());
        danweiTV.setText("单位"+user.getDANWEI());
        addressTV.setText("地址"+user.getADDRESS());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE,1,Menu.NONE,"返回");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case 1:
                finish();
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
