package com.suifeng.quickopen.filter

import com.intellij.ide.util.gotoByName.ChooseByNameFilterConfiguration
import com.suifeng.quickopen.data.QOItemData

/**
 *@author suifengczc
 *@date 2021/10/30
 */
class QOChooseByNameFilterConfiguration : ChooseByNameFilterConfiguration<QOItemData>() {
    override fun nameForElement(type: QOItemData?): String {
        return type?.projectPath ?: ""
    }
}