package com.butterfill.opb.webdemo;


/**
 *
 * @author butterp
 */
public class JsfHelper {

    /**
     * Add a fatal message to the Faces context.
     * 
     * @param detail The detailed message string.
     * @param summary The summarised message string.
     */
    public static void facesFatalMessage(String detail, String summary) {
//        FacesContext.getCurrentInstance().addMessage(null,
//                new FacesMessage(FacesMessage.SEVERITY_FATAL, detail, summary));
    }

    /**
     * Add an error message to the Faces context.
     * 
     * @param detail The detailed message string.
     * @param summary The summarised message string.
     */
    public static void facesErrorMessage(String detail, String summary) {
//        FacesContext.getCurrentInstance().addMessage(null,
//                new FacesMessage(FacesMessage.SEVERITY_ERROR, detail, summary));
    }

    /**
     * Add a warning message to the Faces context.
     * 
     * @param detail The detailed message string.
     * @param summary The summarised message string.
     */
    public static void facesWarningMessage(String detail, String summary) {
//        FacesContext.getCurrentInstance().addMessage(null,
//                new FacesMessage(FacesMessage.SEVERITY_WARN, detail, summary));
    }

    /**
     * Add an info message to the Faces context.
     * 
     * @param detail The detailed message string.
     * @param summary The summarised message string.
     */
    public static void facesInfoMessage(String detail, String summary) {
//        FacesContext.getCurrentInstance().addMessage(null,
//                new FacesMessage(FacesMessage.SEVERITY_INFO, detail, summary));
    }
    
}
