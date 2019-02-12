package me.boqin.rxamap;

import com.amap.api.location.AMapLocation;
import com.boqin.permissionapi.RuntimePermission;
import com.boqin.runtimepermissions.PermissionActivity;
import com.boqin.runtimepermissions.PermissionGranted;

import android.Manifest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import me.boqin.library.XGLocation;
import me.boqin.library.observables.LocationObservable;

@PermissionActivity({Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_PHONE_STATE,Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.READ_EXTERNAL_STORAGE})
public class MainActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.content);
        RuntimePermission.tryPermissionByAnnotation(this);
    }

    @PermissionGranted
    public void doLocation(){
        XGLocation.getInstance().searchCurrentLocation(this)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<AMapLocation>() {
                    @Override
                    public void accept(AMapLocation aMapLocation) throws Exception {
                        Log.d("BQ", aMapLocation.toStr());
                        mTextView.setText(""+aMapLocation.getErrorCode());
                    }
                });
    }
}
