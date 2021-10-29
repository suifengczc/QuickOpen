package com.suifeng.quickopen.contributor

import com.intellij.ide.RecentProjectListActionProvider
import com.intellij.ide.ReopenProjectAction
import com.intellij.navigation.ChooseByNameContributor
import com.intellij.navigation.NavigationItem
import com.intellij.openapi.project.Project
import com.suifeng.quickopen.QuickOpen
import com.suifeng.quickopen.data.QOItemData
import com.suifeng.quickopen.item.QONavigationItem

class QOChooseByNameContributor : ChooseByNameContributor {
    private val allRecentProjectData: Array<QOItemData>

    init {
        val actions = RecentProjectListActionProvider.getInstance().getActions()
        allRecentProjectData = actions.mapNotNull {
            (it as? ReopenProjectAction)?.let { reopen ->
                QOItemData(reopen.projectName, reopen.projectPath)
            }
        }.toTypedArray()
    }

    /**
     * 提供全部搜索选项
     */
    override fun getNames(project: Project?, includeNonProjectItems: Boolean): Array<String> {
        return allRecentProjectData.map { it.projectName }.toTypedArray()
    }

    /**
     * 匹配到的项
     */
    override fun getItemsByName(
        name: String?,
        pattern: String?,
        project: Project?,
        includeNonProjectItems: Boolean
    ): Array<NavigationItem> {
        QuickOpen.log.info("getItemsByName name = ${name}, pattern = ${pattern}")
        if (name == null) {
            return arrayOf()
        }
        return allRecentProjectData.filter {
            it.projectPath.contains(name)
        }.map { QONavigationItem(it) }.toTypedArray()
    }
}