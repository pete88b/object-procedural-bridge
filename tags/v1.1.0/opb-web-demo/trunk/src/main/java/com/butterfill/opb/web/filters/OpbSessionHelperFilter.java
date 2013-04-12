
package com.butterfill.opb.web.filters;

import com.butterfill.opb.session.OpbSession;
import com.butterfill.opb.session.OpbSessionHelper;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Saves the OpbSession of the current HTTP session in the OpbSessionHelper,
 * synchronises access to the OpbSession and releases the OpbSession 
 * connection when the request is complete.
 */
public class OpbSessionHelperFilter implements Filter {
    
    /**
     * The name of this class.
     */
    public static final String CLASS_NAME = 
            OpbSessionHelperFilter.class.getName();

    /**
     * The logger of this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);
    
    
    /**
     * Does nothing.
     */
    public void destroy() {
    }

    /**
     * Saves the OpbSession of the current HTTP session in the OpbSessionHelper,
     * synchronises access to the OpbSession and releases the OpbSession 
     * connection when the request is complete.
     * <br/>
     * This filter should be configured as the first filter in the chain.
     * This is so that all code called during HTTP request processing will work
     * with the correct OpbSession via OpbSessionHelper methods.
     * <br/>
     * The synchronisation of this filter ensures that no more than one thread
     * (HTTP request) will be processed concurrently for an HTTP session.
     * <br/>
     * If the response is a redirect, temporary session data in the database
     * will not be cleared.
     * 
     * @param request 
     *   The request being processed.
     * @param response 
     *   The response to the request.
     * @param chain 
     *   The filter chain.
     * @throws IOException
     *   If calling doFilter on the chain throws an IOException.
     * @throws ServletException
     *   If calling doFilter on the chain throws a ServletException.
     */
    public void doFilter(final ServletRequest request, final ServletResponse response,
            final FilterChain chain) 
            throws IOException, ServletException {
        final String methodName = 
                "doFilter(ServletRequest, ServletResponse, FilterChain)";

        logger.entering(CLASS_NAME, methodName);

        // get the http session
        HttpSession session = ((HttpServletRequest) request).getSession();

        // Allow only one request for a session to be processed.
        // This is important to ensure that multiple threads so not access the 
        // shared database connection saved in the OpbSession
        synchronized (session) {
            // get the Opb session
            OpbSession opbSession = 
                    (OpbSession) session.getAttribute("opbSession");

            // save this session in the OpbSessionHelper 
            OpbSessionHelper.setSession(opbSession);

            try {
                // process the request
                chain.doFilter(request, response);

            } finally {
                // always try to release the connection
                try {
                    // If we know user is being re-directed, do not clear the
                    // temporary session data. e.g. DB messages for this session
                    OpbSessionHelper.getSession().releaseConnection(
                            request.getAttribute("Redirect:trueIfNotNull") == null);

                } catch (Exception ex) {
                    logger.logp(Level.WARNING, CLASS_NAME, methodName,
                            "failed to release connection", ex);

                } finally {
                    // always clear the session saved by the OpbSessionHelper
                    OpbSessionHelper.setSession(null);

                }

            } // End of try chain.doFilter(...

        } // End of synchronized (session)

    } // End of doFilter(ServletRequest, ServletResponse, FilterChain)

    /**
     * Does nothing.
     */
    public void init(final FilterConfig filterConfig) throws ServletException {
    }
    
}
