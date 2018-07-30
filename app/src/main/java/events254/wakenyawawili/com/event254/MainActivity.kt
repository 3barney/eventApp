package events254.wakenyawawili.com.event254

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager

// TODO: Check on auth items if needed, we do social login
class MainActivity : AppCompatActivity() {

    private var mDelayHandler: Handler? = null
    private val SPLASH_DELAY: Long = 5000

    private val mRunnable: Runnable = Runnable {
        if (!isFinishing) {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mDelayHandler = Handler(); // initialize handler
        mDelayHandler!!.postDelayed(mRunnable, SPLASH_DELAY)
    }

    public override fun onDestroy() {
        if (mDelayHandler != null) {
            mDelayHandler!!.removeCallbacks(mRunnable)
        }
        super.onDestroy()
    }
}
