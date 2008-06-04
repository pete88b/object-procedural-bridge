<?xml version="1.0" encoding="iso-8859-1" standalone="yes" ?>
<jsp:root 
    xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
    xmlns:ui="http://java.sun.com/jsf/facelets"
    xmlns:f="http://java.sun.com/jsf/core"
    xmlns:tr="http://myfaces.apache.org/trinidad">
    
    <ui:composition template="WEB-INF/facelets/template.jsp">
        <ui:define name="body">
            
            <tr:panelBox background="medium" text="Java Logging Administration">
                
                <tr:panelHorizontalLayout
                    valign="top"
                    halign="left">
                    <tr:table
                        rowBandingInterval="1"
                        emptyText="No Loggers Found"
                        rows="10"
                        value="#{JavaLoggingAdmin.knownLoggers}"
                        var="var">
                        <f:facet name="header">
                            <tr:outputText
                                value="Known Loggers"/>
                        </f:facet>
                        <tr:column
                            headerText="Logger">
                            <tr:outputText
                                value="#{var.name}"/>
                        </tr:column>
                                  
                        <tr:column
                            headerText="Level">
                            <tr:selectOneChoice
                                value="#{var.level}">
                                <f:selectItems value="#{JavaLoggingAdmin.levels}"/>
                            </tr:selectOneChoice>
                        </tr:column>
                        <tr:column>
                            <tr:commandLink
                                blocking="true"
                                text="Update Level"
                                action="#{var.updateLevel}"/>
                        </tr:column>
                    </tr:table>
                    
                    <tr:spacer height="10" width="10"/>
                    
                    <tr:panelFormLayout>
                        <tr:inputText
                            label="Logger"
                            value="#{JavaLoggingAdmin.workingLoggerName}"/>
                        
                        <tr:inputText
                            readOnly="true"
                            label="Current Level"
                            value="#{JavaLoggingAdmin.workingLoggerCurrentLevel}"/>
                            
                        <tr:selectOneChoice
                            label="New Level"
                            value="#{JavaLoggingAdmin.workingLoggerNewLevel}">
                            <f:selectItems value="#{JavaLoggingAdmin.levels}"/>
                        </tr:selectOneChoice>
                        <tr:panelLabelAndMessage>
                            <tr:commandButton
                                blocking="true"
                                text="Update Level"
                                action="#{JavaLoggingAdmin.updateWorkingLoggerLevel}"/>
                        </tr:panelLabelAndMessage>
                    </tr:panelFormLayout>
                </tr:panelHorizontalLayout>
                
            </tr:panelBox>  
            
        </ui:define>
    </ui:composition>
    
</jsp:root>