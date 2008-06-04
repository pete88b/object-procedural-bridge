<?xml version="1.0" encoding="iso-8859-1" standalone="yes" ?>
<jsp:root 
    xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
    xmlns:demo="http://butterfill.com/opb/webdemo/jsf"
    xmlns:ui="http://java.sun.com/jsf/facelets"
    xmlns:f="http://java.sun.com/jsf/core"
    xmlns:tr="http://myfaces.apache.org/trinidad">
    
<ui:composition template="WEB-INF/facelets/template.jsp">
    <ui:define name="body">

<tr:panelBox background="medium" text="Database Logging Administration">

    <tr:panelTabbed position="above">
        <tr:showDetailItem
            disclosureListener="#{DbLoggingAdmin.tabDisclosed}"
            shortDesc="Show Logger Flags [Alt+F]"
            textAndAccessKey="Logger &amp;Flags">

            <tr:table
                rowBandingInterval="1"
                emptyText="No Logger Flags Found"
                rows="10"
                value="#{DbLoggingAdmin.loggingAdmin.loggerFlags}"
                var="var">
                <f:facet name="header">
                    <tr:outputText value="Logger Flags"/>
                </f:facet>

                <tr:column headerText="Log User" >
                    <tr:inputText value="#{var.logUser}"/>
                </tr:column>

                <tr:column headerText="Log Level" >
                    <tr:inputText value="#{var.logLevel}"/>
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

            <tr:spacer height="10" width="10"/>

            <tr:table
                value="#{DbLoggingAdmin.newLoggerFlagAsArray}"
                partialTriggers="newFlagClearFormLink"
                var="var">
                <f:facet name="header">
                    <tr:outputText value="New Logger Flag"/>
                </f:facet>

                <f:facet name="footer">
                    <tr:commandLink
                        id="newFlagClearFormLink"
                        blocking="true"
                        partialSubmit="true"
                        text="Clear Form"
                        action="#{DbLoggingAdmin.newLoggerFlag.opbClearState}"/>
                </f:facet> 

                <tr:column headerText="Log User" >
                    <tr:inputText value="#{var.logUser}"/>
                </tr:column>

                <tr:column headerText="Log Level" >
                    <tr:inputText value="#{var.logLevel}"/>
                </tr:column>

                <tr:column>
                    <tr:commandLink
                        blocking="true"
                        text="Create"
                        action="#{var.ins}"/>
                </tr:column>

            </tr:table>

        </tr:showDetailItem>

        <tr:showDetailItem
            disclosureListener="#{DbLoggingAdmin.tabDisclosed}"
            text="Logged Data"
            shortDesc="Show Logged Data">

            <tr:table
                partialTriggers="minutesInput dateFormatInput"
                rowBandingInterval="1"
                emptyText="No Logged Data Found"
                rows="50"
                value="#{DbLoggingAdmin.loggingAdmin.loggedData}"
                var="var">
                <f:facet name="actions">
                    <tr:panelGroupLayout layout="horizontal">
                        <tr:inputText
                            id="minutesInput"
                            label="Minutes" 
                            autoSubmit="true"
                            shortDesc="Show rows logged in the last n minutes. Default: 1"
                            value="#{DbLoggingAdmin.loggingAdmin.lastNMinutes}"/>
                        <tr:spacer height="10" width="10"/>
                        <tr:inputText
                            id="dateFormatInput"
                            label="Date Format" 
                            autoSubmit="true"
                            shortDesc="Date Format. Default: hh24:mi:ss"
                            value="#{DbLoggingAdmin.loggingAdmin.dateFormat}"/>
                    </tr:panelGroupLayout>
                </f:facet>

                <demo:outputTextColumn
                    headerText="Log Date"
                    value="${var.logDate}"/>

                <demo:outputTextColumn
                    headerText="Log User"
                    value="${var.logUser}"/>

                <demo:outputTextColumn
                    headerText="Log Seq"
                    shortDesc="Log Sequence"
                    value="${var.logSeq}"/>

                <demo:outputTextColumn
                    headerText="Log Level"
                    value="${var.logLevel}"/>

                <demo:outputTextColumn
                    headerText="Log Data"
                    value="${var.logData}"/>

                <tr:column
                    headerText="Module Name (Line)">
                    <tr:outputText
                        value="#{var.moduleName}"/>
                    <tr:outputText
                        value="(#{var.moduleLine})"/>
                </tr:column>

                <demo:outputTextColumn
                    headerText="Error Message"
                    value="${var.errorMessage}"/>

                <demo:outputTextColumn
                    headerText="Error Code"
                    value="${var.errorCode}"/>

                <demo:outputTextColumn
                    headerText="Error Backtrace"
                    value="${var.errorBacktrace}"/>

                <demo:outputTextColumn
                    headerText="Call Stack"
                    value="${var.callStack}"/>

                <demo:outputTextColumn
                    headerText="Module Owner"
                    value="${var.moduleOwner}"/>

                <demo:outputTextColumn
                    headerText="Module Type"
                    value="${var.moduleType}"/>

                <demo:outputTextColumn
                    headerText="Module Call Level"
                    value="${var.moduleCallLevel}"/>

                <demo:outputTextColumn
                    headerText="Source"
                    value="${var.source}"/>

            </tr:table>

        </tr:showDetailItem>

        <tr:showDetailItem
            disclosureListener="#{DbLoggingAdmin.tabDisclosed}"
            text="Logged Errors"
            shortDesc="Show Logged Errors">

            <tr:table
                partialTriggers="renderCallStackCheckbox renderErrorBacktraceCheckbox minutesInput2 dateFormatInput2"
                rowBandingInterval="1"
                emptyText="No Logged Errors Found"
                rows="20"
                value="#{DbLoggingAdmin.loggingAdmin.loggedErrors}"
                var="var">
                <f:facet name="actions">
                    <tr:panelButtonBar>

                        <tr:inputText
                            id="minutesInput2"
                            label="Minutes" 
                            autoSubmit="true"
                            shortDesc="Show rows logged in the last n minutes. Default: 1440 (1 day)"
                            value="#{DbLoggingAdmin.loggingAdmin.lastNMinutes}"/>

                        <tr:inputText
                            id="dateFormatInput2"
                            label="Date Format" 
                            autoSubmit="true"
                            shortDesc="Date Format. Default: hh24:mi:ss"
                            value="#{DbLoggingAdmin.loggingAdmin.dateFormat}"/>

                        <tr:selectBooleanCheckbox 
                            id="renderErrorBacktraceCheckbox"
                            autoSubmit="true"
                            text="Show Error Backtrace" 
                            value="#{DbLoggingAdmin.renderErrorBacktrace}"/>

                        <tr:selectBooleanCheckbox 
                            id="renderCallStackCheckbox"
                            autoSubmit="true"
                            text="Show Call Stack" 
                            value="#{DbLoggingAdmin.renderCallStack}"/>

                    </tr:panelButtonBar>

                </f:facet>

                <demo:outputTextColumn
                    headerText="Log Date"
                    value="${var.logDate}"/>

                <demo:outputTextColumn
                    headerText="Log User"
                    value="${var.logUser}"/>

                <demo:outputTextColumn
                    headerText="Log Seq"
                    shortDesc="Log Sequence"
                    value="${var.logSeq}"/>

                <demo:outputTextColumn
                    headerText="Log Level"
                    value="${var.logLevel}"/>

                <demo:outputTextColumn
                    headerText="Log Data"
                    value="${var.logData}"/>

                <tr:column
                    headerText="Module Name (Line)">
                    <tr:outputText
                        value="#{var.moduleName}"/>
                    <tr:outputText
                        value="(#{var.moduleLine})"/>
                </tr:column>

                <demo:outputTextColumn
                    headerText="Error Message"
                    value="${var.errorMessage}"/>

                <demo:outputTextColumn
                    headerText="Error Code"
                    value="${var.errorCode}"/>

                <tr:column 
                    headerText="Error Backtrace"
                    rendered="#{DbLoggingAdmin.renderErrorBacktrace}">
                    <tr:outputFormatted
                        value="&lt;pre>#{var.errorBacktrace}&lt;/pre>"/>
                </tr:column>

                <tr:column 
                    headerText="Call Stack"
                    rendered="#{DbLoggingAdmin.renderCallStack}">
                    <tr:outputFormatted
                        value="&lt;pre>#{var.callStack}&lt;/pre>"/>
                </tr:column>

                <demo:outputTextColumn
                    headerText="Module Owner"
                    value="${var.moduleOwner}"/>

                <demo:outputTextColumn
                    headerText="Module Type"
                    value="${var.moduleType}"/>

                <demo:outputTextColumn
                    headerText="Module Call Level"
                    value="${var.moduleCallLevel}"/>

            </tr:table>

        </tr:showDetailItem>

    </tr:panelTabbed>

</tr:panelBox>  

    </ui:define>
</ui:composition>
    
</jsp:root>