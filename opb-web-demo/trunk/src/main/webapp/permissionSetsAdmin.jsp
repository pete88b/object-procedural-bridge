<?xml version="1.0" encoding="iso-8859-1" standalone="yes" ?>
<jsp:root
    xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
    xmlns:ui="http://java.sun.com/jsf/facelets"
    xmlns:f="http://java.sun.com/jsf/core"
    xmlns:tr="http://myfaces.apache.org/trinidad">

<ui:composition template="WEB-INF/facelets/template.jsp">
    <ui:define name="body">

    <tr:panelBox background="medium" text="Permission Sets Administration">

        <tr:panelGroupLayout
            layout="vertical">
            <tr:panelHorizontalLayout valign="top" halign="left">

                <tr:treeTable
                    emptyText="No Permissions Found"
                    value="#{PermissionSetsAdmin.permissionsTree}"
                    var="var">

                    <f:facet name="nodeStamp">
                        <tr:column headerText="Permission">
                            <tr:outputText value="#{var.permission}"/>
                        </tr:column>
                    </f:facet>

                    <tr:column>
                        <tr:selectBooleanCheckbox
                            onchange="document.forms[0].submit();"
                            onclick="document.forms[0].submit();"
                            rendered="#{var != PermissionSetsAdmin.rootNode}"
                            value="#{var.groupManagerMap.selectedForAllow}"/>
                    </tr:column>
                    <tr:column>
                        <tr:commandLink
                            blocking="true"
                            rendered="#{var != PermissionSetsAdmin.rootNode and PermissionSetsAdmin.permissionSelectedForAllow != null and PermissionSetsAdmin.permissionSelectedForAllow != var and var.permissionSet == null}"
                            action="#{PermissionSetsAdmin.allow}"
                            text="Allow"
                            shortDesc="allow #{PermissionSetsAdmin.permissionSelectedForAllow.permission} the #{var.permission} permission">
                            <f:param name="allowPermission" value="#{var.permission}"/>
                        </tr:commandLink>

                        <tr:commandLink
                            blocking="true"
                            rendered="#{var != PermissionSetsAdmin.rootNode and var.permissionSet != null}"
                            action="#{var.deny}"
                            text="Deny"
                            shortDesc="deny #{var.permissionSet} the #{var.permission} permission"/>
                    </tr:column>

                    <tr:column headerText="Description">
                        <tr:inputText value="#{var.description}" readOnly="true"/>
                    </tr:column>

                    <tr:column headerText="Status">
                        <tr:selectOneChoice
                            rendered="#{var != PermissionSetsAdmin.rootNode}"
                            disabled="true"
                            value="#{var.status}">
                            <f:selectItems
                                value="#{var.permissionStatuses}"/>
                        </tr:selectOneChoice>

                    </tr:column>

                    <tr:column headerText="Filter">
                        <tr:inputText
                            onchange="document.forms[0].submit();"
                            onfocus="select();"
                            value="#{var.permissionSearchString}"/>
                    </tr:column>

                </tr:treeTable>

            </tr:panelHorizontalLayout>

            <tr:spacer height="10" width="10"/>

            <tr:commandButton
                blocking="true"
                textAndAccessKey="&amp;Goto Permissions Administration"
                action="permissionsAdmin"/>

        </tr:panelGroupLayout>

    </tr:panelBox>

    </ui:define>
</ui:composition>

</jsp:root>