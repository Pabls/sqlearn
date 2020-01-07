package ru.ar4i.sqlearn.presentation.sections.filters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.core.view.children
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ru.ar4i.sqlearn.R

class FiltersBottomDialogFragment : BottomSheetDialogFragment() {

    companion object {

        val TAG = "FiltersBottomDialogFragment"

        const val EXTRA_SORTING_TYPE = "EXTRA_SORTING_TYPE"
        const val EXTRA_FILTER_TYPE = "EXTRA_FILTER_TYPE"

        fun newInstanse(sortingType: String?, filterType: String?): FiltersBottomDialogFragment =
            FiltersBottomDialogFragment().apply {
                arguments = Bundle().apply {
                    putString(EXTRA_SORTING_TYPE, sortingType)
                    putString(EXTRA_FILTER_TYPE, filterType)
                }
            }
    }

    private var sortingType: String? = null
    private var filterType: String? = null
    private var listener: FilterChangeListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            sortingType = it.getString(EXTRA_SORTING_TYPE)
            filterType = it.getString(EXTRA_FILTER_TYPE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_filter, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rgSorting = view.findViewById<RadioGroup>(R.id.rg_sorting)
        val rgFilters = view.findViewById<RadioGroup>(R.id.rg_filters)
        val btnReset = view.findViewById<Button>(R.id.btn_reset)
        val btnSave = view.findViewById<Button>(R.id.btn_save)

        setCheckedState(rgSorting, sortingType)
        setCheckedState(rgFilters, filterType)

        btnReset?.setOnClickListener { onResetClick() }
        btnSave?.setOnClickListener { onSaveClick(rgSorting, rgFilters) }
    }

    fun setFilterChangeListener(filterChangeListener: FilterChangeListener) {
        this.listener = filterChangeListener
    }

    private fun setCheckedState(radioGroup: RadioGroup?, text: String?) {
        if (text != null) {
            val radio = radioGroup?.children?.find { (it as RadioButton).text == text }
            (radio as RadioButton).isChecked = true
        }
    }

    private fun onResetClick() {
        listener?.onResetButtonClick()
        dismiss()
    }

    private fun onSaveClick(sorting: RadioGroup, filters: RadioGroup) {
        val checkedSortingButtonText =
            sorting.findViewById<RadioButton>(sorting.checkedRadioButtonId)?.text?.toString()
        val checkedFiltersButtonText =
            filters.findViewById<RadioButton>(filters.checkedRadioButtonId)?.text?.toString()

        listener?.onSaveButtonClick(checkedSortingButtonText, checkedFiltersButtonText)
        dismiss()
    }


}