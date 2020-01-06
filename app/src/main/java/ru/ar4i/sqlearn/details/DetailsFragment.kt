package ru.ar4i.sqlearn.details


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.ar4i.sqlearn.R

class DetailsFragment : Fragment() {

    companion object {

        private const val ARG_PAGE_ID = "ARG_PAGE_ID"

        fun newInstance(pageId: String) =
            DetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PAGE_ID, pageId)
                }
            }
    }

    private var pageId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            pageId= it.getString(ARG_PAGE_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }



}
