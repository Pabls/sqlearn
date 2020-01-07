package ru.ar4i.sqlearn.data.repositories.sections

import android.content.Context
import ru.ar4i.sqlearn.R
import ru.ar4i.sqlearn.data.database.CompletedSection
import ru.ar4i.sqlearn.data.database.CompletedSectionsDao
import ru.ar4i.sqlearn.data.entities.SectionVm

object SectionsRepository : ISectionsRepository {

    private lateinit var context: Context
    private lateinit var completedSectionsDao: CompletedSectionsDao

    fun setContext(context: Context) {
        SectionsRepository.context = context
    }

    override suspend fun insertSection(sectionId: Int) {
        completedSectionsDao.insertSection(CompletedSection(id = sectionId))
    }

    override suspend fun getSections(): List<SectionVm> {
        val completedSections = completedSectionsDao.getCompletedSections().map { it.id }
        val sectionsArray = context.resources.getStringArray(R.array.sections)
        val descriptionsArray = context.resources.getStringArray(R.array.description)
        val sections = mutableListOf<SectionVm>()

        var index = 0
        for (sectionName in sectionsArray) {
            sections.add(
                SectionVm(
                    id = index + 1,
                    name = sectionName,
                    description = descriptionsArray[index],
                    isDone = completedSections.contains(index + 1)
                )
            )
            index += 1
        }

        return sections
    }

    override suspend fun deleteSectionById(sectionId: Int) {
        completedSectionsDao.deleteSections(sectionId)
    }
}