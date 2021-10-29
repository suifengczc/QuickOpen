package com.suifeng.quickopen.presentation

import com.intellij.navigation.ItemPresentation
import com.suifeng.quickopen.data.QOItemData
import javax.swing.Icon

/**
 *@author suifengczc
 *@date 2021/10/30
 */
class QOPresentation(private val project: QOItemData) : ItemPresentation {
    override fun getPresentableText(): String? {
        return project.projectPath
    }

    override fun getIcon(unused: Boolean): Icon? = null
}