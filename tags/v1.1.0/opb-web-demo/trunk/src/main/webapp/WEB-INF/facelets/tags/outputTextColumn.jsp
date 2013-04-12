<?xml version="1.0" encoding="iso-8859-1" standalone="yes" ?>
<jsp:root 
    xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
    xmlns:ui="http://java.sun.com/jsf/facelets"
    xmlns:f="http://java.sun.com/jsf/core"
    xmlns:tr="http://myfaces.apache.org/trinidad">
    <ui:composition>
        <tr:column headerText="#{headerText}" shortDesc="#{shortDesc}">
            <tr:outputText value="#{value}"/>
        </tr:column>
    </ui:composition>
</jsp:root>