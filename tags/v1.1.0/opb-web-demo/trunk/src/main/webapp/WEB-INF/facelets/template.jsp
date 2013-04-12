<?xml version="1.0" encoding="iso-8859-1" standalone="yes" ?>
<jsp:root 
    xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
    xmlns:ui="http://java.sun.com/jsf/facelets"
    xmlns:f="http://java.sun.com/jsf/core"
    xmlns:tr="http://myfaces.apache.org/trinidad"
    xmlns:trh="http://myfaces.apache.org/trinidad/html">
<f:view>
    <tr:document id="templateDocument" title="Opb web demo" onload="bodyLoadProcedures()">
        <trh:script source="/scripts/global.js"/>
        <tr:form id="templateForm">
            <tr:panelGroupLayout layout="vertical">
                <tr:panelGroupLayout layout="horizontal">
                    <tr:commandButton textAndAccessKey="&amp;reload"/>
                    <tr:spacer height="10" width="10"/>

                    <tr:commandButton 
                        text="clear Opb session" 
                        action="#{Template.clearOpbSessionState}"/>
                    <tr:spacer height="10" width="10"/>

                    <tr:commandButton textAndAccessKey="&amp;index" action="index"/>
                    <tr:spacer height="10" width="10"/>

                    <tr:goButton 
                        text="Go http://localhost:8080/opb-web-demo/" 
                        destination="http://localhost:8080/opb-web-demo"/>

                </tr:panelGroupLayout>
                
                <tr:spacer id="globalMessagesSpacer" height="1"/>

                <ui:insert name="body">Default Body</ui:insert>

                <tr:messages 
                    inlineStyle="position:relative;"
                    id="globalMessages"
                    shortDesc="#{Template.sessionMessages}" />

            </tr:panelGroupLayout>

        </tr:form>
    </tr:document>
</f:view>
</jsp:root>