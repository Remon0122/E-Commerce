package com.mis.route.e_commerce.ui.base

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.mis.route.e_commerce.domain.utils.AppErrors


abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    private var _binding: VB? = null
    protected val binding get() = _binding!!

    abstract fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?): VB

    private var loadingDialog: AlertDialog? = null
    private var errorDialog: AlertDialog? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = getViewBinding(inflater, container)
        return binding.root
    }

    /* ---------------- Loading Dialog ---------------- */

    protected fun isLoading(show: Boolean) {
        if (!isAdded) return

        if (show) {
            if (loadingDialog == null) {
                loadingDialog = AlertDialog.Builder(requireContext())
                    .setView(android.R.layout.simple_spinner_item) // ممكن تحط dialog custom هنا
                    .setCancelable(false)
                    .create()
            }
            loadingDialog?.show()
        } else {
            loadingDialog?.dismiss()
        }
    }

    /* ---------------- Error Dialog ---------------- */

    protected fun errorLoading(message: String?, retry: (() -> Unit)? = null) {
        if (!isAdded) return

        errorDialog?.dismiss()

        val builder = AlertDialog.Builder(requireContext())
            .setTitle("Error")
            .setMessage(message ?: "Something went wrong")
            .setCancelable(false)

        retry?.let {
            builder.setPositiveButton("Retry") { _, _ -> it.invoke() }
        }

        builder.setNegativeButton("OK", null)

        errorDialog = builder.create()
        errorDialog?.show()
    }
    protected fun handleError(error: AppErrors, retry: (() -> Unit)? = null) {
        if (error is AppErrors.IgnoredErrors) return

        isLoading(false)
        errorLoading(error.errorMessage, retry)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        loadingDialog?.dismiss()
        errorDialog?.dismiss()
    }
}



