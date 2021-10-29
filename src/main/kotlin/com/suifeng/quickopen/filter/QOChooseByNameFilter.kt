package com.suifeng.quickopen.filter

import com.intellij.ide.util.gotoByName.ChooseByNameFilter
import com.intellij.ide.util.gotoByName.ChooseByNamePopup
import com.intellij.openapi.project.Project
import com.suifeng.quickopen.contributor.QOChooseByNameContributor
import com.suifeng.quickopen.data.QOItemData
import com.suifeng.quickopen.model.QOGoToProjectModel
import javax.swing.Icon

/**
 *@author suifengczc
 *@date 2021/10/30
 */
class QOChooseByNameFilter(
    val popup: ChooseByNamePopup,
    val model: QOGoToProjectModel,
    filterConfiguration: QOChooseByNameFilterConfiguration,
    project: Project
) :
    ChooseByNameFilter<QOItemData>(popup, model, filterConfiguration, project) {
    override fun textForFilterValue(value: QOItemData): String {
        return value.projectPath
    }

    override fun iconForFilterValue(value: QOItemData): Icon? {
        return null
    }

    override fun getAllFilterValues(): MutableCollection<QOItemData> {
        // TODO
//        QOChooseByNameContributor.
        return mutableListOf()
    }
}