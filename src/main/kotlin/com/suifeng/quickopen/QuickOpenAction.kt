package com.suifeng.quickopen

import com.intellij.ide.IdeBundle
import com.intellij.ide.RecentProjectListActionProvider
import com.intellij.ide.actions.GotoActionBase
import com.intellij.ide.util.gotoByName.ChooseByNameFilter
import com.intellij.ide.util.gotoByName.ChooseByNamePopup
import com.intellij.ide.util.gotoByName.DefaultChooseByNameItemProvider
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.application.ModalityState
import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.project.DumbAware
import com.intellij.pom.Navigatable
import com.suifeng.quickopen.data.QOItemData
import com.suifeng.quickopen.item.QONavigationItem
import com.suifeng.quickopen.model.QOGoToProjectModel

class QuickOpenAction : GotoActionBase(), DumbAware {

    private val recentOpenedProject = RecentProjectListActionProvider.getInstance().getActions()

    override fun gotoActionPerformed(e: AnActionEvent) {
//        val actions = RecentProjectListActionProvider.getInstance().getActions()
        for (action in recentOpenedProject) {
            QuickOpen.log.info("recentProject fun2 = $action")
        }
        e.getData(CommonDataKeys.PROJECT)?.let { project ->
            showNavigationPopup(
                e,
                QOGoToProjectModel(project),
                object : GotoActionBase.GotoActionCallback<FileType>() {
//                    override fun createFilter(popup: ChooseByNamePopup): ChooseByNameFilter<FileType>? {
//                        return super.createFilter(popup)
//                    }
                    override fun elementChosen(popup: ChooseByNamePopup?, element: Any?) {
                        // TODO
                        (element as? QONavigationItem)?.let {
                            QuickOpen.log.info(
                                "elementChosen ${
                                    it.projectData.projectPath
                                }"
                            )
                            ApplicationManager.getApplication().invokeLater({
                                (element as? Navigatable)?.navigate(true)
                            }, ModalityState.NON_MODAL)
                        } ?: run {
                            QuickOpen.log.info("elementChosen is ${element}")
                        }
                    }
                },
                "QUICK OPEN PROJECT",
                true,
                false,
                DefaultChooseByNameItemProvider(getPsiContext(e))
            )
        }


    }


}