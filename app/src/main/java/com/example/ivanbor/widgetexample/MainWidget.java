package com.example.ivanbor.widgetexample;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;

import java.util.Arrays;

public class MainWidget extends AppWidgetProvider {

    final String LOG_TAG = "myLogs";

    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);
        Log.i(LOG_TAG, "onEnabled: first widget example is created");
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        launchActivity(context, appWidgetManager, appWidgetIds);

        Log.i(LOG_TAG, "onUpdate: widgets " + Arrays.toString(appWidgetIds));
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        super.onDeleted(context, appWidgetIds);
        Log.i(LOG_TAG, "onDeleted: widgets " + Arrays.toString(appWidgetIds) + " were deleted");
    }

    @Override
    public void onDisabled(Context context) {
        super.onDisabled(context);
        Log.i(LOG_TAG, "onDisabled: last widget example were deleted");
    }

    private void launchActivity(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.main_widget);
        Intent configIntent = new Intent(context, MainActivity.class);

        PendingIntent configPendingIntent = PendingIntent.getActivity(context, 0, configIntent, 0);

        remoteViews.setOnClickPendingIntent(R.id.textView, configPendingIntent);
        appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);

        Log.i(LOG_TAG, "Main activity is launched!");
    }
}
