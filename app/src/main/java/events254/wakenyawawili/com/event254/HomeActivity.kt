package events254.wakenyawawili.com.event254

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager

class HomeActivity : AppCompatActivity() {

    private val FLAG_FULLSCREEN: Int = WindowManager.LayoutParams.FLAG_FULLSCREEN

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN)

        setContentView(R.layout.activity_home)
    }
}
