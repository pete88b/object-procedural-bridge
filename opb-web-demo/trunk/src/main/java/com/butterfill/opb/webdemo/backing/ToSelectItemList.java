package com.butterfill.opb.webdemo.backing;

import com.butterfill.opb.util.OpbExceptionHelper;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.model.SelectItem;

/**
 * Converts a list of objects into select items.
 * This has been implemented as a Map so that can be used by JSF pages.
 * See also dbMessageAdmin.jsp.
 * 
 */
public class ToSelectItemList implements Map<List, List<SelectItem>> {
    
    /**
     * The name of this class.
     */
    public static final String CLASS_NAME = ToSelectItemList.class.getName();
    
    /**
     * The logger of this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    /** 
     * Creates a new instance of SelectItemHelper 
     */
    public ToSelectItemList() {
        logger.entering(CLASS_NAME, "ToSelectItemList()");
    }

    /**
     * Throws an UnsupportedOperationException.
     */
    public int size() {
        throw new UnsupportedOperationException("Not supported.");
    }

    /**
     * Throws an UnsupportedOperationException.
     */
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported.");
    }

    /**
     * Throws an UnsupportedOperationException.
     */
    public boolean containsKey(Object key) {
        throw new UnsupportedOperationException("Not supported.");
    }

    /**
     * Throws an UnsupportedOperationException.
     */
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("Not supported.");
    }

    /**
     * Converts o to a select item.
     * <ul>
     * <li>If o is null, return null</li>
     * <li>If o is a select item, return it</li>
     * <li>If o is a Map, return a select item created from from it's 
     *      "value" and "label" properties</li>
     * <li>Otherwise return a select item created from the values returned by the o's
     *      getValue and getLabel methods.</li>
     * </ul>
     * @param o The object to convert.
     * @return A select item.
     */
    private SelectItem toSelectItem(final Object o) {
        final String methodName = "toSelectItem(Object)";
        
        logger.entering(CLASS_NAME, methodName);
        
        if (o == null) {
            return null;
        }
        
        if (o instanceof SelectItem) {
            return (SelectItem) o;
        }
        
        Object value = null;
        String label = null;
        
        if (o instanceof Map) {
            logger.finer("found a Map");
            
            Map map = (Map) o;
            value = map.get("value");
            label = (String) map.get("label");
            if (label == null &&
                    value != null) {
                label = value.toString();
            }
            
        } else {
            Class classOfO = o.getClass();
            Method getValueMethod;
            try {
                getValueMethod = classOfO.getDeclaredMethod("getValue");
                
            } catch (Exception ex) {
                throw OpbExceptionHelper.throwException(
                        new RuntimeException(
                        "Failed to get getValue method from a " + 
                        classOfO.getName(), ex), 
                        logger, CLASS_NAME, methodName);
                
            }
            
            Method getLabelMethod = null;
            try {
                getLabelMethod = classOfO.getDeclaredMethod("getLabel");
                
            } catch (Exception ex) {
                logger.logp(Level.FINER, CLASS_NAME, methodName, 
                        "failed to get getLabel method from a " +
                        classOfO.getName(), ex);
                getLabelMethod = getValueMethod;
                
            }
            
            try {
                value = getValueMethod.invoke(o);
                
            } catch (Exception ex) {
                throw OpbExceptionHelper.throwException(
                        new RuntimeException("failed to get value", ex), 
                        logger, CLASS_NAME, methodName);
                
            }
            
            try {
                label = (String)getLabelMethod.invoke(o);
                
            } catch (Exception ex) {
                throw OpbExceptionHelper.throwException(
                        new RuntimeException("failed to get label", ex), 
                        logger, CLASS_NAME, methodName);
                
            }
                
        }
        
        String valueClassName = (value == null) ? "" : value.getClass().getName();
        String labelClassName = (label == null) ? "" : label.getClass().getName();
        
        logger.logp(Level.FINEST, CLASS_NAME, methodName, 
                "returning SelectItem({0}, {1}) ({2}, {3})",
                new Object[]{value, label, valueClassName, labelClassName});
        
        return new SelectItem(value, label);

    } // End of toSelectItem(Object)
    
    /**
     * Returns a list of select items created from the values of key.
     * If key is not a collection a warning is logged and an empty list is returned.
     * Each element of the collection is converted to a select item using the following rules:
     * <ul>
     * <li>If the element is null, null is added to the result</li>
     * <li>If the element is a select item, it is added to the result</li>
     * <li>If the element is a Map, we create a select item from it's 
     *      "value" and "label" properties</li>
     * <li>Otherwise we create a select item from the values returned by the objects 
     *      getValue and getLabel methods.</li>
     * </ul>
     * @param key A collection to convert to select items.
     * @return A list of select items.
     */
    public List<SelectItem> get(final Object key) {
        String methodName = "get(Object)";
        
        logger.entering(CLASS_NAME, methodName);
        
        List<SelectItem> result = new ArrayList<SelectItem>();
        
        if (!(key instanceof Collection)) {
            logger.logp(Level.WARNING, CLASS_NAME, methodName,
                    "key is not a Collection. returning empty SelectItem list");
            return result;
        }
        
        Collection collection = (Collection) key;
        
        if (collection.isEmpty()) {
            logger.logp(Level.FINER, CLASS_NAME, methodName,
                    "key is an empty Collection. returning empty SelectItem list");
            return result;
        }
        
        logger.logp(Level.FINEST, CLASS_NAME, methodName,
                "key is a non-empty Collection. converting elements to SelectItems");
        
        for (Object o : collection) {
            SelectItem selectItem = toSelectItem(o);
            if (selectItem != null) {
                result.add(selectItem);
            }
        }
        
        return result;
        
    }

    /**
     * Throws an UnsupportedOperationException.
     */
    public List<SelectItem> put(List key, List<SelectItem> value) {
        throw new UnsupportedOperationException("Not supported.");
    }

    /**
     * Throws an UnsupportedOperationException.
     */
    public List<SelectItem> remove(Object key) {
        throw new UnsupportedOperationException("Not supported.");
    }

    /**
     * Throws an UnsupportedOperationException.
     */
    public void putAll(Map<? extends List, ? extends List<SelectItem>> t) {
        throw new UnsupportedOperationException("Not supported.");
    }

    /**
     * Throws an UnsupportedOperationException.
     */
    public void clear() {
        throw new UnsupportedOperationException("Not supported.");
    }

    /**
     * Throws an UnsupportedOperationException.
     */
    public Set<List> keySet() {
        throw new UnsupportedOperationException("Not supported.");
    }

    /**
     * Throws an UnsupportedOperationException.
     */
    public Collection<List<SelectItem>> values() {
        throw new UnsupportedOperationException("Not supported.");
    }

    /**
     * Throws an UnsupportedOperationException.
     */
    public Set<Entry<List, List<SelectItem>>> entrySet() {
        throw new UnsupportedOperationException("Not supported.");
    }

}
