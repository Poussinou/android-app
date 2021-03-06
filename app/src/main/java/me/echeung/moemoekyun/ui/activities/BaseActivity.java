package me.echeung.moemoekyun.ui.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import me.echeung.moemoekyun.App;
import me.echeung.moemoekyun.R;
import me.echeung.moemoekyun.utils.LocaleUtil;
import me.echeung.moemoekyun.utils.PreferenceUtil;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        switch (App.getPreferenceUtil().getTheme()) {
            case PreferenceUtil.THEME_DEFAULT:
                setTheme(R.style.AppTheme);
                break;

            case PreferenceUtil.THEME_LEGACY:
                setTheme(R.style.AppThemeLegacy);
                break;

            case PreferenceUtil.THEME_CHRISTMAS:
                setTheme(R.style.AppThemeChristmas);
                break;
        }

        super.onCreate(savedInstanceState);

        LocaleUtil.setTitle(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleUtil.setLocale(base));
    }

}
