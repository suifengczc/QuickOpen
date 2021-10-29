package com.suifeng.quickopen

import com.intellij.ide.RecentProjectListActionProvider
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.DumbAware

class QuickOpenAction : AnAction(), DumbAware {
    override fun actionPerformed(e: AnActionEvent) {
        val actions = RecentProjectListActionProvider.getInstance().getActions()
        for (action in actions) {
            println("recentProject fun2 = $action")
        }
    }


}