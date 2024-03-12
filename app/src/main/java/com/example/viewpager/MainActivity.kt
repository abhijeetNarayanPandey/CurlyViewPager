package com.example.viewpager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.library.CurlPage
import com.example.library.CurlView


class MainActivity : AppCompatActivity() {

    private val mImages = intArrayOf(R.drawable.obama, R.drawable.road_rage, R.drawable.taipei_101 /* Add more image resources */)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        viewPager.adapter = ImagePagerAdapter(this, mImages)

        val curlView = findViewById<CurlView>(R.id.curl_view)
        curlView.setPageProvider(object : CurlView.PageProvider {
            override fun getPageCount(): Int {
                return mImages.size
            }

            override fun updatePage(curlPage: CurlPage, width: Int, height: Int, index: Int) {
                // Load your images onto the curlPage
            }
        })

        curlView.setSizeChangedObserver(object : CurlView.SizeChangedObserver {
            override fun onSizeChanged(w: Int, h: Int) {
                if (w > h) {
                    curlView.setViewMode(CurlView.SHOW_TWO_PAGES)
                    curlView.setMargins(0f, 0f, 0f, 0f)
                } else {
                    curlView.setViewMode(CurlView.SHOW_ONE_PAGE)
                    curlView.setMargins(0f, 0f, 0f, 0f)
                }
            }
        })
    }
}
