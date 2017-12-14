package com.app.sharepro;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;

import com.app.sharepro.util.SPUtil;

/**
 * Created by duanlei on 2017/11/23.
 */

@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity {

  boolean isNight;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    isNight = (boolean) SPUtil.get(this, "isNight", false);

    if (isNight) {
      getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
    } else {
      getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
    }
  }
}
