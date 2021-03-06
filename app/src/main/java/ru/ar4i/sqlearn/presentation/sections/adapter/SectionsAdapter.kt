package ru.ar4i.sqlearn.presentation.sections.adapter

import android.os.Build
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import ru.ar4i.sqlearn.R
import ru.ar4i.sqlearn.data.entities.SectionVm

class SectionsAdapter(private val listener: (String) -> Unit) :
    RecyclerView.Adapter<SectionsAdapter.SectionViewHolder>() {

    private var items = mutableListOf<SectionVm>()

    fun setData(data: List<SectionVm>) {
        items.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_section, parent, false)
        return SectionViewHolder(v, listener = listener)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: SectionViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class SectionViewHolder(view: View, private val listener: (String) -> Unit) :
        RecyclerView.ViewHolder(view) {

        private var clContainer: ConstraintLayout
        private var imgDone: ImageView
        private var tvSectionName: TextView
        private var tvDescription: TextView

        init {
            clContainer = view.findViewById(R.id.cl_container)
            imgDone = view.findViewById(R.id.img_done)
            tvSectionName = view.findViewById(R.id.tv_section_name)
            tvDescription = view.findViewById(R.id.tv_description)
        }

        fun bind(section: SectionVm) {
            val sectionId =
                "${tvSectionName.context.getString(R.string.item_section_section)} " +
                        "${section.id}${tvSectionName.context.getString(R.string.item_section_dot)}"
            tvSectionName.text = "$sectionId ${section.name}"
            tvDescription.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                Html.fromHtml(section.description, Html.FROM_HTML_OPTION_USE_CSS_COLORS)
            } else {
                section.description
            }
            clContainer.setOnClickListener { listener.invoke(section.name) }
            imgDone.visibility = if (section.isDone) View.VISIBLE else View.GONE
        }
    }
}