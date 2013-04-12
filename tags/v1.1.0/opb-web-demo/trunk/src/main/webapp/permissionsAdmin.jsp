<?xml version="1.0" encoding="iso-8859-1" standalone="yes" ?>
<jsp:root
    xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
    xmlns:ui="http://java.sun.com/jsf/facelets"
    xmlns:f="http://java.sun.com/jsf/core"
    xmlns:tr="http://myfaces.apache.org/trinidad">

<ui:composition template="WEB-INF/facelets/template.jsp">
    <ui:define name="body">

    <tr:panelBox background="medium" text="Permissions Administration">
        <tr:panelHorizontalLayout valign="top" halign="left">
        <tr:table
            emptyText="No Permissions Found"
            value="#{PermissionsAdmin.permissions.permissions}"
            var="var">
            <f:facet name="actions">
                <tr:panelHorizontalLayout>
                    <tr:inputText
                        onfocus="select();"
                        value="#{PermissionsAdmin.permissions.permissionSearchString}"/>

                    <tr:spacer width="10" height="10"/>

                    <tr:commandLink
                        blocking="true"
                        accessKey="F"
                        shortDesc="Filter by Permission Name"
                        text="Filter"/>

                </tr:panelHorizontalLayout>
            </f:facet>

            <tr:column headerText="Permission">
                <tr:outputText value="#{var.permission}"/>
            </tr:column>
            <tr:column headerText="Description">
                <tr:inputText 
                    autoSubmit="true"
                    value="#{var.description}" />
            </tr:column>
            <tr:column headerText="Status">
                <tr:selectOneChoice 
                    autoSubmit="true"
                    value="#{var.status}">
                    <f:selectItems value="#{var.permissionStatuses}"/>
                </tr:selectOneChoice>
            </tr:column>

            <tr:column>
                <tr:commandLink
                    blocking="true"
                    action="#{var.updatePermission}"
                    text="Update"/>
            </tr:column>

            <tr:column>
                <tr:commandLink
                    blocking="true"
                    action="#{var.deletePermission}"
                    text="Delete"/>
            </tr:column>

        </tr:table>

        <tr:spacer height="10" width="10"/>

        <tr:panelGroupLayout layout="vertical">

            <tr:panelBox
                background="medium"
                text="Create new Permission">
                <tr:panelFormLayout>
                    <tr:inputText
                        value="#{PermissionsAdmin.newPermission.newPermission}"
                        label="Permission"/>
                    <tr:inputText
                        value="#{PermissionsAdmin.newPermission.description}"
                        label="Description"/>

                    <tr:selectOneChoice
                        value="#{PermissionsAdmin.newPermission.status}"
                        label="Status">
                        <f:selectItems
                            value="#{PermissionsAdmin.newPermission.permissionStatuses}"/>
                    </tr:selectOneChoice>
                    <tr:panelLabelAndMessage>
                        <tr:commandButton
                            blocking="true"
                            action="#{PermissionsAdmin.newPermission.createPermission}"
                            text="Create New Permission"/>

                    </tr:panelLabelAndMessage>

                    <tr:panelLabelAndMessage>
                        <tr:commandLink
                            blocking="true"
                            accessKey="C"
                            action="#{PermissionsAdmin.newPermission.opbClearState}"
                            text="Clear Form"/>
                    </tr:panelLabelAndMessage>
                </tr:panelFormLayout>
            </tr:panelBox>

            <tr:spacer height="10" width="10"/>

            <tr:commandButton
                blocking="true"
                textAndAccessKey="&amp;Goto Permission Sets Administration"
                action="permissionSetsAdmin"/>

            </tr:panelGroupLayout>
        </tr:panelHorizontalLayout>
    </tr:panelBox>

    </ui:define>
</ui:composition>

</jsp:root>