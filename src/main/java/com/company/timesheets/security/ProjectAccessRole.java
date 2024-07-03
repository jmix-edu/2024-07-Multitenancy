package com.company.timesheets.security;

import com.company.timesheets.entity.Client;
import com.company.timesheets.entity.Project;
import com.company.timesheets.entity.User;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securityflowui.role.annotation.MenuPolicy;
import io.jmix.securityflowui.role.annotation.ViewPolicy;

@ResourceRole(name = "ProjectAccess", code = ProjectAccessRole.CODE, scope = "UI")
public interface ProjectAccessRole {
    String CODE = "project-access";


    @MenuPolicy(menuIds = {"ts_Client.list", "ts_Project.list", "ts_User.list"})
    @ViewPolicy(viewIds = {"ts_Client.list", "ts_Project.list", "ts_Client.detail", "ts_Project.detail", "ts_User.list", "ts_User.detail"})
    void screens();

    @EntityAttributePolicy(entityClass = Client.class, attributes = {"id", "image", "name", "contactInformation", "version", "deletedBy", "deletedDate"}, action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Client.class, actions = EntityPolicyAction.ALL)
    void client();

    @EntityAttributePolicy(entityClass = Project.class, attributes = {"id", "name", "client", "description", "status", "tasks", "participants", "version", "deletedBy", "deletedDate"}, action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Project.class, actions = EntityPolicyAction.ALL)
    void project();

    @EntityAttributePolicy(entityClass = User.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = User.class, actions = EntityPolicyAction.ALL)
    void user();
}