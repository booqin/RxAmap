package me.boqin.library;


import com.amap.api.location.AMapLocation;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import io.reactivex.Observable;
import me.boqin.library.observables.LocationObservable;
import me.boqin.library.utils.LocationUtils;
import me.boqin.library.utils.SettingUtils;

/**
 * TODO
 * Created by BoQin on 2018/3/1.
 * Modified by BoQin
 *
 * @Version
 */
public class XGLocation {

    private XGLocation(){
    }

    public static synchronized XGLocation getInstance(){
        return XGLocationHolder.instance;
    }

    /**
     * 返回的是observable对象
     */
    public Observable<AMapLocation> searchCurrentLocation(Context context){

        return LocationObservable.create(context);
    }

    public boolean checkPermissions(@NonNull
            Context context){
        return LocationUtils.isGPSOpened(context);
    }

    public void goApplicationLocationSetting(@NonNull Activity currentActivity){

        SettingUtils.goApplicationLocationSetting(currentActivity);
    }

    public void goSystemLocationSetting(@NonNull Activity currentActivity){

        SettingUtils.goSystemLocationSetting(currentActivity);
    }

    private static class XGLocationHolder {
        private static final XGLocation instance = new XGLocation();
    }
}
