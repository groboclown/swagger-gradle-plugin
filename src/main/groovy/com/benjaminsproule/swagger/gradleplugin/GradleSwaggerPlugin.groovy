package com.benjaminsproule.swagger.gradleplugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class GradleSwaggerPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.dependencies.add('compile', 'io.swagger:swagger-core:1.5.4', {
            exclude group: 'javax.ws.rs', module: 'jsr311-api'
        })

        project.extensions.create('swagger', SwaggerPluginExtension, project)

        project.task(GenerateSwaggerDocsTask.TASK_NAME, type: GenerateSwaggerDocsTask, dependsOn: 'classes')
    }
}