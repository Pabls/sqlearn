package ru.ar4i.sqlearn.presentation.sections

import android.os.Bundle
import android.text.InputType
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.ar4i.sqlearn.R
import ru.ar4i.sqlearn.data.entities.SectionVm
import ru.ar4i.sqlearn.presentation.base.BaseToolbarFragment
import ru.ar4i.sqlearn.presentation.sections.adapter.SectionsAdapter
import ru.ar4i.sqlearn.presentation.sections.filters.FilterChangeListener
import ru.ar4i.sqlearn.presentation.sections.filters.FiltersBottomDialogFragment

class SectionsFragment : BaseToolbarFragment() {

    private var rvSections: RecyclerView? = null
    private var adapter: SectionsAdapter? = null
    private var navController: NavController? = null
    private var searchViewEditText: SearchView? = null

    private var sortingType: String? = null
    private var filterType: String? = null
    private var sections = mutableListOf<SectionVm>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showMenu()
        navController = findNavController()
        rvSections = view.findViewById(R.id.rv_sections)
        adapter = SectionsAdapter { sectionName: String ->
            navController?.navigate(
                SectionsFragmentDirections.actionSectionsFragmentToDetailsFragment(
                    sectionName
                )
            )
        }
        rvSections?.adapter = adapter
        setData()
    }

    override fun getTitle(): String = getString(R.string.fragment_menu_toolbar_title)

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.sections_fragment_menu, menu)
        val actionSearch = menu.findItem(R.id.menu_search)
        searchViewEditText = actionSearch?.actionView as SearchView
        searchViewEditText?.queryHint = getString(R.string.sections_fragment_menu_hint)
        searchViewEditText?.inputType = InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS

        searchViewEditText?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                return true
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.menu_filter) {
            openFilterMenu()
            true
        } else {
            super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroyView() {
        val visiblePosition =
            (rvSections?.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
        super.onDestroyView()
    }

    override fun getLayoutId(): Int = R.layout.fragment_sections


    private fun openFilterMenu() {
        val fragment = FiltersBottomDialogFragment.newInstanse(this.sortingType, this.filterType)
        fragment.show(activity!!.supportFragmentManager, FiltersBottomDialogFragment.TAG)
        fragment.setFilterChangeListener(object : FilterChangeListener {

            override fun onSaveButtonClick(sortingType: String?, filterType: String?) {
                this@SectionsFragment.sortingType = sortingType
                this@SectionsFragment.filterType = filterType
            }

            override fun onResetButtonClick() {
                sortingType = null
                filterType = null
            }

        })
    }

    private fun setData() {
        val sectionsArray = resources.getStringArray(R.array.sections)
        val descriptionsArray = resources.getStringArray(R.array.description)
        this.sections = mutableListOf<SectionVm>()

        var index = 0
        for (sectionName in sectionsArray) {
            sections.add(
                SectionVm(
                    id = index + 1,
                    name = sectionName,
                    description = descriptionsArray[index],
                    isDone = index % 2 == 0
                )
            )
            index += 1
        }
        adapter?.setData(sections)
    }
}
