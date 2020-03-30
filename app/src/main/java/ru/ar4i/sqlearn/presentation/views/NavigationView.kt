package ru.ar4i.sqlearn.presentation.views

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.annotation.DrawableRes
import ru.ar4i.sqlearn.R
import java.lang.Exception

class NavigationView(context: Context, attrs: AttributeSet? = null) :
    RelativeLayout(context, attrs) {

    private val tvText: TextView
    private val imgIcon: ImageView

    init {
        inflate(getContext(), R.layout.view_navigation, this)
        setBackgroundResource(getSelectableItemBackground())
        tvText = findViewById(R.id.tv_text)
        imgIcon = findViewById(R.id.img_icon)

        attrs?.let {
            context.theme
                .obtainStyledAttributes(it, R.styleable.NavigationView, DEFAULT_VALUE, DEFAULT_VALUE)
                ?.let { array ->
                    try {
                        array.getResourceId(R.styleable.NavigationView_nv_icon_src, DEFAULT_VALUE)
                            ?.let { if (it != DEFAULT_VALUE) { setIcon(it) } }

                        array.getString(R.styleable.NavigationView_nv_text)?.let { setText(it) }
                    } catch (ex: Exception){
                        ex.printStackTrace()
                    } finally {
                        array.recycle()
                    }
                }
        }
    }

    fun setText(text: String) {
        tvText.text = text
    }

    fun setIcon(@DrawableRes resId: Int) {
        imgIcon.setImageResource(resId)
    }

    private fun getSelectableItemBackground(): Int {
        val outValue = TypedValue()
        context.theme
            .resolveAttribute(R.attr.selectableItemBackground, outValue, true)
        return outValue.resourceId
    }

    companion object {
        private const val DEFAULT_VALUE = 0
    }
}