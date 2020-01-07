package ru.ar4i.sqlearn.data.repositories.sections

import ru.ar4i.sqlearn.data.entities.SectionVm

interface ISectionsRepository {
   suspend fun insertSection(sectionId: Int)
   suspend fun getSections(): List<SectionVm>
   suspend fun deleteSectionById(sectionId: Int)
}