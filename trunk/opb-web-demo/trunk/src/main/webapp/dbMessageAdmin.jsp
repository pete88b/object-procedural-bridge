<?xml version="1.0" encoding="iso-8859-1" standalone="yes" ?>
<jsp:root 
    xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
    xmlns:demo="http://butterfill.com/opb/webdemo/jsf"
    xmlns:ui="http://java.sun.com/jsf/facelets"
    xmlns:f="http://java.sun.com/jsf/core"
    xmlns:tr="http://myfaces.apache.org/trinidad">
    
<ui:composition template="WEB-INF/facelets/template.jsp">
    <ui:define name="body">

<tr:panelBox background="medium" text="Database Message Administration">
    
    <tr:panelHorizontalLayout valign="top" halign="left">

        <tr:table 
            value="#{DbMessageAdmin.messages.allContextMessages}"
            emptyText="No Messages Found" 
            var="var">
            <f:facet name="header">
                <tr:outputText value="Current Messages"/>
            </f:facet>
            <tr:column headerText="Level">
                <tr:outputText value="#{var.messageLevel}"/>
            </tr:column>

            <tr:column headerText="Detail">
                <tr:outputText value="#{var.messageDetail}"/>
            </tr:column>

            <tr:column headerText="Summary">
                <tr:outputText value="#{var.messageSummary}"/>
            </tr:column>

            <tr:column headerText="">
                <tr:commandLink
                    blocking="true"
                    text="Delete"
                    action="#{var.deleteMessage}"/>
            </tr:column>
        </tr:table>

        <tr:spacer height="10" width="10"/>

        <tr:panelBox 
            background="medium"
            text="Add a message for all users">
            <tr:panelFormLayout>
                <tr:selectOneChoice 
                    label="Level"
                    value="#{DbMessageAdmin.messages.messageLevel}">
                    <f:selectItems value="#{ToSelectItemList[DbMessageAdmin.messages.messageLevels]}"/>
                </tr:selectOneChoice>
                <tr:inputText
                    value="#{DbMessageAdmin.messages.messageSummary}"
                    label="Summary"/>
                <tr:inputText
                    value="#{DbMessageAdmin.messages.messageDetail}"
                    label="Detail"/>
                <tr:panelLabelAndMessage>
                    <tr:commandButton
                        blocking="true"
                        accessKey="A"
                        action="#{DbMessageAdmin.messages.addAllContextMessage}"
                        text="Add Message"/>
                </tr:panelLabelAndMessage>
                <tr:panelLabelAndMessage>
                    <tr:commandLink
                        accessKey="C"
                        blocking="true"
                        action="#{DbMessageAdmin.messages.opbClearState}"
                        text="Clear Form "/>
                </tr:panelLabelAndMessage>
            </tr:panelFormLayout>
        </tr:panelBox>
            
    </tr:panelHorizontalLayout>	

</tr:panelBox>  



    </ui:define>
</ui:composition>
    
</jsp:root>