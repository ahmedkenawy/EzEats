package com.ahmedkenawy.ezeats.ui

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp
/**
 * MyApplication is the application class annotated with @HiltAndroidApp.
 *
 * This class:
 * - Extends the Android Application class.
 * - Initializes Hilt's dependency injection framework for the application.
 */

@HiltAndroidApp
class MyApplication :Application() {}