package ru.ar4i.sqlearn.presentation.sections

import android.os.Bundle
import android.text.InputType
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import ru.ar4i.sqlearn.R
import ru.ar4i.sqlearn.data.entities.SectionVm
import ru.ar4i.sqlearn.presentation.base.fragment.BaseVmFragment
import ru.ar4i.sqlearn.presentation.sections.adapter.SectionsAdapter
import ru.ar4i.sqlearn.presentation.sections.filters.FilterChangeListener
import ru.ar4i.sqlearn.presentation.sections.filters.FiltersBottomDialogFragment

class SectionsFragment : BaseVmFragment<SectionsViewModel>() {

    override val layoutId: Int
        get() = R.layout.fragment_sections
    override val viewModel: Class<SectionsViewModel>
        get() = SectionsViewModel::class.java

    private var rvSections: RecyclerView? = null
    private var adapter: SectionsAdapter? = null
    private var navController: NavController? = null
    private var searchViewEditText: SearchView? = null

    private var sections = mutableListOf<SectionVm>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle(getString(R.string.fragment_menu_toolbar_title))
    }

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

    override fun initObservers() {
    }

    private fun openFilterMenu() {
        val (sortingType, filterType) = vm.getFilters()
        val fragment = FiltersBottomDialogFragment.newInstanse(sortingType, filterType)
        fragment.show(requireFragmentManager(), FiltersBottomDialogFragment.TAG)
        fragment.setFilterChangeListener(object : FilterChangeListener {
            override fun onSaveButtonClick(sortingType: String?, filterType: String?) {
                vm.setFilters(sortingType, filterType)
            }
            override fun onResetButtonClick() { vm.setFilters(null, null) }
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
