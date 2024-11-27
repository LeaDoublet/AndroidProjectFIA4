package com.example.tpandroid1

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.squareup.moshi.Moshi
import dagger.Provides
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@HiltAndroidApp
class MyApplication : Application()
