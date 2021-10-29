package com.suifeng.quickopen.contributor

import com.intellij.navigation.ChooseByNameContributor
import com.intellij.navigation.NavigationItem
import com.intellij.openapi.project.Project

class QOChooseByNameContributor: ChooseByNameContributor{
    override fun getNames(project: Project?, includeNonProjectItems: Boolean): Array<String> {
        TODO("Not yet implemented")
    }

    override fun getItemsByName(
        name: String?,
        pattern: String?,
        project: Project?,
        includeNonProjectItems: Boolean
    ): Array<NavigationItem> {
        TODO("Not yet implemented")
    }
}