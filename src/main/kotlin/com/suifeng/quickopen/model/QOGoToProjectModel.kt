package com.suifeng.quickopen.model

import com.intellij.ide.util.gotoByName.FilteringGotoByModel
import com.intellij.navigation.NavigationItem
import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFile
import com.suifeng.quickopen.contributor.QOChooseByNameContributor

class QOGoToProjectModel(project: Project) :
    FilteringGotoByModel<FileType>(
        project,
        listOf(QOChooseByNameContributor())
    ) {
    override fun getPromptText(): String {
        return ""
    }

    override fun getNotInMessage(): String {
        return ""
    }

    override fun getNotFoundMessage(): String {
        return ""
    }

    override fun getCheckBoxName(): String? {
        return ""
    }

    override fun loadInitialCheckBoxState(): Boolean {
        return false
    }

    override fun saveInitialCheckBoxState(state: Boolean) {

    }

    override fun getSeparators(): Array<String> {
        return arrayOf("")
    }

    override fun getFullName(element: Any): String? {
        return "fullname"
    }

    override fun willOpenEditor(): Boolean {
        return true
    }

    override fun filterValueFor(item: NavigationItem?): FileType? {
        return (item as? PsiFile)?.fileType
    }
}