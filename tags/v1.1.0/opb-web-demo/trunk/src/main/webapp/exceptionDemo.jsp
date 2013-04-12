<?xml version="1.0" encoding="iso-8859-1" standalone="yes" ?>
<jsp:root
    xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
    xmlns:ui="http://java.sun.com/jsf/facelets"
    xmlns:f="http://java.sun.com/jsf/core"
    xmlns:tr="http://myfaces.apache.org/trinidad">
    
<ui:composition template="WEB-INF/facelets/template.jsp">
    <ui:define name="body">
        
<tr:panelBox background="medium" text="Exception Demonstration">
    <tr:panelFormLayout>
        <tr:panelLabelAndMessage 
            label="Call ...webdemo.data.ExceptionDemo#raiseNoDataFound">
            <tr:commandButton
                text="RAISE NO_DATA_FOUND"
                action="#{ExceptionDemo.exceptionDemo.raiseNoDataFound}"/>
        </tr:panelLabelAndMessage>
        <tr:panelLabelAndMessage 
            label="Call ...webdemo.data.ExceptionDemo#raiseNoDataFound (partial submit)">
            <tr:commandButton
                partialSubmit="true"
                text="RAISE NO_DATA_FOUND PPR"
                action="#{ExceptionDemo.exceptionDemo.raiseNoDataFound}"/>
        </tr:panelLabelAndMessage>
        
        <tr:spacer height="10"/>
        
        <tr:inputText 
            label="Exception Message"
            value="#{ExceptionDemo.exceptionMessage}"/>
        
        <tr:panelLabelAndMessage 
            label="Throw a runtime exception with the above message">
            <tr:commandButton
                text="Throw RuntimeException"
                action="#{ExceptionDemo.throwException}"/>
        </tr:panelLabelAndMessage>
        
        <tr:panelLabelAndMessage 
            label="Throw a runtime exception with the above message (partial submit)">
            <tr:commandButton
                partialSubmit="true"
                text="throw RuntimeException PPR"
                action="#{ExceptionDemo.throwException}"/>
        </tr:panelLabelAndMessage>
    </tr:panelFormLayout>
</tr:panelBox>

    </ui:define>
</ui:composition>

</jsp:root>