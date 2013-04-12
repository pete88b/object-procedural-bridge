<?xml version="1.0" encoding="iso-8859-1" standalone="yes" ?>
<jsp:root
    xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
    xmlns:ui="http://java.sun.com/jsf/facelets"
    xmlns:f="http://java.sun.com/jsf/core"
    xmlns:tr="http://myfaces.apache.org/trinidad">
    
<ui:composition template="WEB-INF/facelets/template.jsp">
    <ui:define name="body">
        
        <tr:panelBox background="medium" text="Properties Administration">
            
            <tr:panelTabbed position="above">
                <tr:showDetailItem
                    textAndAccessKey="&amp;Groups">
                    
                    <tr:table
                        rowBandingInterval="1"
                        emptyText="No Property Groups Found"
                        rows="15"
                        value="#{PropertiesAdmin.propertyGroups.propertyGroups}"
                        var="var">
                        
                        <f:facet name="header">
                            <tr:outputText value="Property Groups"/>
                        </f:facet>
                        
                        <tr:column>
                            <tr:selectBooleanRadio
                                group="propertyGroups"
                                value="#{var.groupManagerMap.singleSelectedPropertyGroup}"/>
                        </tr:column>
                        <tr:column
                            headerText="Group Name">
                            <tr:outputText
                                value="#{var.groupName}"/>
                        </tr:column>
                        <tr:column
                            headerText="Single Value">
                            <tr:selectOneChoice
                                value="#{var.singleValuePerKey}">
                                <tr:selectItem value="N" label="No"/>
                                <tr:selectItem value="Y" label="Yes"/>
                            </tr:selectOneChoice>
                        </tr:column>
                        <tr:column
                            headerText="Locked">
                            <tr:selectOneChoice
                                value="#{var.locked}">
                                <tr:selectItem value="N" label="No"/>
                                <tr:selectItem value="Y" label="Yes"/>
                            </tr:selectOneChoice>
                        </tr:column>
                        <tr:column
                            headerText="Description">
                            <tr:inputText
                                columns="60"
                                value="#{var.groupDescription}"/>
                        </tr:column>
                        
                        <tr:column>
                            <tr:commandLink
                                blocking="true"
                                text="Update"
                                action="#{var.upd}"/>
                        </tr:column>
                        
                        <tr:column>
                            <tr:commandLink
                                blocking="true"
                                text="Delete"
                                action="#{var.del}"/>
                        </tr:column>
                        <tr:column>
                            <tr:selectBooleanCheckbox
                                shortDesc="Enable force delete for property group #{var.groupName}"
                                value="#{var.forceDelete}"/>
                        </tr:column>
                    </tr:table>
                    
                    <tr:spacer width="10" height="10"/>
                    
                    <tr:table
                        value="#{PropertiesAdmin.newPropertyGroupAsArray}"
                        var="var">
                        <f:facet name="header">
                            <tr:outputText value="New Property Group"/>
                        </f:facet>
                        
                        <f:facet name="footer">
                            <tr:commandLink
                                blocking="true"
                                textAndAccessKey="&amp;Clear Form"
                                action="#{PropertiesAdmin.newPropertyGroup.opbClearState}"/>
                        </f:facet>
                        
                        <tr:column
                            headerText="Group Name">
                            <tr:inputText
                                value="#{var.groupName}"/>
                        </tr:column>
                        <tr:column
                            headerText="Single Value">
                            <tr:selectOneChoice
                                value="#{var.singleValuePerKey}">
                                <tr:selectItem value="N" label="No"/>
                                <tr:selectItem value="Y" label="Yes"/>
                            </tr:selectOneChoice>
                        </tr:column>
                        
                        <tr:column
                            headerText="Description">
                            <tr:inputText
                                columns="60"
                                value="#{var.groupDescription}"/>
                        </tr:column>
                        
                        <tr:column>
                            <tr:commandLink
                                blocking="true"
                                text="Create"
                                action="#{PropertiesAdmin.createNewGroup}"/>
                        </tr:column>
                        
                    </tr:table>
                    
                </tr:showDetailItem>
                
                <tr:showDetailItem
                    textAndAccessKey="&amp;Properties">
                    
                    <tr:outputFormatted
                        rendered="#{PropertiesAdmin.selectedPropertyGroup == null}"
                        value="No Property Group Selected"
                        styleUsage="instruction"/>
                    
                    <tr:table
                        rendered="#{PropertiesAdmin.selectedPropertyGroup != null}"
                        rowBandingInterval="1"
                        emptyText="No Properties Found"
                        rows="15"
                        value="#{PropertiesAdmin.selectedPropertyGroup.propertyValues}"
                        var="var">
                        
                        <f:facet name="header">
                            <tr:outputText
                                value="Properties of group #{PropertiesAdmin.selectedPropertyGroup.groupName}"/>
                        </f:facet>
                        
                        <tr:column>
                            <tr:selectBooleanRadio
                                group="properties"
                                value="#{var.groupManagerMap.singleSelectedProperty}"/>
                        </tr:column>
                        
                        <tr:column headerText="Key">
                            <tr:outputText value="#{var.key}"/>
                        </tr:column>
                        
                        <tr:column headerText="Order">
                            <tr:inputText value="#{var.sortOrder}" columns="5"/>
                        </tr:column>
                        
                        <tr:column headerText="Value">
                            <tr:outputText
                                rendered="#{var.valueContainsCr}"
                                shortDesc="Use Multi-Line Edit to modify this value"
                                truncateAt="50"
                                value="#{var.value}"/>
                            <tr:inputText
                                rendered="#{!var.valueContainsCr}"
                                columns="45"
                                value="#{var.value}"/>
                        </tr:column>
                        
                        <tr:column headerText="Description">
                            <tr:inputText 
                                columns="60"
                                value="#{var.propertyDescription}"/>
                        </tr:column>
                        
                        <tr:column>
                            <tr:commandLink
                                blocking="true"
                                text="Update"
                                action="#{var.upd}"/>
                        </tr:column>
                        <tr:column>
                            <tr:commandLink
                                blocking="true"
                                text="Delete"
                                action="#{var.del}"/>
                        </tr:column>
                    </tr:table>
                    
                    <tr:spacer width="10" height="10"/>
                    
                    <tr:table
                        rendered="#{PropertiesAdmin.selectedPropertyGroup != null}"
                        value="#{PropertiesAdmin.newPropertyAsArray}"
                        var="var">
                        
                        <f:facet name="header">
                            <tr:outputText
                                value="New Property for group #{PropertiesAdmin.selectedPropertyGroup.groupName}"/>
                        </f:facet>
                        
                        <f:facet name="footer">
                            <tr:commandLink
                                blocking="true"
                                textAndAccessKey="&amp;Clear Form"
                                action="#{PropertiesAdmin.newProperty.opbClearState}"/>
                        </f:facet>
                        
                        <tr:column headerText="Key">
                            <tr:inputText 
                                columns="20"
                                value="#{var.key}"/>
                        </tr:column>
                        
                        <tr:column headerText="Order">
                            <tr:inputText value="#{var.sortOrder}" columns="5"/>
                        </tr:column>
                        
                        <tr:column headerText="Value">
                            <tr:inputText value="#{var.value}"/>
                        </tr:column>
                        
                        <tr:column headerText="Description">
                            <tr:inputText 
                                columns="60"
                                value="#{var.propertyDescription}"/>
                        </tr:column>
                        
                        <tr:column>
                            <tr:commandLink
                                blocking="true"
                                text="Add"
                                action="#{var.ins}"/>
                        </tr:column>
                    </tr:table>
                    
                </tr:showDetailItem>
                
                <tr:showDetailItem
                    textAndAccessKey="&amp;Multi-Line Edit">
                    
                    <tr:outputFormatted
                        value="#{PropertiesAdmin.textForSelectedProperty}"
                        styleUsage="instruction"/>
                    
                    <tr:panelGroupLayout
                        rendered="#{PropertiesAdmin.selectedProperty != null}"
                        layout="vertical">
                        <tr:inputText
                            contentStyle="font-family: courier"
                            columns="100"
                            rows="25"
                            wrap="hard"
                            value="#{PropertiesAdmin.selectedProperty.value}"/>
                        
                        <tr:spacer width="10" height="10"/>
                        
                        <tr:panelHorizontalLayout halign="left">
                            <tr:commandButton
                                blocking="true"
                                textAndAccessKey="&amp;Update Property Value"
                                action="#{PropertiesAdmin.selectedProperty.upd}"/>
                            <tr:spacer width="10" height="10"/>
                            <tr:commandButton
                                blocking="true"
                                textAndAccessKey="&amp;Delete Property Value"
                                action="#{PropertiesAdmin.selectedProperty.del}"/>
                        </tr:panelHorizontalLayout>
                    </tr:panelGroupLayout>
                    
                </tr:showDetailItem>
            </tr:panelTabbed>
        </tr:panelBox>
        
    </ui:define>
</ui:composition>

</jsp:root>