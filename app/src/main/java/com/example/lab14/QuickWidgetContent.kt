package com.example.lab14

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.glance.Button
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.action.actionStartActivity
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.layout.*
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import androidx.glance.unit.ColorProvider

// IMPORTAR dp/sp de Compose (LOS CORRECTOS PARA TU VERSION)
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class QuickWidgetContent : GlanceAppWidget() {

    override suspend fun provideGlance(context: Context, id: androidx.glance.GlanceId) {
        provideContent {
            GlanceTheme {
                WidgetUI()
            }
        }
    }
}

@SuppressLint("ResourceType")
@Composable
fun WidgetUI() {

    Column(
        modifier = GlanceModifier
            .fillMaxSize()
            .background(GlanceTheme.colors.background)
            .padding(16.dp),   // ← dp de Compose funciona aquí
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Acceso Rápido",
            style = TextStyle(
                fontSize = 18.sp, // ← sp de Compose funciona aquí
                color = ColorProvider(android.graphics.Color.BLACK)
            ),
            modifier = GlanceModifier.padding(bottom = 12.dp)
        )

        Row(
            modifier = GlanceModifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Button(
                text = "Principal",
                onClick = actionStartActivity<MainActivity>()
            )

            Spacer(GlanceModifier.width(12.dp))

            Button(
                text = "Secundaria",
                onClick = actionStartActivity<MainActivity>()
            )
        }

        Spacer(GlanceModifier.height(16.dp))

        Button(
            text = "Nueva Acción",
            onClick = actionStartActivity<MainActivity>(),
            modifier = GlanceModifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
        )
    }
}
