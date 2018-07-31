package events254.wakenyawawili.com.event254

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.MenuItem
import android.view.WindowManager
import android.widget.FrameLayout
import events254.wakenyawawili.com.event254.fragments.CalendarFragment
import events254.wakenyawawili.com.event254.fragments.HomeFragment
import events254.wakenyawawili.com.event254.fragments.NotificationFragment
import events254.wakenyawawili.com.event254.fragments.SavedFragment

class HomeActivity : AppCompatActivity() {

    private val FLAG_FULLSCREEN: Int = WindowManager.LayoutParams.FLAG_FULLSCREEN
    private var content: FrameLayout? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN)

        setContentView(R.layout.activity_home)
        content = findViewById<FrameLayout>(R.id.frame_layout) as FrameLayout
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.navigation) as BottomNavigationView
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        val fragment = HomeFragment.Companion.newInstance()
        addFragment(fragment)
    }

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.design_bottom_sheet_slide_in, R.anim.design_bottom_sheet_slide_out)
                .replace(R.id.frame_layout, fragment, fragment.javaClass.simpleName)
                .addToBackStack(fragment.javaClass.simpleName)
                .commit()
    }

    private val mOnNavigationItemSelectedListener = object : BottomNavigationView.OnNavigationItemSelectedListener {
        override fun onNavigationItemSelected(item: MenuItem): Boolean {
            when (item.itemId) {
                R.id.navigation_events -> {
                    val fragment = HomeFragment.Companion.newInstance()
                    addFragment(fragment)
                    return true
                }

                R.id.navigation_calendar -> {
                    val fragment = CalendarFragment()
                    addFragment(fragment)
                    return true
                }

                R.id.navigation_saved -> {
                    val fragment = SavedFragment()
                    addFragment(fragment)
                    return true
                }

                R.id.navigation_notifications -> {
                    val fragment = NotificationFragment()
                    addFragment(fragment)
                    return true
                }
            }
            return false
        }
    }
}
