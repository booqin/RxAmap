package me.boqin.rxamap;

import com.boqin.runtimepermissions.PermissionActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

@PermissionActivity({})
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
