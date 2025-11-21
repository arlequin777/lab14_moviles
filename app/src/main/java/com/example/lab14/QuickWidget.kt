package com.example.lab14

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews

class QuickWidget : AppWidgetProvider() {

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        // Se llama cuando el widget debe actualizarse
        for (appWidgetId in appWidgetIds) {

            val views = RemoteViews(context.packageName, R.layout.widget_quick)

            // Intent para MainActivity
            val intentMain = Intent(context, MainActivity::class.java)
            val pendingMain = PendingIntent.getActivity(
                context,
                0,
                intentMain,
                PendingIntent.FLAG_IMMUTABLE
            )
            views.setOnClickPendingIntent(R.id.btnPrincipal, pendingMain)

            // Intent para SecondActivity
            val intentSecond = Intent(context, SecondActivity::class.java)
            val pendingSecond = PendingIntent.getActivity(
                context,
                1,
                intentSecond,
                PendingIntent.FLAG_IMMUTABLE
            )
            views.setOnClickPendingIntent(R.id.btnSecundaria, pendingSecond)

            // Intent para “Nueva acción” (por ahora también a MainActivity)
            val intentNueva = Intent(context, MainActivity::class.java)
            val pendingNueva = PendingIntent.getActivity(
                context,
                2,
                intentNueva,
                PendingIntent.FLAG_IMMUTABLE
            )
            views.setOnClickPendingIntent(R.id.btnNuevaAccion, pendingNueva)

            // Actualiza el widget
            appWidgetManager.updateAppWidget(appWidgetId, views)
        }
    }
}
