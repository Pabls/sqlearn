package ru.ar4i.sqlearn.presentation.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.Navigator
import ru.ar4i.sqlearn.R
import ru.ar4i.sqlearn.presentation.main.IModeActivity
import ru.ar4i.sqlearn.presentation.main.IToolbarActivity
import java.lang.IllegalArgumentException

abstract class BaseFragment : Fragment() {

    abstract val layoutId: Int

    private var title: String? = null
    private var tvTitle: TextView? = null
    private var toolbar: Toolbar? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(layoutId, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvTitle = view.findViewById(R.id.toolbar_title)
        toolbar = view.findViewById(R.id.toolbar)
        initToolbarTitle()
    }

    protected fun setTitle(title: String) {
        this.title = title
        initToolbarTitle()
    }

    protected fun showBackButton() {
        if (toolbar != null && activity != null && activity is IToolbarActivity) {
            (activity!! as IToolbarActivity).setToolbar(toolbar!!, true)
        }
    }

    protected fun showMenu() {
        if (toolbar != null && activity != null && activity is IToolbarActivity) {
            setHasOptionsMenu(true)
            (activity!! as IToolbarActivity).setToolbar(toolbar!!, false)
        }
    }

    protected fun getModeActivity(): IModeActivity = requireActivity() as IModeActivity

    protected fun navigateTo(
        screenId: Int,
        initBundle: ((bundle: Bundle) -> Unit)? = null
    ) {
        val bundle = Bundle()
        initBundle?.invoke(bundle)
        Navigation.findNavController(requireView()).apply {
            try {
                navigate(screenId, bundle)
            } catch (ex: IllegalArgumentException) {
            }
        }
    }

    private fun initToolbarTitle(){
        tvTitle?.text = title
    }
}