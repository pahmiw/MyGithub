package com.example.mygithub.abstraction

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

abstract class BaseActivity<B : ViewDataBinding, V : ViewModel> : AppCompatActivity() {

    private lateinit var mViewDataBinding: B
    private lateinit var mViewModel: V

    private var toast: Toast? = null

    val binding: B
        get() = mViewDataBinding
    val vm: V
        get() = mViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutResourceId())
        mViewDataBinding.lifecycleOwner = this

        mViewModel = ViewModelProvider(this).get(getViewModelClass())
    }

    protected fun showToast(text: String, duration: Int = Toast.LENGTH_LONG) {
        toast?.cancel()
        toast = Toast.makeText(this, text, duration)
        toast!!.show()
    }

    @LayoutRes
    abstract fun getLayoutResourceId(): Int
    abstract fun getViewModelClass(): Class<V>
}