package com.suifeng.quickopen.item

import com.intellij.ide.impl.ProjectUtil
import com.intellij.navigation.ItemPresentation
import com.intellij.navigation.NavigationItem
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ex.ProjectManagerEx
import com.intellij.openapi.wm.WindowManager
import com.suifeng.quickopen.QuickOpen
import com.suifeng.quickopen.data.QOItemData
import com.suifeng.quickopen.presentation.QOPresentation

/**
 *@author suifengczc
 *@date 2021/10/29
 */
class QONavigationItem( val projectData: QOItemData) : NavigationItem {

    override fun navigate(requestFocus: Boolean) {
        val manager = ProjectManagerEx.getInstance() as ProjectManagerEx
        val openedProjects = manager.openProjects
        val project = openedProjects.find { it.name == projectData.projectName }
        QuickOpen.log.info("navigate project = ${project?.basePath}, ${project?.name}, ${project?.isOpen}, ${project?.projectFilePath}")
        if (project != null) {
            focusOnOpenedProject(project)
            return
        }
        ProjectUtil.openOrImport(projectData.projectPath, null, false)
    }

    private fun focusOnOpenedProject(openProject: Project) {
        val projectFrame = WindowManager.getInstance().getFrame(openProject)
        val frameState = projectFrame!!.extendedState
        if (frameState and 1 == 1) {
            projectFrame.extendedState = frameState xor 1
        }

        projectFrame.toFront()
        projectFrame.requestFocus()
    }

    override fun canNavigate() = true

    override fun canNavigateToSource() = false

    override fun getName(): String = projectData.projectPath

    override fun getPresentation() = QOPresentation(projectData)
}