package com.istody.simulei.repository

import androidx.annotation.WorkerThread
import com.istody.simulei.data.dao.FolderDao
import com.istody.simulei.data.model.Folder
import kotlinx.coroutines.flow.Flow

class FolderRepository(private val folderDao: FolderDao) {

    val folderList: Flow<List<Folder>> = folderDao.getFolderList()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertFolder(folder: Folder) {
        folderDao.insertFolder(folder)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun updateFolder(folderId: Int, folderName: String) {
        folderDao.updateFolder(folderId, folderName)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun deleteFolder(folder: Folder) {
        folderDao.deleteFolder(folder)
    }
}