package com.izo.yourney.ui.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.text.Editable
import android.text.TextWatcher
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import com.izo.yourney.R

class PasswordView : AppCompatEditText, View.OnTouchListener {

    private lateinit var showPasswordImage: Drawable
    private lateinit var hidePasswordImage: Drawable
    private lateinit var lockImage: Drawable
    private var eyeShow = false
    private var eyeHide = false

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init()
    }

//    override fun onDraw(canvas: Canvas) {
//        super.onDraw(canvas)
//        hint = "Masukkan password Anda"
//    }

    private fun init() {
        showPasswordImage = ContextCompat.getDrawable(context, R.drawable.ic_eye) as Drawable
        hidePasswordImage = ContextCompat.getDrawable(context, R.drawable.ic_hide_eye) as Drawable
        lockImage = ContextCompat.getDrawable(context, R.drawable.ic_lock) as Drawable
        setOnTouchListener(this)

        addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // Do nothing.
            }
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.toString().isNotEmpty()) showPasswordButton() else hideEyeButton()
            }
            override fun afterTextChanged(s: Editable) {
                // Do nothing.
            }
        })
    }

    private fun showPasswordButton() {
        setButtonDrawables(startOfTheText = lockImage, endOfTheText = showPasswordImage)
        eyeShow = true
    }

    private fun hideEyeButton() {
        setButtonDrawables(startOfTheText = lockImage)
        transformationMethod = PasswordTransformationMethod.getInstance()
    }

    private fun hidePasswordButton() {
        setButtonDrawables(startOfTheText = lockImage, endOfTheText = hidePasswordImage)
        eyeShow = false
    }


    private fun setButtonDrawables(
        startOfTheText: Drawable? = null,
        topOfTheText: Drawable? = null,
        endOfTheText: Drawable? = null,
        bottomOfTheText: Drawable? = null
    ) {
        setCompoundDrawablesWithIntrinsicBounds(
            startOfTheText,
            topOfTheText,
            endOfTheText,
            bottomOfTheText
        )
    }

    override fun onTouch(v: View?, event: MotionEvent): Boolean {
        if (compoundDrawables[2] != null) {
            val showEyeStart: Float
            val showEyeEnd: Float
            var isShowButtonClicked = false

            if (layoutDirection == View.LAYOUT_DIRECTION_RTL) {
                showEyeEnd = (showPasswordImage.intrinsicWidth + paddingStart).toFloat()
                when {
                    event.x < showEyeEnd -> isShowButtonClicked = eyeShow
                }
            } else {
                showEyeStart = (width - paddingRight - showPasswordImage.intrinsicWidth).toFloat()
                when {
                    event.x > showEyeStart -> isShowButtonClicked = eyeShow
                }
            }


            if (isShowButtonClicked) {
                return when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        showPasswordImage = ContextCompat.getDrawable(context, R.drawable.ic_eye) as Drawable
                        showPasswordButton()
                        true
                    }
                    MotionEvent.ACTION_UP -> {
                        showPasswordImage = ContextCompat.getDrawable(context, R.drawable.ic_eye) as Drawable
                        transformationMethod = HideReturnsTransformationMethod.getInstance()
                        hidePasswordButton()
                        true
                    }
                    else -> false
                }
            } else {
                return when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        hidePasswordImage = ContextCompat.getDrawable(context, R.drawable.ic_hide_eye) as Drawable
                        hidePasswordButton()
                        true
                    }
                    MotionEvent.ACTION_UP -> {
                        hidePasswordImage = ContextCompat.getDrawable(context, R.drawable.ic_hide_eye) as Drawable
                        transformationMethod = PasswordTransformationMethod.getInstance()
                        showPasswordButton()
                        true
                    }
                    else -> false
                }
            }

        }

        return false
    }
}