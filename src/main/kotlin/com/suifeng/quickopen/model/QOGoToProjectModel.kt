package com.suifeng.quickopen.model

import com.intellij.ide.util.gotoByName.FilteringGotoByModel
import com.intellij.navigation.NavigationItem
import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFile
import com.suifeng.quickopen.contributor.QOChooseByNameContributor
import com.suifeng.quickopen.data.QOItemData
import com.suifeng.quickopen.item.QONavigationItem

class QOGoToProjectModel(project: Project) :
    FilteringGotoByModel<QOItemData>(
        project,
        listOf(QOChooseByNameContributor())
    ) {
    /**
     * 搜索框标题
     */
    override fun getPromptText(): String {
        return "QUICK OPEN"
    }

    override fun getNotInMessage(): String {
        return "NOT IN MESSAGE"
    }

    override fun getNotFoundMessage(): String {
        return "NOT FOUND MESSAGE"
    }

    override fun getCheckBoxName(): String? {
        return "CHECK BOX NAME"
    }

    override fun loadInitialCheckBoxState(): Boolean {
        return false
    }

    override fun saveInitialCheckBoxState(state: Boolean) {

    }

    override fun getSeparators(): Array<String> {
        return arrayOf("/", "\\")
    }

    override fun getFullName(element: Any): String? {
        return (element as? QONavigationItem)?.projectData?.projectPath
    }

    override fun willOpenEditor(): Boolean {
        return true
    }

    /**
     * 命中选项
     */
    override fun filterValueFor(item: NavigationItem?): QOItemData? {
        return (item as? QONavigationItem)?.projectData
    }
}