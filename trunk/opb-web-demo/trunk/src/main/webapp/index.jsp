<?xml version="1.0" encoding="iso-8859-1" standalone="yes" ?>
<jsp:root 
    xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
    xmlns:ui="http://java.sun.com/jsf/facelets"
    xmlns:f="http://java.sun.com/jsf/core"
    xmlns:tr="http://myfaces.apache.org/trinidad">
    
<ui:composition template="WEB-INF/facelets/template.jsp">
    <ui:define name="body">

<tr:panelBox text="Opb web demo index page" >
    <tr:panelFormLayout>
        <tr:commandLink action="dbLoggingAdmin" text="Database Logging Admin"/>
        <tr:commandLink action="javaLoggingAdmin" text="Java Logging Admin"/>
        <tr:commandLink action="dbMessageAdmin" text="Database Message Admin"/>
        <tr:commandLink action="permissionsAdmin" text="Permissions Admin"/>
        <tr:commandLink action="timingAdmin" text="Timing Admin"/>
        <tr:commandLink action="propertiesAdmin" text="Properties Admin"/>
        <tr:commandLink action="exceptionDemo" text="Exception Demo"/>
    </tr:panelFormLayout>
</tr:panelBox>

    </ui:define>
</ui:composition>
  
</jsp:root>