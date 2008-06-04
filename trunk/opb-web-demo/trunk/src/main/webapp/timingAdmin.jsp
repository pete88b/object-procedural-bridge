<?xml version="1.0" encoding="iso-8859-1" standalone="yes" ?>
<jsp:root
    xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
    xmlns:ui="http://java.sun.com/jsf/facelets"
    xmlns:f="http://java.sun.com/jsf/core"
    xmlns:tr="http://myfaces.apache.org/trinidad">
    
<ui:composition template="WEB-INF/facelets/template.jsp">
    <ui:define name="body">
        
<tr:panelBox background="medium" text="Timing Administration">
    <tr:panelHorizontalLayout valign="top" halign="left">
        <tr:panelGroupLayout layout="vertical">

            <tr:table
                emptyText="No Events Found"
                value="#{TimingAdmin.aggregates}" 
                var="var">

                <f:facet name="header">
                    <tr:outputText value="#{TimingAdmin.tableHeader}"/>
                </f:facet>

                <f:facet name="footer">
                    <tr:panelHorizontalLayout>
                        <tr:selectBooleanCheckbox
                            onchange="document.forms[0].submit();"
                            onclick="document.forms[0].submit();"
                            textAndAccessKey="T&amp;iming Enabled"
                            value="#{TimingAdmin.timingEnabled}"/>

                        <tr:spacer height="10" width="10"/>

                        <tr:commandLink
                            blocking="true"
                            action="#{TimingAdmin.clearTimingEvents}"
                            textAndAccessKey="&amp;Clear Timing Events"/>
                    </tr:panelHorizontalLayout>
                </f:facet>

                <tr:column headerText="Event Name" 
                    sortable="true" sortProperty="eventName">
                    <tr:outputText truncateAt="60" value="#{var.eventName}"/>
                </tr:column>

                <tr:column headerText="Average Duration" 
                    sortable="true" sortProperty="averageEventDuration">
                    <tr:outputText value="#{var.averageEventDuration}"/>
                </tr:column>

                <tr:column headerText="Minimum Duration" 
                    sortable="true" sortProperty="minimumEventDuration">
                    <tr:outputText value="#{var.minimumEventDuration}"/>
                </tr:column>

                <tr:column headerText="Maximum Duration" 
                    sortable="true" sortProperty="maximumEventDuration">
                    <tr:outputText value="#{var.maximumEventDuration}"/>
                </tr:column>

                <tr:column headerText="Event Count" 
                    sortable="true" sortProperty="eventCount">
                    <tr:outputText value="#{var.eventCount}"/>
                </tr:column>

                <tr:column headerText="Total Duration" 
                    sortable="true" sortProperty="totalEventDuration">
                    <tr:outputText value="#{var.totalEventDuration}"/>
                </tr:column>

            </tr:table>

        </tr:panelGroupLayout>
    </tr:panelHorizontalLayout>
</tr:panelBox>

    </ui:define>
</ui:composition>

</jsp:root>