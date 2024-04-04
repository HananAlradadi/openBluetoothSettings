package com.example.myapplication443

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication443.ui.theme.MyApplication443Theme
import android.provider.Settings
import androidx.compose.foundation.layout.Row


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplication443Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
 Row {
     Button(onClick = { openBluetoothSettings() }) {
         Text(text = "Open Intent")
     }
 }
               }
            }
        }
    }fun OpenAct2(){
        try {

            val intent = Intent(this , MainActivity2 :: class.java )
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

            startActivity(intent)

        }
        catch(e : Exception) {
            println(e)
        }
    }
    fun openBluetoothSettings(){
        try {
            val intent = Intent(Settings.ACTION_BLUETOOTH_SETTINGS)
            startActivity(intent)
        }
        catch(e : Exception) {
            println(e)
        }
    }
    fun setAlarm(m:String , h : Int , min:Int){
        try {

            val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
                putExtra(AlarmClock.EXTRA_MESSAGE , m)
                putExtra(AlarmClock.EXTRA_HOUR , h)
                putExtra(AlarmClock.EXTRA_MINUTES,min)
            }
           // intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)

        }
        catch(e : Exception) {
            println(e)
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplication443Theme {
        Greeting("Android")
    }
}