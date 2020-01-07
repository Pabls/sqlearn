package ru.ar4i.sqlearn.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CompletedSectionsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSection(section: CompletedSection)

    @Query(
        """
       SELECT * FROM completed_sections; 
    """
    )
    suspend fun getCompletedSections(): List<CompletedSection>

    @Query(
        """
       DELETE FROM completed_sections WHERE id=:sectionId; 
    """
    )
    suspend fun deleteSections(sectionId: Int)
}